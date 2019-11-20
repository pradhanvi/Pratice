package com.testcases;

/**
Script Name			: SCM_CHILE_CST_007_RollUpandUpdateStandardCost
Script Description	: Roll up and Update Standard Cost
Track/Module		: SCM
Sub Track			: 
Created By			: Pradhanvi T R
Creation Date		: 28-Feb-2019
Modified By 		:
Modification Date	:
Instance Name & URL : https://edyg-dev4.fa.us2.oraclecloud.com/homePage/faces/FuseWelcome
User ID/ Password	: 10013865/Bimbo123
Responsibility		:
Pre-Requisites		: Valid Scenario ID should be entered.
Comments (if any)	:
 **/

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.commons.TestBase;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

import report.oracle.ofs.ReportGeneration;
import scm.pagefactory.CostAccountingPage;
import scm.pagefactory.HomePage_SCM;
import scm.pagefactory.LoginPage_SCM;
import scm.pagefactory.ManageCostScenarious;
import scm.pagefactory.ReviewItemCosts;
import scm.pagefactory.ScheduledProcesses;
import xlsx.databank.ofs.ExcelOperations;

public class SCM_CHILE_CST_007_RollUpandUpdateStandardCost extends TestBase{

	String strModule = "SCM";
	@Test
	public void SCM_CHILE_CST_007_RollUpandUpdateStandardCost_TC() throws Throwable {
		rpt = new ReportGeneration("SCM_CHILE_CST_007_RollUpandUpdateStandardCost", "Roll up and Update Standard Cost");

		String strDataSheetName = "CST_007";
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
			rpt.generateReport("SCM_CHILE_CST_007_RollUpandUpdateStandardCost", "Enter URL", "", "Password: "+hashmap.get("URL_"+strModule), "URL should be entered", "URL is entered", "Info", "", false );
			rpt.generateReport("", "Enter User Name", "", "UserName: "+hashmap.get("UserName_"+strModule), "UserName should be entered", "UserName is entered", "Info", "", false );
			rpt.generateReport("", "Enter Password", "", "Password: "+hashmap.get("Password_"+strModule), "Password should be entered", "Password is entered", "Info", "", false );
			rpt.generateReport("", "Validate Login to Appication", "", "", "Login Should be successful", "Login Is Successful", "Passed", "", false );
		}else
		{
			//FAIL
			rpt.generateReport("SCM_CHILE_CST_007_RollUpandUpdateStandardCost", "Login to Appication", "", "UserName: "+exl.read("LoginDetails", 1, "UserName"), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
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
			
		//Clicking on Review Item Costs
			TimeUnit.SECONDS.sleep(5);
			ManageCostScenarious manageCostScenarious = costAccountingPage.clickOnManageCostScenarious();
			rpt.generateReport("", "Tasks Icon", "", "Manage Cost Scenarious", "Must click on Manage Cost Scenarious link", "Clicked on Manage Cost Scenarious Link", "Pass", "", true);
			
		//Searching for the scenario
			TimeUnit.SECONDS.sleep(5);
			cmnLib.enterDataInTextBox(manageCostScenarious.ScenarioSearchEle, exl.read(strDataSheetName, 1, "Scenario"), false);
			   TimeUnit.SECONDS.sleep(2);
			   cmnLib.clickOnWebElement(manageCostScenarious.SearchButton);
			   
			   TimeUnit.SECONDS.sleep(3);
			   
			   if(manageCostScenarious.verifySearchedRecordExists(exl.read(strDataSheetName, 1, "Scenario")) == false) {
					//Fail
					rpt.generateReport("", "Enter Scenario", "", "Scenario Number: "+exl.read(strDataSheetName, 1, "Scenario"), "Entered Scenario details should be displayed", "Entered Scenario details could not be displayed", "Failed", "", true);
					Assert.fail("Scenario in Manage Cost Scenario page could not be entered");
				}else
				{
					//Pass
					rpt.generateReport("", "Enter Scenario", "", "Scenario Number: "+exl.read(strDataSheetName, 1, "Scenario"), "Entered Scenario details should be displayed ", "Entered Scenario details is displayed", "Passed", "", true);
				}
			   
		//Roll Up Costs
			   if (cmnLib.clickByJSE(manageCostScenarious.ActionsButton) == true) {
					rpt.generateReport("", "Click Actions dropdown", "", "", "Actions dropdown must be clicked",
							"Clicked on Actions dropdown", "Passed", "", true);
				} else {
					rpt.generateReport("", "Click Actions dropdown", "", "", "Actions dropdown must be clicked",
							"Actions dropdown not clicked", "Failed", "", true);
					Assert.fail("Actions dropdown not clicked");
				}
			   TimeUnit.SECONDS.sleep(2);
			   if(cmnLib.clickOnWebElement(manageCostScenarious.ActionsRollUpCosts))
			   {
				   rpt.generateReport("", "Select an Action", "", "", "Roll up costs must be selected",
							"Selected Roll Up Costs", "Passed", "", true);
				} else {
					rpt.generateReport("", "Select an Action", "", "", "Roll up costs must be selected",
							"Not Selected Roll Up Costs", "Failed", "", true);
					Assert.fail("Not Selected Roll Up Costs");
				}
			   TimeUnit.SECONDS.sleep(4);
			   if(cmnLib.waitForElementToBeVisible(manageCostScenarious.RollUpCostSubmitButton))
				{
					rpt.generateReport("", "Navigation to Roll Up Costs Page", "", "", "Navigation to Roll Up Costs Page should be displayed", "Navigation to Roll Up Costs Page Is displayed", "Passed", "", true );

				}else
				{
					//FAIL
					rpt.generateReport("", "Navigation to Roll Up Costs Page", "", "", "Navigation to Roll Up Costs Page should be displayed", "Navigation to Roll Up Costs Page Is Not displayed", "Failed", "", true );
					Assert.fail("Navigation to Roll Up Costs Page is not displayed");
				}
			   
			   cmnLib.clickOnWebElement(manageCostScenarious.RollUpCostSubmitButton);
			   TimeUnit.SECONDS.sleep(2);
			   
			   if(cmnLib.waitForElementToBeVisible(manageCostScenarious.RollUpCostsOkButton))
			   {
				   cmnLib.clickOnWebElement(manageCostScenarious.RollUpCostsOkButton);
				   rpt.generateReport("", "Submit the request", "", "", "Must Submit the request",
							"Submitted the request", "Passed", "", true);
				} else {
					rpt.generateReport("", "Submitted the request", "", "", "Must Submit the request",
							"Did not Submit the request", "Failed", "", true);
					Assert.fail("Did not Submit the request");
				}
			   
		//Checking the request status
			   TimeUnit.SECONDS.sleep(3);
			   homePage_SCM.clickOnNavigationIcon();
			   TimeUnit.SECONDS.sleep(3);
			  cmnLib.clickOnWebElement(homePage_SCM.ScheduledProcessesLink);
			  TimeUnit.SECONDS.sleep(3);
			  ScheduledProcesses  scheduledProcesses	= new ScheduledProcesses();
			  
			 String reqStatus= scheduledProcesses.verifyReportStatus("", "Roll up Costs");
			 rpt.generateReport("", "Submit the request", "", "", "Status of the request must be "+reqStatus+"",
					 "Status of the request is "+reqStatus+"", "Passed", "", true);
			   
		// View Scenario Exceptions
			 TimeUnit.SECONDS.sleep(3);
			 homePage_SCM.clickOnNavigationIcon();
			 TimeUnit.SECONDS.sleep(3);
			 homePage_SCM.clickOnCostAccountingLink();
			 TimeUnit.SECONDS.sleep(30);
			costAccountingPage.clickOnTaksIcon();
			TimeUnit.SECONDS.sleep(3);
			costAccountingPage.clickOnManageCostScenarious();
			   cmnLib.waitForPageLoaded();
			   //cmnLib.clickOnWebElement(manageCostScenarious.ExpandSearch);
			   cmnLib.clickOnWebElement(manageCostScenarious.ResetButton);
			   cmnLib.enterDataInTextBox(manageCostScenarious.ScenarioSearchEle, exl.read(strDataSheetName, 1, "Scenario"), false);
			   TimeUnit.SECONDS.sleep(2);
			   cmnLib.clickOnWebElement(manageCostScenarious.SearchButton);
			   
			   TimeUnit.SECONDS.sleep(5);
			   
			   if(manageCostScenarious.verifySearchedRecordExists(exl.read(strDataSheetName, 1, "Scenario")) == false) {
					//Fail
					rpt.generateReport("", "Enter Scenario", "", "Scenario Number: "+exl.read(strDataSheetName, 1, "Scenario"), "Entered Scenario details should be displayed", "Entered Scenario details could not be displayed", "Failed", "", true);
					Assert.fail("Scenario in Manage Cost Scenario page could not be entered");
				}else
				{
					//Pass
					rpt.generateReport("", "Enter Scenario", "", "Scenario Number: "+exl.read(strDataSheetName, 1, "Scenario"), "Entered Scenario details should be displayed ", "Entered Scenario details is displayed", "Passed", "", true);
				}
			   
			   if (cmnLib.clickByJSE(manageCostScenarious.ActionsButton) == true) {
					rpt.generateReport("", "Click Actions dropdown", "", "", "Actions dropdown must be clicked",
							"Clicked on Actions dropdown", "Passed", "", true);
				} else {
					rpt.generateReport("", "Click Actions dropdown", "", "", "Actions dropdown must be clicked",
							"Actions dropdown not clicked", "Failed", "", true);
					Assert.fail("Actions dropdown not clicked");
				}
			   TimeUnit.SECONDS.sleep(2);
			   if(cmnLib.clickOnWebElement(manageCostScenarious.ActionViewScenarioExceptions))
			   {
				   rpt.generateReport("", "Select an Action", "", "", "View Scenario Exceptions must be selected",
							"Selected View Scenario Exceptions", "Passed", "", true);
				} else {
					rpt.generateReport("", "Select an Action", "", "", "View Scenario Exceptions must be selected",
							"Not Selected View Scenario Exceptions", "Failed", "", true);
					Assert.fail("Not Selected View Scenario Exceptions");
				}
			   TimeUnit.SECONDS.sleep(4);
			   if(cmnLib.waitForElementToBeVisible(manageCostScenarious.DoneButton))
				{
					rpt.generateReport("", "Navigation to View Scenario Exceptions Page", "", "", "Expections details must be displayed", "Expections details are displayed", "Passed", "", true );

				}else
				{
					//FAIL
					rpt.generateReport("", "Navigation to View Scenario Exceptions Page", "", "", "Expections details must be displayed", "Expections details are not displayed", "Failed", "", true );
					Assert.fail("Expections details are not displayed");
				}
			   cmnLib.clickOnWebElement(manageCostScenarious.DoneButton);
			   
		//Analyze Costs
			  // cmnLib.clickOnWebElement(manageCostScenarious.ExpandSearch);
			   cmnLib.clickOnWebElement(manageCostScenarious.ResetButton); 
			   cmnLib.enterDataInTextBox(manageCostScenarious.ScenarioSearchEle, exl.read(strDataSheetName, 1, "Scenario"), false);
			   TimeUnit.SECONDS.sleep(2);
			   cmnLib.clickOnWebElement(manageCostScenarious.SearchButton);
			   
			   TimeUnit.SECONDS.sleep(5);
			   if (cmnLib.clickByJSE(manageCostScenarious.ActionsButton) == true) {
					rpt.generateReport("", "Click Actions dropdown", "", "", "Actions dropdown must be clicked",
							"Clicked on Actions dropdown", "Passed", "", true);
				} else {
					rpt.generateReport("", "Click Actions dropdown", "", "", "Actions dropdown must be clicked",
							"Actions dropdown not clicked", "Failed", "", true);
					Assert.fail("Actions dropdown not clicked");
				}
			   TimeUnit.SECONDS.sleep(2);
			   if(cmnLib.clickOnWebElement(manageCostScenarious.ActionViewRolledUpCosts))
			   {
				   rpt.generateReport("", "Select an Action", "", "", "View Rolled up Costs must be selected",
							"Selected View Rolled up Costs", "Passed", "", true);
				} else {
					rpt.generateReport("", "Select an Action", "", "", "View Rolled up Costs must be selected",
							"Not Selected View Rolled up Costs", "Failed", "", true);
					Assert.fail("Not Selected View Rolled up Costs");
				}
			  // System.out.println("Hello..!!");
			  cmnLib.waitForPageLoaded();
			  // if(manageCostScenarious.ViewScenarioExpectionHeader.getText().contains("View Rolled-up Costs"))
				if(cmnLib.waitForElementToBeVisible(manageCostScenarious.DoneButton))
				{
				   //manageCostScenarious.ViewScenarioExpectionHeader.sendKeys(Keys.PAGE_DOWN);
					//cmnLib.scrollTillVisibilityOfElement(manageCostScenarious.ColumnHidden);
					cmnLib.clickOnWebElement(manageCostScenarious.ColumnHidden);
					rpt.generateReport("", "Navigation to View Rolled-up Costs Page", "", "", "Rolled-up costs should appear", "Rolled-up costs details appears", "Passed", "", true );

				}else
				{
					//FAIL
					rpt.generateReport("", "Navigation to View Rolled-up Costs Page", "", "", "Rolled-up costs should appear", "Rolled-up costs details does not appear", "Failed", "", true );
					Assert.fail("Rolled-up costs details does not appear");
				}
			   cmnLib.clickOnWebElement(manageCostScenarious.DoneButton);
			   
		//Compare Standard Costs
			  // cmnLib.clickOnWebElement(manageCostScenarious.ExpandSearch);
			   cmnLib.clickOnWebElement(manageCostScenarious.ResetButton); 
			   cmnLib.enterDataInTextBox(manageCostScenarious.ScenarioSearchEle, exl.read(strDataSheetName, 1, "Scenario"), false);
			   TimeUnit.SECONDS.sleep(2);
			   cmnLib.clickOnWebElement(manageCostScenarious.SearchButton);
			   
			   TimeUnit.SECONDS.sleep(5);
			   if (cmnLib.clickByJSE(manageCostScenarious.ActionsButton) == true) {
					rpt.generateReport("", "Click Actions dropdown", "", "", "Actions dropdown must be clicked",
							"Clicked on Actions dropdown", "Passed", "", true);
				} else {
					rpt.generateReport("", "Click Actions dropdown", "", "", "Actions dropdown must be clicked",
							"Actions dropdown not clicked", "Failed", "", true);
					Assert.fail("Actions dropdown not clicked");
				}
			   TimeUnit.SECONDS.sleep(2);
			   if(cmnLib.clickOnWebElement(manageCostScenarious.ActionCompareStandardCosts))
			   {
				   rpt.generateReport("", "Select an Action", "", "", "Compare Standard Costs must be selected",
							"Selected Compare Standard Costs", "Passed", "", true);
				} else {
					rpt.generateReport("", "Select an Action", "", "", "Compare Standard Costs must be selected",
							"Not Selected Compare Standard Costs", "Failed", "", true);
					Assert.fail("Not Selected Compare Standard Costs");
				}
			   TimeUnit.SECONDS.sleep(4);
			   if(cmnLib.waitForElementToBeVisible(manageCostScenarious.DoneButton))
				{
					rpt.generateReport("", "Navigation to Compare Standard Costs Page", "", "", "Standard costs should appear", "Standard costs details appears", "Passed", "", true );

				}else
				{
					//FAIL
					rpt.generateReport("", "Navigation to Compare Standard Costs Page", "", "", "Standard costs did not appear", "Standard costs did not appear", "Failed", "", true );
					Assert.fail("Standard costs did not appear");
				}
			  if( cmnLib.clickOnWebElement(manageCostScenarious.DoneButton))
			  {
				  System.out.println("Clicked on Done button--Compare Standard costs");
			  }
			   
		//Update Standard costs
			   cmnLib.clickOnWebElement(manageCostScenarious.ExpandSearch);
			   cmnLib.clickOnWebElement(manageCostScenarious.ResetButton); 
			   cmnLib.enterDataInTextBox(manageCostScenarious.ScenarioSearchEle, exl.read(strDataSheetName, 1, "Scenario"), false);
			   TimeUnit.SECONDS.sleep(2);
			   cmnLib.clickOnWebElement(manageCostScenarious.SearchButton);
			   
			   TimeUnit.SECONDS.sleep(5);
			   if (cmnLib.clickByJSE(manageCostScenarious.ActionsButton) == true) {
					rpt.generateReport("", "Click Actions dropdown", "", "", "Actions dropdown must be clicked",
							"Clicked on Actions dropdown", "Passed", "", true);
				} else {
					rpt.generateReport("", "Click Actions dropdown", "", "", "Actions dropdown must be clicked",
							"Actions dropdown not clicked", "Failed", "", true);
					Assert.fail("Actions dropdown not clicked");
				}
			   TimeUnit.SECONDS.sleep(2);
			   if(cmnLib.clickOnWebElement(manageCostScenarious.ActionUpdateStandardCosts))
			   {
				   rpt.generateReport("", "Select an Action", "", "", "Update Standard Costs must be selected",
							"Update Standard Costs", "Passed", "", true);
				} else {
					rpt.generateReport("", "Select an Action", "", "", "Update Standard Costs must be selected",
							"Not Selected Update Standard Costs", "Failed", "", true);
					Assert.fail("Not Selected Update Standard Costs");
				}
			   TimeUnit.SECONDS.sleep(4);
			   if(cmnLib.waitForElementToBeVisible(manageCostScenarious.SubmitButtonUpdateStandardCosts))
				{
					rpt.generateReport("", "Navigation to Update Standard Costs Page", "", "", "Update costs should appear", "Update  Standard Costs Page  appears", "Passed", "", true );
					

				}else
				{
					//FAIL
					rpt.generateReport("", "Update  Standard Costs Page", "", "", "Update  Standard Costs Page should appear", "Update  Standard Costs Page did not appear", "Failed", "", true );
					Assert.fail("Rolled-up costs details does not appear");
				}
			   cmnLib.clickOnWebElement(manageCostScenarious.SubmitButtonUpdateStandardCosts);
			   TimeUnit.SECONDS.sleep(2);
			   
			   if(cmnLib.waitForElementToBeVisible(manageCostScenarious.OkButtonUpdateStandardCosts, 20))
			   {
				   cmnLib.clickOnWebElement(manageCostScenarious.OkButtonUpdateStandardCosts);
				   rpt.generateReport("", "Submit the request", "", "", "Must Submit the request",
							"Submitted the request", "Passed", "", true);
				   TimeUnit.SECONDS.sleep(3);
				} else {
					rpt.generateReport("", "Submitted the request", "", "", "Must Submit the request",
							"Did not Submit the request", "Failed", "", true);
					Assert.fail("Did not Submit the request");
				}
}
	}
}
