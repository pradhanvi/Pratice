package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class CreateBankAccountTransfer extends TestBase{
	
	@FindBy (xpath = "//h1[contains(text(),'Create Bank Account Transfer')]")
	public WebElement CreateBankAccountTransfer_Header;
	
	@FindBy (xpath = "//div[contains(@id,'SPc')]")
	public WebElement Cancel;
	
	@FindBy (xpath = "//div[contains(text(),'changes will be lost')]")
	public WebElement Message_Warning;
	
	@FindBy (xpath = "//button[contains(@id,'cb5')]")
	public WebElement Yes_Warning;	

	public CreateBankAccountTransfer() {
		PageFactory.initElements(driver, this);
		log.info("Create Bank Account Transfer page is initialized...");
	}

}
