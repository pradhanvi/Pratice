package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ManageAccountingPeriods extends TestBase{
	
	//@FindBy(xpath ="//span[contains(text(),'PEBPE_PL_OPER')]")
	//public WebElement Ledger;
	
	@FindBy(xpath = "//h1[contains(text(),'Manage Accounting Periods')]")
	public WebElement ManageAccountingPeriods_Header;
	
	@FindBy(xpath ="//div[contains(@id,'table1::db')]")
	public WebElement LedgerTable;
	
	@FindBy(id ="_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:AT1:_ATp:table1:0:ot9")
	public WebElement AccountingPeriod;
	
	@FindBy(id ="_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:1:ap1:AT1:_ATp:ctb3")
	public WebElement ClosePeriod;
	
	@FindBy(id ="_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:1:ap1:AT1:_ATp:ctb1")
	public WebElement OpenPeriod;
	
	@FindBy(xpath ="//span[@title ='\"Confirmation']")
	public WebElement CofirmationMsg;
	
	@FindBy(id ="_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:1:ap1:d13::ok")
	public WebElement SumbitOkBtn;
	
	public ManageAccountingPeriods() {
		PageFactory.initElements(driver, this);
	}
	
	
}
