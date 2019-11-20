package scm.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class CostAccountingPage extends TestBase {
	
	@FindBy(xpath="//div[contains(@id,'MainAreaTab1::ti')]//a[contains(@id,':MainAreaTab1::disAcr') and text()='Cost Accounting']")
	public WebElement CostAccountingHeader;
	
	@FindBy(xpath="//img[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:_FOTsdiRegionalTaskList::icon'] ")
	public WebElement TasksIcon;
	
	/*@FindBy(xpath="//img[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:1:_FOTsdiRegionalTaskList::icon']")
	public WebElement TasksIcon;*/
	
	@FindBy(xpath="//a[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:_FOTRaT:0:RAtl1']")
	public WebElement ManageCostScenariousLink;
	
	@FindBy(xpath="//a[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:_FOTRaT:0:RAtl4']")
	public WebElement ManageResourceRatesLink;
	
	@FindBy(xpath="//a[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:_FOTRaT:0:RAtl2']")
	public WebElement ManageStandardCostsLink;
	
	@FindBy(xpath="//a[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:_FOTRaT:0:RAtl5']")
	public WebElement ManageOverheadRatesLink;
	
	@FindBy(xpath="//a[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:_FOTRaT:0:RAtl9']")
	public WebElement ReviewItemCostsLink;
	
	@FindBy(xpath="//a[contains(text(),'Create Cost Accounting Distributions')]")
	public WebElement CreateCostAccountingDistributionsLink;
	
	public CostAccountingPage()
	{
		PageFactory.initElements(driver, this);
		log.info("Cost Accounting page is initialised");
	}
	
	
	public void clickOnTaksIcon()
	{
		if(cmnLib.clickOnWebElement(TasksIcon))
		{
			log.info("Clicked on Tasks Icon");
		}else {
			log.info("Not Clicked on Tasks Icon");
		}
		
	}
	
	public ManageCostScenarious clickOnManageCostScenarious()
	{
		if(cmnLib.clickOnWebElement(ManageCostScenariousLink))
		{
			log.info("Clicked on Manage Cost Scenarious Link");
		}else{
			log.info("Not Clicked on Manage Cost Scenarious Link");
		}
		return PageFactory.initElements(driver, ManageCostScenarious.class);
	}
	
	public ManageResourceRates clickOnManageResourceRates()
	{
		if(cmnLib.clickOnWebElement(ManageResourceRatesLink))
		{
			log.info("Clicked on Manage Resource Rates Link");
		}else{
			log.info("Not Clicked on Manage Resource Rates Link");
		}
		return PageFactory.initElements(driver, ManageResourceRates.class);
	}
	
	public ManageStandardCosts clickOnManageStandardCosts()
	{
		if(cmnLib.clickOnWebElement(ManageStandardCostsLink))
		{
			log.info("Clicked on Manage Resource Rates Link");
		}else{
			log.info("Not Clicked on Manage Resource Rates Link");
		}
		return PageFactory.initElements(driver, ManageStandardCosts.class);
	}
	
	public ManageOverheadRates clickOnManageOverheadRates()
	{
		if(cmnLib.clickOnWebElement(ManageOverheadRatesLink))
		{
			log.info("Clicked on Manage Overhead Rates Link");
		}else{
			log.info("Not Clicked on Manage Overhead Rates Link");
		}
		return PageFactory.initElements(driver, ManageOverheadRates.class);
	}
	
	public ReviewItemCosts clickOnReviewItemCosts()
	{
		if(cmnLib.clickOnWebElement(ReviewItemCostsLink))
		{
			log.info("Clicked on Review Item Costs Link");
		}else{
			log.info("Failed to Click on Review Item Costs Link");
		}
		return PageFactory.initElements(driver, ReviewItemCosts.class);
	}
	
	public CreateCostAccountingDistributions clickOnCreateCostAccountingDistributions()
	{
		if(cmnLib.clickOnWebElement(CreateCostAccountingDistributionsLink))
		{
			log.info("Clicked on Create Cost Accounting Distributions Link");
		}else{
			log.info("Failed to Click on Create CostAccounting Distributions");
		}
		return PageFactory.initElements(driver, CreateCostAccountingDistributions.class);
	}

}
