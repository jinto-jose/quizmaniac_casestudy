package com.stackroute.finalcasestudy.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stackroute.finalcasestudy.base.BaseClass;
import com.stackroute.finalcasestudy.utils.BrowserUtils;
import com.stackroute.finalcasestudy.utils.CommonUtils;

public class ManageNewQuizPage extends BaseClass {

	@FindBy(xpath = "//app-question-list/md-list/button")
	private WebElement createQuestionBtn;

	@FindBy(xpath = "//label[text()=\"Quizz name \"]/../../input")
	private WebElement quizzName;
	
	@FindBy(xpath = "//md-list/div[2]//md-card/md-card-actions/button")
	private WebElement secondQuestionEditButton;

	@FindBy(xpath = "//md-list/div[1]//md-card/md-card-actions/button")
	private WebElement firstQuestionEditButton;
	
	@FindBy(xpath = "//md-list/div[1]//app-answer/md-card-actions/button")
	private WebElement firstQuestionAddAnswer;
	
	@FindBy(xpath = "//md-list/div[2]//app-answer/md-card-actions/button")
	private WebElement secondQuestionAddAnswer;
	
	@FindBy(xpath = "//md-list/div[1]//md-form-field//div/input")
	private WebElement firstQuestionTextField;
	
	@FindBy(xpath = "//md-list/div[2]//md-form-field//div/input")
	private WebElement secondQuestionTextField;
	
	@FindBy(xpath = "//md-list/div[1]//app-answer//md-radio-button[1]//div/input")
	private WebElement firstQuestionFirstAnswer;
	
	@FindBy(xpath = "//md-list/div[1]//app-answer//md-radio-button[2]//div/input")
	private WebElement firstQuestionSecondAnswer;
	
	@FindBy(xpath = "//md-list/div[2]//app-answer//md-radio-button[1]//div/input")
	private WebElement secondQuestionFirstAnswer;
	
	@FindBy(xpath = "//md-list/div[2]//app-answer//md-radio-button[2]//div/input")
	private WebElement secondQuestionSecondAnswer;
	
	@FindBy(xpath="//md-list/div[1]//app-answer/md-radio-group/md-radio-button[1]/label/div[1]")
	private WebElement selectFirstQuestionAnswer;
	
	@FindBy(xpath="//md-list/div[2]//app-answer/md-radio-group/md-radio-button[2]/label/div[1]")
	private WebElement selectSecondQuestionAnswer;
	
	@FindBy(xpath="//app-question-list/div/button")
	private WebElement saveQuizBtn;
	
	@FindBy(xpath = "//md-list/div[1]//app-answer/ul/li[1]/button")
	private WebElement firstQuestionAnswer;
	
	@FindBy(xpath="//md-list/div[2]//app-answer/ul/li[2]/button")
	private WebElement secondQuestionAnswer;
	
	public ManageNewQuizPage() {
		PageFactory.initElements(driver, this);
	}

	//Method to check for added answers
	public boolean checkAddedQuizzDetails(){
		boolean isCreateQuestionBtnExists = checkCreateQuestionBtnExists();
		boolean isNewQuizNameShowingInManagePage = checkIfNewQuizManageLoaded();
		boolean isMarkedAnswersAreCorrect = checkIfMarkedAnswersAreCorrect();
		return isCreateQuestionBtnExists && isMarkedAnswersAreCorrect && isNewQuizNameShowingInManagePage;
	}
	
	// Method to check create question option present
	public boolean checkCreateQuestionBtnExists() {
		return BrowserUtils.checkIfElementExists(createQuestionBtn);
	}
	
	//verify new quiz launched
	public boolean verifyNewQuizLaunched(){
		boolean isCreateQuestionBtnExists = checkCreateQuestionBtnExists();
		boolean isNewQuizUrlLaunched = checkNewQuizUrl();
		boolean isNewQuizNameShowingInManagePage = checkIfNewQuizManageLoaded();
		return isCreateQuestionBtnExists && isNewQuizUrlLaunched && isNewQuizNameShowingInManagePage;
	}

	//Method to check new quiz for managing is loaded 
	public boolean checkIfNewQuizManageLoaded() {
		String newQuizName = CommonUtils.getProperty("newQuizzName");
		return quizzName.getAttribute("ng-reflect-model").equals(newQuizName);
	}
	
	//Method to add questions in new quiz
	public void clickToAddQuestions() {
		createQuestionBtn.click();
		createQuestionBtn.click();
	}
	
	//Method to add first question and answers
	public void addFirstQuestionAnswer(){
		String firstQuestion = quizData.get(0).getCell(0).getStringCellValue();
		String firstQuestionAnswer1 = quizData.get(0).getCell(1).getStringCellValue();
		String firstQuestionAnswer2 = quizData.get(0).getCell(2).getStringCellValue();
		firstQuestionEditButton.click();
		firstQuestionTextField.sendKeys(firstQuestion);
		//Add answers
		firstQuestionAddAnswer.click();
		firstQuestionAddAnswer.click();
		firstQuestionFirstAnswer.sendKeys(firstQuestionAnswer1);
		firstQuestionSecondAnswer.sendKeys(firstQuestionAnswer2);
		selectFirstQuestionAnswer.click();
		firstQuestionEditButton.click();
	}
	
	//Method to add second question and answers
	public void addSecondQuestionAnswer(){
		String secondQuestion = quizData.get(1).getCell(0).getStringCellValue();
		String secondQuestionAnswer1 = quizData.get(1).getCell(1).getStringCellValue();
		String secondQuestionAnswer2 = quizData.get(1).getCell(2).getStringCellValue();
		secondQuestionEditButton.click();
		secondQuestionTextField.sendKeys(secondQuestion);
		//Add answers
		secondQuestionAddAnswer.click();
		secondQuestionAddAnswer.click();
		secondQuestionFirstAnswer.sendKeys(secondQuestionAnswer1);
		secondQuestionSecondAnswer.sendKeys(secondQuestionAnswer2);
		selectSecondQuestionAnswer.click();
		secondQuestionEditButton.click();
	}
	
	//Method to click on save quiz button
	public ManageQuizPage saveQuiz() {
		saveQuizBtn.click();
		ManageQuizPage manageQuizPage = new ManageQuizPage();
		return manageQuizPage;
	}
	
	//Method to check marked answers are correct
	public boolean checkIfMarkedAnswersAreCorrect() {
		String actualAnswer1 = quizData.get(0).getCell(3).getStringCellValue();
		String actualAnswer2 = quizData.get(1).getCell(3).getStringCellValue();
		boolean isAnswer1Matching = (firstQuestionAnswer.getAttribute("color").equals("accent") && firstQuestionAnswer.getAttribute("innerText").equals(actualAnswer1));
		boolean isAnswer2Matching = (secondQuestionAnswer.getAttribute("color").equals("accent") && secondQuestionAnswer.getAttribute("innerText").equals(actualAnswer2));
		return (isAnswer1Matching && isAnswer2Matching);
	}
	
	//Method to check new quiz url
	public boolean checkNewQuizUrl() {
		String newQuizName = CommonUtils.getProperty("newQuizzName").toLowerCase();
		return BrowserUtils.getCurrentUrl().contains(newQuizName);
	}
}
