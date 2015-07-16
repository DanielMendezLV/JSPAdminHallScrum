package org.hellscrum.bean;

import java.sql.Date;

public class fase {
	public fase(Integer idfase, String nombre, Date fechainicio,
			Date fechafinalizacion, Integer idproyecto) {
		super();
		this.idfase = idfase;
		this.nombre = nombre;
		this.fechainicio = fechainicio;
		this.fechafinalizacion = fechafinalizacion;
		this.idproyecto = idproyecto;
	}
	public fase() {
		super();
		// TODO Auto-generated constructor stub
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
	public Integer getIdproyecto() {
		return idproyecto;
	}
	public void setIdproyecto(Integer idproyecto) {
		this.idproyecto = idproyecto;
	}
	public Integer idfase;
	public String nombre;
	public Date fechainicio;
	public Date fechafinalizacion;
	public Integer idproyecto;
}
