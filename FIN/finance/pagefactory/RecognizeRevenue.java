package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class RecognizeRevenue extends TestBase{
	
	@FindBy(xpath = "//label[text()='Name']//ancestor::tr[1]//td[text()='Recognize Revenue']")
	public WebElement RecognizeRevenue_Label;

	public RecognizeRevenue() {
		PageFactory.initElements(driver, this);
		log.info("Recognize Revenue page is initialized...");
	}

}
