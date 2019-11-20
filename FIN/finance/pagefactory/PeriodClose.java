package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class PeriodClose extends TestBase{
	
	@FindBy(xpath = "//h1[contains(text(),'Period Close')]")
	public WebElement PeriodClose_Header;
	
	@FindBy(xpath = "//img[@title='Tasks']")
	public WebElement TaskPane;
	
	@FindBy(xpath = "//a[text()='Manage Accounting Periods']")
	public WebElement ManageAccountingPeriods;

	public PeriodClose() {
		PageFactory.initElements(driver, this);
		log.info("Period Close page is initialized...");
	}

}
