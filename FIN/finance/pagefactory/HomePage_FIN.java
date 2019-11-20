package finance.pagefactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.commons.TestBase;

import scm.pagefactory.ScheduledProcesses;

public class HomePage_FIN extends TestBase {

	@FindBy(xpath = "//h1[contains(text(),'Welcome, ')]")
	public WebElement HomePage_StringValidation;

	@FindBy(xpath = "//a[contains(@id,'UIShome')]")
	public WebElement HomePage_HomeIcon;

	@FindBy(xpath = "//span[contains(text(),'Employee News')]")
	public WebElement HomePage_StringValidation2;

	@FindBy(xpath = "//a[@title='Navigator']")
	public WebElement NavigatorIcon;

	@FindBy(xpath = "//h1[text()='Navigator']//ancestor::div[3]//a[text()='Invoices']")
	public WebElement Invoices;

	@FindBy(xpath = "//*[@id='groupNode_general_accounting']")
	public WebElement Role_GeneralAccounting;

	@FindBy(xpath = "//div[@id='pt1:_UISmmp::content']")
	public WebElement NavigatorContent;

	@FindBy(xpath = "//*[@id='itemNode_general_accounting_journals']")
	public WebElement Resp_Journals;

	@FindBy(xpath = "//select[contains(@id,'soc1::content')]")
	public WebElement changeDataAccessSetElement;

	@FindBy(xpath = "//button[contains(@id,'d1::ok')]")
	public WebElement OKButton;

	@FindBy(xpath = "//*[contains(@id,'pt1:nv_itemNode_tools_scheduled_processes')]")
	public WebElement ScheduledProcesses;

	@FindBy(xpath = "//h1[text()='Navigator']//ancestor::div[3]//a[text()='Assets']")
	public WebElement Assets;

	@FindBy(xpath = "//h1[text()='Navigator']//ancestor::div[3]//a[text()='Asset Inquiry']")
	public WebElement AssetInquiry;

	@FindBy(xpath = "//h1[text()='Navigator']//ancestor::div[3]//a[text()='Billing']")
	public WebElement Billing;

	@FindBy(xpath = "//h1[text()='Navigator']//ancestor::div[3]//a[text()='Journals']")
	public WebElement Journals;

	@FindBy(xpath = "//a[@id='pt1:nv_itemNode_tools_reports_and_analytics']")
	public WebElement ReportAndAnalytics;

	@FindBy(xpath = "//a[@id='pt1:nv_itemNode_collections_collections_dashboard']")
	public WebElement CollectionsLink;

	@FindBy(xpath = "//a[@id='pt1:nv_itemNode_receivables_billing']")
	public WebElement BillingLink;

	@FindBy(xpath = "//a[@id='pt1:nv_itemNode_receivables_receivables_balances']")
	public WebElement AccountsReceivable_Link;

	@FindBy(xpath = "//*[@id='pt1:nv_itemNode_payables_payables_invoices']")
	public WebElement InvoicesIcon;

	@FindBy(xpath = "//a[@title='Scheduled Processes']")
	public WebElement EleScheduledProcesses;

	@FindBy(xpath = "//h1[text()='Navigator']//ancestor::div[3]//a[text()='Payments']")
	public WebElement PaymentsLink;
	
	@FindBy(xpath = "//h1[text()='Navigator']//ancestor::div[3]//a[text()='Accounts Receivable']")
	public WebElement AccountsReceivable;
	
	@FindBy(xpath = "//h1[text()='Navigator']//ancestor::div[3]//a[text()='Revenue']")
	public WebElement Revenue;
	
	@FindBy(xpath = "//h1[text()='Navigator']//ancestor::div[3]//a[text()='Cash Balances']")
	public WebElement CashBalances;
	
	@FindBy(xpath = "//h1[text()='Navigator']//ancestor::div[3]//a[text()='Bank Statements and Reconcili...']")
	public WebElement BankStatementsAndReconciliation;
	
	@FindBy(xpath="//a[@id='pt1:nv_itemNode_general_accounting_general_accounting']")
    public WebElement GeneralAccountingDashboard;
	
	@FindBy(xpath="//h1[text()='Navigator']//ancestor::div[3]//a[text()='Budgetary Control']")
	public WebElement BudgetaryControl;
	
	@FindBy(xpath="//td/a[text()='Scheduled Processes']")
	public WebElement ScheduledProcessesLink;

	public HomePage_FIN() {
		PageFactory.initElements(driver, this);
	}

