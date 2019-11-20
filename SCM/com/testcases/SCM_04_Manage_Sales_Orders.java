package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.commons.TestBase;

import report.oracle.ofs.ReportGeneration;
import scm.pagefactory.HomePage_SCM;
import scm.pagefactory.LoginPage_SCM;
import scm.pagefactory.OrderManagement;
import scm.pagefactory.SetupAndMaintenancePage;
import xlsx.databank.ofs.ExcelOperations;

public class SCM_04_Manage_Sales_Orders extends TestBase{

	String strModule = "SCM_Prod";
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void SCM_04_Manage_Sales_Orders_TC() throws Throwable {
		rpt = new ReportGeneration("SCM_04_Manage_Sales_Orders", "Manage Sales Orders");

		boolean login = false;

		rpt.enterStepHeader("Login To Application");
		HomePage_SCM homePage_SCM = null;
		if(! (new HomePage_SCM().getUserNameFromHomePage() != null && new HomePage_SCM().getUserNameFromHomePage().equalsIgnoreCase(hashmap.get("UserName_"+strModule)))) {

			//Launch Browser
			launchBrowser(strModule);

			//Login To Application
			LoginPage_SCM loginPage_SCM = PageFactory.initElements(driver, LoginPage_SCM.class);

			homePage_SCM = loginPage_SCM.login(hashmap.get("UserName_"+strModule), hashmap.get("Password_"+strModule));
			rpt.enterStepHeader("Login to Application");
			if (homePage_SCM != null) {
				rpt.generateReport("", "Enter Username", "", hashmap.get("UserName_" + strModule),
						"Username must be entered", "Username entered", "Passed", "", false);
				rpt.generateReport("", "Enter Password", "", "", "Password must be entered", "Password entered",
						"Passed", "", false);
				rpt.generateReport("", "Click Sign In button", "", "", "Sign In button must be clicked",
						"Clicked Sign In button", "Passed", "", true);
			} else {
				rpt.generateReport("", "Login to application", "Enter Username, Password and Click Sign In button",
						"Username: " + hashmap.get("UserName_" + strModule), "Login must be Successful",
						"Login Un-Successful", "Failed", "", true);
				throw new SkipException("Login Un-Successful");
			}

			login = true;
		}

		//Initialize HomePage Web Elements

		//Validate HomePage Icon
		if(cmnLib.waitForElementToBeVisible(homePage_SCM.HomePage_HomeIcon) == true)
		{
			homePage_SCM = PageFactory.initElements(driver, HomePage_SCM.class);
			//PASS
			rpt.generateReport("SCM_CHILE_CST_001_ManageCostBooks", "Enter URL", "", "Password: "+hashmap.get("URL_"+strModule), "URL should be entered", "URL is entered", "Info", "", true );
			rpt.generateReport("", "Enter User Name", "", "UserName: "+hashmap.get("UserName_"+strModule), "UserName should be entered", "UserName is entered", "Info", "", true );
			rpt.generateReport("", "Enter Password", "", "Password: "+hashmap.get("Password_"+strModule), "Password should be entered", "Password is entered", "Info", "", true );
			rpt.generateReport("", "Validate Login to Appication", "", "", "Login Should be successful", "Login Is Successful", "Passed", "", true );
		}else
		{
			//FAIL
			rpt.generateReport("SCM_CHILE_CST_001_ManageCostBooks", "Login to Appication", "", "UserName: "+exl.read("LoginDetails", 1, "UserName"), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
			throw new RuntimeException("Login Un-Successful");
		}
		
		
			rpt.enterStepHeader("Order Management page");
			//Navigation
			if(homePage_SCM.clickOnWelcomePage_HomeIcon() == true)
			{
				homePage_SCM = PageFactory.initElements(driver, HomePage_SCM.class);
			}else
			{
				rpt.generateReport("", "Click On HomePage Icon", "", "", "HomePage Icon should be clicked", "HomePage Icon is not clicked", "Failed", "", true);
			}

		//Verify Presence of Navigator Icon
			if(homePage_SCM.NavigatorIcon.isDisplayed() == false)
			{
				//FAIL
				rpt.generateReport("", "Validate HomePage", "", "", "Validation Should be successful", "Validation Is Not Successful", "Failed", "", true );
				Assert.fail("Login Un-Successful");
			}
			TimeUnit.SECONDS.sleep(5);
		//Click on Navigator Icon
			homePage_SCM.clickOnNavigationIcon();

		//Click On Setup and Maintenance from Navigator Links
			OrderManagement orderManagement = homePage_SCM.clickOnOrderManagementLink();
			TimeUnit.SECONDS.sleep(5);
			
		//Verify Order Management is displayed
			if(cmnLib.waitForElementToBeVisible(orderManagement.CreateOrderButton))
			{
				rpt.generateReport("", "Navigation to Order Management Page", "", "", "Navigation to Order Management Page should be displayed", "Navigation to Order Management Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to Order Management Page", "", "", "Navigation to Order Management Page should be displayed", "Navigation to Order Management Page Is NOT displayed", "Failed", "", true );
				Assert.fail("Navigation to Order Management Page Is NOT displayed");
			}
			
			
			
			rpt.enterStepHeader("Searching Order");
			//Searching orders
			String OrderNum="925053";
			cmnLib.enterDataInTextBox(orderManagement.SearchInput, OrderNum, true);
			cmnLib.clickOnWebElement(orderManagement.SearchButton);
			TimeUnit.SECONDS.sleep(5);
			/*if(orderManagement.verifySearchedRecordExists(OrderNum))
			{
				rpt.generateReport("", "Verifying Order Management", "", "", "Order number must be avialable", "Order number is avialable", "Passed", "", true );
				TimeUnit.SECONDS.sleep(8);
			}else {
				
				rpt.generateReport("", "Verifying Order Management", "", "", "Order number must be avialable", "Order number is NOT avialable", "Passed", "", true );
				Assert.fail("Order number is NOT avialable");
				
			}*/
			
			//Order Management page verification
			if(cmnLib.waitForElementToBeVisible(orderManagement.ActionsButton))
			{
				rpt.generateReport("", "Navigation to Order Management Page", "", "", "Navigation to Order Management Page should be displayed", "Order Management Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to Order Management Page", "", "", "Navigation to Order Management Page should be displayed", " Order Management Page Is NOT displayed", "Failed", "", true );
				Assert.fail("Navigation to Order Management Page Is NOT displayed");
			}
			
			cmnLib.clickOnWebElement(orderManagement.ActionsButton);
			TimeUnit.SECONDS.sleep(2);
			rpt.generateReport("", "Actions Button", "", "", "Option under Actions", "Option under Actions", "Passed", "", true );
			cmnLib.clickOnWebElement(orderManagement.ViewPricingStrategySegment);
			
			cmnLib.clickOnWebElement(orderManagement.ViewPricingStrategySegmentHeader);
			rpt.generateReport("", "View Pricing Strategy and Segment", "", "", "View Pricing Strategy and Segment page should be available", "View Pricing Strategy and Segment page is available", "Passed", "", true );
			TimeUnit.SECONDS.sleep(2);
			cmnLib.clickOnWebElement(orderManagement.DoneButton);
			
		//Create Order Navigation	
			cmnLib.clickOnWebElement(homePage_SCM.NavigatorIcon);
			homePage_SCM.clickOnOrderManagementLink();
			
			cmnLib.waitForElementToBeVisible(orderManagement.CreateOrderButton);
			
			
			cmnLib.clickOnWebElement(orderManagement.TasksButton);
			TimeUnit.SECONDS.sleep(2);
			rpt.generateReport("", "Tasks Button", "", "", "Option under Tasks", "Option under Tasks", "Passed", "", true );
			cmnLib.clickOnWebElement(orderManagement.CreateOrder_Tasks);
			
			
			if(cmnLib.waitForElementToBeVisible(orderManagement.CreateOrder_Header))
			{
				rpt.generateReport("", "Navigation to Create Order Page", "", "", "Navigation to Create Order Page should be displayed", "Create Order Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to Create Order Page", "", "", "Navigation to Create Order Page should be displayed", "Create Order Page Is NOT displayed", "Failed", "", true );
				Assert.fail("Navigation to Create Order Page Is NOT displayed");
			}
			
			cmnLib.clickOnWebElement(orderManagement.CancelButton);
			TimeUnit.SECONDS.sleep(3);
			cmnLib.clickOnWebElement(orderManagement.YesButton);
			
		//Pricing Administration	
			
			cmnLib.clickOnWebElement(homePage_SCM.NavigatorIcon);
			homePage_SCM.clickOnPricingAdministrationLink();
			
			if(cmnLib.waitForElementToBeVisible(orderManagement.Tasks))
			{
				rpt.generateReport("", "Navigation to Pricing Administration Page", "", "", "Navigation to Pricing Administration Page should be displayed", "Pricing Administration Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to Pricing Administration Page", "", "", "Navigation to Pricing Administration Page should be displayed", "Pricing Administration Page Is NOT displayed", "Failed", "", true );
				Assert.fail("Navigation to Pricing Administration Page Is NOT displayed");
			}
			
			cmnLib.clickOnWebElement(orderManagement.Tasks);
			TimeUnit.SECONDS.sleep(2);
			rpt.generateReport("", "Tasks Button", "", "", "Option under Tasks", "Option under Tasks", "Passed", "", true );
			cmnLib.clickOnWebElement(orderManagement.ManagePricingStrategies);
			
			if(cmnLib.waitForElementToBeVisible(orderManagement.ManagePricingStrategies_Header))
			{
				rpt.generateReport("", "Navigation to Manage Pricing Strategies Page", "", "", "Navigation to Manage Pricing Strategies Page should be displayed", "Manage Pricing Strategies Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to Manage Pricing Strategies Page", "", "", "Navigation to Manage Pricing Strategies Page should be displayed", "Manage Pricing Strategies Page Is NOT displayed", "Failed", "", true );
				Assert.fail("Navigation to Manage Pricing Strategies Page Is NOT displayed");
			}
			
			//Global Order Promising
			
			cmnLib.clickOnWebElement(orderManagement.GlobalOrderPromising);
			if(cmnLib.waitForElementToBeVisible(orderManagement.GlobalOrderPromising_Header))
			{
				TimeUnit.SECONDS.sleep(10);
				rpt.generateReport("", "Navigation to Global Order Promising Page", "", "", "Navigation to Global Order Promising Page should be displayed", "Global Order Promising Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to Global Order Promising Page", "", "", "Navigation to Global Order Promising Page should be displayed", "Global Order Promising Page Is NOT displayed", "Failed", "", true );
				Assert.fail("Navigation to Global Order Promising Page Is NOT displayed");
			}
		}
}
	


