package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ReceivablesToLedgerReconciliation extends TestBase{
	
	@FindBy(xpath = "//h1[contains(text(),'Receivables to Ledger Reconciliation')]")
	public WebElement LedgerReconciliation_Header;

	
	@FindBy(xpath = "//iframe[contains(@name, 'biDashboard') and contains(@name, 'biExecBinding1_iframe')]")
	public WebElement iframe;
	
	@FindBy(xpath = "//td[@class='masterPrompt promptLabel' and contains(., '* Ledger')]/parent::tr//input")
	public WebElement Ledger; //table[@class='TestLayoutTable']/tbody/tr/td[contains(., '* Ledger')]//input
	
	@FindBy(xpath = "//td[@class='masterPrompt promptLabel' and contains(., '* Request Name')]/parent::tr//input")
	public WebElement SelectRequestName; //table[@class='TestLayoutTable']/tbody/tr/td[contains(., '* Request Name')]//input
	
	@FindBy(xpath = "//input[@id='gobtn']")
	public WebElement ApplyButton;
	
	@FindBy(xpath = "//td[@class='PTChildPivotTable']//tr[contains(., 'Accounting End Balance')]/td[3]")
	public WebElement AccountingEndBalance;
	
	public ReceivablesToLedgerReconciliation() {
		PageFactory.initElements(driver, this);
		log.info("ReceivablesToLedgerReconciliation initiated...");
	}
	
	public String getAccountingEndBalance() {
		String result = null;
		try {
			if(cmnLib.waitForElementToBeVisible(AccountingEndBalance)) {
				cmnLib.scrollTillVisibilityOfElement(AccountingEndBalance);
				System.out.println("getAccountingEndBalance: "+AccountingEndBalance.getText());
				if(AccountingEndBalance.getText().length() > 0) {
					String strAccEndBal = AccountingEndBalance.getText().replace(",", "");
					System.out.println("After Parsing: "+Double.parseDouble(strAccEndBal));
					return Double.parseDouble(strAccEndBal) > 0 ? ""+Double.parseDouble(strAccEndBal) : null;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Exception in getAccountingEndBalance");
		}
		return result;
	}
	
}
