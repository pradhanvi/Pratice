package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ManagePaymentProcessRequests extends TestBase{
	
	@FindBy(xpath = "//h1[contains(text(),'Manage Payment Process Requests')]")
	public WebElement ManagePaymentProcessRequests_Header;

	public ManagePaymentProcessRequests() {
		PageFactory.initElements(driver, this);
		log.info("Manage Payment Process Requests page is initialized...");
	}

}
