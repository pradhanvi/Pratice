package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class CreateBankStatement extends TestBase{
	
	@FindBy (xpath = "//h1[contains(text(),'Create Bank Statement')]")
	public WebElement CreateBankStatement_Header;
	
	@FindBy (xpath = "//button[contains(@id,'commandButton3')]")
	public WebElement Cancel;
	
	@FindBy (xpath = "//div[contains(text(),'changes are not saved')]")
	public WebElement Message_Warning;
	
	@FindBy (xpath = "//button[contains(@id,'cb2')]")
	public WebElement Yes_Warning;

	public CreateBankStatement() {
		PageFactory.initElements(driver, this);
		log.info("Create Bank Statement page is initialized...");
	}

}
