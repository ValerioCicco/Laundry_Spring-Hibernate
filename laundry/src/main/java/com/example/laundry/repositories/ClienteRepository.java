package com.example.laundry.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.laundry.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
