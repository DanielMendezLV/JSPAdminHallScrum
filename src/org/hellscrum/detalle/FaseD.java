package org.hellscrum.detalle;

import java.sql.Date;
import java.util.ArrayList;
import org.hellscrum.bean.meta;

public class FaseD {

	public FaseD() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FaseD(Integer idfase, String nombre, ArrayList<meta> listaMetas,
			Date fechainicio, Date fechafinalizacion, String proyecto) {
		super();
		this.idfase = idfase;
		this.nombre = nombre;
		this.ListaMetas = listaMetas;
		this.fechainicio = fechainicio;
		this.fechafinalizacion = fechafinalizacion;
		this.proyecto = proyecto;
	}
	public Integer getIdfase() {
		return idfase;
	}
	public void setIdfase(Integer idfase) {
		this.idfase = idfase;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<meta> getListaMetas() {
		return ListaMetas;
	}
	public void setListaMetas(ArrayList<meta> listaMetas) {
		ListaMetas = listaMetas;
	}
	public Date getFechainicio() {
		return fechainicio;
	}
	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}
	public Date getFechafinalizacion() {
		return fechafinalizacion;
	}
	public void setFechafinalizacion(Date fechafinalizacion) {
		this.fechafinalizacion = fechafinalizacion;
	}
	public String getProyecto() {
		return proyecto;
	}
	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}
	public Integer idfase;
	public String nombre;
	public ArrayList<meta> ListaMetas;
	public Date fechainicio;
	public Date fechafinalizacion;
	public String proyecto;
}
