package com.testcases;

import java.util.Set;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.commons.Common_Library.DropDownSelectBy;
import com.commons.Common_Library.FrameSelectBy;
import com.commons.TestBase;
import com.sun.jndi.cosnaming.CNNameParser;

import otm.pagefactory.GenerateCustomReports;
import otm.pagefactory.HomePage_OTM;
import otm.pagefactory.LoginPage_OTM;
import otm.pagefactory.OrderReleaseFinder;
import otm.pagefactory.OrderReleaseResult;
import report.oracle.ofs.ReportGeneration;

import xlsx.databank.ofs.ExcelOperations;


/**
Script Name			: OTM_CHILE_LAS014_Generate_Custom_Reports
Script Description	: Generate Custom Reports
Track/Module		: OTM
Sub Track			: 
Created By			: Pradhanvi T R
Creation Date		: 28-Jan-19
Modified By 		: 
Modification Date	: 
Instance Name & URL : https://otmgtm-edyg-dev7.otm.us2.oraclecloud.com/GC3/glog.webserver.servlet.umt.Logi
User ID/ Password	: TESTING_CHILE@beehiveonline.oracle.com/Bimbo321
Responsibility		: Domain(edyg-dev7)
Pre-Requisites		: 
Comments (if any)	:
 **/
public class OTM_CHILE_LAS014_Generate_Custom_Reports extends TestBase {

