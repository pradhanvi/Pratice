package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ManualReconciliation extends TestBase{
	
	@FindBy (xpath = "//h1[contains(text(),'Manual Reconciliation')]")
	public WebElement ManualReconciliation_Header;

	public ManualReconciliation() {
		PageFactory.initElements(driver, this);
		log.info("Manual Reconciliation page is initialized...");
	}

}
