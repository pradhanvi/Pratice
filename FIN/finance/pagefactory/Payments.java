package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class Payments extends TestBase {

	@FindBy(xpath = "//img[@title='Tasks']")
	public WebElement TaskPane;

	@FindBy(xpath = "//a[text()='Create Accounting']")
	public WebElement CreateAccounting;

	@FindBy(xpath = "//a[contains(text(),'Payments')]")
	public WebElement Payment_Icon;

	// @FindBy(id="_FOpt1:nv_itemNode_payables_payables_payments")
	// public WebElement PaymentsIcon;

	@FindBy(xpath = "//a[text()='Manage Payment Process Request Templates']")
	public WebElement ManagePaymentProcessRequestTemplates;

	@FindBy(xpath = "//a[contains(text(),'Payables to Ledger Reconciliation')]")
	public WebElement PayabletoGeneralLedgerReconciliation;

	// Invoices initial Page

	@FindBy(id = "_FOpt1:_FOr1:0:_FOSsdiitemNode_payables_payables_invoices::icon")
	public WebElement InvoicesIcon;

	@FindBy(id = "_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:1:_FOTRaT:0:RAtl1")
	public WebElement CreateInvoiceIcon;

	@FindBy(xpath = "//a[text()='Manage Payments']")
	public WebElement ManagePayments;

	@FindBy(xpath = "//a[text()='Create Payment']")
	public WebElement CreatePayment;

	@FindBy(xpath = "//a[text()='Manage Payment Process Requests']")
	public WebElement ManagePaymentProcessRequests;

	@FindBy(xpath = "//a[text()='Submit Payment Process Request']")
	public WebElement SubmitPaymentProcessRequest;
	
	@FindBy(xpath = "//a[text()='Manage Accounting Periods']")
	public WebElement ManageAccountingPeriods;

	public Payments() {
		PageFactory.initElements(driver, this);

	}

	public boolean ClickonCreateAccounting() {
		boolean Click = false;
		try {
			cmnLib.waitForElementToBeVisible(TaskPane);
			cmnLib.clickOnWebElement(TaskPane);
			log.info("Task is Clicked");
			cmnLib.waitForElementToBeVisible(CreateAccounting);
			cmnLib.clickOnWebElement(CreateAccounting);
			log.info("Create Accounting is Clicked");
			Click = true;
		} catch (Exception e) {
			log.info("Unable to Click on Create Accounting");

		}
		return Click;

	}

}
