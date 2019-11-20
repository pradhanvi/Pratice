package com.testcases;
/**
Script Name			: SCM_CHILE_MFG_003_Manage_Work_Centers
Script Description	: Manage Work Centers
Track/Module		: SCM
Sub Track			: 
Created By			: Pradhanvi T R
Creation Date		: 11-Mar-2019
Modified By 		:
Modification Date	:
Instance Name & URL : https://edyg-dev4.fa.us2.oraclecloud.com/homePage/faces/FuseWelcome
User ID/ Password	: 10013865/Bimbo123
Responsibility		:
Pre-Requisites		: Work Center name and code must be unique.Valid WorkArea must be selected.
Comments (if any)	:
 **/

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.commons.TestBase;

import report.oracle.ofs.ReportGeneration;
import scm.pagefactory.HomePage_SCM;
import scm.pagefactory.LoginPage_SCM;
import scm.pagefactory.ManageWorkArea;
import scm.pagefactory.ManageWorkCenters;
import scm.pagefactory.WorkDefinition;
import xlsx.databank.ofs.ExcelOperations;

public class SCM_CHILE_MFG_003_Manage_Work_Centers extends TestBase{
	
	String strModule = "SCM";
	@Test
	public void SCM_CHILE_MFG_003_Manage_Work_Centers() throws Throwable {
		rpt = new ReportGeneration("SCM_CHILE_MFG_003_Manage_Work_Centers", "Manage Work Centers");

		String strDataSheetName = "MFG_003";
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
			rpt.generateReport("SCM_CHILE_MFG_003_Manage_Work_Centers", "Enter URL", "", "Password: "+hashmap.get("URL_"+strModule), "URL should be entered", "URL is entered", "Info", "", false );
			rpt.generateReport("", "Enter User Name", "", "UserName: "+hashmap.get("UserName_"+strModule), "UserName should be entered", "UserName is entered", "Info", "", false );
			rpt.generateReport("", "Enter Password", "", "Password: "+hashmap.get("Password_"+strModule), "Password should be entered", "Password is entered", "Info", "", false );
			rpt.generateReport("", "Validate Login to Appication", "", "", "Login Should be successful", "Login Is Successful", "Passed", "", false );
		}else
		{
			//FAIL
			rpt.generateReport("SCM_CHILE_MFG_003_Manage_Work_Centers", "Login to Appication", "", "UserName: "+exl.read("LoginDetails", 1, "UserName"), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
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
			 WorkDefinition workDefinition = homePage_SCM.clickOnWorkDefinition();
			TimeUnit.SECONDS.sleep(5);
			cmnLib.waitForPageLoaded();

		//Verify Work Definition page is displayed
			rpt.enterStepHeader("Work Definition page verification");
			if(workDefinition.WorkDefinitionHeader.isDisplayed())
			{
				rpt.generateReport("", "Navigation to Work Definition Page", "", "", "Navigation to Work Definition Page should be displayed", "Navigation to Work Definition Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to Work Definition Page", "", "", "Navigation to Work Definition should be displayed", "Navigation to Work Definition Page Is Not displayed", "Failed", "", true );
				Assert.fail("Navigation to Work Definition Page is not displayed");
			}
		//Selecting the Organization
			rpt.enterStepHeader("Selecting the Organization");
			cmnLib.waitForElementToBeClickable(workDefinition.TasksIcon);
			/*if(workDefinition.SelectOrganizationPopUp.isDisplayed())
			{
				cmnLib.enterDataInTextBox(workDefinition.OrganizationPopUp, exl.read(strDataSheetName, dataRow, "Organization"), true);
				rpt.generateReport("", "Selecting the Organization", "", "", "Organization must be selected", "Organization is selected", "Passed", "", true );
				cmnLib.clickOnWebElement(workDefinition.SelectOrganizationWindowOKButton);
			}else {*/
				cmnLib.clickOnWebElement(workDefinition.ChangeOrganizationButton);
				TimeUnit.SECONDS.sleep(2);
				cmnLib.enterDataInTextBox(workDefinition.OrganizationPopUp, exl.read(strDataSheetName, dataRow, "Organization"), true);
				TimeUnit.SECONDS.sleep(3);
				rpt.generateReport("", "Selecting the Organization", "", "", "Organization must be selected", "Organization is selected", "Passed", "", true );
				cmnLib.clickOnWebElement(workDefinition.SelectOrganizationWindowOKButton);
			/*}*/
		//Selecting the Tasks
			rpt.enterStepHeader("Selecting the Tasks");
			
			if(workDefinition.TasksIcon.isEnabled())
			{
				cmnLib.clickOnWebElement(workDefinition.TasksIcon);
				rpt.generateReport("", "Selecting the Tasks", "", "", "Tasks must be selected", "Tasks is selected", "Passed", "", true );
				workDefinition.clickOnManageWorkCentersArea();
			}else {
				
				rpt.generateReport("", "Selecting the Tasks", "", "", "Tasks must be selected", "Tasks are not selected", "Failed", "", true );
				Assert.fail("Taks are not selected");
			}
			
		//Verifying Manage Work Centers page
			rpt.enterStepHeader("Verifying Manage Work Centers page");
			ManageWorkCenters manageWorkCentersArea =  new ManageWorkCenters();
			TimeUnit.SECONDS.sleep(5);
			if(cmnLib.waitForElementToBeVisible(manageWorkCentersArea.AddManageWorkCenters))
			{
				rpt.generateReport("", "Navigation to Manage Work Centers page Page", "", "", "Navigation to Manage Work Centers page Page should be displayed", "Navigation to Manage Work Centers page Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to Manage Work Centers page Page", "", "", "Navigation to Manage Work Centers page should be displayed", "Navigation to Manage Work Centers page Page Is Not displayed", "Failed", "", true );
				Assert.fail("Navigation to Manage Work Centers page Page is not displayed");
			}
		//Add New Manage Work Centers page
			rpt.enterStepHeader("Add New Manage Work Centers page");
			cmnLib.clickOnWebElement(manageWorkCentersArea.AddManageWorkCenters);
			//cmnLib.waitForElementToBeVisible(manageWorkCentersArea.CreateWorkCenterHeader);
			if(cmnLib.waitForElementToBeVisible(manageWorkCentersArea.WorkCenters_Name))
			{
				cmnLib.enterDataInTextBox(manageWorkCentersArea.WorkCenters_Name, exl.read(strDataSheetName, dataRow, "WorkCenters_Name"), true);
				cmnLib.enterDataInTextBox(manageWorkCentersArea.WorkCenters_Code, exl.read(strDataSheetName, dataRow, "WorkCenters_Code"), true);
				cmnLib.enterDataInTextBox(manageWorkCentersArea.WorkCenters_WorkArea, exl.read(strDataSheetName, dataRow, "WorkCenters_WorkArea"), true);
				
				cmnLib.clickOnWebElement(manageWorkCentersArea.AddResourceAvailability);
				TimeUnit.SECONDS.sleep(2);
				
				cmnLib.enterDataInTextBox(manageWorkCentersArea.Resource_Name, exl.read(strDataSheetName, dataRow, "Resource_Name"), true);
				cmnLib.enterDataInTextBox(manageWorkCentersArea.DefaultUnitsAvailable, exl.read(strDataSheetName, dataRow, "DefaultUnitsAvailable"), true);
				cmnLib.enterDataInTextBox(manageWorkCentersArea.Planning_Utilization, exl.read(strDataSheetName, dataRow, "Planning_Utilization"), true);
				cmnLib.enterDataInTextBox(manageWorkCentersArea.Planning_Efficiency, exl.read(strDataSheetName, dataRow, "Planning_Efficiency"), true);
				rpt.generateReport("", "Adding New Resource availability", "", "", "Resource availability window must appear", "Resource availability window appeared", "Passed", "", true );
				cmnLib.clickOnWebElement(manageWorkCentersArea.OKButton_WorkCentersResource);
				
				rpt.generateReport("", "Adding New Work Centers", "", "", "Work Centers data must be added", "Work Centers data is added", "Passed", "", true );
				cmnLib.clickOnWebElement(manageWorkCentersArea.Save_WorkCenters);
				
				TimeUnit.SECONDS.sleep(2);
			}else {
				
				rpt.generateReport("", "Adding New Work Centers", "", "", "Work Centers data must be added", "Work Centers data is not added", "Failed", "", true );
				Assert.fail("New Work Centers windows didn't open");
			}	
			
	//Verifying the creation of New Work Center
			rpt.enterStepHeader("Verifying the creation of New Work Center");
			TimeUnit.SECONDS.sleep(2);
			cmnLib.enterDataInTextBox(manageWorkCentersArea.WorkCenters_SeachName, exl.read(strDataSheetName, dataRow, "WorkCenters_Code"), true);
			cmnLib.clickOnWebElement(manageWorkCentersArea.WorkCenters_SearchButton);
			TimeUnit.SECONDS.sleep(2);
			if(manageWorkCentersArea.verifySearchedRecordExists(exl.read(strDataSheetName, dataRow, "WorkCenters_Name")))
			{
				rpt.generateReport("", "Verifying New Work Center", "", "", "New Work Center must be added", "New Work Center is added", "Passed", "", true );
				TimeUnit.SECONDS.sleep(8);
			}else {
				
				rpt.generateReport("", "Verifying New Work Center", "", "", "New Work Center must be added", "New Work Center is NOT added", "Failed", "", true );
				Assert.fail("New Work Center is NOT added");
				
			}
			
		
		}
		
	}

}
