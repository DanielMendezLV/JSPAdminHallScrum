package org.hellscrum.db;
/*
import org.hellscrum.bean.producto;
import org.hellscrum.bean.userr;
*/
import org.hellscrum.bean.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.hellscrum.db.ConexionWitoutHibernate;

public class Prueba {
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		for(Object obj:Conexion.getInstancia().hacerConsulta("From mensaje")){
			mensaje usr=(mensaje)obj;
			System.out.println("fecha " +usr.getTexto());
			
		}
		/*
		for(Object obj:Conexion.getInstancia().hacerConsulta("From equipo")){
			equipo usr=(equipo)obj;

			System.out.println("id " +usr.getIdequipo()+ " equipo " +usr.getNombre());
			ResultSet resultado=ConexionWitoutHibernate.getInstancia().obtenerConsulta(""+
					"select Equipo.idEquipo as id, Usuario.nombre as Usuario, Equipo.nombre as Equipo, rol.nombre as Rol From Usuario "+
					"	INNER JOIN Usuario_equipo on Usuario_Equipo.idUsuario = Usuario.idUsuario"+
					"	INNER JOIN equipo on Usuario_Equipo.idEquipo = Equipo.idEquipo"+
					"	INNER JOIN Rol on Usuario_Equipo.idRol = Rol.idRol where Equipo.idEquipo ="+usr.getIdequipo());
							try {
								while (resultado.next()) {
									System.out.println(" Usuario " + resultado.getString("Usuario") + " Rol " + resultado.getString("Rol"));
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

			
			
			
			
		}
		try{
		usuario user= Conexion.getInstancia().autenticarUsuario("admin","123");
		if(user==null){
			System.out.println("incorrecto");
		}else{
			System.out.println(user.getNombre());
		}
		}catch(Exception e){
			System.out.println("solo excepciones :) ");
		}*/
	}

}
