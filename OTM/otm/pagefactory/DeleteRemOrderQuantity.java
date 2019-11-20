package otm.pagefactory;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.commons.TestBase;

public class DeleteRemOrderQuantity extends TestBase
{

	@FindBy(xpath = "//h1[contains(text(),'Delete Remaining Quantity')]")
	public WebElement delRemQtyHeader;
	
	@FindBy(id="order_movement_is_checked1")
	public WebElement orderToDelQtyCheckBox;
	
	/*@FindBy(xpath="//a[text()='OK']")
	public WebElement ok_Btn_DelRemOrdQty;*/
	
	
	//19C Reg
	@FindBy(xpath="//button[text()='OK']")
	public WebElement ok_Btn_DelRemOrdQty;
	
	@FindBy(xpath = "//iframe[@title='Delete\\x20Remaining\\x20Quantity']")
	public WebElement dROQFrame;
	
	public boolean selectOrdertoDelQtyCB() 
	{
		boolean flag;
		try
		{
			WebElement checkbox = orderToDelQtyCheckBox;
			checkbox.click();
			Thread.sleep(500);
			log.info("Selected Order from Delete Remaining Order Qty window");
			
			flag = true;
		} 
		catch (Exception e) 
		{
			flag = false;
			log.info("Failed to select Order from Delete Remaining Order Qty window");
		}
		return flag;
	}
	public boolean clickOKButton()
	{
		boolean flag;
		try
		{
			cmnLib.clickByJSE(ok_Btn_DelRemOrdQty);
			ok_Btn_DelRemOrdQty.isDisplayed();
			log.info("Selected OK Button");
			flag = true;
		}
		catch (Exception e)
		{
			flag = false;
			log.info("Failed to click OK Button");

		}
		return flag;
	}
}
