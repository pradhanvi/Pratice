package otm.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;


public class Buy_Shipment extends TestBase{

	@FindBy(xpath = "//h1[contains(text(),'Buy Shipment')]")
	public WebElement BuyShipmentHeader;
	
	@FindBy(xpath ="//div[@id='rgSGSec.2.1:sc']")
	public WebElement SelectShipmentID;
	
	@FindBy(xpath = "//a[@class='enButton' and text()='Actions']")
	public WebElement ClickOnActionBtn;
	
	@FindBy(id = "actionTree")
	public WebElement actionTree;
	
	@FindBy(id="actionTree.1_3.l")
	public WebElement ClickOnFleetManagment;
	
	@FindBy(id="actionTree.1_3_1.l")
	public WebElement ClickOnAssign;
	
	@FindBy(id="actionTree.1_3_1_2.k")
	public WebElement ClickOnPowerUnit;
	
	
	
	
	
	public Buy_Shipment() {
		PageFactory.initElements(driver, this);
	}

	

	public boolean verifyShipmentIDInResults(String strValue) {
		boolean flag = false;
		int expected = Integer.parseInt(strValue);
		try {
			List<WebElement> results = driver.findElements(By.xpath("//div[@aria-label='Shipment ID']"));
			if (results.size() > 0) {
				for (WebElement element : results) {
					int actual = Integer.parseInt((element.getText()));
					if (actual == expected) {
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
	
	public boolean selectOrderFromResults(String strShipmentID) {
		boolean flag;
		try {
			WebElement checkbox = SelectShipmentID
					.findElement(By.xpath("//div[@value='LAS." + strShipmentID + "']//preceding-sibling::div"));
			checkbox.click();
			log.info("Selected Order from Results");
			flag = true;
		} catch (Exception e) {
			flag = false;
			log.info("Failed to select Order from results");
		}
		return flag;
		
		
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
				log.info("Clicked Node" + strNode);
				ele = node;
			}
		} catch (Exception e) {
			log.info("Node not clicked" + strNode);
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
			e.printStackTrace();
			log.info("Link not clicked");
		}
		return flag;

	}
	
	//Assign Power Unit to Shipment//
	
	
	
	@FindBy(xpath="//input[@id='powerunit_xid']")
	public WebElement PowerUnitID;
	
	@FindBy(id="ok_button")
	public WebElement OkBtn;
	
	//Validating the Assigned Power Unit
	
	
	@FindBy(xpath="//table[@id='table_to_s_grid']/tbody//tr//td[12]/a")
	public WebElement AssginedPowerUnitID;
	
	@FindBy(xpath="//table[@id='table_to_s_grid']/tbody//tr//td[1]/a")
	public WebElement ShipmentPowerUnitID;
	
	
	//Assign Driver to Shipment Force
	
	@FindBy(xpath="//input[@id='driver_xid']")
	public WebElement DriverID;
	
	@FindBy(id="ok_button")
	public WebElement DriverOkBtn;
	
	
	//Validating the Assigned Driver ID
	
	
		@FindBy(xpath="//table[@id='table_to_s_grid']/tbody//tr//td[11]/a")
		public WebElement AssginedDriverID;
		
	
	//Assign Driver to Shipment Force
		
		@FindBy(xpath="//input[@id='driver_xid']")
		public WebElement EquipmentID;
		
		@FindBy(id="ok_button")
		public WebElement EquipmentOkBtn;
		
		//Validating the Assigned Equipment ID
		
		
		@FindBy(xpath="//table[@id='table_to_s_grid']/tbody//tr//td[11]/a")
		public WebElement AssginedEquipmentID;
		
		// UnAssignment of Power Unit ID to the Shipment ID
		
	
		@FindBy(xpath="//h1[contains(text(),'Success')]")
		public WebElement UnAssginedPowerUnitID;
		
		// UnAssignment of Power Unit ID to the Shipment ID
		
		
			@FindBy(xpath="//h1[contains(text(),'Success')]")
			public WebElement UnAssginedAll;
			
		//Transportation Confirmation Plan
			
			@FindBy(xpath="//div[@id='bodyDataDiv']/div[1]/table/tbody/tr/td[8]")
			public WebElement TransportationConfirmation;
			
		//Assign Driver to Shipment ID - Fleet Assginment	
			
			@FindBy(xpath = "//input[@id ='driver_xid']")
			public WebElement DriverIDText;
			
			@FindBy(xpath = "//a[@id ='ok_button']")
			public WebElement DriverOkbtn;
			
			@FindBy(xpath="//table[@id='table_to_s_grid']/tbody//tr//td[11]/a")
			public WebElement AssginedDriverIDFleet;
			
			
		//Assign Equipment Type to shipment ID
			
			@FindBy(xpath = "//*[@id=\"table_detail_grid\"]/tbody/tr[1]/td[1]/input")
			public WebElement ProcessType_PEF;
			
			@FindBy(xpath = "//*[@id=\"table_detail_grid\"]/tbody/tr[2]/td[1]/input")
			public WebElement ProcessType_DEF;
			
			@FindBy(xpath = "//*[@id=\"location_xid_1\"]")
			public WebElement PEFLocationID;
			
			@FindBy(xpath = "//*[@id=\"equipment_type_xid_1\"]")
			public WebElement PEFEquipmentTypeID;
			
			@FindBy(xpath = "//*[@id=\"location_xid_2\"]")
			public WebElement DEFLocationID;
			
			@FindBy(xpath = "//*[@id=\"equipment_type_xid_2\"]")
			public WebElement DEFEquipmentTypeID;
			
			@FindBy(xpath = "//*[@id=\"ok_button\"]")
			public WebElement EquipOkbtn;
			
//Assign Equipment Type to shipment ID
			
			@FindBy(xpath = "//*[@id=\"table_detail_grid\"]/tbody/tr[1]/td[1]/inputt")
			public WebElement FProcessType_PEF;
			
			@FindBy(xpath = "//*[@id=\"table_detail_grid\"]/tbody/tr[2]/td[1]/input")
			public WebElement FProcessType_DEF;
			
			@FindBy(xpath = "//*[@id=\"location_xid_1\"]")
			public WebElement FPEFLocationID;
			
			@FindBy(xpath = "//*[@id=\"equipment_type_xid_1\"]")
			public WebElement FPEFEquipmentTypeID;
			
			@FindBy(xpath = "//*[@id=\"location_xid_2\"]")
			public WebElement FDEFLocationID;
			
			@FindBy(xpath = "//*[@id=\"equipment_type_xid_2\"]")
			public WebElement FDEFEquipmentTypeID;
			
			@FindBy(xpath = "//*[@id=\"ok_button\"]")
			public WebElement FEquipOkbtn;
			
			
			

			
			
}
