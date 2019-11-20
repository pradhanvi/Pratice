package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class TransferAssets extends TestBase{
	
	@FindBy (xpath = "//h1[contains(text(),'Transfer Assets')]")
	public WebElement TransferAssets_Header;

	public TransferAssets() {
		PageFactory.initElements(driver, this);
		log.info("Transfer Assets page is initialized...");
	}

}
