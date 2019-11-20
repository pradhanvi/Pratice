package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ManageAllBooks extends TestBase{
	
	@FindBy (xpath = "//h1[contains(text(),'Manage All Books')]")
	public WebElement ManageAllBooks_Header;

	public ManageAllBooks() {
		PageFactory.initElements(driver, this);
		log.info("Manage All Books page is initialized...");
	}

}
