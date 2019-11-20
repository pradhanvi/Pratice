package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ImportJournals extends TestBase{
	
	@FindBy(xpath = "//label[text()='Name']//ancestor::tr[1]//td[text()='Import Journals']")
	public WebElement ImportJournals_Label;

	public ImportJournals() {
		PageFactory.initElements(driver, this);
		log.info("Import Journals page is initialized...");
	}

}
