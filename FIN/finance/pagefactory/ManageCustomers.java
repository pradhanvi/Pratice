package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ManageCustomers extends TestBase{
	
	@FindBy (xpath = "//h1[contains(text(),'Manage Customers')]")
	public WebElement ManageCustomers_Header;

	public ManageCustomers() {
		PageFactory.initElements(driver, this);
		log.info("Manage Customers page is initialized...");
	}

}
