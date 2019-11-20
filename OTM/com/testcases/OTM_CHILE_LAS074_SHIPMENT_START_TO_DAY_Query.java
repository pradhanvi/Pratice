package com.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.commons.TestBase;
import com.commons.Common_Library.FrameSelectBy;

import otm.pagefactory.DispatchBoard;
import otm.pagefactory.HomePage_OTM;
import otm.pagefactory.LoginPage_OTM;
import report.oracle.ofs.ReportGeneration;
import xlsx.databank.ofs.ExcelOperations;

/**
Script Name			: OTM_CHILE_LAS005_Edit_Shipment_Quantities
Script Description	: Edit Shipment Quantities
Track/Module		: OTM
Sub Track			: 
Created By			: Pradhanvi T R
Creation Date		: 16-Mar-19
Modified By 		: 
Modification Date	: 
Instance Name & URL : https://otmgtm-edyg-dev7.otm.us2.oraclecloud.com/GC3/glog.webserver.servlet.umt.Logi
User ID/ Password	: TESTING_CHILE@beehiveonline.oracle.com/Bimbo321
Responsibility		: Domain(edyg-dev7)
Pre-Requisites		: 
Comments (if any)	:
 **/

public class OTM_CHILE_LAS074_SHIPMENT_START_TO_DAY_Query extends TestBase{

	String strModule = "OTM_CHILE";

	@Test 
	public void f() throws Throwable {
		rpt = new ReportGeneration("OTM_CHILE_LAS074_SHIPMENT_START_TO_DAY_Query", "How to Use SHIPMENT_START_TO_DAY Query");

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
			rpt.generateReport("LAS074", "Enter Username", "",
					hashmap.get("UserName_" + strModule), "Username must be entered", "Username entered", "Passed", "",
					false);
			rpt.generateReport("LAS074", "Enter Password", "", "", "Password must be entered", "Password entered", "Passed",
					"", false);
			rpt.generateReport("LAS074", "Click Sign In button", "", "", "Sign In button must be clicked",
					"Clicked Sign In button", "Passed", "", true);
		} else {
			rpt.generateReport("LAS074", "Login to application",
					"Enter Username, Password and Click Sign In button",
					"Username: " + hashmap.get("UserName_" + strModule), "Login must be Successful",
					"Login Un-Successful", "Failed", "", true);
			throw new SkipException("Login Un-Successful");
		}
		exl = new ExcelOperations("OTM\\com\\databanks\\OTM_TestData.xlsx");
		String sheetName = "LAS074";

		System.out.println("No Of DataRows: " + exl.getRowCount(sheetName));
		for (int dataRow = 1; dataRow < exl.getRowCount(sheetName); dataRow++) {

			cmnLib.waitForPageLoaded();
			if (!(driver.getTitle().equals("Logistics Cloud - Home"))) {
				cmnLib.clickOnWebElement(homepage.HomePage_HomeIcon);
				System.out.println("Clicked on Home icon");
			}
			
			// Click Assignment Board Icon
			
						System.out.println("Assignment Board");
						rpt.enterStepHeader("Select Assignment Board");
						
						if (cmnLib.clickOnLinkText("Tablero de Asignacion") == true) {
							rpt.generateReport("", "Click on Assignment Board icon", "", "", "Assignment Board icon must be clicked",
									"Clicked on Assignment Board icon", "Passed", "", true);
						} else {
							rpt.generateReport("", "Navigate to Dispatch Board page", "Click on Assignment Order icon", "",
									"Application must navigate to Dispatch Board page",
									"Failed to click and navigate to Dispatch Board page", "Failed", "", true);
							throw new SkipException("Failed to click and navigate to Dispatch Board page");
						}
						DispatchBoard dispatchboard=new DispatchBoard();	
						TimeUnit.SECONDS.sleep(6); 
						
			//Select Query drop down
						TimeUnit.SECONDS.sleep(6); 
						System.out.println("title: Frame: = "+driver.getTitle());
						//Switching the frame to Dispatch board
							//cmnLib.switchToFrame("mainContentRegion:1:if1::f", FrameSelectBy.StringFrameName);
						
						//Dev4-19C Reg
						cmnLib.switchToFrame("mcr:2:if1::f", FrameSelectBy.StringFrameName);
						
						cmnLib.waitForElementToBeVisible(dispatchboard.queryDropdown);
						
						System.out.println("Element is visible");
						dispatchboard.queryDropdown.click();
						System.out.println("Clicked on dropdown");
						dispatchboard.Select_ShipmentStartToDay.click();
						
						if(dispatchboard.selectDropdownOptions(exl.read(sheetName, dataRow, "Query")))
						{
							rpt.generateReport("", "Click Query dropdown", "", "", "Query dropdown must be clicked",
									"Clicked on Query dropdown", "Passed", "", true);
							System.out.println("Query got selected");
						} else {
							rpt.generateReport("", "Click Query dropdown", "", "", "Query dropdown must be clicked",
									"Query dropdown not clicked", "Failed", "", true);
							System.out.println("Query not selected");
							throw new SkipException("Query dropdown not clicked");
						}
					    System.out.println("Selected dropdown");
					    dispatchboard.clickExecuteButton();
					    
				
					    
		}
	}


}
