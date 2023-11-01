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

import com.example.laundry.models.Ordine;
import com.example.laundry.services.OrdineService;

@RestController
@RequestMapping("/ordini")
public class OrdineController {
	
	@Autowired
	private OrdineService ordineService;
	
	@GetMapping
	public List<Ordine> listaOrdini() {
		List<Ordine> ordini = ordineService.getAllOrdini();
		return ordini;
	}
	
	@GetMapping("/{id}")
	public Optional<Ordine> getOrdineById(@PathVariable Long id) {
		return ordineService.getOrdineById(id);
	}
	
	@PostMapping
	public Ordine nuovoOrdine(@RequestBody Ordine ordine) {
		return ordineService.createOrdine(ordine);
	}
	
	@PutMapping("/{id}")
	public Ordine modificaOrdine(@PathVariable Long id, @RequestBody Ordine ordine) {
		return ordineService.updateOrdine(id, ordine);
	}
	
	@DeleteMapping("/{id}")
	public Ordine eliminaOrdine(@PathVariable Long id) {
		return ordineService.deleteOrdine(id);
	}
}
