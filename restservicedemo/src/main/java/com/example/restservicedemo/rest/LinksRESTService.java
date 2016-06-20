package com.example.restservicedemo.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.restservicedemo.domain.Car;
import com.example.restservicedemo.domain.Person;
import com.example.restservicedemo.service.PersonManager;

@Path("link")
public class LinksRESTService {
	
	private PersonManager pm = new PersonManager();
	
	
//PERSON////////////////////////////////////////////////////////
	
	@DELETE
	@Path("/clearPersons")
	public Response clearPersons(){
		pm.clearPersons();
		return Response.status(200).build();
	}
	
	@POST
	@Path("/addPerson")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPerson(Person person){
		pm.addPerson(person);
		return Response.status(201).entity("Person").build(); 
	}
	
	@POST
	@Path("/addPersonWithId")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPersonWithId(Person person){
		pm.addPersonWithId(person);
		return Response.status(201).entity("Person").build(); 
	}
	
	@GET
	@Path("/getPerson/{personId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPerson(@PathParam("personId") Long id){
		Person p = pm.getPerson(id);
		return p;
	}
	
	@GET
	@Path("/getAllPersons")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getAllPersons(){
		return pm.getAllPersons();
	}
	
/////CAR/////////////////////////////////////////////////////////////////////////////	
	
	@DELETE
	@Path("/clearCars")
	public Response clearCars(){
		pm.clearCars();
		return Response.status(200).build();
	}
	@POST
	@Path("/addCar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCar(Car car){
		pm.addCar(car);
		return Response.status(201).entity("Car").build(); 
	}
	@POST
	@Path("/addCarWithId")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCarWithId(Car car){
		pm.addCarWithId(car);
		return Response.status(201).entity("Car").build(); 
	}
	

	@GET
	@Path("/getCar/{carId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Car getCar(@PathParam("carId") Long id){
		Car p = pm.getCar(id);
		return p;
	}
	
	@GET
	@Path("/getAllCars")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Car> getAllCars(){
		return pm.getAllCars();
	}
	
/////OTHER////////////////////////////////////////////////////////////////////////////////	
	

	
	@POST
	@Path("/sellCar/{carToSellId}/{ownerId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response sellCar(
			@PathParam("carToSellId")long carid,
			@PathParam("ownerId")long personid
			){
		Car car = pm.getCar(carid);
		Person person = pm.getPerson(personid);
		
		pm.sellCar(car, person);
		return Response.status(201).build();
	}
	
	@GET
	@Path("/getCarWithOwner/{ownerId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Car getCarWithOwner(@PathParam("ownerId") Long id){
		Car c = pm.getCar(id);
		return pm.getCarWithOwner(c);
	}
	
}
