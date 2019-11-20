package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class AddAsset extends TestBase {
	
	@FindBy(xpath = "//label[text()='Book']//parent::td//parent::tr//td[2]//select")
	public WebElement Book;
	
	@FindBy(xpath = "//button[contains(@id,'cb1')]")
	public WebElement Cancel;
	
	@FindBy(xpath = "//label[text()='Asset Type']//parent::td//parent::tr//td[2]//select")
	public WebElement AssetType;
	
	@FindBy(xpath = "//label[text()='Category']//parent::td//parent::tr//td[2]//input")
	public WebElement Category;
	
	@FindBy(xpath = "//label[text()='Description']//parent::td//parent::tr//td[2]//input")
	public WebElement Description;
	
	@FindBy(xpath = "//label[text()='Cost']//parent::td//parent::tr//td[2]//input")
	public WebElement Cost;
	
	@FindBy(xpath = "//label[text()='Units']//parent::td//parent::tr//td[2]//input")
	public WebElement Units;
	
	@FindBy(xpath = "//label[text()='Expense Account']//parent::td//parent::tr//td[2]//input")
	public WebElement ExpenseAccount;
	
	@FindBy(xpath = "//label[text()='Location']//parent::td//parent::tr//td[2]//input")
	public WebElement Location;
	
	@FindBy(xpath = "//button[contains(@id,'commandButton1')]")
	public WebElement NextButton;
	
	@FindBy(xpath = "//label[text()='Asset Number']//parent::td//parent::tr//td[2]//input")
	public WebElement AssetNumber;
	
	@FindBy(xpath = "//label[text()='In Service Date']//parent::td//parent::tr//td[2]//input")
	public WebElement InServiceDate;
	
	@FindBy(xpath = "//label[text()='Asset Key']//parent::td//parent::tr//td[2]//input")
	public WebElement Asset_Key;
	
	@FindBy(xpath = "//label[text()='Property Type']//parent::td//parent::tr//td[2]//select")
	public WebElement PropertyType;
	
	@FindBy(xpath = "//input[contains(@id,'employeeNumberId')]")
	public WebElement EmployeeNumber;
	
	@FindBy(xpath = "//div[contains(@id,'commandButton15')]")
	public WebElement Submit;
	
	@FindBy(xpath = "//a[contains(@id,'showDetailHeader3')]")
	public WebElement FinancialDetails_ExpandCollapse;
	
	@FindBy(xpath = "//label[contains(@for,'selectBooleanCheckbox4::content')]")
	public WebElement Depreciate_Checkbox;

	public AddAsset() {
		PageFactory.initElements(driver, this);
		log.info("Add Asset page is initialized...");
	}
	


}
