package com.stackroute.finalcasestudy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stackroute.finalcasestudy.base.BaseClass;
import com.stackroute.finalcasestudy.utils.BrowserUtils;
import com.stackroute.finalcasestudy.utils.CommonUtils;

public class HomePage extends BaseClass {

	@FindBy(xpath = "//ul/li[1]/button/span")
	private WebElement firstSampleQuiz;

	@FindBy(xpath = "//h1[text()=\"Welcome to QuizzManiac!\"]")
	private WebElement welcomeMsg;

	@FindBy(xpath = "//button/span/md-icon[text()=\"add\"]")
	private WebElement createNewQuiz;

	@FindBy(xpath = "//ul/li[2]/button/span")
	private WebElement secondSampleQuiz;

	@FindBy(xpath = "//ul/li[3]/button/span")
	private WebElement thirdSampleQuiz;

	@FindBy(xpath = "//div/md-toolbar-row/button[2]")
	private WebElement manageQuizzes;

	@FindBy(xpath = "//app-newquizz-dialog//div/input")
	private WebElement enterQuizzName;

	@FindBy(xpath = "//app-newquizz-dialog/button[1]")
	private WebElement okButton;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Method to check welcome message
	public boolean checkIfWelcomeMsgPresent() {
		return BrowserUtils.checkIfElementExists(welcomeMsg);
	}

	// Method to click on create quiz
	public ManageNewQuizPage createQuizz() {
		String newQuizName = CommonUtils.getProperty("newQuizzName");
		createNewQuiz.click();
		enterQuizzName.sendKeys(newQuizName);
		okButton.click();
		ManageNewQuizPage manageNewQuizPage = new ManageNewQuizPage();
		return manageNewQuizPage;
	}

	// method to verify first sample quiz present
	public boolean checkIfFirstSampleQuizExists() {
		return BrowserUtils.checkIfElementExists(firstSampleQuiz);
	}

	// Method to check manage quizzes present
	public boolean checkIfManageQuizzesExists() {
		return BrowserUtils.checkIfElementExists(manageQuizzes);
	}

	// method to click on the first sample quiz
	public FirstSampleQuizPage clickFirstSampleQuiz() {
		firstSampleQuiz.click();
		FirstSampleQuizPage firstSampleQuizPage = new FirstSampleQuizPage();
		return firstSampleQuizPage;
	}

	// method to click on the second sample quiz
	public SecondSampleQuizPage clickSecondSampleQuiz() {
		secondSampleQuiz.click();
		SecondSampleQuizPage secondSampleQuizPage = new SecondSampleQuizPage();
		return secondSampleQuizPage;
	}

	// method to click on the third sample quiz
	public ThirdSampleQuizPage clickThirdSampleQuiz() {
		thirdSampleQuiz.click();
		ThirdSampleQuizPage thirdSampleQuizPage = new ThirdSampleQuizPage();
		return thirdSampleQuizPage;
	}

	// method to click on the Manage quizzes button
	public ManageQuizPage clickManageQuiz() {
		manageQuizzes.click();
		ManageQuizPage manageQuizPage = new ManageQuizPage();
		return manageQuizPage;
	}

	public String getCurrentUrl() {
		return BrowserUtils.getCurrentUrl();
	}
}
