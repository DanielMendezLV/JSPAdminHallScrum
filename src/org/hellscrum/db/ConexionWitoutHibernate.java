package org.hellscrum.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ConexionWitoutHibernate {
	private Connection conexion;
	private Statement stm;
	private static ConexionWitoutHibernate instancia;
	public static ConexionWitoutHibernate  getInstancia(){
		return (instancia==null)?new ConexionWitoutHibernate():instancia;
	}
	public ConexionWitoutHibernate(){
		try {
			Class.forName("org.hibernate.dialect.PostgreSQLDialect").newInstance();
			conexion=DriverManager.getConnection("jdbc:postgresql://localhost:5432/DB_HallScrum","postgres","admin");
			stm=conexion.createStatement();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public void ejecutarConsulta(String consulta){
		try {
			stm.execute(consulta);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ResultSet obtenerConsulta(String consulta){
		ResultSet resultado=null;
		try {
			resultado=stm.executeQuery(consulta);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}


}
