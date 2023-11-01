package com.example.laundry.models;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordine")
public class Ordine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "dataConsegna")
	private LocalDate dataConsegna;
	
	@Column(name = "dataRitiro")
	private LocalDate dataRitiro;
	
	@ManyToOne()
	@JoinColumn(name = "id_cliente", nullable = false)
	private Cliente cliente;
	
	@ManyToMany
	@JoinTable(
			  name = "servizi_ordini", //nome tabella pivot
			  joinColumns = @JoinColumn(name = "id_ordine"),  //PK associata a questa tabella
			  inverseJoinColumns = @JoinColumn(name = "id_servizio")) //PK associata alla tabella servizi (lo sa perché il tipo della lista è "Servizio")
				List<Servizio> servizi = new ArrayList<>(); //= new ArrayList<>() --> Si fa perché se non ci sono valori è null e automaticamente diventa ArrayList (valore di default)
	
	@Column(name = "costoTotale")
	private float costoTotale;

	public Ordine() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataConsegna() {
		return dataConsegna;
	}

	public void setDataConsegna(LocalDate dataConsegna) {
		this.dataConsegna = dataConsegna;
	}

	public LocalDate getDataRitiro() {
		return dataRitiro;
	}

	public void setDataRitiro(LocalDate dataRitiro) {
		this.dataRitiro = dataRitiro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Servizio> getServizi() {
		return servizi;
	}

	public void setServizi(List<Servizio> servizi) {
		this.servizi = servizi;
	}

	public float getCostoTotale() {
		return costoTotale;
	}

	public void setCostoTotale(float costoTotale) {
		this.costoTotale = costoTotale;
	}

	
	
	
}
