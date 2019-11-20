package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ManageBankAccountTransfers extends TestBase{
	
	@FindBy (xpath = "//h1[contains(text(),'Manage Bank Account Transfers')]")
	public WebElement ManageBankAccountTransfers_Header;

	public ManageBankAccountTransfers() {
		PageFactory.initElements(driver, this);
		log.info("Manage Bank Account Transfers page is initialized...");
	}

}
