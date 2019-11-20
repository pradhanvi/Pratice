package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class AR_Reconcilitation extends TestBase {
	
	
@FindBy(id="pt1:nv_itemNode_receivables_receivables_balances")
public WebElement AccountReceivable;

@FindBy(xpath = "//img[@title='Tasks']")
public WebElement TaskPane;


@FindBy(xpath="//a[@id='_FOpt1:_FOr1:0:_FOSritemNode_receivables_receivables_balances:0:_FOTRaT:0:RAtl24']")
public WebElement ReceivablesReconciliation;

@FindBy(xpath="//h1[text()='Receivables to Ledger Reconciliation']")
public WebElement ReceivablesHeader;

@FindBy(xpath="//td[text()='Accounting End Balance']")
public WebElement DifferenceValidation;
	
	
	

	
	

	
public AR_Reconcilitation() 
{
	PageFactory.initElements(driver, this);
}
	

}