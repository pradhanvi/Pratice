package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ManageInvoices extends TestBase{
	
	@FindBy(xpath = "//h1[contains(text(),'Manage Invoices')]")
	public WebElement ManageInvoices_Header;

	public ManageInvoices() {
		PageFactory.initElements(driver, this);
		log.info("Manage Invoices page is initialized...");
	}

}
