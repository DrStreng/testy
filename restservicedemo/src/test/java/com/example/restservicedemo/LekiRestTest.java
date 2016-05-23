package com.example.restservicedemo;

import org.junit.BeforeClass;
import org.junit.Test;
import com.jayway.restassured.RestAssured;

public class LekiRestTest {
	
	@BeforeClass
	public static void setUp(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/restservicedemo/api";
	}
	
	@Test
	public void add(){

	}
	
	@Test
	public void testPrice(){

	}
	
	@Test
	public void delete(){
		
	}
	

}
