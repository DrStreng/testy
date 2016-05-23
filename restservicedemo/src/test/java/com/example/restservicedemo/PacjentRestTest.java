package com.example.restservicedemo;

import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.equalToIgnoringCase;
//import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;

import javax.ws.rs.core.MediaType;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;
import com.example.restservicedemo.domain.Pacjent;
import com.jayway.restassured.RestAssured;

public class PacjentRestTest {

	private static final String PACJENT_IMIE = "Grzegorz";
	private static final String PACJENT_NAZWISKO = "Czesc";
	private static final String PACJENT_NZOZ = "Gdansk";
	

	@BeforeClass
	public static void setUp(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/restservicedemo/api";
	}
	
	@Test
	public void clearPacjents() {
		delete("/pacjent/").then().assertThat().statusCode(200);
		given().
	       contentType(MediaType.APPLICATION_JSON).
	       body(Pacjent.class).
	    when().
	    then().
	    body("", Matchers.hasSize(0));
	}
	
	
	@Test
	public void addPacjent(){
		delete("/pacjent/").then().assertThat().statusCode(200);
		Pacjent pacjent = new Pacjent(1, PACJENT_IMIE, PACJENT_NAZWISKO, PACJENT_NZOZ);
		given().
	       contentType(MediaType.APPLICATION_JSON).
	       body(pacjent).
	    when().	     
	    post("/pacjent/").then().assertThat().statusCode(201);		
		Pacjent rPacjent = get("/pacjent/1").as(Pacjent.class);
		assertThat(PACJENT_IMIE, equalToIgnoringCase(rPacjent.getImie()));
	}
	
	@Test
	public void testGetSinglePacjent(){

	}
	
	@Test
	public void getAllPacjents(){
		
	}
	
	@Test
	public void getPacjentById(){
		
	}
	
}
