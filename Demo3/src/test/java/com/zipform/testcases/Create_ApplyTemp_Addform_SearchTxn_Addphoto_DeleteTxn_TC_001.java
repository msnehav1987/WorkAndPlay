package com.zipform.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.zipform.webpages.FormPage;
import com.zipform.webpages.HomePage;
import com.zipform.webpages.TransactionPage;

public class Create_ApplyTemp_Addform_SearchTxn_Addphoto_DeleteTxn_TC_001 extends ParentTestNGClass {
	
	
	public FormPage formp;
	public HomePage home;
	public TransactionPage newtxn;
	
	
	@Test(groups={"g1"},description = "Test method to create New with template Transaction")
	public void ZPS_CreateNewValidTXN() throws Exception  {

		home = new HomePage(this.driver);
		
		Reporter.log("Creating a New Transaction with apply template", true);
		home.clicktoAddTXNimage();
		generic.explicitWait(7);
		newtxn = new TransactionPage(this.driver);
		newtxn.createNewTxnwithtemplate("Demo1");
		newtxn.verifydisplaySuccessgemessage("Form - .Arizona Association Cover Sheet was successfully added.");
		
		newtxn.navigatehomePage();
		generic.explicitWait(3);

		IsSeachedtextPresent("Demo1");
		generic.explicitWait(3);
		
		System.out.println("************************************* ");

	}
	
	@Test(groups={"g1"},description="This test is to Add form in created transacion",dependsOnMethods={"ZPS_CreateNewValidTXN"},enabled=true)
	public void ZPS_AddNewForm_ToTransaction() throws InterruptedException {

		Reporter.log("Re-Opening Added Transaction", true);
		newtxn = new TransactionPage(this.driver);
		newtxn.ClicktoReopenTxn();
				
		generic.explicitWait(2);

		System.out.println("Adding the forms to this Transaction .....");

		generic.explicitWait(5);
        formp = new FormPage(this.driver);
		formp.clicktoAddFormtextintotransaction(this.driver,
				"Buyer Contingency Addendum - 02/2014");
		generic.explicitWait(3);
		System.out.println("Navigating to home Page ......");
		newtxn.navigatehomePage();
		generic.explicitWait(3);
		System.out.println("************************************* ");

	}
	
	//Please add here code to ADD photo
	
	@Test(groups={"g1"},description="This test method to search with text and verify after searched",dependsOnMethods={"ZPS_AddNewForm_ToTransaction"},enabled=true)
	public void SearchTransaction() throws Exception {
		generic.explicitWait(5);
		home.searchbyElementwithvalidname("Demo1");
		generic.explicitWait(3);
		IsSeachedtextPresent("Demo1");
		generic.explicitWait(5);
		home.closeSearch();
		System.out.println("************************************* ");
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
	    System.out.println("Searched for text : " +bodyElement.getText());
	    Assert.assertEquals(bodyElement.getText(), txnname);
	    return bodyElement.getText().contains(txnname);
	    
	    
	}
	
	
	

	
	@Test(groups={"g1"},description="This test is to delete transaction",dependsOnMethods={"SearchTransaction"},enabled=true)
	public void ZPS_DeleteSingleTransaction() throws InterruptedException {

		IsSeachedtextPresent("Demo1");
		generic.explicitWait(6);
		System.out.println("Deleting added transaction");
		newtxn.DeleteExistingTransaction("Demo1");
		generic.explicitWait(3);
		
		

	}
	

}

	