package wms.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class IBLPN extends TestBase{
	
	@FindBy(xpath="//span[text()='IB LPNs']")
	public WebElement IBLPNHeader;
	
	/*@FindBy(xpath="//span[contains(@id,'dijit_form_Button') and @title='Search']")
	public WebElement SearchIcon;*/
	
	@FindBy(name="IbContainerView.common_grid_search_action")
	public WebElement SearchIcon;
	
	@FindBy(xpath="//label[text()='LPN Nbr']/parent::td/parent::tr//input")
	public WebElement LPN_Nbr;
	
	@FindBy(xpath="//div[@class='dijitContentPane dijitBorderContainer-child dijitBorderContainer-dijitContentPane dijitBorderContainerPane lgfGridFormCtrlPane dijitAlignBottom']//span[text()='Search']")
	public WebElement SearchButton;
	
	@FindBy(xpath="//div[text()='Nbr Locks']")
	public WebElement NbrLocksColumn;
	
	@FindBy(xpath="//div[@name='IbContainerView.calc_nbr_locks']/span")
	public WebElement NbrLocksValue;
	
	@FindBy(xpath="//div[text()='Lock Code']")
	public WebElement LockCodeColumn;
	
	@FindBy(xpath="//span[contains(@name,'delete_action')]")
	public WebElement DeleteIcon;
	
	@FindBy(xpath="//span[contains(text(),'WARNING')]")
	public WebElement WarningDialogBox;
	
	@FindBy(xpath="//span[text()='OK']")
	public WebElement DialogBox_OKButton;
	
	@FindBy(xpath="")
	public WebElement abc3;
	
	@FindBy(xpath="")
	public WebElement abc4;
	
	@FindBy(xpath="")
	public WebElement abc5;
	
	@FindBy(xpath="")
	public WebElement abc6;
	
	
	
	public IBLPN()
	{
		PageFactory.initElements(driver, this);
		log.info("IB LPN is intialised");
	}
	
	public boolean SearchAndSelectLockCode(String lockCode) {
		boolean exists = false;
		try {
			
			List<WebElement> TableRows = driver.findElements(By.xpath("//table[@class='dgrid-row-table']/tr"));
			System.out.println("No Of Rows in Search Results Table: "+TableRows.size());
			if(TableRows.size() > 0) {
				for (int i = 1; i <= TableRows.size(); i++) {
					if(driver.findElement(By.xpath("//table[@class='dgrid-row-table']/tr["+i+"]/*[contains(text(), '"+lockCode+"')]")).isDisplayed()) {
						exists = true;
						log.info("Searched Scenario record exists");
						cmnLib.clickOnWebElement(driver.findElement(By.xpath("//table[@class='dgrid-row-table']/tr["+i+"]/*[contains(text(), '"+lockCode+"')]")));
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
}
