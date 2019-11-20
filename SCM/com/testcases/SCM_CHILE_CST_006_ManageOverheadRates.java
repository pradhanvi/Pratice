package com.testcases;

/**
Script Name			: SCM_CHILE_CST_006_ManageOverheadRates
Script Description	: Manage Overheads Rates
Track/Module		: SCM
Sub Track			: 
Created By			: Pradhanvi T R
Creation Date		: 27-Feb-2019
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

import com.commons.Common_Library.DropDownSelectBy;
import com.commons.TestBase;

import report.oracle.ofs.ReportGeneration;
import scm.pagefactory.CostAccountingPage;
import scm.pagefactory.HomePage_SCM;
import scm.pagefactory.LoginPage_SCM;
import scm.pagefactory.ManageOverheadRates;
import scm.pagefactory.ManageStandardCosts;
import xlsx.databank.ofs.ExcelOperations;

public class SCM_CHILE_CST_006_ManageOverheadRates extends TestBase {
	String strModule = "SCM";
	@Test
	public void SCM_CHILE_CST_006_ManageOverheadRates_TC() throws Throwable {
		rpt = new ReportGeneration("SCM_CHILE_CST_006_ManageOverheadRates", "Manage Overheads Rates");

		String strDataSheetName = "CST_006";
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
			rpt.generateReport("SCM_CHILE_CST_006_ManageOverheadRates", "Enter URL", "", "Password: "+hashmap.get("URL_"+strModule), "URL should be entered", "URL is entered", "Info", "", true );
			rpt.generateReport("", "Enter User Name", "", "UserName: "+hashmap.get("UserName_"+strModule), "UserName should be entered", "UserName is entered", "Info", "", true );
			rpt.generateReport("", "Enter Password", "", "Password: "+hashmap.get("Password_"+strModule), "Password should be entered", "Password is entered", "Info", "", true );
			rpt.generateReport("", "Validate Login to Appication", "", "", "Login Should be successful", "Login Is Successful", "Passed", "", true );
		}else
		{
			//FAIL
			rpt.generateReport("SCM_CHILE_CST_006_ManageOverheadRates", "Login to Appication", "", "UserName: "+exl.read("LoginDetails", 1, "UserName"), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
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
			if(cmnLib.waitForElementToBeVisible(costAccountingPage.TasksIcon))
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
			
		//Clicking on Manage Overheads Rates
			TimeUnit.SECONDS.sleep(5);
			ManageOverheadRates manageOverheadRates = costAccountingPage.clickOnManageOverheadRates();
			rpt.generateReport("", "Tasks Icon", "", "Manage Overhead Rates", "Must click on Manage Overhead Rates link", "Clicked on Manage Overhead Rates Link", "Pass", "", true);
			
		//Verify Manage Overhead Rates page is displayed
			TimeUnit.SECONDS.sleep(10);
			
			if(cmnLib.waitForElementToBeVisible(manageOverheadRates.CreateOverheadRatesIcon))
			{
				rpt.generateReport("", "Navigation to Manage Overhead Rates Page", "", "", "Navigation to  Manage Overhead Rates Page should be displayed", "Navigation to  Manage Overhead Rates Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to  Manage Overhead Rates Page", "", "", "Navigation to  Manage Overhead Rates Page should be displayed", "Navigation to  Manage Overhead Rates Page Is Not displayed", "Failed", "", true );
				Assert.fail("Navigation to  Manage Overhead Rates Page is not displayed");
			}
		//Creating new Overhead rates
			TimeUnit.SECONDS.sleep(5);
			
			if(!cmnLib.clickOnWebElement(manageOverheadRates.CreateOverheadRatesIcon))
			{
				rpt.generateReport("", "Click on create button", "", "", "Create Icon should be clickable", "Create Icon is not clickable", "Failed", "", true);
			     Assert.fail("Create Icon is not clickable in Manage Overhead Rates");
			}
			TimeUnit.SECONDS.sleep(6);
			
			if(!cmnLib.enterDataInTextBox(manageOverheadRates.ScenarioField, exl.read(strDataSheetName, dataRow, "Scenario"), true))
			{
				manageOverheadRates.ScenarioField.sendKeys(Keys.TAB);
				rpt.generateReport("", "Enter Scenario field", "", exl.read(strDataSheetName, dataRow, "Scenario"), "Scenario should be entered", "Scenario is not entered", "Failed", "", true);
			     Assert.fail("Scenario field could not be entered in Create Overhead Rates page");
			}
			TimeUnit.SECONDS.sleep(10);
			cmnLib.waitForElementToBeVisible(manageOverheadRates.PlantField);
			if(!cmnLib.enterDataInTextBox(manageOverheadRates.PlantField, exl.read(strDataSheetName, dataRow, "Plant"), true))
			{
				rpt.generateReport("", "Enter Plant field", "", exl.read(strDataSheetName, dataRow, "Plant"), "Plant Field should be entered", "Plant Field is not entered", "Failed", "", true);
			     Assert.fail("Plant field could not be entered in Create Overhead Rates page");
			}
			TimeUnit.SECONDS.sleep(2);
			
			if(exl.read(strDataSheetName, dataRow, "Overhead Rate Type").equals("Plant overhead"))
			{
				cmnLib.selectDropdownBy(manageOverheadRates.OverheadRateType, "Plant overhead", DropDownSelectBy.VisibleText);
				TimeUnit.SECONDS.sleep(2);
				if(!cmnLib.enterDataInTextBox(manageOverheadRates.ItemCategory, exl.read(strDataSheetName, dataRow, "Item Category"), true))
				{
					rpt.generateReport("", "Enter Item Category field", "", exl.read(strDataSheetName, dataRow, "Item Category"), "Item Category Field should be entered", "Item Category Field is not entered", "Failed", "", true);
				     Assert.fail("Item Category field could not be entered in Create Overhead Rates page");
				}
				TimeUnit.SECONDS.sleep(2);
				if(!cmnLib.enterDataInTextBox(manageOverheadRates.ItemField, exl.read(strDataSheetName, dataRow, "Item Number"), true))
				{
					rpt.generateReport("", "Enter Item Number field", "", exl.read(strDataSheetName, dataRow, "Item Number"), "Item Number Field should be entered", "Item Number Field is not entered", "Failed", "", true);
				     Assert.fail("Item Number field could not be entered in Create Overhead Rates page");
				}
				
				
			}else if(exl.read(strDataSheetName, dataRow, "Overhead Rate Type").equals("Work center overhead"))
			{
				cmnLib.selectDropdownBy(manageOverheadRates.OverheadRateType, "Work center overhead", DropDownSelectBy.VisibleText);
				TimeUnit.SECONDS.sleep(2);
				if(!cmnLib.enterDataInTextBox(manageOverheadRates.WorkCenterField, exl.read(strDataSheetName, dataRow, "Work Center"), true))
				{
					rpt.generateReport("", "Enter Work Center field", "", exl.read(strDataSheetName, dataRow, "Work Center"), "Work Center Field should be entered", "Work Center Field is not entered", "Failed", "", true);
				     Assert.fail("Work Center field could not be entered in Create Overhead Rates page");
				}
				TimeUnit.SECONDS.sleep(2);
				cmnLib.selectDropdownBy(manageOverheadRates.ResourceType,exl.read(strDataSheetName, dataRow, "Resource Type") , DropDownSelectBy.VisibleText);
			}
			
		//Adding Overhead Rates
			TimeUnit.SECONDS.sleep(2);
			cmnLib.clickOnWebElement(manageOverheadRates.AddOverheadRatesIcon);
			TimeUnit.SECONDS.sleep(2);
			if(!cmnLib.enterDataInTextBox(manageOverheadRates.CostElement, exl.read(strDataSheetName, dataRow, "Cost Element"), true))
			{
				rpt.generateReport("", "Enter Cost Element field", "", exl.read(strDataSheetName, dataRow, "Cost Element"), "Cost Element Field should be entered", "Cost Element Field is not entered", "Failed", "", true);
			     Assert.fail("Cost Element field could not be entered in Create Overhead Rates page");
			}
			TimeUnit.SECONDS.sleep(2);
			if(!cmnLib.enterDataInTextBox(manageOverheadRates.ExpensePool, exl.read(strDataSheetName, dataRow, "Expense Pool"), true))
			{
				rpt.generateReport("", "Enter Expense Pool field", "", exl.read(strDataSheetName, dataRow, "Expense Pool"), "Expense Pool Field should be entered", "Expense Pool Field is not entered", "Failed", "", true);
			     Assert.fail("Expense Pool field could not be entered in Create Overhead Rates page");
			}
			TimeUnit.SECONDS.sleep(2);
			cmnLib.selectDropdownBy(manageOverheadRates.AbsorptionType, exl.read(strDataSheetName, dataRow, "Absorption Type"), DropDownSelectBy.VisibleText);
			TimeUnit.SECONDS.sleep(2);
			if(!cmnLib.enterDataInTextBox(manageOverheadRates.Value, exl.read(strDataSheetName, dataRow, "Value"), true))
			{
				rpt.generateReport("", "Enter Value field", "", exl.read(strDataSheetName, dataRow, "Value"), "Value Field should be entered", "Value Field is not entered", "Failed", "", true);
			     Assert.fail("Value field could not be entered in Create Overhead Rates page");
			}
			rpt.generateReport("", "Entering all the details in Create Overhead Rates", "", "", "All the details must be entered", "All the details are entered", "Passed", "", true);
		//Clicking on Save button
			TimeUnit.SECONDS.sleep(3);
			if(cmnLib.clickOnWebElement(manageOverheadRates.SaveButton)) {
				cmnLib.waitForPageLoaded();
				TimeUnit.SECONDS.sleep(3);
				if(!cmnLib.waitForElementToBeVisible(manageOverheadRates.ErrorDialog)) {
					rpt.generateReport("", "Click on Save Button", "", "", "Save button should be clicked", "Save button is clicked", "Passed", "", false);
				}else {
					rpt.generateReport("", "Click on Save Button", "", "", "Transaction should be saved", "Error! Unable to Save the Transaction", "Failed", "", true);
					String errormsg = manageOverheadRates.ErrorDialog.getAttribute("text");
					cmnLib.clickOnWebElement(manageOverheadRates.ErrorDialogOKButton);
					Assert.fail("Error in saving the Transaction: "+errormsg);
				}

			}else {
				rpt.generateReport("", "Click on Save Button", "", "", "Save button should be clicked", "Save button is not clicked", "Failed", "", true);
				Assert.fail("Save button is not clicked");
			}
			TimeUnit.SECONDS.sleep(3);
		//Clicking on Cancel button
			   if(cmnLib.clickOnWebElement(manageOverheadRates.CancelButton))
			   {
				   System.out.println("Clicked on Cancel button");
			   }else {
				   System.out.println("Not Clicked on Cancel button");
			   }
			   TimeUnit.SECONDS.sleep(5);
			   
		//Verifying Scenario creation
			   cmnLib.enterDataInTextBox(manageOverheadRates.ScenarioSearchEle, exl.read(strDataSheetName, 1, "Scenario"), false);
			   TimeUnit.SECONDS.sleep(2);
			   cmnLib.clickOnWebElement(manageOverheadRates.SearchButton);
			   
			   TimeUnit.SECONDS.sleep(3);
			   
			   if(manageOverheadRates.verifySearchedRecordExists(exl.read(strDataSheetName, 1, "Scenario")) == false) {
					//Fail
					rpt.generateReport("", "Enter Scenario", "", "Scenario Number: "+exl.read(strDataSheetName, 1, "Scenario"), "Entered Scenario details should be displayed in search results ", "Entered Scenario details could not be displayed in search results", "Failed", "", true);
					Assert.fail("Scenario in Manage Resource Rates page could not be entered");
				}else
				{
					//Pass
					rpt.generateReport("", "Enter Scenario", "", "Scenario Number: "+exl.read(strDataSheetName, 1, "Scenario"), "Entered Scenario details should be displayed and created", "Entered Scenario details is displayed and created", "Passed", "", true);
				}
		//Verifying Details 
			   
			   if(manageOverheadRates.Details.getText().contains(exl.read(strDataSheetName, 1, "Scenario")))
			   {
				   rpt.generateReport("", "Enter Scenario", "", "Scenario Number: "+exl.read(strDataSheetName, 1, "Scenario"), "Entered Scenario details should be displayed and created", "Entered Scenario details is displayed and created", "Passed", "", true);
			   }else {
				   rpt.generateReport("", "Enter Scenario", "", "Scenario Number: "+exl.read(strDataSheetName, 1, "Scenario"), "Entered Scenario details should be displayed and created", "Entered Scenario details could not be displayed and not created", "Failed", "", true);
					Assert.fail("Scenario in Search Person page could not be entered");
			   }
			
		}
	}

}
