package co.edu.unbosque.ciclo3back.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="productos")
public class Productos {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (unique = true, nullable = false)
	private Long id;
	private String Nombre_producto;
	private String Genero;
	private Integer Talla;
	private Float Valor_unidad;
	
	@ManyToOne
    @JoinColumn(name = "det_factura", nullable = false, updatable = false)
    private Detalle_factura carrito;
	
	public Productos(String nombre_producto, String genero, Integer talla, Float valor_unidad,
			Detalle_factura carrito) {
		super();
		Nombre_producto = nombre_producto;
		Genero = genero;
		Talla = talla;
		Valor_unidad = valor_unidad;
		this.carrito = carrito;
	}
	public Productos() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre_producto() {
		return Nombre_producto;
	}
	public void setNombre_producto(String nombre_producto) {
		Nombre_producto = nombre_producto;
	}
	public String getGenero() {
		return Genero;
	}
	public void setGenero(String genero) {
		Genero = genero;
	}
	public Integer getTalla() {
		return Talla;
	}
	public void setTalla(Integer talla) {
		Talla = talla;
	}
	public Float getValor_unidad() {
		return Valor_unidad;
	}
	public void setValor_unidad(Float valor_unidad) {
		Valor_unidad = valor_unidad;
	}
	public Detalle_factura getCarrito() {
		return carrito;
	}
	public void setCarrito(Detalle_factura carrito) {
		this.carrito = carrito;
	}
}
