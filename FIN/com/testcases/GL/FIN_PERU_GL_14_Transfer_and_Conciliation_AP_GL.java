package com.testcases.GL;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.commons.Common_Library.FrameSelectBy;
import com.commons.TestBase;

import finance.pagefactory.AP_Reconciliation;
import finance.pagefactory.HomePage_FIN;
import finance.pagefactory.LoginPage_FIN;
import finance.pagefactory.ScheduledProcesses;
import report.oracle.ofs.ReportGeneration;
import xlsx.databank.ofs.ExcelOperations;

public class FIN_PERU_GL_14_Transfer_and_Conciliation_AP_GL extends TestBase {

	String strModule = "FIN";

	@Test
	public void FIN_PERU_GL_14_Transfer_and_Conciliation_AP_GL_TC() throws Throwable {

		boolean login = false;

		rpt = new ReportGeneration("FIN_PERU_GL_14", "Transfer_and_Conciliation_AP_GL");

		HomePage_FIN homepage = null;
		if (!(new HomePage_FIN().getUserNameFromHomePage() != null && new HomePage_FIN().getUserNameFromHomePage()
				.equalsIgnoreCase(hashmap.get("UserName_" + strModule)))) {

			// Launch Browser
			launchBrowser(strModule);

			LoginPage_FIN loginPage = new LoginPage_FIN();
			rpt.enterStepHeader("Navigate to Url");
			if (driver.getTitle().contains("Sign In")) {
				rpt.generateReport("FIN_PERU_GL_14_Transfer_and_Conciliation_AP_GL", "Navigate to Url", "", URL,
						"Browser must navigate to Url", "Browser navigated to Url", "Passed", "", true);
			} else {
				rpt.generateReport("FIN_PERU_GL_14_Transfer_and_Conciliation_AP_GL", "Navigate to Url", "", URL,
						"Browser must navigate to Url", "Failed to load Signin page", "Failed", "", true);
				Assert.fail("Failed to load Signin Page");
			}

			// Login To Application

			homepage = loginPage.login(hashmap.get("UserName_" + strModule), hashmap.get("Password_" + strModule));
			rpt.enterStepHeader("Login to Application");
			if (homepage != null) {
				rpt.generateReport("", "Enter Username", "", hashmap.get("UserName_" + strModule),
						"Username must be entered", "Username entered", "Info", "", false);
				rpt.generateReport("", "Enter Password", "", "", "Password must be entered", "Password entered", "Info",
						"", false);
				rpt.generateReport("", "Click Sign In button", "", "", "Sign In button must be clicked",
						"Clicked Sign In button", "Passed", "", true);
			} else {
				rpt.generateReport("", "Login to application", "Enter Username, Password and Click Sign In button",
						"Username: " + hashmap.get("UserName_" + strModule), "Login must be Successful",
						"Login Un-Successful", "Failed", "", true);
				Assert.fail("Login Un-Successful");
			}

			login = true;

		}

		if (!login) {
			homepage = new HomePage_FIN();
			rpt.enterStepHeader("Navigate to Url and Log into application");
			rpt.generateReport("FIN_PERU_GL_14_Transfer_and_Conciliation_AP_GL", "Login to Application", "",
					"Url: " + URL + "\nUsername: " + hashmap.get("UserName_" + strModule),
					"Application must be logged in", "Logged into application", "Passed", "", true);
		}

		exl = new ExcelOperations("Finance\\com\\databanks\\GL_TestData.xlsx");
		String sheetName = "GL14";

		System.out.println("No Of DataRows: " + exl.getRowCount(sheetName));
		for (int dataRow = 1; dataRow < exl.getRowCount(sheetName); dataRow++) {

			// TimeUnit.SECONDS.sleep(5);
			cmnLib.waitForPageLoaded();
			if (!(driver.getTitle().equalsIgnoreCase("Oracle Applications"))) {
				rpt.enterStepHeader("Navigate to HomePage");
				if (cmnLib.clickOnWebElement(homepage.HomePage_HomeIcon) == true) {
					// System.out.println("Clicked on Home icon");
					rpt.generateReport("", "Click on Home icon", "", "", "Home icon must be clicked",
							"Clicked on Home icon", "Passed", "", false);
				} else {
					rpt.generateReport("", "Click on Home icon", "", "", "Home icon must be clicked",
							"Home icon not clicked", "Passed", "", true);
					Assert.fail("Failed to click Home icon");
				}
			}

			TimeUnit.SECONDS.sleep(2);
			rpt.enterStepHeader("Navigate to Tools -> Scheduled Process");

			if (cmnLib.clickOnWebElement(homepage.NavigatorIcon) && cmnLib.clickOnWebElement(homepage.ScheduledProcesses)) {

				Thread.sleep(1000);
				rpt.generateReport("", "Click on Navigator", "", "", "Navigator must be clicked",
						"Clicked on Navigator", "Passed", "", false);
				rpt.generateReport("", "Click on Scheduled Processes link", "", "", "Scheduled Processes link must be clicked",
						"Clicked on Scheduled Processes link", "Passed", "", true);
			} else {
				rpt.generateReport("", "Navigate to Scheduled Processes page", "Click Navigator --> Scheduled Processes", "",
						"Application must navigate to Scheduled Processes page", "Scheduled Processes link not clicked", "Failed", "", true);
				Assert.fail("Failed to click Scheduled Processes link");
				
			}
			
			ScheduledProcesses scheduledProcesses= new ScheduledProcesses();
			
			//Click on Schedule New Process
			
			if(cmnLib.clickOnWebElement(scheduledProcesses.ScheduleNewProcesses) == false) 
			{
				rpt.generateReport("", "Click On Schedule New Process", "", "", "Schedule New Process should be clicked", "Schedule New Process is not clicked", "Failed", "", true);
				Assert.fail("Next Button is not Clicked");
			}
			else 
			{
				rpt.generateReport("", "Click On Schedule New Process", "", "", "Schedule New Process should be clicked", "Schedule New Process is clicked", "Passed", "", false);
			}
			
			//Click on Name Dropdown
			
			
			if(cmnLib.clickOnWebElement(scheduledProcesses.NameDropdown) == false) 
			{
				rpt.generateReport("", "Click On Name Dropdown", "", "", "Name Dropdown should be clicked", "Name Dropdown is not clicked", "Failed", "", true);
				Assert.fail("NameDropdown is not Clicked");
			}
			else 
			{
				rpt.generateReport("", "Click On Name Dropdown", "", "", "Name Dropdown should be clicked", "Name Dropdown is clicked", "Passed", "", false);
			}
			
			
			//Click on Search
			
			if(cmnLib.clickOnWebElement(scheduledProcesses.Search) == false) 
			{
				rpt.generateReport("", "Click On Search", "", "", "Search should be clicked", "Search is not clicked", "Failed", "", true);
				Assert.fail("Search is not Clicked");
			}
			else 
			{
				rpt.generateReport("", "Click On Search", "", "", "Search should be clicked", "Search is clicked", "Passed", "", false);
			}
			
			// Enter the Name
			
			
			if(cmnLib.enterDataInTextBox(scheduledProcesses.ProcessName, exl.read(sheetName, dataRow, "ProcessName"), true) == false) 
			{
				rpt.generateReport("", "Enter Process Name", "", exl.read(sheetName, dataRow, "ProcessName"), "Process Name should be entered", " Process SName is not entered", "Failed", "", true);
				Assert.fail("Unable to Enter value into TextBox");
			}
			
			
			//Click on Search Name
			
			if(cmnLib.clickOnWebElement(scheduledProcesses.SearchName) == false) 
			{
				rpt.generateReport("", "Click On Search Name", "", "", "Search Name should be clicked", "Search Name is not clicked", "Failed", "", true);
				Assert.fail("Search is not Clicked");
			}
			else 
			{
				rpt.generateReport("", "Click On Search Name", "", "", "Search should be clicked", "Search is clicked", "Passed", "", false);
			}
			
			//Click on Search Result
			
			if(cmnLib.clickOnWebElement(scheduledProcesses.SearchResult) == false) 
			{
				rpt.generateReport("", "Click On Search Result", "", "", "Search Result should be clicked", "Search Result is not clicked", "Failed", "", true);
				Assert.fail("Search is not Clicked");
			}
			else 
			{
				rpt.generateReport("", "Click On Search Result", "", "", "Search Result should be clicked", "Search Result is clicked", "Passed", "", false);
			}
			
			//Click on Ok Button
			
			
			if(cmnLib.clickOnWebElement(scheduledProcesses.OkBtn) == false) 
			{
				rpt.generateReport("", "Click On Ok", "", "", "Ok should be clicked", "Ok is not clicked", "Failed", "", true);
				Assert.fail("Search is not Clicked");
			}
			else 
			{
				rpt.generateReport("", "Click On Ok", "", "", "Ok should be clicked", "Ok is clicked", "Passed", "", false);
			}
			
            
			//Click on Ok Button
			
			
			if(cmnLib.clickOnWebElement(scheduledProcesses.OkButton) == false) 
			{
				rpt.generateReport("", "Click On Ok", "", "", "Ok should be clicked", "Ok is not clicked", "Failed", "", true);
				Assert.fail("Search is not Clicked");
			}
			else 
			{
				rpt.generateReport("", "Click On Ok", "", "", "Ok should be clicked", "Ok is clicked", "Passed", "", false);
			}
			
			//Enter the Parameter Details For Basic Options

			rpt.enterStepHeader("Enter the Parameter Details For Basic Options");
			TimeUnit.SECONDS.sleep(3);
			
			//Enter Request Name
			
			
			if(cmnLib.enterDataInTextBox(scheduledProcesses.RequestName, exl.read(sheetName, dataRow, "RequestName"), true) == false) {
				rpt.generateReport("", "Enter Request Name", "", exl.read(sheetName, dataRow, "RequestName"), "Request Name should be entered", "Request Name is not entered", "Failed", "", true);
				Assert.fail("Unable to Enter value into TextBox");
			}
			
			else 
			{
				rpt.generateReport("", "Enter the Parameter Details For Basic Options", "", "Parameter Details For Basic Options entered are:  \n RequestName: "+exl.read(sheetName, dataRow, "RequestName"),"All Valid details should be entered", "Details are entered", "Passed", "", true);
			}
			
			//Click on Submit Button
			
			if(cmnLib.clickOnWebElement(scheduledProcesses.SubmitBtn) == false) 
			{
				rpt.generateReport("", "Click On Submit Button", "", "", "Submit Button should be clicked", "Submit Button is not clicked", "Failed", "", true);
				Assert.fail("Search is not Clicked");
			}
			else 
			{
				rpt.generateReport("", "Click On Submit Button", "", "", "Submit Button should be clicked", "Submit Button is clicked", "Passed", "", false);
			}
			
			
			//Validation of Confirmation Message
			
			 TimeUnit.SECONDS.sleep(3);
		     
		     rpt.enterStepHeader("Check if Confirmation Dialog Box Appear");
		     
		     
		     TimeUnit.SECONDS.sleep(3);
		     
		     WebElement confirmationmsg = driver.findElement(By.xpath("//label[contains(text(),'Process')]"));
		     String confirmmsg = confirmationmsg.getText();
		     
		     TimeUnit.SECONDS.sleep(3);
		     
		     if(confirmmsg.contains("Process")) {
		     rpt.generateReport("", "Check if Confirmation Dialog Box Appear", "", "", "Confirmation Dialog Box  must be appear",
		        "Confirmation Dialog Box Opened", "Passed", "", true);
		     } else {
		      rpt.generateReport("", "Check if Confirmation Dialog Box Appear", "", "",
		        "Confirmation Dialog Box  must be appear",
		        "Confirmation Dialog Box  is not Opened", "Failed", "", true);
		      Assert.fail("Failed to get Confirmation Dialog Box ");
		           
		     }
		     
		     //Click on Ok  Button
		     
		     if(cmnLib.clickOnWebElement(scheduledProcesses.OK_Confirmation) == false) 
				{
					rpt.generateReport("", "Click On Ok Button", "", "", "Ok Button should be clicked", "Ok Button is not clicked", "Failed", "", true);
					Assert.fail("Ok is not Clicked");
				}
				else 
				{
					rpt.generateReport("", "Click On Ok Button", "", "", "Ok Button should be clicked", "Ok Button is clicked", "Passed", "", false);
				}
		     
		        
		     AP_Reconciliation aP_Reconciliation= new AP_Reconciliation();
		        
		        TimeUnit.SECONDS.sleep(2);
				rpt.enterStepHeader("Navigate to Payables -> Invoices");

				if (cmnLib.clickOnWebElement(homepage.NavigatorIcon) && cmnLib.clickOnWebElement(aP_Reconciliation.Invoices)) {

					Thread.sleep(1000);
					rpt.generateReport("", "Click on Navigator", "", "", "Navigator must be clicked",
							"Clicked on Navigator", "Passed", "", false);
					rpt.generateReport("", "Click on Payables link", "", "", "Payables link must be clicked",
							"Clicked on Payables link", "Passed", "", true);
				} else {
					rpt.generateReport("", "Navigate to Payables page", "Click Navigator --> Invoices", "",
							"Application must navigate to Payables  page", "Payables link not clicked", "Failed", "", true);
					Assert.fail("Failed to click Payables link");
					
				}
				
				TimeUnit.SECONDS.sleep(5);
				rpt.enterStepHeader("Navigate to Payables to Ledger Reconciliation");

				if (cmnLib.clickOnWebElement(aP_Reconciliation.TaskPane)
						&& cmnLib.clickOnWebElement(aP_Reconciliation.PayablesToLedger)) {

					rpt.generateReport("", "Click on Task Pane", "", "", "Task Pane must be clicked",
							"Clicked on Task Pane", "Passed", "", false);
					rpt.generateReport("", "Click on Payables to Ledger Reconciliation link", "", "", "Payables to Ledger Reconciliation link must be clicked",
							"Clicked on Payables to Ledger Reconciliation link", "Passed", "", true);
				} else {
					rpt.generateReport("", "Click on Payables to Ledger Reconciliation link in Task Pane", "", "",
							"Click on Payables to Ledger Reconciliation link must be clicked", "Not clicked on Click on Payables to Ledger Reconciliation link", "Failed", "",
							true);
					Assert.fail("Failed to click on Payables to Ledger Reconciliation link");
				}
				
				 
				TimeUnit.SECONDS.sleep(5);
				//Verify Receivables to Ledger Reconciliation page is displayed
				
				TimeUnit.SECONDS.sleep(5);
				
				if(cmnLib.waitForElementToBeVisible(aP_Reconciliation.PayablesHeader) == true)
				{
					TimeUnit.SECONDS.sleep(6);
					rpt.generateReport("", "Navigation to Payables to Ledger Reconciliation page", "", "", "Payables to Ledger Reconciliation page should be displayed", "Payables to Ledger Reconciliation page Is displayed", "Passed", "", true );

				}
				
				else
				{
					//FAIL
					rpt.generateReport("", "Navigation to Payables to Ledger Reconciliation page", "", "", "Payables to Ledger Reconciliation page should not be displayed", "Payables to Ledger Reconciliation page Is Not displayed", "Failed", "", true );
					Assert.fail("Payables to Ledger Reconciliation page is not displayed");
				}	
			     
				
		        Thread.sleep(10000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,1000)");
				Thread.sleep(4000);
				
			      
				cmnLib.switchToFrame("mainBody", FrameSelectBy.StringFrameName); 
			     rpt.enterStepHeader("Check if we are able to see the difference in Red");
			     
			     
			       TimeUnit.SECONDS.sleep(6);
					
					WebElement confirmationmessage = driver.findElement(By.xpath("//td[text()='Accounting End Balance']"));
					String confirmmesg = confirmationmessage.getText();
					
					TimeUnit.SECONDS.sleep(3);
					
					if(confirmmesg.contains("Accounting")) {
						rpt.generateReport("", "Check if we are able to see the Report", "", "", "Report must be viewed",
									"Able to view report", "Passed", "", true);
						} else {
							rpt.generateReport("", "Check if we are able to see the Report", "", "",
									"Report must be viewed",
									"Not Able to view report", "Failed", "", true);
							Assert.fail("Failed to view report");		
				}
					
				
			
		
		}
	}
}