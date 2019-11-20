package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.commons.Common_Library.DropDownSelectBy;
import com.commons.TestBase;

import jdk.internal.dynalink.beans.StaticClass;
import report.oracle.ofs.ReportGeneration;
import scm.pagefactory.HomePage_SCM;
import scm.pagefactory.InventoryManagementPage;
import scm.pagefactory.LoginPage_SCM;
import scm.pagefactory.ManageWorkArea;
import scm.pagefactory.ScheduledProcesses;
import scm.pagefactory.WorkDefinition;
import xlsx.databank.ofs.ExcelOperations;

/**
Script Name			: SCM_CHILE_INV_039_PerformCycleCounting
Script Description	: Perform Cycle Counting
Track/Module		: SCM
Sub Track			: 
Created By			: Pradhanvi T R
Creation Date		: 
Modified By 		:
Modification Date	:
Instance Name & URL : https://edyg-dev4.fa.us2.oraclecloud.com/homePage/faces/FuseWelcome
User ID/ Password	: 10013865/Bimbo123
Responsibility		:
Pre-Requisites		: 
Comments (if any)	:
 **/

public class SCM_CHILE_INV_039_PerformCycleCounting extends TestBase{
	
	String strModule = "SCM";
	@Test
	public void SCM_CHILE_INV_039_PerformCycleCounting_TC() throws Throwable {
		rpt = new ReportGeneration("SCM_CHILE_INV_039_PerformCycleCounting", "");

		String strDataSheetName = "INV_039";
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
			rpt.generateReport("SCM_CHILE_INV_039_PerformCycleCounting", "Enter URL", "", "Password: "+hashmap.get("URL_"+strModule), "URL should be entered", "URL is entered", "Info", "", false );
			rpt.generateReport("", "Enter User Name", "", "UserName: "+hashmap.get("UserName_"+strModule), "UserName should be entered", "UserName is entered", "Info", "", false );
			rpt.generateReport("", "Enter Password", "", "Password: "+hashmap.get("Password_"+strModule), "Password should be entered", "Password is entered", "Info", "", false );
			rpt.generateReport("", "Validate Login to Appication", "", "", "Login Should be successful", "Login Is Successful", "Passed", "", false );
		}else
		{
			//FAIL
			rpt.generateReport("SCM_CHILE_INV_039_PerformCycleCounting", "Login to Appication", "", "UserName: "+exl.read("LoginDetails", 1, "UserName"), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
			Assert.fail("Login Un-Successful");
		}
		rpt.enterStepHeader("Navigation to Work Definition Page");

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
		//Click on Navigator Icon
			homePage_SCM.clickOnNavigationIcon();
			TimeUnit.SECONDS.sleep(5);
			
		//Click On Work Definition from Navigator Links
			 InventoryManagementPage invMan = homePage_SCM.clickOnInventoryManagement();
			TimeUnit.SECONDS.sleep(5);
			cmnLib.waitForPageLoaded();

		//Verify Inventory Management page is displayed
			rpt.enterStepHeader("Inventory Management page verification");
			if(cmnLib.waitForElementToBeVisible(invMan.InventoryManagementHeader,10))
			{
				rpt.generateReport("", "Navigation to Inventory Management Page", "", "", "Navigation to Inventory Management Page should be displayed", "Navigation to Inventory Management Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to Inventory Management Page", "", "", "Navigation to Inventory Management should be displayed", "Navigation to Inventory Management Page Is Not displayed", "Failed", "", true );
				Assert.fail("Navigation to Inventory Management Page is not displayed");
			}
		//Selecting the Tasks
			rpt.enterStepHeader("Selecting the Tasks");
			
			if(invMan.TasksIcon.isEnabled())
			{
				cmnLib.clickOnWebElement(invMan.TasksIcon);
				rpt.generateReport("", "Selecting the Tasks", "", "", "Tasks must be selected", "Tasks is selected", "Passed", "", true );
			}else {
				
				rpt.generateReport("", "Selecting the Tasks", "", "", "Tasks must be selected", "Tasks are not selected", "Failed", "", true );
				Assert.fail("Tasks are not selected");
			}
			cmnLib.waitForElementToBeVisible(invMan.TasksSelctionDropdown, 40);
			
			if(!cmnLib.selectDropdownBy(invMan.TasksSelctionDropdown, exl.read(strDataSheetName, dataRow, "TasksSelctionDropdown"), DropDownSelectBy.VisibleText))
			{
				rpt.generateReport("", "Selecting the Tasks", "", exl.read(strDataSheetName, dataRow, "TasksSelctionDropdown"), "Task dropdown should be selected", "Task dropdown is not selected", "Failed", "", true );
				Assert.fail("Task dropdown is not selected");
			}
			
			cmnLib.waitForElementToBeVisible(invMan.ManageCycleCounts, 10);
			if(cmnLib.clickOnWebElement(invMan.ManageCycleCounts))
			{
				rpt.generateReport("", "Selecting the Tasks", "", "Manage Cycle Counts", "Tasks must be selected", "Tasks is selected", "Passed", "", true );
			}else {
				
				rpt.generateReport("", "Selecting the Tasks", "", "Manage Cycle Counts", "Tasks must be selected", "Tasks are not selected", "Failed", "", true );
				Assert.fail("Tasks are not selected");
			}
			if(cmnLib.waitForElementToBeVisible(invMan.SelectOrgWindow, 10))
			{
				cmnLib.enterDataInTextBox(invMan.Org, exl.read(strDataSheetName, dataRow, "Organization"), true);
				rpt.generateReport("", "Selecting the Organization", "", exl.read(strDataSheetName, dataRow, "Organization"), "Organization must be selected", "Organization is selected", "Passed", "", true );
				cmnLib.clickOnWebElement(invMan.OrgWindowOKBtn);
			}
			
		//Verifying Manage Cycle count page 
			
			// Generate Count Schedule
			rpt.enterStepHeader("Verifying Manage Cycle count page");
			if(cmnLib.waitForElementToBeVisible(invMan.ManageCycleCountsPageHeader))
			{
				rpt.generateReport("", "Navigation to Manage Cycle count Page", "", "", "Navigation to ManageCycle count Page should be displayed", "Navigation to Manage Cycle count Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to Manage Cycle count Page", "", "", "Navigation to Manage Cycle count page should be displayed", "Navigation to Manage Cycle count Page Is Not displayed", "Failed", "", true );
				Assert.fail("Navigation to Manage Cycle count Page is not displayed");
			}
			if(cmnLib.waitForElementToBeVisible(invMan.ExpandAdvancedSearch))
				cmnLib.clickOnWebElement(invMan.ExpandAdvancedSearch);
			cmnLib.enterDataInTextBox(invMan.CountName, exl.read(strDataSheetName, dataRow, "CountName"), true);
			cmnLib.clickOnWebElement(invMan.SearchBtn);
			
			
			if(cmnLib.waitForElementToBeVisible(invMan.NoResultFound, 5))
			{
				rpt.generateReport("", "Count Name search", "", exl.read(strDataSheetName, dataRow, "CountName"), "Count name search result should appear", "Count Name search result not found", "Failed", "", true );
				Assert.fail("Count Name search result not found");
			}else{
				rpt.generateReport("", "Count Name search", "", exl.read(strDataSheetName, dataRow, "CountName"), "Count name search result should appear", "Count Name search result found", "Passed", "", true );
			}
			
			cmnLib.clickOnWebElement(invMan.ActionsBtn);
			TimeUnit.SECONDS.sleep(2);
			cmnLib.clickOnWebElement(invMan.GenerateCountSchedules);
			 String  strProcessID=null;
			if (cmnLib.waitForElementToBeVisible(invMan.InformationWindow)
					&& invMan.ConfirmationMsg.getText() != null) {
				String strMessage = invMan.ConfirmationMsg.getText();
				System.out.println(strMessage);
				strProcessID = strMessage.split(" ")[1];
				rpt.generateReport("", "Verify Process submitted message in Confirmation window", "", "",
						"Process submitted message must appear", "Message appears: " + strMessage, "Passed", "", true);
			} else {
				rpt.generateReport("", "Verify Process submitted message in Confirmation window", "", "",
						"Process submitted message must appear", "Message did not appear", "Failed", "", true);
				Assert.fail("Failed to verify Process submitted message");
			}
			cmnLib.clickOnWebElement(invMan.ConfirmationWinOKBtn);
			
			//Navigating to Scheduled Processes
			homePage_SCM.clickOnNavigationIcon();
			TimeUnit.SECONDS.sleep(5);
			homePage_SCM.clickOnScheduledProcesses();
			
			
			//Checking the Report Status
			ScheduledProcesses scheduledProcesses = new ScheduledProcesses();
			rpt.enterStepHeader("Verify Report status");
			String strReportName=exl.read(strDataSheetName, dataRow, "Report_Name1");
			String strStatus = scheduledProcesses.verifyReportStatus(strProcessID, strReportName);
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
				Assert.fail("Failed to verify report status");
			}
/******************************************************************Generate Count Sequences********************************************************************************/
			//Verify Presence of Navigator Icon
			if(homePage_SCM.NavigatorIcon.isDisplayed() == false)
			{
				//FAIL
				rpt.generateReport("", "Validate HomePage", "", "", "Validation Should be successful", "Validation Is Not Successful", "Failed", "", true );
				Assert.fail("Login Un-Successful");
			}
			TimeUnit.SECONDS.sleep(5);
		//Click on Navigator Icon
			homePage_SCM.clickOnNavigationIcon();
			TimeUnit.SECONDS.sleep(5);
			
