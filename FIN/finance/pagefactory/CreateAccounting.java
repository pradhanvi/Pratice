package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class CreateAccounting extends TestBase {
	
	@FindBy(xpath = "//label[text()='Name']//ancestor::tr[1]//td[text()='Create Accounting']")
	public WebElement CreateAccounting_Label;
	
	@FindBy(xpath = "//label[text()='Name']//ancestor::tr[1]//td[text()='Create Accounting for Assets']")
	public WebElement CreateAccountingForAssets_Label;
	
	@FindBy(xpath = "//label[text()='Name']//ancestor::tr[1]//td[text()='Create Receivables Accounting']")
	public WebElement CreateReceivablesAccounting_Label;

	@FindBy(xpath = "//label[text()='Book']//parent::td//parent::tr//td[2]//select")
	public WebElement Book;

	@FindBy(xpath = "//label[text()='End Date']//parent::td//parent::tr//td[2]//input")
	public WebElement EndDate;

	@FindBy(xpath = "//label[text()='Accounting Mode']//parent::td//parent::tr//td[2]//select")
	public WebElement AccountingMode;

	@FindBy(xpath = "//label[text()='Process Events']//parent::td//parent::tr//td[2]//select")
	public WebElement ProcessEvents;

	@FindBy(xpath = "//label[text()='Report Style']//parent::td//parent::tr//td[2]//select")
	public WebElement ReportStyle;

	@FindBy(xpath = "//label[text()='Transfer to General Ledger']//parent::td//parent::tr//td[2]//select")
	public WebElement TransferToGL_select;

	@FindBy(xpath = "//label[text()='Transfer to General Ledger']//parent::td//parent::tr//td[2]//span")
	public WebElement TransferToGL_span;

	@FindBy(xpath = "//div[contains(@id,'requestBtns:submitButton')]")
	public WebElement Submit;

	@FindBy(xpath = "//span[contains(@id,'requestBtns:confirmationPopup:pt_ol1')]")
	public WebElement Message_Confirmation;

	@FindBy(xpath = "//button[contains(@id,'requestBtns:confirmationPopup:confirmSubmitDialog::ok')]")
	public WebElement OK_Confirmation;
	
	@FindBy(xpath = "//select[@title='Assets']")
	public WebElement SubledgerApplication_Select;
	
	@FindBy(xpath = "//label[text()='Ledger']//parent::td//parent::tr//td[2]//input")
	public WebElement Ledger;

	public CreateAccounting() {
		PageFactory.initElements(driver, this);
		log.info("Create Accounting page is initialized...");
	}

}
