package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.commons.TestBase;
import com.commons.Common_Library.DropDownSelectBy;

import hcm.pagefactory.HomePage_HCM;
import hcm.pagefactory.LoginPage_HCM;
import hcm.pagefactory.SearchPerson;
import report.oracle.ofs.ReportGeneration;
import scm.pagefactory.HomePage_SCM;
import scm.pagefactory.LoginPage_SCM;
import scm.pagefactory.SetupAndMaintenancePage;
import xlsx.databank.ofs.ExcelOperations;

/**
Script Name			: SCM_CHILE_CST_001_ManageCostBooks
Script Description	: Manage Cost Books
Track/Module		: SCM
Sub Track			: 
Created By			: Pradhanvi T R
Creation Date		: 
Modified By 		: 
Modification Date	: 
Instance Name & URL : https://edyg-dev4.fa.us2.oraclecloud.com/fscmUI/faces/FuseWelcome?
User ID/ Password	: AUTO.SCM_USER/********
Responsibility		: 
Pre-Requisites		: 
Comments (if any)	:
 **/

public class SCM_CHILE_CST_001_ManageCostBooks extends TestBase {
	String strModule = "SCM";
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void SCM_CHILE_CST_001_ManageCostBooks_TC() throws Throwable {
		rpt = new ReportGeneration("SCM_CHILE_CST_001_ManageCostBooks", "Manage Cost Books");

		String strDataSheetName = "CST_001";
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
				throw new SkipException("Login Un-Successful");
			}

			login = true;
		}

		//Initialize HomePage Web Elements

		//Validate HomePage Icon
		if(cmnLib.waitForElementToBeVisible(homePage_SCM.HomePage_HomeIcon) == true)
		{
			homePage_SCM = PageFactory.initElements(driver, HomePage_SCM.class);
			//PASS
			rpt.generateReport("SCM_CHILE_CST_001_ManageCostBooks", "Enter URL", "", "Password: "+hashmap.get("URL_"+strModule), "URL should be entered", "URL is entered", "Info", "", true );
			rpt.generateReport("", "Enter User Name", "", "UserName: "+hashmap.get("UserName_"+strModule), "UserName should be entered", "UserName is entered", "Info", "", true );
			rpt.generateReport("", "Enter Password", "", "Password: "+hashmap.get("Password_"+strModule), "Password should be entered", "Password is entered", "Info", "", true );
			rpt.generateReport("", "Validate Login to Appication", "", "", "Login Should be successful", "Login Is Successful", "Passed", "", true );
		}else
		{
			//FAIL
			rpt.generateReport("SCM_CHILE_CST_001_ManageCostBooks", "Login to Appication", "", "UserName: "+exl.read("LoginDetails", 1, "UserName"), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
			throw new RuntimeException("Login Un-Successful");
		}
		rpt.enterStepHeader("Navigation to Setup and Maintenance Page");

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
				throw new SkipException("Login Un-Successful");
			}
			TimeUnit.SECONDS.sleep(5);
		//Click on Navigator Icon
			homePage_SCM.clickOnNavigationIcon();

		//Click On Setup and Maintenance from Navigator Links
			SetupAndMaintenancePage setupAndMaintenancePage = homePage_SCM.clickOnSetupMaintenanceLink();
			//SearchPerson Person_Management = homePage_SCM.clickOnPersonManagementLink();
			TimeUnit.SECONDS.sleep(5);
			
		//Verify Setup and Maintenance page is displayed
			if(cmnLib.waitForElementToBeVisible(setupAndMaintenancePage.SetupDropDown))
			{
				rpt.generateReport("", "Navigation to Setup and Maintenace Page", "", "", "Navigation to Setup and Maintenace Page should be displayed", "Navigation to Setup and Maintenace Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to Setup and Maintenace Page", "", "", "Navigation to Setup and Maintenace Page should be displayed", "Navigation to Setup and Maintenace Page Is Not displayed", "Failed", "", true );
				throw new SkipException("Navigation to Setup and Maintenace Page is not displayed");
			}
			rpt.enterStepHeader("Navigating Manufacturing and Supply Chain Materials Management");
		//Selecting Manufacturing and Supply Chain Materials Management from dropdown
			
			if(setupAndMaintenancePage.selectSCMdropdown())
			{
				rpt.generateReport("", "Selecting Setup from drop down", "", "", "Must select Manufacturing and Supply Chain Materials Management ", "Selected Manufacturing and Supply Chain Materials Management", "Pass", "", true);
			}else {
				rpt.generateReport("", "Selecting Setup from drop down", "", "", "Must select Manufacturing and Supply Chain Materials Management ", "Did not Select Manufacturing and Supply Chain Materials Management", "Fail", "", true);
			}
		
		//Entering search criteria 
			
			setupAndMaintenancePage.SearchTasks.sendKeys(exl.read(strDataSheetName, dataRow, "Search_Criteria"));
			setupAndMaintenancePage.SearchTasksSearchButton.click();
			
		//Clicking on Search results
			
			if(cmnLib.clickOnLinkText("Manage Cost Books"))
			{
				rpt.generateReport("", "Clicking on Search results", "", "Manage Cost Books", "Must Click on Manage Cost Books", "Clicked on Manage Cost Books", "Pass", "", true);
			}else {
				rpt.generateReport("", "Clicking on Search results", "", "Manage Cost Books", "Must  Click on Manage Cost Books", "Did not Click on Manage Cost Books", "Fail", "", true);
			}
			
		//Verify Manage Cost Books page is displayed
			TimeUnit.SECONDS.sleep(5);
			if(setupAndMaintenancePage.ManageCostBooksPageHeader.isDisplayed() == true)
			{
				rpt.generateReport("", "Navigation to Manage Cost Books Page", "", "", "Navigation to  Manage Cost Books Page should be displayed", "Navigation to  Manage Cost Books Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to  Manage Cost Books Page", "", "", "Navigation to  Manage Cost Books Page should be displayed", "Navigation to  Manage Cost Books Page Is Not displayed", "Failed", "", true );
				throw new SkipException("Navigation to  Manage Cost Books Page is not displayed");
			}
			
		//Reviewing Cost Books
			TimeUnit.SECONDS.sleep(5);
			if(setupAndMaintenancePage.CostBook1.equals(exl.read(strDataSheetName, dataRow, "Cost_Book1"))&&
					setupAndMaintenancePage.CostBook2.equals(exl.read(strDataSheetName, dataRow, "Cost_Book2"))	&&
					setupAndMaintenancePage.CostBook3.equals(exl.read(strDataSheetName, dataRow, "Cost_Book3")) &&
					setupAndMaintenancePage.CostBook4.equals(exl.read(strDataSheetName, dataRow, "Cost_Book4")) &&
					setupAndMaintenancePage.CostBook5.equals(exl.read(strDataSheetName, dataRow, "Cost_Book5")) &&
					setupAndMaintenancePage.CostBook6.equals(exl.read(strDataSheetName, dataRow, "Cost_Book6")) ||
					setupAndMaintenancePage.CostBook7.equals(exl.read(strDataSheetName, dataRow, "Cost_Book6")))
			{
					rpt.generateReport("", "Review Cost Books", "", "", "System must show list of  cost books", "System is showing list of  cost books", "Passed", "", true);
			}else {
				rpt.generateReport("", "Review Cost Books", "", "", "System must show list of  cost books", "System is showing list of  cost books", "Failed", "", true);
			}
			


		}
	}
}
