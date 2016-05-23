package com.example.restservicedemo.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Leki {
	
	private long id;
	private String producent;
	private String nazwa;	
	private double cena_hurtowa;
	private long pacjentId;
	
	public Leki(long id, String producent, String nazwa, double cena_hurtowa,long pacjentId) {
		super();
		this.id = id;
		this.producent = producent;
		this.nazwa = nazwa;
		this.cena_hurtowa = cena_hurtowa;
		this.pacjentId = pacjentId;
	}
	private Pacjent pacjent;
	
	public Pacjent getPacjent(){
		return pacjent;
	}
	public void setPacjent(Pacjent pacjent){
		this.pacjent = pacjent;
	}
	
	public Leki() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProducent() {
		return producent;
	}

	public void setProducent(String producent) {
		this.producent = producent;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public double getCena_hurtowa() {
		return cena_hurtowa;
	}

	public void setCena_hurtowa(double cena_hurtowa) {
		this.cena_hurtowa = cena_hurtowa;
	}

	public long getPacjentId() {
		return pacjentId;
	}

	public void setPacjentId(long pacjentId) {
		this.pacjentId = pacjentId;
	}
}
