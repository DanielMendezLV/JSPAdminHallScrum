package org.hellscrum.bean;

import java.sql.Date;

public class proyecto {
	public proyecto(Integer idproyecto, String nombre, Date fechacreacion,
			Integer idequipo) {
		super();
		this.idproyecto = idproyecto;
		this.nombre = nombre;
		this.fechacreacion = fechacreacion;
		this.idequipo = idequipo;
	}
	public proyecto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getIdproyecto() {
		return idproyecto;
	}
	public void setIdproyecto(Integer idproyecto) {
		this.idproyecto = idproyecto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechacreacion() {
		return fechacreacion;
	}
	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
	public Integer getIdequipo() {
		return idequipo;
	}
	public void setIdequipo(Integer idequipo) {
		this.idequipo = idequipo;
	}
	private Integer idproyecto;
	private String nombre;
	private Date fechacreacion;
	private Integer idequipo;
}
