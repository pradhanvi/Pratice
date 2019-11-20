package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class BudgetPeriodStatuses extends TestBase {
	
	@FindBy(xpath = "//img[@title='Tasks']")
	public WebElement TaskPane;
	
	@FindBy(xpath="//a[text()='Budget Period Statuses']")
	public WebElement BudgetPeriodStatuses;
	
	@FindBy(xpath="//a[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:r1:0:AP1:AT1:_ATp:ATt1:0:cl1']")
	public WebElement ControlBudget;
	
	@FindBy(xpath="//img[contains(@id,'ctb2::icon')]")
	public WebElement Edit;
	
	@FindBy(xpath="//input[contains(@id,'afr_status::content')]")
	public WebElement SearchIcon;
	
	@FindBy(xpath="//select[contains(@id,'ATt1:0:soc2::content')]")
	public WebElement Status;
	
	@FindBy(xpath="//button[@id='_FOd1::msgDlg::cancel']")
	public WebElement OK;
	
	@FindBy(xpath="//input[contains(@id,'pName::content')]")
	public WebElement Search;
	

	
	@FindBy(xpath="//span[contains(text(),'Save')]")
	public WebElement Save;
	
	
	
    public BudgetPeriodStatuses() {
	PageFactory.initElements(driver, this);
	log.info("Budget Period Statuses  Page is initialized...");
}

}