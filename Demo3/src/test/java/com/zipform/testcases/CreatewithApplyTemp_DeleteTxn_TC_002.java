package com.zipform.testcases;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.zipform.webpages.FormPage;
import com.zipform.webpages.HomePage;
import com.zipform.webpages.LoginPage;
import com.zipform.webpages.TransactionPage;

public class CreatewithApplyTemp_DeleteTxn_TC_002 extends ParentTestNGClass {
	public LoginPage login;
	public FormPage formp;
	public HomePage home;
	public TransactionPage newtxn;
	@Test(groups={"g2"},description = "Test method to create New with template Transaction")
	public void ZPS_CreateValidTXN() throws Exception  {

		home = new HomePage(this.driver);
		
		Reporter.log("Creating a New Transaction", true);
		home.clicktoAddTXNimage();
		generic.explicitWait(7);
		newtxn = new TransactionPage(this.driver);
		newtxn.createNewTxnwithtemplate("Demo1");
		
		newtxn.navigatehomePage();
		generic.explicitWait(5);

		newtxn.isTextPresent("Demo1");
		generic.explicitWait(3);
		
		System.out.println("************************************* ");

	}
	
	@Test(groups={"g2"},description = "Test method to Edit Existed Transaction",dependsOnMethods = {"ZPS_CreateValidTXN"})
	public void ZPS_EditTXN() throws InterruptedException{
		
		newtxn = new TransactionPage(this.driver);
		
		System.out.println("Edit Existing Transaction....");
		generic.explicitWait(5);
		newtxn.EditTxnwithName("Demo1_EditingText");
		generic.explicitWait(3);
		
		System.out.println("************************************* ");
		
	}
	
	@Test(groups={"g2"},description="Test method to Delete Transaction",dependsOnMethods={"ZPS_EditTXN"})
	public void ZPS_DeleteTxn() throws Exception{
		
		newtxn.isTextPresent("Demo1_EditingText");
		generic.explicitWait(6);

		System.out.println("Deleting Edited transaction");
		newtxn.DeleteExistingTransaction("Demo1_EditingText");
		generic.explicitWait(3);
		
		
	}

}
