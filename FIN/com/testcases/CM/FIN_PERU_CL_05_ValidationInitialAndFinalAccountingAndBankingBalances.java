package com.testcases.CM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.commons.TestBase;
import com.commons.Common_Library.DropDownSelectBy;

import finance.pagefactory.BankStatementsAndReconciliation;
import finance.pagefactory.HomePage_FIN;
import finance.pagefactory.LoginPage_FIN;
import report.oracle.ofs.ReportGeneration;
import scm.pagefactory.ScheduledProcesses;
import xlsx.databank.ofs.ExcelOperations;

/**
Script Name			: FIN_PERU_CL_05_ValidationInitialAndFinalAccountingAndBankingBalances
Script Description	: Validation of initial and final accounting and banking balances
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

public class FIN_PERU_CL_05_ValidationInitialAndFinalAccountingAndBankingBalances extends TestBase {
	String strModule = "FIN";

	@Test
	public void FIN_PERU_CL_05_ValidationInitialAndFinalAccountingAndBankingBalances_TC() throws Throwable { 
		rpt = new ReportGeneration("FIN_PERU_CL_05_ValidationInitialAndFinalAccountingAndBankingBalances", "");

		String strDataSheetName = "CL_05";

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
			SoftAssert sAssert = new SoftAssert();
			String strProcessID = null;
			String strReportName=null;
			String strStatus=null;
			
			//Click on Billing from Navigator Pane
			ScheduledProcesses scheduledProcesses = homePage_FIN.clickOnScheduledProcesses();
			cmnLib.waitForPageLoaded();

			//Verify Scheduled Processes page is displayed
				if(cmnLib.waitForElementToBeVisible(scheduledProcesses.ScheduledProcessesHeader))
				{
					rpt.generateReport("", "Navigation to Scheduled Processes Page", "", "", "Navigation to Scheduled Processes Page should be displayed", 
							"Navigation to Scheduled Processes Page Is displayed", "Passed", "", true );

				}else
				{
					//FAIL
					rpt.generateReport("", "Navigation to Scheduled Processes Page", "", "", "Navigation to Scheduled Processes Page should be displayed",
							"Navigation to Scheduled Processes Page Is Not displayed", "Failed", "", true );
					Assert.fail("Navigation to Scheduled Processes Page is not displayed");
				}
				
				//Import Revenue Lines request
				rpt.enterStepHeader("Create Accounting");
				if(scheduledProcesses.submitNewRequest(exl.read(strDataSheetName, dataRow, "Report_Name")))
				{
					rpt.generateReport("", "Selecting the report", "", "", "Should select "+exl.read(strDataSheetName, dataRow, "Report_Name")+" report", 
							"Succeffully selected "+exl.read(strDataSheetName, dataRow, "Report_Name")+" report", "Passed", "", true );

				}else
				{
					//FAIL
					rpt.generateReport("", "Selecting the report", "", "", "Should select "+exl.read(strDataSheetName, dataRow, "Report_Name")+" report", 
							"Unable to select "+exl.read(strDataSheetName, dataRow, "Report_Name")+" report", "Passed", "", true );
					Assert.fail("Report was not selected");
				}
			//Parameters for report
				rpt.enterStepHeader("Entering the Parameters");
				
				if(cmnLib.waitForElementToBeVisible(scheduledProcesses.ParametersPage))
				{
					cmnLib.selectDropdownBy(scheduledProcesses.SubledgerApplication, exl.read(strDataSheetName, dataRow, "SubledgerApplication"), DropDownSelectBy.VisibleText);
					cmnLib.enterDataInTextBox(scheduledProcesses.Ledger_CA, exl.read(strDataSheetName, dataRow, "Ledger"), true);
					cmnLib.enterDataInTextBox(scheduledProcesses.EndDate_CA, cmnLib.futureDate("dd/MMM/yyyy", 0), true);
					cmnLib.selectDropdownBy(scheduledProcesses.AccountingMode, exl.read(strDataSheetName, dataRow, "AccountingMode"), DropDownSelectBy.VisibleText);
					cmnLib.selectDropdownBy(scheduledProcesses.ReportStyle, exl.read(strDataSheetName, dataRow, "ReportStyle"), DropDownSelectBy.VisibleText);
					//cmnLib.selectDropdownBy(scheduledProcesses.TransfertoGeneralLedger, exl.read(strDataSheetName, dataRow, "TransfertoGeneralLedger"), DropDownSelectBy.VisibleText);
					//cmnLib.selectDropdownBy(scheduledProcesses.PostinGeneralLedger, exl.read(strDataSheetName, dataRow, "PostinGeneralLedger"), DropDownSelectBy.VisibleText);
					cmnLib.selectDropdownBy(scheduledProcesses.IncludeUserTransactionIdentifiers, exl.read(strDataSheetName, dataRow, "IncludeUserTransactionIdentifiers"), DropDownSelectBy.VisibleText);
					
					rpt.generateReport("", "Create Accounting Parameters ", "", "", "All Mandatory Details should be entered", "All Mandatory details are entered", "Passed", "", true);
					cmnLib.clickOnWebElement(scheduledProcesses.Para_Submit);
					
					
					if (cmnLib.waitForElementToBeVisible(scheduledProcesses.Message_Confirmation)
							&& scheduledProcesses.Message_Confirmation.getText() != null) {
						String strMessage = scheduledProcesses.Message_Confirmation.getText();
						System.out.println(strMessage);
						strProcessID = strMessage.split(" ")[1];
						rpt.generateReport("", "Verify Process submitted message in Confirmation window", "", "",
								"Process submitted message must appear", "Message appears: " + strMessage, "Passed", "", true);
					} else {
						rpt.generateReport("", "Verify Process submitted message in Confirmation window", "", "",
								"Process submitted message must appear", "Message did not appear", "Failed", "", true);
						Assert.fail("Failed to verify Process submitted message");
					}
					cmnLib.clickOnWebElement(scheduledProcesses.OK_Confirmation);
				}
			//Checking the Report Status
				rpt.enterStepHeader("Verify Report status");
				strReportName=exl.read(strDataSheetName, dataRow, "Report_Name");
				strStatus = scheduledProcesses.verifyReportStatus(strProcessID, strReportName);
				if (strStatus.equalsIgnoreCase("Succeeded")) {
					rpt.generateReport("", "Search the report", "", "", "Report must appear in results",
							"Report appears in results", "Passed", "", false);
					rpt.generateReport("", "Verify Report Status",
							"Wait and Refresh until status changes to Succeeded/Error/Warning",
							strProcessID + ", " + strReportName, "Report status must change to Succeeded/Error/Warning",
							"Report status changed to Succeeded", "Passed", "", true);
				} else if (strStatus.equalsIgnoreCase("Error")) {
					rpt.generateReport("", "Search the report", "", "", "Report must appear in results",
							"Report appears in results", "Passed", "", false);
					rpt.generateReport("", "Verify Report Status",
							"Wait and Refresh until status changes to Succeeded/Error/Warning",
							strProcessID + ", " + strReportName, "Report status must change to Succeeded/Error/Warning",
							"Report status changed to Error", "Passed", "", true);
				} else if (strStatus.equalsIgnoreCase("Warning")) {
					rpt.generateReport("", "Search the report", "", "", "Report must appear in results",
							"Report appears in results", "Passed", "", false);
					rpt.generateReport("", "Verify Report Status",
							"Wait and Refresh until status changes to Succeeded/Error/Warning",
							strProcessID + ", " + strReportName, "Report status must change to Succeeded/Error/Warning",
							"Report status changed to Warning", "Passed", "", true);
				} else {
					rpt.generateReport("", "Search the report and verify Report Status",
							"Wait and Refresh until status changes to Succeeded/Error/Warning",
							strProcessID + ", " + strReportName, "Report status must change to Succeeded/Error/Warning",
							"Unable to verify report status", "Failed", "", true);
					sAssert.fail("Failed to verify report status");
				}
		}
	}


}
