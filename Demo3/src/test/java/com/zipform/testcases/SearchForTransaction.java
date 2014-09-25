package com.zipform.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;





public class SearchForTransaction extends ParentTestNGClass {

	public LoginPage login;
	public FormPage formp;
	public HomePage home;
	public TransactionPage newtxn;

	@Test(description="This test method to search with text and verify after searched")
	public void SearchTransaction() throws Exception {
		generic.explicitWait(5);
		home.searchbyElementwithvalidname("Demo1");
		generic.explicitWait(3);
		IsSeachedtextPresent("Demo1");
		generic.explicitWait(3);
		
	}
	

	/**
	 * Method to verify the searched text into UI from Home Page
	 * 
	 * @author neha.p
	 * @param txnname-input for transaction name to search
	 */
	
	public boolean IsSeachedtextPresent(String txnname)
	{
	    WebElement bodyElement = driver.findElement(By.xpath("//*[contains(text(),'" +txnname+ "')]"));
	    System.out.println("Searched for available text : " +bodyElement.getText());
	    Assert.assertEquals(bodyElement.getText(), txnname);
	    return bodyElement.getText().contains(txnname);
	    
	    
	}
	

}
