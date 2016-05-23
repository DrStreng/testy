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

import com.example.restservicedemo.domain.Leki;
import com.example.restservicedemo.service.LekiManager;

@Path("leki")
public class LekiRESTService {
private LekiManager lm = new LekiManager();
	
	@GET
	@Path("/{lekiId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Leki getleki(@PathParam("lekiId") Long id){
		Leki p = lm.getLeki(id);
		return p;
	}
	@GET
	@Path("/JOIN")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Leki> getAllCarsWithOwner() {
		return lm.getAllInfo();
	}
	
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Leki leki){
		lm.addLeki(leki);
		return Response.status(201).entity("leki").build();
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Leki> getAlllekis() {
		return lm.getAllLekis();
	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_HTML)
	public String test(){
		return "REST API /leki is running";
	}
	
	@GET
	@Path("/delete/{lekiId}")
	@Consumes(MediaType.TEXT_HTML)
	public String removeLeki(@PathParam("personId") Long id) {
		Leki p = lm.getLeki(id);
		lm.deleteLek(p);
		return "Usunieto";
	}
	
	@DELETE
	public Response clearlekis(){
		lm.deleteLekis();
		return Response.status(200).build();
	}
}
