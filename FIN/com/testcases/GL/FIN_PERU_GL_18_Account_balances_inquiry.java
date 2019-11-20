package com.testcases.GL;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.commons.TestBase;

import finance.pagefactory.GeneralAccountingDashboard;
import finance.pagefactory.HomePage_FIN;
import finance.pagefactory.LoginPage_FIN;
import report.oracle.ofs.ReportGeneration;
import xlsx.databank.ofs.ExcelOperations;

public class FIN_PERU_GL_18_Account_balances_inquiry extends TestBase {

	String strModule = "FIN";

	@Test
	public void FIN_PERU_GL_18_Account_balances_inquiry_TC() throws Throwable {

		boolean login = false;

		rpt = new ReportGeneration("FIN_PERU_GL_18", "Account_balances_inquiry");

		HomePage_FIN homepage = null;
		if (!(new HomePage_FIN().getUserNameFromHomePage() != null && new HomePage_FIN().getUserNameFromHomePage()
				.equalsIgnoreCase(hashmap.get("UserName_" + strModule)))) {

			// Launch Browser
			launchBrowser(strModule);

			LoginPage_FIN loginPage = new LoginPage_FIN();
			rpt.enterStepHeader("Navigate to Url");
			if (driver.getTitle().contains("Sign In")) {
				rpt.generateReport("FIN_PERU_GL_18_Account_balances_inquiry", "Navigate to Url", "", URL,
						"Browser must navigate to Url", "Browser navigated to Url", "Passed", "", true);
			} else {
				rpt.generateReport("FIN_PERU_GL_18_Account_balances_inquiry", "Navigate to Url", "", URL,
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
			rpt.generateReport("FIN_PERU_GL_18_Account_balances_inquiry", "Login to Application", "",
					"Url: " + URL + "\nUsername: " + hashmap.get("UserName_" + strModule),
					"Application must be logged in", "Logged into application", "Passed", "", true);
		}

		exl = new ExcelOperations("Finance\\com\\databanks\\GL_TestData.xlsx");
		String sheetName = "GL18";

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
			rpt.enterStepHeader("Navigate to General Accounting -> General Accounting Dashboard");

			if (cmnLib.clickOnWebElement(homepage.NavigatorIcon) && cmnLib.clickOnWebElement(homepage.GeneralAccountingDashboard)) {

				Thread.sleep(1000);
				rpt.generateReport("", "Click on Navigator", "", "", "Navigator must be clicked",
						"Clicked on Navigator", "Passed", "", false);
				rpt.generateReport("", "Click on General Accounting Dashboard link", "", "", "General Accounting Dashboard link must be clicked",
						"Clicked on General Accounting Dashboard link", "Passed", "", true);
			} else {
				rpt.generateReport("", "Navigate to General Accounting Dashboard page", "Click Navigator --> Journals", "",
						"Application must navigate to General Accounting Dashboard page", "General Accounting Dashboard link not clicked", "Failed", "", true);
				Assert.fail("Failed to click General Accounting Dashboard link");
			}
			
			
			TimeUnit.SECONDS.sleep(3);
			
			GeneralAccountingDashboard generalAccountingDashboard=new GeneralAccountingDashboard();
			
			//Click on Task Icon
			

			if(cmnLib.clickOnWebElement(generalAccountingDashboard.TaskIcon)==true) {
				rpt.generateReport("", "Click on Task Icon", "",  "", "Task Icon must be clicked",
						"Task Icon is clicked", "Passed", "", true);
				
			} else {
				rpt.generateReport("", "Click on Task Icon", "",  "", "Task Icon must be clicked",
						"Task Icon is not clicked", "Passed", "", false);
				Assert.fail("Failed to click on Task Icon");
			}
			
			TimeUnit.SECONDS.sleep(2);
			
			//Click on Inquire and Analyze Balances Link
			
			if(cmnLib.clickOnWebElement(generalAccountingDashboard.InquireandAnalyzeBalances)==true) {
				rpt.generateReport("", "Click on Inquire and Analyze Balances Link", "",  "", "Inquire and Analyze Balances Link must be clicked",
						"Inquire and Analyze Balances Link is clicked", "Passed", "", true);
				
			} else {
				rpt.generateReport("", "Click on Inquire and Analyze Balances Link", "",  "", "Inquire and Analyze Balances Link must be clicked",
						"Inquire and Analyze Balances Link is not clicked", "Passed", "", false);
				Assert.fail("Failed to click on Inquire and Analyze Balances Link");
			}
			
			TimeUnit.SECONDS.sleep(2);
			
			//Enter Page Level Dimensions Value  in Inquire And analyze Page
			
			rpt.enterStepHeader("Enter Page Level Dimensions Value  in Inquire And analyze Page");
			TimeUnit.SECONDS.sleep(3);
			
			//Enter Legal Entity
			
			if(cmnLib.enterDataInTextBox(generalAccountingDashboard.LegalEntity, exl.read(sheetName, dataRow, "LegalEntity"), true) == false) {
				rpt.generateReport("", "Enter Legal Entity", "", exl.read(sheetName, dataRow, "LegalEntity"), "Legal Entity should be entered", "Legal Entity is not entered", "Failed", "", true);
				Assert.fail("Unable to Enter value into TextBox");
			}
			
			TimeUnit.SECONDS.sleep(5);
			//Enter Business Area
			
			if(cmnLib.enterDataInTextBox(generalAccountingDashboard.BUSINESSAREA, exl.read(sheetName, dataRow, "BUSINESSAREA"), true) == false) {
				rpt.generateReport("", "Enter Business Area", "", exl.read(sheetName, dataRow, "BUSINESSAREA"), "Business Area should be entered", "Business Area is not entered", "Failed", "", true);
				Assert.fail("Unable to Enter value into TextBox");
			}
			else 
			{
				rpt.generateReport("", "Enter Page Level Dimensions Value  in Inquire And analyze Page", "", "Page Level Dimensions Value entered are:  \n LegalEntity: "+exl.read(sheetName, dataRow, "LegalEntity")+", BUSINESSAREA: "+exl.read(sheetName, dataRow, "BUSINESSAREA"), "All Valid details should be entered", "Details are entered", "Passed", "", true);
			}
			
			TimeUnit.SECONDS.sleep(3);
			
			//Click on Done Button
			
			if(cmnLib.clickOnWebElement(generalAccountingDashboard.DoneBtn)==true) {
				rpt.generateReport("", "Click on Done Button", "",  "", "Done Button must be clicked",
						"Done Button is clicked", "Passed", "", true);
				
			} else {
				rpt.generateReport("", "Click on Done Button", "",  "", "Done Button must be clicked",
						"Done Button is not clicked", "Passed", "", false);
				Assert.fail("Failed to click on Done Button");
			}
			
			
			
		}
	}
}