package otm.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class OrderReleaseFinder extends TestBase {
	
	@FindBy(xpath = "//h1[contains(text(),'Order Release Finder')]")
	public WebElement header;
	
	@FindBy(xpath = "//iframe[@title='OTM']")
	public WebElement actionFrame;

	@FindBy(xpath = "//input[@name='order_release/xid']")
	public WebElement order_Relase_ID;

	@FindBy(id = "search_button")
	public WebElement search_button;
	
	@FindBy(id = "new")
	public WebElement newButton;
	
	

	public OrderReleaseFinder() {
		PageFactory.initElements(driver, this);
	}
	
	

	
}
