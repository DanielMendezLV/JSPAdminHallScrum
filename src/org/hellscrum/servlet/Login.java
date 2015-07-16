package org.hellscrum.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hellscrum.manejador.Manejador;

public class Login extends HttpServlet{
	public void doGet(HttpServletRequest peticion,HttpServletResponse respuesta)throws IOException,ServletException{
		doPost(peticion,respuesta);
	}
	public void doPost(HttpServletRequest peticion,HttpServletResponse respuesta)throws IOException,ServletException{
		RequestDispatcher despachador=null;		
		
		if(Manejador.getInstancia().getUsuarioAutenticado()){
			despachador=peticion.getRequestDispatcher("index.jsp");
		}else{
			String nick=peticion.getParameter("txtNick");
			String pass=peticion.getParameter("txtPass");
			Manejador.getInstancia().autenticarUsuario(nick, pass);
			if (Manejador.getInstancia().getUsuarioAutenticado()){
				despachador=peticion.getRequestDispatcher("index.jsp");
			}else{
				despachador=peticion.getRequestDispatcher("login.jsp");
			}			
		}
		despachador.forward(peticion,respuesta);
	}
}
