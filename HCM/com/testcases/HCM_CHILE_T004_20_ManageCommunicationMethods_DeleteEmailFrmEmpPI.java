package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.commons.TestBase;

import hcm.pagefactory.HomePage_HCM;
import hcm.pagefactory.LoginPage_HCM;import hcm.pagefactory.ManageCommunication;
import hcm.pagefactory.PersonalInformation;
import report.oracle.ofs.ReportGeneration;
import xlsx.databank.ofs.ExcelOperations;

/**
Script Name			: HCM_CHILE_T004_20_ManageCommunicationMethods_DeleteEmailFrmEmpPI
Script Description	: Manage Communication methods - Delete Email from Emp PI
Track/Module		: HCM
Sub Track			: 
Created By			: Pradhanvi T R
Creation Date		: 
Modified By 		: 
Modification Date	: 
Instance Name & URL : https://edyg-dev6.login.us2.oraclecloud.com
User ID/ Password	: AUTO.HCM_USER/********
Responsibility		: 
Pre-Requisites		: 2 records are needed , cannot delete primary record
Comments (if any)	:
 **/

public class HCM_CHILE_T004_20_ManageCommunicationMethods_DeleteEmailFrmEmpPI extends TestBase {
	String strModule = "HCM_EMP";
	
	@Test
	public void HCM_CHILE_T004_20_ManageCommunicationMethods_DeleteEmailFrmEmpPI_TC() throws Throwable {
		rpt = new ReportGeneration("HCM_CHILE_T004_20_ManageCommunicationMethods", "Delete Email from Emp PI");

		String strDataSheetName = "T004_20_ManageCommMthds";
									
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
			rpt.generateReport("HCM_CHILE_T004_20_ManageCommunicationMethods_DeleteEmailFrmEmpPI", "Enter URL", "", "Password: "+hashmap.get("URL_"+strModule), "URL should be entered", "URL is entered", "Info", "", true );
			rpt.generateReport("", "Enter User Name", "", "UserName: "+hashmap.get("UserName_"+strModule), "UserName should be entered", "UserName is entered", "Info", "", true );
			rpt.generateReport("", "Enter Password", "", "Password: "+hashmap.get("Password_"+strModule), "Password should be entered", "Password is entered", "Info", "", true );
			rpt.generateReport("", "Validate Login to Appication", "", "", "Login Should be successful", "Login Is Successful", "Passed", "", true );
		}else
		{
			//FAIL
			rpt.generateReport("HCM_CHILE_T004_20_ManageCommunicationMethods_DeleteEmailFrmEmpPI", "Login to Appication", "", "UserName: "+exl.read("LoginDetails", 1, "UserName"), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
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
			homePage_HCM.clickOnNavigationIcon();

		//Click On Personal Information from Navigator Links
			PersonalInformation personalInfo = homePage_HCM.clickOnPersonalInformation();
			TimeUnit.SECONDS.sleep(5);
			
			
		//Verify Personal Information page is opened
			if(cmnLib.waitForElementToBeVisible(personalInfo.PersonalInformationHeader, 30))
			{
				rpt.generateReport("", "Navigation to Persoanl Information Page", "", "", "Persoanl Information Page should be displayed", "Persoanl Information Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to Persoanl Information Page", "", "", "Persoanl Information Page should be displayed", "Persoanl Information Page Is Not displayed", "Failed", "", true );
				Assert.fail("Persoanl Information Page is not displayed");
			}

		//Delete Email ID
			
			cmnLib.clickOnWebElement(personalInfo.EditButton);
			
			cmnLib.waitForElementToBeVisible(personalInfo.CreateContactDrop, 20);
			
			TimeUnit.SECONDS.sleep(3);
			
			if(!cmnLib.clickOnWebElement(personalInfo.DeleteEmail_PI))
			{
				rpt.generateReport("", "Delete Email ID", "", "", "Email ID should be Deleted", "Deletion of Email is prohibited", "Failed", "", true);
			}
			
			rpt.generateReport("", "Delete Email ID", "", "", "All the details must be entered ", "All the details are entered", "Passed", "", true);
			TimeUnit.SECONDS.sleep(3);
			cmnLib.clickOnWebElement(personalInfo.SaveAndCloseButton);
			
			
			if(cmnLib.waitForElementToBeVisible(personalInfo.PersonalInformationHeader, 20))
			{
				rpt.generateReport("", "Delete Email ID", "", "", "Email ID should be deleted", "Successfully deleted Email ID", "Passed", "", true);
			}else {
				rpt.generateReport("", "Delte Email ID", "", "", "Email ID should be deleted", "Error occured while deleting Email ID", "Failed", "", true);
				Assert.fail("Error occured while deleting Email ID");
			}
			TimeUnit.SECONDS.sleep(2);
			
}
}


}
