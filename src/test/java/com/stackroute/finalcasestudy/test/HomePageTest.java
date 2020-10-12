package com.stackroute.finalcasestudy.test;

import org.testng.annotations.Test;

import com.stackroute.finalcasestudy.pages.HomePage;
import com.stackroute.finalcasestudy.utils.BrowserUtils;
import com.stackroute.finalcasestudy.utils.CommonUtils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertTrue;

import java.util.function.Consumer;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class HomePageTest {

	HomePage hmpage;
	Consumer<String> saveScreenshot = CommonUtils::saveScreenshot;

	@Test
	public void launchQuizHomeTest() {
		// Launch quiz home page
		BrowserUtils.launchQuizHome();
		hmpage = new HomePage();
		// Capturing start page screenshot
		saveScreenshot.accept("startQuizScreen");
		// Validate quiz maniac start page launched
		assertTrue(hmpage.checkIfWelcomeMsgPresent());
		assertTrue(hmpage.checkIfManageQuizzesExists());
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

	@BeforeTest
	public static void setUp() {
		BrowserUtils browserUtils = new BrowserUtils();
		browserUtils.init();
	}

	@AfterTest
	public void tearDown() {
		BrowserUtils.close();
	}

}
