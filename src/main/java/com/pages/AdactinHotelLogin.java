package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.BaseClass;





public class AdactinHotelLogin extends BaseClass{
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submitLogin;
	
	 
	
	
	
	
	
	public AdactinHotelLogin() {
		PageFactory.initElements(driver, this);
	}
	
	public void hotelLogin(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		submitLogin.click();
		String actualTitle=driver.getTitle();
		String expectedTitle="Adactin.com - Search Hotel";
		Assert.assertEquals(expectedTitle, actualTitle);
		
	}

}
