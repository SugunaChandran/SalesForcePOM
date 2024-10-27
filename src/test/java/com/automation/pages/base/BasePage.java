package com.automation.pages.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.base.BaseTest;
import com.automation.utility.ExtentReportsUtility;

public class BasePage extends BaseTest {
	private WebDriverWait wait =null;
	protected WebDriver driver;
	protected Logger mylog = LogManager.getLogger(BasePage.class);
	protected ExtentReportsUtility extentReportUtility = ExtentReportsUtility.getInstance();
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public static void enterText(WebElement ele,String data,String objectName) {
		if(ele.isDisplayed()) {
			ele.clear();
			ele.sendKeys(data);
			System.out.println("data is entered in the "+objectName);
		}
		else{
			System.out.println(objectName+" textbox is not diplayed");
		}
	}

	public static void clickElement(WebElement ele,String objectName) {
		if(ele.isEnabled()) {
			ele.click();
			System.out.println(objectName+" button is clicked");
		}
		else{
			System.out.println(objectName+" button is not diplayed");
		}
	}

	public static void selectElement(WebElement ele,String objectName) {
		if(!ele.isSelected()) {
			ele.click();
			System.out.println(objectName+" button is selected");
		}
		else{
			System.out.println(objectName+" button is already selected");
		}
	}


	public static void selectByValue(WebElement ele,String value) {
		Select select=new Select(ele);
		select.selectByValue(value);
	}

	public static void selectByVisibleText(WebElement ele,String value) {
		Select select=new Select(ele);
		select.selectByVisibleText(value);
	}

	public static void selectByIndex(WebElement ele,int value) {
		Select select=new Select(ele);
		select.selectByIndex(value);
	}

	/*public static void mouseOverOnElement(WebElement ele,String objectName) {
	Actions action=new Actions(driver);
	action.moveToElement(ele).build().perform();
	System.out.println("cursormoved to element="+objectName);
}
public static Alert switchToAlert() {
	Alert alert=driver.switchTo().alert();
	System.out.println("switched to an alert");
	return alert;
}

public static String getalertText(Alert alert,String objectName) {
	System.out.println("extrcting text in the"+objectName+ "alert");
	String text=alert.getText();
	System.out.println("extrcting text in the"+objectName+ "alert");
	return text;
}
public static void acceptAlert(Alert alert) {
	alert.accept();
	System.out.println("Alert accepted");
}
public static void cancelAlert(Alert alert) {
	alert.dismiss();
	System.out.println("Alert cancelled");
}

public static void userDropDownList(String Option) {
	List<WebElement> childs = driver.findElements(By.xpath("//*[@id=\"userNav-menuItems\"]/a"));

	for(WebElement takeChild:childs) {
		if(takeChild.getText().equalsIgnoreCase(Option)) {
			takeChild.click();
			break;
		}

	}
}

public static void waitForVisibility1(WebElement ele,long userNameData,String ObjectName) { 
	System.out.println(ObjectName+ "waiting for visibility for maximum of "+userNameData+ "sec"); 

	wait=new WebDriverWait(driver,userNameData); 

	wait.until(ExpectedConditions.visibilityOf(ele)); 

} 

public void waitForAlertToPresent(long timeInSec,String ObjectName) { 
	System.out.println(ObjectName+ "waiting for visibility for maximum of "+timeInSec+ "sec"); 

	wait=new WebDriverWait(driver,timeInSec); 

	wait.until(ExpectedConditions.alertIsPresent()); 

} 

public static void waitForElementToClickable(WebElement ele,long timeInSec,String ObjectName) { 
	System.out.println(ObjectName+ "waiting for visibility for maximum of "+timeInSec+ "sec"); 

	wait=new WebDriverWait(driver,timeInSec); 

	wait.until(ExpectedConditions.elementToBeClickable(ele)); 

} 

public void waitForVisiTxtTobePresentInElement(WebElement ele,long timeInSec,String txt,String ObjectName) { 
	System.out.println(ObjectName+ "waiting for visibility for maximum of "+timeInSec+ "sec"); 

	wait=new WebDriverWait(driver,timeInSec); 

	wait.until(ExpectedConditions.textToBePresentInElement(ele,txt)); 

} 
	 */
}
