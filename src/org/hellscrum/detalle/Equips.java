package org.hellscrum.detalle;

import java.util.ArrayList;

import org.hellscrum.bean.proyecto;

public class Equips {
	
	public Equips(Integer idEquipo, ArrayList<proyecto> proyectList,
			ArrayList<detalleEquipo> detEquipo, String equipo) {
		super();
		this.idEquipo = idEquipo;
		this.proyectList = proyectList;
		this.detEquipo = detEquipo;
		this.equipo = equipo;
	}

	public Equips() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(Integer idEquipo) {
		this.idEquipo = idEquipo;
	}
	public ArrayList<detalleEquipo> getDetEquipo() {
		return detEquipo;
	}
	public void setDetEquipo(ArrayList<detalleEquipo> detEquipo) {
		this.detEquipo = detEquipo;
	}
	public String getEquipo() {
		return equipo;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public ArrayList<proyecto> getProyectList() {
		return proyectList;
	}
	public void setProyectList(ArrayList<proyecto> proyectList) {
		this.proyectList = proyectList;
	}
	public Integer idEquipo;
	public ArrayList<proyecto> proyectList;
	public ArrayList<detalleEquipo> detEquipo;
	public String equipo;
	
}
