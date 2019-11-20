package finance.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class RetireAssets extends TestBase {

	@FindBy(xpath = "//label[text()='Book']//parent::td//parent::tr//td[2]//select")
	public WebElement Book;

	@FindBy(xpath = "//label[text()='Asset Number']//parent::td//parent::tr//td[2]//input")
	public WebElement AssetNumber;

	@FindBy(xpath = "//button[text()='Search']")
	public WebElement Search;

	@FindBy(xpath = "//table[@summary='Search Results']/tbody/tr")
	public List<WebElement> tableRows_SearchResults;
	
	@FindBy(xpath = "//button[text()='Retire Units']")
	public WebElement RetireUnits;	
	
	@FindBy(xpath = "//button[text()='Retire Cost']")
	public WebElement RetireCost;	
	
	@FindBy(xpath = "//button[contains(@id,'AP1:cb1')]")
	public WebElement Done;

	public RetireAssets() {
		PageFactory.initElements(driver, this);
		log.info("Retire Assets page is initialized...	");
	}

	public boolean selectAssetFromResults(String strAssetNumber, ResultsSelect by) {
		boolean flag = false;
		try {
			Thread.sleep(3000);
			int iRowSize = tableRows_SearchResults.size();
			System.out.println("No. of Rows: " + iRowSize);
			if (iRowSize > 0) {
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
			} else {
				log.info("No Assets found");
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

}
