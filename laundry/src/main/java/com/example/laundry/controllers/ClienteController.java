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

import com.example.laundry.models.Cliente;
import com.example.laundry.services.ClienteService;

@RestController
@RequestMapping("/clienti")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> listaClienti() {
		return clienteService.getAllClienti();
	}
	
	@GetMapping("/{id}")
	public Optional<Cliente> getClienteById(@PathVariable Long id) {
		return clienteService.getClienteById(id);
	}
	
	@PostMapping
	public Cliente nuovoCliente(@RequestBody Cliente cliente) {
		return clienteService.createCliente(cliente);
	}
	
	@PutMapping("/{id}")
	public Cliente modificaCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
		return clienteService.updateCliente(id, cliente);
	}
	
	@DeleteMapping("/{id}")
	public Cliente eliminaCliente(@PathVariable Long id) {
		return clienteService.deleteCliente(id);
	}
}
