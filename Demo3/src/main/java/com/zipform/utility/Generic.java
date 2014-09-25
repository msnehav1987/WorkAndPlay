package com.zipform.utility;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Generic {

	
	/**
	 * Method to verify title of webPage where as actual should be match with expected message
	 * 
	 * @author neha.p
	 * @param driver - Instance of WebDriver
	 * @param eTitle - Passing String Arguments of Expected title of web page
	 * @throws InterruptedException
	 * 
	 */
	
	public void verifyTitle(WebDriver driver,String eTitle) throws InterruptedException
	
	{
		String aTitle=driver.getTitle();
		//aTitle =aTitle.replaceAll("[^zipForm� Plus], ", "");
		
		Thread.sleep(2000);
		Assert.assertEquals(aTitle,eTitle);
	}
	
	
	/**
	 * Method to give explicit wait during actions
	 * 
	 * @author neha.p
	 * @param durationInSec - given the time in seconds to wait for action
	 * 
	 */
	public void explicitWait(int durationInSec)
	{
		try {
			Thread.sleep(1000*durationInSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to maximize the window
	 * 
	 * @author neha.p
	 * @param driver - Instance of Webdriver
	 * @throws InterruptedException
	 * 
	 */
	
	public void windowMax(WebDriver driver) throws InterruptedException{
		Thread.sleep(7000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		
	}
	
	
   
}