		//Click On Work Definition from Navigator Links
			homePage_SCM.clickOnInventoryManagement();
			TimeUnit.SECONDS.sleep(5);
			cmnLib.waitForPageLoaded();

		//Verify Inventory Management page is displayed
			rpt.enterStepHeader("Inventory Management page verification");
			if(cmnLib.waitForElementToBeVisible(invMan.InventoryManagementHeader,10))
			{
				rpt.generateReport("", "Navigation to Inventory Management Page", "", "", "Navigation to Inventory Management Page should be displayed", "Navigation to Inventory Management Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to Inventory Management Page", "", "", "Navigation to Inventory Management should be displayed", "Navigation to Inventory Management Page Is Not displayed", "Failed", "", true );
				Assert.fail("Navigation to Inventory Management Page is not displayed");
			}
		//Selecting the Tasks
			rpt.enterStepHeader("Selecting the Tasks");
			
			if(invMan.TasksIcon.isEnabled())
			{
				cmnLib.clickOnWebElement(invMan.TasksIcon);
				rpt.generateReport("", "Selecting the Tasks", "", "", "Tasks must be selected", "Tasks is selected", "Passed", "", true );
			}else {
				
				rpt.generateReport("", "Selecting the Tasks", "", "", "Tasks must be selected", "Tasks are not selected", "Failed", "", true );
				Assert.fail("Tasks are not selected");
			}
			cmnLib.waitForElementToBeVisible(invMan.TasksSelctionDropdown, 40);
			