	public String getUserNameFromHomePage() {
		String strUserName = null;
		try {
//			clickOnWelcomePage_HomeIcon();

			driver.findElement(By.xpath("//img[contains(@id,'pt1:_UIScmil2u::icon')]")).isDisplayed();
			strUserName = driver.findElement(By.xpath("//img[contains(@id,'pt1:_UIScmil2u::icon')]")).getAttribute("title");
			System.out.println("UserName captured from HomePage: " + strUserName);
		} catch (Exception e) {
			System.out.println("UserName could not be captured from HomePage");
		}
		return strUserName;
	}

	public boolean clickOnWelcomePage_HomeIcon() {
		try {
			HomePage_HomeIcon.isDisplayed();
			HomePage_HomeIcon.click();
			log.info("Clicked on HomeIcon in HomePage");
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Home Icon in HomePage is not displayed...");
			return false;
		}
		return true;
	}

	public boolean validateWelcomePageWelcomeString() {

		if (HomePage_StringValidation.getText().toLowerCase().contains("welcome")) {
			log.info("Welcome Page Validation is successful");
			return true;
		}
		log.info("Welcome Page Validation is Un-successful");
		return false;
	}

	public boolean validateHomePageWelcomeString() throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(HomePage_StringValidation2));
		if (HomePage_StringValidation2.getText().toLowerCase().contains("employee news")) {
			log.info("Home Page Validation is successful");
			return true;
		}
		log.info("Home Page Validation is successful");
		return false;
	}

	public boolean changeDataAccess(String strChangeDataAccessSet) {
		boolean flag = false;
		try {
			Select sel = new Select(changeDataAccessSetElement);
			if (changeDataAccessSetElement.isDisplayed() && !(strChangeDataAccessSet.length()>0)) {
				sel.selectByVisibleText(strChangeDataAccessSet);
				log.info("Change Data Access Set is Selected");
				OKButton.click();
				flag = true;
				log.info("OK button is clicked");
			} else if (changeDataAccessSetElement.isDisplayed()) {
				sel.selectByIndex(0);
				log.info("Change Data Access Set is selected by Index=0");
				OKButton.click();
				log.info("OK button is clicked");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to Change Data Access Set");
		}

		return flag;
	}

	public void clickOnNavigationIcon() throws InterruptedException {
		NavigatorIcon.click();
		log.info("Navigation Icon is clicked");
		cmnLib.waitForPageLoaded();
		TimeUnit.SECONDS.sleep(5);
	}

	public AccountsReceivable clickOnAccountsReceivableLink() {

		if (cmnLib.clickOnWebElement(AccountsReceivable_Link)) {
			log.info("Accounts Receivable Link is Clicked");
		} else {
			log.info("Accounts Receivable Link is Not Clicked");
			return null;
		}
		cmnLib.waitForPageLoaded();
		return PageFactory.initElements(driver, AccountsReceivable.class);
	}

	public Billing clickOnBillingLink() {

		if (cmnLib.clickOnWebElement(BillingLink)) {
			log.info("Billing Link is Clicked");
		} else {
			log.info("Billing Link is Not Clicked");
			return null;
		}
		cmnLib.waitForPageLoaded();
		return PageFactory.initElements(driver, Billing.class);
	}
	
	public BankStatementsAndReconciliation clickOnBankStatementAndReconciliation() {

		if (cmnLib.clickOnWebElement(BankStatementsAndReconciliation)) {
			log.info("Bank Statements And Reconciliation Link is Clicked");
		} else {
			log.info("Bank Statements And Reconciliation Link is Not Clicked");
			return null;
		}
		cmnLib.waitForPageLoaded();
		return PageFactory.initElements(driver, BankStatementsAndReconciliation.class);
	}

	public ReportAndAnalytics clickOnReportAndAnalyticsLink() {

		if (cmnLib.clickOnWebElement(ReportAndAnalytics)) {
			log.info("ReportAndAnalytics Link is Clicked");
		} else {
			log.info("ReportAndAnalytics Link is Not Clicked");
			return null;
		}
		cmnLib.waitForPageLoaded();
		return PageFactory.initElements(driver, ReportAndAnalytics.class);
	}
	
	public ScheduledProcesses clickOnScheduledProcesses() {
		try {
			ScheduledProcessesLink.isDisplayed();
			//cmnLib.clickOnLinkText("Cost Accounting");
			cmnLib.clickOnWebElement(ScheduledProcessesLink);
			log.info("Scheduled Processes Link is Clicked");

		} catch (Exception e) {
			// TODO: handle exception
			log.info("Scheduled Processes Link is Not Clicked");
			return null;
		}
		return PageFactory.initElements(driver, ScheduledProcesses.class);
	}

}
