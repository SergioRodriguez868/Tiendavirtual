package co.edu.unbosque.ciclo3back.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.ciclo3back.model.Detalle_factura;

public interface Detalle_facturaDAO extends JpaRepository <Detalle_factura, Long> {

}
