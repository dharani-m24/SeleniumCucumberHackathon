package com.stepDefinition;


import com.baseClass.BaseClass;
import com.pages.ZooplaPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ZooplaStepDefinition extends BaseClass{
	
	ZooplaPage page;

	@Given("^launch the browser url$")
	public void launch_the_browser_url() throws Throwable {
		
		BaseClass.launchBrowser();
		driver.get(properties.getProperty("zoourl"));
	   
	}
	
	@Then("^Input location London and click Submit$")
	public void input_location_London_and_click_Submit() throws Throwable {
	    page=new ZooplaPage();
	    page.search();
	}

	@Then("^Print all the price values in sorted order$")
	public void print_all_the_price_values_in_sorted_order() throws Throwable {
		page=new ZooplaPage();
	    page.listThePrice();
	}

	@Then("^Select the fifthth property on that list$")
	public void select_the_fifthth_property_on_that_list() throws Throwable {
		page=new ZooplaPage();
		page.selectProperty();
	}
	
	@Then("^check same present in the agent page$")
	public void check_same_present_in_the_agent_page() throws Throwable {
		page=new ZooplaPage();
		page.checkAgent();
	}


}
