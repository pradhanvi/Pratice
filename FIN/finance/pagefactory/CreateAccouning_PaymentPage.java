package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class CreateAccouning_PaymentPage extends TestBase {
	
	@FindBy(xpath = "//Select[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_payments:0:MAnt2:1:ap1:r1:basicReqBody:paramDynForm_SubledgerApplicationAttr::content']")
	public WebElement SubLedgerDropdown;
	
	@FindBy(xpath = "//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_payments:0:MAnt2:1:ap1:r1:basicReqBody:paramDynForm_LedgerAttr::content']")
	public WebElement Ledger;
	
	@FindBy(xpath = "//Select[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_payments:0:MAnt2:1:ap1:r1:basicReqBody:paramDynForm_ATTRIBUTE5_ATTRIBUTE5::content']")
	public WebElement Process_CategoryDropdown;
	
	@FindBy(xpath = "//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_payments:0:MAnt2:1:ap1:r1:basicReqBody:paramDynForm_ATTRIBUTE6_ATTRIBUTE6::content']")
	public WebElement EndDate;
	
	@FindBy(xpath = "//Select[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_payments:0:MAnt2:1:ap1:r1:basicReqBody:paramDynForm_ATTRIBUTE8_ATTRIBUTE8::content']")
	public WebElement AccountingModeDropdown;
	
	@FindBy(xpath = "//Select[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_payments:0:MAnt2:1:ap1:r1:basicReqBody:paramDynForm_ATTRIBUTE9_ATTRIBUTE9::content']")
	public WebElement ProcessEventsDropdown;
	
	@FindBy(xpath = "//Select[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_payments:0:MAnt2:1:ap1:r1:basicReqBody:paramDynForm_ATTRIBUTE10_ATTRIBUTE10::content']")
	public WebElement ReportStyleDropdown;
	
	@FindBy(xpath = "//Select[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_payments:0:MAnt2:1:ap1:r1:basicReqBody:paramDynForm_ATTRIBUTE11_ATTRIBUTE11::content']")
	public WebElement TransfertoGLDropdown;
	
	@FindBy(xpath = "//Select[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_payments:0:MAnt2:1:ap1:r1:basicReqBody:paramDynForm_ATTRIBUTE12_ATTRIBUTE12::content']")
	public WebElement PostinGeneralDropdown;
	
	@FindBy(xpath = "//Select[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_payments:0:MAnt2:1:ap1:r1:basicReqBody:paramDynForm_ATTRIBUTE15_ATTRIBUTE15::content']")
	public WebElement UserTransactionIdentifier;
	
	@FindBy(xpath = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_payments:0:MAnt2:1:ap1:r1:requestBtns:submitButton']")
	public WebElement SubmitBtn;
	
	@FindBy(xpath = "_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_payments:0:MAnt2:1:ap1:r1:requestBtns:confirmationPopup:confirmSubmitDialog::ok")
	public WebElement SubmitClickOkbtn;
	
	
	
	public void PageFactory() {
		PageFactory.initElements(driver, this);
		}
	
	public boolean SubmitheAccountingDetails() {
		boolean submit = false;
		try {
			cmnLib.clickOnWebElement(SubmitBtn);
			log.info("Submit button is clicked");
			submit = true;
		} catch (Exception e) {
			log.info("Couldn't click on Submit button ");
		}
		
		return submit;
		
	}
	
	//FIN_PERU_AP022 - Confirmation Button
	
			public boolean SubmitokBtn() {
				boolean Submit = false;
				cmnLib.waitForElementToBeVisible(SubmitClickOkbtn);
				cmnLib.clickOnWebElement(SubmitClickOkbtn);
				Submit = true;
				return Submit;
				}
		

}
