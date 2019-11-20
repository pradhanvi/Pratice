package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ManageBankStatements extends TestBase{
	
	@FindBy (xpath = "//h1[contains(text(),'Manage Bank Statements')]")
	public WebElement ManageBankStatements_Header;

	public ManageBankStatements() {
		PageFactory.initElements(driver, this);
		log.info("Manage Bank Statements page is initialized...");
	}

}
