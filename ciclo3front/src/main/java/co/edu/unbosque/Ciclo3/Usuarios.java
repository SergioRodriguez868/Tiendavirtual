package co.edu.unbosque.Ciclo3;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuarios {
	private String Nombres;
	private String Apellidos;
	@Id
	private String IDadmin;
	private String Correo;
	private String Celular;
	private String Usuario;
	private String Password;
	
	public Usuarios (String Nombres, String Apellidos, String IDadmin, String Correo, String Celular, String Usuario, String Password) {
		this.Nombres = Nombres;
		this.Apellidos = Apellidos;
		this.IDadmin = IDadmin;
		this.Correo = Correo;
		this.Celular = Celular;
		this.Usuario = Usuario;
		this.Password = Password;
	}
	public Usuarios() {
		
	}
	
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
	public String getIDadmin() {
		return IDadmin;
	}
	public void setIDadmin(String iDadmin) {
		IDadmin = iDadmin;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	public String getCelular() {
		return Celular;
	}
	public void setCelular(String celular) {
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
