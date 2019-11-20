package finance.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class AdjustAssets extends TestBase {

	@FindBy(xpath = "//label[text()='Book']//parent::td//parent::tr//td[2]//select")
	public WebElement Book;

	@FindBy(xpath = "//input[contains(@id,'SrchTF:0:AP2:q1:value20::content')]")
	public WebElement AssetNumber;

	@FindBy(xpath = "//button[contains(@id,'SrchTF:0:AP2:q1::search')]")
	public WebElement Search;

	@FindBy(xpath = "//a[text()='Actions']")
	public WebElement Actions_Dropdown;

	@FindBy(xpath = "//table[contains(@id,'SrchTF:0:AP2:tbl1:_ATp:ATm::ScrollContent')]/tbody/tr")
	public List<WebElement> Actions_Dropdown_Values;

	@FindBy(id = "_FOpt1:_FOr1:0:_FOSritemNode_fixed_assets_additions:0:MAnt2:1:SrchTF:0:AP2:tbl1:_ATp:chgFinDetBtn")
	public WebElement ChangeFinancialDetails;

	@FindBy(xpath = "//div[contains(@id,'t1::db')]")
	public WebElement table_SearchResults;

	@FindBy(xpath = "//div[contains(@id,'t1::db')]/table/tbody/tr")
	public List<WebElement> tableRows_SearchResults;

	@FindBy(xpath = "//button[contains(@id,'SrchTF:0:AP2:done')]")
	public WebElement Done;

	public AdjustAssets() {
		PageFactory.initElements(driver, this);
		log.info("Adjus Assets Page is Initialized...");
	}

	public boolean selectAssetFromResults(String strAssetNumber, ResultsSelect by) {
		boolean flag = false;
		try {
			if (cmnLib.waitForElementToBeVisible(table_SearchResults)) {
				int iRowSize = tableRows_SearchResults.size();
				System.out.println("No. of Rows: " + iRowSize);
				for (WebElement row : tableRows_SearchResults) {
					WebElement tableDataAssetNumber = row.findElement(By.xpath("td[2]/div[1]/table/tbody/tr/td[1]"));
					String AssetNumber = tableDataAssetNumber.getText();
					System.out.println(AssetNumber);
					if (AssetNumber.equalsIgnoreCase(strAssetNumber)) {
						System.out.println("Matched: " + AssetNumber);
						if (by.equals(ResultsSelect.Row)) {
							flag = cmnLib.clickOnWebElement(
									driver.findElement(By.xpath("//div[contains(@id,'t1::db')]/table/tbody/tr/td[1]")));
						} else if (by.equals(ResultsSelect.AssetNumber)) {
							flag = cmnLib.clickOnWebElement(tableDataAssetNumber.findElement(By.tagName("a")));
						}
						log.info("Selected result item");
						break;
					}
				}
			} else {
				log.info("Results table not found");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Unable to select row in results");
		}
		return flag;
	}

	public enum ResultsSelect {
		Row, AssetNumber;
	}

	public boolean selectValueFromActionsDropdown(String strValue) {
		boolean flag = false;
		try {
			if (Actions_Dropdown_Values.size() > 0) {
				for (WebElement row : Actions_Dropdown_Values) {
					WebElement valueElement = row.findElement(By.xpath("td[2]"));
					if (valueElement.getText().equalsIgnoreCase(strValue)) {
						cmnLib.clickOnWebElement(valueElement);
						flag = true;
						log.info("Selected value from Actions dropdown");
						break;
					}
				}
			} else {
				log.info("No values found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to select value from Actions dropdown");
		}
		return flag;
	}

}
