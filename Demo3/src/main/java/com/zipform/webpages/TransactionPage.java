package com.zipform.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TransactionPage extends HomePage {

	public WebDriver driver;

	@FindBy(id = "btnTxnNewHeader")
	private WebElement AddTxnheaderIamge;

	@FindBy(id = "txtTranHName1")
	private WebElement TxnnameTextBox;

	@FindBy(xpath = "//div[@role='dialog']//span[text()='Save']")
	private WebElement savebutton;
	
	
	@FindBy(css = ".crumbBack>a>img")
	private WebElement clickbackbutton;

	@FindBy(id = "rd_TxnType1")
	private WebElement defaultRadioButton_TXNtype;

	@FindBy(id = "rd_PropType1")
	private WebElement defaultRadioButton_PRPtype;

	@FindBy(id = "dvApplyTemplate")
	private WebElement verifyApplyTemplate;

	@FindBy(xpath = "//div[@role='dialog']//span[text()='Close']")
	private WebElement closebutton;

	@FindBy(xpath = "//div[contains(@class,'dvUpload1')]//a[@class='jqTransformSelectOpen']")
	private WebElement DropdownList_ApplyTemplate;

	@FindBy(xpath = "//div[@class='toast-container toast-position-top-center']//p")
	private WebElement verifyMsgElement;

	/*
	 * @FindBy(xpath="//div[@id='TransactionList']//a[@class='first']") private
	 * WebElement menubuttonIntxn;
	 */

	@FindBy(xpath = "//div[@id='transactionListPopup']//span[text()='View/Edit Details']")
	private WebElement viewEditTextInTxn;

	@FindBy(xpath ="//div[@id='dvOptions']/div/div/a")
	private WebElement applytempdropdownListbutton;

	/*
	 * @FindBy(xpath="//div[@id='TransactionList']/div[1]/div") private
	 * WebElement reopenAddedTXN;
	 */

	@FindBy(xpath = "//div[@id='dvOptions']//a[@index='3']")
	private WebElement applyTemplatebyIndex;

	@FindBy(xpath = "//div[@id='transactionListPopup']//span[text()='Copy']")
	private WebElement copyTxnText;

	@FindBy(xpath = "//div[@role='dialog']//span[text()='Copy']")
	private WebElement copyButton;

	@FindBy(xpath = "//div[@id='transactionListPopup']//span[text()='Delete']")
	private WebElement deleteTxnText;

	@FindBy(xpath = "//div[@role='dialog']//span[text()='Delete']")
	private WebElement deletebuttonIndialogBox;

	// ---------------------------------Defining Methods related to respective
	// pages ---------------------------------------------

	/**
	 * Constructor of the Transaction Page which will take care of driver
	 * instance setting with PageFactory
	 * @author neha.p
	 * @param driver
	 *            - Insatance of Webdriver
	 */
	//

	public TransactionPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Method to Create new Transation with passing Arguments
	 * @author neha.p
	 * @param TxnName
	 *            - given name of transaction
	 */

	public void createNewTxn(String TxnName) throws InterruptedException {
		AddTxnheaderIamge.click();
		TxnnameTextBox.clear();
		TxnnameTextBox.sendKeys(TxnName);
		Thread.sleep(2000);
		savebutton.click();
	}
	
	
	/**
	 * Method to Create new Transation with template
	 * @author neha.p
	 * @param TxnName
	 *            - given name of transaction
	 */
	
	public void createNewTxnwithtemplate(String TxnName) throws InterruptedException {
		AddTxnheaderIamge.click();
		TxnnameTextBox.clear();
		TxnnameTextBox.sendKeys(TxnName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='dvOptions']/div/div/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='dvOptions']//a[@index='3']")).click();
		Thread.sleep(3000);
		savebutton.click();
	}
	
	
	
	
	/**
	 * Method to Create new Transation without saveing the transaction with passing Arguments
	 * @author neha.p
	 * @param TxnName
	 *            - given name of transaction
	 */
	
	
	public void addTxnWithoutSave(String TxnName) throws InterruptedException {
		AddTxnheaderIamge.click();
		Thread.sleep(2000);
		TxnnameTextBox.clear();
		TxnnameTextBox.sendKeys(TxnName);
		Thread.sleep(2000);
		closebutton.click();
	}
	
	
	

	/**
	 * Method to verify failure message when giving wrong input
	 * @author neha.p
	 * @param eSmsg
	 *            - given expected message which should be display in UI
	 */

	
	
	public void verifydisplayfailedmessage(String eSmsg) {
		// String aSmsg=verifyMsgElement.getText();

		// String amsg = "Missing or Invalid Data:Please enter name!";

		String str1 = "Missing or Invalid Data:Please enter name!";
		String str2 = "Please enter name!";

		/*
		 * String[] strarray = amsg.split(":");
		 * 
		 * System.out.println("strarray.size: " + strarray.length);
		 * strarray[0]="Missing or Invalid Data";
		 * strarray[1]="Please enter name!";
		 */
		boolean s = str1.toLowerCase().contains(str2.toLowerCase());

		/*
		 * String str = String.valueOf(s);
		 * System.out.println("boolean b1 in string form is " + str);
		 * 
		 * for( String str: strarray){
		 * 
		 * System.out.println(str);
		 * 
		 * Assert.assertEquals(str, eSmsg); }
		 */

		// boolean avalue = aSmsg.contains("Missing or Invalid Data:");

		Assert.assertTrue(s);

	}

	/**
	 * Method to navigate to home page from Form page
	 * @author neha.p
	 * @param
	 */

	public void navigatehomePage() throws InterruptedException {

		Thread.sleep(2000);
		clickbackbutton.click();
		Thread.sleep(2000);

	}

	/**
	 * Method to re-open added New Transaction
	 * @author neha.p
	 * @param
	 */
	//
	public void ClicktoReopenTxn() throws InterruptedException {

		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By
				.xpath("//div[@id='TransactionList']/div[1]/div"));
		Thread.sleep(5000);
		action.moveToElement(we).click().perform();

	}

	/**
	 * Over-ride Method to verify Added transaction Text is Present on page in
	 * UI
	 * 
	 * @param textvalue
	 *            - Passing the text value which need to verify
	 */
	//

	// verify added txn text present on page
	@Override
	public boolean isTextPresent(String textvalue) {

		if (!driver.findElement(By.tagName("a")).getText().contains(textvalue)) {
			System.out.println("verifyTextPresent passed");
		}
		return false;

	}

	/**
	 * Method to verify successge message Present on page in UI
	 * @author neha.p
	 * @param emsg
	 *            - Passing the expected text message which need to verify with
	 *            actual message
	 */
	//

	public void verifydisplaySuccessgemessage(String emsg)
			throws InterruptedException {

		String aSmsg = verifyMsgElement.getText();
        System.out.println("Actual message is : "+ aSmsg);
		Assert.assertEquals(aSmsg, emsg);

	}

	/**
	 * Method to Edit the existing Transaction by given new name
	 * @author neha.p
	 * @param Newname
	 *            - Passing the new name which need to be edit with existing
	 *            transaction
	 */
	//

	public void EditTxnwithName(String Newname) throws InterruptedException {

		Thread.sleep(3000);
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By
				.xpath("//div[@id='TransactionList']/div[1]/div"));
		action.moveToElement(we);

		WebElement dropButton = driver.findElement(By
				.xpath("//div[@id='TransactionList']/div[1]/div/div[1]/a"));
		action.moveToElement(dropButton);
		action.click().perform();

		Thread.sleep(3000);

		viewEditTextInTxn.click();
		TxnnameTextBox.clear();
		TxnnameTextBox.sendKeys(Newname);
		Thread.sleep(2000);
		savebutton.click();

	}

	/**
	 * Method to apply Template With New Transaction
	 * @author neha.p
	 * @param TxnName
	 *            - Passing the transaction name which need to be apply template
	 *            with transaction
	 */

	public void ApplyTemplatewithNewTxn(String TxnName)
			throws InterruptedException {
		Thread.sleep(2000);
		AddTxnheaderIamge.click();
		TxnnameTextBox.clear();
		TxnnameTextBox.sendKeys(TxnName);
		Thread.sleep(3000);
		applytempdropdownListbutton.click();
		Thread.sleep(3000);
		applyTemplatebyIndex.click();
		Thread.sleep(3000);
		savebutton.click();
	}

	/**
	 * Method to create a copy transaction after creating a new transaction
	 * @author neha.p
	 * @param newTxnname
	 *            - Passing the new transaction name which need to be make a
	 *            copy of transaction
	 */
	//

	public void CopyExistingTXN(String newTxnname) throws InterruptedException {

		Thread.sleep(5000);
		// System.err.println("Creating a copy of Existing Transaction");

		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By
				.xpath("//div[@id='TransactionList']/div[1]/div"));
		action.moveToElement(we);
		Thread.sleep(3000);
		WebElement dropButton = driver.findElement(By
				.xpath("//div[@id='TransactionList']/div[1]/div/div[1]/a"));
		action.moveToElement(dropButton);
		action.click().perform();

		Thread.sleep(3000);

		copyTxnText.click();
		Thread.sleep(5000);
		copyButton.click();
		

	}

	/**
	 * Method to Delete created transaction
	 * 
	 * @author neha.p
	 * @param newTxnname
	 *            - Passing the new transaction name which need to be make a
	 *            copy of transaction
	 * @throws InterruptedException
	 */
	//

	public void DeleteExistingTransaction(String TxnName)
			throws InterruptedException {

		Thread.sleep(5000);

		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By
				.xpath("//div[@id='TransactionList']/div[1]/div"));
		action.moveToElement(we);
		Thread.sleep(3000);
		WebElement dropButton = driver.findElement(By
				.xpath("//div[@id='TransactionList']/div[1]/div/div[1]/a"));
		action.moveToElement(dropButton);
		action.click().perform();

		Thread.sleep(3000);

		deleteTxnText.click();
		Thread.sleep(2000);
		deletebuttonIndialogBox.click();
		Thread.sleep(2000);

	}
	
	/**
	 * Method to Delete Multiple transaction
	 * 
	 * @author neha.p
	 */
	
	public void deleteMutipleTransaction() throws InterruptedException{
		
		 Thread.sleep(5000);
		 
		
       driver.findElement(By.id("selectAllBtn")).click();
       Thread.sleep(3000);
       driver.findElement(By.id("confirmDeleteBtn")).click();
       Thread.sleep(3000);
	   
	   driver.findElement(By.xpath("//div[@role='dialog']//span[text()='Delete']")).click();
	   Thread.sleep(2000);
	
		
		
		
	}

	
	public void verifyafterDeletionmultipletransaction(String expText){
		
		String actualtext = driver.findElement(By.id("TransactionList")).getText();
		
		Assert.assertEquals(actualtext, expText);
		
		
	}
	
	
}
