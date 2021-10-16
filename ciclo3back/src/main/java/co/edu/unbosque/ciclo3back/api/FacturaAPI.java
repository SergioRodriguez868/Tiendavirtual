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

import co.edu.unbosque.ciclo3back.dao.FacturaDAO;
import co.edu.unbosque.ciclo3back.model.Factura;

@RestController //esta es una clase REST
@RequestMapping("/factura")
public class FacturaAPI {
	
	@Autowired //inyecta la dependencia de todos los métodos del JPA
	private FacturaDAO facturaDAO;
	
	@PostMapping("/guardar")//Request convierte en un objeto Java desde un JSon
	public void guardar(@RequestBody Factura factura) {
		facturaDAO.save(factura);
	}
	
	@GetMapping("/listar")
	public List<Factura> listar(){
		return facturaDAO.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		facturaDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Factura factura) {
		facturaDAO.save(factura);
	}
}
