package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class LoadAndImportBankStatement extends TestBase{
	
	@FindBy(xpath = "//label[text()='Name']//ancestor::tr[1]//td[text()='Load and Import Bank Statement']")
	public WebElement LoadAndImportBankStatement_Label;

	public LoadAndImportBankStatement() {
		PageFactory.initElements(driver, this);
		log.info("Load and Import Bank Statement page is initialized...");
	}

}
