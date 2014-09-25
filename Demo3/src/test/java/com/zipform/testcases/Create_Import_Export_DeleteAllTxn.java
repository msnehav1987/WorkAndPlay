package com.zipform.testcases;

import org.testng.annotations.Test;

import com.zipform.webpages.FormPage;
import com.zipform.webpages.HomePage;
import com.zipform.webpages.LoginPage;
import com.zipform.webpages.TransactionPage;

public class Create_Import_Export_DeleteAllTxn extends ParentTestNGClass {
	
	public LoginPage login;
	public FormPage formp;
	public HomePage home;
	public TransactionPage newtxn;
	@Test(groups={"g3"},description = "Test method to Import transaction",dependsOnMethods = {"ZPS_AddNewValidTXN"})
	public void ZPS_ImportTXN() throws Exception  {

		   home = new HomePage(this.driver);
	       System.out.println("Importing transaction into application");
		   home.importTransaction();
		   System.out.println("********************************************");

	}
	
	
	

}
