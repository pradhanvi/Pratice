package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class AutoReversing extends TestBase {

	@FindBy(xpath = "//img[@title='Tasks']")
	public WebElement TaskPane;

	@FindBy(xpath = "//a[@id='_FOpt1:_FOr1:0:_FOSritemNode_general_accounting_journals:0:_FOTRaT:0:RAtl6']")
	public WebElement RunAutoreserve;
	
	@FindBy(xpath="//select[contains(@id,'paramDynForm_Attribute3_ATTRIBUTE3::content')]")
	public WebElement DataAccessSet;
	
	@FindBy(xpath="//select[contains(@id,'paramDynForm_Attribute1_ATTRIBUTE1::content')]")
	public WebElement Ledger;
	
	@FindBy(xpath="//select[contains(@id,'paramDynForm_Attribute2_ATTRIBUTE2::content')]")
	public WebElement ReversalPeriod;
	
	@FindBy(xpath="//div[contains(@id,'requestBtns:submitButton')]")
	public WebElement SubmitBtn;
	
	@FindBy(xpath="//button[contains(@id,'confirmSubmitDialog::ok')]")
	public WebElement OkBtn;
	
	

	public AutoReversing() {
		PageFactory.initElements(driver, this);
		log.info("AutoReversing Journal Page is initialized...");
	}

}