			if(!cmnLib.selectDropdownBy(invMan.TasksSelctionDropdown, exl.read(strDataSheetName, dataRow, "TasksSelctionDropdown"), DropDownSelectBy.VisibleText))
			{
				rpt.generateReport("", "Selecting the Tasks", "", exl.read(strDataSheetName, dataRow, "TasksSelctionDropdown"), "Task dropdown should be selected", "Task dropdown is not selected", "Failed", "", true );
				Assert.fail("Task dropdown is not selected");
			}
			
			cmnLib.waitForElementToBeVisible(invMan.ManageCycleCounts, 10);
			if(cmnLib.clickOnWebElement(invMan.ManageCycleCounts))
			{
				rpt.generateReport("", "Selecting the Tasks", "", "Manage Cycle Counts", "Tasks must be selected", "Tasks is selected", "Passed", "", true );
			}else {
				
				rpt.generateReport("", "Selecting the Tasks", "", "Manage Cycle Counts", "Tasks must be selected", "Tasks are not selected", "Failed", "", true );
				Assert.fail("Tasks are not selected");
			}
			if(cmnLib.waitForElementToBeVisible(invMan.SelectOrgWindow, 10))
			{
				cmnLib.enterDataInTextBox(invMan.Org, exl.read(strDataSheetName, dataRow, "Organization"), true);
				rpt.generateReport("", "Selecting the Organization", "", exl.read(strDataSheetName, dataRow, "Organization"), "Organization must be selected", "Organization is selected", "Passed", "", true );
				cmnLib.clickOnWebElement(invMan.OrgWindowOKBtn);
			}
			
