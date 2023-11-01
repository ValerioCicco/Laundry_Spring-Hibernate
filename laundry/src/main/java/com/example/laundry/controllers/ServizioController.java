package com.example.laundry.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.laundry.models.Servizio;
import com.example.laundry.services.ServizioService;

@RestController
@RequestMapping("/servizi")
public class ServizioController {
	
	@Autowired
	private ServizioService servizioService;
	
	@GetMapping
	public List<Servizio> listaServizi() {
		return servizioService.getAllServizi();
	}
	
	@GetMapping("/{id}")
	public Optional<Servizio> getServizioById(@PathVariable Long id) {
		return servizioService.getServizioById(id);
	}
	
	@PostMapping
	public Servizio nuovoServizio(@RequestBody Servizio servizio) {
		return servizioService.createServizio(servizio);
	}
	
	@PutMapping("/{id}")
	public Servizio modificaServizio(@PathVariable Long id, @RequestBody Servizio servizio) {
		return servizioService.updateServizio(id, servizio);
	}
	
	@DeleteMapping("/{id}")
	public Servizio eliminaServizio(@PathVariable Long id) {
		return servizioService.deleteServizio(id);
	}
}
