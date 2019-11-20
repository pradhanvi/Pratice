package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class AP_Reconciliation extends TestBase {

	
@FindBy(xpath = "//img[@title='Tasks']")
public WebElement TaskPane;

@FindBy(id = "pt1:nv_itemNode_payables_payables_invoices")
public WebElement Invoices;

@FindBy(xpath="//a[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:_FOTRaT:0:RAtl15']")
public WebElement PayablesToLedger;

@FindBy(xpath="//h1[text()='Payables to Ledger Reconciliation Report']")
public WebElement PayablesHeader;

public AP_Reconciliation() 
{
	PageFactory.initElements(driver, this);
}
	

	
}