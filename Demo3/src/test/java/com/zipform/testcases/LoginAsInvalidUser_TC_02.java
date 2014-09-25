package com.zipform.testcases;

import org.testng.annotations.Test;

import com.zipform.webpages.LoginPage;

public class LoginAsInvalidUser_TC_02 extends ParentTestNGClass {

	@Test(description = " This method is about to login as Invalid user into Application")
	public void Login_Invalid() throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);
		generic.windowMax(driver);
		System.out.println("Entering invalid login credentials");
		loginPage.login("", "");
		generic.explicitWait(7);

		System.out.println("Verifying the error message displayed in UI");
		loginPage.verifyErrMsg("Invalid Login Information");
	
		}
}
