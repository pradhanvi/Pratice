package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class GeneralAccountingDashboard extends TestBase{
	
	@FindBy(xpath="//img[contains(@id,'FOTsdiDefault_Regional::icon')]")
	public WebElement TaskIcon;

	@FindBy(xpath="//a[text()='Inquire and Analyze Balances']")
	public WebElement InquireandAnalyzeBalances;

	@FindBy(xpath="//input[contains(@id,'i1:0:iclov2::content')]")
	public WebElement LegalEntity;

	@FindBy(xpath="//input[contains(@id,'i1:1:iclov2::content')]")
	public WebElement BUSINESSAREA;

	@FindBy(xpath="//div[contains(@id,'zpanel1:SPb')]")
	public WebElement DoneBtn;

	
	
	public GeneralAccountingDashboard() {
		PageFactory.initElements(driver, this);
		log.info("GeneralAccountingDashboard initiated...");
	}
}
