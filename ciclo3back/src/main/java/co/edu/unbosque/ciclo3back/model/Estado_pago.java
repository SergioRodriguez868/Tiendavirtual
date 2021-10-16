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
@Table (name="estado_pago")
public class Estado_pago {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (unique = true, nullable = false)
	private Long IDestado_pago;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "IDfactura")
	private Clientes IDfactura;
	
	private String Estado_pago;

	public Estado_pago(Clientes iDfactura, String estado_pago) {
		super();
		IDfactura = iDfactura;
		Estado_pago = estado_pago;
	}
	public Estado_pago() {
		
	}
	public Long getIDestado_pago() {
		return IDestado_pago;
	}
	public void setIDestado_pago(Long iDestado_pago) {
		IDestado_pago = iDestado_pago;
	}
	public Clientes getIDfactura() {
		return IDfactura;
	}
	public void setIDfactura(Clientes iDfactura) {
		IDfactura = iDfactura;
	}
	public String getEstado_pago() {
		return Estado_pago;
	}
	public void setEstado_pago(String estado_pago) {
		Estado_pago = estado_pago;
	}
	
	
}
