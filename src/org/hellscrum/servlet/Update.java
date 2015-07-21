package org.hellscrum.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hellscrum.manejador.Manejador;

public class Update extends HttpServlet{
	public void doGet(HttpServletRequest peticion,HttpServletResponse respuesta)throws IOException,ServletException{
		doPost(peticion,respuesta);
	}
	public void doPost(HttpServletRequest peticion,HttpServletResponse respuesta)throws IOException,ServletException{
		RequestDispatcher despachador=null;
		
		if(Manejador.getInstancia().getUsuarioAutenticado()){
			String go = peticion.getParameter("go");
			if ( go.equals("1")){

				String id= peticion.getParameter("id");
				String nombre = peticion.getParameter("nombre");
				Manejador.getInstancia().UpdateRol(id,nombre);
				peticion.setAttribute("listadoRol", Manejador.getInstancia().listaRol());
				despachador=peticion.getRequestDispatcher("rol.jsp");				
			}else if(go.equals("2")){
				String id=peticion.getParameter("id");
				String nombre=peticion.getParameter("nombre");
				String apellido=peticion.getParameter("apellido");
				String nick=peticion.getParameter("nick");
				String password=peticion.getParameter("password");
				Manejador.getInstancia().UpdateUsuario(id,nombre,apellido,nick,password);
				peticion.setAttribute("listaUsuario", Manejador.getInstancia().listaUsuario());				
				despachador=peticion.getRequestDispatcher("usuario.jsp");				
			}else if(go.equals("3")){
				String id=peticion.getParameter("id");
				String nombre=peticion.getParameter("nombre");
				Manejador.getInstancia().UpdateEquipo(id,nombre);
				peticion.setAttribute("listaEquipo", Manejador.getInstancia().listaEquipo());					
				despachador=peticion.getRequestDispatcher("equipo.jsp");				
			}else if(go.equals("4")){
				String id=peticion.getParameter("id");
				String nombre=peticion.getParameter("nombre");
				Manejador.getInstancia().UpdateProyecto(id,nombre);				
				peticion.setAttribute("listadoProyecto", Manejador.getInstancia().listaProyecto());						
				despachador=peticion.getRequestDispatcher("proyecto.jsp");
			}else if(go.equals("5")){
				String id=peticion.getParameter("id");
				String nombre=peticion.getParameter("nombre");
				Manejador.getInstancia().UpdateFase(id,nombre);				
			
				peticion.setAttribute("listadoFase", Manejador.getInstancia().listaFase());
				despachador=peticion.getRequestDispatcher("fase.jsp");
			}else if(go.equals("6")){
				String id=peticion.getParameter("id");
				String nombre=peticion.getParameter("descripcion");
				Manejador.getInstancia().UpdateMeta(id,nombre);				
			
				peticion.setAttribute("listaMeta", Manejador.getInstancia().listaMetas());
				despachador=peticion.getRequestDispatcher("meta.jsp");
			}else if(go.equals("8")){
				String id=peticion.getParameter("id");
				String nombre=peticion.getParameter("texto");
				Manejador.getInstancia().UpdateMensaje(id,nombre);				
			
				
				peticion.setAttribute("listaMensaje", Manejador.getInstancia().listaMensaje());
				despachador=peticion.getRequestDispatcher("mensaje.jsp");				
			}else{
				despachador=peticion.getRequestDispatcher("index.jsp");
			}
		
		}else{
			despachador=peticion.getRequestDispatcher("login.jsp");
		}
		despachador.forward(peticion,respuesta);
	}
}