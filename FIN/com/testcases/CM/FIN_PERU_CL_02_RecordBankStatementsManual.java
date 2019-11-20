package com.testcases.CM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.commons.TestBase;
import com.commons.Common_Library.DropDownSelectBy;

import finance.pagefactory.BankStatementsAndReconciliation;
import finance.pagefactory.HomePage_FIN;
import finance.pagefactory.LoginPage_FIN;
import report.oracle.ofs.ReportGeneration;
import xlsx.databank.ofs.ExcelOperations;

/**
Script Name			: FIN_PERU_CL_02_RecordBankStatementsManual
Script Description	: Record Bank Statements Manual
Track/Module		: FIN
Sub Track			: 
Created By			: Pradhanvi T R
Creation Date		: 
Modified By 		: 
Modification Date	: 
Instance Name & URL : https://edyg-dev6.login.us2.oraclecloud.com
User ID/ Password	: AUTO.FIN_USER/********
Responsibility		: 
Pre-Requisites		: StatementID should be unique
Comments (if any)	:
 **/

public class FIN_PERU_CL_02_RecordBankStatementsManual extends TestBase {
	String strModule = "FIN";

	@Test
	public void FIN_PERU_CL_02_RecordBankStatementsManual_TC() throws Throwable { 
		rpt = new ReportGeneration("FIN_PERU_CL_02_RecordBankStatementsManual", "");

		String strDataSheetName = "CL_02";

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
			rpt.generateReport("FIN_PERU_CL_02_RecordBankStatementsManual", "Enter URL", "", "Password: "+hashmap.get("URL_"+strModule), "URL should be entered", "URL is entered", "Info", "", false );

			rpt.enterStepHeader("Login To Application");
			rpt.generateReport("", "Enter User Name", "", "UserName: "+hashmap.get("UserName_"+strModule), "UserName should be entered", "UserName is entered", "Info", "", false );
			rpt.generateReport("", "Enter Password", "", "Password: "+hashmap.get("Password_"+strModule), "Password should be entered", "Password is entered", "Info", "", false );
			rpt.generateReport("", "Validate Login to Application", "", "", "Login Should be successful", "Login Is Successful", "Passed", "", true );
		}else
		{
			//FAIL
			rpt.generateReport("FIN_PERU_CL_02_RecordBankStatementsManual", "Login to Appication", "", "UserName: "+exl.read("LoginDetails", 1, "UserName"), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
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
			
			rpt.enterStepHeader("Create Transactions");
			if(cmnLib.clickOnWebElement(bankstmtreconc.CreateBankStatement)) {
				rpt.generateReport("", "Click on Create Bank Statement link in Tasks", "", "", "Create Bank Statement Link should be clicked", "Create Bank Statement link is clicked", "Passed", "", true);
			}else {
				rpt.generateReport("", "Click on Create Bank Statement link in Tasks", "", "", "Create Bank Statement Link should be clicked", "Create Bank Statement link is not clicked", "Failed", "", true);
				Assert.fail("Create Bank Statement link is not clicked");
			}
			cmnLib.waitForPageLoaded();
			if(cmnLib.waitForElementToBeVisible(bankstmtreconc.BankAccount)) {
				rpt.generateReport("", "Verify Create Bank Statement page", "", "", "Create Bank Statement page should be opened", "Create Bank Statement page is opened", "Passed", "", true);
			}else {
				rpt.generateReport("", "Verify Create Bank Statement page", "", "", "Create Bank Statement page should be opened", "Create Bank Statement page is not opened", "Failed", "", true);
				Assert.fail("Create Bank Statement page is not opened");
			}
			
			
			cmnLib.enterDataInTextBox(bankstmtreconc.BankAccount, exl.read(strDataSheetName, dataRow, "BankAccount"), true);
			cmnLib.enterDataInTextBox(bankstmtreconc.PeriodStartDate, exl.read(strDataSheetName, dataRow, "PeriodStartDate"), true);
			cmnLib.enterDataInTextBox(bankstmtreconc.PeriodEndDate, exl.read(strDataSheetName, dataRow, "PeriodEndDate"), true);
			cmnLib.enterDataInTextBox(bankstmtreconc.StatementID, exl.read(strDataSheetName, dataRow, "StatementID"), true);
			cmnLib.clickOnWebElement(bankstmtreconc.StatementLines);
			cmnLib.waitForElementToBeVisible(bankstmtreconc.AddStatementLine, 20);
			cmnLib.clickOnWebElement(bankstmtreconc.AddStatementLine);
			
			cmnLib.waitForElementToBeVisible(bankstmtreconc.BookingDate, 20);
			cmnLib.enterDataInTextBox(bankstmtreconc.BookingDate, exl.read(strDataSheetName, dataRow, "BookingDate"), true);
			cmnLib.enterDataInTextBox(bankstmtreconc.TransactionCode, exl.read(strDataSheetName, dataRow, "TransactionCodeDebit"), true);
			cmnLib.selectDropdownBy(bankstmtreconc.FlowIndicator, exl.read(strDataSheetName, dataRow, "FlowIndicatorDebit"), DropDownSelectBy.VisibleText);
			cmnLib.enterDataInTextBox(bankstmtreconc.Amount, exl.read(strDataSheetName, dataRow, "AmountDebit"), true);
			
			rpt.generateReport("", "Enter Details in Create Bank Statement Line page", "", "", "All Mandatory Details should be entered", "All Mandatory details are entered", "Passed", "", true);
			
			cmnLib.clickOnWebElement(bankstmtreconc.OKBtn);
			TimeUnit.SECONDS.sleep(3);
			cmnLib.clickOnWebElement(bankstmtreconc.AddStatementLine);
			
			cmnLib.waitForElementToBeVisible(bankstmtreconc.BookingDate, 20);
			cmnLib.enterDataInTextBox(bankstmtreconc.BookingDate, exl.read(strDataSheetName, dataRow, "BookingDate"), true);
			cmnLib.enterDataInTextBox(bankstmtreconc.TransactionCode, exl.read(strDataSheetName, dataRow, "TransactionCodeCredit"), true);
			cmnLib.selectDropdownBy(bankstmtreconc.FlowIndicator, exl.read(strDataSheetName, dataRow, "FlowIndicatorCredit"), DropDownSelectBy.VisibleText);
			cmnLib.enterDataInTextBox(bankstmtreconc.Amount, exl.read(strDataSheetName, dataRow, "AmountCredit"), true);
			rpt.generateReport("", "Enter Details in Create Bank Statement Line page", "", "", "All Mandatory Details should be entered", "All Mandatory details are entered", "Passed", "", true);
			
			cmnLib.clickOnWebElement(bankstmtreconc.OKBtn);
			rpt.generateReport("", "Enter Details in Create Bank Statement page", "", "", "All Mandatory Details should be entered", "All Mandatory details are entered", "Passed", "", true);
			cmnLib.clickOnWebElement(bankstmtreconc.SaveAndCloseBtnTrans);
			
			if(cmnLib.waitForElementToBeVisible(bankstmtreconc.WarningDailog, 20))
			{
				rpt.generateReport("", "Warning message", "", "", "Warning message should appear", "Warning message appeared", "Passed", "", true);
				cmnLib.clickOnWebElement(bankstmtreconc.OKBtn);
			}
			
			if(cmnLib.waitForElementToBeVisible(bankstmtreconc.ConfirmationDialogBox, 20))
			{
				rpt.generateReport("", "Confirmation message", "", "", "Confirmation message should appear", "Confirmation message appeared", "Passed", "", true);
				cmnLib.clickOnWebElement(bankstmtreconc.OKBtnConfirmation);
			}else {
				rpt.generateReport("", "Confirmation message", "", "", "Confirmation message should appear", "Confirmation message did not appeared", "Passed", "", true);
				Assert.fail("Confirmation message did not appeared");
			}
			
		}
	}
}
