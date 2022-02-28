package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.baseClass.BaseClass;

public class TakeScreenShot extends BaseClass {
	
	public static String getscreenshotpath(String Testcasename) throws IOException {
		TakesScreenshot screen=(TakesScreenshot)driver;
		File source=screen.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"\\reports\\"+Testcasename+".png";
		File file=new File(path);
		FileUtils.copyFile(source,file);
		 System.out.println("The screenshot is taken");
		return path;
	}

}
