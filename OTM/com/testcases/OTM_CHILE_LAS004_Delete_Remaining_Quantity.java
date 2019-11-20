package com.testcases;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.commons.Common_Library.FrameSelectBy;
import com.commons.TestBase;

import otm.pagefactory.HomePage_OTM;
import otm.pagefactory.LoginPage_OTM;
import otm.pagefactory.OrderReleaseFinder;
import otm.pagefactory.OrderReleaseResult;
import otm.pagefactory.DeleteRemOrderQuantity;
import org.openqa.selenium.support.PageFactory;
import report.oracle.ofs.ReportGeneration;
import xlsx.databank.ofs.ExcelOperations;

/**
Script Name			: OTM_CHILE_LAS004_Delete_Remaining_Quantity
Script Description	: Delete Remaining Quantity
Track/Module		: OTM
Sub Track			: 
Created By			: Chitralekha
Creation Date		: 
Modified By 		: Pradhanvi T R
Modification Date	: 25-Mar-19
Instance Name & URL : https://otmgtm-edyg-dev7.otm.us2.oraclecloud.com/GC3/glog.webserver.servlet.umt.Logi
User ID/ Password	: TESTING_CHILE@beehiveonline.oracle.com/Bimbo321
Responsibility		: Domain(edyg-dev7)
Pre-Requisites		: 
Comments (if any)	:
 **/


public class OTM_CHILE_LAS004_Delete_Remaining_Quantity extends TestBase
{
	String strModule = "OTM_CHILE";

