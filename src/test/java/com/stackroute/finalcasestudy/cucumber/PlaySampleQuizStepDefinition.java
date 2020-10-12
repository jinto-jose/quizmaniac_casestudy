package com.stackroute.finalcasestudy.cucumber;

import static org.testng.Assert.assertTrue;

import java.util.function.Consumer;

import org.testng.Reporter;

import com.stackroute.finalcasestudy.pages.HomePage;
import com.stackroute.finalcasestudy.utils.BrowserUtils;
import com.stackroute.finalcasestudy.utils.CommonUtils;
import com.stackroute.finalcasestudy.pages.ResultsPage;
import com.stackroute.finalcasestudy.pages.SecondSampleQuizPage;
import com.stackroute.finalcasestudy.pages.ThirdSampleQuizPage;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PlaySampleQuizStepDefinition {
	HomePage hmpage;
	SecondSampleQuizPage secondSampleQuizPage;
	ThirdSampleQuizPage thirdSampleQuizPage;
	ResultsPage resultsPage;
	Consumer<String> saveScreenshot = CommonUtils::saveScreenshot;
	
	@After
	public void scenarioTearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			saveScreenshot.accept(scenario.getName().replace(" ", "_") + "_failed");

		} else {
			Reporter.log("Test Execution Successful and hence screenshot not captured");
		}
	}
	
	@Given("the user in quiz home page")
	public void the_user_in_quiz_home_page() {
		//launching quiz home
		BrowserUtils.launchQuizHome();
		hmpage = new HomePage();
		hmpage.checkIfWelcomeMsgPresent();
	}

	@When("clicking on second sample quiz")
	public void clicking_on_second_sample_quiz() {
		// Click on second sample quiz
		secondSampleQuizPage = hmpage.clickSecondSampleQuiz();
		// checking for Question
		assertTrue(secondSampleQuizPage.checkSeondSampleQuizUrl());
		assertTrue(secondSampleQuizPage.checkIfQuestionExists());
	}

	@When("selecting the second quiz answers")
	public void selecting_the_second_quiz_answers() {
		// answer the quiz
		resultsPage = secondSampleQuizPage.answerTheQuiz();
		// Capturing search page screenshot
		saveScreenshot.accept("SecondSampleQuizResultScreen");
	}

	@Then("second quiz results should be displayed")
	public void second_quiz_results_should_be_displayed() {
		// Validate Quiz results
		assertTrue(resultsPage.checkQuizResuts());
		assertTrue(resultsPage.checkResultsPageUrl());
	}

	@When("clicking on try again")
	public void clicking_on_try_again() {
		//click on the try again button
		hmpage = resultsPage.clickTryAgain();
	}

	@Then("quiz home page should be displayed")
	public void quiz_home_page_should_be_displayed() {
		//Validate quiz home page loaded
		assertTrue(hmpage.checkIfWelcomeMsgPresent());
		assertTrue(hmpage.checkIfManageQuizzesExists());
	}

	@Given("the user already in quiz home page")
	public void the_user_already_in_quiz_home_page() {
		hmpage = new HomePage();
		Reporter.log("User already in quiz home page");
	}

	@When("clicking on third sample quiz")
	public void clicking_on_third_sample_quiz() {
		// Click on third sample quiz
		thirdSampleQuizPage = hmpage.clickThirdSampleQuiz();
		// checking for Question
		assertTrue(thirdSampleQuizPage.checkThirdSampleQuizUrl());
		assertTrue(thirdSampleQuizPage.checkIfQuestionExists());
	}

	@When("selecting the third quiz answers")
	public void selecting_the_third_quiz_answers() {
		// answer the quiz
		resultsPage = thirdSampleQuizPage.answerTheQuiz();
		// Capturing search page screenshot
		saveScreenshot.accept("ThirdSampleQuizResultScreen");
	}

	@Then("third quiz results should be displayed")
	public void third_quiz_results_should_be_displayed() {
		// Validate Quiz results
		assertTrue(resultsPage.checkQuizResuts());
		assertTrue(resultsPage.checkResultsPageUrl());
	}
}
