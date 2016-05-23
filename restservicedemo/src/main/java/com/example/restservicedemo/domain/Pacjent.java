package com.example.restservicedemo.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pacjent {
	
	private long id;
	private String imie;
	private String nazwisko;
	private String nzoz;
	
	public Pacjent() {
	}

	public Pacjent(long id, String imie,String nazwisko,String nzoz) {
		super();
		this.id = id;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.nzoz = nzoz;
	}
	public Pacjent( String imie,String nazwisko,String nzoz) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.nzoz = nzoz;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getNzoz() {
		return nzoz;
	}

	public void setNzoz(String nzoz) {
		this.nzoz = nzoz;
	}

}
