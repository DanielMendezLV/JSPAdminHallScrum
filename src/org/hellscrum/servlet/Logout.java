package org.hellscrum.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hellscrum.manejador.Manejador;

public class Logout extends HttpServlet{
	public void doGet(HttpServletRequest peticion,HttpServletResponse respuesta)throws IOException,ServletException{
		doPost(peticion,respuesta);
	}
	public void doPost(HttpServletRequest peticion,HttpServletResponse respuesta)throws IOException,ServletException{
		RequestDispatcher despachador=null;
		
		Manejador.getInstancia().desAutenticarUsuario();		
		despachador=peticion.getRequestDispatcher("login.jsp");
		despachador.forward(peticion,respuesta);
	}
}
