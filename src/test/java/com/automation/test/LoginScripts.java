package com.automation.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.Login.LoginPage;
import com.automation.pages.forgotPage.ForgotPage;
import com.automation.pages.homePage.DashBoardPage;
import com.automation.utility.Constants;
import com.automation.utility.PropertiesUtility;
@Listeners(com.automation.utility.SalesForceListenerUtility.class)

public class LoginScripts extends BaseTest {
	@Test(priority=1)
	public void valid_Login() {

		String userNameData=PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES, "username");
		String passwordData=PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES, "password");

		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}

		LoginPage lpage=new LoginPage(driver);
		lpage.enterUserName(userNameData);
		lpage.enterPassword(passwordData);
		lpage.clickLoginButton();


		mylog.info("Completed test exectuion of valid_Login");
		extentReportUtility.logTestInfo("Completed test exectuion of valid_Login");

	}

	@Test(priority=2)
	public void invalid_Login() {

		String userNameData=PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES, "username");
		String passwordData=PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES, "invalid_password");

		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}

		LoginPage lpage=new LoginPage(driver);
		lpage.enterUserName(userNameData);
		lpage.enterPassword(passwordData);
		lpage.clickLoginButton();

		String expectedError = "Please enter your password.";
		String actualError = lpage.getErrMessageNoPassword();

		Assert.assertEquals(actualError, expectedError, "Error message did not match!");
		mylog.info("Got expected error message");
		mylog.info("Completed test exectuion of Invalid_Login");

	}

	@Test
	public void rememberme_Login() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		

		String userNameData=PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES, "username");
		String passwordData=PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES, "password");

		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}

		LoginPage lpage=new LoginPage(driver);
		lpage.enterUserName(userNameData);
		lpage.enterPassword(passwordData);
		lpage.remCheckButton();

		lpage.clickLoginButton();

		DashBoardPage dpage=new DashBoardPage(driver);
		dpage.clickUserNavButton();

		userDropDownList("Logout");
		String expectedData = userNameData;
		String actualData = lpage.getUSerNameVisible();


		Assert.assertEquals(actualData, expectedData, "User data did not match!");
		
		
		mylog.info("Logout button is clicked");
		mylog.info("Validation successful");
		mylog.info("Completed test exectuion of rememberme_Login");


	}
	@Test
	public void forgotpwd_invalid() throws InterruptedException {	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String forgotusernameData=PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES, "forgot_username");

		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}

		LoginPage lpage=new LoginPage(driver);
		lpage.clickforgotPassLink();

		ForgotPage fpage=new ForgotPage(driver);
		fpage.enterForgotUserName(forgotusernameData);

		fpage.clickContinueButton();
		String expectedData = "Check Your Email";
		String actualData = fpage.checkEmailMsg();

		mylog.info("Validation successful");

		mylog.info("Completed test exectuion of forgotpwd_invalid");



	}

	@Test(priority=4)

	public void forgotpwd_validation() throws InterruptedException {

		String userNameData=PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES, "usernamenew");
		String passwordData=PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES, "passwordnew");

		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}

		LoginPage lpage=new LoginPage(driver);
		lpage.enterUserName(userNameData);
		lpage.enterPassword(passwordData);
		lpage.clickLoginButton();


		String expectedError = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		String actualError = lpage.getErrMessageInvalid();


		Assert.assertEquals(actualError, expectedError, "Error message did not match!");
		mylog.info("Got expected error message");
		mylog.info("Completed test exectuion of forgotpwd_valid");


	}
}

