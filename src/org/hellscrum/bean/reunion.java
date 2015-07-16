package org.hellscrum.bean;

import java.sql.Date;

public class reunion {
	public reunion(Integer idreunion, Date fecha, String hora, Integer idequipo) {
		super();
		this.idreunion = idreunion;
		this.fecha = fecha;
		this.hora = hora;
		this.idequipo = idequipo;
	}
	public reunion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getIdreunion() {
		return idreunion;
	}
	public void setIdreunion(Integer idreunion) {
		this.idreunion = idreunion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public Integer getIdequipo() {
		return idequipo;
	}
	public void setIdequipo(Integer idequipo) {
		this.idequipo = idequipo;
	}
	public Integer idreunion;
	public Date fecha;
	public String hora;
	public Integer idequipo;
}
