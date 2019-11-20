package otm.pagefactory;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.Common_Library.DropDownSelectBy;
import com.commons.TestBase;

public class DispatchBoard extends TestBase {
	
	@FindBy(id="dcc:j_id7:actions::icon")
	//*[@id="dcc:j_id7:actions::icon"]   - Action
	public WebElement Actions_Icon;
	
	@FindBy(xpath="//span[@id='dcc:j_id7:tbl:0:2']")
	public WebElement firstShipmentID;
	
	@FindBy(xpath="//select[@name='c_5PopulateDL']")
	public WebElement queryDropdown;
	
	@FindBy(xpath="//option[text()='SHIPMENT_START_TO_DAY']")
	public WebElement Select_ShipmentStartToDay;
	
	@FindBy(xpath="//div[@class='tm_panelStretchLayout']//div[@class='tm_panelCollection']//tr[1]//td[3]//div[1]//table[1]//tbody[1]//tr[1]//td[1]")
	public WebElement Select_FirstShipment;
	
	@FindBy(id="dcc:j_id7:populate::icon")
	public WebElement ExecuteButton;
	
	@FindBy(xpath="//img[@id='dcc:j_id7:selAdd::icon']")
	public WebElement AddButton;
	
	@FindBy(xpath="//input[@aria-label='Shipment ID']")
	public WebElement ShipmentID_Add;
	
	/*@FindBy(xpath="//a[@id='search_button']")
	public WebElement SearchButton_Add;*/
	
	//Dev4- 19C Reg
	@FindBy(xpath="//button[@id='search_button']")
	public WebElement SearchButton_Add;
	
	/*@FindBy(xpath="/a[text()='Replace Rows']")
	public WebElement ReplaceButton;*/
	
	//Dev4- 19C Reg
	@FindBy(xpath="//button[text()='Replace Rows']")
	public WebElement ReplaceButton;
	
	@FindBy(xpath="//button[text()='OK']")
	public WebElement OKButton_ServiceProvider;
	
	@FindBy(xpath="//h1[text()='Error']")
	public WebElement ErrorWindow;
	
	@FindBy(xpath="//span[text()='Affected Shipments']")
	public WebElement AffectedWindow;
	
	@FindBy(xpath="//input[@aria-label='Service Provider ID']")
	public WebElement ServiceProviderID_Input;
	
	@FindBy(xpath="//a[@title='Search']")
	public WebElement ServiceProviderID_Search;
	
	@FindBy(xpath="//input[@aria-label='Equipment Group ID']")
	public WebElement EquipmentGroupID_Input;
	
	/*@FindBy(xpath="//a[text()='OK']")
	public WebElement OKButton;*/
	
	//Dev4-19C Reg
	@FindBy(xpath="//button[text()='OK']")
	public WebElement OKButton;
	
	@FindBy(xpath="//input[@aria-label='Start Date/Time']")
	public WebElement StartTime;
	
	@FindBy(xpath="//input[@aria-label='Reset Order Time Windows']")
	public WebElement ResetOrderTimeWindows;
	
	@FindBy(xpath="//div[text()='Confirmation']")
	public WebElement ConfirmationWindow;
	
	@FindBy(xpath="//select[@name='adjustment_type1']")
	public WebElement AdjustmentType_Select;
	
	@FindBy(xpath="//a[text()='Adjust']")
	public WebElement Adjust_Button;
	
	@FindBy(xpath="//input[@aria-label='Shipment Cost']")
	public WebElement Shipment_Cost;
	
	@FindBy(xpath="//input[@aria-label='Adjustment Reason']")
	public WebElement Adjustment_Reason;
	
	@FindBy(xpath="//h1[text()='Adjust Shipment Costs']")
	public WebElement Confirmation_AdjustShipmentCosts;
	
	@FindBy(xpath="//h1[text()='Adjust Shipment Costs - Results']")
	public WebElement Success_AdjustShipmentCosts;
	
	@FindBy(xpath="//input[@aria-label='NFR Location ID']")
	public WebElement NFRLocationID;
	
	
	
	
	//Actions Dropdown
	
	@FindBy(xpath="//a[text()='Change Service Provider']")
	public WebElement ChangeServiceProvider;
	
	@FindBy(xpath="//a[text()='Select and Change Service Provider']")
	public WebElement SelectAndChangeServiceProvider;
	
	@FindBy(xpath="//a[text()='Change Equipment Group']")
	public WebElement ChangeEquipmentGroup;
	
	@FindBy(xpath="//a[text()='Change Start Time']")
	public WebElement ChangeStartTime;
	
	@FindBy(xpath="//a[text()='Adjust Shipment Costs']")
	public WebElement AdjustShipmentCosts;
	
	@FindBy(xpath="//a[text()='Recalculate Shipment Cost']")
	public WebElement RecalculateShipmentCost;
	
