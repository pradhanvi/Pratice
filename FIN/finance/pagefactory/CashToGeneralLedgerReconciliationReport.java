package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class CashToGeneralLedgerReconciliationReport extends TestBase{
	
	@FindBy(xpath = "//label[text()='Name']//ancestor::tr[1]//td[text()='Cash to General Ledger Reconciliation Report']")
	public WebElement CashToGeneralLedgerReconciliationReport_Label;

	public CashToGeneralLedgerReconciliationReport() {
		PageFactory.initElements(driver, this);
		log.info("Cash to General Ledger Reconciliation Report page is initialized...");
	}

}
