package com.stackroute.finalcasestudy.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stackroute.finalcasestudy.base.BaseClass;
import com.stackroute.finalcasestudy.utils.BrowserUtils;

public class ResultsPage extends BaseClass {
	private int questionCount;

	@FindBy(xpath = "//md-icon[@ng-reflect-class-base=\"correct\"]")
	private List<WebElement> correctAnswersList;
	
	@FindBy(xpath = "//app-quizz-results/div/button")
	private WebElement tryAgainBtn;

	public ResultsPage(Integer questionCount) {
		PageFactory.initElements(driver, this);
		this.questionCount = questionCount;
	}

	//Method to check quiz results
	public boolean checkQuizResuts() {
		return correctAnswersList.size()==questionCount;
	}
	
	//Method to click try again
	public HomePage clickTryAgain() {
		tryAgainBtn.click();
		HomePage homePage = new HomePage();
		return homePage;
	}

	//Method to check results page url
	public boolean checkResultsPageUrl(){
		return BrowserUtils.getCurrentUrl().contains("result");
	}
}
