package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.baseClass.BaseClass;

public class AdactinHotelBookPage extends BaseClass {

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "last_name")
	WebElement lastName;

	@FindBy(id = "address")
	WebElement address;

	@FindBy(id = "cc_num")
	WebElement crediCardNo;

	@FindBy(id = "cc_type")
	WebElement creditCardType;

	@FindBy(id = "cc_exp_month")
	WebElement exprieMonth;

	@FindBy(id = "cc_exp_year")
	WebElement exprieYear;

	@FindBy(id = "cc_cvv")
	WebElement cvvNumber;

	@FindBy(id = "book_now")
	WebElement bookNow;

	@FindBy(id = "order_no")
	WebElement orderID;

	public AdactinHotelBookPage() {
		PageFactory.initElements(driver, this);
	}

	public void bookHotel(String fName, String lName, String BillingAddress, String cardNumber, String cardType,
			String month, String year, String cardCvvNumber) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		address.sendKeys(BillingAddress);
		crediCardNo.sendKeys(cardNumber);
		Select selectCardType = new Select(creditCardType);
		selectCardType.selectByValue(cardType);
		exprieMonth.sendKeys(month);
		exprieYear.sendKeys(year);
		cvvNumber.sendKeys(cardCvvNumber);
		bookNow.click();

	}

	public String fetchorderID() {
		String bookingId = orderID.getAttribute("value");
		System.out.println("Booking id is :" + bookingId);
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "Adactin.com - Hotel Booking Confirmation";
		Assert.assertEquals(expectedTitle, actualTitle);
		return bookingId;

	}

}
