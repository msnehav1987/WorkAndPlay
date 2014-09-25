package com.zipform.webpages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {

	public WebDriver driver;

	// Elements of Home Page Header

	@FindBy(id = "releaseNotesDialog")
	private WebElement feedbacknote;

	@FindBy(css = "#continueToApp>a>img")
	private WebElement continuebutton;

	@FindBy(css = "#btnTxnNewHeader>img")
	private WebElement createNewTxn;

	@FindBy(id = "btnTxnDelete")
	private WebElement deleteTxnbutton;

	@FindBy(id = "btnTxnNewHeader")
	private WebElement addTxnbutton;

	@FindBy(id="mnuTransactions")
	private WebElement menu_trans;

	@FindBy(id = "mnuTemplates")
	private WebElement menu_Temp;

	@FindBy(id = "mnuContacts")
	private WebElement menu_Contacts;

	@FindBy(id = "mnuAdministration")
	private WebElement menu_Contact;

	@FindBy(id = "mnuHelp")
	private WebElement menu_help;

	@FindBy(className = "successmsg")
	protected WebElement successMsg;

	@FindBy(xpath = "//img[@src='css/images/page_arrow.png']")
	private WebElement linktoLogoff;

	@FindBy(id = "logoff")
	private WebElement logoffbutton;

	@FindBy(css = "#btnTxnNewHeader>img")
	private WebElement createNewTxnbutton;

	@FindBy(className = "toast-container toast-position-top-center")
	protected WebElement msgElement;

	@FindBy(css = "#btnFormViewer>img")
	private WebElement addFormbutton;

	@FindBy(xpath = "//button[@title='Sort']")
	private WebElement sortbuttontitleText;

	@FindBy(id = "ui-id-3")
	private WebElement sortbyDatemodifiedListvalue;

	@FindBy(id = "ui-id-4")
	private WebElement sortbycreatedlistvalue;

	@FindBy(id = "ui-id-5")
	private WebElement sortbyTxnnamelistvalue;

	@FindBy(id = "ui-id-6")
	private WebElement sortbyBuyernamelistvalue;

	@FindBy(id = "ui-id-7")
	private WebElement sortbySellerNamelistValue;

	@FindBy(id = "ui-id-8")
	private WebElement sortbyTxnapprovallistvalue;

	@FindBy(css = ".field.field3")
	private WebElement inputforsearchcharacters;

	@FindBy(id = "btnTxnImport")
	private WebElement ImportButton;

	@FindBy(id = "btnTxnExport")
	private WebElement ExportButton;

	@FindBy(xpath = "//div[@role='dialog']//span[text()='OK']")
	private WebElement okbutton;

	@FindBy(xpath = "//div[@role='dialog']//span[text()='Cancel']")
	private WebElement cancelbutton;

	@FindBy(xpath = "//div[@class='qq-upload-button']")
	private WebElement Browsebutton;

	
	@FindBy(xpath="//div[@id='transaction1FormSearch']//div[@class='x']")
	private WebElement closeSearchicon;
	
	@FindBy(xpath="//div[@class='toast-container toast-position-top-center']//p")
	private WebElement msgpanel;
	/**
	 * Defined Constructor of HomePage which will take care of driver Setting
	 * with page factory
	 * 
	 * @author neha.p
	 * 
	 */
	public HomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	/**
	 * Method to logout from application available inside LinkMenu in right
	 * Corner of Home Page
	 * 
	 * @author neha.p
	 * 
	 */

	public void Clicklogout() throws InterruptedException {

		Thread.sleep(7000);
		System.out.println("Logging out from Application");
		linktoLogoff.click();
		// imageLinktoLogoff.click();
		logoffbutton.click();
	}

	/**
	 * Method to verify success messages
	 * 
	 * @author neha.p
	 * 
	 */

	public void verifysuccessmsg(String eSmsg) {
		System.out.println("Actual and expected message both are same");
		String aSmsg = successMsg.getText();
		Assert.assertEquals(aSmsg, eSmsg);
	}

	/**
	 * Method to verify that text present in home Page
	 * 
	 * @author neha.p
	 * 
	 */

	public boolean isTextPresent(String txtValue) {

		try {
			Thread.sleep(5000);
			boolean b = driver.getPageSource().contains(txtValue);
			return b;
		} catch (Exception e) {
			return false;
		}

		// Assert.assertEquals(b,txtValue);

	}

	/**
	 * Method to make continue with Feedback note after immediate login
	 * 
	 * @author neha.p
	 * 
	 */

	public void clickContinue() throws InterruptedException {

		if (feedbacknote.isDisplayed()) {
			Thread.sleep(2000);
			continuebutton.click();

		}
		/*
		 * else{ System.err.println(
		 * "No Feedback form displayed,now continuing with application"); }
		 */
	}

	/**
	 * Method to click on menu header which shown in home page
	 * 
	 * @author neha.p
	 * 
	 */

	public void clicktoAddTXNimage() throws InterruptedException {

		Thread.sleep(5000);
		menu_trans.click();

	}

	/**
	 * Method to click on delete button image on home page
	 * 
	 * @author neha.p
	 * 
	 */

	public void clickonDeletebutton() {

		deleteTxnbutton.click();
	}

	/**
	 * Method to click on add transaction button image on home page
	 * 
	 * @author neha.p
	 * 
	 */

	public void clickonAddTxnImagebutton() {
		addTxnbutton.click();

	}

	public void verifysortorderwithclass() {

		WebElement AtoZorder = driver
				.findElement(By
						.xpath("//span[@class='ui-menu-icon ui-icon ui-icon-arrowthick-1-n']"));

		// WebElement ZtoAorder =
		// driver.findElement(By.xpath("//span[@class='ui-menu-icon ui-icon ui-icon-arrowthick-1-s']"));

		if (AtoZorder.isDisplayed()) {

			System.out
					.println("The transaction List are shown in Assending Order...");

		}

	}

	/**
	 * Method to sort transaction by date modified
	 * 
	 * @author neha.p
	 * @throws InterruptedException
	 * 
	 */

	public void sortbyDatemodified() throws InterruptedException {

		sortbuttontitleText.click();
		Thread.sleep(2000);
		sortbyDatemodifiedListvalue.click();

	}

	/**
	 * Method to sort transaction by whom its created
	 * 
	 * @author neha.p
	 * @throws InterruptedException
	 * 
	 */

	public void sortbycreated() throws InterruptedException {
		sortbuttontitleText.click();
		Thread.sleep(2000);
		sortbycreatedlistvalue.click();

	}

	/**
	 * Method to sort transaction by transaction name
	 * 
	 * @author neha.p
	 * @throws InterruptedException
	 * 
	 */

	public void sortbyTransactionName() throws InterruptedException {
		
		Thread.sleep(5000);
		
		 
		 
		 /*if(unsortText.isDisplayed()){
		 System.out.println(unsortText);
		 }
		 return;
	*/
		 
		 
			
		sortbuttontitleText.click();
		Thread.sleep(2000);
		
		sortbyTxnnamelistvalue.click();
		
		/*System.out.println("Verify displayed name is sorted by Transaction name");
        List<WebElement> alltxnText1 = driver.findElements(By.xpath("//h2//a"));
        for (WebElement txnText : alltxnText1) {
        	
        	System.out.println(txnText);
        	
			
		}
*/
        
		
		
		
		/*
		 * WebElement AtoZorder = driver.findElement(By.xpath(
		 * "//li[@class='form-sort-opt ui-menu-item active-sort asc']"));
		 * 
		 * if(AtoZorder.isDisplayed()){
		 * 
		 * System.out.println("The transaction List are shown in Assending Order..."
		 * );
		 * 
		 * } System.out.println("The list is in Desending Order");
		 */

		

	}

	/**
	 * Method to sort transaction by buyerName
	 * 
	 * @author neha.p
	 * @throws InterruptedException
	 * 
	 */

	public void sortbybuyername() throws InterruptedException {
		sortbuttontitleText.click();
		Thread.sleep(2000);
		sortbyBuyernamelistvalue.click();

	}

	/**
	 * Method to sort transaction by seller name
	 * 
	 * @author neha.p
	 * @throws InterruptedException
	 * 
	 */

	public void sortbyseller() throws InterruptedException {
		sortbuttontitleText.click();
		Thread.sleep(2000);
		sortbySellerNamelistValue.click();
	}

	/**
	 * Method to sort transaction by Transaction approval
	 * 
	 * @author neha.p
	 * @throws InterruptedException
	 * 
	 */
	public void sortbytxnapproval() throws InterruptedException {
		sortbuttontitleText.click();
		Thread.sleep(2000);
		sortbyTxnapprovallistvalue.click();
	}

	/**
	 * Method to Search charaters by transaction name
	 * 
	 * @author neha.p
	 * @param transactionname
	 *            - Passing arguments to be search by name
	 * @return
	 * @throws InterruptedException
	 * 
	 */
	public void searchbyElementwithvalidname(String transactionname)
			throws InterruptedException, Exception {

		Thread.sleep(4000);

		inputforsearchcharacters.clear();
		Thread.sleep(4000);
		inputforsearchcharacters.sendKeys(transactionname);
		Thread.sleep(2000);
		
	}
	
	/**
	 * Method to close after searched the text
	 * 
	 * @author neha.p
	 * 
	 * @throws InterruptedException
	 * 
	 */
	
	public void closeSearch(){
		closeSearchicon.click();
		
	}
	


	/**
	 * Method to Search with Invalid charaters by transaction name
	 * 
	 * @author neha.p
	 * @param transactionname
	 *            - Passing arguments to be search by name
	 * @return
	 * @throws InterruptedException
	 * 
	 */

	public void searchbyElementwithInvalidname(String transactionname)
			throws InterruptedException, Exception {

		Thread.sleep(4000);

		inputforsearchcharacters.clear();
		Thread.sleep(4000);
		inputforsearchcharacters.sendKeys(transactionname);
		Thread.sleep(4000);

		WebElement noTxn = driver.findElement(By
				.xpath("//div[text()='No transactions.']"));
		Thread.sleep(5000);
		if (noTxn.isDisplayed()) {
			System.out.println("Invali transaction displayed message : "
					+ noTxn);
		}

	}

	/**
	 * Method to import transaction by browse file from external by transaction
	 * name
	 * 
	 * @author neha.p
	 * 
	 * @return
	 * @throws InterruptedException
	 * @throws Exception
	 * 
	 */

	public void importTransaction() throws InterruptedException, Exception {
 
		Thread.sleep(5000);
		    driver.findElement(By.xpath("//div[@id='btnTxnImport']/img")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.name("file")).click();
	        Thread.sleep(5000);
	        
	        Runtime.getRuntime().exec("/Zipform_Demo3/ExternalExe/autosample1.exe");
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//button[@type='button']//span[text()='OK']")).click();
	       
	        Thread.sleep(3000);
	        System.out.println(driver.findElement(By.xpath("html/body/div[27]/div[11]/div/button[1]")).isDisplayed());
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("html/body/div[27]/div[11]/div/button[1]")).sendKeys(Keys.RETURN);
	        Thread.sleep(7000);
	}
	
	/**
	 * Method to verify messages whether success or failure
	 * name
	 * 
	 * @author neha.p
	 * 
	 * @return
	 * @throws InterruptedException
	 * 
	 */

	public void verifydisplayMsg(String expmsg) {
		
		String actmsg= msgpanel.getText();
		Assert.assertEquals(actmsg, expmsg);
		
	}
	

	/**
	 * Method to explicitwait to browser until messages is displayed
	 * 
	 * @author neha.p
	 * 
	 * @return
	 * @throws InterruptedException
	 * 
	 */
	
	public void explicitwaituntildisplayMessage(WebDriver driver,String expmsg){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast-item toast-type-success']//p")));
		String actElement = driver.findElement(By.xpath("//div[@class='toast-item toast-type-success']//p")).getText();
		
		// assert that displayed message text which is auto-hide feature
		Assert.assertEquals(expmsg,actElement);

		
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
	
	
	
	
}
