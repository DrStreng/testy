package restAssuredTests.tests;

import static com.jayway.restassured.RestAssured.delete;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.DatabaseUnitException;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.example.restservicedemo.domain.Car;
import com.example.restservicedemo.domain.Person;
import com.example.restservicedemo.service.PersonManager;
import com.jayway.restassured.RestAssured;

import restAssuredTests.service.ServiceMockRESTDB;

public class DefaultRESTDB {
	
	private static IDatabaseConnection connection ;
	private static IDatabaseTester databaseTester;
	ServiceMockRESTDB service = new ServiceMockRESTDB();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/restservicedemo/api";
		
		Connection jdbcConnection;
		jdbcConnection = DriverManager.getConnection(
				"jdbc:hsqldb:hsql://localhost/workdb", "sa", "");
		connection = new DatabaseConnection(jdbcConnection);
		
		databaseTester = new JdbcDatabaseTester(
				"org.hsqldb.jdbcDriver", "jdbc:hsqldb:hsql://localhost/workdb", "sa", "");
		IDataSet dataSet = new FlatXmlDataSetBuilder().build(
				new FileInputStream(new File("src/test/resources/fullData.xml")));
		databaseTester.setDataSet(dataSet);
		databaseTester.onSetup();
	}
	
	@Before
	public void setUpBeforeTest() throws Exception {
		IDataSet dataSet = new FlatXmlDataSetBuilder().build(
				new FileInputStream(new File("src/test/resources/fullData.xml")));
		databaseTester.setDataSet(dataSet);
		databaseTester.onSetup();
		
	}
	
	@After
	public void shouldClearPersons(){
		service.clearCars();
		service.clearPersons();
	}
	
	@Test
	public void shouldAddPersonData() throws SQLException, MalformedURLException, DatabaseUnitException{
		service.addPersonData("Bonio", 10, 1987);
		service.addPersonData("Janko", 1, 1234);
		
		IDataSet dbDataSet = connection.createDataSet();
		ITable actualTable = dbDataSet.getTable("PERSON");
		ITable filteredTable = DefaultColumnFilter.excludedColumnsTable
				(actualTable, new String[]{"ID"});
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(
				new File("src/test/resources/personData.xml"));
		ITable expectedTable = expectedDataSet.getTable("PERSON");
		Assertion.assertEquals(expectedTable, filteredTable);
	}
	
	@Test
	public void shouldAddCarData() throws SQLException, MalformedURLException, DatabaseUnitException{
		service.addCarData("Fiat", 2, 1987);
		service.addCarData("Janko", 4, 1234);
		
		IDataSet dbDataSet = connection.createDataSet();
		ITable actualTable = dbDataSet.getTable("CAR");
		ITable filteredTable = DefaultColumnFilter.excludedColumnsTable
				(actualTable, new String[]{"ID"});
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(
				new File("src/test/resources/carData.xml"));
		ITable expectedTable = expectedDataSet.getTable("CAR");
		Assertion.assertEquals(expectedTable, filteredTable);
	}
	
	@Test
	public void shouldClearCars(){
		service.clearCars();
	}
	
	@Test
	public void shouldSellCar() throws Exception{
		Car p1 = new Car();
		p1.setId(10);
		p1.setModel("Ford");
		p1.setYop(1999);
		
		service.addCarData(p1.getModel(), p1.getId(), p1.getYop());
		List<Car> carToSell = new ArrayList<Car>();
		carToSell.add(p1);
		
		Person p = new Person();
		p.setId(10);
		p.setFirstName("Placek");
		p.setYob(2000);
	
		service.addPersonData(p.getFirstName(),p.getId() ,p.getYob());
		
		List<Person> owner = new ArrayList<Person>();
		owner.add(p);
		
		service.sellCar(carToSell.get(0).getId(),owner.get(0).getId());
		
		IDataSet dbDataSet = connection.createDataSet();
		ITable actualTable = dbDataSet.getTable("CAR");
		ITable filteredTable = DefaultColumnFilter.excludedColumnsTable
				(actualTable, new String[]{"ID"});
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(
				new File("src/test/resources/CarOwner.xml"));
		ITable expectedTable = expectedDataSet.getTable("CAR");

		Assertion.assertEquals(expectedTable, filteredTable);
		
	}
	@Ignore
	@Test
	public void shouldGetPersonData(){
		service.addPersonData("Banek", 1, 1987);
		service.getPersonData("1");
	}
	
	@Ignore
	@Test
	public void shouldGetCarData(){
		service.getCarData("1");
	}
	
	@Test
	public void shouldGetAllPersons(){
		service.clearPersons();
		
		Person p1 = new Person();
		p1.setId(1);
		p1.setFirstName("Janek");
		p1.setYob(1999);
		
		Person p2 = new Person();
		p2.setId(2);
		p2.setFirstName("Placek");
		p2.setYob(2000);
		
		Person p3 = new Person();
		p3.setId(3);
		p3.setFirstName("Placek");
		p3.setYob(2000);
	
		service.addPersonData(p1.getFirstName(),p1.getId() ,p1.getYob());
		service.addPersonData(p2.getFirstName(),p2.getId() ,p2.getYob());
		service.addPersonData(p3.getFirstName(),p3.getId() ,p3.getYob());
		
		List<Person> myList = new ArrayList<Person>();
		myList.add(p1);
		myList.add(p3);
		myList.add(p2);
		
		service.getAllPersonsData(myList);
	}
	
	@Test
	public void shouldGetAllCars(){
		service.clearCars();
		
		Car c1 = new Car();
		c1.setId(1);
		c1.setModel("Ford");
		c1.setYop(1999);
		
		Car c2 = new Car();
		c2.setId(2);
		c2.setModel("Ford");
		c2.setYop(1999);
		
		service.addCarData(c1.getModel(), c1.getId(), c1.getYop());
		service.addCarData(c2.getModel(), c2.getId(), c2.getYop());
		
		List<Car> myList = new ArrayList<Car>();
		myList.add(c1);
		myList.add(c2);

		service.getAllCarsData(myList);
	}
	
	@Test
	public void shouldGetCarWithOwner(){
		Car p1 = new Car();
		p1.setId(15);
		p1.setModel("Mazda");
		p1.setYop(2007);
		
		service.addCarData(p1.getModel(), p1.getId(), p1.getYop());
		List<Car> carToSell = new ArrayList<Car>();
		carToSell.add(p1);
		
		Person p = new Person();
		p.setId(23);
		p.setFirstName("Dawid");
		p.setYob(1993);
	
		service.addPersonData(p.getFirstName(),p.getId() ,p.getYob());
		
		List<Person> owner = new ArrayList<Person>();
		owner.add(p);
		
		service.sellCar(carToSell.get(0).getId(),owner.get(0).getId());
		
		service.shouldGetCarWithOwner(15,p1,p);

	}
	
	
	
	
}
