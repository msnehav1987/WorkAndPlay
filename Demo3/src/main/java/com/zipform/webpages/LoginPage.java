package com.zipform.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {

	public WebDriver driver;
	public WebDriverWait wait;

	@FindBy(id = "login-usr")
	private WebElement unTextBox;

	@FindBy(id = "login-pwd")
	private WebElement pwdTextBox;

	@FindBy(id = "btnLogin")
	private WebElement loginButton;

	@FindBy(xpath = "//div[@class='toast-container toast-position-top-center']")
	private WebElement errMsgElement;

	@FindBy(id = "pleasewait")
	private WebElement pleasewaittoload;

	@FindBy(id = "forgotUsernameLink")
	private WebElement forgotlink;

	@FindBy(id = "forgotPasswordLink")
	private WebElement forgotpwdlink;

	@FindBy(id = "login-ctls")
	private WebElement logincontainer;

	
	/*
	 * //-----------------------------------------------------------//------------
	 * --------------------------------//--------------------------------------
	 * --
	 * ------------------------------------------------------------------------
	 * ----------//
	 */
	/**
	 * Login page constructor,Will take care of driver instance
	 * 
	 * @author neha.p
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Login page with Overloaded method of arguments
	 * 
	 * @author neha.p
	 * 
	 */

	public void login(String un, String pwd) throws InterruptedException {
		unTextBox.clear();
		unTextBox.sendKeys(un);
		Thread.sleep(1000);
		pwdTextBox.clear();
		pwdTextBox.sendKeys(pwd);
		loginButton.click();

	}

	/**
	 * Method to verification for error messsage displayed
	 * 
	 * @author neha.p
	 * 
	 */

	public void verifyErrMsg(String errmsg)

	{
		if (errMsgElement.isDisplayed()) {
			String aErrMsg = errMsgElement.getText();
			Assert.assertEquals(aErrMsg, errmsg);
		}

	}

	/**
	 * Method to verification that given Text is Present in UI
	 * 
	 * @author neha.p
	 * 
	 */

	public void verifyTextPresence_pleaseWait() {

		if (driver.getPageSource().contains("pleasewait")) {
			System.err.println("Text is present");
		} else {
			System.err.println("Text is absent");
		}
	}

	/**
	 * Method to Delete the cookies of the browser
	 * 
	 * @author neha.p
	 * 
	 */

	public void deletecookies() {

		driver.manage().deleteAllCookies();
	}

	/**
	 * Method to verification that 'forgotlink' is Present in UI
	 * 
	 * @author neha.p
	 * 
	 */
	public void isElementpresent_forgotlink() {

		if (forgotlink.isDisplayed()) {
			System.out.println("Element is found");
		} else {
			System.out.println("Element not found");
		}
	}

	/**
	 * Method to verification that 'forgotpwdlink' is Present in UI
	 * 
	 * @author neha.p
	 * 
	 */

	public void isElementpresent_forgotpwdlink() {

		if (forgotpwdlink.isDisplayed()) {
			System.out.println("Element is found");
		} else {
			System.out.println("Element not found");
		}
	}

	/**
	 * Method to webdriverwait to load pleasewait control in login page
	 * 
	 * @author neha.p
	 * 
	 */

	public void waituntillpleasewaitLoading() {

		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("pleasewait")));

	}
	
	

	/**
	 * Method to verify when display loginContainer Panel After login into Application
	 * 
	 * @author neha.p
	 * 
	 */

	public void isDisplayLoginContainer() throws InterruptedException {

		if (logincontainer.isDisplayed()) {

			Thread.sleep(5000);
			pwdTextBox.clear();
			pwdTextBox.sendKeys("password");

			loginButton.click();

			WebElement feedbacknote = driver.findElement(By
					.id("releaseNotesDialog"));
			WebElement continuebutton = driver.findElement(By
					.cssSelector("#continueToApp>a>img"));

			Thread.sleep(10000);
			feedbacknote.isDisplayed();
			continuebutton.click();

		} else {

			WebElement feedbacknote = driver.findElement(By
					.id("releaseNotesDialog"));
			WebElement continuebutton = driver.findElement(By
					.cssSelector("#continueToApp>a>img"));

			Thread.sleep(10000);
			feedbacknote.isDisplayed();
			continuebutton.click();

		}

		// driver.findElement(By.cssSelector("#continueToApp>a>img"));
	}

	
	

	/**
	 * Method to click on Transaction header menu Link to avoid Login Container Panel
	 * 
	 * @author neha.p
	 * 
	 */
	public void avoidloginContainer() throws InterruptedException {

		Thread.sleep(7000);
		//driver.findElement(By.id("mnuTransactions")).click();
		Thread.sleep(2000);
		WebElement feedbacknote = driver.findElement(By
				.id("releaseNotesDialog"));
		WebElement continuebutton = driver.findElement(By
				.cssSelector("#continueToApp>a>img"));
		Thread.sleep(10000);
		if (feedbacknote.isDisplayed()) {
			System.out.println("Continue with application....");
			continuebutton.click();
		}
		else{
			driver.findElement(By.id("mnuTransactions")).click();
		}

	}

}