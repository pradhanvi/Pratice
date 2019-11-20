package wms.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class Location extends TestBase {
	
	@FindBy(xpath="//span[contains(@name,'LocationViewFW.common_grid_search_action')]")
	public WebElement SearchIcon;
	
	@FindBy(xpath="//label[text()='Barcode']/parent::td/parent::tr//input")
	public WebElement Barcode_Search;
	
	@FindBy(xpath="//span[text()='Search' and @class='dijitReset dijitInline dijitButtonText']")
	public WebElement Search_Button;
	
	@FindBy(xpath="//div[text()='Lock Code']")
	public WebElement LockCode_Column;
	
	@FindBy(xpath="//table[@class='dgrid-row-table']//td[27]")
	public WebElement LockCode_Value;
	
	@FindBy(xpath="//span[@title='Edit']")
	public WebElement Edit_Icon;
	
	@FindBy(xpath="//label[text()='Lock Code']/parent::td/parent::tr//input[@class='dijitReset dijitInputInner']")
	public WebElement LockCode_Edit;
	
	@FindBy(xpath="//span[text()='Save']")
	public WebElement Save_Button;
	
	
	public Location()
	{
		PageFactory.initElements(driver, this);
		log.info("Location is intialised");
	}

}
