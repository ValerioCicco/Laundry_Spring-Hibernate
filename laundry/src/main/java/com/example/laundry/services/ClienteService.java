package com.example.laundry.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.laundry.models.Cliente;
import com.example.laundry.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> getAllClienti() {
		return clienteRepository.findAll();
	}
	
	public Optional<Cliente> getClienteById(Long id) {
		return clienteRepository.findById(id);
	}
	
	public Cliente createCliente(Cliente newCliente) {

		newCliente = clienteRepository.save(newCliente);

        return newCliente;
    }
	
	public Cliente updateCliente(long id, Cliente updateCliente) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);

        if (optionalCliente.isEmpty()) {
            throw new IllegalStateException("Cliente not found");
        }

        Cliente clienteToUpdate = optionalCliente.get();

        updateCliente.setId(clienteToUpdate.getId());

        updateCliente = clienteRepository.save(updateCliente);

        return updateCliente;
    }
	
	public Cliente deleteCliente(long id) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);

        if (optionalCliente.isEmpty()) {
            throw new IllegalStateException("Cliente not found");
        }

        Cliente clienteToDelete = optionalCliente.get();

        clienteRepository.delete(clienteToDelete);

        return clienteToDelete;
    }
}