	String strModule = "OTM_CHILE";
	@Test
	public void LAS014_Generate_Custom_Reports_TC() throws Throwable {
		rpt = new ReportGeneration("OTM_CHILE_LAS014_Generate_Custom_Reports", "Generate Custom Reports");

		String strDataSheetName = "LAS014";
		boolean login = false;

		rpt.enterStepHeader("Login To Application");
		
		HomePage_OTM homePage_OTM = null;
		if(! (new HomePage_OTM().getUserNameFromHomePage() != null && new HomePage_OTM().getUserNameFromHomePage().equalsIgnoreCase(hashmap.get("UserName_"+strModule)))) {

			//Launch Browser
			launchBrowser(strModule);

			//Login To Application
			
			LoginPage_OTM loginPage_OTM = PageFactory.initElements(driver, LoginPage_OTM.class);
			loginPage_OTM.setDomain(hashmap.get("Domain_" + strModule));			
			homePage_OTM = loginPage_OTM.login(hashmap.get("UserName_"+strModule), hashmap.get("Password_"+strModule));
			rpt.enterStepHeader("Login to Application");
			if (homePage_OTM != null) {
				rpt.generateReport("", "Enter Username", "", hashmap.get("UserName_" + strModule),
						"Username must be entered", "Username entered", "Passed", "", true);
				rpt.generateReport("", "Enter Password", "", "", "Password must be entered", "Password entered",
						"Passed", "", true);
				rpt.generateReport("", "Click Sign In button", "", "", "Sign In button must be clicked",
						"Clicked Sign In button", "Passed", "", false);
			} else {
				rpt.generateReport("", "Login to application", "Enter Username, Password and Click Sign In button",
						"Username: " + hashmap.get("UserName_" + strModule), "Login must be Successful",
						"Login Un-Successful", "Failed", "", true);
				Assert.fail("Login Un-Successful");
			}

			login = true;
		}

		//Initialize HomePage Web Elements

		//Validate HomePage Icon
		TimeUnit.SECONDS.sleep(10);
		if(cmnLib.waitForElementToBeVisible(homePage_OTM.HomePage_HomeIcon) == true)
		{
			homePage_OTM = PageFactory.initElements(driver, HomePage_OTM.class);
			//PASS
			rpt.generateReport("OTM_CHILE_LAS014_Generate_Custom_Reports", "Enter URL", "", "Password: "+hashmap.get("URL_"+strModule), "URL should be entered", "URL is entered", "Info", "", false );
			rpt.generateReport("", "Enter User Name", "", "UserName: "+hashmap.get("UserName_"+strModule), "UserName should be entered", "UserName is entered", "Info", "", false );
			rpt.generateReport("", "Enter Password", "", "Password: "+hashmap.get("Password_"+strModule), "Password should be entered", "Password is entered", "Info", "", false );
			rpt.generateReport("", "Validate Login to Appication", "", "", "Login Should be successful", "Login Is Successful", "Passed", "", false );
		}else
		{
			//FAIL
			rpt.generateReport("OTM_CHILE_LAS014_Generate_Custom_Reports", "Login to Appication", "", "UserName: "+hashmap.get("UserName_"+strModule), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
			Assert.fail("Login Un-Successful");
		}
		rpt.enterStepHeader("Navigation to Cost Accounting Page");

		//Always Load TestData Sheet Excel After Login as UserName & Password exists in other Excel which is loaded in TestBase
		exl = new ExcelOperations("OTM\\com\\dataBanks\\OTM_TestData.xlsx");

		// Script will execute for all the Rows present in the Data Sheet.
		System.out.println("No Of DataRows: "+exl.getRowCount(strDataSheetName));
		for (int dataRow = 1; dataRow < exl.getRowCount(strDataSheetName); dataRow++) {

		//Navigation
			if(homePage_OTM.clickOnWelcomePage_HomeIcon() == true)
			{
				homePage_OTM = PageFactory.initElements(driver, HomePage_OTM.class);
			}else
			{
				rpt.generateReport("", "Click On HomePage Icon", "", "", "HomePage Icon should be clicked", "HomePage Icon is not clicked", "Failed", "", true);
			}

		//Verify Presence of Navigator Icon
			if(homePage_OTM.NavigatorIcon.isDisplayed() == false)
			{
				//FAIL
				rpt.generateReport("", "Validate HomePage", "", "", "Validation Should be successful", "Validation Is Not Successful", "Failed", "", true );
				Assert.fail("Login Un-Successful");
			}
			TimeUnit.SECONDS.sleep(5);
		//Click on Navigator Icon
			homePage_OTM.clickOnNavigationIcon();
			TimeUnit.SECONDS.sleep(5);
			
		//Click On Order Release
			OrderReleaseFinder orderReleaseFinder = homePage_OTM.clickOnOrderRelease();
			cmnLib.clickOnWebElement(homePage_OTM.OrderReleaseSubLink);
			TimeUnit.SECONDS.sleep(5);
			cmnLib.waitForPageLoaded();
			// Perform search with Order Release ID
			//OrderReleaseFinder orderReleaseFinder = new OrderReleaseFinder();
						cmnLib.switchToFrame(orderReleaseFinder.actionFrame, FrameSelectBy.FrameWebElement);
						rpt.enterStepHeader("Perform Search with Order Release ID");
						 OrderReleaseResult orderReleaseResult = null;
						cmnLib.enterDataInTextBox(orderReleaseFinder.order_Relase_ID,
								exl.read(strDataSheetName, dataRow, "OrderReleaseID"), false);
						if (cmnLib.clickByJSE(orderReleaseFinder.search_button)) {
							orderReleaseResult = new OrderReleaseResult();
							rpt.generateReport("", "Enter Order Release ID", "Enter Order Release ID",
									exl.read(strDataSheetName, dataRow, "OrderReleaseID"), "Order Release ID must be entered",
									"Order Release ID entered", "Passed", "", false);
							rpt.generateReport("", "Click on Search button", "Click on Search button", "",
									"Search button must be clicked", "Clicked on Search button", "Passed", "", false);
						} else {
							rpt.generateReport("", "Perform search with Order Release ID",
									"Enter Order Release ID and Click Search button",
									exl.read(strDataSheetName, dataRow, "OrderReleaseID"), "Search must be Successful",
									"Search Un-Successful", "Passed", "", true);
							Assert.fail("Search Un-Successful");
						}
						//Verify Results
						String OrderReleaseID = exl.read(strDataSheetName, dataRow, "OrderReleaseID");
						if(orderReleaseResult.verifyOrderReleaseIDInResults(OrderReleaseID) == true) {
							rpt.generateReport("", "Verify Results", "",
									OrderReleaseID, "Order Release ID must appear in results",
									"Order Release ID appears in results", "Passed", "", true);
						}else {
							rpt.generateReport("", "Verify Results", "",
									OrderReleaseID, "Order Release ID must appear in results",
									"Order Release ID did not appear in results", "Failed", "", true);
							Assert.fail("Order Release ID did not appear in results");
						}
						
						//Selecting the Order
						rpt.enterStepHeader("Selecting the OrderRelease ID");
						System.out.println("Before Condition");
						if(orderReleaseResult.selectOrderFromResuls(OrderReleaseID)) {
							System.out.println("After Condition");
							rpt.generateReport("", "Selecting the Order release ID", "",
									OrderReleaseID, "Order Release ID must be selected",
									"Order Release ID selected", "Passed", "", true);
						}else {
							System.out.println("Failed to select Order from results");
						}
						

						// Selecting Actions dropdown
						if (cmnLib.clickByJSE(orderReleaseResult.actionsDropdown) == true) {
							rpt.generateReport("", "Click Actions dropdown", "", "", "Actions dropdown must be clicked",
									"Clicked on Actions dropdown", "Passed", "", true);
						} else {
							rpt.generateReport("", "Click Actions dropdown", "", "", "Actions dropdown must be clicked",
									"Actions dropdown not clicked", "Failed", "", true);
							Assert.fail("Actions dropdown not clicked");
						}
						cmnLib.switchToFrame("actionFrame", FrameSelectBy.StringFrameName);

						String parentNode = exl.read(strDataSheetName, dataRow, "Actions_Parent");
						String childNode = exl.read(strDataSheetName, dataRow, "Actions_Child");
						String link = exl.read(strDataSheetName, dataRow, "Actions_Link");

						// Select Parent Node under Actions dropdown
						WebElement parentElement = orderReleaseResult.clickNodeUnderActionsDropdown(orderReleaseResult.actionTree,
								parentNode);

						if (parentElement != null) {
							rpt.generateReport("", "Click " + parentNode + " under Actions dropdown", "", parentNode,
									parentNode + " must be clicked", "Clicked " + parentNode, "Passed", "", true);
						} else {
							rpt.generateReport("", "Click " + parentNode + " under Actions dropdown", "", parentNode,
									parentNode + " must be clicked", parentNode + "not clicked", "Failed", "", true);
							Assert.fail(parentNode + "not clicked");
						}

						// Select Child Node
						WebElement childElement = orderReleaseResult.clickNodeUnderActionsDropdown(parentElement,
								exl.read(strDataSheetName, dataRow, "Actions_Child"));

						if (childElement != null) {
							rpt.generateReport("", "Click " + childNode, "", childNode, childNode + " must be clicked",
									"Clicked " + childNode, "Passed", "", true);
						} else {
							rpt.generateReport("", "Click " + childNode, "", childNode, childNode + " must be clicked",
									childNode + " not clicked", "Failed", "", true);
							Assert.fail(childNode + "not clicked");
						}

						// Click link
						boolean result = orderReleaseResult.selectLinkUnderNode(childElement, exl.read(strDataSheetName, dataRow, "Actions_Link"));

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
							rpt.generateReport("", "Click " + link, "", link, "Bulk report window must be opened",
									"Bulk report window opened", "Passed", "", true);
						} else {
							rpt.generateReport("", "Click " + link, "", link, "Bulk report window must be opened",
									"Bulk report window not opened", "Failed", "", true);
							Assert.fail("Bulk report window not opened");
						}
						// Switching control to Bulk reports
						cmnLib.switchToFrame("mainBody", FrameSelectBy.StringFrameName);
						//Selecting custom reports
						GenerateCustomReports generateCustomerReports=new GenerateCustomReports();
						rpt.enterStepHeader("Selecting Bulk reports name");
						cmnLib.waitForPageLoaded();
						cmnLib.waitForElementToBeClickable(generateCustomerReports.OrderRelease_ReportName);
						if (cmnLib.selectDropdownBy(generateCustomerReports.OrderRelease_ReportName,exl.read(strDataSheetName, dataRow, "ReportName"), DropDownSelectBy.VisibleText) == true)
						{
							rpt.generateReport("", "Click reports dropdown", "", "", "reports dropdown must be clicked",
									"Clicked on reports dropdown", "Passed", "", true);
						} else {
							rpt.generateReport("", "Click reports dropdown", "", "", "reports dropdown must be clicked",
									"reports dropdown not clicked", "Failed", "", true);
							Assert.fail("reports dropdown not clicked");
						}
						rpt.enterStepHeader("Selecting report format");
						TimeUnit.SECONDS.sleep(3);
						if (cmnLib.selectDropdownBy(generateCustomerReports.formateType,exl.read(strDataSheetName, dataRow, "FormatType"), DropDownSelectBy.VisibleText) == true)
						{
							rpt.generateReport("", "Click report format dropdown", "", "", "report format dropdown must be clicked",
									"Clicked on report format dropdown", "Passed", "", true);
						} else {
							rpt.generateReport("", "Click report format dropdown", "", "", "report format dropdown must be clicked",
									"report format dropdown not clicked", "Failed", "", true);
							Assert.fail("report format dropdown not clicked");
						}
						
						rpt.generateReport("", "Selecting the report parameters", "",
								"PDF", "Parameters are selected",
								"Parameters are selected", "Passed", "", true);
						generateCustomerReports.clickSubmit();
						TimeUnit.SECONDS.sleep(10);
						rpt.generateReport("OTM_LAS014", "Report generation", "",
								"", "Capturing the report",
								"Report generated successfully", "Passed", "", true);
						TimeUnit.SECONDS.sleep(5);
						
						
						
						
		}
	}

}
