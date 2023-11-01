package com.example.laundry.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.laundry.models.Servizio;
import com.example.laundry.repositories.ServizioRepository;

@Service
public class ServizioService {
	
	@Autowired
	private ServizioRepository servizioRepository;
	
	public List<Servizio> getAllServizi() {
		return servizioRepository.findAll();
	}
	
	public Optional<Servizio> getServizioById(Long id) {
		return servizioRepository.findById(id);
	}
	
	public Servizio createServizio(Servizio newServizio) {

		newServizio = servizioRepository.save(newServizio);

        return newServizio;
    }
	
	public Servizio updateServizio(long id, Servizio updateServizio) {
        Optional<Servizio> optionalServizio = servizioRepository.findById(id);

        if (optionalServizio.isEmpty()) {
            throw new IllegalStateException("Servizio not found");
        }

        Servizio servizioToUpdate = optionalServizio.get();

        updateServizio.setId(servizioToUpdate.getId());

        updateServizio = servizioRepository.save(updateServizio);

        return updateServizio;
    }
	
	public Servizio deleteServizio(long id) {
        Optional<Servizio> optionalServizio = servizioRepository.findById(id);

        if (optionalServizio.isEmpty()) {
            throw new IllegalStateException("Servizio not found");
        }

        Servizio servizioToDelete = optionalServizio.get();

        servizioRepository.delete(servizioToDelete);

        return servizioToDelete;
    }
}
