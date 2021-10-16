package co.edu.unbosque.ciclo3back.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="detalle_factura")
public class Detalle_factura {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (unique = true, nullable = false)
	private Long IDdetalle;
	
	@ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "IDcliente", nullable = false)
	private Clientes Clientes;
	
	@OneToMany (cascade = CascadeType.MERGE, mappedBy = "carrito")
	private List<Productos> productos;
	
	private Integer Cantidad;

	
	public Detalle_factura(co.edu.unbosque.ciclo3back.model.Clientes clientes, List<Productos> productos,
			Integer cantidad) {
		super();
		Clientes = clientes;
		this.productos = productos;
		Cantidad = cantidad;
	}
	public Detalle_factura() {
		
	}
	public Long getIDdetalle() {
		return IDdetalle;
	}
	public void setIDdetalle(Long iDdetalle) {
		IDdetalle = iDdetalle;
	}
	public Clientes getClientes() {
		return Clientes;
	}
	public void setClientes(Clientes clientes) {
		Clientes = clientes;
	}
	public List<Productos> getProductos() {
		return productos;
	}
	public void setProductos(List<Productos> productos) {
		this.productos = productos;
	}
	public Integer getCantidad() {
		return Cantidad;
	}
	public void setCantidad(Integer cantidad) {
		Cantidad = cantidad;
	}
}
