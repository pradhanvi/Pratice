package com.testcases.GL;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.commons.TestBase;

import finance.pagefactory.HomePage_FIN;
import finance.pagefactory.LoginPage_FIN;
import finance.pagefactory.ManageJournals;
import report.oracle.ofs.ReportGeneration;
import xlsx.databank.ofs.ExcelOperations;

public class FIN_PERU_GL_10_Post_Journal_to_Future_or_Closed_Period extends TestBase {

	String strModule = "FIN";

	@Test
	public void FIN_PERU_GL_10_Post_Journal_to_Future_or_Closed_Period_TC() throws Throwable {

		boolean login = false;

		rpt = new ReportGeneration("FIN_PERU_GL_10", "Post_Journal_to_Future_or_Closed_Period");

		HomePage_FIN homepage = null;
		if (!(new HomePage_FIN().getUserNameFromHomePage() != null && new HomePage_FIN().getUserNameFromHomePage()
				.equalsIgnoreCase(hashmap.get("UserName_" + strModule)))) {

			// Launch Browser
			launchBrowser(strModule);

			LoginPage_FIN loginPage = new LoginPage_FIN();
			rpt.enterStepHeader("Navigate to Url");
			if (driver.getTitle().contains("Sign In")) {
				rpt.generateReport("FIN_PERU_GL_10_Post_Journal_to_Future_or_Closed_Period", "Navigate to Url", "", URL,
						"Browser must navigate to Url", "Browser navigated to Url", "Passed", "", true);
			} else {
				rpt.generateReport("FIN_PERU_GL_10_Post_Journal_to_Future_or_Closed_Period", "Navigate to Url", "", URL,
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
			rpt.generateReport("FIN_PERU_GL_10_Post_Journal_to_Future_or_Closed_Period", "Login to Application", "",
					"Url: " + URL + "\nUsername: " + hashmap.get("UserName_" + strModule),
					"Application must be logged in", "Logged into application", "Passed", "", true);
		}

		exl = new ExcelOperations("Finance\\com\\databanks\\GL_TestData.xlsx");
		String sheetName = "GL10";

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
			
			ManageJournals manageJournals = new ManageJournals();
			
			TimeUnit.SECONDS.sleep(5);
			rpt.enterStepHeader("Navigate to Manage Journal");

			if (cmnLib.clickOnWebElement(manageJournals.TaskPane)
					&& cmnLib.clickOnWebElement(manageJournals.ManageJournals)) {

				rpt.generateReport("", "Click on Task Pane", "", "", "Task Pane must be clicked",
						"Clicked on Task Pane", "Passed", "", false);
				rpt.generateReport("", "Click on Manage Journals link", "", "", "Manage Journals link must be clicked",
						"Clicked on Manage Journals link", "Passed", "", true);
			} else {
				rpt.generateReport("", "Click on Manage Journals link in Task Pane", "", "",
						"Manage Journals link link must be clicked", "Not clicked on Manage Journals link", "Failed", "",
						true);
				Assert.fail("Failed to click Manage Journals link");
			}
			
			//Click on Create Button
			
			if(cmnLib.clickOnWebElement(manageJournals.CreateJournal) == true)

			{
				rpt.generateReport("", "Click on Create Journal ", "", "", "Create Journal should be clicked", "Create Journal Is Clicked", "Passed", "", true );
			  
			}

			else
			{
				//FAIL
				Assert.fail("Create Journal is not clicked");
			}
			
			//Enter the Journal Batch Details
			
			rpt.enterStepHeader("Enter the Journal Batch Details");
			TimeUnit.SECONDS.sleep(5);
			
			//Enter the Journal Batch name
			
			
			if(cmnLib.enterDataInTextBox(manageJournals.JournalBatch1, exl.read(sheetName, dataRow, "JournalBatch"), true) == false) {
				rpt.generateReport("", "Enter Journal Batch", "", exl.read(sheetName, dataRow, "JournalBatch"), "Journal Batch should be entered", "Journal Batch is not entered", "Failed", "", true);
				Assert.fail("Unable to Enter value into TextBox");
			}
			
			//Enter the Description
			
			if(cmnLib.enterDataInTextBox(manageJournals.Description, exl.read(sheetName, dataRow, "Description"), true) == false) {
				rpt.generateReport("", "Enter Description", "", exl.read(sheetName, dataRow, "Description"), "Description should be entered", "Description is not entered", "Failed", "", true);
				Assert.fail("Unable to Enter value into TextBox");
			}
			
	
			//Enter Journal
			
			if(cmnLib.enterDataInTextBox(manageJournals.Journal1, exl.read(sheetName, dataRow, "Journal"), true) == false) {
				rpt.generateReport("", "Enter Journal", "", exl.read(sheetName, dataRow, "Journal"), "Journal should be entered", "Journal is not entered", "Failed", "", true);
				Assert.fail("Unable to Enter value into TextBox");
			}
			
			//Enter the Journal Description
			
			if(cmnLib.enterDataInTextBox(manageJournals.JournalDescription, exl.read(sheetName, dataRow, "JournalDescription"), true) == false) 
			{
				rpt.generateReport("", "Enter Journal Description", "", exl.read(sheetName, dataRow, "JournalDescription"), "Journal Description should be entered", "Journal Description is not entered", "Failed", "", true);
				Assert.fail("Unable to Enter value into TextBox");
			}
			else 
			{
				rpt.generateReport("", "Enter the Journal Batch Details", "", "Journal Batch Details entered are:  \n JournalBatch: "+exl.read(sheetName, dataRow, "JournalBatch")+", Description: "+exl.read(sheetName, dataRow, "Description")+", Journal: "+exl.read(sheetName, dataRow, "Journal") +", JournalDescription: "+exl.read(sheetName, dataRow, "JournalDescription"),"All Valid details should be entered", "Details are entered", "Passed", "", true);
			}
			
			
			//Enter the Category
			
			if(cmnLib.enterDataInTextBox(manageJournals.CategoryName, exl.read(sheetName, dataRow, "CategoryName"), true) == false) {
				rpt.generateReport("", "Enter CategoryName", "", exl.read(sheetName, dataRow, "CategoryName"), "CategoryName should be entered", "Journal is not entered", "Failed", "", true);
				Assert.fail("Unable to Enter value into TextBox");
			}
			
			//Click on Account Icon
			
			if(cmnLib.clickOnWebElement(manageJournals.AccountIcon) == false) 
			{
				rpt.generateReport("", "Click On Account Icon", "", "", "Account Icon should be clicked", "Account Icon is not clicked", "Failed", "", true);
				Assert.fail("Next Button is not Clicked");
			}
			else 
			{
				rpt.generateReport("", "Click On Account Icon", "", "", "Account Icon should be clicked", "Account Icon is clicked", "Passed", "", false);
			}
		
            
            //Enter the Journal Line Details
			
			rpt.enterStepHeader("Enter the Journal Batch Details");
			TimeUnit.SECONDS.sleep(5);
			
			//Enter the legal Entity
			
			if(!manageJournals.selectLegalEntity(exl.read(sheetName, dataRow, "LegalEntity"))) {
				rpt.generateReport("", "Enter Legal Entity Type ", "", exl.read(sheetName, dataRow, "LegalEntity"), "Legal Entity  should be entered", "Legal Entity is not entered", "Failed", "", true);
				
				Assert.fail("Unable to Enter value into TextBox");
			}
			
			//Enter the Business Area
			
			if(!manageJournals.selectBusinessArea(exl.read(sheetName, dataRow, "BusinessArea"))) {
				rpt.generateReport("", "Enter Business Area Type ", "", exl.read(sheetName, dataRow, "BusinessArea"), "Business Area should be entered", "Business Area is not entered", "Failed", "", true);
				
				Assert.fail("Unable to Enter value into TextBox");
			}
			
			//Enter the Cost Center
			
			if(!manageJournals.selectCostCenter(exl.read(sheetName, dataRow, "CostCenter"))) {
				rpt.generateReport("", "Enter Cost Center Type ", "", exl.read(sheetName, dataRow, "CostCenter"), "Cost Center should be entered", "Cost Center is not entered", "Failed", "", true);
				
				Assert.fail("Unable to Enter value into TextBox");
			}
			
			//Enter the Account
			
			if(!manageJournals.selectAccount(exl.read(sheetName, dataRow, "Account"))) {
				rpt.generateReport("", "Enter Account Type ", "", exl.read(sheetName, dataRow, "Account"), "Account should be entered", "Account is not entered", "Failed", "", true);
				
				Assert.fail("Unable to Enter value into TextBox");
			}
			
			//Enter the Intercompany
			
			if(!manageJournals.selectInterCompany(exl.read(sheetName, dataRow, "InterCompany"))) {
				rpt.generateReport("", "Enter Account Type ", "", exl.read(sheetName, dataRow, "Account"), "Account should be entered", "Account is not entered", "Failed", "", true);
				
				Assert.fail("Unable to Enter value into TextBox");
			}
			
			//Enter Fiscal
			
			if(!manageJournals.selectFiscal(exl.read(sheetName, dataRow, "Fiscal"))) {
				rpt.generateReport("", "Enter Fiscal ", "", exl.read(sheetName, dataRow, "Fiscal"), "Fiscal should be entered", "Fiscal is not entered", "Failed", "", true);
				
				Assert.fail("Unable to Enter value into TextBox");
			}
			
			//Enter Brand
			
			if(!manageJournals.selectBrand(exl.read(sheetName, dataRow, "Brand"))) {
				rpt.generateReport("", "Enter Brand ", "", exl.read(sheetName, dataRow, "Brand"), "Brand should be entered", "Brand is not entered", "Failed", "", true);
				
				Assert.fail("Unable to Enter value into TextBox");
			}
			
			//Enter Future
			
			if(!manageJournals.selectFuture(exl.read(sheetName, dataRow, "Brand"))) {
				rpt.generateReport("", "Enter Brand ", "", exl.read(sheetName, dataRow, "Brand"), "Brand should be entered", "Brand is not entered", "Failed", "", true);
				
				Assert.fail("Unable to Enter value into TextBox");
			}
			
			//Click Ok Button
			
			if(cmnLib.clickOnWebElement(manageJournals.Ok) == true)

			{
				rpt.generateReport("", "Click on Ok ", "", "", "Ok should be clicked", "Ok Is Clicked", "Passed", "", true );
			  
			}

			else
			{
				//FAIL
				Assert.fail("Ok is not clicked");
			}
			
			
			
		}
	}
}
