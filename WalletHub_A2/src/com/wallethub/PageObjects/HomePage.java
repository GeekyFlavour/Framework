package com.wallethub.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import com.wallethub.utils.Constant;

public class HomePage 

//This Page is to store all locators of HomePage

{
	
	WebDriver driver;
	Actions builder;
	
	By successfulLoginTextLocator = By.xpath("//h1[text()='Test Insurance Company']");
	By star_1_Locator = By.xpath("//*[@class='rvs-star-svg' and @height='35.72'][1]");
	By star_2_Locator = By.xpath("//*[@class='rvs-star-svg' and @height='35.72'][2]");
	By star_3_Locator = By.xpath("//*[@class='rvs-star-svg' and @height='35.72'][3]");
	By star_4_Locator = By.xpath("//*[@class='rvs-star-svg' and @height='35.72'][4]");
	By star_5_Locator = By.xpath("//*[@class='rvs-star-svg' and @height='35.72'][5]");
	By dropdownLocator = By.xpath("//*[@id='reviews-section']/modal-dialog/div/div/write-review/div/ng-dropdown/div/span");
	By textHealthLocator = By.xpath("//*[@id='reviews-section']/modal-dialog/div/div/write-review/div/ng-dropdown/div/ul/li[2]");
	By reviewTextAreaLocator_1 = By.xpath("//textarea[@placeholder='Write your review...']");
	By submitLocator = By.xpath("//div[text()='Submit']");
	By confirmSubmitTextLocator = By.xpath("//span[@itemprop='author']//following::div[@data-pos='0']");
	
	String health = "Health";

	//This is the color code it returned after mouse hover. I am bit skeptical about it though.
	
	String expectedColorAfterHover = "rgba(0, 0, 0, 1)";	
			
	public HomePage(WebDriver driver)
	
	{
	
		this.driver = driver;
	
	}
	
	//To verify successful login, a text "Create Post" is taken as sign of success
	
	public String verifySuccessfulLoginText()
	
	{
	
		return driver.findElement(successfulLoginTextLocator).getText();
	
	}
		
	public void clickStart() throws Exception
		{
		
		// Create object on Actions class
	
		WebElement ele1 = driver.findElement(star_1_Locator);
		builder=new Actions(driver);
		
		// To hover on 1st star
		
		Thread.sleep(5000);
		
		// use Mouse hover action for that element
		
		builder.moveToElement(ele1).build().perform();
		Thread.sleep(5000);
	
		String actualStar_1_ColorAfterHover = ele1.getCssValue("color");
		Assert.assertEquals(actualStar_1_ColorAfterHover, expectedColorAfterHover);
		
		// To hover on 2nd star
		
		WebElement ele2 = driver.findElement(star_2_Locator);
		Thread.sleep(5000);
		
		// Use Mouse hover action for that element

		builder.moveToElement(ele2).build().perform();
		Thread.sleep(5000);
		String actualStar_2_ColorAfterHover = ele2.getCssValue("color");
		Assert.assertEquals(actualStar_2_ColorAfterHover, expectedColorAfterHover);
				
		// To hover on 3rd star
		
		WebElement ele3 = driver.findElement(star_3_Locator);
		Thread.sleep(5000);
		
		// Use Mouse hover action for that element
		
		builder.moveToElement(ele3).build().perform();
		Thread.sleep(5000);
		String actualStar_3_ColorAfterHover = ele3.getCssValue("color");
		Assert.assertEquals(actualStar_3_ColorAfterHover, expectedColorAfterHover);
			
		// To hover on 4th star
		
		WebElement ele4= driver.findElement(star_4_Locator);
		Thread.sleep(5000);

		// Use Mouse hover action for that element
		
		builder.moveToElement(ele4).build().perform();
		Thread.sleep(5000);
		String actualStar_4_ColorAfterHover = ele4.getCssValue("color");
		Assert.assertEquals(actualStar_4_ColorAfterHover, expectedColorAfterHover);
		
		// To hover on 5th star
		
		WebElement ele5 = driver.findElement(star_5_Locator);
		Thread.sleep(5000);

		// Use Mouse hover action for that element
		
		builder.moveToElement(ele5).build().perform();
		Thread.sleep(5000);
		String actualStar_5_ColorAfterHover = ele5.getCssValue("color");
		Assert.assertEquals(actualStar_5_ColorAfterHover, expectedColorAfterHover);
		
		//Click on 5th glowing star
		
		driver.findElement(star_5_Locator).click();
		Thread.sleep(5000);
		
		//Go towards submitting reviews.
		
		driver.findElement(dropdownLocator).click();
		driver.findElement(textHealthLocator).click();
		Thread.sleep(5000);
		driver.findElement(reviewTextAreaLocator_1).sendKeys(Constant.reviewText);
		Thread.sleep(5000);
		driver.findElement(submitLocator).click();
		Thread.sleep(5000);
		String actualReviewComments = driver.findElement(confirmSubmitTextLocator).getText();
		Assert.assertEquals(Constant.reviewText, actualReviewComments);
		
		}

}
	

