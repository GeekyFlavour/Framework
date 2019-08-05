package com.wallethub.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 

//This Page is to store all locators of LoginPage

{
	WebDriver driver;
	By username = By.xpath("//input[@placeholder='Email Address']");
	By password = By.xpath("//input[@placeholder='Password']");
	By loginButton = By.xpath("//span[text()='Login']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void userName(String uid)

	{
		
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(uid);
	
	}
	
	public void password(String pass)
	
	{
	
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pass);
	
	}
	
	public void clickOnLoginButton()
	
	{
	
		driver.findElement(loginButton).click();
	
	}
				
}
