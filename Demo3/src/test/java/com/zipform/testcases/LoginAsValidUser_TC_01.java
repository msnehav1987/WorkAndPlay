package com.zipform.testcases;

import org.testng.annotations.Test;

import com.zipform.webpages.HomePage;
import com.zipform.webpages.LoginPage;

public class LoginAsValidUser_TC_01 extends ParentTestNGClass {

	@Test(description = "This test is about to login as valid user")
	public void LoginUser_TC_01() throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);
		generic.windowMax(driver);
		System.out.println("Entering valid User Credentials");
		loginPage.login("--", "--");

		System.out.println("Please wait while page is loading....");

		loginPage.waituntillpleasewaitLoading();
		generic.explicitWait(6);

		HomePage home = new HomePage(driver);

		System.out.println("Searched for visible text 'Please Wait' on page");
		home.isTextPresent("pleasewait");

		generic.verifyTitle(driver, "--");
		generic.explicitWait(15);

	
		loginPage.avoidloginContainer();

		generic.explicitWait(5);
		
	}

}
