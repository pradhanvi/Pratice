package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ApproveAdjustments extends TestBase{
	
	@FindBy (xpath = "//h1[contains(text(),'Approve Adjustments')]")
	public WebElement ApproveAdjustments_Header;

	public ApproveAdjustments() {
		PageFactory.initElements(driver, this);
		log.info("Approve Adjustments page is initialized...");
	}

}
