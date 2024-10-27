package com.automation.pages.homePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.pages.base.BasePage;

public class DashBoardPage  extends BasePage {
	@FindBy(xpath="//*[@id=\"Opportunity_Tab\"]/a")WebElement oppButtonEle;
	@FindBy(xpath="//*[@id=\"Lead_Tab\"]/a")WebElement leadButtonEle;
	@FindBy(xpath="//*[@id=\\\"Contact_Tab\\\"]/a")WebElement contactButtonEle;
	@FindBy(id="Account_Tab")WebElement account_TabEle;
	@FindBy(id="userNav")WebElement userNavEle;
	@FindBy(xpath="//*[@id=\"Lead_Tab\"]/a")WebElement leadEle;


	public DashBoardPage(WebDriver driver) {
		super(driver);
	}

	public void clickOppButton() {
		clickElement(oppButtonEle,"Opportunity Tab");
	}

	public void clickContactButton() {
		clickElement(contactButtonEle,"contact Tab");
	}
	public void clickAccButton() {
		clickElement(account_TabEle,"account Tab");
	}
	public void clickUserNavButton() {
		clickElement(userNavEle,"user nav button");
	}
	public void clickLeadTabButton() {
		clickElement(leadEle,"login button");
	}

}
