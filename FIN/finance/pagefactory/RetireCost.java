package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class RetireCost extends TestBase {
	
	@FindBy(xpath = "//label[text()='Retire Date']//parent::td//parent::tr//td[2]//input")
	public WebElement RetireDate;

	@FindBy(xpath = "//input[contains(@id,'costRetired')]")
	public WebElement CostRetired;

	@FindBy(xpath = "//div[contains(@id,'commandButton7')]")
	public WebElement Submit;

	@FindBy(xpath = "//label[text()='Cost']//parent::td//parent::tr//td[2]//span")
	public WebElement Cost;

	@FindBy(xpath = "//label[text()='Check or Invoice Number']//parent::td//parent::tr//td[2]//input")
	public WebElement CheckOrInvoiceNumber;

	@FindBy(xpath = "//label[text()='Sold To']//parent::td//parent::tr//td[2]//input")
	public WebElement SoldTo;

	@FindBy(xpath = "//label[text()='Retirement Account']//parent::td//parent::tr//td[2]//input")
	public WebElement RetirementAccount;

	@FindBy(xpath = "//label[text()='Intercompany']//parent::td//parent::tr//td[2]//input")
	public WebElement Intercompany;

	public RetireCost() {
		PageFactory.initElements(driver, this);
		log.info("Retire Cost page is initialized...");
	}

}
