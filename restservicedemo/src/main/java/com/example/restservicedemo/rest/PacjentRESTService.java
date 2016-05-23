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

import com.example.restservicedemo.domain.Pacjent;
import com.example.restservicedemo.service.PacjentManager;

@Path("pacjent")
public class PacjentRESTService {	
	
	private PacjentManager pm = new PacjentManager();
	
	@GET
	@Path("/{pacjentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Pacjent getPacjent(@PathParam("pacjentId") Long id){
		Pacjent p = pm.getPacjent(id);
		return p;
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Pacjent pacjent){
		pm.addPacjent(pacjent);
		return Response.status(201).entity("Pacjent").build();
	}
	
	@GET
	@Path("/all")
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Pacjent> getAllPacjents() {
		return pm.getAllPacjents();
	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_HTML)
	public String test(){
		return "REST API /pacjent is running";
	}
	
	@GET
	@Path("/delete/{pacjentId}")
	@Consumes(MediaType.TEXT_HTML)
	public String removeLeki(@PathParam("personId") Long id) {
		Pacjent p = pm.getPacjent(id);
		pm.deletePacjent(p);
		return "Usunieto";
	}
	
	@DELETE
	public Response deletePacjents(){
		pm.deletePacjents();
		return Response.status(200).build();
	}
}
