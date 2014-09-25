package com.zipform.testcases;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.zipform.webpages.FormPage;
import com.zipform.webpages.HomePage;
import com.zipform.webpages.LoginPage;
import com.zipform.webpages.TransactionPage;

public class TransactionTestwithGroups extends ParentTestNGClass{
	
	public FormPage formp;
	public HomePage home;
	public TransactionPage newtxn;
	public LoginPage login;
	
	
	/* This Test will maintain the Group-1
	 * (Create,Add new form,Apply template,Apply photo Txn,Search txn)
	 * 
	 * 
	 */
	@Test(groups={"g1","g2","g3"},description = "This test to create new Transaction")
	public void ZPS_CreateNewValidTXN() throws Exception  {

		home = new HomePage(this.driver);
		
		Reporter.log("Creating a New Transaction", true);
		home.clicktoAddTXNimage();
		generic.explicitWait(7);
		newtxn = new TransactionPage(this.driver);
		newtxn.createNewTxn("Demo1");
		newtxn.navigatehomePage();
		generic.explicitWait(5);

		newtxn.isTextPresent("Demo1");
		generic.explicitWait(3);
		
		System.out.println("************************************* ");

	}
	
	@Test(groups={"g1"},description="This test is to Add form in created transacion",dependsOnMethods={"ZPS_CreateNewValidTXN"})
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
	
	
	
	
	
	
	
	@Test(groups={"g1"},description="This test is to delete transaction",dependsOnMethods={"ZPS_AddNewForm_ToTransaction"})
	public void ZPS_DeleteSingleTransaction() throws InterruptedException {

		newtxn.isTextPresent("Demo1");
		generic.explicitWait(6);
		System.out.println("Deleting added transaction");
		newtxn.DeleteExistingTransaction("Demo1");
		generic.explicitWait(3);
		
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

	
	
	@Test(groups={"g3"},description = "Test method to copy Transaction",dependsOnMethods = {"ZPS_AddNewValidTXN"})
	public void ZPS_copyTxn() throws Exception{
		
		newtxn = new TransactionPage(this.driver);
		home = new HomePage(this.driver);
		System.out.println("Copy with Existing Transaction....");
		newtxn.CopyExistingTXN("Demo2");
		home.verifydisplayMsg("Copy Successful");
		//home.explicitwaituntildisplayMessage(driver, "Copy Successful");
	    System.out.println("Copy Successfully message verified");
		generic.explicitWait(5);
		System.out.println("************************************* ");
		
	}
	
	@Test(groups={"g3"},description = "Test method to sort Transaction",dependsOnMethods={"ZPS_copyTxn"})
	public void ZPS_SortTxn() throws Exception{
		
		newtxn = new TransactionPage(this.driver);
		home = new HomePage(this.driver);
		System.out.println("Sorting by Transaction name");
		generic.explicitWait(10);
		home.sortbyTransactionName();
		generic.explicitWait(4);
		
		System.out.println("************************************* ");
		
		
		
	}
	

}
