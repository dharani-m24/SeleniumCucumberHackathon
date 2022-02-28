package com.stepDefinition;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import com.baseClass.BaseClass;
import com.excelData.ReadExcelFile;
import com.pages.AmazonPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class AmazonStepDefinition extends BaseClass {
	
	AmazonPage amazonPage;
	ReadExcelFile excelData;
	
	@Given("^lauch the url$")
	public void lauch_the_url() throws Throwable {
		
		BaseClass.launchBrowser();
		driver.get(properties.getProperty("amazonurl"));
	
	    
	}

	@Given("^click on signIn button and enter the credentials$")
	public void click_on_signIn_button_and_enter_the_credentials() throws Throwable {
		amazonPage=new AmazonPage();
		excelData=new ReadExcelFile();
		 ArrayList<String> testData=excelData.getData("Sheet1","user1");
		amazonPage.signIn(testData.get(1), testData.get(2) );
		
	    
	}

	@Then("^click on books and select India language$")
	public void click_on_books_and_select_India_language() throws Throwable {
		amazonPage=new AmazonPage();
		amazonPage.selectIndianBook();
		WebElement logoImage=amazonPage.getLogo();
			File src=logoImage.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"\\reports\\logo.png";
		File file=new File(path);
		FileUtils.copyFile(src,file);
		 System.out.println("The screenshot is taken");
	}


}
