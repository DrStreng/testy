package com.example.webguidemo;

import org.jbehave.web.selenium.WebDriverProvider;

import com.example.webguidemo.pages.SomeLink;
import com.example.webguidemo.pages.Home;

public class Pages {

	private WebDriverProvider driverProvider;
	
	//Pages
	private Home home;
	private SomeLink somelink;
	// ...

	public Pages(WebDriverProvider driverProvider) {
		super();
		this.driverProvider = driverProvider;
	}

	public Home home() {
		if (home == null) {
			home = new Home(driverProvider);
		}
		return home;
	}
	
	public SomeLink somelink(){
		if (somelink == null) {
			somelink = new SomeLink(driverProvider);
		}
		return somelink;
	}
}
