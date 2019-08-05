package com.wallethub.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import com.wallethub.utils.ReadFromExcel;
import com.wallethub.PageObjects.HomePage;
import com.wallethub.PageObjects.LoginPage;
import com.wallethub.PageObjects.VerifyReview;
import com.wallethub.utils.Constant;

public class VerifyLogin 

{
	
	WebDriver driver;
	LoginPage lp;
	HomePage hp;
	ChromeOptions options;
	VerifyReview vr;
		
	@BeforeClass

	//Initialization process
	
	public void setPrerequisites()
	
	{
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", Constant.Path_ChromerDriver);
	}
	
	@BeforeMethod
	public void invokeBrowser() throws Exception
	{
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test

	public void Login() throws Exception
	
	{
		/*
		Read username and password from excel file. We can update 
		the new username and password here. 
		*/
	
		driver.get(Constant.URL);
		ReadFromExcel.setExcelFile();
		String sUserName = ReadFromExcel.getCellData(0,1);
		String sPassword = ReadFromExcel.getCellData(1,1);
				
		//Login to Wallet Hub application
		
		lp = new LoginPage(driver);
		lp.userName(sUserName);
		lp.password(sPassword);
		lp.clickOnLoginButton();
				
		//Verify successful login
		
		hp = new HomePage(driver);
		Assert.assertEquals(hp.verifySuccessfulLoginText(), Constant.successfulLoginText);
		hp.clickStart();
		
	}
	
	//Verify submission of successful review comments
	
	@Test
	
	public void verifyReviewComments() throws Exception
	
	{
	
		driver.get(Constant.reviewURL);
		vr = new VerifyReview(driver);
		vr.confirmReview();
		
	}
	
	@AfterMethod
	
	//Close all browser instance(s)
	
	public void tearDown()
	
	{
	
		driver.quit();
	
	}

}


