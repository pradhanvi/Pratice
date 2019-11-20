package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ValidateInvoices extends TestBase{
	
	@FindBy(xpath = "//label[text()='Name']//ancestor::tr[1]//td[text()='Validate Payables Invoices']")
	public WebElement ValidateInvoices_Label;
	
	@FindBy(xpath = "//label[text()='Business Unit']//parent::td//parent::tr//td[2]//input")
	public WebElement BusinessUnit;
	
	@FindBy(xpath = "//label[text()='Ledger']//parent::td//parent::tr//td[2]//input")
	public WebElement Ledger;
	
	@FindBy(xpath = "//select[@title='All']")
	public WebElement Option_Select;
	
	@FindBy(xpath = "//div[contains(@id,'submitButton')]")
	public WebElement Submit;
	
	@FindBy(xpath = "//label[contains(text(),'submitted')]")
	public WebElement Message_Confirmation;
	
	@FindBy(xpath = "//button[contains(@id,'confirmSubmitDialog::ok')]")
	public WebElement OK_Confirmation;

	public ValidateInvoices() {
		PageFactory.initElements(driver, this);
		log.info("Validate Invoices page is initialized...");
	}

}
