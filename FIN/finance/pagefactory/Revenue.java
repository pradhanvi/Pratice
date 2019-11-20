package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class Revenue extends TestBase{
	
	@FindBy(xpath = "//div[@title='Tasks']")
	public WebElement TasksPaneIcon;
	
	@FindBy(xpath = "//a[text()='Manage Revenue Adjustments']")
	public WebElement ManageRevenueAdjustments;
	
	@FindBy(xpath = "//a[text()='Recognize Revenue']")
	public WebElement RecognizeRevenue;

	public Revenue() {
		PageFactory.initElements(driver, this);
		log.info("Revenue page is initialized...");
	}

}