		//Verifying Manage Cycle count page 
			
			// Generate Count Sequences
			rpt.enterStepHeader("Verifying Manage Cycle count page");
			if(cmnLib.waitForElementToBeVisible(invMan.ManageCycleCountsPageHeader))
			{
				rpt.generateReport("", "Navigation to Manage Cycle count Page", "", "", "Navigation to ManageCycle count Page should be displayed", "Navigation to Manage Cycle count Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to Manage Cycle count Page", "", "", "Navigation to Manage Cycle count page should be displayed", "Navigation to Manage Cycle count Page Is Not displayed", "Failed", "", true );
				Assert.fail("Navigation to Manage Cycle count Page is not displayed");
			}
			if(cmnLib.waitForElementToBeVisible(invMan.ExpandAdvancedSearch))
				cmnLib.clickOnWebElement(invMan.ExpandAdvancedSearch);
			cmnLib.enterDataInTextBox(invMan.CountName, exl.read(strDataSheetName, dataRow, "CountName"), true);
			cmnLib.clickOnWebElement(invMan.SearchBtn);
			
			
			if(cmnLib.waitForElementToBeVisible(invMan.NoResultFound, 5))
			{
				rpt.generateReport("", "Count Name search", "", exl.read(strDataSheetName, dataRow, "CountName"), "Count name search result should appear", "Count Name search result not found", "Failed", "", true );
				Assert.fail("Count Name search result not found");
			}else{
				rpt.generateReport("", "Count Name search", "", exl.read(strDataSheetName, dataRow, "CountName"), "Count name search result should appear", "Count Name search result found", "Passed", "", true );
			}
			
			cmnLib.clickOnWebElement(invMan.ActionsBtn);
			TimeUnit.SECONDS.sleep(2);
			cmnLib.clickOnWebElement(invMan.GenerateCountSequences);
			String  strProcessID1=null;
			if (cmnLib.waitForElementToBeVisible(invMan.InformationWindow)
					&& invMan.ConfirmationMsg.getText() != null) {
				String strMessage = invMan.ConfirmationMsg.getText();
				System.out.println(strMessage);
				strProcessID1 = strMessage.split(" ")[2];
				System.out.println("strProcessID for report 2 "+strProcessID1);
				rpt.generateReport("", "Verify Process submitted message in Confirmation window", "", "",
						"Process submitted message must appear", "Message appears: " + strMessage, "Passed", "", true);
			} else {
				rpt.generateReport("", "Verify Process submitted message in Confirmation window", "", "",
						"Process submitted message must appear", "Message did not appear", "Failed", "", true);
				Assert.fail("Failed to verify Process submitted message");
			}
			cmnLib.clickOnWebElement(invMan.ConfirmationWinOKBtn);
			
			//Navigating to Scheduled Processes
			homePage_SCM.clickOnNavigationIcon();
			TimeUnit.SECONDS.sleep(5);
			homePage_SCM.clickOnScheduledProcesses();
			
			
			//Checking the Report Status
			//ScheduledProcesses scheduledProcesses = new ScheduledProcesses();
			rpt.enterStepHeader("Verify Report status");
			strReportName=exl.read(strDataSheetName, dataRow, "Report_Name2");
			strStatus = scheduledProcesses.verifyReportStatus(strProcessID1, strReportName);
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
				Assert.fail("Failed to verify report status");
			}
