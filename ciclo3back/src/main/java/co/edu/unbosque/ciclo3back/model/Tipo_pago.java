package co.edu.unbosque.ciclo3back.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="tipo_pago")
public class Tipo_pago {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (unique = true, nullable = false)
	private Long IDtipo_pago;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "IDfactura")
	private Clientes IDfactura;
	
	private String Tipo_pago;

	public Tipo_pago(Clientes iDfactura, String tipo_pago) {
		super();
		IDfactura = iDfactura;
		Tipo_pago = tipo_pago;
	}
	public Tipo_pago() {
		
	}
	
	public Long getIDtipo_pago() {
		return IDtipo_pago;
	}
	public void setIDtipo_pago(Long iDtipo_pago) {
		IDtipo_pago = iDtipo_pago;
	}
	public Clientes getIDfactura() {
		return IDfactura;
	}
	public void setIDfactura(Clientes iDfactura) {
		IDfactura = iDfactura;
	}
	public String getTipo_pago() {
		return Tipo_pago;
	}
	public void setTipo_pago(String tipo_pago) {
		Tipo_pago = tipo_pago;
	}
}
