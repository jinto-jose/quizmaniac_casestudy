package com.stackroute.finalcasestudy.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stackroute.finalcasestudy.base.BaseClass;
import com.stackroute.finalcasestudy.utils.BrowserUtils;

public class ManageFirstSampleQuizPage extends BaseClass {
	public static int questionCount = 2;
	
	@FindBy(xpath = "//md-list/div/app-question")
	private List<WebElement> questionsList;

	@FindBy(xpath = "//label[text()=\"Quizz name \"]/../../input")
	private WebElement quizzName;

	@FindBy(xpath = "//md-list/div[2]//md-card-actions/button")
	private WebElement secondQuestionEditButton;

	@FindBy(xpath = "//md-list/div[1]//md-card-actions/button")
	private WebElement firstQuestionEditButton;
	
	@FindBy(xpath = "//md-list/div[2]//app-answer/ul/li[2]/button")
	private WebElement secondQuestionAnswer;
	
	@FindBy(xpath = "//md-list/div[2]//app-answer/ul/li[1]/button")
	private WebElement modifiedSecondQuestionAnswer;
	
	@FindBy(xpath="//md-list/div[1]//app-answer/ul/li[2]/button")
	private WebElement firstQuestionAnswer;
	
	@FindBy(xpath="//md-list/div[1]//app-answer/ul/li[4]/button")
	private WebElement modifiedFirstQuestionAnswer;
	
	@FindBy(xpath="//md-list/div[1]//app-answer/md-radio-group/md-radio-button[4]/label/div[1]")
	private WebElement modifyFirstQuestionAnswer;
	
	@FindBy(xpath="//md-list/div[2]//app-answer/md-radio-group/md-radio-button[1]/label/div[1]")
	private WebElement modifySecondQuestionAnswer;
	
	@FindBy(xpath="//app-question-list/div/button")
	private WebElement saveQuizBtn;
	
	@FindBy(xpath="//md-list/div[1]/button[2]")
	private WebElement deleteFirstQuestionBtn;
	
	public ManageFirstSampleQuizPage() {
		PageFactory.initElements(driver, this);
	}

//	manageFirstSampleQuizPage.clickFirstQuestionEditButton();
//	manageFirstSampleQuizPage.clickOnModifiedAnswerButton();
//	manageFirstSampleQuizPage.clickSecondQuestionEditButton();
//	manageFirstSampleQuizPage.clickOnModifiedSecondAnswerButton();
	
	//Method to click on first question edit button
	public void modifyFirstSampleQuiz() {
		firstQuestionEditButton.click();
		modifyFirstQuestionAnswer.click();
		secondQuestionEditButton.click();
		modifySecondQuestionAnswer.click();
	}
	
//	//Method to click on modified answer
//	public void clickOnModifiedAnswerButton() {
//		
//	}
//	
//	//Method to click on second question edit button
//	public void clickSecondQuestionEditButton() {
//		secondQuestionEditButton.click();
//	}
//	
//	//Method to click on second modified answer
//	public void clickOnModifiedSecondAnswerButton() {
//		modifySecondQuestionAnswer.click();
//	}
	
	//Method to delete first question
	public void deleteFirstQuestion() {
		deleteFirstQuestionBtn.click();
	}
	
	//method to check for first sample quiz manage page loaded
	public boolean checkManagePageForFirstSampleQuiz(){
		boolean isFirstSampleQuizPresent = checkIfFirstSampleQuizManageLoaded();
		boolean isDefaultAnswersCorrect = checkIfDefaultAnswersAreCorrect();
		boolean isFirstSampleQuizManageUrlLoaded = checkFirstSampleQuizManageUrl();
		return isFirstSampleQuizPresent &&  isDefaultAnswersCorrect && isFirstSampleQuizManageUrlLoaded;
	}
	
	//method to check for default questions for first sample quiz
	public boolean checkDeafultQuizDetailsForFirstSampleQuiz(){
		boolean isFirstSampleQuizPresent = checkIfFirstSampleQuizManageLoaded();
		boolean isDefaultQuestionsCorrect = checkTheNumberOfQuestionsCorrect();
		boolean isFirstSampleQuizManageUrlLoaded = checkFirstSampleQuizManageUrl();
		return isFirstSampleQuizPresent &&  isDefaultQuestionsCorrect && isFirstSampleQuizManageUrlLoaded;
	}
	
	//method to check for modified questions for first sample quiz
	public boolean checkModifiedQuizDetailsForFirstSampleQuiz(){
		boolean isFirstSampleQuizPresent = checkIfFirstSampleQuizManageLoaded();
		boolean isNumberOfQuestionsCorrect = checkTheNumberOfQuestionsCorrectAfterDeletion();
		boolean isFirstSampleQuizManageUrlLoaded = checkFirstSampleQuizManageUrl();
		return isFirstSampleQuizPresent &&  isNumberOfQuestionsCorrect && isFirstSampleQuizManageUrlLoaded;
	}
	
	//method to check for first sample quiz for modified answers
	public boolean checkManagePageForFirstSampleQuizModified(){
		boolean isFirstSampleQuizPresent = checkIfFirstSampleQuizManageLoaded();
		boolean isModifiedAnswersCorrect = checkIfModifiedAnswersAreCorrect();
		boolean isFirstSampleQuizManageUrlLoaded = checkFirstSampleQuizManageUrl();
		return isFirstSampleQuizPresent &&  isModifiedAnswersCorrect && isFirstSampleQuizManageUrlLoaded;
	}
	
	//Method to click on save quiz button
	public ManageQuizPage clickOnSaveQuiz() {
		saveQuizBtn.click();
		ManageQuizPage manageQuizPage = new ManageQuizPage();
		return manageQuizPage;
	}
	
	//Method to check first sample quiz for managing is loaded 
	public boolean checkIfFirstSampleQuizManageLoaded() {
		return quizzName.getAttribute("ng-reflect-model").equals("A Sample Quizz");
	}
	
	//Method to check existing answers
	public boolean checkIfDefaultAnswersAreCorrect() {
		return (firstQuestionAnswer.getAttribute("color").equals("accent") && secondQuestionAnswer.getAttribute("color").equals("accent"));
	}
	
	//Method to check number of questions
	public boolean checkTheNumberOfQuestionsCorrect() {
		return questionsList.size()==questionCount;
	}
	
	//Method to check number of questions after deletion
	public boolean checkTheNumberOfQuestionsCorrectAfterDeletion() {
		return questionsList.size()==1;
	}
	
	//Method to check modified answers
	public boolean checkIfModifiedAnswersAreCorrect() {
		return (modifiedFirstQuestionAnswer.getAttribute("color").equals("accent") && modifiedSecondQuestionAnswer.getAttribute("color").equals("accent"));
	}
	
	//Method to check  url
	public boolean checkFirstSampleQuizManageUrl(){
		return BrowserUtils.getCurrentUrl().contains("manage/a-sample-quizz");
	}
}
