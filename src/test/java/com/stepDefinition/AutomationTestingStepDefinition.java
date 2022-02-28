package com.stepDefinition;

import com.baseClass.BaseClass;
import com.pages.AutomationTestingPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AutomationTestingStepDefinition extends BaseClass {

	AutomationTestingPage testingPage;

	@Given("user have to launch browser")
	public void user_have_to_launch_browser() {

		BaseClass.launchBrowser();

		String url = properties.getProperty("automationTestingurl");
		driver.navigate().to(url);

	}

	@When("user able to click the shop and home buttons")
	public void user_able_to_click_the_shop_and_home_buttons() {
		testingPage = new AutomationTestingPage();
		testingPage.homeButton();

	}

	@When("user is able to add the product to the cart")
	public void user_is_able_to_add_the_product_to_the_cart() {
		testingPage = new AutomationTestingPage();
		testingPage.checkArrivals();
		testingPage.viewCart();
		testingPage.checkTotal();

	}

	@Then("user able to place the order")
	public void user_able_to_place_the_order() {
		testingPage = new AutomationTestingPage();
		testingPage.enterDetails();
		System.out.println("Order is Placed");

	}

}
