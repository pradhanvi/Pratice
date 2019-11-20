package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class RetireUnits extends TestBase {
	
	@FindBy(xpath = "//label[text()='Retire Date']//parent::td//parent::tr//td[2]//input")
	public WebElement RetireDate;

	@FindBy(xpath = "//input[contains(@id,'UnitsRetired')]")
	public WebElement RetiredUnits;
	
	@FindBy(xpath = "//label[text()='Retirement Reason']//parent::td//parent::tr//td[2]//select")
	public WebElement RetirementReason;
	
	@FindBy(xpath = "//label[text()='Retirement Convention']//parent::td//parent::tr//td[2]//select")
	public WebElement RetirementConvention;
	
	@FindBy(xpath = "//table[@summary='Assignment Details']/tbody/tr/td[3]/div/table/tbody/tr/td[2]")
	public WebElement Units;
	
	@FindBy(xpath = "//label[text()='Check or Invoice Number']//parent::td//parent::tr//td[2]//input")
	public WebElement CheckOrInvoiceNumber;

	@FindBy(xpath = "//label[text()='Sold To']//parent::td//parent::tr//td[2]//input")
	public WebElement SoldTo;

	@FindBy(xpath = "//label[text()='Retirement Account']//parent::td//parent::tr//td[2]//input")
	public WebElement RetirementAccount;

	@FindBy(xpath = "//label[text()='Intercompany']//parent::td//parent::tr//td[2]//input")
	public WebElement Intercompany;
	
	@FindBy(xpath = "//div[contains(@id,'AP3:cb4')]")
	public WebElement Submit;

	public RetireUnits() {
		PageFactory.initElements(driver, this);
		log.info("Retire Units page is initialized...");
	}

}
