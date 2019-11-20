package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class SubmitPaymentProcessRequest extends TestBase{
	
	@FindBy(xpath = "//h1[contains(text(),'Submit Payment Process Request')]")
	public WebElement SubmitPaymentProcessRequest_Header;
	
	@FindBy(xpath = "//div[contains(@id,'SPc')]")
	public WebElement Cancel;
	
	@FindBy (xpath = "//div[contains(text(),'changes will be lost')]")
	public WebElement Message_Warning;
	
	@FindBy (xpath = "//button[contains(@id,'yes')]")
	public WebElement Yes_Warning;
	
	@FindBy (xpath = "//label[text()='Name']//parent::td//parent::tr//td[2]//input")
	public WebElement Name;
	
	@FindBy (xpath = "//label[text()='Template']//parent::td//parent::tr//td[2]//input")
	public WebElement Template;
	
	@FindBy (xpath = "//div[contains(@id,'sb2')]")
	public WebElement Submit;

	public SubmitPaymentProcessRequest() {
		PageFactory.initElements(driver, this);
		log.info("Submit Payment Process Request page is initialized...");
	}

}
