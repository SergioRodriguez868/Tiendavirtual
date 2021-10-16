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

import co.edu.unbosque.ciclo3back.dao.Estado_pagoDAO;
import co.edu.unbosque.ciclo3back.model.Estado_pago;

@RestController //esta es una clase REST
@RequestMapping("/estado_pago")
public class Estado_pagoAPI {
	
	@Autowired //inyecta la dependencia de todos los métodos del JPA
	private Estado_pagoDAO estado_pagoDAO;
	
	@PostMapping("/guardar")//Request convierte en un objeto Java desde un JSon
	public void guardar(@RequestBody Estado_pago estado_pago) {
		estado_pagoDAO.save(estado_pago);
	}
	
	@GetMapping("/listar")
	public List<Estado_pago> listar(){
		return estado_pagoDAO.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		estado_pagoDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Estado_pago estado_pago) {
		estado_pagoDAO.save(estado_pago);
	}
}
