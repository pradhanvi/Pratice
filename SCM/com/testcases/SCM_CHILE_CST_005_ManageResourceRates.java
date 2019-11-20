package com.testcases;

/**
Script Name			: SCM_CHILE_CST_005_ManageResourceRates
Script Description	: Manage Resource Rates
Track/Module		: SCM
Sub Track			: 
Created By			: Pradhanvi T R
Creation Date		: 26-Feb-2019
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
import org.testng.annotations.Test;

import com.commons.TestBase;

import report.oracle.ofs.ReportGeneration;
import scm.pagefactory.CostAccountingPage;
import scm.pagefactory.HomePage_SCM;
import scm.pagefactory.LoginPage_SCM;
import scm.pagefactory.ManageCostScenarious;
import scm.pagefactory.ManageResourceRates;
import xlsx.databank.ofs.ExcelOperations;

public class SCM_CHILE_CST_005_ManageResourceRates extends TestBase{
	String strModule = "SCM";
	@Test
	public void SCM_CHILE_CST_005_ManageResourceRates_TC() throws Throwable {
		rpt = new ReportGeneration("SCM_CHILE_CST_005_ManageResourceRates", "Manage Resource Rates");

		String strDataSheetName = "CST_005";
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
			rpt.generateReport("SCM_CHILE_CST_005_ManageResourceRates", "Enter URL", "", "Password: "+hashmap.get("URL_"+strModule), "URL should be entered", "URL is entered", "Info", "", true );
			rpt.generateReport("", "Enter User Name", "", "UserName: "+hashmap.get("UserName_"+strModule), "UserName should be entered", "UserName is entered", "Info", "", true );
			rpt.generateReport("", "Enter Password", "", "Password: "+hashmap.get("Password_"+strModule), "Password should be entered", "Password is entered", "Info", "", true );
			rpt.generateReport("", "Validate Login to Appication", "", "", "Login Should be successful", "Login Is Successful", "Passed", "", true );
		}else
		{
			//FAIL
			rpt.generateReport("SCM_CHILE_CST_005_ManageResourceRates", "Login to Appication", "", "UserName: "+exl.read("LoginDetails", 1, "UserName"), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
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
			
		//Clicking on Manage Resource Rates
			TimeUnit.SECONDS.sleep(5);
			cmnLib.clickOnWebElement(costAccountingPage.ManageResourceRatesLink);
			rpt.generateReport("", "Tasks Icon", "", "Manage Resource Rates", "Must click on Manage Resource Rates link", "Clicked on Manage Resource Rates Link", "Pass", "", true);
			
		//Verify Manage Resource Rates page is displayed
			TimeUnit.SECONDS.sleep(10);
			
			ManageResourceRates manageResourceRates = new ManageResourceRates();
			if(cmnLib.waitForElementToBeVisible(manageResourceRates.CreateResourceRatesIcon))
			{
				rpt.generateReport("", "Navigation to Manage Resource Rates Page", "", "", "Navigation to  Manage Resource Rates Page should be displayed", "Navigation to  Manage Resource Rates Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to  Manage Resource Rates Page", "", "", "Navigation to  Manage Resource Rates Page should be displayed", "Navigation to  Manage Resource Rates Page Is Not displayed", "Failed", "", true );
				Assert.fail("Navigation to  Manage Resource Rates Page is not displayed");
			}
			
		//Creating new Resource Rates
			TimeUnit.SECONDS.sleep(10);
			
			if(!cmnLib.clickOnWebElement(manageResourceRates.CreateResourceRatesIcon))
			{
				rpt.generateReport("", "Click on create button", "", "", "Create Icon should be clickable", "Create Icon is not clickable", "Failed", "", true);
			     Assert.fail("Create Icon is not clickable in Manage Resource Rates");
			}
			TimeUnit.SECONDS.sleep(10);
			
			if(!cmnLib.enterDataInTextBox(manageResourceRates.ScenarioField, exl.read(strDataSheetName, dataRow, "Scenario"), true))
			{
				manageResourceRates.ScenarioField.sendKeys(Keys.TAB);
				rpt.generateReport("", "Enter Scenario field", "", exl.read(strDataSheetName, dataRow, "Scenario"), "Scenario should be entered", "Scenario is not entered", "Failed", "", true);
			     Assert.fail("Scenario field could not be entered in Create Resource Rate page");
			}
			TimeUnit.SECONDS.sleep(10);
			cmnLib.waitForElementToBeVisible(manageResourceRates.PlantField);
			if(!cmnLib.enterDataInTextBox(manageResourceRates.PlantField, exl.read(strDataSheetName, dataRow, "Plant"), true))
			{
				rpt.generateReport("", "Enter Plant field", "", exl.read(strDataSheetName, dataRow, "Plant"), "Plant Field should be entered", "Plant Field is not entered", "Failed", "", true);
			     Assert.fail("Plant field could not be entered in Create Resource Rate page");
			}
			TimeUnit.SECONDS.sleep(10);
			
			if(!cmnLib.enterDataInTextBox(manageResourceRates.Resource, exl.read(strDataSheetName, dataRow, "Resource"), true))
			{
				rpt.generateReport("", "Enter Resource field", "", exl.read(strDataSheetName, dataRow, "Resource"), "Resource Field should be entered", "Resource Field is not entered", "Failed", "", true);
			     Assert.fail("Resource field could not be entered in Create Resource Rate page");
			}
			
		//Create new Rates
			
			if(!cmnLib.clickOnWebElement(manageResourceRates.AddRates))
			{
				rpt.generateReport("", "Click on create button", "", "", "Create Icon should be clickable", "Create Icon is not clickable", "Failed", "", true);
			     Assert.fail("Create Icon is not clickable in Create Resource Rates");
			}
			TimeUnit.SECONDS.sleep(5);
			
			if(!cmnLib.enterDataInTextBox(manageResourceRates.CostElement, exl.read(strDataSheetName, dataRow, "Cost Element"), true))
			{
				rpt.generateReport("", "Enter Cost Element field", "", exl.read(strDataSheetName, dataRow, "Cost Element"), "Cost Element Field should be entered", "Cost Element Field is not entered", "Failed", "", true);
			     Assert.fail("Cost Element field could not be entered in Create Resource Rate page");
			}
			TimeUnit.SECONDS.sleep(5);
			
			if(!cmnLib.enterDataInTextBox(manageResourceRates.ExpensePool, exl.read(strDataSheetName, dataRow, "Expense Pool"), true))
			{
				rpt.generateReport("", "Enter Expense Pool field", "", exl.read(strDataSheetName, dataRow, "Expense Pool"), "Expense Pool Field should be entered", "Expense Pool Field is not entered", "Failed", "", true);
			     Assert.fail("Expense Pool field could not be entered in Create Resource Rate page");
			}
			TimeUnit.SECONDS.sleep(5);
			
			if(!cmnLib.enterDataInTextBox(manageResourceRates.Rates, exl.read(strDataSheetName, dataRow, "Rate"), true))
			{
				rpt.generateReport("", "Enter Rate field", "", exl.read(strDataSheetName, dataRow, "Rate"), "Rate Field should be entered", "Rate Field is not entered", "Failed", "", true);
			     Assert.fail("Rate field could not be entered in Create Resource Rate page");
			}
			rpt.generateReport("", "Entering all the details in Create Resource Rates", "", "", "All the details must be entered", "All the details are entered", "Passed", "", true);
			
		//Clicking on Save button
			TimeUnit.SECONDS.sleep(3);
			if(cmnLib.clickOnWebElement(manageResourceRates.SaveButton)) {
				cmnLib.waitForPageLoaded();
				TimeUnit.SECONDS.sleep(3);
				if(!cmnLib.waitForElementToBeVisible(manageResourceRates.ErrorDialog)) {
					rpt.generateReport("", "Click on Save Button", "", "", "Save button should be clicked", "Save button is clicked", "Passed", "", false);
				}else {
					rpt.generateReport("", "Click on Save Button", "", "", "Transaction should be saved", "Error! Unable to Save the Transaction", "Failed", "", true);
					String errormsg = manageResourceRates.ErrorDialog.getAttribute("text");
					cmnLib.clickOnWebElement(manageResourceRates.ErrorDialogOKButton);
					Assert.fail("Error in saving the Transaction: "+errormsg);
				}

			}else {
				rpt.generateReport("", "Click on Save Button", "", "", "Save button should be clicked", "Save button is not clicked", "Failed", "", true);
				Assert.fail("Save button is not clicked");
			}
			TimeUnit.SECONDS.sleep(3);
		//Clicking on Cancel button
			   if(cmnLib.clickOnWebElement(manageResourceRates.CancelButton))
			   {
				   System.out.println("Clicked on Cancel button");
			   }else {
				   System.out.println("Not Clicked on Cancel button");
			   }
			   TimeUnit.SECONDS.sleep(5);
			   
		 //Verifying Scenario creation
			   cmnLib.enterDataInTextBox(manageResourceRates.ScenarioSearchEle, exl.read(strDataSheetName, 1, "Scenario"), false);
			   TimeUnit.SECONDS.sleep(2);
			   cmnLib.clickOnWebElement(manageResourceRates.SearchButton);
			   
			   TimeUnit.SECONDS.sleep(3);
			   
			   if(manageResourceRates.verifySearchedRecordExists(exl.read(strDataSheetName, 1, "Scenario")) == false) {
					//Fail
					rpt.generateReport("", "Enter Scenario", "", "Scenario Number: "+exl.read(strDataSheetName, 1, "Scenario"), "Entered Scenario details should be displayed in search results ", "Entered Scenario details could not be displayed in search results", "Failed", "", true);
					Assert.fail("Scenario in Manage Resource Rates page could not be entered");
				}else
				{
					//Pass
					rpt.generateReport("", "Enter Scenario", "", "Scenario Number: "+exl.read(strDataSheetName, 1, "Scenario"), "Entered Scenario details should be displayed and created", "Entered Scenario details is displayed and created", "Passed", "", true);
				}
			//Verifying Details 
			   
			   if(manageResourceRates.Details.getText().contains(exl.read(strDataSheetName, 1, "Scenario")))
			   {
				   rpt.generateReport("", "Enter Scenario", "", "Scenario Number: "+exl.read(strDataSheetName, 1, "Scenario"), "Entered Scenario details should be displayed and created", "Entered Scenario details is displayed and created", "Passed", "", true);
			   }else {
				   rpt.generateReport("", "Enter Scenario", "", "Scenario Number: "+exl.read(strDataSheetName, 1, "Scenario"), "Entered Scenario details should be displayed and created", "Entered Scenario details could not be displayed and not created", "Failed", "", true);
					Assert.fail("Scenario in Search Person page could not be entered");
			   }
			
		}
	}

}
