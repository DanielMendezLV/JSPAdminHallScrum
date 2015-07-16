package org.hellscrum.detalle;

import java.sql.Date;

public class MensajeD {
	public MensajeD(Integer idmensaje, String equipo, Date fecha, String texto) {
		super();
		this.idmensaje = idmensaje;
		this.equipo = equipo;
		this.fecha = fecha;
		this.texto = texto;
	}
	public MensajeD() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getIdmensaje() {
		return idmensaje;
	}
	public void setIdmensaje(Integer idmensaje) {
		this.idmensaje = idmensaje;
	}
	public String getEquipo() {
		return equipo;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Integer idmensaje;
	public String equipo;
	public Date fecha;
	public String  texto;
}
