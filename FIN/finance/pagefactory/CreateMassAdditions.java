package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class CreateMassAdditions extends TestBase{
	
	@FindBy(xpath = "//label[text()='Name']//ancestor::tr[1]//td[text()='Create Mass Additions']")
	public WebElement CreateMassAdditions_Label;

	public CreateMassAdditions() {
		PageFactory.initElements(driver, this);
		log.info("Create Mass Additions page is initialized...");
	}

}
