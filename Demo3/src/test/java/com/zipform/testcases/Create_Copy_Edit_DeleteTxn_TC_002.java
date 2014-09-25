package com.zipform.testcases;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.zipform.webpages.FormPage;
import com.zipform.webpages.HomePage;
import com.zipform.webpages.LoginPage;
import com.zipform.webpages.TransactionPage;

public class Create_Copy_Edit_DeleteTxn_TC_002 extends ParentTestNGClass {

	public LoginPage login;
	public FormPage formp;
	public HomePage home;
	public TransactionPage newtxn;
	@Test(groups={"g2,g3"},description = "Test method to create New Transaction")
	public void ZPS_AddNewValidTXN() throws Exception  {

		home = new HomePage(this.driver);
		
		Reporter.log("Creating a New Transaction", true);
		home.clicktoAddTXNimage();
		generic.explicitWait(7);
		newtxn = new TransactionPage(this.driver);
		newtxn.createNewTxn("Demo2");
		newtxn.navigatehomePage();
		generic.explicitWait(5);
		home.IsSeachedtextPresent("Demo2");
		generic.explicitWait(3);
		
		System.out.println("************************************* ");

	}
	
	@Test(groups={"g2"},description = "Test method to copy Transaction",dependsOnMethods = {"ZPS_AddNewValidTXN"})
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
	
	/*@Test(groups={"g2"},description = "Test method to sort Transaction",dependsOnMethods={"ZPS_copyTxn"},enabled=false)
	public void ZPS_SortTxn() throws Exception{
		
		newtxn = new TransactionPage(this.driver);
		home = new HomePage(this.driver);
		System.out.println("Sorting by Transaction name");
		generic.explicitWait(10);
		home.sortbyTransactionName();
		generic.explicitWait(4);
		
		System.out.println("************************************* ");
		
		
		
	}	*/
	
	
	@Test(groups={"g2"},description="This test is to delete transaction",dependsOnMethods={"ZPS_SortTxn"},enabled=true)
	public void ZPS_DeleteSingleTransaction() throws InterruptedException {

		home.IsSeachedtextPresent("Demo2");
		generic.explicitWait(6);
		System.out.println("Deleting added transaction");
		newtxn.DeleteExistingTransaction("Demo2");
		generic.explicitWait(3);
		
		System.out.println("************************************* ");

	}
	
	
	@Test(groups={"g2"},description = "Test method to Edit Existed Transaction",dependsOnMethods = {"ZPS_DeleteSingleTransaction"})
	public void ZPS_EditTXN() throws InterruptedException{
		
		newtxn = new TransactionPage(this.driver);
		
		System.out.println("Edit Existing Transaction....");
		generic.explicitWait(5);
		newtxn.EditTxnwithName("Demo2_EditingText");
		generic.explicitWait(3);
		
		
		
	}
	
	/*@Test(groups={"g2"},description="Test method is to delete multiple transaction",dependsOnMethods={"ZPS_copyTxn"})
	public void ZPS_DeleteTxn() throws InterruptedException {

		home = new HomePage(this.driver);
		generic.explicitWait(5);
		System.out.println("Deleting multiple transaction");
		home.clickonDeletebutton();
		generic.explicitWait(6);
		newtxn = new TransactionPage(this.driver);
		newtxn.deleteMutipleTransaction();
		generic.explicitWait(6);
		System.out.println("Verify after deleting all available Transaction from UI");
		newtxn.verifyafterDeletionmultipletransaction("No transactions.");
		
		
		

	}*/
}


