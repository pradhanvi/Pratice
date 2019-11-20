package scm.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ReceiptAccounting extends TestBase {
	
	@FindBy(xpath="//a[contains(@id,'_FOSsdiitemNode_costing_receipt_accounting')]")
	public WebElement ReceiptAccountingIcon;
	
	@FindBy(xpath="//img[contains(@id,'TaskList::icon')]")
	public WebElement TasksIcon;
	
	@FindBy(xpath="//a[text()='Create Receipt Accounting Distributions']")
	public WebElement CreateReceiptAccountingDistributionLink;
	
	
	
	public ReceiptAccounting() {
		PageFactory.initElements(driver, this);
		log.info("ReceiptAccounting is initialized");
	}

}
