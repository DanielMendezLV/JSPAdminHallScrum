package org.hellscrum.detalle;

public class MetaD {

	public MetaD(Integer idmeta, String descripcion, boolean estado, String fase) {
		super();
		this.idmeta = idmeta;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fase = fase;
	}
	public MetaD() {
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
	public String getFase() {
		return fase;
	}
	public void setFase(String fase) {
		this.fase = fase;
	}
	public Integer idmeta;
	public String descripcion;
	public boolean estado;
	public String fase;
}
