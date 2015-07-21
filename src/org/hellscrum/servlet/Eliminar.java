package org.hellscrum.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hellscrum.manejador.Manejador;
import org.hellscrum.bean.*;
import org.hellscrum.db.Conexion;
import org.hellscrum.db.ConexionWitoutHibernate;

public class Eliminar extends HttpServlet{
	public void doGet(HttpServletRequest peticion,HttpServletResponse respuesta)throws IOException,ServletException{
		doPost(peticion,respuesta);
	}
	public void doPost(HttpServletRequest peticion,HttpServletResponse respuesta)throws IOException,ServletException{
		RequestDispatcher despachador=null;		
		
		if(Manejador.getInstancia().getUsuarioAutenticado()){

			String go = peticion.getParameter("go");
			String id = peticion.getParameter("id");
			
			if ( go.equals("1")){
				
				peticion.setAttribute("listadoRol", Manejador.getInstancia().listaRol());
				despachador=peticion.getRequestDispatcher("rol.jsp");				
			}else if(go.equals("2")){
				usuario user=(usuario)Conexion.getInstancia().hacerConsulta("From usuario where idusuario="+id).get(0);
				for(Object obj:Conexion.getInstancia().hacerConsulta("From usuario_equipo where idusuario="+id)){
					usuario_equipo ue = (usuario_equipo)obj;
					Conexion.getInstancia().eliminar(ue);
				}
				Conexion.getInstancia().eliminar(user);
				peticion.setAttribute("listaUsuario", Manejador.getInstancia().listaUsuario());				
				despachador=peticion.getRequestDispatcher("usuario.jsp");				
			}else if(go.equals("3")){
				try{
					equipo eq=(equipo)Conexion.getInstancia().hacerConsulta("From equipo where idequipo="+id).get(0);
					for(Object obj:Conexion.getInstancia().hacerConsulta("From usuario_equipo where idequipo="+id)){
						usuario_equipo ue = (usuario_equipo)obj;
						Conexion.getInstancia().eliminar(ue);
					}
					for(Object opro:Conexion.getInstancia().hacerConsulta("From proyecto where idequipo="+id)){
						proyecto pr=(proyecto)opro;
						for(Object ofs:Conexion.getInstancia().hacerConsulta("From fase where idproyecto="+pr.getIdproyecto())){
							fase fs=(fase)ofs;
							for(Object omt:Conexion.getInstancia().hacerConsulta("From meta where idfase="+fs.getIdfase())){
								meta mt=(meta)omt;
								Conexion.getInstancia().eliminar(mt);
							}
							Conexion.getInstancia().eliminar(fs);
						}
						Conexion.getInstancia().eliminar(pr);
					}
					for(Object oreun:Conexion.getInstancia().hacerConsulta("From reunion where idequipo="+id)){
						reunion rn=(reunion)oreun;
						for(Object omsg:Conexion.getInstancia().hacerConsulta("From mensaje where idreunion="+rn.getIdreunion())){
							mensaje msg=(mensaje)omsg;
							Conexion.getInstancia().eliminar(msg);
						}
						Conexion.getInstancia().eliminar(rn);
					}
					Conexion.getInstancia().eliminar(eq);
				}catch(Exception e){
					
				}
				
					
				peticion.setAttribute("listaEquipo", Manejador.getInstancia().listaEquipo());					
				despachador=peticion.getRequestDispatcher("equipo.jsp");				
			}else if(go.equals("4")){
				try{
					proyecto pr=(proyecto)Conexion.getInstancia().hacerConsulta("From proyecto where idproyecto="+id).get(0);
					for(Object obj:Conexion.getInstancia().hacerConsulta("From fase where idproyecto="+id)){
						fase fs=(fase)obj;
						for(Object ob:Conexion.getInstancia().hacerConsulta("From meta where idfase="+fs.getIdfase())){
							meta mt=(meta)ob;
							Conexion.getInstancia().eliminar(mt);
						}
						Conexion.getInstancia().eliminar(fs);
					}
					Conexion.getInstancia().eliminar(pr);
				}catch(Exception e){
					
				}
				peticion.setAttribute("listadoProyecto", Manejador.getInstancia().listaProyecto());						
				despachador=peticion.getRequestDispatcher("proyecto.jsp");
			}else if(go.equals("5")){
				try{
					fase fs=(fase)Conexion.getInstancia().hacerConsulta("From fase where idfase="+id).get(0);
					for(Object obj:Conexion.getInstancia().hacerConsulta("From meta where idfase="+id)){
						meta mt=(meta)obj;
						Conexion.getInstancia().eliminar(mt);
					}
					Conexion.getInstancia().eliminar(fs);
				}catch(Exception e){
					
				}

				peticion.setAttribute("listadoFase", Manejador.getInstancia().listaFase());
				despachador=peticion.getRequestDispatcher("fase.jsp");
			}else if(go.equals("6")){
				try{
					meta mt=(meta)Conexion.getInstancia().hacerConsulta("From meta where idmeta="+id).get(0);
					Conexion.getInstancia().eliminar(mt);
				}catch(Exception e){
					
				}
				peticion.setAttribute("listaMeta", Manejador.getInstancia().listaMetas());
				despachador=peticion.getRequestDispatcher("meta.jsp");
			}else if(go.equals("7")){
				try{
					reunion rn=(reunion)Conexion.getInstancia().hacerConsulta("From reunion where idreunion="+id).get(0);
					for(Object obj:Conexion.getInstancia().hacerConsulta("From mensaje where idreunion="+id)){
						mensaje msg=(mensaje)obj;
						Conexion.getInstancia().eliminar(msg);
					}
					Conexion.getInstancia().eliminar(rn);
				}catch(Exception e){
					
				}
				
				peticion.setAttribute("listaReunion", Manejador.getInstancia().listaReunion());
				despachador=peticion.getRequestDispatcher("reunion.jsp");		
			}else if(go.equals("8")){
				try{
				mensaje msg=(mensaje)Conexion.getInstancia().hacerConsulta("From mensaje where idmensaje="+id).get(0);
				Conexion.getInstancia().eliminar(msg);
				}catch(Exception e)	{
					
				}
				
				peticion.setAttribute("listaMensaje", Manejador.getInstancia().listaMensaje());
				despachador=peticion.getRequestDispatcher("mensaje.jsp");				
			}else{
				despachador=peticion.getRequestDispatcher("index.jsp");
			}
		}else{
				despachador=peticion.getRequestDispatcher("login.jsp");
			
		}
//			String nick=peticion.getParameter("txtNick");
		despachador.forward(peticion,respuesta);
	}
}
