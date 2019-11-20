package com.testcases;

/**
Script Name			: SCM_CHILE_CST_003_CreateCostScenario
Script Description	: Create Cost Scenario
Track/Module		: SCM
Sub Track			: 
Created By			: Pradhanvi T R
Creation Date		: 26-Feb-2019
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
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.commons.Common_Library.DropDownSelectBy;
import com.commons.TestBase;

import hcm.pagefactory.HomePage_HCM;
import hcm.pagefactory.LoginPage_HCM;
import hcm.pagefactory.SearchPerson;
import report.oracle.ofs.ReportGeneration;
import scm.pagefactory.CostAccountingPage;
import scm.pagefactory.HomePage_SCM;
import scm.pagefactory.LoginPage_SCM;
import scm.pagefactory.ManageCostScenarious;
import scm.pagefactory.SetupAndMaintenancePage;
import xlsx.databank.ofs.ExcelOperations;

/**
Script Name			: SCM_CHILE_CST_003_CreateCostScenario
Script Description	: Create Cost Scenario
Track/Module		: SCM
Sub Track			: 
Created By			: Pradhanvi T R
Creation Date		: 
Modified By 		: 
Modification Date	: 
Instance Name & URL : https://edyg-dev4.fa.us2.oraclecloud.com/fscmUI/faces/FuseWelcome?
User ID/ Password	: AUTO.SCM_USER/********
Responsibility		: 
Pre-Requisites		: Update test data. Scenario ID should be unique
Comments (if any)	:
 **/

public class SCM_CHILE_CST_003_CreateCostScenario  extends TestBase{
	String strModule = "SCM";
	@Test
	public void SCM_CHILE_CST_003_CreateCostScenario_TC() throws Throwable {
		rpt = new ReportGeneration("SCM_CHILE_CST_003_CreateCostScenario", "Create Cost Scenario");

		String strDataSheetName = "CST_003";
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
						"Username must be entered", "Username entered", "Passed", "", false);
				rpt.generateReport("", "Enter Password", "", "", "Password must be entered", "Password entered",
						"Passed", "", false);
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

		//Initialize HomePage Web Elements

