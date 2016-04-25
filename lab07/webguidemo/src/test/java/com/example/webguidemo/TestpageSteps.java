package com.example.webguidemo;
import static org.junit.Assert.*;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.hamcrest.MatcherAssert;
import org.hamcrest.text.*;



public class TestpageSteps {
	
	private final Pages pages;
	public TestpageSteps(Pages pages) {
		this.pages = pages;
	}
	
	@Given("user is on Home page")
    public void userIsOnHomePage(){        
        pages.home().open();        
    }
 
    @When("user click some link")
    public void userClicksOnSomeLink(){        
        pages.home().clickSomeLink();
    }

    @Then("some page is shown")
    public void somePageIsShown(){
       assertEquals("Selenium Framework | Setup Visual Studio", pages.somelink().getTitle());
       assertNotNull(true);
    }
    
    @When("user click Submit")
    public void clickSubmit(){
    	pages.home().open();
    	pages.home().clickVerButton();
    }
    
    @Then("This field is required alert validator is shown")
    public void valIsReq(){
    	assertNotNull(pages.home().findValidatorMessageRequired());
    }
    
    @When("user click alert button")
    public void userClicksOnAlert() throws InterruptedException{
    	pages.home().open();
        pages.home().clickAlertButton();
    }

    @Then("alert is shown")
    public void alertCheck(){
    	//assertTrue(true);
    	assertEquals("Please share this website with your friends and in your organization.", pages.home().alertCheck());	
    }
    

}