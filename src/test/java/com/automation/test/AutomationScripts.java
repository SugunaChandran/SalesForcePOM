package com.automation.test;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.Login.LoginPage;
import com.automation.pages.base.BasePage;
import com.automation.pages.forgotPage.ForgotPage;
import com.automation.pages.homePage.DashBoardPage;
import com.automation.pages.leadPage.LeadPage;
import com.automation.pages.opportunityPage.OpportunityPage;
import com.automation.utility.Constants;
import com.automation.utility.PropertiesUtility;
@Listeners(com.automation.utility.SalesForceListenerUtility.class)
public class AutomationScripts extends BaseTest {

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
		//extentReportUtility.logTestInfo("Completed test exectuion of valid_Login");

	}

	@Test(priority=2)
	public void invalid_Login() {

		String userNameData=PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES, "invalid_username");
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


		mylog.info("Completed test exectuion of valid_Login");
		
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
		mylog.info("Logout button is clicked");
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

		WebElement errEle= driver.findElement(By.xpath("//*[@id=\"error\"]\r\n"));

         Assert.assertEquals("Please check your username and password. If you still can't log in, contact your Salesforce administrator.", errEle.getText());

		mylog.info("Completed test exectuion of forgotpwd_valid");
		

	}
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
 	public void check_LeadsSelectView() {
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

  		
  		LeadPage lepage=new LeadPage(driver);
  		lepage.clickviewLeadButton();

 		Select viewEle=new Select((WebElement) lepage);	

 		List<WebElement> allOptions = viewEle.getOptions();

 		List dropDownEntries = new ArrayList<>();		
 		for (WebElement op : allOptions) {			
 			dropDownEntries.add(op.getText());  
 		}
 		String expectedStrVale = PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES, "Leadoptions");
 		List<String> expectedStr = Arrays.asList(expectedStrVale.split(","));

 		boolean testcaseStatus = true;
 		for(String str : expectedStr) {
 			if(!dropDownEntries.contains(str)) {			
 				testcaseStatus = false;
 				break;
 			}		
 		}
 		Assert.assertEquals(testcaseStatus,true);

 		mylog.info("Completed test exectuion of check_LeadsSelectView");
 		

 }
     @Test
     public void select_TodaysLead() {
 		
 		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 		
 		String userNameData=PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES, "username");
  		String passwordData=PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES, "password");
  		String viewLeadData=PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES, "viewLeadData");


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
