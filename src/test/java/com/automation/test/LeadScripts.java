package com.automation.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.Login.LoginPage;
import com.automation.pages.homePage.DashBoardPage;
import com.automation.pages.leadPage.LeadPage;
import com.automation.utility.Constants;
import com.automation.utility.PropertiesUtility;

public class LeadScripts extends BaseTest {
	@Test
    public void check_LeadTabLink() {
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
		lpage.clickLoginButton();
		
		DashBoardPage dpage=new DashBoardPage(driver);
		dpage.clickLeadTabButton();
		
		mylog.info("Completed test exectuion of check_LeadTabLink");
		
	}

    @Test(dependsOnMethods= {"check_LeadTabLink"})
	public void check_LeadsDefaultView() {
   	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   	String userNameData=PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES, "username");
 	String passwordData=PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES, "password");
 	String viewLeadData=PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES, "leadViewvalue");
 		try {
 			Thread.sleep(3000);
 		}catch(InterruptedException e) {
 			e.printStackTrace();
 		}

 		LoginPage lpage=new LoginPage(driver);
 		lpage.enterUserName(userNameData);
 		lpage.enterPassword(passwordData);
 		lpage.clickLoginButton();
 		
 		DashBoardPage dpage=new DashBoardPage(driver);
 		dpage.clickLeadTabButton();

 		
 		LeadPage lepage=new LeadPage(driver);
 		lepage.selectLeadByVisibleText(viewLeadData);
 		
 		dpage.clickUserNavButton();
 		userDropDownList("Logout");

 		lpage.enterUserName(userNameData);
 		lpage.enterPassword(passwordData);
 		lpage.clickLoginButton();
 		dpage.clickLeadTabButton();

		mylog.info("Completed test exectuion of check_LeadsDefaultView");
				
}
    @Test
    public void check_LeadsSelectView() {
       	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       	String userNameData=PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES, "username");
     	String passwordData=PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES, "password");
     	String viewLeadData=PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES, "leadViewvalue");
     		try {
     			Thread.sleep(3000);
     		}catch(InterruptedException e) {
     			e.printStackTrace();
     		}

     		LoginPage lpage=new LoginPage(driver);
     		lpage.enterUserName(userNameData);
     		lpage.enterPassword(passwordData);
     		lpage.clickLoginButton();
     		
     		DashBoardPage dpage=new DashBoardPage(driver);
     		dpage.clickLeadTabButton();
     		
     		LeadPage lepage=new LeadPage(driver);
     		lepage.clickviewLeadButton();
     		     		
       		
    		mylog.info("Completed test exectuion of check_LeadsSelectView");
    				
    }

     		

    @Test
    public void select_TodaysLead() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String userNameData=PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES, "username");
 		String passwordData=PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES, "password");
 		String viewLeadData=PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES, "leadViewvalue");


 		try {
 			Thread.sleep(3000);
 		}catch(InterruptedException e) {
 			e.printStackTrace();
 		}

 		LoginPage lpage=new LoginPage(driver);
 		lpage.enterUserName(userNameData);
 		lpage.enterPassword(passwordData);
 		lpage.clickLoginButton();
 		
 		DashBoardPage dpage=new DashBoardPage(driver);
 		dpage.clickLeadTabButton();

 		
 		LeadPage lepage=new LeadPage(driver);
 		lepage.selectLeadByVisibleText(viewLeadData);
 		lepage.clickViewGoButton();
			
		mylog.info("Completed test exectuion of select_TodaysLead");
		
	}
    
    @Test
    public void new_TodaysLeadSave() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		String userNameData=PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES, "username");
 		String passwordData=PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES, "password");
		String leadsLastNameData=PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES, "Leads_lastName");
		String leadsCompanyData=PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES, "Leads_companyName");

		LoginPage lpage=new LoginPage(driver);
 		lpage.enterUserName(userNameData);
 		lpage.enterPassword(passwordData);
 		lpage.clickLoginButton();
 		
 		DashBoardPage dpage=new DashBoardPage(driver);
 		dpage.clickLeadTabButton();
 		
 		LeadPage lepage=new LeadPage(driver);
 		lepage.clickLeadNewButton();
 		lepage.enterLastName(leadsLastNameData);
 		lepage.enterCompanyName(leadsCompanyData);
 		lepage.clickSaveButton();
		

		mylog.info("Completed test exectuion of new_TodaysLeadSave");
		

    }
}
