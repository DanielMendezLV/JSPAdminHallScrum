package org.hellscrum.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hellscrum.manejador.Manejador;


public class Redirect extends HttpServlet{
	public void doGet(HttpServletRequest peticion,HttpServletResponse respuesta)throws IOException,ServletException{
		doPost(peticion,respuesta);
	}
	public void doPost(HttpServletRequest peticion,HttpServletResponse respuesta)throws IOException,ServletException{
		RequestDispatcher despachador=null;		
		
		if(Manejador.getInstancia().getUsuarioAutenticado()){

			String go = peticion.getParameter("go");
			if ( go.equals("1")){
				peticion.setAttribute("listadoRol", Manejador.getInstancia().listaRol());
				despachador=peticion.getRequestDispatcher("rol.jsp");				
			}else if(go.equals("2")){
				peticion.setAttribute("listaUsuario", Manejador.getInstancia().listaUsuario());				
				despachador=peticion.getRequestDispatcher("usuario.jsp");				
			}else if(go.equals("3")){
				peticion.setAttribute("listaEquipo", Manejador.getInstancia().listaEquipo());					
				despachador=peticion.getRequestDispatcher("equipo.jsp");				
			}else if(go.equals("4")){
				peticion.setAttribute("listadoProyecto", Manejador.getInstancia().listaProyecto());						
				despachador=peticion.getRequestDispatcher("proyecto.jsp");
			}else if(go.equals("5")){
				
				peticion.setAttribute("listadoFase", Manejador.getInstancia().listaFase());
				despachador=peticion.getRequestDispatcher("fase.jsp");
			}else if(go.equals("6")){
				peticion.setAttribute("listaMeta", Manejador.getInstancia().listaMetas());
				despachador=peticion.getRequestDispatcher("meta.jsp");
			}else if(go.equals("7")){
				peticion.setAttribute("listaReunion", Manejador.getInstancia().listaReunion());
				despachador=peticion.getRequestDispatcher("reunion.jsp");		
			}else if(go.equals("8")){
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
