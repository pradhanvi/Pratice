package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class Invoices extends TestBase{
	
	@FindBy(xpath = "//span[text()='Invoices']")
	public WebElement Invoices_Header;
	
	@FindBy(xpath = "//img[@title='Tasks']")
	public WebElement TaskPane;
	
	@FindBy(xpath = "//a[text()='Create Invoice']")
	public WebElement CreateInvoice;
	
	@FindBy(xpath = "//a[text()='Manage Invoices']")
	public WebElement ManageInvoices;
	
	@FindBy(xpath = "//a[text()='Validate Invoices']")
	public WebElement ValidateInvoices;
	
	@FindBy(xpath = "//a[text()='Import Invoices']")
	public WebElement ImportInvoices;
	
	@FindBy(xpath = "//a[text()='Create Accounting']")
	public WebElement CreateAccounting;
	
	@FindBy(xpath = "//a[text()='Create Mass Additions']")
	public WebElement CreateMassAdditions;
	
	@FindBy(xpath = "//a[text()='Manage Accounting Periods']")
	public WebElement ManageAccountingPeriods;
	
	public Invoices() {
		PageFactory.initElements(driver, this);
	}

}
