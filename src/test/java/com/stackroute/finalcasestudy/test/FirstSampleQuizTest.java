package com.stackroute.finalcasestudy.test;

import org.testng.annotations.Test;

import com.stackroute.finalcasestudy.pages.FirstSampleQuizPage;
import com.stackroute.finalcasestudy.pages.HomePage;
import com.stackroute.finalcasestudy.pages.ResultsPage;
import com.stackroute.finalcasestudy.utils.BrowserUtils;
import com.stackroute.finalcasestudy.utils.CommonUtils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import java.util.function.Consumer;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class FirstSampleQuizTest {
	HomePage hmpage;
	FirstSampleQuizPage firstSampleQuizPage;
	ResultsPage resultsPage;
	Consumer<String> saveScreenshot = CommonUtils::saveScreenshot;

	@Test
	public void playFirstSampleQuizTest(){
		// Click on first sample quiz
		firstSampleQuizPage = hmpage.clickFirstSampleQuiz();
		// checking for Question
		assertTrue(firstSampleQuizPage.checkFirstSampleQuizUrl());
		assertTrue(firstSampleQuizPage.checkIfQuestionExists());
		// answer the quiz
		resultsPage = firstSampleQuizPage.answerTheQuiz();
		// Capturing search page screenshot
		saveScreenshot.accept("FirstSampleQuizResultScreen");
		// Validate Quiz results
		assertTrue(resultsPage.checkQuizResuts());
		assertTrue(resultsPage.checkResultsPageUrl());
		//click on the try again button
		hmpage = resultsPage.clickTryAgain();
		//Validate quiz home page loaded
		assertTrue(hmpage.checkIfWelcomeMsgPresent());
		assertTrue(hmpage.checkIfManageQuizzesExists());
	}


	@BeforeMethod
	public void launchQuizManiac(){
		BrowserUtils.launchQuizHome();
		hmpage = new HomePage();
		hmpage.checkIfWelcomeMsgPresent();
	}

	@AfterMethod
	public void postTest(ITestResult itr){
		// Capturing screenshots for failed scenarios
		if (!itr.isSuccess()) {
			saveScreenshot.accept(itr.getMethod().getMethodName() + "_failed");

		} else {
			Reporter.log("Test Execution Successful and hence screenshot not captured");
		}

	}

//	@BeforeClass
//	public static void setUp(){
//		BrowserUtils browserUtils = new BrowserUtils();
//		browserUtils.init();
//	}
//
//	@AfterClass
//	public void tearDown() {
//		BrowserUtils.close();
//	}

}
