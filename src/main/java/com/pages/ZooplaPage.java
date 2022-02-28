package com.pages;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.BaseClass;



public class ZooplaPage extends BaseClass{
	
	@FindBy(id="header-location")
	WebElement searchLocation;
	
	@FindBy(xpath="//button[text()='Search']")
	WebElement searchBtn;
	
	
	public ZooplaPage() {
		PageFactory.initElements(driver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public void search() throws InterruptedException {
		//search for london location
		searchLocation.sendKeys("London");
		String text = "";
		do {
			searchLocation.sendKeys(Keys.ARROW_DOWN);
			text = searchLocation.getAttribute("value");
			if (text.equals("London")) {
				searchLocation.sendKeys(Keys.ENTER);
				break;
			}

		} while (!text.isEmpty());
		
		//click search btn
		Thread.sleep(3000);
		searchBtn.click();
		
		
		
	}
	
	public void listThePrice() throws InterruptedException {
		
		Thread.sleep(5000);
//		
//		String actualTitle=driver.getTitle();
//		String expectedTitle="Property for Sale in London - Buy Properties in London - Zoopla";
//		Assert.assertEquals(expectedTitle, actualTitle);
		
//		String price=driver.findElement(By.xpath("//p[@size]")).getText();
//		System.out.println("hi"+price);
		//WebElement image=driver.findElement(By.xpath("(//img[@src])[12]"));
		
		
		
		List<WebElement> priceAll=driver.findElements(By.xpath("//p[@size]"));
		
		   
		TreeSet<String> priceList=new TreeSet<>();
		for(WebElement propertyPrice : priceAll){
			
			String price=propertyPrice.getText();
			
			priceList.add(price);
			
			
			
		}
		
		TreeSet<String> res = (TreeSet<String>)priceList.descendingSet();
		
		Iterator<String> iterator=res.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	public void selectProperty() {
		WebElement image=driver.findElement(By.xpath("//*[text()='3 bed town house for sale']"));
		js.executeScript("arguments[0].click();", image);
	}
	public void checkAgent() {

		WebElement agentPage=driver.findElement(By.xpath("//*[text()='View agent properties']"));
		agentPage.click();
		
		if(driver.findElements(By.xpath("//*[text()='3 bed town house for sale']")).size()!=0) {
			
			System.out.println("Agent Page also has same property");
			
		}
	}

}
