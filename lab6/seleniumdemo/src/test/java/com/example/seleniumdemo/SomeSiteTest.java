package com.example.seleniumdemo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SomeSiteTest {

	private static WebDriver driver;
	WebElement element;

	//dla wybranej strony
	//findby
	//akcje typu radiobutton select slidery(przesuwanie) wyszukiwanie(np search pilka nozna)
	//wypelnianie formularza
	//reakcja na bledy 
	//nie tylko chodzenie pomiedzy stronami
	//prubowac w swojej technologii
	//sprawdzian napisz test ktury wejdzie tu i tu znajdzie to i to i zrobi screanschota
	//wypelnij formularz
	//sprawdz czy sie pojawil komunikat bledny komunikat
	//czy po kliknieciu gdzies pojawilo sie to i to
	//zalogowac sie z blednym haslem
	//czy pojawil sie text na stronie po wykonaniu czegos
	
	
	@BeforeClass
	public static void driverSetup() {
		// ChromeDrirver, FireforxDriver, ...
		//System.setProperty("webdriver.chrome.driver", "C:/SeleniumDrivers");
		driver = new FirefoxDriver();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void homePage(){
		driver.get("http://www.empik.com");
		element = driver.findElement(By.linkText("elektronika"));
		assertNotNull(element);
	}
	
	@Test
	public void polsatPage(){
		driver.get("http://www.empik.com/elektronika");
		driver.findElement(By.linkText("telefony")).click();
		element = driver.findElement(By.linkText("telefony"));
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    assertNotNull(screenshot);

		try {
			FileUtils.copyFile(screenshot, new File("/SeleniumDrivers/telefony.png"));// . katalog bierzacy sprubowac
		} catch (IOException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	@AfterClass
	public static void cleanp() {
		driver.quit();
	}
}
