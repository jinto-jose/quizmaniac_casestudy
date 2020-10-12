package com.stackroute.finalcasestudy.test;

import org.testng.annotations.Test;

import com.stackroute.finalcasestudy.pages.HomePage;
import com.stackroute.finalcasestudy.pages.InvalidPage;
import com.stackroute.finalcasestudy.utils.BrowserUtils;
import com.stackroute.finalcasestudy.utils.CommonUtils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import java.util.function.Consumer;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class InvalidPageTest {

	HomePage hmpage;
	InvalidPage invalidPage;
	Consumer<String> saveScreenshot = CommonUtils::saveScreenshot;

	@Test
	public void launchInvalidPageTest() {
		// Launch invalid page
		BrowserUtils.launchInvalidURL();
		invalidPage = new InvalidPage();
		// Validation of invalid page
		assertTrue(invalidPage.checkIfErrorMsgPresent());
		assertTrue(invalidPage.checkInvalidUrl());
		// Capturing start page screenshot
		saveScreenshot.accept("InvalidQuizScreen");
		// click on go to beginning
		hmpage = invalidPage.gotoHome();
		// Validate quiz maniac start page launched
		assertTrue(hmpage.checkIfWelcomeMsgPresent());
		assertTrue(hmpage.checkIfFirstSampleQuizExists());
	}

	@AfterMethod
	public void postTest(ITestResult itr) {
		// Capturing screenshots for failed scenarios
		if (!itr.isSuccess()) {
			saveScreenshot.accept(itr.getMethod().getMethodName() + "_failed");

		} else {
			Reporter.log("Test Execution Successful and hence screenshot not captured");
		}

	}

//	@BeforeClass
//	public static void setUp() {
//		BrowserUtils browserUtils = new BrowserUtils();
//		browserUtils.init();
//	}
//
//	@AfterClass
//	public void tearDown() {
//		BrowserUtils.close();
//	}

}
