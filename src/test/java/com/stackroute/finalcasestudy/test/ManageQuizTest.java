package com.stackroute.finalcasestudy.test;

import org.testng.annotations.Test;

import com.stackroute.finalcasestudy.pages.HomePage;
import com.stackroute.finalcasestudy.pages.ManageFirstSampleQuizPage;
import com.stackroute.finalcasestudy.pages.ManageNewQuizPage;
import com.stackroute.finalcasestudy.pages.ManageQuizPage;
import com.stackroute.finalcasestudy.utils.BrowserUtils;
import com.stackroute.finalcasestudy.utils.CommonUtils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import java.util.function.Consumer;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class ManageQuizTest {

	HomePage hmpage;
	ManageQuizPage manageQuizPage;
	ManageFirstSampleQuizPage manageFirstSampleQuizPage;
	ManageNewQuizPage manageNewQuizPage;
	Consumer<String> saveScreenshot = CommonUtils::saveScreenshot;

	@Test(priority=1)
	public void modifyFirstSampleQuiz(){
		// Click on manage quiz
		manageQuizPage = hmpage.clickManageQuiz();
		// checking for manage quiz page loaded
		assertTrue(manageQuizPage.checkManageQuizPageLoaded());
		// Clicking the the first sample quiz
		manageFirstSampleQuizPage=manageQuizPage.clickFirstSampleQuiz();
		//checking for first sample quiz manage page loaded
		assertTrue(manageFirstSampleQuizPage.checkManagePageForFirstSampleQuiz());
		saveScreenshot.accept("FirstSampleQuizDefaultAnswersScreen");
		// Modify question answers and save the quiz
		manageFirstSampleQuizPage.modifyFirstSampleQuiz();
		manageQuizPage = manageFirstSampleQuizPage.clickOnSaveQuiz();
		// checking for manage quiz page loaded
		assertTrue(manageQuizPage.checkManageQuizPageLoaded());
		// Clicking the the first sample quiz and check for the modified answers
		manageFirstSampleQuizPage=manageQuizPage.clickFirstSampleQuiz();
		assertTrue(manageFirstSampleQuizPage.checkManagePageForFirstSampleQuizModified());
		saveScreenshot.accept("FirstSampleQuizModifiedAnswersScreen");
	}

	@Test(priority=2)
	public void deleteQuestionFromFirstSampleQuiz(){
		// Click on manage quiz
		manageQuizPage = hmpage.clickManageQuiz();
		// checking for manage quiz page loaded
		assertTrue(manageQuizPage.checkManageQuizPageLoaded());
		// Clicking the the first sample quiz
		manageFirstSampleQuizPage=manageQuizPage.clickFirstSampleQuiz();
		//checking for first sample quiz manage page loaded
		assertTrue(manageFirstSampleQuizPage.checkDeafultQuizDetailsForFirstSampleQuiz());
		saveScreenshot.accept("FirstSampleQuizDefaultQuestionsScreen");
		// Delete first question and save the quiz
		manageFirstSampleQuizPage.deleteFirstQuestion();
		manageQuizPage = manageFirstSampleQuizPage.clickOnSaveQuiz();
		// checking for manage quiz page loaded
		assertTrue(manageQuizPage.checkManageQuizPageLoaded());
		// Clicking the the first sample quiz and check the question is deleted
		manageFirstSampleQuizPage=manageQuizPage.clickFirstSampleQuiz();
		assertTrue(manageFirstSampleQuizPage.checkModifiedQuizDetailsForFirstSampleQuiz());
		saveScreenshot.accept("FirstSampleQuizDeletedQuestionsScreen");
	}
	
	@Test(priority=3)
	public void createQuizAndVerify(){
		// Click on manage quiz
		manageQuizPage = hmpage.clickManageQuiz();
		// checking for manage quiz page loaded
		assertTrue(manageQuizPage.checkManageQuizUrl());
		assertTrue(manageQuizPage.checkIfExistingQuizzesExists());
		//Create a new quiz
		manageNewQuizPage = manageQuizPage.createQuizz();
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
		saveScreenshot.accept("QuizListAfterNewlyAddedQuiz");
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
