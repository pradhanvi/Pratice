package finance.pagefactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class CreateJournal extends TestBase{

	
	@FindBy (xpath="//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_general_accounting_journals:0:MAnt2:1:pt1:ap1:showLessBatchName::content']")
	WebElement JournalBatch;
	
	@FindBy (xpath = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_general_accounting_journals:0:MAnt2:1:pt1:ap1:showLessBatchDescription::content']")
	WebElement JournalDescription;
	
	@FindBy (xpath = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_general_accounting_journals:0:MAnt2:1:pt1:ap1:DefaultPeriodName1::content']")
	WebElement AccountingPeriod;
	
	@FindBy(xpath = "//h1[contains(text(),'Create Journal')]")
	public WebElement CreateJournal_Header;
	
	@FindBy(xpath = "//div[contains(@id,'commandToolbarButton5')]")
	public WebElement Cancel;
	
	public CreateJournal() {
		PageFactory.initElements(driver, this);
		log.info("CreateJournal initiated...");
	}
}