/******************************************************************Record Count Sequences********************************************************************************/
			//Verify Presence of Navigator Icon
			if(homePage_SCM.NavigatorIcon.isDisplayed() == false)
			{
				//FAIL
				rpt.generateReport("", "Validate HomePage", "", "", "Validation Should be successful", "Validation Is Not Successful", "Failed", "", true );
				Assert.fail("Login Un-Successful");
			}
			TimeUnit.SECONDS.sleep(5);
		//Click on Navigator Icon
			homePage_SCM.clickOnNavigationIcon();
			TimeUnit.SECONDS.sleep(5);
			
		//Click On Work Definition from Navigator Links
			homePage_SCM.clickOnInventoryManagement();
			TimeUnit.SECONDS.sleep(5);
			cmnLib.waitForPageLoaded();

		//Verify Inventory Management page is displayed
			rpt.enterStepHeader("Inventory Management page verification");
			if(cmnLib.waitForElementToBeVisible(invMan.InventoryManagementHeader,10))
			{
				rpt.generateReport("", "Navigation to Inventory Management Page", "", "", "Navigation to Inventory Management Page should be displayed", "Navigation to Inventory Management Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to Inventory Management Page", "", "", "Navigation to Inventory Management should be displayed", "Navigation to Inventory Management Page Is Not displayed", "Failed", "", true );
				Assert.fail("Navigation to Inventory Management Page is not displayed");
			}
		//Selecting the Tasks
			rpt.enterStepHeader("Selecting the Tasks");
			
			if(invMan.TasksIcon.isEnabled())
			{
				cmnLib.clickOnWebElement(invMan.TasksIcon);
				rpt.generateReport("", "Selecting the Tasks", "", "", "Tasks must be selected", "Tasks is selected", "Passed", "", true );
			}else {
				
				rpt.generateReport("", "Selecting the Tasks", "", "", "Tasks must be selected", "Tasks are not selected", "Failed", "", true );
				Assert.fail("Tasks are not selected");
			}
			cmnLib.waitForElementToBeVisible(invMan.TasksSelctionDropdown, 40);
			
			if(!cmnLib.selectDropdownBy(invMan.TasksSelctionDropdown, exl.read(strDataSheetName, dataRow, "TasksSelctionDropdown"), DropDownSelectBy.VisibleText))
			{
				rpt.generateReport("", "Selecting the Tasks", "", exl.read(strDataSheetName, dataRow, "TasksSelctionDropdown"), "Task dropdown should be selected", "Task dropdown is not selected", "Failed", "", true );
				Assert.fail("Task dropdown is not selected");
			}
			
			cmnLib.waitForElementToBeVisible(invMan.ManageCycleCounts, 10);
			if(cmnLib.clickOnWebElement(invMan.ManageCycleCounts))
			{
				rpt.generateReport("", "Selecting the Tasks", "", "Manage Cycle Counts", "Tasks must be selected", "Tasks is selected", "Passed", "", true );
			}else {
				
				rpt.generateReport("", "Selecting the Tasks", "", "Manage Cycle Counts", "Tasks must be selected", "Tasks are not selected", "Failed", "", true );
				Assert.fail("Tasks are not selected");
			}
			if(cmnLib.waitForElementToBeVisible(invMan.SelectOrgWindow, 10))
			{
				cmnLib.enterDataInTextBox(invMan.Org, exl.read(strDataSheetName, dataRow, "Organization"), true);
				rpt.generateReport("", "Selecting the Organization", "", exl.read(strDataSheetName, dataRow, "Organization"), "Organization must be selected", "Organization is selected", "Passed", "", true );
				cmnLib.clickOnWebElement(invMan.OrgWindowOKBtn);
			}
			
		//Verifying Manage Cycle count page 
			
			// Record Count Sequences
			rpt.enterStepHeader("Verifying Manage Cycle count page");
			if(cmnLib.waitForElementToBeVisible(invMan.ManageCycleCountsPageHeader))
			{
				rpt.generateReport("", "Navigation to Manage Cycle count Page", "", "", "Navigation to ManageCycle count Page should be displayed", "Navigation to Manage Cycle count Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to Manage Cycle count Page", "", "", "Navigation to Manage Cycle count page should be displayed", "Navigation to Manage Cycle count Page Is Not displayed", "Failed", "", true );
				Assert.fail("Navigation to Manage Cycle count Page is not displayed");
			}
			if(cmnLib.waitForElementToBeVisible(invMan.ExpandAdvancedSearch))
				cmnLib.clickOnWebElement(invMan.ExpandAdvancedSearch);
			cmnLib.enterDataInTextBox(invMan.CountName, exl.read(strDataSheetName, dataRow, "CountName"), true);
			cmnLib.clickOnWebElement(invMan.SearchBtn);
			
			
			if(cmnLib.waitForElementToBeVisible(invMan.NoResultFound, 5))
			{
				rpt.generateReport("", "Count Name search", "", exl.read(strDataSheetName, dataRow, "CountName"), "Count name search result should appear", "Count Name search result not found", "Failed", "", true );
				Assert.fail("Count Name search result not found");
			}else{
				rpt.generateReport("", "Count Name search", "", exl.read(strDataSheetName, dataRow, "CountName"), "Count name search result should appear", "Count Name search result found", "Passed", "", true );
			}
			
			cmnLib.clickOnWebElement(invMan.ActionsBtn);
			TimeUnit.SECONDS.sleep(2);
			cmnLib.clickOnWebElement(invMan.RecordCountSequences);
			  strProcessID=null;	
			  
			if(cmnLib.waitForElementToBeVisible(invMan.RecordCountSequencesPageHeader, 20))
			{
				rpt.generateReport("", "Navigation to Record Count Sequences Page", "", "", "Navigation to Record Count Sequences Page should be displayed", "Navigation to Record Count Sequences Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to Record Count Sequences Page", "", "", "Navigation to Record Count Sequences page should be displayed", "Navigation to Record Count Sequences Page Is Not displayed", "Failed", "", true );
				Assert.fail("Navigation to Record Count Sequences Page is not displayed");
			}
			if(cmnLib.waitForElementToBeVisible(invMan.NoResultFoundRecordCountPage, 15))
			{
				rpt.generateReport("", "Record Count search", "", exl.read(strDataSheetName, dataRow, "CountName"), "Record Count search result should appear", "Record Count search result not found", "Failed", "", true );
				Assert.fail("Record Count search result not found");
			}else{
				rpt.generateReport("", "Record Count search", "", exl.read(strDataSheetName, dataRow, "CountName"), "Record Count search result should appear", "Record Count search result found", "Passed", "", true );
			}
			
			cmnLib.enterDataInTextBox(invMan.CountQty, exl.read(strDataSheetName, dataRow, "CountQty"), true);
			cmnLib.enterDataInTextBox(invMan.CountedBy, exl.read(strDataSheetName, dataRow, "CountedBy"), true);
			
			rpt.generateReport("", "Record Count Sequence", "", "", "All mandatory fields must be entered", "All mandatory fields are entered", "Passed", "", true );
			cmnLib.clickOnWebElement(invMan.SubmitBtn);
			
			if (cmnLib.waitForElementToBeVisible(invMan.InformationWindow)
					&& invMan.ConfirmationMsg.getText() != null) {
				String strMessage = invMan.ConfirmationMsg.getText();
				System.out.println(strMessage);
				rpt.generateReport("", "Verify Process submitted message in Confirmation window", "", "",
						"Process submitted message must appear", "Message appears: " + strMessage, "Passed", "", true);
			} else {
				rpt.generateReport("", "Verify Process submitted message in Confirmation window", "", "",
						"Process submitted message must appear", "Message did not appear", "Failed", "", true);
				Assert.fail("Failed to verify Process submitted message");
			}
			cmnLib.clickOnWebElement(invMan.ConfirmationWinOKBtn);
			
			
