package com.automation.pages.forgotPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.pages.base.BasePage;

public class ForgotPage extends BasePage {
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"un\"]")WebElement forgotusernameEle;
	@FindBy(xpath="//*[@id=\"continue\"]\r\n")WebElement continueEle;
	@FindBy(xpath="//*[@id=\"header\"]")WebElement checkemailEle;

	public ForgotPage(WebDriver driver) {
		super(driver);
	}
	public void enterForgotUserName(String data) {
	 enterText(forgotusernameEle,data,"Forgot User Name");
	}
	
	public void clickContinueButton() {
		clickElement(continueEle,"login button");
	}
	
	public String checkEmailMsg() {
        return checkemailEle.getText();
    }
}



