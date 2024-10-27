package com.automation.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.Login.LoginPage;
import com.automation.pages.homePage.DashBoardPage;
import com.automation.pages.opportunityPage.OpportunityPage;
import com.automation.utility.Constants;
import com.automation.utility.PropertiesUtility;

public class OpportunityScripts extends BaseTest {
	@Test
    
    public void test_OppPipelineReport() {
		
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
 		dpage.clickOppButton();
 		
 		OpportunityPage opppage=new OpportunityPage(driver);
 		opppage.clickOppPipelineButton();


		mylog.info("Completed test exectuion of test_OppPipelineReport");
		
	}
    
    @Test
    public void test_OppStuckReport() {
		
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
 		dpage.clickOppButton();
 		
 		OpportunityPage opppage=new OpportunityPage(driver);
 		opppage.clickStuckPipelineButton();

		mylog.info("Completed test exectuion of test_OppStuckReport");
		

	}
	

}


