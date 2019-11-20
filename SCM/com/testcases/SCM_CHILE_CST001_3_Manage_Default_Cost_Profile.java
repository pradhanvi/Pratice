package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.commons.TestBase;

import hcm.pagefactory.HomePage_HCM;
import hcm.pagefactory.LoginPage_HCM;
import hcm.pagefactory.SetupAndMaintenance;
import report.oracle.ofs.ReportGeneration;
import scm.pagefactory.CostAccountingPage;
import scm.pagefactory.HomePage_SCM;
import scm.pagefactory.LoginPage_SCM;
import scm.pagefactory.ManageResourceRates;
import xlsx.databank.ofs.ExcelOperations;

/**
Script Name			: SCM_CHILE_CST001_3_Manage_Default_Cost_Profile
Script Description	: Manage Default Cost Profile
Track/Module		: SCM
Sub Track			: 
Created By			: Pradhanvi T R
Creation Date		: 01-May-19
Modified By 		: 
Modification Date	: 
Instance Name & URL : https://edyg-dev6.fa.us2.oraclecloud.com/ 
User ID/ Password	: AUTO.HCM_USER/Oracle123
Responsibility		: 
Pre-Requisites		: 
Comments (if any)	:
 **/

public class SCM_CHILE_CST001_3_Manage_Default_Cost_Profile extends TestBase {
	String strModule = "SCM";
	@Test
	public void SCM_CHILE_CST001_3_Manage_Default_Cost_Profile_TC() throws Throwable {
		rpt = new ReportGeneration("SCM_CHILE_CST001_3_Manage_Default_Cost_Profile", "");

		String strDataSheetName = "CST_001_3";
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
			
		//Click On Setup And Maintenance
			
			cmnLib.clickOnWebElement(homePage_SCM.SetupAndMaintenance);
			 SetupAndMaintenance setupAndMaintenance = new SetupAndMaintenance();
			 TimeUnit.SECONDS.sleep(5);
				
		//Search Task
			cmnLib.waitForElementToBeVisible(setupAndMaintenance.TasksIcon,10);
			cmnLib.clickOnWebElement(setupAndMaintenance.TasksIcon);
			cmnLib.clickOnWebElement(setupAndMaintenance.SearchAction);
			cmnLib.waitForElementToBeVisible(setupAndMaintenance.SearchBar);
			cmnLib.enterDataInTextBox(setupAndMaintenance.SearchBar, exl.read(strDataSheetName, dataRow, "Search_Action"), true);
			cmnLib.clickOnWebElement(setupAndMaintenance.SearchIcon);
			rpt.generateReport("", "Selecting the Task", "", "Manage Default Cost Profile", "Task must appear in search result", "Task appeared in search result", "Passed", "", true );
			cmnLib.clickOnLinkText(exl.read(strDataSheetName, dataRow, "Search_Action"));	
			
			cmnLib.waitForElementToBeVisible(setupAndMaintenance.ManageDefaultCostProfilesPage,20);
			cmnLib.enterDataInTextBox(setupAndMaintenance.CostOrganization, exl.read(strDataSheetName, dataRow, "Cost_Organisation"), true);
			cmnLib.enterDataInTextBox(setupAndMaintenance.CategoryName, exl.read(strDataSheetName, dataRow, "Category_Name"), true);
			cmnLib.enterDataInTextBox(setupAndMaintenance.CostBook, exl.read(strDataSheetName, dataRow, "Cost_Book"), true);
			cmnLib.clickOnWebElement(setupAndMaintenance.SearchBtn);
			
			if(!cmnLib.waitForElementToBeVisible(setupAndMaintenance.NoResultsFound, 10))
				rpt.generateReport("", "Selecting the Task", "", "Manage Default Cost Profile", "Search result must appear", "Search result appeared", "Passed", "", true );
			else {
				rpt.generateReport("", "Selecting the Task", "", "Manage Default Cost Profile", "Search result must appear", "Search result did not appeared", "Failed", "", true );
				Assert.fail("Search result did not appeared");
			}
			
		}
	}

}
