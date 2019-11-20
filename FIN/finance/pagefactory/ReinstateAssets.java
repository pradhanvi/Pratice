package finance.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ReinstateAssets extends TestBase {

	@FindBy(xpath = "//label[text()='Book']//parent::td//parent::tr//td[2]//select")
	public WebElement Book;

	@FindBy(xpath = "//button[text()='Reinstate']")
	public WebElement Reinstate;

	@FindBy(xpath = "//table[@summary='Search Results']/tbody/tr")
	public List<WebElement> tableRows_SearchResults;

	@FindBy(xpath = "//button[text()='Search']")
	public WebElement Search;

	@FindBy(xpath = "//button[contains(@id,'commandButton5')]")
	public WebElement Done;

	@FindBy(xpath = "//label[text()='Asset Number']//parent::td//parent::tr//td[2]//input")
	public WebElement AssetNumber;

	@FindBy(xpath = "//table[@summary='Search Results']")
	public WebElement table_Results;
	
	

	public ReinstateAssets() {
		PageFactory.initElements(driver, this);
		log.info("Reinstate Assets page is initialized...");
	}

	public boolean selectAssetFromResults(String strAssetNumber, ResultsSelect by) {
		boolean flag = false;
		try {
			Thread.sleep(3000);
			int iRowSize = tableRows_SearchResults.size();
			System.out.println("No. of Rows: " + iRowSize);
			for (WebElement row : tableRows_SearchResults) {
				WebElement tableDataAssetNumber = row.findElement(By.xpath("td[2]/div[1]/table/tbody/tr/td[1]"));
				String AssetNumber = tableDataAssetNumber.getText();
				System.out.println(AssetNumber);
				if (AssetNumber.equalsIgnoreCase(strAssetNumber)) {
					if (by.equals(ResultsSelect.Row)) {
						cmnLib.clickOnWebElement(row.findElement(By.xpath("td[1]")));
					} else if (by.equals(ResultsSelect.AssetNumber)) {
						cmnLib.clickOnWebElement(tableDataAssetNumber.findElement(By.tagName("a")));
					}
					flag = true;
					log.info("Selected row");
					break;
				}
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

	public String getAssetDetailFromResults(String strAssetNumber, String strColumnNumber) {
		String columnValue = null;
		try {
			if (cmnLib.waitForElementToBeVisible(table_Results)) {
				int iRowSize = tableRows_SearchResults.size();
				System.out.println("No. of Rows: " + iRowSize);
				for (WebElement row : tableRows_SearchResults) {
					WebElement tableDataAssetNumber = row.findElement(By.xpath("td[2]//table//td[1]"));
					String AssetNumber = tableDataAssetNumber.getText();
					if (AssetNumber.equalsIgnoreCase(strAssetNumber)) {
						columnValue = row.findElement(By.xpath("td[2]//table//td[" + strColumnNumber + "]")).getText();
						System.out.println(strColumnNumber + ": " + columnValue);
						log.info("Column value found");
						break;
					}
				}
			} else {
				log.info("Search Results table not found");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Unable to get Asset Detail from results");
		}
		return columnValue;

	}

	/************************************************************************************************************************
	 * Warning
	 **************************************************************************************************************************/
	@FindBy(xpath = "//button[contains(@id,'commandButton3')]")
	public WebElement Yes_Warning;
}
