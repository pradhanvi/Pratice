package otm.pagefactory;


//import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;


public class EditShipmentQuantity extends TestBase
{
	
	@FindBy(xpath="//h1[contains(text(),'Buy Shipment Quantities')]")
	public WebElement editShpmtQtyWindowHeader;
	
	@FindBy(xpath = "//*[@id=\'shipunit_radio\']/div/input")
	public WebElement shipUnitRB;
	
	@FindBy(xpath = "//*[@id=\'gross_radio\']/div/input")
	public WebElement weightVolumeTypeRB;
	
	/*@FindBy(xpath = "//a[@class='enButton' and text()='Submit']")
	public WebElement submitBuySQButton;*/
	
	//19C Reg
	@FindBy(xpath = "//button[@class='enButton' and text()='Submit']")
	public WebElement submitBuySQButton;
	
	/*@FindBy(xpath ="//*[@id=\'s_equipment_LAS.126257_ship_unit_LAS.551644/weight@PRF\']")
	public WebElement shipmentWeight;*/
	
	@FindBy(xpath="//table[@summary='Ship Units']/tbody/tr[2]//input[contains(@name, 'weight@PRF')]")
	public WebElement shipmentWeight;
	
	@FindBy(xpath = "//*[contains(@class,'enButton') and contains(text(),'Finished')]")
	public WebElement finishedButton;
	
	@FindBy(xpath = "//*[@id=\'successData\']/span")
	public WebElement successStmt;
	
	public boolean selectEditOptions()
	{
		boolean flag;
		try 
		{
			WebElement radioButton1 = shipUnitRB;
			radioButton1.click();
			log.info("Selected Ship Unit radio Button");
			flag = true;
			
			WebElement radioButton2 = weightVolumeTypeRB;
			radioButton2.click();
			
			log.info("Selected Weight/Volume Type Radio Button");
			flag = true;
		}        
		catch (Exception e) 
		{
			flag = false;
			log.info("Failed to select Radio Buttons");
		}
		return flag;
	}
	
	public boolean clickSubmitEdit()
	{
		boolean flag;
		try 
		{
			WebElement Button = submitBuySQButton;
			Button.click();
			log.info("Clicked on Submit Button in the Edit Shipment Qty window");
			flag = true;
		}
		catch (Exception e) 
		{
			flag = false;
			log.info("Failed to click Submit Button in the Edit Shipment Qty window");
		}
		return flag;
	}
	
	
}
