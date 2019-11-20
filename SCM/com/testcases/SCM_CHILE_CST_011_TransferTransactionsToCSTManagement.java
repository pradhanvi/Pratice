package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.commons.Common_Library.DropDownSelectBy;
import com.commons.TestBase;

import report.oracle.ofs.ReportGeneration;
//import report.oracle.ofs.ReportGeneration;
import scm.pagefactory.CostAccountingPage;
import scm.pagefactory.CreateCostAccountingDistributions;
import scm.pagefactory.CreateReceiptAccountingDistribution;
import scm.pagefactory.HomePage_SCM;
import scm.pagefactory.LoginPage_SCM;
import scm.pagefactory.ManageCostScenarious;
import scm.pagefactory.ReceiptAccounting;
import scm.pagefactory.ScheduledProcesses;
import xlsx.databank.ofs.ExcelOperations;
/**
Script Name			: SCM_CHILE_CST_011_TransferTransactionsToCSTManagement
Script Description	: Transfer Transactions to CST Management 
Track/Module		: SCM
Sub Track			: 
Created By			: Pradhanvi T R
Creation Date		: 01-Mar-2019
Modified By 		:
Modification Date	:
Instance Name & URL : https://edyg-dev4.fa.us2.oraclecloud.com/homePage/faces/FuseWelcome
User ID/ Password	: 10013865/Bimbo123
Responsibility		:
Pre-Requisites		: 
Comments (if any)	:
 **/


public class SCM_CHILE_CST_011_TransferTransactionsToCSTManagement extends TestBase{
	
