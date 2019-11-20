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
Script Name			: HCM_CHILE_TS004_1_Create_Action_WorkforceStructure
Script Description	: Create Action from Workforce Structures
Track/Module		: HCM
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

public class HCM_CHILE_TS004_1_Create_Action_WorkforceStructure extends TestBase{

	String strModule = "HCM";
	
	@Test
	public void HCM_CHILE_TS004_1_Create_Action_WorkforceStructure_TC() throws Throwable {
		rpt = new ReportGeneration("HCM_CHILE_TS004.1_Create_Action", "");

		String strDataSheetName = "TS004_1_Crt_Action";
									
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
			rpt.generateReport("HCM_CHILE_TS004_1_Create_Action_WorkforceStructure", "Enter URL", "", "Password: "+hashmap.get("URL_"+strModule), "URL should be entered", "URL is entered", "Info", "", true );
			rpt.generateReport("", "Enter User Name", "", "UserName: "+hashmap.get("UserName_"+strModule), "UserName should be entered", "UserName is entered", "Info", "", true );
			rpt.generateReport("", "Enter Password", "", "Password: "+hashmap.get("Password_"+strModule), "Password should be entered", "Password is entered", "Info", "", true );
			rpt.generateReport("", "Validate Login to Appication", "", "", "Login Should be successful", "Login Is Successful", "Passed", "", true );
		}else
		{
			//FAIL
			rpt.generateReport("HCM_CHILE_TS004_1_Create_Action_WorkforceStructure", "Login to Appication", "", "UserName: "+exl.read("LoginDetails", 1, "UserName"), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
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
			//cmnLib.clickOnWebElement(homePage_HCM.SetupAndMaintenance_HomePage_Icon);
			 SetupAndMaintenance setupAndMaintenance = new SetupAndMaintenance();
			
			homePage_HCM.clickOnNavigationIcon();

		//Click On Personal Information from Navigator Links
			rpt.enterStepHeader("Navigation to  Setup And Maintenance Page");
			 homePage_HCM.clickOnWorkforceStructures();
			TimeUnit.SECONDS.sleep(5);
			
		//Search Task
			
		   //Below code is commented during 19C reg in dev6
			/*cmnLib.waitForElementToBeVisible(setupAndMaintenance.TasksIcon,10);
			cmnLib.clickOnWebElement(setupAndMaintenance.TasksIcon);*/
			
			
			cmnLib.waitForElementToBeVisible(setupAndMaintenance.ManageActionsLink,10);
			cmnLib.waitForElementToBeVisible(setupAndMaintenance.ManageActionsLink,10);
			cmnLib.clickOnWebElement(setupAndMaintenance.ManageActionsLink);
			
			if(cmnLib.waitForElementToBeVisible(setupAndMaintenance.ManageActionsPage,20))
			{
				rpt.generateReport("", "Create Action", "", "", "Create Action page should be displayed", "Create Action page is displayed", "Passed", "", true );
			}else {
				rpt.generateReport("", "Create Salary Basis", "", "", "Create Action page should be displayed", "Create Action page is NOT displayed", "Failed", "", true );
				Assert.fail("Create Action page is NOT displayed");
			}
			
			cmnLib.waitForElementToBeVisible(setupAndMaintenance.Add_Action, 20);
			cmnLib.clickOnWebElement(setupAndMaintenance.Add_Action);
			
			cmnLib.enterDataInTextBox(setupAndMaintenance.Action_Code,exl.read(strDataSheetName, dataRow, "Action_Code") , true);
			cmnLib.enterDataInTextBox(setupAndMaintenance.Action_Name,exl.read(strDataSheetName, dataRow, "Action_Name") , true);
			setupAndMaintenance.Start_Date.clear();
			cmnLib.enterDataInTextBox(setupAndMaintenance.Start_Date, cmnLib.futureDate("dd/MMM/yyyy", 0), true);
			setupAndMaintenance.End_Date.clear();
			cmnLib.enterDataInTextBox(setupAndMaintenance.End_Date, cmnLib.futureDate("dd/MMM/yyyy", 7), true);
			
			cmnLib.clickOnWebElement(setupAndMaintenance.Action_Type_Dropdown);
			setupAndMaintenance.SelectInputComboBox(exl.read(strDataSheetName, dataRow, "Action_Type"));
			
			cmnLib.clickOnWebElement(setupAndMaintenance.Save_Actions);
			if(cmnLib.waitForElementToBeVisible(setupAndMaintenance.Error, 10))
			{
				rpt.generateReport("", "Create Action", "", "", "Warning message should be dispalyed", "Error message appeared", "Failed", "", true );
				Assert.fail("Error message appeared");
			}
			
			if(cmnLib.waitForElementToBeVisible(setupAndMaintenance.Warning_Action)) 
			{
				rpt.generateReport("", "Create Action", "", "", "Warning message should be dispalyed", "Warning message is dispalyed", "Passed", "", true );
				TimeUnit.SECONDS.sleep(2);
								
				cmnLib.clickOnWebElement(setupAndMaintenance.Warning_Action_Yes);
			}else
			{
				System.out.println("Warning window nt found");
			}
			if(cmnLib.waitForElementToBeVisible(setupAndMaintenance.Confimation_Message, 5))
			{
				rpt.generateReport("", "Create Action", "", "", "Confirmation message should be dispalyed", "Confirmation message is dispalyed", "Passed", "", true );
			}else {
				rpt.generateReport("", "Create Action", "", "", "Confirmation message should be dispalyed", "Confirmation message is NOT dispalyed", "Passed", "", true );
				Assert.fail("Confirmation message is NOT dispalyed");
			}
			
		}
	}



	

}
