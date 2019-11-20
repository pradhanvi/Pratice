package com.testcases;

/**
Script Name			: SCM_CHILE_MFG_006_Manage_Operation_Items
Script Description	: Manage Operation Items
Track/Module		: SCM
Sub Track			: 
Created By			: Pradhanvi T R
Creation Date		: 13-Mar-2019
Modified By 		:
Modification Date	:
Instance Name & URL : https://edyg-dev4.fa.us2.oraclecloud.com/homePage/faces/FuseWelcome
User ID/ Password	: 10013865/Bimbo123
Responsibility		:
Pre-Requisites		: Valid Item should be given.
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
import scm.pagefactory.ManageStandardOperations;
import scm.pagefactory.ManageWorkDefinition;
import scm.pagefactory.WorkDefinition;
import xlsx.databank.ofs.ExcelOperations;

public class SCM_CHILE_MFG_006_Manage_Operation_Items extends TestBase{
	String strModule = "SCM";
	@Test
	public void SCM_CHILE_MFG_006_Manage_Operation_Items() throws Throwable {
		rpt = new ReportGeneration("SCM_CHILE_MFG_006_Manage_Operation_Items", "Manage Operation Items");

		String strDataSheetName = "MFG_006";
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
			rpt.generateReport("SCM_CHILE_MFG_006_Manage_Operation_Items", "Enter URL", "", "Password: "+hashmap.get("URL_"+strModule), "URL should be entered", "URL is entered", "Info", "", false );
			rpt.generateReport("", "Enter User Name", "", "UserName: "+hashmap.get("UserName_"+strModule), "UserName should be entered", "UserName is entered", "Info", "", false );
			rpt.generateReport("", "Enter Password", "", "Password: "+hashmap.get("Password_"+strModule), "Password should be entered", "Password is entered", "Info", "", false );
			rpt.generateReport("", "Validate Login to Appication", "", "", "Login Should be successful", "Login Is Successful", "Passed", "", false );
		}else
		{
			//FAIL
			rpt.generateReport("SCM_CHILE_MFG_006_Manage_Operation_Items", "Login to Appication", "", "UserName: "+exl.read("LoginDetails", 1, "UserName"), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
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
			/*if(cmnLib.waitForElementToBeVisible(workDefinition.SelectOrganizationPopUp))
			{
				cmnLib.clickOnWebElement(workDefinition.Cancel_SelectOrganizationPopUp);
			}*/
			cmnLib.clickOnWebElement(workDefinition.ChangeOrganizationButton);
			TimeUnit.SECONDS.sleep(2);
			cmnLib.enterDataInTextBox(workDefinition.OrganizationPopUp, exl.read(strDataSheetName, dataRow, "Organization"), true);
			TimeUnit.SECONDS.sleep(3);
			rpt.generateReport("", "Selecting the Organization", "", "", "Organization must be selected", "Organization is selected", "Passed", "", true );
			cmnLib.clickOnWebElement(workDefinition.SelectOrganizationWindowOKButton);
			
		//Selecting the Tasks
			rpt.enterStepHeader("Selecting the Tasks");
			TimeUnit.SECONDS.sleep(5);
			if(workDefinition.TasksIcon.isEnabled())
			{
				cmnLib.clickOnWebElement(workDefinition.TasksIcon);
				rpt.generateReport("", "Selecting the Tasks", "", "", "Tasks must be selected", "Tasks is selected", "Passed", "", true );
				workDefinition.clickOnManageWorkDefinition();
			}else {
				
				rpt.generateReport("", "Selecting the Tasks", "", "", "Tasks must be selected", "Tasks are not selected", "Failed", "", true );
				Assert.fail("Taks are not selected");
			}
			
		//Verifying Manage Standard Operations page
			rpt.enterStepHeader("Verifying Manage Standard Operations page");
			ManageWorkDefinition manageWorkDefinition =  new ManageWorkDefinition();
			TimeUnit.SECONDS.sleep(5);
			if(cmnLib.waitForElementToBeVisible(manageWorkDefinition.Item_Search))
			{
				rpt.generateReport("", "Navigation to Manage Work Definition Page", "", "", "Navigation to Manage Work Definition Page should be displayed", "Navigation to Manage Work Definition Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to Manage Work Definition Page", "", "", "Navigation to Manage Work Definition page should be displayed", "Navigation to Manage Work Definition Page Is Not displayed", "Failed", "", true );
				Assert.fail("Navigation to Manage Work Definition is not displayed");
			}
			
		//Searching for an Item
			rpt.enterStepHeader("Searching for an Item");
			cmnLib.enterDataInTextBox(manageWorkDefinition.Item_Search, exl.read(strDataSheetName, dataRow, "Item"), true);
			cmnLib.clickOnWebElement(manageWorkDefinition.SearchButton);
			TimeUnit.SECONDS.sleep(2);
			
			if(manageWorkDefinition.verifySearchedRecordExists(exl.read(strDataSheetName, dataRow, "Item")))
			{
				rpt.generateReport("", "Searching an Item", "", "", "Item must be found in Search Results", "Item found in Search Results", "Passed", "", true );
			}else {
				rpt.generateReport("", "Searching an Item", "", "", "Item must be found in Search Results", "Item NOT found in Search Results", "Failed", "", true );
				Assert.fail("Item NOT found in Search Results");
			}
			
		//Selecting the item
			TimeUnit.SECONDS.sleep(3);
			if(manageWorkDefinition.selectingItem(exl.read(strDataSheetName, dataRow, "Item")))
			{
				TimeUnit.SECONDS.sleep(5);
				if(cmnLib.waitForElementToBeVisible(manageWorkDefinition.ManageWorkDefinitionHeader))
				{
					rpt.generateReport("", "Navigation to Manage Work Definition Page", "", "", "Must be Able to Edit the page ", "Able to Edit the page", "Passed", "", true );

				}else
				{
					//FAIL
					rpt.generateReport("", "Navigation to Manage Work Definition Page", "", "", "Must be Able to Edit the page ", "Not Able to Edit the page", "Failed", "", true );
					Assert.fail("Not Able to Edit the page");
				}
			}
			
			
			
		}
	}

}
