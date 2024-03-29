package com.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.commons.TestBase;
import com.commons.Common_Library.FrameSelectBy;

import otm.pagefactory.DispatchBoard;
import otm.pagefactory.HomePage_OTM;
import otm.pagefactory.LoginPage_OTM;
import report.oracle.ofs.ReportGeneration;
import xlsx.databank.ofs.ExcelOperations;

/**
Script Name			: OTM_CHILE_LAS078_Change_Start_Time
Script Description	: To Change Start Time
Track/Module		: OTM
Sub Track			: 
Created By			: Pradhanvi T R
Creation Date		: 18-Mar-19
Modified By 		: 
Modification Date	: 
Instance Name & URL : https://otmgtm-edyg-dev7.otm.us2.oraclecloud.com/GC3/glog.webserver.servlet.umt.Logi
User ID/ Password	: TESTING_CHILE@beehiveonline.oracle.com/Bimbo321
Responsibility		: Domain(edyg-dev7)
Pre-Requisites		: 
Comments (if any)	:
 **/

public class OTM_CHILE_LAS078_Change_Start_Time extends TestBase {

	String strModule = "OTM_CHILE";

	@Test 
	public void OTM_CHILE_LAS078_Change_Start_Time_TC() throws Throwable {
		rpt = new ReportGeneration("OTM_CHILE_LAS078_Change_Start_Time", "To Change Start Time");
		String sheetName = "LAS078";
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
			rpt.generateReport("OTM_CHILE_LAS078_Change_Start_Time", "Enter Username", "",
					hashmap.get("UserName_" + strModule), "Username must be entered", "Username entered", "Passed", "",
					false);
			rpt.generateReport("", "Enter Password", "", "", "Password must be entered", "Password entered", "Passed",
					"", false);
			rpt.generateReport("", "Click Sign In button", "", "", "Sign In button must be clicked",
					"Clicked Sign In button", "Passed", "", true);
		} else {
			rpt.generateReport("OTM_CHILE_LAS078_Change_Start_Time", "Login to application",
					"Enter Username, Password and Click Sign In button",
					"Username: " + hashmap.get("UserName_" + strModule), "Login must be Successful",
					"Login Un-Successful", "Failed", "", true);
			Assert.fail("Login Un-Successful");
		}
		exl = new ExcelOperations("OTM\\com\\databanks\\OTM_TestData.xlsx");
		

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
							Assert.fail("Failed to click and navigate to Dispatch Board page");
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
						
						//cmnLib.waitForElementToBeVisible(dispatchboard.queryDropdown);
						
						cmnLib.clickOnWebElement(dispatchboard.queryDropdown);
						cmnLib.clickOnWebElement(dispatchboard.Select_ShipmentStartToDay);
						
						if(dispatchboard.selectDropdownOptions(exl.read(sheetName, dataRow, "Query")))
						{
							rpt.generateReport("", "Click Query dropdown", "", "", "Query dropdown must be clicked",
									"Clicked on Query dropdown", "Passed", "", true);
							System.out.println("Query got selected");
						} else {
							rpt.generateReport("", "Click Query dropdown", "", "", "Query dropdown must be clicked",
									"Query dropdown not clicked", "Failed", "", true);
							System.out.println("Query not selected");
							Assert.fail("Query dropdown not clicked");
						}
					    System.out.println("Selected dropdown");
					    //dispatchboard.clickExecuteButton();
					    
					    
				//Selecting the shipments
					    TimeUnit.SECONDS.sleep(4);
					 if(dispatchboard.ClickOnSearchedResults())
					 {
						   rpt.generateReport("", "Selecting the shipments", "", "", "Must select an shipment with the given query","Shipments are selected", "Passed", "", true);
					 }else {
						 rpt.generateReport("", "Selecting the shipments", "", "", "Must select an shipment with the given query","Shipments are NOT selected", "Failed", "", true);
						   Assert.fail("Shipments are NOT selected");
					 }
					  
					    
				//Clicking on Actions Icon
					    
					    if(cmnLib.clickOnWebElement(dispatchboard.Actions_Icon))
					    {
							   rpt.generateReport("", "Click on Actions Icon", "", "", "Actions Icon must be clicked","Actions Icon is clicked", "Passed", "", true);
						 }else {
							   rpt.generateReport("", "Click on Actions Icon", "", "", "Actions Icon must be clicked","Actions Icon is NOT clicked", "Failed", "", true);
							   Assert.fail("Actions Icon is NOT clicked");
						 }
			 //Switching frame to Actions  
					    cmnLib.switchToFrame("actionFrame", FrameSelectBy.StringFrameName);
					    cmnLib.clickOnWebElement(dispatchboard.ChangeStartTime);
					    cmnLib.waitForPageLoaded();
					    
					    cmnLib.switchToWindowTab("Change Start Time");
					    if(cmnLib.switchToFrame("mainBody", FrameSelectBy.StringFrameName)) {
					    	System.out.println("Switch to Frame: mainBody - Successfull...");
					    }
				//Changing the Start date
					    
					    if(cmnLib.enterDataInTextBox(dispatchboard.StartTime, exl.read(sheetName, dataRow, "StartTime_Change"), true))
					    {
							   	rpt.generateReport("", "Change Start Time", "", exl.read(sheetName, dataRow, "StartTime_Change"), "Start time must be entered","Start time is entered", "Passed", "", true);
						   }else
						   {
							   rpt.generateReport("", "Change Start Time", "", exl.read(sheetName, dataRow, "StartTime_Change"), "Start time must be entered","Start time is NOT entered", "Failed", "", true);
							   Assert.fail("Start time is NOT entered");
						   }
					    cmnLib.clickOnWebElement(dispatchboard.ResetOrderTimeWindows);
					   cmnLib.clickOnWebElement(dispatchboard.OKButton);
					    
					   
					   if(cmnLib.waitForElementToBeVisible(dispatchboard.ConfirmationWindow))
					   {
						   rpt.generateReport("", "Change Start Time", "", exl.read(sheetName, dataRow, "StartTime_Change"), "Start time must be changed successfully","Start time changed successfully", "Passed", "", true);
						   TimeUnit.SECONDS.sleep(3);
					   }else if(cmnLib.waitForElementToBeVisible(dispatchboard.ErrorWindow))
					   {
						   rpt.generateReport("", "Change Start Time", "", exl.read(sheetName, dataRow, "StartTime_Change"), "Start time must be changed successfully","Start time NOT changed", "Failed", "", true);
						   Assert.fail("Start time NOT changed");
					   }
					   
					 
		}
	}






}