	@SuppressWarnings("null")
	@Test
	public void f() throws Throwable 
	{
		rpt = new ReportGeneration("OTM_CHILE_LAS004_Delete_Remaining_Quantity","Delete Remaining Quantity");

		// Login to Application
		HomePage_OTM homepage = null;
		if (!(new HomePage_OTM().getUserNameFromHomePage() != null && new HomePage_OTM().getUserNameFromHomePage()
				.equalsIgnoreCase(hashmap.get("UserName_" + strModule)))) 
		{

			launchBrowser(strModule);
			// Launch & Login

			LoginPage_OTM loginPage = new LoginPage_OTM();
			loginPage.setDomain(hashmap.get("Domain_" + strModule));
			homepage = loginPage.login(hashmap.get("UserName_" + strModule), hashmap.get("Password_" + strModule));
		}

		rpt.enterStepHeader("Login to Application");
		
		if (homepage != null) 
		{
			rpt.generateReport("OTM_LAS004_To_Del_Remng_Qty", "Enter Username", "",
					hashmap.get("UserName_" + strModule), "Username must be entered", "Username entered", "Passed", "",
					false);
			rpt.generateReport("OTM_LAS004", "Enter Password", "", "", "Password must be entered", "Password entered", "Passed",
					"", false);
			rpt.generateReport("OTM_LAS004", "Click Sign In button", "", "", "Sign In button must be clicked",
					"Clicked Sign In button", "Passed", "", true);
		} 
		else 
		{
			rpt.generateReport("OTM_LAS004_To_Chng_Pkp_Dlvry_Dats", "Login to application",
					"Enter Username, Password and Click Sign In button",
					"Username: " + hashmap.get("UserName_" + strModule), "Login must be Successful",
					"Login Un-Successful", "Failed", "", true);
			Assert.fail("Login Un-Successful");
		}

		exl = new ExcelOperations("OTM\\com\\databanks\\OTM_TestData.xlsx");
		String sheetName = "LAS004";
		
		System.out.println("No Of DataRows: " + exl.getRowCount(sheetName));
		for (int dataRow = 1; dataRow < exl.getRowCount(sheetName); dataRow++) 
		{
			
			//Navigation
			if(homepage.clickOnWelcomePage_HomeIcon() == true)
			{
				homepage = PageFactory.initElements(driver, HomePage_OTM.class);
			}else
			{
				rpt.generateReport("", "Click On HomePage Icon", "", "", "HomePage Icon should be clicked", "HomePage Icon is not clicked", "Failed", "", true);
			}

		//Verify Presence of Navigator Icon
			if(homepage.NavigatorIcon.isDisplayed() == false)
			{
				//FAIL
				rpt.generateReport("", "Validate HomePage", "", "", "Validation Should be successful", "Validation Is Not Successful", "Failed", "", true );
				Assert.fail("Login Un-Successful");
			}
			TimeUnit.SECONDS.sleep(5);
		/*//Click on Navigator Icon
			homepage.clickOnNavigationIcon();
			TimeUnit.SECONDS.sleep(5);*/

			// Click Rapid Order Icon
			rpt.enterStepHeader("Go to Rapid Order");
			OrderReleaseFinder orderReleaseFinder = homepage.clickOnRapidOrder();
			cmnLib.waitForPageLoaded();
			
			cmnLib.switchToFrame(orderReleaseFinder.actionFrame, FrameSelectBy.FrameWebElement);
			if (cmnLib.clickOnWebElement(homepage.OrderRelaeseFinderPage)) 
			{
				orderReleaseFinder = new OrderReleaseFinder();
				rpt.generateReport("OTM_LAS004", "Click on Rapid Order icon", "", "", "Rapid Order icon must be clicked",
						"Clicked on Rapid Order icon", "Passed", "", true);
			} 
			else 
			{
				rpt.generateReport("OTM_LAS004", "Navigate to Order Release Finder page", "Click on Rapid Order icon", "",
						"Rapid Order icon must be clicked and application must navigate to Order Release Finder page",
						"Failed to click Rapid Order icon and navigate to Order Release Finder page", "Failed", "", true);
				Assert.fail("Failed to click Rapid Order icon and navigate to Order Release Finder page");
			}
	
			// Perform search with Order Release ID
			
			rpt.enterStepHeader("Perform Search with Order Release ID");
			OrderReleaseResult orderReleaseResult = null;
			/*List<WebElement> findElements = driver.findElements(By.tagName("iframe"));
			System.out.println(findElements);
			for(int i=0;i<findElements.size();i++) {
				System.out.println("Id :"+findElements.get(i).getAttribute("id"));
				System.out.println("Name :"+findElements.get(i).getAttribute("title"));
			}*/
			cmnLib.enterDataInTextBox(orderReleaseFinder.order_Relase_ID, exl.read(sheetName, dataRow, "OrderReleaseID"),
					false);
			if (cmnLib.clickByJSE(orderReleaseFinder.search_button)) 
			{
				orderReleaseResult = new OrderReleaseResult();
				rpt.generateReport("OTM_LAS004", "Enter Order Release ID", "Enter Order Release ID",
						exl.read(sheetName, dataRow, "OrderReleaseID"), "Order Release ID must be entered",
						"Order Release ID entered", "Passed", "", false);
				rpt.generateReport("OTM_LAS004", "Click on Search button", "Click on Search button", "",
						"Search button must be clicked", "Clicked on Search button", "Passed", "", true);
			} else 
			{
				rpt.generateReport("OTM_LAS004", "Perform search with Order Release ID",
						"Enter Order Release ID and Click Search button", exl.read(sheetName, dataRow, "OrderReleaseID"),
						"Search must be Successful", "Search Un-Successful", "Passed", "", true);
				Assert.fail("Search Un-Successful");
			}
	
			// Select Order from the results
			rpt.enterStepHeader("Select an Order and Delete Remaining Quantity");
			if (orderReleaseResult.selectOrderFromResuls(exl.read(sheetName, dataRow, "OrderReleaseID")))
			{
				rpt.generateReport("OTM_LAS004", "Select Order from results", "", exl.read(sheetName, dataRow, "OrderReleaseID"),
						"Order must be selected from results", "Selected Order from results", "Passed", "", true);
			} else 
			{
				rpt.generateReport("OTM_LAS004", "Select Order from results", "", exl.read(sheetName, dataRow, "OrderReleaseID"),
						"Order must be selected from results", "Failed to select Order from results", "Failed", "", true);
				Assert.fail("Failed to select Order from results");
			}
	
			// Select Delete Remaining Quantity under Actions dropdown
			if (cmnLib.clickByJSE(orderReleaseResult.actionsDropdown) == true) {
				rpt.generateReport("OTM_LAS004", "Click Actions dropdown", "", "", "Actions dropdown must be clicked",
						"Clicked on Actions dropdown", "Passed", "", true);
			} else {
				rpt.generateReport("OTM_LAS004", "Click Actions dropdown", "", "", "Actions dropdown must be clicked",
						"Actions dropdown not clicked", "Failed", "", true);
				Assert.fail("Actions dropdown not clicked");
			}
	
			cmnLib.switchToFrame("actionFrame", FrameSelectBy.StringFrameName);
	
			String parentNode = exl.read(sheetName, dataRow, "Actions_Parent");
			String childNode = exl.read(sheetName, dataRow, "Actions_Child");
			String link = exl.read(sheetName, dataRow, "Actions_Link");
	
			// Select Parent Node under Actions dropdown
			WebElement parentElement = orderReleaseResult.clickNodeUnderActionsDropdown(orderReleaseResult.actionTree,parentNode);
	
			if (parentElement != null) {
				rpt.generateReport("OTM_LAS004", "Click " + parentNode + " under Actions dropdown", "", parentNode,
						parentNode + " must be clicked", "Clicked " + parentNode, "Passed", "", true);
			} else {
				rpt.generateReport("OTM_LAS004", "Click " + parentNode + " under Actions dropdown", "", parentNode,
						parentNode + " must be clicked", parentNode + "not clicked", "Failed", "", true);
				Assert.fail(parentNode + "not clicked");
			}

		// Select Child Node
		WebElement childElement = orderReleaseResult.clickNodeUnderActionsDropdown(parentElement,
				exl.read(sheetName, dataRow, "Actions_Child"));

		if (childElement != null)
		{
			rpt.generateReport("OTM_LAS004", "Click " + childNode, "", childNode, childNode + " must be clicked",
					"Clicked " + childNode, "Passed", "", true);
		} 
		else 
		{
			rpt.generateReport("OTM_LAS004", "Click " + childNode, "", childNode, childNode + " must be clicked",
					childNode + " not clicked", "Failed", "", true);
			Assert.fail(childNode + "not clicked");
		}

		// Click link
		boolean result = orderReleaseResult.selectLinkUnderNode(childElement, exl.read(sheetName, dataRow, "Actions_Link"));

		// Switch to new Window
		String pHandle = driver.getWindowHandle();

		Set<String> allHandles = null;
		boolean flag = false;
		while (!flag) 
		{
			allHandles = driver.getWindowHandles();
			if (allHandles.size() > 1)
			{
				flag = true;
			}
		}

		for (String handle : allHandles) 
		{
			if (!handle.equals(pHandle)) 
			{
				driver.switchTo().window(handle);
			}
		}

		if (result == true)
		{
			rpt.generateReport("OTM_LAS004", "Click " + link, "", link, "Delete Remaining Order Quantity window must be opened",
					"Delete Remaining Order Quantity window opened", "Passed", "", true);
		}
		else 
		{
			rpt.generateReport("OTM_LAS004", "Click " + link, "", link, "Delete Remaining Order Quantity window must be opened",
					"Delete Remaining Order Quantity window not opened", "Failed", "", true);
			Assert.fail("Delete Remaining Order Quantity window not opened");
		}
		Thread.sleep(2000);
		
		cmnLib.switchToFrame("mainBody", FrameSelectBy.StringFrameName);

		// Delete Remaining Order Quantity 
		DeleteRemOrderQuantity deleteRemOrderQuantity = PageFactory.initElements(driver,DeleteRemOrderQuantity.class);		
		
		
		//Check the checkbox against the order in the Delete Remaining Order Qty window
		if (deleteRemOrderQuantity.selectOrdertoDelQtyCB() == true) 
		{
			rpt.generateReport("OTM_LAS004", "Select the checkbox of order","","",
				"Checkbox against order must be checked","Selected the checkbox","Passed","", true);
		}
		else
		{
			rpt.generateReport("OTM_LAS004", "Select the checkbox of order","","",
					"Checkbox against order must be checked","Failed to select the checkbox","Failed","", true);
			Assert.fail("Failed to select CheckBox");
		}

		Thread.sleep(1000);


		//Click OK button
		
		if (cmnLib.clickOnWebElement(deleteRemOrderQuantity.ok_Btn_DelRemOrdQty)) 
		{

			rpt.generateReport("OTM_LAS004", "Click on OK button in Delete Remaining Order Quantity window", "", "",
					"OK button must be clicked", "Clicked on OK button", "Passed", "", true);
		} 
		else 
		{
			rpt.generateReport("OTM_LAS004", "Click on OK button in Delete Remaining Order Quantity window", "", "",
					"OK button must clicked", "Failed to click OK button", "Failed", "", true);
			Assert.fail("Failed to click OK button");
		}
		
			/*Thread.sleep(1000);
	
			cmnLib.switchToFrame("mainBody", FrameSelectBy.StringFrameName);
			
			// Close current window and switch to parent window
			driver.close();
			driver.switchTo().window(pHandle);*/
		}
	}

 
}
