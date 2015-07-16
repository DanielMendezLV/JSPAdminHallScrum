package org.hellscrum.bean;

public class usuario {
	public usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public usuario(Integer idUsuario, String nombre, String apellido,
			String nickname, String contrasena, Integer idRol) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nickname = nickname;
		this.contrasena = contrasena;
		this.idRol = idRol;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public Integer getIdRol(){
		return idRol;
	}
	public void setIdRol(Integer idRol){
		this.idRol = idRol;
	}
	public Integer idUsuario;
	public String nombre;
	public String apellido;
	public String nickname;
	public String contrasena;
	public Integer idRol;

}