		//Validate HomePage Icon
		if(cmnLib.waitForElementToBeVisible(homePage_SCM.HomePage_HomeIcon) == true)
		{
			homePage_SCM = PageFactory.initElements(driver, HomePage_SCM.class);
			//PASS
			rpt.generateReport("SCM_CHILE_CST_003_CreateCostScenario", "Enter URL", "", "Password: "+hashmap.get("URL_"+strModule), "URL should be entered", "URL is entered", "Info", "", true );
			rpt.generateReport("", "Enter User Name", "", "UserName: "+hashmap.get("UserName_"+strModule), "UserName should be entered", "UserName is entered", "Info", "", true );
			rpt.generateReport("", "Enter Password", "", "Password: "+hashmap.get("Password_"+strModule), "Password should be entered", "Password is entered", "Info", "", true );
			rpt.generateReport("", "Validate Login to Appication", "", "", "Login Should be successful", "Login Is Successful", "Passed", "", true );
		}else
		{
			//FAIL
			rpt.generateReport("SCM_CHILE_CST_003_CreateCostScenario", "Login to Appication", "", "UserName: "+exl.read("LoginDetails", 1, "UserName"), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
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
		//Click on Navigator Icon
			homePage_SCM.clickOnNavigationIcon();
			TimeUnit.SECONDS.sleep(5);
			
		//Click On Cost Accounting from Navigator Links
			CostAccountingPage costAccountingPage = homePage_SCM.clickOnCostAccountingLink();
			TimeUnit.SECONDS.sleep(5);
			cmnLib.waitForPageLoaded();

		//Verify Cost Accounting page is displayed
			if(costAccountingPage.CostAccountingHeader.isDisplayed() == true)
			{
				rpt.generateReport("", "Navigation to Cost Accounting Page", "", "", "Navigation to Cost Accounting Page should be displayed", "Navigation to Cost Accounting Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to Cost Accounting Page", "", "", "Navigation to Cost Accounting Page should be displayed", "Navigation to Cost Accounting Page Is Not displayed", "Failed", "", true );
				Assert.fail("Navigation to Cost Accounting Page is not displayed");
			}

		// Selecting Tasks
			cmnLib.waitForPageLoaded();
			TimeUnit.SECONDS.sleep(30);
			costAccountingPage.clickOnTaksIcon();
			
		//Clicking on Manage Cost Scenarios
			TimeUnit.SECONDS.sleep(5);
			cmnLib.clickOnWebElement(costAccountingPage.ManageCostScenariousLink);
			rpt.generateReport("", "Tasks Icon", "", "Manage Cost Scenarious", "Must click on Manage Cost Scenarious link", "Clicked on Manage Cost Scenarious Link", "Pass", "", true);
			
			
			
		//Verify Manage Cost Scenarios page is displayed
			TimeUnit.SECONDS.sleep(10);
			ManageCostScenarious manageCostScenarious= new ManageCostScenarious();
			if(cmnLib.waitForElementToBeVisible(manageCostScenarious.CreateCostScenarioIcon))
			{
				rpt.generateReport("", "Navigation to Manage Cost Scenario Page", "", "", "Navigation to  Manage Cost Books Page should be displayed", "Navigation to  Manage Cost Scenario Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to  Manage Cost Scenario Page", "", "", "Navigation to  Manage Cost Scenario Page should be displayed", "Navigation to  Manage Cost Scenario Page Is Not displayed", "Failed", "", true );
				Assert.fail("Navigation to  Manage Cost Scenario Page is not displayed");
			}
			
		//Creating new Cost Scenario
			TimeUnit.SECONDS.sleep(5);
			
			if(!cmnLib.clickOnWebElement(manageCostScenarious.CreateCostScenarioIcon))
			{
				rpt.generateReport("", "Click on create button", "", "", "Create Icon should be clickable", "Create Icon is not clickable", "Failed", "", true);
			     Assert.fail("Create Icon is not clickable in Manage Cost Scenarious");
			}
			TimeUnit.SECONDS.sleep(10);
			if(!cmnLib.enterDataInTextBox(manageCostScenarious.ScenarioField, exl.read(strDataSheetName, dataRow, "Scenario"), true))
			{
				rpt.generateReport("", "Enter Scenario field", "", exl.read(strDataSheetName, dataRow, "Scenario"), "Scenario should be entered", "Scenario is not entered", "Failed", "", true);
			     Assert.fail("Scenario field could not be entered in Manage Create Cost Scenario page");
			}
			TimeUnit.SECONDS.sleep(3);
			if(!cmnLib.enterDataInTextBox(manageCostScenarious.CostOrganizationField, exl.read(strDataSheetName, dataRow, "Cost Organization"), true))
			{
				rpt.generateReport("", "Enter Cost Oraganization field", "", exl.read(strDataSheetName, dataRow, "Cost Organization"), "Cost Oraganization should be entered", "Cost Oraganization is not entered", "Failed", "", true);

			}
			TimeUnit.SECONDS.sleep(3);
			if(!cmnLib.enterDataInTextBox(manageCostScenarious.CostBooksField, exl.read(strDataSheetName, dataRow, "Cost Books"), true))
			{
				rpt.generateReport("", "Enter Cost Books field", "", exl.read(strDataSheetName, dataRow, "Cost Books"), "Cost Books should be entered", "Cost Books is not entered", "Failed", "", true);
			     Assert.fail("Cost Books field could not be entered in Manage Create Cost Scenario page");
			}
			TimeUnit.SECONDS.sleep(3);
			if(!cmnLib.enterDataInTextBox(manageCostScenarious.EffectiveDate, cmnLib.futureDate("dd/MMM/yyyy", 0), true))
			{
				rpt.generateReport("", "Enter Effective Date field", "", "", "Effective Date should be entered", "Effective Date is not entered", "Failed", "", true);
			     Assert.fail("Effective Date field could not be entered in Manage Create Cost Scenario page");
			}
			TimeUnit.SECONDS.sleep(3);
			if(!cmnLib.enterDataInTextBox(manageCostScenarious.Comments, exl.read(strDataSheetName, dataRow, "Comments"), true))
			{
				rpt.generateReport("", "Enter Comments field", "", "", "Comments should be entered", "Comments is not entered", "Failed", "", true);
			     Assert.fail("Comments field could not be entered in Manage Create Cost Scenario page");
			}
			TimeUnit.SECONDS.sleep(3);
			if(!cmnLib.selectDropdownBy(manageCostScenarious.ScenarioType, "Regular items", DropDownSelectBy.VisibleText))
			{
				rpt.generateReport("", "Select Scenario Type", "", exl.read(strDataSheetName, dataRow, "Scenario Type"), "Scenario Type should be selected", "Scenario Type is not selected", "Failed", "", true);
			     Assert.fail("Scenario Type is not selected in Manage Create Cost Scenario page");
			}
			TimeUnit.SECONDS.sleep(3);
			if(!cmnLib.enterDataInTextBox(manageCostScenarious.WorkDefinitionField, exl.read(strDataSheetName, dataRow, "Work Definition"), true))
			{
				rpt.generateReport("", "Enter Work Definition field", "", exl.read(strDataSheetName, dataRow, "Work Definition"), "Work Definition should be entered", "Work Definition is not entered", "Failed", "", true);
			     Assert.fail("Work Definition field could not be entered in Manage Create Cost Scenario page");
			}
			TimeUnit.SECONDS.sleep(3);
			rpt.generateReport("", "Entering all the details in Manage Cost Sec", "", "", "All the detailsmust be enetered", "All the details are enetered", "Passed", "", true);
		//Clicking on Save button
			TimeUnit.SECONDS.sleep(3);
			   if(cmnLib.clickOnWebElement(manageCostScenarious.SaveButton)) {
			    cmnLib.waitForPageLoaded();
			    TimeUnit.SECONDS.sleep(3);
			    if(!cmnLib.waitForElementToBeVisible(manageCostScenarious.ErrorDialog)) {
			     rpt.generateReport("", "Click on Save Button", "", "", "Save button should be clicked", "Save button is clicked", "Passed", "", false);
			    }else {
			     rpt.generateReport("", "Click on Save Button", "", "", "Transaction should be saved", "Error! Unable to Save the Transaction", "Failed", "", true);
			     String errormsg = manageCostScenarious.ErrorDialog.getAttribute("text");
			     cmnLib.clickOnWebElement(manageCostScenarious.ErrorDialogOKButton);
			     Assert.fail("Error in saving the Transaction: "+errormsg);
			    }
			    
			   }else {
			    rpt.generateReport("", "Click on Save Button", "", "", "Save button should be clicked", "Save button is not clicked", "Failed", "", true);
			    Assert.fail("Save button is not clicked");
			   }
			   TimeUnit.SECONDS.sleep(3);
		//Clicking on Cancel button
			   if(cmnLib.clickOnWebElement(manageCostScenarious.CancelButton))
			   {
				   System.out.println("Clicked on Cancel button");
			   }else {
				   System.out.println("Not Clicked on Cancel button");
			   }
			   TimeUnit.SECONDS.sleep(3);
			   
			  // cmnLib.randomNumber("SCM");
			   
		//Verifying Scenario creation
			   cmnLib.enterDataInTextBox(manageCostScenarious.ScenarioSearchEle, exl.read(strDataSheetName, 1, "Scenario"), false);
			   TimeUnit.SECONDS.sleep(2);
			   cmnLib.clickOnWebElement(manageCostScenarious.SearchButton);
			   
			   TimeUnit.SECONDS.sleep(3);
			   
			   if(manageCostScenarious.verifySearchedRecordExists(exl.read(strDataSheetName, 1, "Scenario")) == false) {
					//Fail
					rpt.generateReport("", "Enter Scenario", "", "Scenario Number: "+exl.read(strDataSheetName, 1, "Scenario"), "Entered Scenario details should be displayed and created", "Entered Scenario details could not be displayed and not created", "Failed", "", true);
					Assert.fail("Scenario in Manage Cost Scenario page could not be entered");
				}else
				{
					//Pass
					rpt.generateReport("", "Enter Scenario", "", "Scenario Number: "+exl.read(strDataSheetName, 1, "Scenario"), "Entered Scenario details should be displayed and created", "Entered Scenario details is displayed and created", "Passed", "", true);
				}
			   
			   
			   
			
			
		}
	}
}
