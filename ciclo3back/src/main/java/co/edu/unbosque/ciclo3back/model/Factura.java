package co.edu.unbosque.ciclo3back.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name="factura")
public class Factura {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (unique = true, nullable = false)
	private Long IDfactura;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "IDcliente")
	private Clientes IDcliente;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha", nullable = false)
	private Date Fecha;
	
	private Float Valor_total;
	
	public Factura(Clientes iDcliente, Date fecha, Float valor_total) {
		super();
		IDcliente = iDcliente;
		Fecha = fecha;
		Valor_total = valor_total;
	}
	public Factura() {
		
	}
	public Long getIDfactura() {
		return IDfactura;
	}
	public void setIDfactura(Long iDfactura) {
		IDfactura = iDfactura;
	}
	public Clientes getIDcliente() {
		return IDcliente;
	}
	public void setIDcliente(Clientes iDcliente) {
		IDcliente = iDcliente;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public Float getValor_total() {
		return Valor_total;
	}
	public void setValor_total(Float valor_total) {
		Valor_total = valor_total;
	}	
}
