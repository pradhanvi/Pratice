package scm.pagefactory;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.*;

import hcm.pagefactory.SetupAndMaintenance;


public class HomePage_SCM extends TestBase{
								
	@FindBy  (xpath="//a[contains(@id,'_UIShome')]")
	public WebElement HomePage_HomeIcon;

	@FindBy (xpath = "//a[@title='Navigator']")
	public WebElement NavigatorIcon;

	@FindBy(id="pt1:nv_itemNode_tools_setup_and_maintenance")
	public WebElement SetupMaintenanceLink;
	
	@FindBy(xpath="//td/a[text()='Cost Accounting']")
	public WebElement CostAccountingLink;
						
	@FindBy(xpath="//td/a[text()='Scheduled Processes']")
	public WebElement ScheduledProcessesLink;
	
	@FindBy(xpath="//a[text()='Setup and Maintenance']")
	public WebElement SetupAndMaintenance_HomePage_Icon;
	
	@FindBy(xpath="//td/a[text()='Setup and Maintenance']")
	public WebElement SetupAndMaintenance;	
	
	@FindBy(xpath="//a[@id='_FOpt1:nv_itemNode_tools_scheduled_processes']")
	public WebElement ScheduledProcessesLink_From;
									
	@FindBy(xpath="//a[@id='pt1:nv_itemNode_manufacturing_work_definition']")
	public WebElement WorkDefinitionLink;
	
	@FindBy(xpath="//a[@id='pt1:nv_itemNode_manufacturing_work_execution']")
	public WebElement WorkExecutionLink;
	
	@FindBy(xpath="//a[text()='Order Management' and contains(@id,'nv_itemNode_order_management_order_management')]")
	public  WebElement OrderManagementLink; 
	
	@FindBy(xpath="//a[text()='Pricing Administration']")
	public  WebElement PricingAdministration; 
	
	@FindBy(xpath="//a[text()='Receipt Accounting']")
	public  WebElement ReceiptAccounting;
	
	@FindBy(xpath="//td/a[text()='Inventory Management']")
	public WebElement InventoryManagement;

	public boolean clickOnWelcomePage_HomeIcon()
	{
		try {
			driver.findElement(By.xpath("//*[@id='pt1:_UIShome::icon']")).isDisplayed();
			driver.findElement(By.xpath("//*[@id='pt1:_UIShome::icon']")).click();
			//			HomePage_HomeIcon.isDisplayed();
			//			HomePage_HomeIcon.click();
			log.info("Clicked on HomeIcon in HomePage");
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Home Icon in HomePage is not displayed...");
			return false;
		}
		return true;
	}

	public String getUserNameFromHomePage() {
		String strUserName = null;
		try {
			clickOnWelcomePage_HomeIcon();

			driver.findElement(By.xpath("//*[@id='pt1:_UIScmil2u::icon']")).isDisplayed();
			strUserName = driver.findElement(By.xpath("//*[@id='pt1:_UIScmil2u::icon']")).getAttribute("title");
			//			UserName_Icon.isDisplayed();
			//			strUserName = UserName_Icon.getAttribute("title");
			System.out.println("UserName captured from HomePage: "+strUserName);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("UserName could not be captured from HomePage");
		}
		return strUserName;
	}

	public void clickOnNavigationIcon() throws InterruptedException {
		NavigatorIcon.click();
		log.info("Navigation Icon is clicked");
		TimeUnit.SECONDS.sleep(5);
	}

	public SetupAndMaintenancePage clickOnSetupMaintenanceLink() {
		try {
			SetupMaintenanceLink.isDisplayed();
			SetupMaintenanceLink.click();
			log.info("Setup and Maintenance Link is Clicked");

		} catch (Exception e) {
			// TODO: handle exception
			log.info("Setup and Maintenance Link is Not Clicked");
			return null;
		}
		return PageFactory.initElements(driver, SetupAndMaintenancePage.class);
	}
	
	public OrderManagement clickOnOrderManagementLink() {
		try {
			OrderManagementLink.isDisplayed();
			OrderManagementLink.click();
			log.info("Order Management Link is Clicked");

		} catch (Exception e) {
			// TODO: handle exception
			log.info("Order Management Link is Clicked");
			return null;
		}
		return PageFactory.initElements(driver, OrderManagement.class);
	}
	
