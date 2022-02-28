package com.stepDefinition;

import java.util.ArrayList;

import com.baseClass.BaseClass;
import com.excelData.ReadExcelFile;

import com.pages.AdactinHotelBookPage;
import com.pages.AdactinHotelLogin;
import com.pages.AdactinHotelSearchPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class AdactinHotelStepDefinition extends BaseClass{
	
	AdactinHotelLogin loginPage;
	AdactinHotelSearchPage searchPage;
	AdactinHotelBookPage bookPage;
	ReadExcelFile excelData;
	
	@Given("^launch the hotel url$")
	public void launch_the_hotel_url() throws Throwable {
		
		BaseClass.launchBrowser();
		driver.get(properties.getProperty("hotelurl"));
	   
	}

	@Given("^Enter the credentials$")
	public void enter_the_credentials() throws Throwable {
	   loginPage=new AdactinHotelLogin();
	   excelData=new ReadExcelFile();
	   ArrayList<String> testData=excelData.getData("Sheet2","userhotel");
	   loginPage.hotelLogin(testData.get(1), testData.get(2));
	}

	@Then("^enter the feilds to search hotel$")
	public void enter_the_feilds_to_search_hotel() throws Throwable {
		searchPage=new AdactinHotelSearchPage();
		excelData=new ReadExcelFile();
		 ArrayList<String> testData=excelData.getData("Sheet2","userhotel");
		 searchPage.searchHotel(testData.get(3),testData.get(4), testData.get(5), testData.get(6),testData.get(7),testData.get(8),
				 testData.get(9));
		 searchPage.selectHotel();
	}
	
	@Then("^enter the mandatory feilds to book the hotel$")
	public void enter_the_mandatory_feilds_to_book_the_hotel() throws Throwable {
		bookPage=new AdactinHotelBookPage();
		
		excelData=new ReadExcelFile();
		 ArrayList<String> testData=excelData.getData("Sheet2","userhotel");
		 bookPage.bookHotel(testData.get(10), testData.get(11), testData.get(12), testData.get(13), testData.get(14), testData.get(15),
				 testData.get(16), testData.get(17));
	}

	@Then("^fetch the order no$")
	public void fetch_the_order_no() throws Throwable {
		bookPage=new AdactinHotelBookPage();
		
		bookPage.fetchorderID();
			
	}


}
