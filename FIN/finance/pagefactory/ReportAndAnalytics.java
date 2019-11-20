package finance.pagefactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.commons.TestBase;

public class ReportAndAnalytics extends TestBase{

	
	@FindBy(xpath = "//img[@title='Hierarchical Selector']")
	public WebElement HierarchicalSelector;
	
	@FindBy(xpath = "//a[.='Shared Folders']")
	public WebElement SharedFolder;
	
	@FindBy(xpath = "//table[@summary='Search']/tbody/tr[1]/td[2]")
	public WebElement SearchTable;
	
	@FindBy(xpath = "//a[text()='Extension']/ancestor::tr[2]/td[3]")
	public WebElement Extension_td3;
	
	@FindBy(xpath = "//a[@title='Financials']")
	public WebElement Financials;
	 
	@FindBy(xpath = "//a[@title='Receivables']")
	public WebElement Receivables;
	
	@FindBy(xpath = "//a[@title='Period Close']")
	public WebElement PeriodClose;
	
	@FindBy(xpath = "//a[@title='Adjustment Register']")
	public WebElement AdjustmentRegister;
	
	@FindBy(xpath = "//table[@summary='Search']//a[.='Adjustment Register']")
	public WebElement AdjustmentRegisterPage;
	
	@FindBy(xpath = "//iframe[contains(@id, 'biDashboard')]")
	public WebElement iframe;
	
	@FindBy(xpath = "//tr/td[contains(@class, 'masterPrompt promptLabel') and contains(., 'Business Unit')]/parent::tr//input")
	public WebElement BusinessUnit;
	
	@FindBy(xpath = "//tr/td[contains(@class, 'masterPrompt promptLabel') and contains(., 'Adjustment Accounting Date')]/parent::tr//td[@class='promptControl'][1]//input")
	public WebElement Adjustment_AccountingStartDate;
	
	@FindBy(xpath = "//tr/td[contains(@class, 'masterPrompt promptLabel') and contains(., 'Adjustment Accounting Date')]/parent::tr//td[@class='promptControl'][2]//input")
	public WebElement Adjustment_AccountingEndDate;
	
	@FindBy(xpath = "//input[@name='gobtn' and @value='Apply']")
	public WebElement ApplyBtn;
	
	@FindBy(xpath = "//a[text()='Refresh']")
	public WebElement RefreshLink;
	
	@FindBy(xpath = "//td[@class='PTChildPivotTable']")
	public WebElement AdjustmentRegister_Results;
	
	@FindBy(xpath = "//a[contains(text(), 'Adobe Flash Player')]")
	public WebElement AdobeFlashPlayerLink;
	
	
	public ReportAndAnalytics() {
		PageFactory.initElements(driver, this);
		System.out.println("ReportAndAnalytics is Initialized...");
	}
	
	public boolean clickOnFinacials() {
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(Extension_td3).click();
			actions.sendKeys(Keys.PAGE_DOWN).build().perform();
			log.info("Moved to given element");
			return cmnLib.clickByJSE(Financials) ? true : false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Unable to move to given element");
		}
		return false;
	}
	
	public void clickOnAdobeFlashPlayerLink() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(AdobeFlashPlayerLink));
			AdobeFlashPlayerLink.click();
			TimeUnit.SECONDS.sleep(2);
			driver.switchTo().alert().accept();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