	public OrderManagement clickOnPricingAdministrationLink() {
		try {
			PricingAdministration.isDisplayed();
			PricingAdministration.click();
			log.info("Pricing Administration Link is Clicked");

		} catch (Exception e) {
			// TODO: handle exception
			log.info("Pricing Administration Link is Clicked");
			return null;
		}
		return PageFactory.initElements(driver, OrderManagement.class);
	}

	public CostAccountingPage clickOnCostAccountingLink() {
		try {
			CostAccountingLink.isDisplayed();
			//cmnLib.clickOnLinkText("Cost Accounting");
			cmnLib.clickOnWebElement(CostAccountingLink);
			log.info("Cost Accounting Link is Clicked");

		} catch (Exception e) {
			// TODO: handle exception
			log.info("Cost Accounting Link is Not Clicked");
			return null;
		}
		return PageFactory.initElements(driver, CostAccountingPage.class);
	}
	
	public InventoryManagementPage clickOnInventoryManagement() {
		try {
			InventoryManagement.isDisplayed();
			//cmnLib.clickOnLinkText("Cost Accounting");
			cmnLib.clickOnWebElement(InventoryManagement);
			log.info("Inventory Management Link is Clicked");

		} catch (Exception e) {
			// TODO: handle exception
			log.info("Inventory Management Link is Not Clicked");
			return null;
		}
		return PageFactory.initElements(driver, InventoryManagementPage.class);
	}
	
	public SetupAndMaintenance clickOnSetupAndMaintenance() {
		try {
			SetupAndMaintenance.isDisplayed();
			cmnLib.clickByJSE(SetupAndMaintenance);
			log.info("Setup And Maintenance Link is Clicked");
			
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Setup And Maintenance Link is NOT Clicked");
			return null;
		}
		return PageFactory.initElements(driver, SetupAndMaintenance.class);
	}
	
	
	public ScheduledProcesses clickOnScheduledProcesses() {
		try {
			ScheduledProcessesLink.isDisplayed();
			//cmnLib.clickOnLinkText("Cost Accounting");
			cmnLib.clickOnWebElement(ScheduledProcessesLink);
			log.info("Scheduled Processes Link is Clicked");

		} catch (Exception e) {
			// TODO: handle exception
			log.info("Scheduled Processes Link is Not Clicked");
			return null;
		}
		return PageFactory.initElements(driver, ScheduledProcesses.class);
	}
	
	public WorkDefinition clickOnWorkDefinition() {
		try {
			WorkDefinitionLink.isDisplayed();
			//cmnLib.clickOnLinkText("Cost Accounting");
			cmnLib.clickOnWebElement(WorkDefinitionLink);
			log.info("Work Definition Link is Clicked");

		} catch (Exception e) {
			// TODO: handle exception
			log.info("Work Definition Link is NOT Clicked");
			return null;
		}
		return PageFactory.initElements(driver, WorkDefinition.class);
	}
	
	public WorkExecution clickOnWorkExecution() {
		try {
			WorkExecutionLink.isDisplayed();
			//cmnLib.clickOnLinkText("Cost Accounting");
			cmnLib.clickOnWebElement(WorkExecutionLink);
			log.info("Work Execution Link is Clicked");

		} catch (Exception e) {
			// TODO: handle exception
			log.info("Work Execution Link is NOT Clicked");
			return null;
		}
		return PageFactory.initElements(driver, WorkExecution.class);
	}
	
	public CreateReceiptAccountingDistribution clickOnReceiptAccounting() {
		try {
			ReceiptAccounting.isDisplayed();
			//cmnLib.clickOnLinkText("Cost Accounting");
			cmnLib.clickOnWebElement(ReceiptAccounting);
			log.info("Receipt Accounting Link is Clicked");

		} catch (Exception e) {
			// TODO: handle exception
			log.info("Receipt Accounting Link is NOT Clicked");
			return null;
		}
		return PageFactory.initElements(driver, CreateReceiptAccountingDistribution.class);
	}
	
}
