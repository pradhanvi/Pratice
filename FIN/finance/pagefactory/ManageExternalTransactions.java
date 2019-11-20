package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ManageExternalTransactions extends TestBase{
	
	@FindBy (xpath = "//h1[contains(text(),'Manage External Transactions')]")
	public WebElement ManageExternalTransactions_Header;

	public ManageExternalTransactions() {
		PageFactory.initElements(driver, this);
		log.info("Manage External Transactions page is initialized...");
	}

}
