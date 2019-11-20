package otm.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class OrderReleaseResult extends TestBase {

	@FindBy(xpath = "//h1[contains(text(),'Order Release')]")
	public WebElement orderReleaseResultHeader;

	@FindBy(xpath = "//h1[contains(text(),'Shipment Planning')]")
	public WebElement shipmentPlanningHeader;

	@FindBy(xpath = "//h1[contains(text(),'Bulk Plan')]")
	public WebElement bulkPlanHeader;

	@FindBy(xpath = "//div[@id='rgSGSec.2.1:sc']")
	public WebElement results_Section1;

	/*@FindBy(xpath = "//a[@class='enButton' and text()='Actions']")
	public WebElement actionsDropdown;*/
	
	//19C Reg
	@FindBy(xpath = "//button[@class='enButton' and text()='Actions']")
	public WebElement actionsDropdown;

	@FindBy(id = "actionTree")
	public WebElement actionTree;

	@FindBy(id = "actionTree.1_4.o")
	public WebElement actionTree_Branch4;

	@FindBy(id = "ok")
	public WebElement shipPlanning_ConfirmOK;

	@FindBy(xpath = "//div[text()='Bulk Plan ID']//following-sibling::div")
	public WebElement bulk_Plan_ID;
	
	@FindBy(id ="actionTree.1_2.l")
	public WebElement BusinessProcessAutomation_Actions;
	
	@FindBy(id="actionTree.1_2_1.cc")
	public WebElement Reports_Actions;
	
	@FindBy(id="actionTree.1_2_1_2.k")
	public WebElement UserDefinedFunction_Actions;
	
	

	public OrderReleaseResult() {
		PageFactory.initElements(driver, this);
	}

	public boolean selectOrderFromResuls(String strOrderReleaseID) {
		boolean flag;
		try {
			WebElement checkbox = results_Section1
					.findElement(By.xpath("//div[@value='LAS." + strOrderReleaseID + "']//preceding-sibling::div"));
			checkbox.click();
			log.info("Selected Order from Results");
			flag = true;
		} catch (Exception e) {
			flag = false;
			log.info("Failed to select Order from results");
		}
		return flag;
	}

	public boolean verifyOrderReleaseIDInResults(String strValue) {
		boolean flag = false;
		String expected = strValue;
		try {
			List<WebElement> results = driver.findElements(By.xpath("//div[@aria-label='Order Release ID']"));
			if (results.size() > 0) {
				for (WebElement element : results) {
					String actual = element.getText();
					if (actual.equalsIgnoreCase(expected)) {
						flag = true;
						log.info("Match found in results");
						break;
					}
				}
			} else {
				System.out.println("No Results Found");
			}
		} catch (Exception e) {
			log.info("Unable to match results");
		}
		return flag;
	}
	
	public boolean verifySearchedRecordExists(String workCenterName) {
		boolean exists = false;
		try {
			
			List<WebElement> TableRows = driver.findElements(By.xpath("//div[@aria-label='Order Release ID']"));
			System.out.println("No Of Rows in Search Results Table: "+TableRows.size());
			if(TableRows.size() > 0) {
				for (int i = 1; i <= TableRows.size(); i++) {
					if(driver.findElement(By.xpath("//table[@summary='Search Results']/tbody/tr["+i+"]//*[contains(text(), '"+workCenterName+"')]")).isDisplayed()) {
						exists = true;
						log.info("Searched Scenario record exists");
						}
					}
				}else {
					log.info("TableRows row count is less than zero !!");
				}
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Searched Scenario record does not exist");
		}
		return exists;
	}

	/**
	 * @author mehmurug (Mehavarnan) This method will click and expand the node
	 *         under Actions Dropdown
	 * @param element
	 *            WebElement of parent
	 * @param strNode
	 *            Node to be clicked
	 * @return WebElement
	 */

	public WebElement clickNodeUnderActionsDropdown(WebElement element, String strNode) {
		WebElement ele = null;
		try {
			cmnLib.waitForElementToBeVisible(element);
			WebElement node = element.findElement(By.xpath("//span[text()='" + strNode + "']"));
			if (cmnLib.waitForElementToBeClickable(node)) {
				node.click();
				log.info("Clicked Node " + strNode);
				ele = node;
			}
		} catch (Exception e) {
			log.info("Node not clicked " + strNode);
		}
		return ele;
	}

	/**
	 * @author mehmurug (Mehavarnan) This method will click the link present under
	 *         the node
	 * @param element
	 *            WebElement of Node
	 * @param strLink
	 *            Link to be clicked
	 * @return boolean
	 */
	public boolean selectLinkUnderNode(WebElement element, String strLink) {
		boolean flag = false;
		try {
			cmnLib.waitForElementToBeVisible(element);
			WebElement link = element.findElement(By.xpath("//a[text()='" + strLink + "']"));
			if (cmnLib.waitForElementToBeClickable(link)) {
				link.click();
				log.info("Clicked Link under Node");
				flag = true;
			}
		} catch (Exception e) {
			log.info("Link not clicked");
		}
		return flag;

	}

	/**
	 * @author mehmurug (Mehavarnan) This method will click the link present
	 *         directly under Actions dropdown
	 * @param element
	 *            WebElement of Node
	 * @param strLink
	 *            Link to be clicked
	 * @return boolean
	 */
	public boolean selectLinkUnderActionsDropdown(String strLink) {
		boolean flag = false;
		try {
			cmnLib.waitForElementToBeVisible(actionTree_Branch4);
			WebElement link = actionTree_Branch4.findElement(By.xpath("//a[text()='" + strLink + "']"));
			if (cmnLib.waitForElementToBeClickable(link)) {
				link.click();
				log.info("Clicked Link under Actions dropdown");
				flag = true;
			}
		} catch (Exception e) {
			log.info("Link not clicked");
		}
		return flag;

	}

	/**************************************************************************************************************************
	 * Change Pickup and Delivery Dates
	 ***************************************************************************************************************************/
	@FindBy(id = "order_release/early_pickup_date::content")
	public WebElement earlyPickupDate;

	@FindBy(id = "order_release/late_pickup_date::content")
	public WebElement latePickupDate;

	@FindBy(id = "order_release/early_delivery_date::content")
	public WebElement earlyDeliveryDate;

	@FindBy(id = "order_release/late_delivery_date::content")
	public WebElement lateDeliveryDate;

	@FindBy(id = "ok")
	public WebElement ok_Btn_ChangePickUPDeliveryDates;

	/*******************************************************************************************************************************************************
	 * Change Order Release Times
	 ********************************************************************************************************************************************************/

	@FindBy(xpath = "//tbody//a")
	public WebElement IDChangeOrderReleaseTimes;
	
	

}
