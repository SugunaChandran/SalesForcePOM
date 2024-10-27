package com.automation.base;

import java.io.File;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.automation.pages.base.BasePage;
import com.automation.utility.Constants;
import com.automation.utility.ExtentReportsUtility;
import com.automation.utility.PropertiesUtility;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest  {
	public static WebDriver driver=null;
	protected Logger mylog = LogManager.getLogger(BasePage.class);
	protected ExtentReportsUtility extentReportUtility = ExtentReportsUtility.getInstance();

	@BeforeMethod
	@Parameters("browser name")
	public void setUpBeforeMethod(@Optional("chrome") String name) throws InterruptedException {
		mylog.info("************setupbeforemetod**********");
		launchBrowser("chrome");
		String url=PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES,"url");
		goToUrl(url);
		
	}
	@AfterMethod
	public void tearDownAfterMethod() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);		
		closeDriver();
		mylog.info("teardown after test method");
	}

	public static void launchBrowser(String browserName) {
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;

		default:
			break;
		}
	}


	public static void goToUrl(String url) throws InterruptedException {
		driver.get(url);
		System.out.println(url + "is entered");
		Thread.sleep(5000);

	}

	public static void takeScreenShot(String path) {

	TakesScreenshot screenCapture=(TakesScreenshot)driver;
	File src= screenCapture.getScreenshotAs(OutputType.FILE);
	File destFile=new File(path);
	try {
		Files.copy(src, destFile);
		System.out.println("screen captured");
	} catch (IOException e) {
		e.printStackTrace();
		System.out.println("problem occured during screenshot taking");
	}
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


	public static void closeDriver() {
		driver.close();
	}

}


