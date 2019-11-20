package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class BankStatementReport extends TestBase{
	
	@FindBy(xpath = "//label[text()='Name']//ancestor::tr[1]//td[text()='Bank Statement Report']")
	public WebElement BankStatementReport_Label;

	public BankStatementReport() {
		PageFactory.initElements(driver, this);
		log.info("Bank Statement Report page is initialized...");
	}

}
