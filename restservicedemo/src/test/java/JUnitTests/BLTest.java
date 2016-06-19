package JUnitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.restservicedemo.domain.Car;
import com.example.restservicedemo.domain.Person;
import com.example.restservicedemo.service.PersonManager;

public class BLTest {

	PersonManager pm = new PersonManager();

	private static Person person1;
	private static Person person2;
	private static Car car1;
	private static Car car2;
	private static Car car3;
	
	@BeforeClass
	public static void setUp() {
		person1 = new Person(1,"Jacek",1999);
		person2 = new Person(2,"Placek",2000);
		car1    = new Car(1,"BMW",2005);
		car2    = new Car(2,"Opel",2003);
		car3    = new Car(3,"Astra",2004);
	}
	
	@Before
	public void deleteDB(){
		pm.clearCars();
		pm.clearPersons();
	}
	
	//1
	@Test
	public void checkPersonAddingWithoutId(){
		Person p = new Person();
		p.setFirstName("Grzegorz");
		p.setYob(1992);
		assertEquals(1,pm.addPerson(p));
	}
	//2
	@Test
	public void checkPersonAddingWithId(){
		Person p = new Person();
		p.setId(2);
		p.setFirstName("Placek");
		p.setYob(1992);
		assertEquals(1,pm.addPersonWithId(p));
	}
	//3
	@Test
	public void checkCarAddingWithoutId() {
		Car c = new Car();
		c.setModel("Syrena");
		c.setYop(1973);
		assertEquals(1, pm.addCar(c));
	}
	//4
	@Test
	public void checkCarAddingWithId() {
		Car c = new Car();
		c.setId(1);
		c.setModel("Syrena");
		c.setYop(1973);
		assertEquals(1, pm.addCarWithId(c));
	}
	//5
	@Test
	public void deleteAllPersons(){
		pm.addPerson(person1);
		pm.addPerson(person2);
		List<Person> persons;
		persons = pm.getAllPersons();
		assertEquals(2,persons.size());
		pm.clearPersons();
		persons = pm.getAllPersons();
		assertEquals(0,persons.size());	
	}
	//6
	@Test
	public void deleteAllCars(){
		pm.addCarWithId(car1);
		pm.addCarWithId(car2);
		List<Car> cars;
		cars = pm.getAllCars();
		assertEquals(2,cars.size());
		pm.clearCars();
		cars = pm.getAllCars();
		assertEquals(0,cars.size());
	}
	//7
	@Test
	public void getAllPersons(){
		pm.addPersonWithId(person1);
		pm.addPersonWithId(person2);
		List<Person> persons = new ArrayList<>();
		persons = pm.getAllPersons();
		
		assertEquals(2,persons.size());
		assertNotEquals("duplikat",persons.get(0),persons.get(1));
		assertEquals(person1.getFirstName(),persons.get(0).getFirstName());
		assertEquals(person2.getYob(),persons.get(1).getYob());
		
	}
	//8
	@Test
	public void getPersonById(){
		Person p = new Person();
		p.setId(2);
		p.setFirstName("Placek");
		p.setYob(1992);
		pm.addPersonWithId(p);
		
		Person first = pm.getPerson(p.getId());
		assertEquals(2,first.getId());
		assertEquals("Placek",first.getFirstName());
	}
	//9
	@Test 
	public void getCarById(){
		pm.addCarWithId(car1);
		Car c = pm.getCar(car1.getId());
		assertEquals(1,c.getId());
		assertEquals("BMW",c.getModel());
	
	}

	//10
	@Test
	public void checkSell() {
		Car c1 = new Car();
		c1.setModel("Syrena");
		c1.setYop(1973);
		Car c2 = new Car();
		c2.setModel("Fiat Punto");
		c2.setYop(1999);
		assertEquals(1, pm.addCar(c1));
		assertEquals(1, pm.addCar(c2));
		List<Car> cars = pm.getAllCars();
		assertTrue(cars.size() > 0);
		Car carToSell = cars.get(1);
		Person p1 = new Person();
		p1.setFirstName("Zieliński");
		p1.setYob(1978);
		Person p2 = new Person();
		p2.setFirstName("Kowalski");
		p2.setYob(1978);
		assertEquals(1, pm.addPerson(p1));
		assertEquals(1, pm.addPerson(p2));
		List<Person> persons = pm.getAllPersons();
		assertTrue(persons.size() > 1);
		Person owner = persons.get(1);
		pm.sellCar(carToSell, owner);
		Car rCar = pm.getCarWithOwner(carToSell);
		assertEquals(owner.getFirstName(), rCar.getOwner().getFirstName());
	}
	//11
	@Test
	public void getAllPersonsWithCars(){
		pm.addCarWithId(car1);
		pm.addCarWithId(car2);
		pm.addCarWithId(car3);
		pm.addPersonWithId(person1);
		pm.addPersonWithId(person2);
		
		List<Person> persons = pm.getAllPersons();
		List<Car> cars = pm.getAllCars();
		
		assertEquals(1,pm.sellCar(cars.get(0), persons.get(0)));
		assertEquals(1,pm.sellCar(cars.get(1), persons.get(0)));
		assertEquals(1,pm.sellCar(cars.get(2), persons.get(1)));
		
		Map<Person,List<Car>> m = pm.getPersonWithCar();
		
		assertEquals(2,m.size());
		assertEquals(persons.get(0),m.get(persons.get(0)).get(0).getOwner());
		assertEquals(persons.get(0),m.get(persons.get(0)).get(1).getOwner());
		assertEquals(persons.get(1),m.get(persons.get(1)).get(0).getOwner());
	}
	//12
	@Test
	public void getCarWithOwner(){
		pm.addPersonWithId(person2);
		pm.addCarWithId(car1);
		
		
		List<Person> persons = pm.getAllPersons();
		List<Car> cars = pm.getAllCars();
		assertEquals(1,pm.sellCar(cars.get(0), persons.get(0)));
		Car c = pm.getCarWithOwner(cars.get(0));
		assertEquals(persons.get(0),c.getOwner());
	}
	//13
	@Test
	public void getAllCars(){
		pm.addCarWithId(car1);
		pm.addCarWithId(car2);
		List<Car> cars = new ArrayList<>();
		cars = pm.getAllCars();
		
		assertEquals(2,cars.size());
		assertNotEquals("duplikat",cars.get(0),cars.get(1));
		assertEquals(car1.getModel(),cars.get(0).getModel());
		assertEquals(car2.getYop(),cars.get(1).getYop());
	}

}