/**********************************************************************Approval Cycle Count***************************************************************************/
			
			if(cmnLib.waitForElementToBeVisible(invMan.ManageCycleCountsPageHeader))
			{
				rpt.generateReport("", "Navigation to Manage Cycle count Page", "", "", "Navigation to ManageCycle count Page should be displayed", "Navigation to Manage Cycle count Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to Manage Cycle count Page", "", "", "Navigation to Manage Cycle count page should be displayed", "Navigation to Manage Cycle count Page Is Not displayed", "Failed", "", true );
				Assert.fail("Navigation to Manage Cycle count Page is not displayed");
			}
			
			cmnLib.enterDataInTextBox(invMan.CountName, exl.read(strDataSheetName, dataRow, "CountName"), true);
			cmnLib.clickOnWebElement(invMan.SearchBtn);
			
			if(cmnLib.waitForElementToBeVisible(invMan.NoResultFound, 15))
			{
				rpt.generateReport("", "Count Name search", "", exl.read(strDataSheetName, dataRow, "CountName"), "Count name search result should appear", "Count Name search result not found", "Failed", "", true );
				Assert.fail("Count Name search result not found");
			}else{
				rpt.generateReport("", "Count Name search", "", exl.read(strDataSheetName, dataRow, "CountName"), "Count name search result should appear", "Count Name search result found", "Passed", "", true );
			}
			
			cmnLib.clickOnWebElement(invMan.ActionsBtn);
			TimeUnit.SECONDS.sleep(2);
			cmnLib.clickOnWebElement(invMan.ApproveCountSequences);
			  strProcessID=null;	
			  
			if(cmnLib.waitForElementToBeVisible(invMan.ApproveCountSequencesPageHeader, 20))
			{
				rpt.generateReport("", "Navigation to Approve Count Sequences Page", "", "", "Navigation to Approve Count Sequences Page should be displayed", "Navigation to Approve Count Sequences Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to Approve Count Sequences Page", "", "", "Navigation to Approve Count Sequences page should be displayed", "Navigation to Approve Count Sequences Page Is Not displayed", "Failed", "", true );
				Assert.fail("Navigation to Approve Count Sequences Page is not displayed");
			}
			if(cmnLib.waitForElementToBeVisible(invMan.NoResultFoundRecordCountPage, 15))
			{
				rpt.generateReport("", "Record Count search", "", exl.read(strDataSheetName, dataRow, "CountName"), "Record Count search result should appear", "Record Count search result not found", "Failed", "", true );
				Assert.fail("Record Count search result not found");
			}else{
				rpt.generateReport("", "Record Count search", "", exl.read(strDataSheetName, dataRow, "CountName"), "Record Count search result should appear", "Record Count search result found", "Passed", "", true );
			}
			
			cmnLib.enterDataInTextBox(invMan.ReviewedBy, exl.read(strDataSheetName, dataRow, "ReviewedBy"), true);
			rpt.generateReport("", "Approve Count Sequences", "", "", "Approve Count Sequences status before approve", "Approve Count Sequences status before approve", "Passed", "", true );
			
			cmnLib.clickOnWebElement(invMan.ApproveBtn);
			TimeUnit.SECONDS.sleep(5);
			
			String CountSequenceStatus = invMan.CountSequenceStatus.getText();
			
			if(CountSequenceStatus.equalsIgnoreCase("Approved, not submitted"))
			{
				rpt.generateReport("", "Approve Count Sequences", "", "", "Approve Count Sequences status should change", "Approve Count Sequences status changed to "+CountSequenceStatus+"", "Passed", "", true );
			}else{
				rpt.generateReport("", "Approve Count Sequences", "", "", "Approve Count Sequences status should change", "Approve Count Sequences status has not changed", "Failed", "", true );
				Assert.fail("Approve Count Sequences status has not changed");
			}
			
			cmnLib.clickOnWebElement(invMan.SubmitBtn);
			if (cmnLib.waitForElementToBeVisible(invMan.InformationWindow)
					&& invMan.ConfirmationMsg.getText() != null) {
				String strMessage = invMan.ConfirmationMsg.getText();
				System.out.println(strMessage);
				rpt.generateReport("", "Verify Process submitted message in Confirmation window", "", "",
						"Process submitted message must appear", "Message appears: " + strMessage, "Passed", "", true);
			} else {
				rpt.generateReport("", "Verify Process submitted message in Confirmation window", "", "",
						"Process submitted message must appear", "Message did not appear", "Failed", "", true);
				Assert.fail("Failed to verify Process submitted message");
			}
			cmnLib.clickOnWebElement(invMan.ConfirmationWinOKBtn);
		}
	}



}
