package com.testcases.GL;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.commons.TestBase;
import com.commons.Common_Library.DropDownSelectBy;

import finance.pagefactory.HomePage_FIN;
import finance.pagefactory.Journals;
import finance.pagefactory.LoginPage_FIN;
import report.oracle.ofs.ReportGeneration;
import xlsx.databank.ofs.ExcelOperations;

public class FIN_PERU_GL_22_Opening_the_GL_Period extends TestBase {

	String strModule = "FIN";

	@Test
	public void FIN_PERU_GL_22_Opening_the_GL_Period_TC() throws Throwable {

		boolean login = false;

		rpt = new ReportGeneration("FIN_PERU_GL_22", "Opening_the_GL_period");

		HomePage_FIN homepage = null;
		if (!(new HomePage_FIN().getUserNameFromHomePage() != null && new HomePage_FIN().getUserNameFromHomePage()
				.equalsIgnoreCase(hashmap.get("UserName_" + strModule)))) {

			// Launch Browser
			launchBrowser(strModule);

			LoginPage_FIN loginPage = new LoginPage_FIN();
			rpt.enterStepHeader("Navigate to Url");
			if (driver.getTitle().contains("Sign In")) {
				rpt.generateReport("FIN_PERU_GL_22_Opening_the_GL_Period", "Navigate to Url", "", URL,
						"Browser must navigate to Url", "Browser navigated to Url", "Passed", "", true);
			} else {
				rpt.generateReport("FIN_PERU_GL_22_Opening_the_GL_Period", "Navigate to Url", "", URL,
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
			rpt.generateReport("FIN_PERU_GL_22_Opening_the_GL_Period", "Login to Application", "",
					"Url: " + URL + "\nUsername: " + hashmap.get("UserName_" + strModule),
					"Application must be logged in", "Logged into application", "Passed", "", true);
		}

		exl = new ExcelOperations("Finance\\com\\databanks\\GL_TestData.xlsx");
		String sheetName = "GL22";

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
				rpt.generateReport("", "Navigate to Journals page", "Click Navigator -->Journals", "",
						"Application must navigate to Journals page", "Journals link not clicked", "Failed", "", true);
				Assert.fail("Failed to click Journals link");
			}
			
			TimeUnit.SECONDS.sleep(3);
			
			Journals journals=new Journals();
			
			//Click on Period Close
			
			if(cmnLib.clickOnWebElement(journals.PeriodCloseLink) == true) 
			{
				rpt.generateReport("", "Click On Period Close Icon", "", "", "Period Close Icon should be clicked", "Period Close Icon is  clicked", "Passed", "", true);
				
			}
			else 
			{
				rpt.generateReport("", "Click On Period Close Icon", "", "", "Period Close Icon should be clicked", "Period Close Icon is not clicked", "Failed", "", false);
				Assert.fail("PeriodClose Link is not Clicked");
			}
			
			
			TimeUnit.SECONDS.sleep(3);
			
			//Click on Open Period Link
			
			if(cmnLib.clickOnWebElement(journals.OpenPeriodLink) == true) 
			{
				rpt.generateReport("", "Click On Open Period Link", "", "", "Open Period Link should be clicked", "Open Period Link is clicked", "Passed", "", true);
				
			}
			else 
			{
				rpt.generateReport("", "Click On Open Period Link", "", "", "Open Period Link should be clicked", "Open Period Link is clicked", "Failed", "", false);
				Assert.fail("Open Period Link is not Clicked");
			}
			
			TimeUnit.SECONDS.sleep(4);
			
			//Click on Action Dropdown
			
			if(cmnLib.clickOnWebElement(journals.ActionDropdown) == true) 
			{
				rpt.generateReport("", "Click On Action Dropdown", "", "", "Action Dropdown should be clicked", "Action Dropdown is clicked", "Passed", "", true);
				
			}
			else 
			{
				rpt.generateReport("", "Click On Action Dropdown", "", "", "Action Dropdown should be clicked", "Action Dropdown is not clicked", "Failed", "", false);
				Assert.fail("Action Dropdown is not Clicked");
			}
			
			TimeUnit.SECONDS.sleep(5);
			
			//Select Open Target Period under Action Dropdown
			
			if(cmnLib.clickOnWebElement(journals.OpenTargetPeriod) == true) 
			{
				rpt.generateReport("", "Select Open Target Period under Action Dropdown", "", "", "Open Target Period under Action Dropdown should be selected", "Open Target Period under Action Dropdown is  selected", "Passed", "", true);
				
			}
			else 
			{
				rpt.generateReport("", "Select Open Target Period under Action Dropdown", "", "", "Open Target Period under Action Dropdown should be selected", "Open Target Period under Action Dropdown is not selected", "Failed", "", false);
				Assert.fail("Open Target Period is not Clicked");
				
			}
			
			//Select Open TargeT Period Month from DropDown
			
			
			if(cmnLib.selectDropdownBy(journals.TargetPeriod, exl.read(sheetName, dataRow, "TargetPeriod"), DropDownSelectBy.VisibleText) == false) {
			rpt.generateReport("", "Select TargeT Period", "", exl.read(sheetName, dataRow, "TargetPeriod"), "TargeT Period value should be selected from Dropdown", "TargeT Period value is not selected from the dropdown", "Failed", "", true);
			Assert.fail("Unable to select from Dropdown");
			}
			
			//Click on Open Button
			
			if(cmnLib.clickOnWebElement(journals.OpenButton) == true) 
			{
				rpt.generateReport("", "Click on Open Button", "", "", "Open Button should be clicked", "Open Button is clicked", "Passed", "", true);
				
			}
			else 
			{
				rpt.generateReport("", "Click on Open Button", "", "", "Open Button should be clicked", "Open Button is not clicked", "Failed", "", false);
				Assert.fail("Open Button is not Clicked");
			}
			
			//Validate the Confirmation Message
			
			 rpt.enterStepHeader("Validation of confirmation message");
		     
		     
		     TimeUnit.SECONDS.sleep(2);
		     
		     WebElement confirmationmsg = driver.findElement(By.xpath("//div[text()='Confirmation']"));
		     String confirmmsg = confirmationmsg.getText();
		     
		     TimeUnit.SECONDS.sleep(2);
		     
		     if(confirmmsg.contains("Confirmation")) {
		     rpt.generateReport("", "Check if the Confirmation message Window Opened ", "", "", "Confirmation message Window must be Opened",
		        "Confirmation message Window Opened", "Passed", "", true);
		     } else {
		      rpt.generateReport("", "Check if the Confirmation message Window Opened", "", "",
		        "Confirmation message Window must be Opened",
		        "Confirmation message Window is not Opened", "Failed", "", true);
		      Assert.fail("Failed to open Confirmation message Window ");
		           
		     }
		     
		     //Click on Ok Button
		     
		     if(cmnLib.clickOnWebElement(journals.OkBtn) == true) 
				{
					rpt.generateReport("", "Click on Ok Button", "", "", "Ok Button should be clicked", "Ok Button is clicked", "Passed", "", true);
					
				}
				else 
				{
					rpt.generateReport("", "Click on Ok Button", "", "", "Ok Button should be clicked", "Ok Button is not clicked", "Failed", "", false);
					Assert.fail("Ok Button is not Clicked");
				}
		     
		     TimeUnit.SECONDS.sleep(6);
		     //Validate whether Period is Open
		     
            rpt.enterStepHeader("Validate whether Period is Open");
		     
		     
		     TimeUnit.SECONDS.sleep(2);
		     
		     WebElement confirmationmsg1 = driver.findElement(By.xpath("//td[contains(text(),'Aug-19')]"));
		     String confirmmsg1 = confirmationmsg1.getText();
		     
		     TimeUnit.SECONDS.sleep(2);
		     
		     if(confirmmsg1.contains("Aug")) {
		     rpt.generateReport("", "Check if the Period is Opened ", "", "", "Period must be Opened",
		        "Period is  Opened", "Passed", "", true);
		     } else {
		      rpt.generateReport("", "Check if the Period is Opened", "", "",
		        "Period must be Opened",
		        "Period is not  Opened", "Failed", "", true);
		      Assert.fail("Failed to open Period");
		           
		     }
		}
	}
}