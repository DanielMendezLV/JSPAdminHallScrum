package org.hellscrum.detalle;

import java.sql.Date;

public class ReunionD {

	public ReunionD(Integer idreunion, Date fecha, String hora, String equipo) {
		super();
		this.idreunion = idreunion;
		this.fecha = fecha;
		this.hora = hora;
		this.equipo = equipo;
	}
	public ReunionD() {
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
	public String getEquipo() {
		return equipo;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	public Integer idreunion;
	public Date fecha;
	public String hora;
	public String equipo;
}
