package finance.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

import finance.pagefactory.AdjustAssets.ResultsSelect;

public class CapitalizeCIPAssets extends TestBase {

	@FindBy(id = "_FOpt1:_FOr1:0:_FOSritemNode_fixed_assets_additions:0:MAnt2:1:pt1:SrchTF:0:AP1:q1:value00::content")
	public WebElement Book;

	@FindBy(xpath = "//select[contains(@id,'SrchTF:0:AP1:q1:value40::content')]")
	public WebElement AssetType;

	@FindBy(id = "_FOpt1:_FOr1:0:_FOSritemNode_fixed_assets_additions:0:MAnt2:1:pt1:SrchTF:0:AP1:q1:value20::content")
	public WebElement AssetNumber;

	@FindBy(id = "_FOpt1:_FOr1:0:_FOSritemNode_fixed_assets_additions:0:MAnt2:1:pt1:SrchTF:0:AP1:q1::search")
	public WebElement Search;

	@FindBy(xpath = "//table[@summary='Search Results: Assets']/tbody/tr")
	public List<WebElement> tableRows_SearchResults;

	@FindBy(id = "_FOpt1:_FOr1:0:_FOSritemNode_fixed_assets_additions:0:MAnt2:1:pt1:SrchTF:0:AP1:tbl1:_ATp:commton1")
	public WebElement ReverseCapitalize;

	@FindBy(xpath = "//button[contains(@id,'SrchTF:0:AP1:cb3')]")
	public WebElement Yes_Warning;

	@FindBy(xpath = "//button[contains(@id,'SrchTF:0:AP1:commandButton2')]")
	public WebElement Done;

	public CapitalizeCIPAssets() {
		PageFactory.initElements(driver, this);
		log.info("Capitalize CIP Assets page is initialized...");
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

}
