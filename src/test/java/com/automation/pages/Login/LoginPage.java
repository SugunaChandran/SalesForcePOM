package com.automation.pages.Login;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.base.BaseTest;
import com.automation.pages.base.BasePage;


public class LoginPage extends BasePage {
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"username\"]")WebElement usernameEle;
	@FindBy(id="password")WebElement pwdEle;
	@FindBy(name="Login")WebElement loginButtonEle;
	@FindBy(xpath="//*[@id=\"rememberUn\"]")WebElement remCheckEle;
	@FindBy(xpath="//*[@id=\"forgot_password_link\"]")WebElement forgotPassLinkEle;
	@FindBy(xpath="//*[@id=\"error\"]")WebElement errNoPassEle;
	@FindBy(xpath="//*[@id=\\\"error\\\"]\\r\\n")WebElement errEle;
	@FindBy(xpath="//*[@id=\"idcard-identity\"]")WebElement usernameIdEle;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
			
	public void enterUserName(String data) {
		enterText(usernameEle,data,"User Name");
	}

	public void enterPassword(String data) {
	   enterText(pwdEle,data,"password");
	}
	public void clickLoginButton() {
	  clickElement(loginButtonEle,"login button");
	}
	
	public void remCheckButton() {
	 clickElement(remCheckEle,"login button");
	}

	public void clickforgotPassLink() {
	 clickElement(forgotPassLinkEle,"login button");
	}
	
	public String getErrMessageNoPassword() {
        return errNoPassEle.getText();
    }
	public String getErrMessageInvalid() {
        return errNoPassEle.getText();
    }
	public String getUSerNameVisible() {
        return usernameIdEle.getText();
    }
}
