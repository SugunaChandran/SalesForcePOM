package com.automation.pages.leadPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automation.pages.base.BasePage;

public class LeadPage extends BasePage {
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"fcf\"]")WebElement viewLeadEle;
	@FindBy(xpath="//*[@id=\"filter_element\"]/div/span/span[1]/input")WebElement viewGoButtonEle;
	@FindBy(xpath="//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input")WebElement newButtonEle;
	@FindBy(xpath="//*[@id=\"name_lastlea2\"]")WebElement lastNameEle;
	@FindBy(xpath="//*[@id=\"lea3\"]")WebElement companyEle;
	@FindBy(xpath="//*[@id=\"bottomButtonRow\"]/input[1]")WebElement saveButtonEle;

	public LeadPage(WebDriver driver) {
		super(driver);
	}

	public void clickviewLeadButton() {
		clickElement(viewLeadEle,"viewlead");
	}

	public void selectLeadByVisibleText(String data) {
		selectByVisibleText(viewLeadEle,data);
	}

	public void clickViewGoButton() {
		clickElement(viewGoButtonEle,"Go button");

	}

	public void clickLeadNewButton() {
		clickElement(newButtonEle,"new button");

	}
	public void enterLastName(String data) {
		enterText(lastNameEle,data,"Last name");

	}
	public void enterCompanyName(String data) {
		enterText(companyEle,data,"Company name");

	}
	public void clickSaveButton() {
		clickElement(saveButtonEle,"Save Button");


	}



}


