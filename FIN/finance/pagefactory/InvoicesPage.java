package finance.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class InvoicesPage extends TestBase {
	
	@FindBy(xpath = "//img[@title='Tasks']")
	public WebElement Task;
	
	@FindBy(id = "_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:_FOTRaT:0:RAtl1")
	public WebElement CreateInvoice;
	
	@FindBy(id = "_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:_FOTRaT:0:RAtl6")
	public WebElement ValidateInvoices;
	
	@FindBy(xpath = "//a[contains(text(),'Manage Invoices')]")
	public WebElement ManageInvoices;
	
	@FindBy(xpath = "//input[contains(@id,'value00::content')]")
	public WebElement BusinessUnit;
	
	
	@FindBy(xpath = "//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:ap1:r1:basicReqBody:paramDynForm_Ledger::content']")
	public WebElement Ledger;
	
	
	@FindBy(xpath ="//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:ap1:r1:basicReqBody:paramDynForm_ATTRIBUTE4_ATTRIBUTE4::content']")
	public WebElement Option;
	
	
	@FindBy(xpath = "//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:ap1:r1:basicReqBody:paramDynForm_InvoiceNumber::content']")
	public WebElement InvoiceNumber;
	
	@FindBy(xpath = "//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:q1:value10::content']")
	public WebElement PaymentInvoiceNumber;
	
	@FindBy(xpath = "//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:q1::search']")
	public WebElement PaymentSearchBtn;
	
	@FindBy(id ="_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:_FOTRaT:0:RAtl17")
	public WebElement ManageAccountingPeriod;
	
	public InvoicesPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean ClickonTaskandAssets() {
		boolean Click = false;
		try {
			Thread.sleep(10000);
			WebElement NewTask  = driver.findElement(By.xpath("//img[@title='Tasks']"));
			cmnLib.clickOnWebElement(NewTask);
			log.info("Task is Clicked");
			WebElement CreateMassAddition  = driver.findElement(By.id("_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:_FOTRaT:0:RAtl15"));
			cmnLib.clickOnWebElement(CreateMassAddition);
			log.info("Create Mass Addition is Clicked");
			 Click = true;
		} catch (Exception e) {
			log.info("Unable to Click on Create Mass Addition");
			
		}
		return Click;
		
	}
	
	public boolean ClickonTaskandValidateInvoice() {
		boolean click = false;
		try {
			cmnLib.clickOnWebElement(Task);
			log.info("Task is Clicked");
			cmnLib.clickOnWebElement(ValidateInvoices);
			log.info("Validate Invoices is Clicked");
			click = true;
		} catch (Exception e) {
			
		}
		return click;
		
	}
	
	public boolean ClickonTaskandCreateInvoice() {
		boolean click = false;
		try {
			cmnLib.clickOnWebElement(Task);
			log.info("Task is Clicked");
			cmnLib.clickOnWebElement(CreateInvoice);
			log.info("Create Invoices is Clicked");
			click = true;
		} catch (Exception e) {
			
		}
		return click;
		
	}
	
	//Create Single Payments//
	
	@FindBy(id = "//a[contains(text(),'Manage Invoices')]")
	public WebElement CSP_ManageInvoices;
	
	@FindBy(xpath = "//input[contains(@id,'value10::content')]")
	public WebElement CSP_InvoiceNumber;
	
	@FindBy(xpath = "//input[contains(@id,'value50::content')]")
	public WebElement CSP_SupplierNumber;
	
	@FindBy(xpath = "//button[contains(@id,'search')]")
	public WebElement CSP_SearchBtn;
	
	@FindBy(xpath = "//table[@summary =\"Search Results\"]/tbody/tr/td[1]")
	public WebElement CSP_ResultInvoiceNumber;
	
	@FindBy(xpath = "//span[contains(text(),'Pay in Full')]")
	public WebElement CSP_PayinFull;
	
	@FindBy(xpath = "//input[contains(@id,'bankAccountNamePIFId')]")
	public WebElement CSP_BankAcctNo;
	
	@FindBy(xpath = "//input[contains(@id,'paymentProfileNameId')]")
	public WebElement CSP_PaymentProcessProfile;
	
	@FindBy(xpath = "//button[contains(@accesskey,'m')]")
	public WebElement CSP_Submitbtn;
	
	@FindBy(xpath = "//div[contains(text(),'has been created.')]")
	public WebElement CSP_ConfirmationMsg;
	
	@FindBy(xpath = "//button[contains(@id,'msgDlg::cancel')]")
	public WebElement CSP_Okbtn;
	
	
	
	
	
	
	
	
	
	
}
