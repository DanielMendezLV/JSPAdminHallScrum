package org.hellscrum.detalle;

import java.sql.Date;
import java.util.ArrayList;

import org.hellscrum.bean.fase;
public class ProyectoD {
	
	public ProyectoD(Integer idproyecto, String nombre, Date fechacreacion,
			Integer idequipo, ArrayList<fase> listaFase) {
		super();
		this.idproyecto = idproyecto;
		this.nombre = nombre;
		this.fechacreacion = fechacreacion;
		this.idequipo = idequipo;
		ListaFase = listaFase;
	}
	public ProyectoD() {
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
	public ArrayList<fase> getListaFase() {
		return ListaFase;
	}
	public void setListaFase(ArrayList<fase> listaFase) {
		ListaFase = listaFase;
	}
	private Integer idproyecto;
	private String nombre;
	private Date fechacreacion;
	private Integer idequipo;
	private ArrayList<fase> ListaFase;
}
