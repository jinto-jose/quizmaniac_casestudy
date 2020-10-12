package com.stackroute.finalcasestudy.utils;


import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stackroute.finalcasestudy.base.BaseClass;

public class BrowserUtils extends BaseClass {

	public static WebDriverWait wait;

	// Method for web driver initialization
	public void init() {
		initialization();
		wait = new WebDriverWait(driver, 10);
	}

	//Quit the browser driver
	public static void close() {
		driver.quit();
	}

	//Launch the quiz
	public static void launchQuizHome(){
		driver.get(CommonUtils.getProperty("homeURL"));
	}
	
	//Launch invalid URL
	public static void launchInvalidURL(){
		driver.get(CommonUtils.getProperty("invalidURL"));
	}
	
	//Get current url
	public static String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	//Check an element present
	public static boolean checkIfElementExists(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (TimeoutException e) {
			e.printStackTrace();
			return false;
		}

	}

}
