package org.hellscrum.manejador;

import org.hellscrum.bean.*;
import org.hellscrum.detalle.*;
import org.hellscrum.db.Conexion;
import org.hellscrum.db.ConexionWitoutHibernate;
import org.hellscrum.detalle.Equips;
import org.hellscrum.detalle.detalleEquipo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;


public class Manejador {
	private ArrayList<UsuarioD> UserList = new ArrayList<UsuarioD>();
	private ArrayList<rol> RolList = new ArrayList<rol>();
	private ArrayList<Equips> ListaEquipo = new ArrayList<Equips>();
	private ArrayList<ProyectoD> ListaProyecto = new ArrayList<ProyectoD>();
	private ArrayList<FaseD> ListaFase = new ArrayList<FaseD>();
	private ArrayList<MetaD> ListaMeta = new ArrayList<MetaD>();
	private ArrayList<ReunionD> ListaReunion  = new ArrayList<ReunionD>();
	private ArrayList<MensajeD> ListaMensaje = new ArrayList<MensajeD>();
	
	private Manejador(){}
	private usuario UsuarioAutenticado; 
	public static Manejador instancia=null;
	
	public static Manejador getInstancia(){
		if (instancia==null){
			instancia=new Manejador();
		}
		return instancia;		
	}
	
	public void autenticarUsuario(String nick,String password){
		if (nick != null && password != null){
			try{
				usuario user = Conexion.getInstancia().autenticarUsuario(nick,password);
					UsuarioAutenticado= user;
				
			}catch(Exception e){
				
			}
			
		}
		
	}
	
	
	public boolean getUsuarioAutenticado(){
		if(UsuarioAutenticado == null){
			return false;
		}
		return true;
	}
	
	
	public ArrayList<UsuarioD> listaUsuario(){
		UserList.clear();
		for(Object obj:Conexion.getInstancia().hacerConsulta("From usuario")){
				usuario usr = (usuario)obj;
				rol rl= null;
				rl=(rol)Conexion.getInstancia().hacerConsulta("From rol u where u.idRol ="+usr.getIdRol()).get(0);
			UserList.add(new UsuarioD(usr.getIdUsuario(),usr.getNombre(),usr.getApellido(),usr.getNickname(),usr.getContrasena(),rl.getNombre()));
		}
		return UserList;
	}
	
	public ArrayList<MetaD> listaMetas(){
		ListaMeta.clear();
		for(Object obj:Conexion.getInstancia().hacerConsulta("From meta")){
			meta mt=(meta)obj;
			fase fs= null;
			fs=(fase)Conexion.getInstancia().hacerConsulta("From fase u where u.idfase ="+ mt.getIdfase()).get(0); 
						
			ListaMeta.add(new MetaD(mt.getIdmeta(),mt.getDescripcion(),mt.isEstado(),fs.getNombre()));
		}
		return ListaMeta;
	}
	
	public ArrayList<ReunionD> listaReunion(){
		ListaReunion.clear();
		for(Object obj:Conexion.getInstancia().hacerConsulta("From reunion")){
			reunion rn=(reunion)obj;
			equipo eq=(equipo)Conexion.getInstancia().hacerConsulta("From equipo u where u.idequipo ="+rn.getIdequipo()).get(0);
			ListaReunion.add(new ReunionD(rn.idreunion,rn.getFecha(),rn.getHora(),eq.getNombre()));
		}
		return ListaReunion;
	}
	
	public ArrayList<MensajeD> listaMensaje(){
		ListaMensaje.clear();
		//Integer idmensaje, String equipo, String fecha, String texto
		for(Object obj:Conexion.getInstancia().hacerConsulta("From mensaje")){
			mensaje mn=(mensaje)obj;
			reunion rn=(reunion)Conexion.getInstancia().hacerConsulta("From reunion u where u.idreunion="+mn.getIdreunion()).get(0);
			equipo eq=(equipo)Conexion.getInstancia().hacerConsulta("From equipo u where u.idequipo ="+rn.getIdequipo()).get(0);
			ListaMensaje.add(new MensajeD(mn.getIdmensaje(),eq.getNombre(),rn.getFecha(),mn.getTexto()));
		}	
		return ListaMensaje;
	}
	
