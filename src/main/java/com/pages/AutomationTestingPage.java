package com.pages;

import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.baseClass.BaseClass;

public class AutomationTestingPage extends BaseClass {

	@FindBy(xpath = "//*[@id=\'menu-item-40\']/a")
	WebElement shop;
	@FindBy(xpath = "//a[text()='Home']")
	WebElement menu;
	@FindBy(xpath = "//*[@id='site-logo']/a/img")
	WebElement loogo;

	@FindBy(xpath = "//*[@id=\'product-165\']/div[2]/h1")
	WebElement title;

	@FindBy(xpath = "//button[text()='Add to basket']")
	WebElement basket;

	@FindBy(xpath = "//i[@class='wpmenucart-icon-shopping-cart-0']")
	WebElement cart;

	@FindBy(xpath = "//*[@id=\'page-34\']/div/div[1]/div/div/div/a")
	WebElement checkout;

	@FindBy(xpath = "//input[@id='billing_first_name']")
	WebElement namee;

	@FindBy(xpath = "//input[@id='billing_last_name']")
	WebElement last;

	@FindBy(xpath = "//input[@id='billing_email']")
	WebElement email;

	@FindBy(xpath = "//input[@id='billing_phone']")
	WebElement phn;

	@FindBy(xpath = "//input[@id='billing_address_1']")
	WebElement add;

	@FindBy(xpath = "//input[@id='billing_city']")
	WebElement city;

	@FindBy(xpath = "//input[@id='billing_postcode']")
	WebElement zip;

	@FindBy(xpath = "//input[@id='place_order']")
	WebElement place;

	@FindBy(id = "s2id_billing_state")
	WebElement selectState;

	@FindBy(id = "s2id_autogen2_search")
	WebElement selectInput;

	@FindBy(xpath = "//p[text()='Thank you. Your order has been received.']")
	WebElement OrderMessage;

	// image
	@FindBy(xpath = "//img[@alt='Selenium Ruby']")
	WebElement seleniumRuByImage;

	@FindBy(xpath = "//img[@alt='Thinking in HTML']")
	WebElement htmlImage;

	@FindBy(xpath = "//img[@alt='Mastering JavaScript']")
	WebElement masteringImage;

	// total
	@FindBy(xpath = "//table[@class='shop_table shop_table_responsive']//tr[1]//td")
	WebElement subTotal;

	@FindBy(xpath = "//table[@class='shop_table shop_table_responsive']//tr[3]//td")
	WebElement total;

	public AutomationTestingPage() {
		PageFactory.initElements(driver, this);

	}

	JavascriptExecutor js = (JavascriptExecutor) driver;

	// shop and home buttons
	public void homeButton() {
		shop.click();
		menu.click();
		// verification
		boolean logo = loogo.isDisplayed();
		Assert.assertTrue(logo);
		System.out.println("logo is verified");

	}

	public void checkArrivals() {
		ArrayList<WebElement> arrivalsImage = new ArrayList<>();
		arrivalsImage.add(seleniumRuByImage);
		arrivalsImage.add(htmlImage);
		arrivalsImage.add(masteringImage);
		int actualSize = arrivalsImage.size();
		int expectedSize = 3;
		Assert.assertEquals(expectedSize, actualSize);

		// check the arrivals navigating to next page and can add the books to his
		// basket
		for (WebElement image : arrivalsImage) {
			image.click();

			if (driver.findElements(By.xpath("//button[text()='Add to basket']")).size() != 0) {
				basket.click();

				break;
			}

			driver.navigate().back();
		}

	}

	public void viewCart() {

		// verification
		boolean view = cart.isDisplayed();
		Assert.assertTrue(view);

		// click item
		cart.click();
		// scrolling
		js.executeScript("window.scrollBy(0,100)");
		// verification

	}

	public void checkTotal() {

		String getSubTotal = subTotal.getText();
		System.out.println(getSubTotal);
		String sT = getSubTotal.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(sT);
		String getTotal = total.getText();
		System.out.println(getTotal);
		String t = getTotal.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(t);
		int sTotal = Integer.parseInt(sT);
		int finalTotal = Integer.parseInt(t);
		Assert.assertTrue(finalTotal >= sTotal);
		checkout.click();
	}

	public void enterDetails() {
		// details
		namee.sendKeys("Dharani");
		last.sendKeys("m");
		email.sendKeys("mdtest.2412@gmail.com");
		phn.sendKeys("1234567890");
		// scrolling
		js.executeScript("window.scrollBy(0,100)");
		add.sendKeys("xxx");
		city.sendKeys("Namakkal");
		selectState.click();

		selectInput.sendKeys("Tamil Nadu");
		String text = "";
		do {
			selectInput.sendKeys(Keys.ARROW_DOWN);
			text = selectInput.getAttribute("value");
			if (text.equals("Tamil Nadu")) {
				selectInput.sendKeys(Keys.ENTER);
				break;
			}

		} while (!text.isEmpty());

		zip.sendKeys("524405");
		System.out.println("Details is Added");

		// order
		js.executeScript("window.scrollBy(0,100)");
		place.click();

		String actualMessage = OrderMessage.getText();
		String expectedMessage = "Thank you. Your order has been received.";
		Assert.assertEquals(expectedMessage, actualMessage);

	}

}
