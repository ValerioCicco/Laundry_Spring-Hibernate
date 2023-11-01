package com.example.laundry.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.laundry.models.Ordine;

public interface OrdineRepository extends JpaRepository<Ordine, Long>{

}
