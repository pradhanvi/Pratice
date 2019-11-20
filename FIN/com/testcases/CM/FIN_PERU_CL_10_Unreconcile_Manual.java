package com.testcases.CM;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.commons.TestBase;

import finance.pagefactory.BankStatementsAndReconciliation;
import finance.pagefactory.HomePage_FIN;
import finance.pagefactory.LoginPage_FIN;
import report.oracle.ofs.ReportGeneration;
import xlsx.databank.ofs.ExcelOperations;

/**
Script Name			: FIN_PERU_CL_10_Unreconcile_Manual
Script Description	: Unreconcile (Manual)
Track/Module		: FIN
Sub Track			: 
Created By			: Pradhanvi T R
Creation Date		: 
Modified By 		: 
Modification Date	: 
Instance Name & URL : https://edyg-dev6.login.us2.oraclecloud.com
User ID/ Password	: AUTO.FIN_USER/********
Responsibility		: 
Pre-Requisites		: Reconciled Statement ID required
Comments (if any)	:
 **/

public class FIN_PERU_CL_10_Unreconcile_Manual extends TestBase{
	String strModule = "FIN";

	@Test
	public void FIN_PERU_CL_10_Unreconcile_Manual_TC() throws Throwable { 
		rpt = new ReportGeneration("FIN_PERU_CL_10_Unreconcile_Manual", "");

		String strDataSheetName = "CL_10";

		//Verify If Same UserExists as of Previous TestCase
		HomePage_FIN homePage_FIN = null;
		if(! (new HomePage_FIN().getUserNameFromHomePage() != null && new HomePage_FIN().getUserNameFromHomePage().equalsIgnoreCase(hashmap.get("UserName_"+strModule)))) {

			launchBrowser(strModule);
			//Launch & Login
			LoginPage_FIN loginPage_FIN = PageFactory.initElements(driver, LoginPage_FIN.class);
			homePage_FIN = loginPage_FIN.login(hashmap.get("UserName_"+strModule), hashmap.get("Password_"+strModule));
		}

		//Validate HomePage Icon
		if(cmnLib.waitForElementToBeVisible(homePage_FIN.HomePage_HomeIcon))
		{
			//PASS
			rpt.enterStepHeader("Navigate to URL");
			rpt.generateReport("FIN_PERU_CL_10_Unreconcile_Manual", "Enter URL", "", "Password: "+hashmap.get("URL_"+strModule), "URL should be entered", "URL is entered", "Info", "", false );

			rpt.enterStepHeader("Login To Application");
			rpt.generateReport("", "Enter User Name", "", "UserName: "+hashmap.get("UserName_"+strModule), "UserName should be entered", "UserName is entered", "Info", "", false );
			rpt.generateReport("", "Enter Password", "", "Password: "+hashmap.get("Password_"+strModule), "Password should be entered", "Password is entered", "Info", "", false );
			rpt.generateReport("", "Validate Login to Application", "", "", "Login Should be successful", "Login Is Successful", "Passed", "", true );
		}else
		{
			//FAIL
			rpt.generateReport("FIN_PERU_CL_10_Unreconcile_Manual", "Login to Appication", "", "UserName: "+exl.read("LoginDetails", 1, "UserName"), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
			Assert.fail("Login Un-Successful");
		}

		rpt.enterStepHeader("Navigation to Bank Reconcilation");

		//Always Load TestData Sheet Excel After Login as UserName & Password exists in other Excel which is loaded in TestBase
		exl = new ExcelOperations("FIN\\com\\dataBanks\\FIN_CM_TestData.xlsx");

		// Script will execute for all the Rows present in the Data Sheet.
		System.out.println("No Of DataRows: "+exl.getRowCount(strDataSheetName));

		for (int dataRow = 1; dataRow < exl.getRowCount(strDataSheetName); dataRow++) {

			//Navigation
			if(homePage_FIN.clickOnWelcomePage_HomeIcon())
			{
				homePage_FIN = PageFactory.initElements(driver, HomePage_FIN.class);
			}else
			{
				rpt.generateReport("", "Click On HomePage Icon", "", "", "HomePage Icon should be clicked", "HomePage Icon is not clicked", "Failed", "", true);
			}

			cmnLib.waitForPageLoaded();
			
			//Verify Presence of Navigator Icon
			if(!cmnLib.waitForElementToBeVisible(homePage_FIN.NavigatorIcon))
			{
				//FAIL
				rpt.generateReport("", "Validate HomePage", "", "", "Validation Should be successful", "Validation Is Not Successful", "Failed", "", true );
				Assert.fail("Login Un-Successful");
			}

			//Click on Navigator Icon
			homePage_FIN.clickOnNavigationIcon();
			cmnLib.waitForPageLoaded();
			
			//Click on Billing from Navigator Pane
			BankStatementsAndReconciliation bankstmtreconc = homePage_FIN.clickOnBankStatementAndReconciliation();
			cmnLib.waitForPageLoaded();
			
			//Verify Tasks if visible and enabled
			if(cmnLib.waitForElementToBeClickable(bankstmtreconc.TasksPane)) {
				rpt.generateReport("", "Click on Bank Statement And Reconciliation", "", "", "Bank Statement And Reconciliation Link from Navigator should be clicked", "Bank Statement And Reconciliation Link is clicked from the Navigator", "Passed", "", true);
			}else {
				rpt.generateReport("", "Click on Billing Link", "", "", "Bank Statement And Reconciliation Link from Navigator should be clicked", "Bank Statement And Reconciliation Link is not clicked from the Navigator", "Failed", "", true);
				Assert.fail("Bank Statement And Reconciliation Link From Navigator is not clicked");
			}
			cmnLib.waitForPageLoaded();
			
			//Click on Tasks in Bank Statement And Reconciliation Page
			if(cmnLib.clickOnWebElement(bankstmtreconc.TasksPane)) {
				rpt.generateReport("", "Click Tasks in Bank Statement And Reconciliation Page", "", "", "Tasks should be clicked", "Tasks is clicked", "Passed", "", true);
			}else
			{
				rpt.generateReport("", "Click Tasks in Bank Statement And Reconciliation Page", "", "", "Tasks should be clicked", "Tasks is not clicked", "Failed", "", true);
				Assert.fail("Tasks is not clicked in Bank Statement And Reconciliation Page");
			}
			cmnLib.waitForPageLoaded();
			
			rpt.enterStepHeader("Submit Autoreconciliation");
			if(cmnLib.clickOnWebElement(bankstmtreconc.ManualReconciliation)) {
				rpt.generateReport("", "Click on Manual Reconciliation link in Tasks", "", "", "Manual Reconciliation Link should be clicked", "Manual Reconciliation link is clicked", "Passed", "", true);
			}else {
				rpt.generateReport("", "Click on Manual Reconciliation link in Tasks", "", "", "Manual Reconciliation Link should be clicked", "Manual Reconciliation link is not clicked", "Failed", "", true);
				Assert.fail("Manual Reconciliation link is not clicked");
			}
			cmnLib.waitForPageLoaded();
			
			if(cmnLib.waitForElementToBeVisible(bankstmtreconc.BankAccount)) {
				rpt.generateReport("", "Verify Manual Reconciliation page", "", "", "Manual Reconciliation page should be opened", "Manual Reconciliation page is opened", "Passed", "", true);
			}else {
				rpt.generateReport("", "Verify Manual Reconciliation page", "", "", "Manual Reconciliation page should be opened", "Manual Reconciliation page is not opened", "Failed", "", true);
				Assert.fail("Manual Reconciliation page is not opened");
			}
			cmnLib.clickOnWebElement(bankstmtreconc.ReconciledLink);
			TimeUnit.SECONDS.sleep(2);
			cmnLib.enterDataInTextBox(bankstmtreconc.BankAccount, exl.read(strDataSheetName, dataRow, "BankAccount"), true);
			cmnLib.enterDataInTextBox(bankstmtreconc.StatementID, exl.read(strDataSheetName, dataRow, "StatementID"), true);
			cmnLib.clickOnWebElement(bankstmtreconc.SearchBtn);
			TimeUnit.SECONDS.sleep(10);
			if(cmnLib.waitForElementToBeVisible(bankstmtreconc.NoResultFound, 5))
			{
				rpt.generateReport("", "Search Results", "", "", "Search results", "No Result Found", "Failed", "", true);
				Assert.fail("No Result Found");
			}
			
			if(cmnLib.clickOnWebElement(bankstmtreconc.CheckBox_Unreconciled))
				System.out.println("");
			if(cmnLib.waitForElementToBeVisible(bankstmtreconc.WarningDailog, 5)) 
			{
				rpt.generateReport("", "Warning Message", "", "", "Warning dialog should appear", "Warning dialog appeared", "Passed", "", true);
				cmnLib.clickOnWebElement(bankstmtreconc.OKBtnConfirmation);
			}
			
			if(cmnLib.clickOnWebElement(bankstmtreconc.Unreconcile))
			{
				rpt.generateReport("", "Unreconcile button", "", "", "Click on Unreconcile button", "Clicked on Unreconcile button", "Passed", "", true);
			}else {
				rpt.generateReport("", "Unreconcile button", "", "", "Click on Unreconcile button", "Not Clicked on Unreconcile button", "Passed", "", true);
				Assert.fail("Not Clicked on Unreconcile button");
			}
			cmnLib.clickOnWebElement(bankstmtreconc.SearchBtn);
			if(cmnLib.waitForElementToBeVisible(bankstmtreconc.NoResultFound, 50))
			{
				rpt.generateReport("", "Unreconcile", "", "", "Successfully Unreconciled", "Successfully Unreconciled", "Passed", "", true);
			}else
			{
				rpt.generateReport("", "Unreconcile", "", "", "Successfully Unreconciled", "Unsuccessfull in Unreconciling", "Passed", "", true);
				Assert.fail("Unsuccessfull in Unreconciling");
			}
			
		}
	}


}
