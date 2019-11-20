package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class PrepareSourceLines extends TestBase{
	
	@FindBy (xpath = "//h1[contains(text(),'Prepare Source Lines')]")
	public WebElement PrepareSourceLines_Header;

	public PrepareSourceLines() {
		PageFactory.initElements(driver, this);
		log.info("Prepare Source Lines page is initialized...");
	}

}
