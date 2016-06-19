package restAssuredTests.tests;

import static com.jayway.restassured.RestAssured.given;

import javax.ws.rs.core.MediaType;

import org.junit.Ignore;
import org.junit.Test;



import restAssuredTests.service.ServiceMockRESTDB;

public class ServiceRESTDBTest extends DefaultRESTDB {
	
	ServiceMockRESTDB service = new ServiceMockRESTDB();
	
	
	
	@Test
	public void shouldClearPersons(){
		service.clearPersons();
	}
	
	@Ignore
	@Test
	public void shouldGetPersonData(){
		service.addPersonData("Banek", 1, 1987);
		service.getPersonData("1");
	}
	
	@Test
	public void shouldAddPersonData(){
		service.addPersonData("Bonio", 10, 1987);
		service.addPersonData("Janko", 1, 1234);
	}
	
	@Test
	public void shouldGetAllPersons(){
		
	}
	
	@Test
	public void shouldClearCars(){
		service.clearCars();
	}
	
	@Ignore
	@Test
	public void shouldGetCarData(){
		service.getCarData("1");
	}
	
	@Test
	public void shouldAddCarData(){
		service.addCarData("Fiat", 2, 1987);
		service.addCarData("Janko", 4, 1234);
	}
	
	@Test
	public void shouldGetAllCars(){
		
	}
	
	

}
