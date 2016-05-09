package com.example.webguidemo;
import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;



public class TestpageSteps {
	
	private final Pages pages;
	public TestpageSteps(Pages pages) {
		this.pages = pages;
	}
	
	@Given("user is on Home page")
    public void userIsOnHomePage(){        
        pages.home().open();        
    }
    @When("user click $some link")
    public void userClicksOnSomeLink(String some) throws AWTException, InterruptedException { 
    	Robot robot = new Robot();
    	robot.keyPress(KeyEvent.VK_END);
    	robot.keyRelease(KeyEvent.VK_END);
        pages.home().clickTestLink(some);
    }
    @When("user click Submit")
    public void clickSubmit() throws InterruptedException, AWTException{
    	pages.home().open();
    	Robot robot = new Robot();
    	robot.keyPress(KeyEvent.VK_END);
    	robot.keyRelease(KeyEvent.VK_END);
    	pages.home().clickVerButton();
    }
    @When("user types $digits in field")
    public void typeText(String digits) throws InterruptedException{
    	pages.home().clearValue();
    	pages.home().typeValue(digits);
    }
    @When("user click alert button")
    public void userClicksOnAlert() throws InterruptedException{
    	pages.home().open();
        pages.home().clickAlertButton();
    }
    @When("user click on change color button")
    public void colorButton() throws AWTException, InterruptedException{
    	pages.home().open();
    	Robot robot = new Robot();
    	robot.keyPress(KeyEvent.VK_DOWN);
    	robot.keyRelease(KeyEvent.VK_DOWN);
    	pages.home().clickColorButton();
    }
    @When("user click on checkBox")
    public void clickCheckBox() throws AWTException, InterruptedException{
    	pages.home().open();
    	Robot robot = new Robot();
    	robot.keyPress(KeyEvent.VK_END);
    	robot.keyRelease(KeyEvent.VK_END);
    	pages.home().clickCheckBox();
    }
    @Then("color is $color")
    public void checkColor(String color){
    	assertEquals(color,pages.home().getColor());
    }
    @Then("Setup Visual Studio page is shown")
    public void somePageIsShown(){
       assertEquals("Selenium Framework | Setup Visual Studio", pages.somelink().getTitle());  
    }
    @Then("create PrSc")
    public void createPrSc() throws InterruptedException{
    	assertTrue(pages.home().createPrSc());
    }
    @Then("msg validation show $msg")
    public void errorValid(String msg) throws InterruptedException{
    	assertEquals(msg, pages.home().validMsg());
    }
    @Then("user pass a validation")
    public void passValid() throws InterruptedException{
    	pages.home().clickVerButton();
    	assertNotNull(pages.verLink().checkElement());
    }
    @Then("alert is shown")
    public void alertCheck() throws InterruptedException{
    	assertEquals("Please share this website with your friends and in your organization.", pages.home().alertCheck());	
    }
    @Then("checkBox is selected")
    public void checkBoxValid(){
    	assertTrue(pages.home().checkBoxValid());
    }
}
