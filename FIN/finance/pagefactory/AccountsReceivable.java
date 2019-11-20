package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class AccountsReceivable extends TestBase{

	@FindBy(xpath = "//div[@title='Tasks']")
	public WebElement TasksPaneIcon;
	
	@FindBy(xpath = "//a[text()='Receivables to Ledger Reconciliation']")
	public WebElement ReceivablesToLedgerReconciliation_Link;
	
	@FindBy(xpath = "//a[text()='Create Receipt']")
	public WebElement CreateReceipt_Link;
	
	@FindBy(xpath = "//a[text()='Manage Receipts']")
	public WebElement ManageReceipts_Link;
	
	@FindBy(xpath = "//a[text()='Create Accounting']")
	public WebElement CreateAccounting;
	
	@FindBy(xpath = "//a[text()='Manage Accounting Periods']")
	public WebElement ManageAccountingPeriods;
	
	@FindBy(xpath = "//a[text()='Receivables to Ledger Reconciliation']")
	public WebElement ReceivablesToLedgerReconciliation;
	
	
	public AccountsReceivable() {
		PageFactory.initElements(driver, this);
		log.info("AccountsReceivable initiated...");
	}
	
	public ReceivablesToLedgerReconciliation clickOnReceivablesToLedgerReconciliationLinkFromTask() {

		if(cmnLib.clickOnWebElement(ReceivablesToLedgerReconciliation_Link)) {
			log.info("Receivables To Ledger Reconciliation Link is Clicked");
		}else {
			log.info("Receivables To Ledger Reconciliation Link is Not Clicked");
			return null;
		}
		cmnLib.waitForPageLoaded();
		return PageFactory.initElements(driver, ReceivablesToLedgerReconciliation.class);
	}
	
	public CreateReceipt clickOnCreateReceipt() {
		if(cmnLib.clickOnWebElement(CreateReceipt_Link)) {
			log.info("Create Receipt Link is Clicked");
		}else {
			log.info("Create Receipt Link is Not Clicked");
			return null;
		}
		cmnLib.waitForPageLoaded();
		return PageFactory.initElements(driver, CreateReceipt.class);
	}
	
//	
	
	public ManageReceipts clickOnManageReceipts() {
		if(cmnLib.clickOnWebElement(ManageReceipts_Link)) {
			log.info("Manage Receipts Link is Clicked");
		}else {
			log.info("Manage Receipts Link is Not Clicked");
			return null;
		}
		cmnLib.waitForPageLoaded();
		return PageFactory.initElements(driver, ManageReceipts.class);
	}
}
