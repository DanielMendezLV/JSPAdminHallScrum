package org.hellscrum.detalle;
import java.util.ArrayList;

import org.hellscrum.bean.usuario;
import org.hellscrum.bean.proyecto;

public class Equipos {
	
	
	public Equipos(Integer idEquipo, String nombre, String myKey,
			ArrayList<usuario> listaUsuario, ArrayList<proyecto> listaProecto) {
		super();
		this.idEquipo = idEquipo;
		this.nombre = nombre;
		this.myKey = myKey;
		this.listaUsuario = listaUsuario;
		this.listaProecto = listaProecto;
	}
	public Equipos() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(Integer idEquipo) {
		this.idEquipo = idEquipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMyKey() {
		return myKey;
	}
	public void setMyKey(String myKey) {
		this.myKey = myKey;
	}
	public ArrayList<usuario> getListaUsuario() {
		return listaUsuario;
	}
	public void setListaUsuario(ArrayList<usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
	public ArrayList<proyecto> getListaProecto() {
		return listaProecto;
	}
	public void setListaProecto(ArrayList<proyecto> listaProecto) {
		this.listaProecto = listaProecto;
	}
	public Integer idEquipo;
	public String nombre;
	public String myKey;
	public ArrayList<usuario> listaUsuario;
	public ArrayList<proyecto> listaProecto;
}
