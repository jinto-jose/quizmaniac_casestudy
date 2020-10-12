package com.stackroute.finalcasestudy.test;

import org.testng.annotations.Test;

import com.stackroute.finalcasestudy.pages.HomePage;
import com.stackroute.finalcasestudy.pages.ManageNewQuizPage;
import com.stackroute.finalcasestudy.pages.ManageQuizPage;
import com.stackroute.finalcasestudy.utils.BrowserUtils;
import com.stackroute.finalcasestudy.utils.CommonUtils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

import java.util.function.Consumer;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class AddNewQuizTest {

	HomePage hmpage;
	ManageNewQuizPage manageNewQuizPage;
	ManageQuizPage manageQuizPage;
	Consumer<String> saveScreenshot = CommonUtils::saveScreenshot;

	@Test
	public void addNewQuizAndVerifyTest() {
		// click on create quiz
		manageNewQuizPage = hmpage.createQuizz();
		//Validate manage new quiz launched
		assertTrue(manageNewQuizPage.verifyNewQuizLaunched());
		//Add questions
		manageNewQuizPage.clickToAddQuestions();
		//Enter questions and answers
		manageNewQuizPage.addFirstQuestionAnswer();
		manageNewQuizPage.addSecondQuestionAnswer();
		// Capturing start page screenshot
		saveScreenshot.accept("savedQuizScreen");
		//Save the quiz
		manageQuizPage = manageNewQuizPage.saveQuiz();
		// checking for manage quiz page loaded
		assertTrue(manageQuizPage.checkManagePageAfterNewQuizSaved());
		// Clicking the the newly added quiz
		manageNewQuizPage=manageQuizPage.clickNewlyAddedQuiz();
		//checking for added answers
		assertTrue(manageNewQuizPage.checkAddedQuizzDetails());
		saveScreenshot.accept("FirstSampleQuizDeletedQuestionsScreen");
	}
	
	@BeforeMethod
	public void launchQuizManiac(){
		BrowserUtils.launchQuizHome();
		hmpage = new HomePage();
		hmpage.checkIfWelcomeMsgPresent();
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
