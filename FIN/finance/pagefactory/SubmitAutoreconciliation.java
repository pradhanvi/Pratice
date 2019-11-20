package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class SubmitAutoreconciliation extends TestBase{
	
	@FindBy(xpath = "//label[text()='Name']//ancestor::tr[1]//td[text()='Autoreconcile Bank Statements']")
	public WebElement AutoreconcileBankStatement_Label;

	public SubmitAutoreconciliation() {
		PageFactory.initElements(driver, this);
		log.info("Submit Autoreconciliation page is initialized...");
	}

}
