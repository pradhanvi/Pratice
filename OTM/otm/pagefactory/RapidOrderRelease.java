package otm.pagefactory;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.Common_Library.DropDownSelectBy;
import com.commons.TestBase;

public class RapidOrderRelease extends TestBase {

	@FindBy(xpath = "//h1[contains(text(),'Rapid Order Release')]")
	public WebElement header;

	@FindBy(xpath = "//h1[contains(text(),'Results')]")
	public WebElement resultsHeader;

	@FindBy(xpath = "//input[@id='order_release/source/xid']")
	public WebElement pickupLocation;

	@FindBy(xpath = "//input[@id='order_release/destination/xid']")
	public WebElement destinationLocation;

	@FindBy(name = "ship_unit/ship_unit_count@PRF")
	public WebElement shipUnitCount;

	@FindBy(xpath = "//select[@name='ship_unit/transport_handling_unit/xid@ID']")
	public WebElement shipUnitSpecID;

	@FindBy(xpath = "//table[@id='table_ship_unit_grid']//a[text()='Save']")
	public WebElement save_Grid1;

	@FindBy(name = "submit")
	public WebElement submit;

	public RapidOrderRelease() {
		PageFactory.initElements(driver, this);
	}

	public void selectshipUnitSpecID(String optionToSelect) {
		cmnLib.selectDropdownBy(shipUnitSpecID, optionToSelect, DropDownSelectBy.VisibleText);
	}

	public void clickSubmit() {
		submit.click();
		log.info("Clicked Submit button");
	}

	public boolean verifyResultsHeader() {
		try {
			cmnLib.waitForElementToBeClickable(resultsHeader);
			resultsHeader.isDisplayed();
			log.info("Order Release Finder Results header displayed");
			return true;
		} catch (NoSuchElementException e) {
			log.info("Order Release Finder Results header not displayed");
			return false;
		}
	}

}
