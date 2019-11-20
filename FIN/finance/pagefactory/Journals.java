package finance.pagefactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.commons.TestBase;

public class Journals extends TestBase{

	@FindBy(xpath = "//img[@title='Tasks']")
	public WebElement TaskPane;
	
	@FindBy(xpath = "//a[text()='Manage Journals']")
	public WebElement ManageJournals;
	
	@FindBy(xpath = "//a[text()='Create Journal']")
	public WebElement CreateJournal;
	
	@FindBy(xpath = "//a[text()='Import Journals']")
	public WebElement ImportJournals;
	
	@FindBy (xpath="//h1[(text(),'Journals')]")
	WebElement JournalsPage_StringValidation;
	
	@FindBy(xpath = "//select[contains(@id,'2:0:soc1::content')]")
	public WebElement changeDataAccessSetElement;
	
	@FindBy(xpath = "//button[contains(@id,'d1::ok')]")
	public WebElement OKButton;
	
	@FindBy(xpath = "//div[text()='Period Close']")
	public WebElement PeriodClose_Icon;
	
	@FindBy(xpath="//div[text()='Period Close']")
	public WebElement PeriodCloseLink;
	
	@FindBy(xpath="//img[@title='General Ledger']")
	public WebElement OpenPeriodLink;
	
	@FindBy(xpath="//div[@id='_FOpt1:_FOr1:0:_FOSritemNode_general_accounting_period_close:1:_FOTsr1:0:pt1:r1:1:ap1:AT1:_ATp:ATm']")
	public WebElement ActionDropdown;
	
	@FindBy(xpath="//td[contains(text(),'Open Target Period')]")
	public WebElement OpenTargetPeriod;
	
	@FindBy(xpath="//select[contains(@id,'soc1::content')]")
	public WebElement TargetPeriod;
	
	@FindBy(xpath="//button[contains(@id,'cb1')]")
	public WebElement OpenButton;
	
	@FindBy(xpath="//button[contains(@id,'ap1:d13::ok')]")
	public WebElement OkBtn;
	
	public Journals() {
		PageFactory.initElements(driver, this);
		log.info("Journals initiated...");
	}
	public boolean validateJournalsPage() {
		if(JournalsPage_StringValidation.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	@FindBy (xpath="//*[@id='pt1:_FOr1:1:_FOSritemNode_general_accounting_journals:0:_FOTsdi_JournalEntryPage_itemNode_FndTasksList::icon']")
	WebElement JournalsTaskImage;
	
	public void clickOnTaskBar() {
		JournalsTaskImage.click();
	}
	
	
	@FindBy(xpath="//*[@id='pt1:_FOr1:1:_FOSritemNode_general_accounting_journals:0:_FOTRaT:0:RAtl2']")
	WebElement linkCreateJournal;
	
	public CreateJournal clickOnCreateJournal() {
		clickOnTaskBar();
		linkCreateJournal.click();
		return PageFactory.initElements(driver, CreateJournal.class);
	}
	
	
	@FindBy (xpath="//a[@id='pt1:_FOr1:1:_FOSritemNode_general_accounting_journals:0:_FOTRaT:0:RAtl1']")
	WebElement linkManageJournals;
	
	public ManageJournals clickOnManageJournals() {
		linkManageJournals.click();
		return PageFactory.initElements(driver, ManageJournals.class);
	}
	
	
	
	public boolean changeDataAccess(String strChangeDataAccessSet) {
		boolean flag = false;
		try {
			Select sel = new Select(changeDataAccessSetElement);
			if (changeDataAccessSetElement.isDisplayed() && strChangeDataAccessSet.length()>0) {
				sel.selectByVisibleText(strChangeDataAccessSet);
				cmnLib.waitForPageLoaded();
				log.info("Change Data Access Set is Selected");
				flag = cmnLib.clickByJSE(OKButton);
				cmnLib.waitForPageLoaded();
				TimeUnit.SECONDS.sleep(5);
				log.info("OK button is clicked");
			} else if (changeDataAccessSetElement.isDisplayed()) {
				sel.selectByIndex(0);
				log.info("Change Data Access Set is selected by Index=0");
				flag = cmnLib.clickByJSE(OKButton);
				cmnLib.waitForPageLoaded();
				TimeUnit.SECONDS.sleep(5);
				log.info("OK button is clicked");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to Change Data Access Set");
		}

		return flag;
	}
	
	
	
	
}
