package co.edu.unbosque.ciclo3back.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.ciclo3back.model.Factura;

public interface FacturaDAO extends JpaRepository <Factura, Long> {

}
