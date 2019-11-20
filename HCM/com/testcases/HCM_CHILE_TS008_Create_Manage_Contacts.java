package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.commons.TestBase;

import hcm.pagefactory.BenefitsEnrollment;
import hcm.pagefactory.HomePage_HCM;
import hcm.pagefactory.LoginPage_HCM;
import hcm.pagefactory.ManagePerson;
import hcm.pagefactory.SearchPerson;
import report.oracle.ofs.ReportGeneration;
import xlsx.databank.ofs.ExcelOperations;

/**
Script Name			: HCM_CHILE_TS008_Create_Manage_Contacts
Script Description	: Create Manage Contacts
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

public class HCM_CHILE_TS008_Create_Manage_Contacts extends TestBase {

	String strModule = "HCM";
	
	@Test
	public void HCM_CHILE_TS008_Create_Manage_Contacts_TC() throws Throwable {
		rpt = new ReportGeneration("HCM_CHILE_TS008_Create_Manage_Contacts", "Create Manage Contacts");

		String strDataSheetName = "TS008_Cr_Mng_Contacts";
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
				throw new SkipException("Login Un-Successful");
			}

			login = true;
		}

		//Initialize HomePage Web Elements

		//Validate HomePage Icon
		if(cmnLib.waitForElementToBeVisible(homePage_HCM.HomePage_HomeIcon) == true)
		{
			homePage_HCM = PageFactory.initElements(driver, HomePage_HCM.class);
			//PASS
			rpt.generateReport("HCM_CHILE_TS008_Create_Manage_Contacts", "Enter URL", "", "Password: "+hashmap.get("URL_"+strModule), "URL should be entered", "URL is entered", "Info", "", true );
			rpt.generateReport("", "Enter User Name", "", "UserName: "+hashmap.get("UserName_"+strModule), "UserName should be entered", "UserName is entered", "Info", "", true );
			rpt.generateReport("", "Enter Password", "", "Password: "+hashmap.get("Password_"+strModule), "Password should be entered", "Password is entered", "Info", "", true );
			rpt.generateReport("", "Validate Login to Appication", "", "", "Login Should be successful", "Login Is Successful", "Passed", "", true );
		}else
		{
			//FAIL
			rpt.generateReport("HCM_CHILE_TS008_Create_Manage_Contacts", "Login to Appication", "", "UserName: "+exl.read("LoginDetails", 1, "UserName"), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
			throw new RuntimeException("Login Un-Successful");
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
				throw new SkipException("Login Un-Successful");
			}
			TimeUnit.SECONDS.sleep(5);
			//Click on Navigator Icon
			homePage_HCM.clickOnNavigationIcon();

		//Click On Person Management from Navigator Links
			rpt.enterStepHeader("Navigation to  Benefits Enrollment Page");
			 BenefitsEnrollment benefitsEnrollment = homePage_HCM.clickOnBenefitsEnrollment();
			TimeUnit.SECONDS.sleep(5);
		//Verify Person Number Edit box is displayed
			SearchPerson searchPerson=new SearchPerson();
			if(cmnLib.waitForElementToBeVisible(searchPerson.SearchButton))
			{
				rpt.generateReport("", "Navigation to Benefits Enrollment Page", "", "", "Benefits Enrollment Page should be displayed", "Benefits Enrollment Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to Benefits Enrollment Page", "", "", "Benefits Enrollment Page should be displayed", "Benefits Enrollment Page Is Not displayed", "Failed", "", true );
				throw new SkipException("Benefits Enrollment Page is not displayed");
			}

			rpt.enterStepHeader("Search the Person");
		//Enter the Details to Search the Person
			cmnLib.waitForPageLoaded();
			String strPersonNumber = exl.read(strDataSheetName, dataRow, "Person_Number");
			
			searchPerson.enterPersonNumber(strPersonNumber);
			searchPerson.clickOnSearch();

		//Verify the Entered Person Search Record Exists
			if(searchPerson.verifySearchedRecordExists(strPersonNumber) == false) {
				//Fail
				rpt.generateReport("", "Enter Search Person details", "", "Person Number: "+strPersonNumber, "Entered Person Number details should be displayed", "Entered Person Number details could not be displayed", "Failed", "", true);
				throw new SkipException("Person Number in Search Person page could not be entered");
			}else
			{
				//Pass
				rpt.generateReport("", "Enter Search Person details", "", "Person Number: "+strPersonNumber, "Entered Person Number details should be displayed", "Entered Person Number details is displayed", "Passed", "", true);
			}

			rpt.enterStepHeader("Click on Person Name");
		//Click on Person Name
			if(searchPerson.clickOnSearchedPerson(exl.read(strDataSheetName, dataRow, "Person_Name")) == true)
			{
				rpt.generateReport("", "Click on Person Name", "", exl.read(strDataSheetName, dataRow, "Person_Name"), "Person Name of the Searched Employee should be clicked", "Person Name of the Searched Employee is clicked", "Passed", "", true);
			}else
			{
				rpt.generateReport("", "Click on Person Name", "", exl.read(strDataSheetName, dataRow, "Person_Name"), "Person Name of the Searched Employee should be clicked", "Person Name of the Searched Employee is not clicked", "Failed", "", true);
				Assert.fail("Person Name of the Searched Employee is not clicked");
			}

		//Click on Tasks Icon
			rpt.enterStepHeader("Click on Tasks Icon");
			cmnLib.waitForElementToBeClickable(benefitsEnrollment.TasksIcon);
			
			if(benefitsEnrollment.TasksIcon.isEnabled())
			{
				rpt.generateReport("", "Click on Tasks Icon", "", strPersonNumber, "Participant Benefits Summary page must be dispalyed", "Participant Benefits Summary page is dispalyed", "Passed", "", true);
				cmnLib.clickOnWebElement(benefitsEnrollment.TasksIcon);
			}else
			{
				rpt.generateReport("", "Click on Person Name", "", strPersonNumber, "Participant Benefits Summary page must be dispalyed", "Participant Benefits Summary page is NOT dispalyed", "Failed", "", true);
				Assert.fail("Participant Benefits Summary page is NOT dispalyed");
			}
			
		//Manage Contacts page
			rpt.enterStepHeader("Manage Contacts page");
			cmnLib.waitForElementToBeVisible(benefitsEnrollment.ManageContactsLink);
			cmnLib.clickOnWebElement(benefitsEnrollment.ManageContactsLink);
			
			cmnLib.waitForElementToBeVisible(benefitsEnrollment.EditContactsIcon);
			if(benefitsEnrollment.EditContactsIcon.isEnabled())
			{
				rpt.generateReport("", "Manage Contacts page", "", strPersonNumber, "Manage Contacts page must be dispalyed", "Manage Contacts page is dispalyed", "Passed", "", true);
				cmnLib.clickOnWebElement(benefitsEnrollment.TasksIcon);
			}else
			{
				rpt.generateReport("", "Manage Contacts page", "", strPersonNumber, "Manage Contacts page must be dispalyed", "Manage Contacts page is NOT dispalyed", "Failed", "", true);
				Assert.fail("Manage Contacts page is NOT dispalyed");
			}
			
		//Create Contacts
			cmnLib.clickOnWebElement(benefitsEnrollment.CreateContactsIcon);
			
			cmnLib.waitForElementToBeVisible(benefitsEnrollment.Relationship);
			/*TimeUnit.SECONDS.sleep(3);
			cmnLib.enterDataInTextBox(benefitsEnrollment.Relationship, exl.read(strDataSheetName, dataRow, "Relationship"), true);*/
			cmnLib.clickOnWebElement(benefitsEnrollment.RelationshipDropDown);
			cmnLib.clickOnWebElement(benefitsEnrollment.Relationship);
			TimeUnit.SECONDS.sleep(2);
			cmnLib.enterDataInTextBox(benefitsEnrollment.RelationshipStartDate, exl.read(strDataSheetName, dataRow, "RelationshipStartDate"), true);
			cmnLib.enterDataInTextBox(benefitsEnrollment.PaternalLastName, exl.read(strDataSheetName, dataRow, "PaternalLastName"), true);
			cmnLib.enterDataInTextBox(benefitsEnrollment.FirstName, exl.read(strDataSheetName, dataRow, "FirstName"), true);
			cmnLib.enterDataInTextBox(benefitsEnrollment.DateOfBirth, exl.read(strDataSheetName, dataRow, "DateOfBirth"), true);
			
			rpt.generateReport("", "Adding Contacts", "", strPersonNumber, "Contact details must be entered", "Contacts details are entered", "Passed", "", true);
			cmnLib.clickOnWebElement(benefitsEnrollment.OKButton);
			TimeUnit.SECONDS.sleep(8);
			
			cmnLib.waitForElementToBeVisible(benefitsEnrollment.CreateContactsIcon);
			//TimeUnit.SECONDS.sleep(4);
			String paternalLastName=exl.read(strDataSheetName, dataRow, "PaternalLastName");
			if(benefitsEnrollment.verifySearchedRecordExists(paternalLastName))
			{
				rpt.generateReport("", "Adding Contacts", "", exl.read(strDataSheetName, dataRow, "PaternalLastName"), "Contact details must be successfully entered", "Contacts details are successfully entered", "Passed", "", true);
			}else {
				rpt.generateReport("", "Adding Contacts", "", exl.read(strDataSheetName, dataRow, "PaternalLastName"), "Contact details must be successfully entered", "Contacts details are NOT entered successfully", "Failed", "", true);
				Assert.fail("Contacts details are NOT entered successfully");
			}
			
				
	}	
	
	}


}
