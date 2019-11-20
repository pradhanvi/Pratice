package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class CreateExternalTransaction extends TestBase{
	
	@FindBy (xpath = "//h1[contains(text(),'Create External Transaction')]")
	public WebElement CreateExternalTransaction_Header;
	
	@FindBy (xpath = "//div[contains(@id,'SPc')]")
	public WebElement Cancel;
	
	@FindBy (xpath = "//td[contains(text(),'changes will be lost')]")
	public WebElement Message_Warning;
	
	@FindBy (xpath = "//button[contains(@id,'dialog1::yes')]")
	public WebElement Yes_Warning;

	public CreateExternalTransaction() {
		PageFactory.initElements(driver, this);
		log.info("Create External Transaction page is initialized...");
	}

}
