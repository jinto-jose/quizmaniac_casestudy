package com.stackroute.finalcasestudy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stackroute.finalcasestudy.base.BaseClass;
import com.stackroute.finalcasestudy.utils.BrowserUtils;

public class InvalidPage extends BaseClass {

	@FindBy(xpath = "//app-page-not-found/h3[text()=\"Sorry, the page you are looking for does not exist\"]")
	private WebElement pageNotFoundMsg;

	@FindBy(xpath = "//app-page-not-found/a")
	private WebElement gotoBeginningBtn;

	public InvalidPage() {
		PageFactory.initElements(driver, this);
	}

	// Method to check error message
	public boolean checkIfErrorMsgPresent() {
		return BrowserUtils.checkIfElementExists(pageNotFoundMsg);
	}

	// method to click on the goto beginning button
	public HomePage gotoHome() {
		gotoBeginningBtn.click();
		HomePage homePage = new HomePage();
		return homePage;
	}
	
	//Method to check invalid page url
	public boolean checkInvalidUrl() {
		return BrowserUtils.getCurrentUrl().contains("invalid");
	}
}
