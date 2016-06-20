package restAssuredTests.service;

import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.hamcrest.Matchers;

import com.example.restservicedemo.domain.Car;
import com.example.restservicedemo.domain.Person;

public class ServiceMockRESTDB {

	public void clearPersons() {
		delete("/link/clearPersons/").then().assertThat().statusCode(200);
		given()
	       	.contentType(MediaType.APPLICATION_JSON)
	       	.body(Person.class)
	    .when()
	    .then()
	    	.body("", Matchers.hasSize(0));
	}

	public void getPersonData(String personId){
		given()
			.contentType("application/json")
		.when()
			.get("/link/getPerson/"+ personId)
		.then()
			.body(containsString("firstName"))
			.body(containsString("id"))
			.body(containsString("yob"))
			.statusCode(200);
	}
	
	public void addPersonData(String firstName, long id, int yob){
		Person person = new Person();
		person.setFirstName(firstName);
		person.setId(id);
		person.setYob(yob);
		
		given()
			.contentType("application/json")
			.body(person)
		.when()
			.post("/link/addPersonWithId/")
		.then()
			.assertThat().
			statusCode(201);
		
		given()
			.contentType("application/json")
		.when()
			.get("/link/getPerson/"+ id)
		.then()
			.body("id",equalTo(Long.toString(id)))
			.body("firstName",equalTo(firstName))
			.body("yob",equalTo(Integer.toString(yob)))
			.statusCode(200);
	}
	
	public void getAllPersonsData(List<Person> myList){
		given()
			.contentType("application/json")
		.when()
			.get("/link/getAllPersons/")
		.then()
			.body("person[0].id",equalTo(Long.toString(myList.get(0).getId())))
			.body("person[0].firstName", equalTo(myList.get(0).getFirstName()))
			.body("person[0].yob", equalTo(Integer.toString(myList.get(0).getYob())))
			.body("person[1].firstName",equalTo(myList.get(1).getFirstName()))
			.body("person[2].firstName",equalTo(myList.get(2).getFirstName()))
			.body("person.id", hasItems("1","2"))
			.body("person.size()",equalTo(myList.size()))
			.statusCode(200);
	}
	
	public void clearCars(){
		delete("/link/clearCars/").then().assertThat().statusCode(200);
		given()
	       	.contentType(MediaType.APPLICATION_JSON)
	       	.body(Car.class)
	    .when()
	    .then()
	    	.body("", Matchers.hasSize(0));
	}
	
	public void getCarData(String carId){
		given()
			.contentType("application/json")
		.when()
			.get("/link/getCar/"+ carId)
		.then()
			.body(containsString("id"))
			.body(containsString("model"))
			.body(containsString("yop"))
			.statusCode(200);
	}
	
	public void addCarData(String model, long id, int yop){
		Car car = new Car();
		car.setId(id);
		car.setModel(model);
		car.setYop(yop);
		
		given()
			.contentType("application/json")
			.body(car)
		.when()
			.post("/link/addCarWithId/")
		.then()
			.assertThat()
			.statusCode(201);
	
		given()
			.contentType("application/json")
		.when()
			.get("/link/getCar/"+ id)
		.then()
			.body("id",equalTo(Long.toString(id)))
			.body("model",equalTo(model))
			.body("yop",equalTo(Integer.toString(yop)))
			.statusCode(200);
	}
	
	public void getAllCarsData(List<Car> myList){
		given()
			.contentType("application/json")
		.when()
			.get("/link/getAllCars/")
		.then()
			.body("car[0].id",equalTo(Long.toString(myList.get(0).getId())))
			.body("car[0].model", equalTo(myList.get(0).getModel()))
			.body("car[0].yop", equalTo(Integer.toString(myList.get(0).getYop())))
			.body("car.id", hasItems("1","2"))
			.body("car.size()",equalTo(myList.size()))
			.statusCode(200);
	}
	
	public void sellCar(long l, long m){

		given()
			.contentType("application/json")
		.when()
			.post("link/sellCar/"+l+"/"+m);
		
			
	
	}
	

	
	
	
	
	
	
	
}