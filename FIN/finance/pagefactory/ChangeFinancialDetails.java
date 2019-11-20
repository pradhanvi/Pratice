package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ChangeFinancialDetails extends TestBase{
	
	@FindBy(xpath = "//label[text()='Amortize']")
	public WebElement Amortize_Checkbox;
		
	@FindBy(id ="_FOpt1:_FOr1:0:_FOSritemNode_fixed_assets_additions:0:MAnt2:1:SrchTF:1:AP2:inputDate2::content")
	public WebElement AmortizationStartDate;
	
	@FindBy(id ="_FOpt1:_FOr1:0:_FOSritemNode_fixed_assets_additions:0:MAnt2:1:SrchTF:1:AP2:commandButton1")
	public WebElement Submit;
	
	@FindBy(xpath = "//select[contains(@id,'LifeYearId::content')]")
	public WebElement LifeInYears;
	
	@FindBy(xpath = "//label[text()='In Service Date']//parent::td//parent::tr//td[2]//input")
	public WebElement InServiceDate;
	
	@FindBy(xpath = "//label[text()='Prorate Convention']//parent::td//parent::tr//td[2]//select")
	public WebElement ProrateConvention;
	
	@FindBy(xpath = "//label[text()='Salvage Value Type']//parent::td//parent::tr//td[2]//select")
	public WebElement SalvageValueType;
	
	@FindBy(xpath = "//td[contains(text(),'overwrite a previous')]")
	public WebElement Message_warning;
	
	@FindBy(xpath = "//button[contains(@id,'cb4')]")
	public WebElement OK_warning;
	
	
	public ChangeFinancialDetails() {
		PageFactory.initElements(driver, this);
		log.info("Change Financial Details page is initialized...");
	}

}
