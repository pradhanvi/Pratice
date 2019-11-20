package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ManageRevenueAdjustments extends TestBase{
	
	@FindBy (xpath = "//h1[contains(text(),'Manage Revenue Adjustments')]")
	public WebElement ManageRevenueAdjustments_Header;

	public ManageRevenueAdjustments() {
		PageFactory.initElements(driver, this);
		log.info("Manage Revenue Adjustments page is initialized...");
	}

}
