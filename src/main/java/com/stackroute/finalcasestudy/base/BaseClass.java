package com.stackroute.finalcasestudy.base;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;

import com.stackroute.finalcasestudy.exception.PropertiesFileNotFoundException;
import com.stackroute.finalcasestudy.utils.TestDataLoader;
import com.stackroute.finalcasestudy.webdriver.WebDriverFactory;

public class BaseClass {

	protected static WebDriver driver;
	protected static Properties properties;
	public static List<Row> quizData;

	public BaseClass() {
		properties = new Properties();
		Path filePath = Paths.get("configurations", "quiz.properties");
		try {
			properties.load(Files.newInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
			throw new PropertiesFileNotFoundException("Invalid properties file path");
		}
	}

	// Method for initialization of driver and loading of test data
	public void initialization() {
//		loadProperties();
		quizData = TestDataLoader.loadQuizData();
		String browserName = properties.getProperty("browserName");
		driver = WebDriverFactory.getInstance(browserName);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	// Method for loading properties file
	public void loadProperties() {
		properties = new Properties();
		Path filePath = Paths.get("configurations", "quiz.properties");
		try {
			properties.load(Files.newInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
			throw new PropertiesFileNotFoundException("Invalid properties file path");
		}
	}

}
