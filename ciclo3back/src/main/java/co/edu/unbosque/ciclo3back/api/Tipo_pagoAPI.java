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

import co.edu.unbosque.ciclo3back.dao.Tipo_pagoDAO;
import co.edu.unbosque.ciclo3back.model.Tipo_pago;

@RestController //esta es una clase REST
@RequestMapping("/tipo_pago")
public class Tipo_pagoAPI {
	
	@Autowired //inyecta la dependencia de todos los métodos del JPA
	private Tipo_pagoDAO tipo_pagoDAO;
	
	@PostMapping("/guardar")//Request convierte en un objeto Java desde un JSon
	public void guardar(@RequestBody Tipo_pago tipo_pago) {
		tipo_pagoDAO.save(tipo_pago);
	}
	
	@GetMapping("/listar")
	public List<Tipo_pago> listar(){
		return tipo_pagoDAO.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		tipo_pagoDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Tipo_pago tipo_pago) {
		tipo_pagoDAO.save(tipo_pago);
	}
}
