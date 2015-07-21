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
	
	public usuario getUsuario(String id){
		usuario usu=(usuario)Conexion.getInstancia().hacerConsulta("From usuario where idUsuario = "+id).get(0);
		
		return usu;
	}
	
	public equipo getEquipo(String id){
		equipo equip = (equipo)Conexion.getInstancia().hacerConsulta("From equipo where idequipo = "+id).get(0);
		return equip;
	}
	
	public proyecto getProyeco(String id){
		proyecto pr=(proyecto)Conexion.getInstancia().hacerConsulta("From proyecto where idproyecto = "+id).get(0);
		return pr;
	}
	
	public fase getFase(String id){
		fase fs= (fase)Conexion.getInstancia().hacerConsulta("From fase where idfase="+id).get(0);
		return fs;		
	}
	
	public meta getMeta(String id){
		meta mt= (meta)Conexion.getInstancia().hacerConsulta("From meta where idmeta="+id).get(0);
		return mt;
	}
	
	public mensaje getMensaje(String id){
		mensaje msg = (mensaje)Conexion.getInstancia().hacerConsulta("From mensaje where idmensaje="+id).get(0);
		return msg;
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
			UserList.add(new UsuarioD(usr.getIdUsuario(),usr.getNombre(),usr.getApellido(),usr.getNickname(),usr.getContrasena(),rl.getNombre(),usr.getIdRol()));
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
			
			
			ArrayList<proyecto> proyectlist= new ArrayList<proyecto>();
			for(Object objt:Conexion.getInstancia().hacerConsulta("From proyecto u where u.idequipo ="+ eq.getIdequipo())){
				proyecto pr =(proyecto)objt;
				proyectlist.add(pr);
			}				
			ListaEquipo.add(new Equips(eq.getIdequipo(),proyectlist,detalle,eq.getNombre(),eq.getMykey()));

			
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
	
	public void UpdateRol(String id,String nombre){
		rol rl=(rol)Conexion.getInstancia().hacerConsulta("From rol where idrol = "+id).get(0);
		rl.setNombre(nombre);
		Conexion.getInstancia().modificar(rl);
	}
	
	public void CreateUsuario(String nombre, String apellido, String nick, String contrasena){
		usuario usu = new usuario();
		int id=0;
		for(Object obj:Conexion.getInstancia().hacerConsulta("From usuario")){
			usuario user = (usuario)obj;
			if(user.getIdUsuario() > id){
				id = user.getIdUsuario();
			}
		}
		id++;
		usu.setIdUsuario(id);
		usu.setNombre(nombre);
		usu.setApellido(apellido);
		usu.setNickname(nick);
		usu.setContrasena(contrasena);
		usu.setIdRol(1);
		Conexion.getInstancia().agregar(usu);
	}
	
	public void UpdateUsuario(String id,String nombre, String apellido, String nick, String contrasena){
		usuario usu = (usuario)Conexion.getInstancia().hacerConsulta("From usuario where idusuario = "+id).get(0);
		usu.setNombre(nombre);
		usu.setApellido(apellido);
		usu.setNickname(nick);
		usu.setContrasena(contrasena);
		Conexion.getInstancia().modificar(usu);
	}
	
	public void UpdateEquipo(String id, String nombre){
		equipo eq = (equipo)Conexion.getInstancia().hacerConsulta("From equipo where idequipo="+id).get(0);
		eq.setNombre(nombre);
		Conexion.getInstancia().modificar(eq);
	}
	
	public void UpdateProyecto(String id,String nombre){
		proyecto pr = (proyecto)Conexion.getInstancia().hacerConsulta("From proyecto where idproyecto="+id).get(0);
		pr.setNombre(nombre);
		Conexion.getInstancia().modificar(pr);
	}
	
	public void UpdateFase(String id,String nombre){
		fase fs = (fase)Conexion.getInstancia().hacerConsulta("From fase where idfase="+id).get(0);
		fs.setNombre(nombre);
		Conexion.getInstancia().modificar(fs);
	}
	
	public void UpdateMeta(String id,String descripcion){
		meta mt= (meta)Conexion.getInstancia().hacerConsulta("From meta where idmeta="+id).get(0);
		mt.setDescripcion(descripcion);
		Conexion.getInstancia().modificar(mt);
	}
	
	public void UpdateMensaje(String id,String texto){
		mensaje msg=(mensaje)Conexion.getInstancia().hacerConsulta("From mensaje where idmensaje="+id).get(0);
		msg.setTexto(texto);
		Conexion.getInstancia().modificar(msg);
	}
}
