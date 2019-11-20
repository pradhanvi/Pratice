package finance.pagefactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.commons.TestBase;


public class ManageJournals extends TestBase{

	@FindBy  (xpath="//h1[contains(text(),'Manage Journals')]")
	public WebElement ManageJournalsPage_StringValidation;
	
	@FindBy(xpath = "//img[@title='Tasks']")
	public WebElement TaskPane;
	
	@FindBy(xpath="//a[@id='_FOpt1:_FOr1:0:_FOSritemNode_general_accounting_journals:0:_FOTRaT:0:RAtl1']")
	public WebElement ManageJournals;
	
	@FindBy(xpath="//img[contains(@id,'ATp:create::icon')]")
	public WebElement CreateJournal;
	
	@FindBy(xpath="//input[contains(@id,'showLessBatchName::content')]")
	public WebElement JournalBatch1;
	
	@FindBy(xpath="//textarea[contains(@id,'showLessBatchDescription::content')]")
	public WebElement Description;
	
	@FindBy(xpath="//input[contains(@id,'showLessJournalName::content')]")
	public WebElement Journal1;
	
	@FindBy(xpath="//textarea[contains(@id,'showLessJournalDescription::content')]")
	public WebElement JournalDescription;
	
	@FindBy(xpath="//input[contains(@id,'userJeCategoryNameId1::content')]")
	public WebElement CategoryName;
	
	@FindBy(xpath="//img[contains(@id,'accountKBIMG::icon')]")
	public WebElement AccountIcon;
	
	@FindBy(xpath="//a[contains(@id,'accountSPOP_query:value00::lovIconId')]")
	public WebElement LegalEntity;

	@FindBy(xpath="//a[contains(@id,'accountSPOP_query:value10::lovIconId')]")
	public WebElement BusinessArea;
	
	@FindBy(xpath="//a[contains(@id,'accountSPOP_query:value20::lovIconId')]")
	public WebElement CostCenter;

	@FindBy(xpath="//a[contains(@id,'accountSPOP_query:value30::lovIconId')]")
	public WebElement Account;
	
	@FindBy(xpath="//a[contains(@id,'accountSPOP_query:value40::lovIconId')]")
	public WebElement InterCompany;

	@FindBy(xpath="//a[contains(@id,'accountSPOP_query:value50::lovIconId')]")
	public WebElement Fiscal;
	
	@FindBy(xpath="//a[contains(@id,'accountSPOP_query:value60::lovIconId')]")
	public WebElement Brand;

	@FindBy(xpath="//a[contains(@id,'accountSPOP_query:value70::lovIconId')]")
	public WebElement Future;

	@FindBy(xpath="//button[contains(@id,'jeLineAppTable:_ATp:t3:0:accountSEl')]")
	public WebElement Ok;

	public ManageJournals() {
		PageFactory.initElements(driver, this);
		log.info("ManageJournals initiated...");
	}
	public boolean validateManageJournalsString()	{
		
		if(ManageJournalsPage_StringValidation.getText().toLowerCase().contains("Manage Journals")){
			return true;
		}
		return false;
	}
	
	
	@FindBy (xpath="//*[@id='pt1:_FOr1:1:_FOSritemNode_general_accounting_journals:0:MAnt2:1:pt1:ap1:queryP:operator0::content']")
	WebElement JournalSearchCriteria;
	
	public void journalSearchCriteria(String strJournalSearchCriteria) {
		Select sel = new Select(JournalSearchCriteria);
		sel.selectByVisibleText(strJournalSearchCriteria);
	}
	@FindBy (xpath="//*[@id='pt1:_FOr1:1:_FOSritemNode_general_accounting_journals:0:MAnt2:1:pt1:ap1:queryP:value00::content']")
	WebElement Journal;
	
	public void journal(String strJournal) {
		Journal.sendKeys(strJournal);
	}
	
	@FindBy (xpath="//*[@id='pt1:_FOr1:1:_FOSritemNode_general_accounting_journals:0:MAnt2:1:pt1:ap1:queryP:operator1::content']")
	WebElement JournalBatchSearchCriteria;
	
	public void journalBatchSearchCriteria(String strJournalBatchSearchCriteria) {
		Select sel = new Select(JournalBatchSearchCriteria);
		sel.selectByVisibleText(strJournalBatchSearchCriteria);
	}
	
	@FindBy (xpath="//*[@id='pt1:_FOr1:1:_FOSritemNode_general_accounting_journals:0:MAnt2:1:pt1:ap1:queryP:value10::content']")
	WebElement JournalBatch;
	
	public void journalBatch(String strJournalBatch) {
		JournalBatch.sendKeys(strJournalBatch);
	}
	
	@FindBy (xpath="//*[@id='pt1:_FOr1:1:_FOSritemNode_general_accounting_journals:0:MAnt2:1:pt1:ap1:queryP:operator2::content']")
	WebElement AccountingPeriodSearchCriteria;
	
	public void accountingPeriodSearchCriteria(String strAccountingPeriodSearchCriteria) {
		Select sel = new Select(AccountingPeriodSearchCriteria);
		sel.selectByVisibleText(strAccountingPeriodSearchCriteria);
	}
	
	@FindBy (xpath="//*[@id='pt1:_FOr1:1:_FOSritemNode_general_accounting_journals:0:MAnt2:1:pt1:ap1:queryP:value20::content']")
	WebElement AccountingPeriod;
	public void accountingPeriod(String strAccountingPeriod) {
		AccountingPeriod.sendKeys(strAccountingPeriod);
	}
	
	@FindBy (xpath="//*[@id='pt1:_FOr1:1:_FOSritemNode_general_accounting_journals:0:MAnt2:1:pt1:ap1:queryP:operator5::content']")
	WebElement BatchStatusSearchCriteria;
	
