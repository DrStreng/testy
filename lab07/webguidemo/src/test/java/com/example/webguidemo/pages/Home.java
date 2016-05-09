package com.example.webguidemo.pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Alert;

public class Home extends WebDriverPage {
	WebDriver driver;
	
	public Home(WebDriverProvider driverProvider) {
		super(driverProvider);
		driver = driverProvider.get();
	}

	public void open() {
		get("http://www.seleniumframework.com/Practiceform/");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void clickTestLink(String some) throws InterruptedException {
		Thread.sleep(200);
		findElement(By.linkText(some)).click();
	}
	
	public void clickAlertButton() throws InterruptedException{
		Thread.sleep(200);
		findElement(By.xpath("//*[@id='alert']")).click();
		
	}
	
	public String alertCheck() throws InterruptedException{
			Thread.sleep(200);
			Alert simpleAlert = driver.switchTo().alert();
			String alertText = simpleAlert.getText();
			simpleAlert.accept();
			return alertText;
	}
	
	public void clickVerButton() throws InterruptedException{
		Thread.sleep(200);
		findElement(By.xpath("//*[@id='vfb-4']")).click();
	}

	public void clearValue() throws InterruptedException {
		Thread.sleep(200);
		findElement(By.xpath("//*[@id='vfb-3']")).clear();
	}

	public void typeValue(String digits) throws InterruptedException {
		Thread.sleep(200);
		findElement(By.xpath("//*[@id='vfb-3']")).sendKeys(digits);
	}

	public String validMsg() throws InterruptedException {
		Thread.sleep(200);
		return findElement(By.xpath("//*[@id='item-vfb-2']/ul/li[1]/span/label[1]")).getText();
	}
	
	public boolean createPrSc() throws InterruptedException {
		Thread.sleep(200);
		File prsc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
			FileUtils.copyFile(prsc, new File("testlink.png"));
			return true;
		} catch (IOException e){
			e.printStackTrace();
			return false;
		}
	}

	public void clickCheckBox() throws InterruptedException {
		if ( !driver.findElement(By.xpath("//*[@id='vfb-6-0']")).isSelected() )
		{
		     driver.findElement(By.xpath("//*[@id='vfb-6-0']")).click();
		     Thread.sleep(200);
		}
		
	}

	public boolean checkBoxValid() {
		return findElement(By.xpath("//*[@id='vfb-6-0']")).isSelected();
	}

	public void clickColorButton() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id='doubleClick']"))).doubleClick().perform();
		Thread.sleep(200);
	}

	public String getColor() {
		//System.out.println(findElement(By.xpath("//*[@id='doubleClick']")).getCssValue("color"));
		return findElement(By.xpath("//*[@id='doubleClick']")).getCssValue("color");	
	}
	
	
}
