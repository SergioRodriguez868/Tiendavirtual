package co.edu.unbosque.Ciclo3;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuarios {
	private String Nombres;
	private String Apellidos;
	@Id
	private long IDadmin;
	private String Correo;
	private long Celular;
	private String Usuario;
	private String Password;
	public String getNombres() {
		return Nombres;
	}
	public void setNombres(String nombres) {
		Nombres = nombres;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	public long getIDadmin() {
		return IDadmin;
	}
	public void setIDadmin(long iDadmin) {
		IDadmin = iDadmin;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	public long getCelular() {
		return Celular;
	}
	public void setCelular(long celular) {
		Celular = celular;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
		
}
