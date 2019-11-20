package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class Billing extends TestBase{
	
	@FindBy (xpath = "//img[@title='Tasks']")
	public WebElement TasksPane;
	
	@FindBy(xpath = "//a[text()='Manage Transactions']")
	public WebElement ManageTransactionLink;
	
	@FindBy(xpath = "//a[text()='Credit Transaction']")
	public WebElement CreditTransactionLink;
	
	@FindBy(xpath = "//a[text()='Create Transaction']")
	public WebElement CreateTransaction;
	
	@FindBy(xpath = "//a[text()='Approve Adjustments']")
	public WebElement ApproveAdjustments;
	
	@FindBy(xpath = "//a[text()='Create Customer']")
	public WebElement CreateCustomer;
	
	@FindBy(xpath = "//a[text()='Manage Customers']")
	public WebElement ManageCustomers;

	@FindBy(xpath = "//a[text()='Create Accounting']")
	public WebElement CreateAccounting;
	
	public Billing() {
		PageFactory.initElements(driver, this);
		log.info("Billing initiated...");
	}
	public ManageTransactions clickOnManageTransactionLinkFromTask() {

		if(cmnLib.clickOnWebElement(ManageTransactionLink)) {
			log.info("Manage Transactions is Clicked");
		}else {
			log.info("Manage Transactions is Not Clicked");
			return null;
		}
		cmnLib.waitForPageLoaded();
		return PageFactory.initElements(driver, ManageTransactions.class);
	}
	
	public CreditTransaction clickOnCreditTransactionLinkFromTask() {

		if(cmnLib.clickOnWebElement(CreditTransactionLink)) {
			log.info("Credit Transactions is Clicked");
		}else {
			log.info("Credit Transactions is Not Clicked");
			return null;
		}
		cmnLib.waitForPageLoaded();
		return PageFactory.initElements(driver, CreditTransaction.class);
	}
}
