package com.testcases.GL;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.commons.TestBase;
import com.commons.Common_Library.DropDownSelectBy;

import finance.pagefactory.AutoReversing;
import finance.pagefactory.BudgetPeriodStatuses;
import finance.pagefactory.HomePage_FIN;
import finance.pagefactory.LoginPage_FIN;
import report.oracle.ofs.ReportGeneration;
import xlsx.databank.ofs.ExcelOperations;

public class FIN_PERU_GL_21_Closing_the_GL_period extends TestBase {

	String strModule = "FIN";

	@Test
	public void FIN_PERU_GL_21_Closing_the_GL_period_TC() throws Throwable {

		boolean login = false;

		rpt = new ReportGeneration("FIN_PERU_GL_21", "Closing_the_GL_period");

		HomePage_FIN homepage = null;
		if (!(new HomePage_FIN().getUserNameFromHomePage() != null && new HomePage_FIN().getUserNameFromHomePage()
				.equalsIgnoreCase(hashmap.get("UserName_" + strModule)))) {

			// Launch Browser
			launchBrowser(strModule);

			LoginPage_FIN loginPage = new LoginPage_FIN();
			rpt.enterStepHeader("Navigate to Url");
			if (driver.getTitle().contains("Sign In")) {
				rpt.generateReport("FIN_PERU_GL_21_Closing_the_GL_period", "Navigate to Url", "", URL,
						"Browser must navigate to Url", "Browser navigated to Url", "Passed", "", true);
			} else {
				rpt.generateReport("FIN_PERU_GL_21_Closing_the_GL_period", "Navigate to Url", "", URL,
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
			rpt.generateReport("FIN_PERU_GL_21_Closing_the_GL_period", "Login to Application", "",
					"Url: " + URL + "\nUsername: " + hashmap.get("UserName_" + strModule),
					"Application must be logged in", "Logged into application", "Passed", "", true);
		}

		exl = new ExcelOperations("Finance\\com\\databanks\\GL_TestData.xlsx");
		String sheetName = "GL21";

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
			rpt.enterStepHeader("Navigate to Budgetary Control -> BudgetaryControl");

			if (cmnLib.clickOnWebElement(homepage.NavigatorIcon) && cmnLib.clickOnWebElement(homepage.BudgetaryControl)) {

				Thread.sleep(1000);
				rpt.generateReport("", "Click on Navigator", "", "", "Navigator must be clicked",
						"Clicked on Navigator", "Passed", "", false);
				rpt.generateReport("", "Click on Budgetary Control link", "", "", "Budgetary Control link must be clicked",
						"Clicked on Budgetary Control link", "Passed", "", true);
			} else {
				rpt.generateReport("", "Navigate to Budgetary Control page", "Click Navigator --> Budgetary Control", "",
						"Application must navigate to Budgetary Control page", "Budgetary Control link not clicked", "Failed", "", true);
				Assert.fail("Failed to click Budgetary Control link");
			}
			
			BudgetPeriodStatuses budgetPeriodStatuses = new BudgetPeriodStatuses();

			TimeUnit.SECONDS.sleep(5);
			rpt.enterStepHeader("Navigate to Budget Period Statuses Page");

			if (cmnLib.clickOnWebElement(budgetPeriodStatuses.TaskPane)
					&& cmnLib.clickOnWebElement(budgetPeriodStatuses.BudgetPeriodStatuses)) {

				rpt.generateReport("", "Click on Task Pane", "", "", "Task Pane must be clicked",
						"Clicked on Task Pane", "Passed", "", false);
				rpt.generateReport("", "Click on Budget Period Statuses link", "", "", "Budget Period Statuses link must be clicked",
						"Clicked on Budget Period Statuses link", "Passed", "", true);
			} else {
				rpt.generateReport("", "Click on Budget Period Statuses link in Task Pane", "", "",
						"Budget Period Statuses link must be clicked", "Not clicked on Budget Period Statuses link", "Failed", "",
						true);
				Assert.fail("Failed to click Budget Period Statuses link");
			}
			
			
			//Click on Edit
			
			if(cmnLib.clickOnWebElement(budgetPeriodStatuses.Edit) == true)

			{
				rpt.generateReport("", "Click on Edit ", "", "", "Edit should be clicked", "Edit Is Clicked", "Passed", "", true );
			  
			}

			else
			{
				//FAIL
				Assert.fail("Edit is not clicked");
			}
			
			// Enter in the Search Bar
			
			if(cmnLib.enterDataInTextBox(budgetPeriodStatuses.SearchIcon, exl.read(sheetName, dataRow, "SearchIcon"), false)==true) 
			{
			  
			  rpt.generateReport("", "Enter Open", exl.read(sheetName, dataRow, "SearchIcon"), "", "Open must be entered","Open entered", "Passed", "", true);
			} 
			else 
			{
			  rpt.generateReport("", "Enter Open", "", "","Open must be entered","Open is not entered", "Failed", "", true);
			  Assert.fail("Failed to enter Opend in search icon");
			}
		   cmnLib.pressEnterKey();
		
		   TimeUnit.SECONDS.sleep(3);
		   
			//Enter the Status
			
			if(cmnLib.selectDropdownBy(budgetPeriodStatuses.Status, exl.read(sheetName, dataRow, "Status"), DropDownSelectBy.VisibleText) == false) {
				rpt.generateReport("", "Select Status", "", exl.read(sheetName, dataRow, "Status"), "Status should be selected from Dropdown", "Status is not selected from the dropdown", "Failed", "", true);
				Assert.fail("Unable to select from Dropdown");
			}
			
			//Click on Save
			
			if(cmnLib.clickOnWebElement(budgetPeriodStatuses.Save) == true)

			{
				rpt.generateReport("", "Click on Save ", "", "", "Save should be clicked", "Save Is Clicked", "Passed", "", true );
			  
			}

			else
			{
				//FAIL
				Assert.fail("Save is not clicked");
			}
			
			//Click on OK
			
			if(cmnLib.clickOnWebElement(budgetPeriodStatuses.OK) == true)

			{
				rpt.generateReport("", "Click on OK ", "", "", "OK should be clicked", "OK Is Clicked", "Passed", "", true );
			  
			}

			else
			{
				//FAIL
				Assert.fail("OK is not clicked");
			}
			
			
			
			
		}
	}
	
}