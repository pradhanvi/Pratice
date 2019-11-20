package com.testcases;

/**
Script Name			: SCM_CHILE_MFG_014_Manage_Nonstandard_Work_Orders
Script Description	: Manage Non Standard Work Orders
Track/Module		: SCM
Sub Track			: 
Created By			: Pradhanvi T R
Creation Date		: 14-Mar-2019
Modified By 		:
Modification Date	:
Instance Name & URL : https://edyg-dev4.fa.us2.oraclecloud.com/homePage/faces/FuseWelcome
User ID/ Password	: 10013865/Bimbo123
Responsibility		:
Pre-Requisites		: 
Comments (if any)	:
 **/

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.commons.Common_Library.DropDownSelectBy;
import com.commons.TestBase;

import report.oracle.ofs.ReportGeneration;
import scm.pagefactory.HomePage_SCM;
import scm.pagefactory.LoginPage_SCM;
import scm.pagefactory.ManageWorkOrders;
import scm.pagefactory.WorkExecution;
import xlsx.databank.ofs.ExcelOperations;

public class SCM_CHILE_MFG_014_Manage_Nonstandard_Work_Orders extends TestBase{

	String strModule = "SCM";
	@Test
	public void SCM_CHILE_MFG_014_Manage_Nonstandard_Work_Orders() throws Throwable {
		rpt = new ReportGeneration("SCM_CHILE_MFG_014_Manage_Nonstandard_Work_Orders", "Manage Non Standard Work Orders");

		String strDataSheetName = "MFG_014";
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
			rpt.generateReport("SCM_CHILE_MFG_014_Manage_Nonstandard_Work_Orders", "Enter URL", "", "Password: "+hashmap.get("URL_"+strModule), "URL should be entered", "URL is entered", "Info", "", false );
			rpt.generateReport("", "Enter User Name", "", "UserName: "+hashmap.get("UserName_"+strModule), "UserName should be entered", "UserName is entered", "Info", "", false );
			rpt.generateReport("", "Enter Password", "", "Password: "+hashmap.get("Password_"+strModule), "Password should be entered", "Password is entered", "Info", "", false );
			rpt.generateReport("", "Validate Login to Appication", "", "", "Login Should be successful", "Login Is Successful", "Passed", "", false );
		}else
		{
			//FAIL
			rpt.generateReport("SCM_CHILE_MFG_014_Manage_Nonstandard_Work_Orders", "Login to Appication", "", "UserName: "+exl.read("LoginDetails", 1, "UserName"), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
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
			
		//Click On Work Execution from Navigator Links
			 WorkExecution workExecution = homePage_SCM.clickOnWorkExecution();
			TimeUnit.SECONDS.sleep(5);
			cmnLib.waitForPageLoaded();

		//Verify Work Definition page is displayed
			rpt.enterStepHeader("Work Definition page verification");
			if(workExecution.WorkOrdersHeader.isDisplayed())
			{
				rpt.generateReport("", "Navigation to Work Execution Page", "", "", "Navigation to Work Execution Page should be displayed", "Navigation to Work Execution Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to Work Execution Page", "", "", "Navigation to Work Execution should be displayed", "Navigation to Work Execution Page Is Not displayed", "Failed", "", true );
				Assert.fail("Navigation to Work Execution Page is not displayed");
			}
		//Selecting the Organization
			rpt.enterStepHeader("Selecting the Organization");
			cmnLib.waitForElementToBeClickable(workExecution.TasksIcon);
			/*if(cmnLib.waitForElementToBeVisible(workDefinition.SelectOrganizationPopUp))
			{
				cmnLib.clickOnWebElement(workDefinition.Cancel_SelectOrganizationPopUp);
			}*/
			cmnLib.clickOnWebElement(workExecution.ChangeOrganizationButton);
			TimeUnit.SECONDS.sleep(2);
			cmnLib.enterDataInTextBox(workExecution.OrganizationPopup, exl.read(strDataSheetName, dataRow, "Organization"), true);
			TimeUnit.SECONDS.sleep(2);
			rpt.generateReport("", "Selecting the Organization", "", "", "Organization must be selected", "Organization is selected", "Passed", "", true );
			cmnLib.clickOnWebElement(workExecution.SelectOrganizationWindowOKButton);
			
		//Selecting the Tasks
			rpt.enterStepHeader("Selecting the Tasks");
			TimeUnit.SECONDS.sleep(2);
			if(workExecution.TasksIcon.isEnabled())
			{
				cmnLib.clickOnWebElement(workExecution.TasksIcon);
				rpt.generateReport("", "Selecting the Tasks", "", "", "Tasks must be selected", "Tasks is selected", "Passed", "", true );
				workExecution.clickOnManageWorkOrders();
			}else {
				
				rpt.generateReport("", "Selecting the Tasks", "", "", "Tasks must be selected", "Tasks are not selected", "Failed", "", true );
				Assert.fail("Taks are not selected");
			}
			
		//Verifying Manage Work Order page
			rpt.enterStepHeader("Verifying Manage Work Order page");
			ManageWorkOrders manageWorkOrders = new ManageWorkOrders();
			TimeUnit.SECONDS.sleep(2);
			if(cmnLib.waitForElementToBeVisible(manageWorkOrders.AddNewWorderOrderDropdown))
			{
				rpt.generateReport("", "Navigation to Manage Work Order Page", "", "", "Navigation to Manage Work Order Page should be displayed", "Navigation to Manage Work Order Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to Manage Work Order Page", "", "", "Navigation to Manage Work Order page  should be displayed", "Navigation to Manage Work Order Page Is Not displayed", "Failed", "", true );
				Assert.fail("Navigation to Manage Work Order Page is not displayed");
			}
			
		//Adding New Non Standard Work Order
			rpt.enterStepHeader("Adding New Non Standard Work Order");
			cmnLib.clickOnWebElement(manageWorkOrders.AddNewWorderOrderDropdown);
			cmnLib.clickOnWebElement(manageWorkOrders.CreateNonStandardWorkOrdersLink);
			TimeUnit.SECONDS.sleep(2);
			if(cmnLib.waitForElementToBeVisible(manageWorkOrders.Item_NonStandard))
			{
				cmnLib.enterDataInTextBox(manageWorkOrders.Item_NonStandard, exl.read(strDataSheetName, dataRow, "Item"), true);
				TimeUnit.SECONDS.sleep(1);
				cmnLib.enterDataInTextBox(manageWorkOrders.Quantity_NonStandard, exl.read(strDataSheetName, dataRow, "Quantity"), true);
				cmnLib.selectDropdownBy(manageWorkOrders.Status_NonStandard, exl.read(strDataSheetName, dataRow, "Status"), DropDownSelectBy.VisibleText);
				rpt.generateReport("", "Create Non Standard Work Order", "", "", "Non Standard work order details must be entered", "Non Standard work order details are entered", "Passed", "", true );
				cmnLib.clickOnWebElement(manageWorkOrders.SaveEditButton_WorkOrder);
			}else {
				rpt.generateReport("", "Create Non Standard Work Order", "", "", "Create Non Standard Work Order window must appear", "Create Non Standard Work Order window did not appear", "Failed", "", true );
				Assert.fail("Create Non Standard Work Order window did not appear");
			}
			
			if(cmnLib.waitForElementToBeVisible(manageWorkOrders.WorkOrderGenralInfoTab))
			{
				cmnLib.clickOnWebElement(manageWorkOrders.WorkOrderGenralInfoTab);
				rpt.generateReport("", "Create Non Standard Work Order", "", "", "General information tab must appear", "General information tab appeared", "Passed", "", true );
				cmnLib.clickOnWebElement(manageWorkOrders.WorkOrderOperationsTab);
				TimeUnit.SECONDS.sleep(2);
				rpt.generateReport("", "Create Non Standard Work Order", "", "", "Opeartions tab must appear", "Opeartions tab appeared", "Passed", "", true );
				
				cmnLib.clickOnWebElement(manageWorkOrders.SaveCloseButton_WorkOrder);
			}else {
				rpt.generateReport("", "Create Non Standard Work Order", "", "", "Work Order details must appear", "Work Order details did not appear", "Failed", "", true );
				Assert.fail("Work Order details did not appear");
			}
		//Verifying Confirmation message
			rpt.enterStepHeader("Verifying Confirmation message");
			TimeUnit.SECONDS.sleep(4);
			if(manageWorkOrders.ConfirmationTD.isDisplayed())
			{
				if(manageWorkOrders.ConfirmationMessage.getText().contains("updated"))
				{
					rpt.generateReport("", "Non Standard Work Order", "", "", "Non Standard work order must be created successfully", "Non Standard work order created successfully", "Passed", "", true );
				}else {
					rpt.generateReport("", "Non Standard Work Order", "", "", "Non Standard work order must be created successfully", "Non Standard work order was not created successfully", "Failed", "", true );
					Assert.fail("Non Standard work order was not created successfully");
				}
			}else {
				rpt.generateReport("", "Non Standard Work Order", "", "", "Non Standard work order must be created successfully", "Non Standard work order was not created successfully", "Failed", "", true );
				Assert.fail("Non Standard work order was not created successfully");
			}
			
		}
	
	}
	



}
