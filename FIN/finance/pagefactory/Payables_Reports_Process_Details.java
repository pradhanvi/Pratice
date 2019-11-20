package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class Payables_Reports_Process_Details extends TestBase {
	
	//Report: Payables Invoice Register
	
	@FindBy(xpath = "//input[contains(@id,'paramDynForm_BusinessUnit::content')]")
	public WebElement PIR_BusinessUnit;
	
	@FindBy(xpath="//div[contains(@id,'requestBtns:submitButton')]")
	public WebElement PIR_SubmitBtn;
	
	@FindBy(xpath ="//button[contains(@id,'r1:requestBtns:confirmationPopup:confirmSubmitDialog::ok')]")
	public WebElement PIR_ConfOkBtn;
	
	//Report: Payables Invoice Aging Report
	
	@FindBy(xpath = "//input[contains(@id,'paramDynForm_BusinessUnit::content')]")
	public WebElement PIAR_BusinessUnit;
	
	@FindBy(xpath = "//select[contains(@id,'ATTRIBUTE6_ATTRIBUTE6::content')]")
	public WebElement PIAR_SortInvoicesBy;
	
	@FindBy(xpath = "//select[contains(@id,'ATTRIBUTE7_ATTRIBUTE7::content')]")
	public WebElement PIAR_InvoiceDetail;
	
	@FindBy(xpath = "//select[contains(@id,'ATTRIBUTE8_ATTRIBUTE8::content')]")
	public WebElement PIAR_SupplierSite;
	
	@FindBy(xpath = "//select[contains(@id,'ATTRIBUTE13_ATTRIBUTE13::content')]")
	public WebElement PIAR_AgingPeriod;
	
	@FindBy(xpath="//div[contains(@id,'requestBtns:submitButton')]")
	public WebElement PIAR_SubmitBtn;
	
	@FindBy(xpath="//button[contains(@id,'r1:requestBtns:confirmationPopup:confirmSubmitDialog::ok')]")
	public WebElement PIAR_ConfOkBtn;
	
	//Report: Payables Payments Register
	
	@FindBy(xpath = "//input[contains(@id,'paramDynForm_BusinessUnit::content')]")
	public WebElement PPR_BusinessUnit;
	
	@FindBy(xpath ="//select[contains(@id,'ATTRIBUTE12_ATTRIBUTE12::content')]")
	public WebElement PPR_BusinessUnit_Context;
	
	@FindBy(xpath = "//input[contains(@id,'paramDynForm_FromDate::content')]")
	public WebElement PPR_FromDate;
	
	@FindBy(xpath = "//input[contains(@id,'paramDynForm_ToDate::content')]")
	public WebElement PPR_ToDate;
	
	@FindBy(xpath="//select[contains(@id,'ATTRIBUTE9_ATTRIBUTE9::content')]")
	public WebElement PPR_PayeeAddress;
	
	@FindBy(xpath ="//div[contains(@id,'requestBtns:submitButton')]")
	public WebElement PPR_SubmitBtn;
	
	@FindBy(xpath ="//button[contains(@id,'r1:requestBtns:confirmationPopup:confirmSubmitDialog::ok')]")
	public WebElement PPR_ConfOkBtn;
	
	//Report: Payables Trial Balance Report
	
	@FindBy(xpath = "//input[contains(@id, 'bd::content')]")
	public WebElement PTBR_BusinessUnit;
	
	@FindBy(xpath = "//input[contains(@id, 'id1::content')]")
	public WebElement PTBR_Liability_Account;
	
	@FindBy(xpath = "//input[contains(@id, 'pd::content')]")
	public WebElement PTBR_Party_Name;
	
	@FindBy(xpath = "//select[contains(@id, 'soc3::content')]")
	public WebElement PTBR_Negative_Balance;
	
	@FindBy(xpath = "//select[contains(@id, 'soc1::content')]")
	public WebElement PTBR_Include_Bills;
	
	@FindBy(xpath="//div[contains(@id,'requestBtns:submitButton')]")
	public WebElement PTBR_SubmitBtn;
	
	@FindBy(xpath="//button[contains(@id,'r1:requestBtns:confirmationPopup:confirmSubmitDialog::ok')]")
	public WebElement PTBR_ConfOkBtn;
	
	
	public Payables_Reports_Process_Details() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	
	
	

}
