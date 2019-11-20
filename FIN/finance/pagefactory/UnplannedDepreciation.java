package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class UnplannedDepreciation extends TestBase {

	@FindBy(xpath = "//label[text()='Amount']//parent::td//parent::tr//td[2]//input")
	public WebElement Amount;

	@FindBy(xpath = "//label[text()='Depreciation Expense Account']//parent::td//parent::tr//td[2]//input")
	public WebElement DepreciationExpenseAccount;

	@FindBy(xpath = "//label[text()='Reason']//parent::td//parent::tr//td[2]//select")
	public WebElement Reason;

	@FindBy(xpath =  "//button[contains(@id,'commandButton1')]")
	public WebElement Submit;

	public UnplannedDepreciation() {
		PageFactory.initElements(driver, this);
		log.info("Unplanned Depreciation page is initialized");
	}

}
