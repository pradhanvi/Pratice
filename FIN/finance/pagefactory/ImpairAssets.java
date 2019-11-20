package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ImpairAssets extends TestBase{
	
	@FindBy (xpath = "//h1[contains(text(),'Impair Assets')]")
	public WebElement ImpairAssets_Header;

	public ImpairAssets() {
		PageFactory.initElements(driver, this);
		log.info("Impair Assets page is initialized...");
	}

}
