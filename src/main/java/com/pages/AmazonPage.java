package com.pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.BaseClass;

public class AmazonPage extends BaseClass{
	
	@FindBy(id = "nav-link-accountList")
	WebElement myAccount;
	
	@FindBy(id = "ap_email")
	WebElement emailID;
	
	@FindBy(id = "continue")
	WebElement clickContinue;
	
	@FindBy(id = "ap_password")
	WebElement password;
	
	@FindBy(id = "signInSubmit")
	WebElement signIn;
	
	@FindBy(id="nav-hamburger-menu")
	WebElement allMenu;
	
	@FindBy(xpath="//div[text()='see all']")
	WebElement seeAll;
	
	@FindBy(xpath="//div[text()='Books']")
	WebElement books;
	
	@FindBy(xpath="//a[text()='Indian Language Books']")
	WebElement selectBook;
	
	@FindBy(xpath="//strong[text()='Books in Indian languages']")
	WebElement heading;
	
	@FindBy(id="nav-logo-sprites")
	WebElement logo;
	
	

	
	public AmazonPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void signIn(String username, String pwd) {
		myAccount.click();
		emailID.sendKeys( username);
		clickContinue.click();
		password.sendKeys(pwd);
		signIn.click();
	}

	public void selectIndianBook() {
		allMenu.click();
		//seeAll.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",seeAll);
		books.click();
		selectBook.click();
		String actualtext=heading.getText();
		String expectedText="Books in Indian languages";
		Assert.assertEquals(expectedText, actualtext);
	}
	
	public WebElement getLogo() {
		return logo;
	}
}
