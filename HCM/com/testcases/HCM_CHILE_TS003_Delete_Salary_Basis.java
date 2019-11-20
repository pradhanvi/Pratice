package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.commons.TestBase;

import hcm.pagefactory.HomePage_HCM;
import hcm.pagefactory.LoginPage_HCM;
import hcm.pagefactory.SetupAndMaintenance;
import report.oracle.ofs.ReportGeneration;
import xlsx.databank.ofs.ExcelOperations;


/**
Script Name			: HCM_CHILE_TS003_Delete_Salary_Basis
Script Description	: Delete Salary Basis
Track/Module		: HCM
Sub Track			: 
Created By			: Pradhanvi T R
Creation Date		: 01-May-19
Modified By 		: 
Modification Date	: 
Instance Name & URL : https://edyg-dev6.fa.us2.oraclecloud.com/ 
User ID/ Password	: AUTO.HCM_USER/Oracle123
Responsibility		: 
Pre-Requisites		: Existing Salary Basis must be provided
Comments (if any)	:
 **/

public class HCM_CHILE_TS003_Delete_Salary_Basis extends TestBase {


	String strModule = "HCM";
	
	@Test
	public void HCM_CHILE_TS003_Delete_Salary_Basis_TC() throws Throwable {
		rpt = new ReportGeneration("HCM_CHILE_TS003_Delete_Salary_Basis", "");

		String strDataSheetName = "TS003_Delete_SalBasis";
									
		boolean login = false;
		
		rpt.enterStepHeader("Login To Application");
		HomePage_HCM homePage_HCM = null;
		if(! (new HomePage_HCM().getUserNameFromHomePage() != null && new HomePage_HCM().getUserNameFromHomePage().equalsIgnoreCase(hashmap.get("UserName_"+strModule)))) {

			//Launch Browser
			launchBrowser(strModule);

			//Login To Application
			LoginPage_HCM loginPage_HCM = PageFactory.initElements(driver, LoginPage_HCM.class);
		
			homePage_HCM = loginPage_HCM.login(hashmap.get("UserName_"+strModule), hashmap.get("Password_"+strModule));
			rpt.enterStepHeader("Login to Application");
			if (homePage_HCM != null) {
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
		if(cmnLib.waitForElementToBeVisible(homePage_HCM.HomePage_HomeIcon) == true)
		{
			homePage_HCM = PageFactory.initElements(driver, HomePage_HCM.class);
			//PASS
			rpt.generateReport("HCM_CHILE_TS003_Delete_Salary_Basis", "Enter URL", "", "Password: "+hashmap.get("URL_"+strModule), "URL should be entered", "URL is entered", "Info", "", true );
			rpt.generateReport("", "Enter User Name", "", "UserName: "+hashmap.get("UserName_"+strModule), "UserName should be entered", "UserName is entered", "Info", "", true );
			rpt.generateReport("", "Enter Password", "", "Password: "+hashmap.get("Password_"+strModule), "Password should be entered", "Password is entered", "Info", "", true );
			rpt.generateReport("", "Validate Login to Appication", "", "", "Login Should be successful", "Login Is Successful", "Passed", "", true );
		}else
		{
			//FAIL
			rpt.generateReport("HCM_CHILE_TS003_Delete_Salary_Basis", "Login to Appication", "", "UserName: "+exl.read("LoginDetails", 1, "UserName"), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
			Assert.fail("Login Un-Successful");
		}

		
		//Always Load TestData Sheet Excel After Login as UserName & Password exists in other Excel which is loaded in TestBase
		exl = new ExcelOperations("HCM\\com\\dataBanks\\HCM_TestData.xlsx");

		// Script will execute for all the Rows present in the Data Sheet.
		System.out.println("No Of DataRows: "+exl.getRowCount(strDataSheetName));
		for (int dataRow = 1; dataRow < exl.getRowCount(strDataSheetName); dataRow++) {

			//Navigation
			if(homePage_HCM.clickOnWelcomePage_HomeIcon() == true)
			{
				homePage_HCM = PageFactory.initElements(driver, HomePage_HCM.class);
			}else
			{
				rpt.generateReport("", "Click On HomePage Icon", "", "", "HomePage Icon should be clicked", "HomePage Icon is not clicked", "Failed", "", true);
			}

			//Verify Presence of Navigator Icon
			if(homePage_HCM.NavigatorIcon.isDisplayed() == false)
			{
				//FAIL
				rpt.generateReport("", "Validate HomePage", "", "", "Validation Should be successful", "Validation Is Not Successful", "Failed", "", true );
				Assert.fail("Login Un-Successful");
			}
			TimeUnit.SECONDS.sleep(5);
			//Click on Navigator Icon
			
			cmnLib.clickOnWebElement(homePage_HCM.SetupAndMaintenance_HomePage_Icon);
			 SetupAndMaintenance setupAndMaintenance = new SetupAndMaintenance();
			/*homePage_HCM.clickOnNavigationIcon();

		//Click On Personal Information from Navigator Links
			rpt.enterStepHeader("Navigation to  Setup And Maintenance Page");
			 SetupAndMaintenance setupAndMaintenance = homePage_HCM.clickOnSetupAndMaintenance();*/
			TimeUnit.SECONDS.sleep(5);
			
		//Search Task
			cmnLib.waitForElementToBeVisible(setupAndMaintenance.TasksIcon,10);
			cmnLib.clickOnWebElement(setupAndMaintenance.TasksIcon);
			cmnLib.clickOnWebElement(setupAndMaintenance.SearchAction);
			cmnLib.waitForElementToBeVisible(setupAndMaintenance.SearchBar);
			cmnLib.enterDataInTextBox(setupAndMaintenance.SearchBar, exl.read(strDataSheetName, dataRow, "Search_Action"), true);
			cmnLib.clickOnWebElement(setupAndMaintenance.SearchIcon);
			rpt.generateReport("", "Selecting the Task", "", "Manage Salary Basis", "Task must appear in search result", "Task appeared in search result", "Passed", "", true );
			cmnLib.clickOnLinkText("Manage Salary Basis");
			
			cmnLib.waitForElementToBeVisible(setupAndMaintenance.Search_Name, 10);
			cmnLib.enterDataInTextBox(setupAndMaintenance.Search_Name, exl.read(strDataSheetName, dataRow, "Salary_Name"), true);
			cmnLib.clickOnWebElement(setupAndMaintenance.SearchButton);
			
			/* if(setupAndMaintenance.ClickOnSearchedResults())
			 {
				   rpt.generateReport("", "Delete Salary Basisc", "", "", "Should select the salary basis","Salary Basis are selected", "Passed", "", true);
			 }else {
				 rpt.generateReport("", "Delete Salary Basisc", "", "", "Should select the salary basis","Salary Basis are NOT selected", "Failed", "", true);
				   Assert.fail("Salary Basis are NOT selected");
			 }*/
			
			 cmnLib.clickOnWebElement(setupAndMaintenance.DeleteIcon);
			
			 if(cmnLib.waitForElementToBeVisible(setupAndMaintenance.WarningPopUp, 10))
			 {
				 TimeUnit.SECONDS.sleep(2);
				 rpt.generateReport("", "Delete Salary Basisc", "", "", "Warning message should Popup","Warning message Popup appeared", "Passed", "", true);
				 cmnLib.clickOnWebElement(setupAndMaintenance.Yes_WarningPOPup);
			 }else {
				 rpt.generateReport("", "Delete Salary Basisc", "", "", "Warning message should Popup","Warning message Popup did not appear", "Failed", "", true);
				 Assert.fail("Warning message Popup did not appear");
			 }
			
			 cmnLib.enterDataInTextBox(setupAndMaintenance.Search_Name, exl.read(strDataSheetName, dataRow, "Salary_Name"), true);
				
			 cmnLib.clickOnWebElement(setupAndMaintenance.SearchButton);
				
			if(!setupAndMaintenance.verifySearchedRecordExists(exl.read(strDataSheetName, dataRow, "Salary_Name")))
			{
				rpt.generateReport("", "Delete Salary Basis", "", "", "Salary Basis should be Deleted", "Salary Basis is Deleted", "Passed", "", true );
			}else {
				rpt.generateReport("", "Delete Salary Basis", "", "", "Salary Basis should be Deleted", "Salary Basis is NOT Deleted", "Failed", "", true );
				Assert.fail("Salary Basis is NOT Deleted");
			}
			
		}
	}

}
