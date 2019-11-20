package com.testcases.CM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.commons.Common_Library.DropDownSelectBy;
import com.commons.TestBase;

import finance.pagefactory.BankStatementsAndReconciliation;
import finance.pagefactory.Billing;
import finance.pagefactory.CreateTransaction;
import finance.pagefactory.HomePage_FIN;
import finance.pagefactory.LoginPage_FIN;
import finance.pagefactory.ManageTransactions;
import finance.pagefactory.ReviewTransaction;
import report.oracle.ofs.ReportGeneration;
import xlsx.databank.ofs.ExcelOperations;

/**
Script Name			: FIN_PERU_CL_01_RecordMiscellaneousBankTransactions
Script Description	: Record Miscellaneous Bank Transactions
Track/Module		: FIN
Sub Track			: 
Created By			: Pradhanvi T R
Creation Date		: 
Modified By 		: 
Modification Date	: 
Instance Name & URL : https://edyg-dev6.login.us2.oraclecloud.com
User ID/ Password	: AUTO.FIN_USER/********
Responsibility		: 
Pre-Requisites		: 
Comments (if any)	:
 **/

public class FIN_PERU_CL_01_RecordMiscellaneousBankTransactions extends TestBase {
	String strModule = "FIN";

	@Test
	public void FIN_PERU_CL_01_RecordMiscellaneousBankTransactions_TC() throws Throwable { 
		rpt = new ReportGeneration("FIN_PERU_CL_01_RecordMiscellaneousBankTransactions", "");

		String strDataSheetName = "CL_01";

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
			rpt.generateReport("FIN_PERU_CL_01_RecordMiscellaneousBankTransactions transaction", "Enter URL", "", "Password: "+hashmap.get("URL_"+strModule), "URL should be entered", "URL is entered", "Info", "", false );

			rpt.enterStepHeader("Login To Application");
			rpt.generateReport("", "Enter User Name", "", "UserName: "+hashmap.get("UserName_"+strModule), "UserName should be entered", "UserName is entered", "Info", "", false );
			rpt.generateReport("", "Enter Password", "", "Password: "+hashmap.get("Password_"+strModule), "Password should be entered", "Password is entered", "Info", "", false );
			rpt.generateReport("", "Validate Login to Application", "", "", "Login Should be successful", "Login Is Successful", "Passed", "", true );
		}else
		{
			//FAIL
			rpt.generateReport("FIN_PERU_CL_01_RecordMiscellaneousBankTransactions", "Login to Appication", "", "UserName: "+exl.read("LoginDetails", 1, "UserName"), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
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
			if(cmnLib.clickOnWebElement(bankstmtreconc.CreateTransaction)) {
				rpt.generateReport("", "Click on Create Transaction link in Tasks", "", "", "Create Transaction Link should be clicked", "Create Transaction link is clicked", "Passed", "", true);
			}else {
				rpt.generateReport("", "Click on Create Transaction link in Tasks", "", "", "Create Transaction Link should be clicked", "Create Transaction link is not clicked", "Failed", "", true);
				Assert.fail("Create Transaction link is not clicked");
			}
			cmnLib.waitForPageLoaded();
			
			if(cmnLib.waitForElementToBeVisible(bankstmtreconc.BankAccount)) {
				rpt.generateReport("", "Verify Create External Transaction page", "", "", "Create External Transaction page should be opened", "Create External Transaction page is opened", "Passed", "", true);
			}else {
				rpt.generateReport("", "Verify Create External Transaction page", "", "", "Create External Transaction page should be opened", "Create External Transaction page is not opened", "Failed", "", true);
				Assert.fail("Create External Transaction page is not opened");
			}
			
			
			cmnLib.enterDataInTextBox(bankstmtreconc.BankAccount, exl.read(strDataSheetName, dataRow, "BankAccount"), true);
			cmnLib.enterDataInTextBox(bankstmtreconc.BusinessUnit, exl.read(strDataSheetName, dataRow, "BusinessUnit"), true);
			cmnLib.enterDataInTextBox(bankstmtreconc.Amount, exl.read(strDataSheetName, dataRow, "Amount"), true);
			cmnLib.enterDataInTextBox(bankstmtreconc.Date, cmnLib.futureDate("dd/MMM/yyyy", 0), true);
			cmnLib.enterDataInTextBox(bankstmtreconc.DescriptionTextArea, exl.read(strDataSheetName, dataRow, "DescriptionTextArea"), true);
			cmnLib.selectDropdownBy(bankstmtreconc.TransactionType, exl.read(strDataSheetName, dataRow, "TransactionType"), DropDownSelectBy.VisibleText);
			String offsetAcc = bankstmtreconc.OffsetAccount.getAttribute("value");
			System.out.println("Length "+offsetAcc.length()+" Offset "+offsetAcc);
			if(offsetAcc.length()==0) 
				cmnLib.enterDataInTextBox(bankstmtreconc.OffsetAccount, exl.read(strDataSheetName, dataRow, "OffsetAccount"), true);
			
			
			rpt.generateReport("", "Enter Details in Create External Transaction page", "", "", "All Mandatory Details should be entered", "All Mandatory details are entered", "Passed", "", true);
			
			cmnLib.clickOnWebElement(bankstmtreconc.SaveAndCloseBtn);
			TimeUnit.SECONDS.sleep(3);
			if(cmnLib.waitForElementToBeClickable(bankstmtreconc.BankStatementsReconciliationPage)) {
				rpt.generateReport("", "Verify External transactions are created", "", "", "External transactions should be created successfully", "External transactions are created successfully", "Passed", "", true);
			}else {
				rpt.generateReport("", "Verify External transactions are created", "", "", "External transactions should be created successfully", "External transactions are not created successfully", "Failed", "", true);
				Assert.fail("External transactions are not created successfully");
			}
		}
	}
}
