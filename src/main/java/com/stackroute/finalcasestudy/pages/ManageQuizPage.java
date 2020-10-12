package com.stackroute.finalcasestudy.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stackroute.finalcasestudy.utils.CommonUtils;
import com.stackroute.finalcasestudy.base.BaseClass;
import com.stackroute.finalcasestudy.utils.BrowserUtils;

public class ManageQuizPage extends BaseClass {
	public static int questionCount = 0;

	@FindBy(xpath = "//app-quizz-manager/button")
	private WebElement createQuizz;

	@FindBy(xpath = "//app-quizz-manager/h2")
	private WebElement existingQuizzes;

	@FindBy(xpath = "//app-newquizz-dialog//div/input")
	private WebElement inputQuizzName;
	
	@FindBy(xpath = "//app-quizz-manager/ul/li[1]/button")
	private WebElement firstSampleQuiz;
	
	@FindBy(xpath = "//app-quizz-manager/ul/li[4]/button")
	private WebElement newlyAddedQuiz;
	
	@FindBy(xpath = "//app-newquizz-dialog//div/input")
	private WebElement enterQuizzName;
	
	@FindBy(xpath = "//app-newquizz-dialog/button[1]")
	private WebElement okButton;
	
	public ManageQuizPage() {
		PageFactory.initElements(driver, this);
	}

	//method to check for manage page loaded after saving quiz
	public boolean checkManagePageAfterNewQuizSaved(){
		boolean isExistingQuizzesPresent = checkIfExistingQuizzesExists();
		boolean isManageQuizUrlLaunched = checkManageQuizUrl();
		boolean isNewlyAddedQuizPresent = checkNewlyAddedQuizPresent();
		return isExistingQuizzesPresent &&  isManageQuizUrlLaunched && isNewlyAddedQuizPresent;
	}
	
	//method to check for manage page loaded
	public boolean checkManageQuizPageLoaded(){
		boolean isExistingQuizzesPresent = checkIfExistingQuizzesExists();
		boolean isManageQuizUrlLaunched = checkManageQuizUrl();
		boolean isFirstSampleQuizPresent = checkIfFirstSampleQuizExists();
		return isExistingQuizzesPresent &&  isManageQuizUrlLaunched && isFirstSampleQuizPresent;
	}
	
	//Method to check existing quizzes present
	public boolean checkIfExistingQuizzesExists() {
		return BrowserUtils.checkIfElementExists(existingQuizzes);
	}
	
	//Method to check first sample quiz present
	public boolean checkIfFirstSampleQuizExists() {
		return BrowserUtils.checkIfElementExists(firstSampleQuiz);
	}
	
	//Method to check create quiz option present
	public boolean checkIfCreateQuizzExists() {
		return BrowserUtils.checkIfElementExists(existingQuizzes);
	}
	
	//Method to click on create quiz
	public ManageNewQuizPage createQuizz(){
		String newQuizName = CommonUtils.getProperty("newQuizzName");
		createQuizz.click();
		enterQuizzName.sendKeys(newQuizName);
		okButton.click();
		ManageNewQuizPage manageNewQuizPage = new ManageNewQuizPage();
		return manageNewQuizPage;
	}
	
	//method to click on the first sample quiz
	public ManageFirstSampleQuizPage clickFirstSampleQuiz() {
		firstSampleQuiz.click();
		ManageFirstSampleQuizPage manageFirstSampleQuizPage = new ManageFirstSampleQuizPage();
		return manageFirstSampleQuizPage;
	}
	
	//Method to click on newly added quiz
	public ManageNewQuizPage clickNewlyAddedQuiz(){
		newlyAddedQuiz.click();
		ManageNewQuizPage manageNewQuizPage = new ManageNewQuizPage();
		return manageNewQuizPage;
	}
	
	//Method to check newly added quiz present
	public boolean checkNewlyAddedQuizPresent(){
		String newQuizName = CommonUtils.getProperty("newQuizzName");
		return newlyAddedQuiz.getAttribute("innerText").contains(newQuizName);
		
	}
	
	//Method to check manage quiz url
	public boolean checkManageQuizUrl(){
		return BrowserUtils.getCurrentUrl().contains("manage");
	}
}
