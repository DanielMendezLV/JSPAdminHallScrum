package org.hellscrum.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hellscrum.manejador.Manejador;

public class Create extends HttpServlet{
	public void doGet(HttpServletRequest peticion,HttpServletResponse respuesta)throws IOException,ServletException{
		doPost(peticion,respuesta);
	}
	public void doPost(HttpServletRequest peticion,HttpServletResponse respuesta)throws IOException,ServletException{
		RequestDispatcher despachador=null;

		String nombre=peticion.getParameter("nombre");
		String apellido=peticion.getParameter("apellido");
		String nick=peticion.getParameter("nick");
		String password=peticion.getParameter("password");
		Manejador.getInstancia().CreateUsuario(nombre,apellido,nick,password);
		peticion.setAttribute("listaUsuario", Manejador.getInstancia().listaUsuario());				
		despachador=peticion.getRequestDispatcher("usuario.jsp");				

		
		despachador.forward(peticion,respuesta);
	}
}