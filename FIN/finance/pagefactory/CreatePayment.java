package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class CreatePayment extends TestBase{
	
	@FindBy(xpath = "//h1[contains(text(),'Create Payment')]")
	public WebElement CreatePayment_Header;
	
	@FindBy(xpath = "//button[contains(@id,'cb6')]")
	public WebElement Cancel;
	
	@FindBy (xpath = "//div[contains(text(),'changes will be lost')]")
	public WebElement Message_Warning;
	
	@FindBy (xpath = "//button[contains(@id,'yes')]")
	public WebElement Yes_Warning;	

	public CreatePayment() {
		PageFactory.initElements(driver, this);
		log.info("Create Payment page is initialized...");
	}

}
