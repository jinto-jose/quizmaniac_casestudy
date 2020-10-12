package com.stackroute.finalcasestudy.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.stackroute.finalcasestudy.base.BaseClass;
import com.stackroute.finalcasestudy.exception.InvalidScreenshotPathException;

public class CommonUtils extends BaseClass {

	// Method to capture screenshot
	public static void saveScreenshot(String fileName) {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
		String imagepath = System.getProperty("user.dir") + "/screenshots/" + fileName + timeStamp + ".png";
		File fileObj = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(fileObj, new File(imagepath));
		} catch (IOException e) {
			e.printStackTrace();
			throw new InvalidScreenshotPathException("Provide proper screenshot path");
		}
	}

	// Method to read properties from properties file
	public static String getProperty(String propertyName){
		return properties.getProperty(propertyName);
	}

}
