package com.example.laundry.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "servizio")
public class Servizio {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "tipo", nullable = false)
	private String tipo;
	
	@Column(name = "tempoEsecuzione", nullable = false)
	private int tempoEsecuzione;
	
	@Column(name = "costoTotale", nullable = false)
	private float costoTotale;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "servizi") //mapped by ha il nome della variabile presente nell'altra tabella
	List<Ordine> ordini = new ArrayList<>();

	public Servizio() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getTempoEsecuzione() {
		return tempoEsecuzione;
	}

	public void setTempoEsecuzione(int tempoEsecuzione) {
		this.tempoEsecuzione = tempoEsecuzione;
	}

	public float getCostoTotale() {
		return costoTotale;
	}

	public void setCostoTotale(float costoTotale) {
		this.costoTotale = costoTotale;
	}

	public List<Ordine> getOrdini() {
		return ordini;
	}

	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
	}
	

	
	
	
}