	public ArrayList<rol> listaRol(){
		RolList.clear();
		for(Object obj:Conexion.getInstancia().hacerConsulta("From rol")){
			
			
			rol rl = (rol)obj;
			RolList.add(rl);
			
		}
		return RolList;
	}
	
	public ArrayList<FaseD> listaFase(){
		ListaFase.clear();
		for(Object obj:Conexion.getInstancia().hacerConsulta("From fase")){
			fase fs =(fase)obj;
			ArrayList<meta> listaMetas= new ArrayList<meta>();
			for(Object obje:Conexion.getInstancia().hacerConsulta("From meta u where u.idfase="+fs.getIdfase())){
				meta mt=(meta)obje;
				listaMetas.add(mt);
			}
			proyecto pro=null;
			pro=(proyecto)Conexion.getInstancia().hacerConsulta("From proyecto u where u.idproyecto ="+ fs.getIdproyecto()).get(0);
			
			
			ListaFase.add(new FaseD(fs.getIdfase(),fs.getNombre(),listaMetas,fs.getFechainicio(),fs.fechafinalizacion,pro.getNombre()));
		}
		return ListaFase;
	}
	
	public ArrayList<Equips> listaEquipo(){
		ListaEquipo.clear();


		for(Object obj:Conexion.getInstancia().hacerConsulta("From equipo")){
			equipo eq=(equipo)obj;
			ArrayList<detalleEquipo> detalle = new ArrayList<detalleEquipo>();
			
			ResultSet resultado=ConexionWitoutHibernate.getInstancia().obtenerConsulta(""+
					"select Equipo.idEquipo as id, Usuario.nombre as Usuario, Equipo.nombre as Equipo, rol.nombre as Rol From Usuario "+
					"	INNER JOIN Usuario_equipo on Usuario_Equipo.idUsuario = Usuario.idUsuario"+
					"	INNER JOIN equipo on Usuario_Equipo.idEquipo = Equipo.idEquipo"+
					"	INNER JOIN Rol on Usuario_Equipo.idRol = Rol.idRol where Equipo.idEquipo = "+eq.getIdequipo());
							try {
								while (resultado.next()) {
									detalle.add(new detalleEquipo(resultado.getString("Usuario"),resultado.getString("Rol")));
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						
			ArrayList<proyecto> proyectlist= new ArrayList<proyecto>();
			for(Object objt:Conexion.getInstancia().hacerConsulta("From proyecto u where u.idequipo ="+ eq.getIdequipo())){
				proyecto pr =(proyecto)objt;
				proyectlist.add(pr);
			}				
			ListaEquipo.add(new Equips(eq.getIdequipo(),proyectlist,detalle,eq.getNombre()));

			
		}
		return ListaEquipo;
	}

		
	public void desAutenticarUsuario(){
		UsuarioAutenticado = new usuario();
	}
	
	public ArrayList<ProyectoD> listaProyecto(){
		ListaProyecto.clear();
		for(Object obj:Conexion.getInstancia().hacerConsulta("From proyecto")){
			proyecto pr=(proyecto)obj;
			ArrayList<fase> listafase= new ArrayList<fase>();
			System.out.println(pr.getIdproyecto());
			for(Object obje:Conexion.getInstancia().hacerConsulta("From fase u where u.idproyecto = "+ pr.getIdproyecto())){
				fase fs=(fase)obje;
				listafase.add(fs);
				System.out.println(fs.getNombre());
			}
			
			ListaProyecto.add(new ProyectoD(pr.getIdproyecto(),pr.getNombre(),pr.getFechacreacion(),pr.getIdequipo(),listafase));
		}
		return ListaProyecto;
	}
}