	public void batchStatusSearchCriteria(String strBatchStatusSearchCriteria) {
		Select sel = new Select(BatchStatusSearchCriteria);
		sel.selectByVisibleText(strBatchStatusSearchCriteria);
	}
	
	@FindBy (xpath="//*[@id='pt1:_FOr1:1:_FOSritemNode_general_accounting_journals:0:MAnt2:1:pt1:ap1:queryP:value50::content']")
	WebElement BatchStatus;
	public void batchStatus(String strBatchStatus) {
		Select sel = new Select(BatchStatus);
		sel.selectByVisibleText(strBatchStatus);
	}
	
	@FindBy (xpath = "//button[@id='pt1:_FOr1:1:_FOSritemNode_general_accounting_journals:0:MAnt2:1:pt1:ap1:queryP::search']")
	WebElement SearchButton;
	
	public void clickOnSearchButton() {
		SearchButton.click();
	}
	
	//@FindBy (xpath = "//table[@summary='Search Results']/tbody/tr[1]/td[3]/a")
	public void searchAndClickOnJournalLink(String strJournalName) {
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@summary='Search Results']/tbody/tr"));
		int iNoOfRowsinSearchResultTable = rows.size();
		for (int j = 1; j <= iNoOfRowsinSearchResultTable; j++) {
			String strValue = driver.findElement(By.xpath("//table[@summary='Search Results']/tbody/tr["+j+"]/td[3]/a")).getText();
			
			if(strValue != null && strValue.equalsIgnoreCase(strJournalName))
			{
				
			}
		}
	}
	
	public boolean selectLegalEntity(String strLegalEntityValue) {
		boolean result = false;
		try {
			
			if(cmnLib.clickOnWebElement(LegalEntity)) {
			
				driver.findElement(By.xpath("//td[text()='" + strLegalEntityValue + "']")).click();
			
				TimeUnit.SECONDS.sleep(5);
				cmnLib.waitForPageLoaded();
				result = true;
			}else {
				log.info("Could not click on the Legal Entity type webelement");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Exception: selectLegalEntity");
		}
		return result;
	}

	public boolean selectBusinessArea(String strBusinessAreaValue) {
		boolean result = false;
		try {
			
			if(cmnLib.clickOnWebElement(BusinessArea)) {
			
				driver.findElement(By.xpath("//td[text()='" + strBusinessAreaValue + "']")).click();
			
				TimeUnit.SECONDS.sleep(5);
				cmnLib.waitForPageLoaded();
				result = true;
			}else {
				log.info("Could not click on the Business Area type webelement");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Exception: selectBusinessArea");
		}
		return result;
	}
	
	
	public boolean selectCostCenter(String strCostCenterValue) {
		boolean result = false;
		try {
			
			if(cmnLib.clickOnWebElement(CostCenter)) {
			
				driver.findElement(By.xpath("//td[text()='" + strCostCenterValue + "']")).click();
			
				TimeUnit.SECONDS.sleep(5);
				cmnLib.waitForPageLoaded();
				result = true;
			}else {
				log.info("Could not click on the Cost Center Value type webelement");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Exception: selectCostCenter");
		}
		return result;
	}

	public boolean selectAccount(String strAccountValue) {
		boolean result = false;
		try {
			
			if(cmnLib.clickOnWebElement(Account)) {
			
				driver.findElement(By.xpath("//td[text()='" + strAccountValue + "']")).click();
			
				TimeUnit.SECONDS.sleep(5);
				cmnLib.waitForPageLoaded();
				result = true;
			}else {
				log.info("Could not click on the Account Value type webelement");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Exception: selectAccount");
		}
		return result;
	}
	
	
	public boolean selectInterCompany(String strInterCompanyValue) {
		boolean result = false;
		try {
			
			if(cmnLib.clickOnWebElement(InterCompany)) {
			
				driver.findElement(By.xpath("//td[text()='" + strInterCompanyValue + "']")).click();
			
				TimeUnit.SECONDS.sleep(5);
				cmnLib.waitForPageLoaded();
				result = true;
			}else {
				log.info("Could not click on the InterCompany type webelement");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Exception: selectInterCompany");
		}
		return result;
	}

	public boolean selectFiscal(String strFiscalValue) {
		boolean result = false;
		try {
			
			if(cmnLib.clickOnWebElement(Fiscal)) {
			
				driver.findElement(By.xpath("//td[text()='" + strFiscalValue + "']")).click();
			
				TimeUnit.SECONDS.sleep(5);
				cmnLib.waitForPageLoaded();
				result = true;
			}else {
				log.info("Could not click on the Fiscal type webelement");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Exception: selectFiscal");
		}
		return result;
	}

	public boolean selectBrand(String strBrandValue) {
		boolean result = false;
		try {
			
			if(cmnLib.clickOnWebElement(Brand)) {
			
				driver.findElement(By.xpath("//td[text()='" + strBrandValue + "']")).click();
			
				TimeUnit.SECONDS.sleep(5);
				cmnLib.waitForPageLoaded();
				result = true;
			}else {
				log.info("Could not click on the Brand type webelement");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Exception: selectBrand");
		}
		return result;
	}


	public boolean selectFuture(String strFutureValue) {
		boolean result = false;
		try {
			
			if(cmnLib.clickOnWebElement(Future)) {
			
				driver.findElement(By.xpath("//td[text()='" + strFutureValue + "']")).click();
			
				TimeUnit.SECONDS.sleep(5);
				cmnLib.waitForPageLoaded();
				result = true;
			}else {
				log.info("Could not click on the Future type webelement");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Exception: selectFuture");
		}
		return result;
	}
	
	
}
