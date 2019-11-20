package com.testcases;

import java.util.Set;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.commons.Common_Library.FrameSelectBy;
import com.commons.TestBase;

import otm.pagefactory.HomePage_OTM;
import otm.pagefactory.LoginPage_OTM;
import otm.pagefactory.OrderReleaseFinder;
import otm.pagefactory.OrderReleaseResult;
import report.oracle.ofs.ReportGeneration;
import xlsx.databank.ofs.ExcelOperations;

public class OTM_LAS020 extends TestBase {

	String strModule = "OTM_CHILE/PERU";

	@Test
	public void f() throws Throwable {

		rpt = new ReportGeneration("OTM_LAS016_Crte_Blk_Pln_Dirctly","");

		// Login to Application
		HomePage_OTM homepage = null;
		if (!(new HomePage_OTM().getUserNameFromHomePage() != null && new HomePage_OTM().getUserNameFromHomePage()
				.equalsIgnoreCase(hashmap.get("UserName_" + strModule)))) {

			launchBrowser(strModule);
			// Launch & Login

			LoginPage_OTM loginPage = new LoginPage_OTM();
			loginPage.setDomain(hashmap.get("Domain_" + strModule));
			homepage = loginPage.login(hashmap.get("UserName_" + strModule), hashmap.get("Password_" + strModule));
		}

		rpt.enterStepHeader("Login to Application");
		if (homepage != null) {
			rpt.generateReport("OTM_LAS020_How to use Bulk Plan directly", "Enter Username", "",
					hashmap.get("UserName_" + strModule), "Username must be entered", "Username entered", "Passed", "",
					false);
			rpt.generateReport("", "Enter Password", "", "", "Password must be entered", "Password entered", "Passed",
					"", false);
			rpt.generateReport("", "Click Sign In button", "", "", "Sign In button must be clicked",
					"Clicked Sign In button", "Passed", "", true);
		} else {
			rpt.generateReport("LAS016_How_to_Create_Bulk_Plan", "Login to application",
					"Enter Username, Password and Click Sign In button",
					"Username: " + hashmap.get("UserName_" + strModule), "Login must be Successful",
					"Login Un-Successful", "Failed", "", true);
			throw new SkipException("Login Un-Successful");
		}

		exl = new ExcelOperations("OTM\\com\\databanks\\OTM_TestData.xlsx");
		String sheetName = "LAS016";

		System.out.println("No Of DataRows: " + exl.getRowCount(sheetName));
		for (int dataRow = 1; dataRow < exl.getRowCount(sheetName); dataRow++) {

			cmnLib.waitForPageLoaded();
			if (!(driver.getTitle().equals("Logistics Cloud - Home"))) {
				cmnLib.clickOnWebElement(homepage.HomePage_HomeIcon);
			}

			// Click Rapid Order Icon
			rpt.enterStepHeader("Go to Rapid Order");
			OrderReleaseFinder orderReleaseFinder = null;
			if (cmnLib.clickOnWebElement(homepage.Rapid_Order_Icon) == true) {
				orderReleaseFinder = new OrderReleaseFinder();
				rpt.generateReport("", "Click on Rapid Order icon", "", "", "Rapid Order icon must be clicked",
						"Clicked on Rapid Order icon", "Passed", "", true);
			} else {
				rpt.generateReport("", "Navigate to Order Release Finder page", "Click on Rapid Order icon", "",
						"Application must navigate to Order Release Finder page",
						"Failed to navigate to Order Release Finder page", "Failed", "", true);
				throw new SkipException("Failed to navigate to Order Release Finder page");
			}

			// Perform search with Order Release ID
			cmnLib.switchToFrame(orderReleaseFinder.actionFrame, FrameSelectBy.FrameWebElement);
			rpt.enterStepHeader("Perform Search with Order Release ID");
			OrderReleaseResult orderReleaseResult = null;
			cmnLib.enterDataInTextBox(orderReleaseFinder.order_Relase_ID,
					exl.read(sheetName, dataRow, "OrderReleaseID"), false);
			if (cmnLib.clickByJSE(orderReleaseFinder.search_button)) {
				orderReleaseResult = new OrderReleaseResult();
				rpt.generateReport("", "Enter Order Release ID", "Enter Order Release ID",
						exl.read(sheetName, dataRow, "OrderReleaseID"), "Order Release ID must be entered",
						"Order Release ID entered", "Passed", "", false);
				rpt.generateReport("", "Click on Search button", "Click on Search button", "",
						"Search button must be clicked", "Clicked on Search button", "Passed", "", true);
			} else {
				rpt.generateReport("", "Perform search with Order Release ID",
						"Enter Order Release ID and Click Search button",
						exl.read(sheetName, dataRow, "OrderReleaseID"), "Search must be Successful",
						"Search Un-Successful", "Passed", "", true);
				throw new SkipException("Search Un-Successful");
			}

			// Select Order from the results
			rpt.enterStepHeader("Select an Order and Create Bulk Plan");
			if (orderReleaseResult.selectOrderFromResuls(exl.read(sheetName, dataRow, "OrderReleaseID"))) {
				rpt.generateReport("", "Select Order from results", "", exl.read(sheetName, dataRow, "OrderReleaseID"),
						"Order must be selected from results", "Selected Order from results", "Passed", "", true);
			} else {
				rpt.generateReport("", "Select Order from results", "", exl.read(sheetName, dataRow, "OrderReleaseID"),
						"Order must be selected from results", "Failed to select Order from results", "Failed", "",
						true);
				throw new SkipException("Failed to select Order from results");
			}

			// Select Bulk Plan - Buy from Actions dropdown
			if (cmnLib.clickByJSE(orderReleaseResult.actionsDropdown) == true) {
				rpt.generateReport("", "Click Actions dropdown", "", "", "Actions dropdown must be clicked",
						"Clicked on Actions dropdown", "Passed", "", true);
			} else {
				rpt.generateReport("", "Click Actions dropdown", "", "", "Actions dropdown must be clicked",
						"Actions dropdown not clicked", "Failed", "", true);
				throw new SkipException("Actions dropdown not clicked");
			}

			String link = exl.read(sheetName, dataRow, "Actions_Link");

			cmnLib.switchToFrame("actionFrame", FrameSelectBy.StringFrameName);

			boolean result = orderReleaseResult.selectLinkUnderActionsDropdown(link);

			// Switch to new Window
			String pHandle = driver.getWindowHandle();

			Set<String> allHandles = null;
			boolean flag = false;
			while (!flag) {
				allHandles = driver.getWindowHandles();
				if (allHandles.size() > 1) {
					flag = true;
				}
			}

			for (String handle : allHandles) {
				if (!handle.equals(pHandle)) {
					driver.switchTo().window(handle);
				}
			}

			if (result == true) {
				rpt.generateReport("", "Click " + link, "", link, "Shipment Planning window must be opened",
						"Shipment Planning window opened", "Passed", "", true);
			} else {
				rpt.generateReport("", "Click " + link, "", link, "Shipment Planning window must be opened",
						"Shipment Planning window not opened", "Failed", "", true);
				throw new SkipException("Shipment Planning window not opened");
			}

			// Click OK in Shipment planning window
			cmnLib.switchToFrame("mainBody", FrameSelectBy.StringFrameName);

			if (cmnLib.clickByJSE(orderReleaseResult.shipPlanning_ConfirmOK) == true) {
				rpt.generateReport("", "Click on OK button in Shipment Planning window", "", "",
						"OK button must be clicked", "Clicked on OK button", "Passed", "", true);
			} else {
				rpt.generateReport("", "Click on OK button in Shipment Planning window", "", "",
						"OK button must be clicked", "OK button not clicked", "Failed", "", true);
				throw new SkipException("OK button not clicked in Shipment Planning window");
			}

			// Verify created Bulk Plan ID
			if (cmnLib.waitForElementToBeVisible(orderReleaseResult.bulk_Plan_ID) == true
					&& orderReleaseResult.bulk_Plan_ID.getText().length() != 0) {
				System.out.println("Bulk Plan created \nBulk Plan ID: " + orderReleaseResult.bulk_Plan_ID.getText());
				rpt.generateReport("", "Verify new Bulk Plan is created", "Verify created Bulk Plan ID", "",
						"Bulk Plan ID must be created", "Bulk Plan ID created", "Passed", "", true);
			} else {
				rpt.generateReport("", "Verify new Bulk Plan is created", "Verify created Bulk Plan ID", "",
						"Bulk Plan ID must be created", "Bulk Plan ID not created", "Failed", "", true);
				throw new SkipException("New Bulk Plan ID not created");
			}

			// Close current window and switch to parent window
			driver.close();
			driver.switchTo().window(pHandle);

		}
	}
}
