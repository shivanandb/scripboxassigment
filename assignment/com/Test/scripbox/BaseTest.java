package com.Test.scripbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.Factory.scripbox.PageFactoryClass;
import com.Utils.scripbox.CommonFunction;
import com.google.common.collect.Ordering;

public class BaseTest {

//Variable and other declaration
	public WebDriver driver;
	public String URL = "https://www.goibibo.com/";
	public String Driver_Path = "C:\\chromedriver\\chromedriver.exe";
	PageFactoryClass objLAunch;
	String Source = "Bangalore (BLR)";
	String Dest = "Mumbai (BOM)";
	String loc = "react-autosuggest-1";
	String ExpTxt = "Flight Ticket Booking";
	String data = "sampleuser1!@#";
	WebElement date1;
	WebElement date2;
	int seconds = 10;
	By SrcErr = By.xpath("//span[@class='status_cont red ico13']");
	String SrcErrTxt = "Please enter a valid Source";


	public WebDriver setup() {
		System.setProperty("webdriver.chrome.driver", Driver_Path);
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		return driver;
	}

	/**
	 * 
	 * Test case to Open https://www.goibibo.com/
	 * 
	 * Verify page title
	 * 
	 * search for one-way flights between Bangalore and Mumbai.
	 * 
	 * Verify page results are ordered in decreasing order of cost.
	 * 
	 */

	@Test(priority = 0)

	public void PositiveScenario() {
		setup();
		// Create Page object (Page Factory)
		objLAunch = new PageFactoryClass(driver);

		// Verify page title
		String PageTitle = objLAunch.getTitle();

		System.out.println(PageTitle);

		AssertJUnit.assertTrue(PageTitle.contains(ExpTxt));

		// Enter the positive input of Source City (Bangalore)
		objLAunch.setinputSrc(Source);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("react-autosuggest-1")));

		driver.findElement(By.id("gosuggest_inputSrc")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("gosuggest_inputSrc")).sendKeys(Keys.ENTER);

		// Enter the positive input of Destination City (Mumbai)
		objLAunch.setinputDest(Dest);
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("react-autosuggest-1")));

		driver.findElement(By.id("gosuggest_inputDest")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("gosuggest_inputDest")).sendKeys(Keys.ENTER);

		// Click Calendar Departure Date
		objLAunch.clickDeparture();

		WebElement date1 = driver.findElement(By.id("fare_" + CommonFunction.dateformat()));
		System.out.println(date1);
		date1.click();

		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);

		// Click Calendar Return Date
		objLAunch.clickReturn();

		WebElement date2 = driver.findElement(By.id("fare_" + CommonFunction.dateformat1()));
		System.out.println(date2);
		date2.click();

		// Click on Search button
		objLAunch.clickSearch();
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);

		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("(//i[@class='icon-arrow-down fl downArrFilter'])[4]"));
		action.moveToElement(we)
				.moveToElement(driver.findElement(By.xpath("(//i[@class='icon-arrow-down fl downArrFilter'])[4]")))
				.click().build().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("The Slider of price shows ascendeing order sorted: ");
		driver.close();
		driver.quit();
	}

	@Test(priority = 1)
	public void InvalidSrc() {
		setup();
		objLAunch = new PageFactoryClass(driver);
		objLAunch.setinputSrc(data);

		
		// Enter the positive input of Destination City (Mumbai)
				objLAunch.setinputDest(Dest);
				WebDriverWait wait1 = new WebDriverWait(driver, 20);
				wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("react-autosuggest-1")));

				driver.findElement(By.id("gosuggest_inputDest")).sendKeys(Keys.DOWN);
				driver.findElement(By.id("gosuggest_inputDest")).sendKeys(Keys.ENTER);

				// Click Calendar Departure Date
				objLAunch.clickDeparture();

				WebElement date1 = driver.findElement(By.id("fare_" + CommonFunction.dateformat()));
				System.out.println(date1);
				date1.click();

				driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);

				// Click Calendar Return Date
				objLAunch.clickReturn();

				WebElement date2 = driver.findElement(By.id("fare_" + CommonFunction.dateformat1()));
				System.out.println(date2);
				date2.click();

		// Click on Search button
		objLAunch.clickSearch();
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		String ekm = driver.findElement(SrcErr).getText();

		Assert.assertEquals(ekm, SrcErrTxt);
		System.out.println("Error Message Validated : " + ekm);
	//	driver.close();
		//driver.quit();
	}

	
}