	String strModule = "SCM";
	@Test
	public void SCM_CHILE_CST_011_TransferTransactionsToCSTManagement_TC() throws Throwable {
	
		rpt = new ReportGeneration("SCM_CHILE_CST_011_TransferTransactionsToCSTManagement", "Transfer Transactions to CST Management ");

		String strDataSheetName = "CST_011";
		boolean login = false;

		rpt.enterStepHeader("Login To Application");
		HomePage_SCM homePage_SCM = null;
		if(! (new HomePage_SCM().getUserNameFromHomePage() != null && new HomePage_SCM().getUserNameFromHomePage().equalsIgnoreCase(hashmap.get("UserName_"+strModule)))) {

			//Launch Browser
			launchBrowser(strModule);

			//Login To Application
			LoginPage_SCM loginPage_SCM = PageFactory.initElements(driver, LoginPage_SCM.class);

			homePage_SCM = loginPage_SCM.login(hashmap.get("UserName_"+strModule), hashmap.get("Password_"+strModule));
			rpt.enterStepHeader("Login to Application");
			if (homePage_SCM != null) {
				rpt.generateReport("", "Enter Username", "", hashmap.get("UserName_" + strModule),
						"Username must be entered", "Username entered", "Passed", "", true);
				rpt.generateReport("", "Enter Password", "", "", "Password must be entered", "Password entered",
						"Passed", "", true);
				rpt.generateReport("", "Click Sign In button", "", "", "Sign In button must be clicked",
						"Clicked Sign In button", "Passed", "", false);
			} else {
				rpt.generateReport("", "Login to application", "Enter Username, Password and Click Sign In button",
						"Username: " + hashmap.get("UserName_" + strModule), "Login must be Successful",
						"Login Un-Successful", "Failed", "", true);
				Assert.fail("Login Un-Successful");
			}

			login = true;
		}

		//Initialize HomePage Web Elements

		//Validate HomePage Icon
		if(cmnLib.waitForElementToBeVisible(homePage_SCM.HomePage_HomeIcon) == true)
		{
			homePage_SCM = PageFactory.initElements(driver, HomePage_SCM.class);
			//PASS
			rpt.generateReport("SCM_CHILE_CST_011_TransferTransactionsToCSTManagement", "Enter URL", "", "Password: "+hashmap.get("URL_"+strModule), "URL should be entered", "URL is entered", "Info", "", false );
			rpt.generateReport("", "Enter User Name", "", "UserName: "+hashmap.get("UserName_"+strModule), "UserName should be entered", "UserName is entered", "Info", "", false );
			rpt.generateReport("", "Enter Password", "", "Password: "+hashmap.get("Password_"+strModule), "Password should be entered", "Password is entered", "Info", "", false );
			rpt.generateReport("", "Validate Login to Appication", "", "", "Login Should be successful", "Login Is Successful", "Passed", "", false );
		}else
		{
			//FAIL
			rpt.generateReport("SCM_CHILE_CST_011_TransferTransactionsToCSTManagement", "Login to Appication", "", "UserName: "+exl.read("LoginDetails", 1, "UserName"), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
			Assert.fail("Login Un-Successful");
		}
		rpt.enterStepHeader("Navigation to Cost Accounting Page");

		//Always Load TestData Sheet Excel After Login as UserName & Password exists in other Excel which is loaded in TestBase
		exl = new ExcelOperations("SCM\\com\\dataBanks\\SCM_TestData.xlsx");

		// Script will execute for all the Rows present in the Data Sheet.
		System.out.println("No Of DataRows: "+exl.getRowCount(strDataSheetName));
		for (int dataRow = 1; dataRow < exl.getRowCount(strDataSheetName); dataRow++) {

		//Navigation
			if(homePage_SCM.clickOnWelcomePage_HomeIcon() == true)
			{
				homePage_SCM = PageFactory.initElements(driver, HomePage_SCM.class);
			}else
			{
				rpt.generateReport("", "Click On HomePage Icon", "", "", "HomePage Icon should be clicked", "HomePage Icon is not clicked", "Failed", "", true);
			}

		//Verify Presence of Navigator Icon
			if(homePage_SCM.NavigatorIcon.isDisplayed() == false)
			{
				//FAIL
				rpt.generateReport("", "Validate HomePage", "", "", "Validation Should be successful", "Validation Is Not Successful", "Failed", "", true );
				Assert.fail("Login Un-Successful");
			}
			TimeUnit.SECONDS.sleep(5);
			SoftAssert sAssert = new SoftAssert();
			String strProcessID = null;
			String strReportName=null;
			String strStatus=null;
			//ScheduledProcesses scheduledProcesses = homePage_SCM.clickOnScheduledProcesses();
		//Click on Navigator Icon
			homePage_SCM.clickOnNavigationIcon();
			TimeUnit.SECONDS.sleep(5);
			
		//Click On Scheduled Processes from Navigator Links
			ScheduledProcesses scheduledProcesses = homePage_SCM.clickOnScheduledProcesses();
			
			TimeUnit.SECONDS.sleep(5);
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
			rpt.enterStepHeader("Import Revenue Lines request");
			if(scheduledProcesses.submitNewRequest(exl.read(strDataSheetName, dataRow, "Report_Name1")))
			{
				rpt.generateReport("", "Selecting the report", "", "", "Should select "+exl.read(strDataSheetName, dataRow, "Report_Name1")+" report", 
						"Succeffully selected "+exl.read(strDataSheetName, dataRow, "Report_Name1")+" report", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Selecting the report", "", "", "Should select "+exl.read(strDataSheetName, dataRow, "Report_Name1")+" report", 
						"Unable to select "+exl.read(strDataSheetName, dataRow, "Report_Name1")+" report", "Passed", "", true );
				Assert.fail("Report was not selected");
			}
		//Parameters for report
			rpt.enterStepHeader("Entering the Parameters");
			
			if(cmnLib.waitForElementToBeVisible(scheduledProcesses.ParametersPage))
			{
				//cmnLib.enterDataInTextBox(scheduledProcesses.Para_BusinessUnit, exl.read(strDataSheetName, dataRow, "BusinessUnit_1"), true);
				cmnLib.enterDataInTextBox(scheduledProcesses.Para_NoOfChildWorkers, exl.read(strDataSheetName, dataRow, "NumOfChildWorkers"), true);
				cmnLib.enterDataInTextBox(scheduledProcesses.Para_ImportAsOfDate, cmnLib.futureDate("dd/MMM/yyyy", 0), true);
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
			strReportName=exl.read(strDataSheetName, dataRow, "Report_Name1");
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
/*****************************************************************************************************************/
			//Transfer Transactions from Production to Costing
			rpt.enterStepHeader("Transfer Transactions from Production to Costing request");
			if(scheduledProcesses.submitNewRequest(exl.read(strDataSheetName, dataRow, "Report_Name2")))
			{
				rpt.generateReport("", "Selecting the report", "", "", "Should select "+exl.read(strDataSheetName, dataRow, "Report_Name2")+" report", 
						"Succeffully selected "+exl.read(strDataSheetName, dataRow, "Report_Name2")+" report", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Selecting the report", "", "", "Should select "+exl.read(strDataSheetName, dataRow, "Report_Name2")+" report", 
						"Unable to select "+exl.read(strDataSheetName, dataRow, "Report_Name2")+" report", "Passed", "", true );
				Assert.fail("Report was not selected");
			}
		//Parameters for report
			rpt.enterStepHeader("Entering the Parameters");
			//String strProcessID = null;
			if(cmnLib.waitForElementToBeVisible(scheduledProcesses.ParametersPage))
			{
				cmnLib.enterDataInTextBox(scheduledProcesses.Para_Organization, exl.read(strDataSheetName, dataRow, "Organization"), true);
				cmnLib.enterDataInTextBox(scheduledProcesses.Para_SourceSystem, exl.read(strDataSheetName, dataRow, "SourceSystem"), true);
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
			strReportName=exl.read(strDataSheetName, dataRow, "Report_Name2");
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
			
/*************************************************************************************************************************************/
			//Transfer Transactions from Inventory to Costing
			rpt.enterStepHeader("Transfer Transactions from Inventory to Costing request");
			if(scheduledProcesses.submitNewRequest(exl.read(strDataSheetName, dataRow, "Report_Name3")))
			{
				rpt.generateReport("", "Selecting the report", "", "", "Should select "+exl.read(strDataSheetName, dataRow, "Report_Name3")+" report", 
						"Succeffully selected "+exl.read(strDataSheetName, dataRow, "Report_Name3")+" report", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Selecting the report", "", "", "Should select "+exl.read(strDataSheetName, dataRow, "Report_Name3")+" report", 
						"Unable to select "+exl.read(strDataSheetName, dataRow, "Report_Name3")+" report", "Passed", "", true );
				Assert.fail("Report was not selected");
			}
		//Parameters for report
			rpt.enterStepHeader("Entering the Parameters");
			strProcessID = null;
			if(cmnLib.waitForElementToBeVisible(scheduledProcesses.ParametersPage))
			{
				cmnLib.enterDataInTextBox(scheduledProcesses.Para_Cost_Organization, exl.read(strDataSheetName, dataRow, "Cost_Organization"), true);
				cmnLib.enterDataInTextBox(scheduledProcesses.Para_CommitLimit, exl.read(strDataSheetName, dataRow, "CommitLimit"), true);
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
			strReportName=exl.read(strDataSheetName, dataRow, "Report_Name3");
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
/*************************************************************************************************************************************/
			//Transfer Transactions from Receiving to Costing
			rpt.enterStepHeader("Transfer Transactions from Receiving to Costing");
			if(scheduledProcesses.submitNewRequest(exl.read(strDataSheetName, dataRow, "Report_Name4")))
			{
				rpt.generateReport("", "Selecting the report", "", "", "Should select "+exl.read(strDataSheetName, dataRow, "Report_Name4")+" report", 
						"Succeffully selected "+exl.read(strDataSheetName, dataRow, "Report_Name4")+" report", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Selecting the report", "", "", "Should select "+exl.read(strDataSheetName, dataRow, "Report_Name4")+" report", 
						"Unable to select "+exl.read(strDataSheetName, dataRow, "Report_Name4")+" report", "Passed", "", true );
				Assert.fail("Report was not selected");
			}
		//Parameters for report
			rpt.enterStepHeader("Entering the Parameters");
			strProcessID = null;
			if(cmnLib.waitForElementToBeVisible(scheduledProcesses.ParametersPage))
			{
				//cmnLib.enterDataInTextBox(scheduledProcesses.Para_Cost_Organization, exl.read(strDataSheetName, dataRow, "Cost_Organization"), true);
				//cmnLib.enterDataInTextBox(scheduledProcesses.Para_CommitLimit, exl.read(strDataSheetName, dataRow, "CommitLimit"), true);
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
			 strReportName=exl.read(strDataSheetName, dataRow, "Report_Name4");
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
/**********************************************************************************************************************************************/
			//Transfer Costs to Cost Management
			rpt.enterStepHeader("Transfer Costs to Cost Management");
			if(scheduledProcesses.submitNewRequest(exl.read(strDataSheetName, dataRow, "Report_Name5")))
			{
				rpt.generateReport("", "Selecting the report", "", "", "Should select "+exl.read(strDataSheetName, dataRow, "Report_Name5")+" report", 
						"Succeffully selected "+exl.read(strDataSheetName, dataRow, "Report_Name5")+" report", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Selecting the report", "", "", "Should select "+exl.read(strDataSheetName, dataRow, "Report_Name5")+" report", 
						"Unable to select "+exl.read(strDataSheetName, dataRow, "Report_Name5")+" report", "Passed", "", true );
				Assert.fail("Report was not selected");
			}
		//Parameters for report
			rpt.enterStepHeader("Entering the Parameters");
			strProcessID = null;
			if(cmnLib.waitForElementToBeVisible(scheduledProcesses.ParametersPage))
			{
				cmnLib.enterDataInTextBox(scheduledProcesses.Para_BusinessUnit, exl.read(strDataSheetName, dataRow, "Business_Unit"), true);
				cmnLib.enterDataInTextBox(scheduledProcesses.Para_CutOffDate, cmnLib.futureDate("dd/MMM/yyyy", 0), true);
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
			strReportName=exl.read(strDataSheetName, dataRow, "Report_Name5");
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
	
/******************************************************************************************************************************************/
		/*//Create cost accounting distribution
			rpt.enterStepHeader("Create cost accounting distribution");
			homePage_SCM.clickOnNavigationIcon();
			TimeUnit.SECONDS.sleep(3);
			//homePage_SCM.clickOnCostAccountingLink();
			CostAccountingPage costAccountingPage = homePage_SCM.clickOnCostAccountingLink();
			TimeUnit.SECONDS.sleep(20);
			boolean flag = cmnLib.waitForElementToBeVisible(costAccountingPage.CostAccountingHeader);
			System.out.println("Is visible------"+flag);
			TimeUnit.SECONDS.sleep(30);
			costAccountingPage.clickOnTaksIcon();
			TimeUnit.SECONDS.sleep(5);
			cmnLib.clickOnWebElement(costAccountingPage.CreateCostAccountingDistributionsLink);
			
			
			
			
			
			
			
			
			
			
			
			homePage_SCM.clickOnNavigationIcon();
			TimeUnit.SECONDS.sleep(5);
			
		
			CostAccountingPage costAccountingPage1 = homePage_SCM.clickOnCostAccountingLink();
			TimeUnit.SECONDS.sleep(5);
			cmnLib.waitForPageLoaded();

		//Verify Cost Accounting page is displayed
			if(costAccountingPage.CostAccountingHeader.isDisplayed() == true)
			{
				System.out.println("Navigation to Cost Accounting Page Is displayed");
				//rpt.generateReport("", "Navigation to Cost Accounting Page", "", "", "Navigation to Cost Accounting Page should be displayed", "Navigation to Cost Accounting Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				System.out.println("Navigation to Cost Accounting Page Is not displayed");
				rpt.generateReport("", "Navigation to Cost Accounting Page", "", "", "Navigation to Cost Accounting Page should be displayed", "Navigation to Cost Accounting Page Is Not displayed", "Failed", "", true );
				Assert.fail("Navigation to Cost Accounting Page is not displayed");
			}

		// Selecting Tasks
			cmnLib.waitForPageLoaded();
			TimeUnit.SECONDS.sleep(30);
			costAccountingPage.clickOnTaksIcon();
			
		//Clicking on Review Item Costs
			TimeUnit.SECONDS.sleep(5);
			CreateCostAccountingDistributions createCostAccountingDistributions = costAccountingPage.clickOnCreateCostAccountingDistributions();
			
			if(cmnLib.waitForElementToBeVisible(createCostAccountingDistributions.CreateCostAccountingDistributionsHeader))
			{
				rpt.generateReport("", "Create cost accounting distribution", "", "", "Create cost accounting distribution page must be opened", 
						"Create cost accounting distribution page is opened", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Create cost accounting distribution", "", "", "Create cost accounting distribution page must be opened", 
						"Create cost accounting distribution page is not opened", "Failed", "", true );
				Assert.fail("Page not displayed");
			}
			cmnLib.clickOnWebElement(createCostAccountingDistributions.RunControl_Add);
			cmnLib.enterDataInTextBox(createCostAccountingDistributions.RunControlID, exl.read(strDataSheetName, dataRow, "RunControl_ID"), true);
			TimeUnit.SECONDS.sleep(3);
			
			cmnLib.clickOnWebElement(createCostAccountingDistributions.Details_Add);
			cmnLib.enterDataInTextBox(createCostAccountingDistributions.CostOrganization, exl.read(strDataSheetName, dataRow, "Cost_Oraganization"), true);
			TimeUnit.SECONDS.sleep(3);
			cmnLib.enterDataInTextBox(createCostAccountingDistributions.CostBooks, exl.read(strDataSheetName, dataRow, "Cost_Books"), true);
			
			cmnLib.selectDropdownBy(createCostAccountingDistributions.CutOffDateOptions, exl.read(strDataSheetName, dataRow, "CutOffDate_Option"), DropDownSelectBy.VisibleText);
			
			//cmnLib.enterDataInTextBox(createCostAccountingDistributions.CutOffDate, cmnLib.futureDate("dd/MMM/yyyy", 0), true);
			
			cmnLib.clickOnWebElement(createCostAccountingDistributions.SaveButton);
			rpt.generateReport("", "Create cost accounting distribution", "", "", "Saves the page successfully", 
					"Saved the page successfully", "Passed", "", true );
			
			cmnLib.clickOnWebElement(createCostAccountingDistributions.ScheduleProcessButton);
			
			cmnLib.waitForElementToBeVisible(createCostAccountingDistributions.SubmitButton);
			cmnLib.clickOnWebElement(createCostAccountingDistributions.SubmitButton);
			TimeUnit.SECONDS.sleep(5);
			if (cmnLib.waitForElementToBeVisible(createCostAccountingDistributions.ProcessIDMessage)
					&& createCostAccountingDistributions.ProcessIDMessage.getText() != null){
				String strMessage = createCostAccountingDistributions.ProcessIDMessage.getText();
				System.out.println(strMessage);
				strProcessID = strMessage.split(" ")[1];
				rpt.generateReport("", "Verify Process submitted message in Confirmation window", "", "",
						"Process submitted message must appear", "Message appears: " + strMessage, "Passed", "", true);
			} else {
				rpt.generateReport("", "Verify Process submitted message in Confirmation window", "", "",
						"Process submitted message must appear", "Message did not appear", "Failed", "", true);
				Assert.fail("Failed to verify Process submitted message");
			}
			cmnLib.clickOnWebElement(createCostAccountingDistributions.ConfirmationWindowOKButton);
			cmnLib.clickOnWebElement(homePage_SCM.HomePage_HomeIcon);
			TimeUnit.SECONDS.sleep(3);
			homePage_SCM.clickOnNavigationIcon();
			TimeUnit.SECONDS.sleep(3);
			cmnLib.clickOnWebElement(homePage_SCM.ScheduledProcessesLink);
			cmnLib.waitForPageLoaded();
		
	//Checking the Report Status
			TimeUnit.SECONDS.sleep(8);
		rpt.enterStepHeader("Verify Report status");
		strReportName=exl.read(strDataSheetName, dataRow, "Report_Name6");
		System.out.println("---------strReportName-------"+strReportName);
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
		} else if (strStatus.equalsIgnoreCase("Warning")||strStatus.equalsIgnoreCase("Canceled")) {
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
		}*/
/******************************************Create Receipt accounting distribution**************************************************************************/		
	//Create Receipt accounting distribution
		rpt.enterStepHeader("Create Receipt Accounting Distribution");
		cmnLib.clickOnWebElement(homePage_SCM.HomePage_HomeIcon);
		TimeUnit.SECONDS.sleep(3);
		homePage_SCM.clickOnNavigationIcon();
		TimeUnit.SECONDS.sleep(3);
		CreateReceiptAccountingDistribution createReceiptAccountingDistribution = homePage_SCM.clickOnReceiptAccounting();
		//CreateReceiptAccountingDistribution createReceiptAccountingDistribution=new CreateReceiptAccountingDistribution();
		CostAccountingPage costAccountingPage1 = new CostAccountingPage();
		//CreateCostAccountingDistributions createCostAccountingDistributions = costAccountingPage1.clickOnCreateCostAccountingDistributions();
		CreateCostAccountingDistributions createCostAccountingDistributions =new CreateCostAccountingDistributions();
		TimeUnit.SECONDS.sleep(5);
		
		ReceiptAccounting receiptAccounting = new ReceiptAccounting();
		//cmnLib.clickOnWebElement(receiptAccounting.ReceiptAccountingIcon);
		//cmnLib.waitForElementToBeVisible(costAccountingPage.CostAccountingHeader);
		TimeUnit.SECONDS.sleep(30);
		cmnLib.clickOnWebElement(receiptAccounting.TasksIcon);
		TimeUnit.SECONDS.sleep(3);
		cmnLib.clickOnWebElement(receiptAccounting.CreateReceiptAccountingDistributionLink);
		
				TimeUnit.SECONDS.sleep(5);
		if(cmnLib.waitForElementToBeVisible(createReceiptAccountingDistribution.CreateReceiptAccountingDistribution_Name))
		{
			rpt.generateReport("", "Create Receipt Accounting Distribution", "", "", "Create Receipt Accounting Distribution page must be opened", 
					"Create Receipt Accounting Distribution page is opened", "Passed", "", true );

		}else
		{
			//FAIL
			rpt.generateReport("", "Create Receipt Accounting Distribution", "", "", "Create Receipt Accounting Distribution page must be opened", 
					"Create Receipt Accounting Distribution page is not opened", "Failed", "", true );
			Assert.fail("Create Receipt Accounting Distribution page is not opened");
		}
		
		cmnLib.enterDataInTextBox(createReceiptAccountingDistribution.BillToBusinessUnit, exl.read(strDataSheetName, dataRow, "BillToBusinessUnit"), true);
		cmnLib.enterDataInTextBox(scheduledProcesses.Para_CommitLimit, exl.read(strDataSheetName, dataRow, "CommitLimit"), true);
		
		cmnLib.clickOnWebElement(createReceiptAccountingDistribution.SubmitButton);
		
		if (cmnLib.waitForElementToBeVisible(createCostAccountingDistributions.ProcessIDMessage)
				&& createCostAccountingDistributions.ProcessIDMessage.getText() != null) {
			String strMessage = createCostAccountingDistributions.ProcessIDMessage.getText();
			System.out.println(strMessage);
			strProcessID = strMessage.split(" ")[1];
			rpt.generateReport("", "Verify Process submitted message in Confirmation window", "", "",
					"Process submitted message must appear", "Message appears: " + strMessage, "Passed", "", true);
		} else {
			rpt.generateReport("", "Verify Process submitted message in Confirmation window", "", "",
					"Process submitted message must appear", "Message did not appear", "Failed", "", true);
			Assert.fail("Failed to verify Process submitted message");
		}
		cmnLib.clickOnWebElement(createCostAccountingDistributions.ConfirmationWindowOKButton);
		TimeUnit.SECONDS.sleep(3);
		homePage_SCM.clickOnWelcomePage_HomeIcon();
		TimeUnit.SECONDS.sleep(2);
		homePage_SCM.clickOnNavigationIcon();
		TimeUnit.SECONDS.sleep(3);
		homePage_SCM.clickOnScheduledProcesses();
		TimeUnit.SECONDS.sleep(3);
	
		//Checking the Report Status
			rpt.enterStepHeader("Verify Report status");
			strReportName=exl.read(strDataSheetName, dataRow, "Report_Name7");
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
			} else if (strStatus.equalsIgnoreCase("Warning")||strStatus.equalsIgnoreCase("Canceled")) {
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
				
		
			sAssert.assertAll();
			
		
}
}
}
