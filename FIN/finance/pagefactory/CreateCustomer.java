package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class CreateCustomer extends TestBase{
	
	@FindBy (xpath = "//h1[contains(text(),'Create Organization Customer')]")
	public WebElement CreateCustomer_Header;
	
	@FindBy (xpath = "//button[contains(@id,'cucommandButton3')]")
	public WebElement Cancel;

	public CreateCustomer() {
		PageFactory.initElements(driver, this);
		log.info("Create Customer page is initialized...");
	}

}
