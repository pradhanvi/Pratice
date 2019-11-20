package otm.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class GenerateCustomReports extends TestBase {
	
	@FindBy(xpath="//select[@name='report']")
	public WebElement OrderRelease_ReportName;
	
	@FindBy(name="submit_report")
	public WebElement submitButton;
	
	@FindBy(xpath="//select[@name='output_type']")
	public WebElement formateType;
	

	public GenerateCustomReports() {
		PageFactory.initElements(driver, this);
		log.info("Genarate Custom reports page is intiliased");
	}
	
	public void clickSubmit() {
		submitButton.click();
		log.info("Clicked Submit button");
	}
	
	
}
