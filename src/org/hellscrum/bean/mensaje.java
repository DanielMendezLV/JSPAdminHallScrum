package org.hellscrum.bean;

public class mensaje {
	public mensaje() {
		super();
		// TODO Auto-generated constructor stub
	}
	public mensaje(Integer idmensaje, Integer idreunion, String texto) {
		super();
		this.idmensaje = idmensaje;
		this.idreunion = idreunion;
		this.texto = texto;
	}
	public Integer getIdmensaje() {
		return idmensaje;
	}
	public void setIdmensaje(Integer idmensaje) {
		this.idmensaje = idmensaje;
	}
	public Integer getIdreunion() {
		return idreunion;
	}
	public void setIdreunion(Integer idreunion) {
		this.idreunion = idreunion;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Integer idmensaje;
	public Integer idreunion;
	public String  texto;
}
