package finance.pagefactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class CollectionsPage extends TestBase{

	@FindBy(xpath = "//select[@id='_FOpt1:_FOr1:0:_FONSr2:0:_FOTsr1:0:AP1:r1:0:soc1::content']")
	public WebElement SearchBy_DropDown; //Customer by Name
								
	@FindBy(xpath = "//input[@id='_FOpt1:_FOr1:0:_FONSr2:0:_FOTsr1:0:AP1:r1:0:it1::content']")
	public WebElement SearchValue;

	@FindBy(xpath = "//button[@title='Search']")
	public WebElement SearchButton;

	@FindBy(xpath = "//table[@summary='Customer Search']")
	public WebElement SearchResultsTable;
	
	@FindBy(xpath = "//a[@title='Customer Hierarchy']")
	public WebElement CustomerHierarchyIcon;
	
	@FindBy(xpath = "//table[@summary='Customer Search']/tbody/tr")
	public List<WebElement> CustomerSearchResultRows;
	
	/*@FindBy(xpath = "//a[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:AP1:tab_details::disAcr']")
	public WebElement Profile_Details;*/
	public CollectionsPage() {
		PageFactory.initElements(driver, this);
		log.info("CollectionsPage initiated...");
	}
	public boolean selectCustomerFromSearchResults(String strCustomerNum) {
		boolean result = false;
		try {
			if(strCustomerNum.length() == 0) {
				log.info("Customer Number is empty/blank");
				return false;
			}
			
			System.out.println("No Of Rows in Search Results Table: "+CustomerSearchResultRows.size());
			if(CustomerSearchResultRows.size() > 0) {
				for (WebElement eachTR : CustomerSearchResultRows) {
					List<WebElement> listTDs = eachTR.findElements(By.tagName("td"));
					for (WebElement eachTD : listTDs) {
						System.out.println("Search Results Table TD value: "+eachTD.getText());
						if(eachTD.getText().contains(strCustomerNum)) {
							eachTR.findElements(By.tagName("a")).get(0).click();
							log.info("Selected the Customer with Customer Number: "+strCustomerNum);
							result = true;
							cmnLib.waitForPageLoaded();
							break;
						}
					}
					
				}
				
				/**
				 * Below Old is Commented
				 */
				/*for (int i = 1; i <= CustomerSearchResultRows.size(); i++) {
					
					if(driver.findElement(By.xpath("//table[@summary='Customer Search']/tbody/tr["+i+"]//*[contains(text(), '"+strCustomerNum+"')]")).isDisplayed()) {
						result = true;
						driver.findElement(By.xpath("//table[@summary='Customer Search']/tbody/tr["+i+"]")).click();
						TimeUnit.SECONDS.sleep(2);
						driver.findElement(By.xpath("//table[@summary='Customer Search']/tbody/tr["+i+"]//a")).click();
						cmnLib.waitForPageLoaded();
						log.info("Selected the Customer with Customer Number: "+strCustomerNum);
						result = true;
						break;
					}
				}*/
			}else {
				log.info("TableRows row count is less than zero !!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception: Could not search the Customer from Customer Search Results popup window");
		}
		return result;
	}
	
	public boolean clickOnTabs(String strTabName) throws InterruptedException{
		boolean result = false;
		cmnLib.waitForPageLoaded();
		result = cmnLib.clickOnWebElement(driver.findElement(By.xpath("//a[contains(text(),'"+strTabName+"')]")));
		cmnLib.waitForPageLoaded();
		System.out.println("cmnLib.result: "+cmnLib.result);
		TimeUnit.SECONDS.sleep(5);
		if(result) {
			log.info("Clicked on Tab "+strTabName+" in Collections Page");
		}else {
			log.info("Could not click on Tab "+strTabName+" in Collections Page");
		}
			
		return result;
	}
}