	@FindBy(xpath="//a[text()='Insert Non Freight Related Stop']")
	public WebElement InsertNonFreightRelatedStop;
	
	
	public DispatchBoard() {
		PageFactory.initElements(driver, this);
		log.info("Dispatch board page intialised");
	}
	
	public void clickOnActionsIcon()
	{
		cmnLib.clickOnWebElement(Actions_Icon);
		log.info("Clicked on Actions icon from Dispatch board page");
	}
	
	public boolean clickOnShipment() throws IOException, AWTException, ParseException, InterruptedException
	{
		String ShipmentID= firstShipmentID.getText();
		System.out.println("Shipment ID : "+ShipmentID);
		firstShipmentID.click();
		System.out.println("Clicked on 1st line");
		if(cmnLib.waitForElementToBeVisible(firstShipmentID))
		{
			rpt.generateReport("", "Checking if any Shipments are available", "", "",
					"Shipments must be available ", "Shipments are available ", "Pass", "", true);
			log.info("Shipments are avialable");
			return true;
		}else {
			rpt.generateReport("", "Checking if any Shipments are available", "", "",
					"Shipments must not be available ", "Shipments are not available ", "Fail", "", true);
			log.info("Shipments are not avialable");
			 return false;
		}
		
	}
	
	public boolean selectDropdownOptions(String value)
	{
		boolean flag=false;
		//queryDropdown.click();
		if(cmnLib.selectDropdownBy(queryDropdown, "SHIPMENT_START_TO_DAY", DropDownSelectBy.VisibleText))
		{
				flag=true;
				log.info("Query got selected");
		} else {
				flag=false;
				log.info("Query not selected");
		}
		return flag;

	}
	public void clickExecuteButton()
	{
		cmnLib.clickOnWebElement(ExecuteButton);
		log.info("Clicked on Execute button");
	}
	
	public boolean ClickOnSearchedResults() {
		boolean exists = false;
		try {
			List<WebElement> TableRows = driver.findElements(By.xpath("//div[@id='dcc:j_id7:tbl::db']/table/tbody/tr"));
			System.out.println("No Of Rows in Search Results Table: "+TableRows.size());
			if(TableRows.size() > 0) {
				for (int i = 1; i <= TableRows.size(); i++) {
					if(driver.findElement(By.xpath("//div[@id='dcc:j_id7:tbl::db']/table/tbody/tr["+i+"]/td[1]")).isDisplayed() && i==1) {
						driver.findElement(By.xpath("//div[@id='dcc:j_id7:tbl::db']/table/tbody/tr["+i+"]/td[1]")).click();
						exists = true;
						log.info("Searched Person Number record exists");
						break;
						}
					}
				}else {
					log.info("TableRows row count is less than zero !!");
				}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Searched Person Number record does not exist");
			e.printStackTrace();
		}
		return exists;
	}
	
	public boolean verifySearchedRecordExists(String Shipment_ID) {
		boolean exists = false;
		try {
			List<WebElement> TableRows = driver.findElements(By.xpath("//div[@id='dcc:j_id7:tbl::db']/table/tbody/tr"));
			System.out.println("No Of Rows in Search Results Table: "+TableRows.size());
			if(TableRows.size() > 0) {
				for (int i = 1; i <= TableRows.size(); i++) {
					
					/*WebElement element = driver.findElement(By.xpath("//table[@summary='Contacts']/tbody/tr["+i+"]//td[2]/div/table/tbody/tr/td[1]"));
					System.out.println(element.getText());
					if(element.getText().equalsIgnoreCase(Shipment_ID)) {
						exists = true;
						log.info("Searched Person Number record exists");
					}*/
					if(driver.findElement(By.xpath("//div[@id='dcc:j_id7:tbl::db']/table/tbody/tr["+i+"]//*[contains(text(),'"+Shipment_ID+"')]")).isDisplayed()) {
						exists = true;
						log.info("Searched Person Number record exists");
						}
					}
				}else {
					log.info("TableRows row count is less than zero !!");
				}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Searched Person Number record does not exist");
			e.printStackTrace();
		}
		return exists;
	}
	
	
	public boolean verifyServiceProviderListExsits() {
		boolean exists = false;
		try {
			List<WebElement> TableRows = driver.findElements(By.xpath("//table[@id='table_serv_prov_grid']/tbody/tr"));
			System.out.println("No Of Rows in Search Results Table: "+TableRows.size());
			if(TableRows.size() > 0) 
			{
				log.info("TableRows row count is NOT less than zero");
				exists=true;
			}else{
				log.info("TableRows row count is less than zero !!");
				exists=false;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Searched Person Number record does not exist");
			e.printStackTrace();
		}
		return exists;
	}


}
