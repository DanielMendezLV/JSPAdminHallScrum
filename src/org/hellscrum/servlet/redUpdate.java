package org.hellscrum.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hellscrum.manejador.Manejador;

public class redUpdate extends HttpServlet{
	public void doGet(HttpServletRequest peticion,HttpServletResponse respuesta)throws IOException,ServletException{
		doPost(peticion,respuesta);
	}
	public void doPost(HttpServletRequest peticion,HttpServletResponse respuesta)throws IOException,ServletException{
		RequestDispatcher despachador=null;
		
		if(Manejador.getInstancia().getUsuarioAutenticado()){

			String go = peticion.getParameter("go");
			if(go.equals("2")){
				peticion.setAttribute("user", Manejador.getInstancia().getUsuario(peticion.getParameter("id")));
				peticion.setAttribute("pos2", "active");
				despachador=peticion.getRequestDispatcher("update.jsp");				
			}else if(go.equals("3")){
				peticion.setAttribute("equip", Manejador.getInstancia().getEquipo(peticion.getParameter("id")));
				peticion.setAttribute("pos3", "active");
				despachador=peticion.getRequestDispatcher("update.jsp");				
			}else if(go.equals("4")){
				peticion.setAttribute("proy", Manejador.getInstancia().getProyeco(peticion.getParameter("id")));
				peticion.setAttribute("pos4", "active");
				despachador=peticion.getRequestDispatcher("update.jsp");
			}else if(go.equals("5")){
				peticion.setAttribute("fase", Manejador.getInstancia().getFase(peticion.getParameter("id")));
				peticion.setAttribute("pos5", "active");
				despachador=peticion.getRequestDispatcher("update.jsp");
			}else if(go.equals("6")){
				peticion.setAttribute("meta", Manejador.getInstancia().getMeta(peticion.getParameter("id")));
				peticion.setAttribute("pos6", "active");
				despachador=peticion.getRequestDispatcher("update.jsp");
			}else if(go.equals("8")){
				peticion.setAttribute("msg", Manejador.getInstancia().getMensaje(peticion.getParameter("id")));
				peticion.setAttribute("pos8", "active");
				despachador=peticion.getRequestDispatcher("update.jsp");				
			}else{
				despachador=peticion.getRequestDispatcher("index.jsp");
			}
		}else{
				despachador=peticion.getRequestDispatcher("login.jsp");
			
		}

		despachador.forward(peticion,respuesta);
	}
}
