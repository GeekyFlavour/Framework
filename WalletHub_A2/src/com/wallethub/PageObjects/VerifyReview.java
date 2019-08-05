package com.wallethub.PageObjects;

import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.wallethub.utils.Constant;

public class VerifyReview 
{
	WebDriver driver;
			
	By userNameLocator = By.xpath("//*[@id='viewport']/header/div/nav[3]/div[1]/a[9]");
	By profileLocator = By.xpath("//*[@id='m-user']/ul/li[1]/a");
	By reviewTabLocator = By.xpath("//a[@href='/profile/vikasvardhan/reviews/']");
	By reviewTextAreaLocator_2 = By.xpath("//*[@id='review789507']/p");
	
	public VerifyReview(WebDriver driver)
	
	{
		this.driver = driver;
	}
	
	public void confirmReview() throws Exception

	{
		
		driver.findElement(reviewTabLocator).click();;
		Thread.sleep(15000);
		String actualReviewTextLocator = driver.findElement(reviewTextAreaLocator_2).getText();
		AssertJUnit.assertEquals(Constant.reviewText, actualReviewTextLocator);
	}

	
}
