package org.hellscrum.bean;

public class meta {
	public meta(Integer idmeta, String descripcion, boolean estado,
			Integer idfase) {
		super();
		this.idmeta = idmeta;
		this.descripcion = descripcion;
		this.estado = estado;
		this.idfase = idfase;
	}
	public meta() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getIdmeta() {
		return idmeta;
	}
	public void setIdmeta(Integer idmeta) {
		this.idmeta = idmeta;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public Integer getIdfase() {
		return idfase;
	}
	public void setIdfase(Integer idfase) {
		this.idfase = idfase;
	}
	public Integer idmeta;
	public String descripcion;
	public boolean estado;
	public Integer idfase;
}
