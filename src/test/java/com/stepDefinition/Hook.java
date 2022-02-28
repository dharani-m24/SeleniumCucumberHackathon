package com.stepDefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.baseClass.BaseClass;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hook extends BaseClass{
	
	@After(order=1)
	public void tearDown(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
		    TakesScreenshot screen=(TakesScreenshot)driver;
			File source=screen.getScreenshotAs(OutputType.FILE);
			String path=System.getProperty("user.dir")+"\\screenshotsforfailedTestCase\\"+scenario.getName()+".png";
			File file=new File(path);
			FileUtils.copyFile(source,file);
			
			System.out.println("Screenshot is taken for failed testcase");
		    }
	}
	
	
	@After(order=0)
	public void closeBrowser() {
		BaseClass.closeBowser();
	}

}
