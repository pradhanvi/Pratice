package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ImportInvoices extends TestBase{

	@FindBy(xpath = "//label[text()='Name']//ancestor::tr[1]//td[text()='Import Payables Invoices']")
	public WebElement ImportInvoices_Label;

	public ImportInvoices() {
		PageFactory.initElements(driver, this);
		log.info("Import Invoices page is initialized...");
	}

}
