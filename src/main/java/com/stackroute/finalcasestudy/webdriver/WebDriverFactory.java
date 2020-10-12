package com.stackroute.finalcasestudy.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.stackroute.finalcasestudy.exception.UnsupportedBrowserDriverException;

import io.github.bonigarcia.wdm.WebDriverManager;


/*
 * Factory to instantiate a WebDriver object. It returns an instance of the driver (local invocation).
 */
public class WebDriverFactory {

    /* Browsers constants */
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";

    private WebDriverFactory(){}

    public static WebDriver getInstance(String browserName) {

        WebDriver webDriver;

        
        if (CHROME.equals(browserName)) {
        	WebDriverManager.chromedriver().setup();
        	ChromeOptions chromeoptions = new ChromeOptions();
			chromeoptions.addArguments("--disable-notifications");
            webDriver = new ChromeDriver(chromeoptions);

           
        }else if (FIREFOX.equals(browserName)) {
        	WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();

        }
        else {
            throw new UnsupportedBrowserDriverException("Unsupported browser!");
        }

        return webDriver;
    }
}
