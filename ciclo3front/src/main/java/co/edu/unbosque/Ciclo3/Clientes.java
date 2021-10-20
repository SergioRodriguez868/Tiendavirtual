package co.edu.unbosque.Ciclo3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="clientes")
public class Clientes {
	
	@Id
	@Column (unique = true, nullable = false)
	private Long IDcliente;
	private String Nombres;
	private String Apellidos;
	private String Correo;
	private Long Celular;
	private String Direccion;
	private String Usuario;
	private String Password;
	
	public Clientes (Long IDcliente, String Nombres, String Apellidos, String Correo, Long Celular, String Direccion,String Usuario, String Password) {
		this.IDcliente = IDcliente;
		this.Nombres = Nombres;
		this.Apellidos = Apellidos;
		this.Correo = Correo;
		this.Celular = Celular;
		this.Direccion = Direccion;
		this.Usuario = Usuario;
		this.Password = Password;
	}
	public Clientes() {
		
	}
	
	public Long getIDcliente() {
		return IDcliente;
	}
	public void setIDcliente(Long iDcliente) {
		IDcliente = iDcliente;
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
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	public Long getCelular() {
		return Celular;
	}
	public void setCelular(Long celular) {
		Celular = celular;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
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
