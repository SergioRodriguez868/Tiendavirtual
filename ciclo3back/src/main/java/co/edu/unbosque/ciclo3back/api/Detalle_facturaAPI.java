package co.edu.unbosque.ciclo3back.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.ciclo3back.dao.Detalle_facturaDAO;
import co.edu.unbosque.ciclo3back.model.Detalle_factura;

@RestController //esta es una clase REST
@RequestMapping("/detalle_factura")
public class Detalle_facturaAPI {
	
	@Autowired //inyecta la dependencia de todos los métodos del JPA
	private Detalle_facturaDAO detalle_facturaDAO;
	
	@PostMapping("/guardar")//Request convierte en un objeto Java desde un JSon
	public void guardar(@RequestBody Detalle_factura detalle_factura) {
		detalle_facturaDAO.save(detalle_factura);
	}
	
	@GetMapping("/listar")
	public List<Detalle_factura> listar(){
		return detalle_facturaDAO.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		detalle_facturaDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Detalle_factura detalle_factura) {
		detalle_facturaDAO.save(detalle_factura);
	}
}
