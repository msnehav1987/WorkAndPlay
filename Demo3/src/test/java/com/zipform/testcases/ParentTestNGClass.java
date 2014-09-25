package com.zipform.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.zipform.utility.Generic;
import com.zipform.webpages.HomePage;
import com.zipform.webpages.LoginPage;

public class ParentTestNGClass {

	public WebDriver driver;
	public Generic generic;
	public LoginPage login;
	public HomePage home;

	@BeforeSuite(groups={"g1","g2","g3"})
	public void SetUpDriver() throws InterruptedException {
		driver = new FirefoxDriver();
		generic = new Generic();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.err.println("Launching the browser ......");
		driver.get("---");
		//generic.windowMax(driver);
		generic.explicitWait(6);
		LoginPage login = new LoginPage(driver);
		System.out.println("Entering User Credentials");
		login.login("--", "--");
		System.out.println("Please wait while page is loading....");

		login.waituntillpleasewaitLoading();
		generic.explicitWait(8);
		
		HomePage home = new HomePage(driver);
		System.out.println("Searched for visible text 'Please Wait' on page");
		home.isTextPresent("pleasewait");
		
		generic.verifyTitle(driver, "zipForm® Plus 1409.3");
		generic.explicitWait(15);
		login.avoidloginContainer();
		generic.explicitWait(6);

	}

	@AfterSuite(groups={"g1","g2","g3"})
	public void TeardownDriver() {

		System.err.println("Closing the browser......");
		generic = new Generic();
		generic.explicitWait(5);
	
		System.out.println("************************************* ");
		driver.quit();
		
	}

}
