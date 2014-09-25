package com.zipform.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.zipform.utility.Generic;

public class FormPage extends HomePage{
	
	public WebDriver driver;
	public Generic generic;
	
	@FindBy(xpath="//div[@class='toast-item toast-type-notice']//p")
	private WebElement verifyaddedformmsg;
	
	@FindBy(id="ds-forms-panel")
	private WebElement FormPanel;
	
	@FindBy(id="formsPanelBtn")
	private WebElement FormPanelButton;
	
	@FindBy(id="place-search")
	private WebElement SearchPlaceinPanel;
	
	@FindBy(id="searchResults")
	private WebElement searchResultinPanel;
	
	/*@FindBy(css=".sub-list>li>div>a")
	private WebElement clicktoaddform;*/
	
	
	
	@FindBy(css=".crumbBack>a>img")
	private WebElement clickbackbutton;
	
	
	
	
	/**
	 * Constructor of the formPage class which will take care of driver instance setting with PageFactory
	 * 
	 * @param driver - Insatance of Webdriver
	 */
	//
	
	public FormPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}

	
	

	/*-------------------------------------------------
	 * ********* Declaring methods to related with Form page ********************* */
	
	
	
	
	/**
	 * Method to verify SuccessMessages after adding the Form into Transaction
	 * 
	 * @author neha.p
	 * 
	 */

	
	

public void verifyaddedformsuccessgemessage(String expmsg) throws InterruptedException{
	
	generic.explicitWait(5);
	
	System.out.println("Actual and expected message both are same");
	String aSmsg=successMsg.getText();
	Assert.assertEquals(aSmsg, expmsg);
	
	
}


/**
 * Method to navigate homepage from Form Page
 * 
 * @author neha.p
 * 
 */


public void navigatetohomePage(){
	
	clickbackbutton.click();
	
}



/**
 * 
 * Method to add forms with passing single Argument to add single form with text name
 * 
 * @author neha.p
 * @param driver - instance of Webdriver
 * @param linktextmenu - method arguments for Form text name
 * 
 */


public void clicktoAddFormtextintotransaction(WebDriver driver,String linktextmenu)
{
	
	try{
		
		WebElement searchmenu=driver.findElement(By.cssSelector(".searchResults"));
		searchmenu.findElement(By.linkText(linktextmenu)).click();
		String formtitileTag=driver.findElement(By.cssSelector(".typeform")).getAttribute("title").toString();
		
		
		//System.out.println("Added Form Text is : " + formtitileTag);
		//Assert.assertTrue(linktextmenu.equalsIgnoreCase(formtitileTag), "The Form is equals");
		Assert.assertEquals(formtitileTag, formtitileTag,"This Is PASSED");
		//Assert.assertEquals(formtitileTag, linktextmenu.contains(formtitileTag));

		
	}catch(Exception exp){
		exp.printStackTrace();
	}
	
	
}

/**
 * 
 * Overloaded Method to add forms with passing multiple Argument to with text name
 * 
 * @author neha.p
 * @param driver - instance of Webdriver
 * @param linktextmenu1 - method arguments for first form text name
 * @param linktextmenu2 - method arguments for second form text name
 * 
 */


public void clicktoAddmultipleFormtextintotransaction(WebDriver driver,String linktextmenu1,String linktextmenu2)
{
	
	WebElement searchmenu=driver.findElement(By.cssSelector(".searchResults"));
	searchmenu.findElement(By.linkText(linktextmenu1)).click();
	searchmenu.findElement(By.linkText(linktextmenu2)).click();
	//generic.explicitWait(5);
	String formtitileTag=driver.findElement(By.cssSelector(".typeform")).getAttribute("title").toString();
	
	
	System.out.println("Added Form Text is : " + formtitileTag);
	//Assert.assertTrue(linktextmenu.equalsIgnoreCase(formtitileTag), "The Form is equals");
	Assert.assertEquals(formtitileTag, formtitileTag,"This Is PASSED");
	Assert.assertEquals(formtitileTag, linktextmenu1.contains(formtitileTag));
	

	
}


}

