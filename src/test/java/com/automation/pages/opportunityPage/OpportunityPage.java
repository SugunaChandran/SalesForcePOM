package com.automation.pages.opportunityPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class OpportunityPage extends BasePage {

		@FindBy(xpath="//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[1]/a")WebElement optPipeLineEle;
		@FindBy(xpath="//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[2]/a")WebElement stuckPipeLineEle;
	
	
	public OpportunityPage(WebDriver driver) {
		super(driver);
	}
			
	
	public void clickOppPipelineButton() {
		clickElement(optPipeLineEle,"Opportunity pipeline");
	}
	
	public void clickStuckPipelineButton() {
		clickElement(optPipeLineEle,"Opportunity pipeline");
	}

		
}
