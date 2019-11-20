package com.testcases.GL;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.commons.Common_Library.DropDownSelectBy;
import com.commons.TestBase;

import finance.pagefactory.AutoReversing;
import finance.pagefactory.HomePage_FIN;
import finance.pagefactory.LoginPage_FIN;
import report.oracle.ofs.ReportGeneration;
import xlsx.databank.ofs.ExcelOperations;

public class FIN_PERU_GL_12_AutoReversing_Journal_Batches extends TestBase {

	String strModule = "FIN";

	@Test
	public void FIN_PERU_GL_12_AutoReversing_Journal_Batches_TC() throws Throwable {

		boolean login = false;

		rpt = new ReportGeneration("FIN_PERU_GL_12", "AutoReversing_Journal_Batches");

		HomePage_FIN homepage = null;
		if (!(new HomePage_FIN().getUserNameFromHomePage() != null && new HomePage_FIN().getUserNameFromHomePage()
				.equalsIgnoreCase(hashmap.get("UserName_" + strModule)))) {

			// Launch Browser
			launchBrowser(strModule);

			LoginPage_FIN loginPage = new LoginPage_FIN();
			rpt.enterStepHeader("Navigate to Url");
			if (driver.getTitle().contains("Sign In")) {
				rpt.generateReport("FIN_PERU_GL_12_AutoReversing_Journal_Batches", "Navigate to Url", "", URL,
						"Browser must navigate to Url", "Browser navigated to Url", "Passed", "", true);
			} else {
				rpt.generateReport("FIN_PERU_GL_12_AutoReversing_Journal_Batches", "Navigate to Url", "", URL,
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
			rpt.generateReport("FIN_PERU_GL_12_AutoReversing_Journal_Batches", "Login to Application", "",
					"Url: " + URL + "\nUsername: " + hashmap.get("UserName_" + strModule),
					"Application must be logged in", "Logged into application", "Passed", "", true);
		}

		exl = new ExcelOperations("Finance\\com\\databanks\\GL_TestData.xlsx");
		String sheetName = "GL12";

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
			rpt.enterStepHeader("Navigate to General Accounting -> Journals");

			if (cmnLib.clickOnWebElement(homepage.NavigatorIcon) && cmnLib.clickOnWebElement(homepage.Journals)) {

				Thread.sleep(1000);
				rpt.generateReport("", "Click on Navigator", "", "", "Navigator must be clicked",
						"Clicked on Navigator", "Passed", "", false);
				rpt.generateReport("", "Click on Journals link", "", "", "Journals link must be clicked",
						"Clicked on Journals link", "Passed", "", true);
			} else {
				rpt.generateReport("", "Navigate to Journals page", "Click Navigator --> Journals", "",
						"Application must navigate to Journals page", "Journals link not clicked", "Failed", "", true);
				Assert.fail("Failed to click Journals link");
			}

			AutoReversing autoReversing = new AutoReversing();

			TimeUnit.SECONDS.sleep(5);
			rpt.enterStepHeader("Navigate to Run AutoReserve");

			if (cmnLib.clickOnWebElement(autoReversing.TaskPane)
					&& cmnLib.clickOnWebElement(autoReversing.RunAutoreserve)) {

				rpt.generateReport("", "Click on Task Pane", "", "", "Task Pane must be clicked",
						"Clicked on Task Pane", "Passed", "", false);
				rpt.generateReport("", "Click on Run Autoreserve link", "", "", "Run Autoreserve link must be clicked",
						"Clicked on Run Autoreserve link", "Passed", "", true);
			} else {
				rpt.generateReport("", "Click on Run Autoreserve link in Task Pane", "", "",
						"Run Autoreserve link must be clicked", "Not clicked on Run Autoreserve link", "Failed", "",
						true);
				Assert.fail("Failed to click Run Autoreserve link");
			}
			
			//Enter the Parameter Details For Basic Options

			rpt.enterStepHeader("Enter the Parameter Details For Basic Options");
			TimeUnit.SECONDS.sleep(3);
			
			//Enter Data Access Set
			
			if(cmnLib.selectDropdownBy(autoReversing.DataAccessSet, exl.read(sheetName, dataRow, "DataAccessSet"), DropDownSelectBy.VisibleText) == false) {
				rpt.generateReport("", "Select Data Access Set", "", exl.read(sheetName, dataRow, "DataAccessSet"), "Data Access Set should be selected from Dropdown", "Data Access Set is not selected from the dropdown", "Failed", "", true);
				Assert.fail("Unable to select from Dropdown");
			}
			
			//Enter Ledger
			
			if(cmnLib.selectDropdownBy(autoReversing.Ledger, exl.read(sheetName, dataRow, "Ledger"), DropDownSelectBy.VisibleText) == false) {
				rpt.generateReport("", "Select Ledger", "", exl.read(sheetName, dataRow, "Ledger"), "Ledger should be selected from Dropdown", "Ledger is not selected from the dropdown", "Failed", "", true);
				Assert.fail("Unable to select from Dropdown");
			}
			
			//Enter Reversal Period
			
			if(cmnLib.selectDropdownBy(autoReversing.ReversalPeriod, exl.read(sheetName, dataRow, "ReversalPeriod"), DropDownSelectBy.VisibleText) == false) {
				rpt.generateReport("", "Select ReversalPeriod", "", exl.read(sheetName, dataRow, "ReversalPeriod"), "ReversalPeriod should be selected from Dropdown", "Reversal Period is not selected from the dropdown", "Failed", "", true);
				Assert.fail("Unable to select from Dropdown");
			}

			//Click on Submit Button
			
			
			if(cmnLib.clickOnWebElement(autoReversing.SubmitBtn) == true)

			{
				rpt.generateReport("", "Click on Submit Button", "", "", "Submit Button should be clicked", "Submit Button Is Clicked", "Passed", "", true );
			  
			}

			else
			{
				//FAIL
				Assert.fail("Submit Button is not clicked");
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
		     
		     //Click on OK Button
		     
		     if(cmnLib.clickOnWebElement(autoReversing.OkBtn) == true)

				{
					rpt.generateReport("", "Click on Ok Button", "", "", "Ok Button should be clicked", "Ok Button Is Clicked", "Passed", "", true );
				  
				}

				else
				{
					//FAIL
					Assert.fail("Ok Button is not clicked");
				}

		}
	}
}
