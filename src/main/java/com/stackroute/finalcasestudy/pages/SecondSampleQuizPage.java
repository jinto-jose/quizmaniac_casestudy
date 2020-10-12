package com.stackroute.finalcasestudy.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stackroute.finalcasestudy.base.BaseClass;
import com.stackroute.finalcasestudy.utils.BrowserUtils;

public class SecondSampleQuizPage extends BaseClass {
	public static int questionCount = 0;

	@FindBy(xpath = "//app-question//md-card-title")
	private WebElement question;

	@FindBy(xpath = "//app-answer/ul/li[1]/button")
	private WebElement firstAnswer;

	@FindBy(xpath = "//app-answer/ul/li[3]/button")
	private WebElement secondAnswer;

	public SecondSampleQuizPage() {
		PageFactory.initElements(driver, this);
	}

	//Method to check question exists on the page
	public boolean checkIfQuestionExists() {
		return BrowserUtils.checkIfElementExists(question);
	}
	
	//Method to answer the quiz
	public ResultsPage answerTheQuiz() {
		questionCount++;
		firstAnswer.click();
		checkIfQuestionExists();
		questionCount++;
		secondAnswer.click();
		ResultsPage resultsPage = new ResultsPage(questionCount);
		return resultsPage;
	}

	//Method to check the quiz url
	public boolean checkSeondSampleQuizUrl(){
		return BrowserUtils.getCurrentUrl().contains("a-second-sample-quizz");
	}
}
