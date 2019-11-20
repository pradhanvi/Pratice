package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.commons.TestBase;

import hcm.pagefactory.BenefitsEnrollment;
import hcm.pagefactory.HomePage_HCM;
import hcm.pagefactory.LoginPage_HCM;
import hcm.pagefactory.ManageContact;
import hcm.pagefactory.SearchPerson;
import report.oracle.ofs.ReportGeneration;
import xlsx.databank.ofs.ExcelOperations;

/**
Script Name			: HCM_CHILE_T005_2_AddPersonalRelationship_EditFrmHRSplt
Script Description	: Add Relationship - Edit Personal Relationship from HR Specialist
Track/Module		: HCM
Sub Track			: 
Created By			: Pradhanvi T R
Creation Date		: 
Modified By 		: 
Modification Date	: 
Instance Name & URL : https://edyg-dev6.login.us2.oraclecloud.com
User ID/ Password	: AUTO.HCM_USER/********
Responsibility		: 
Pre-Requisites		: 
Comments (if any)	:
 **/

public class HCM_CHILE_T005_2_AddPersonalRelationship_EditFrmHRSplt extends TestBase{


	String strModule = "HCM";
	
	@Test
	public void HCM_CHILE_T005_2_AddPersonalRelationship_EditFrmHRSplt_TC() throws Throwable {
		rpt = new ReportGeneration("HCM_CHILE_T005_2_AddPersonalRelationship", "Edit Personal Relationship from HR Specialist");

		String strDataSheetName = "T005_2_AddPersoRelatshp";
									
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
			rpt.generateReport("HCM_CHILE_T005_2_AddPersonalRelationship_EditFrmHRSplt", "Enter URL", "", "Password: "+hashmap.get("URL_"+strModule), "URL should be entered", "URL is entered", "Info", "", true );
			rpt.generateReport("", "Enter User Name", "", "UserName: "+hashmap.get("UserName_"+strModule), "UserName should be entered", "UserName is entered", "Info", "", true );
			rpt.generateReport("", "Enter Password", "", "Password: "+hashmap.get("Password_"+strModule), "Password should be entered", "Password is entered", "Info", "", true );
			rpt.generateReport("", "Validate Login to Appication", "", "", "Login Should be successful", "Login Is Successful", "Passed", "", true );
		}else
		{
			//FAIL
			rpt.generateReport("HCM_CHILE_T005_2_AddPersonalRelationship_EditFrmHRSplt", "Login to Appication", "", "UserName: "+exl.read("LoginDetails", 1, "UserName"), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
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

		//Click On Person Management from Navigator Links
			SearchPerson Person_Management = homePage_HCM.clickOnPersonManagementLink();
			TimeUnit.SECONDS.sleep(5);
			
			
		//Verify Person Number Edit box is displayed
			if(Person_Management.PersonNumber.isDisplayed() == true)
			{
				rpt.generateReport("", "Navigation to Person Management Page", "", "", "Person Management Page should be displayed", "Person Management Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to Person Management Page", "", "", "Person Management Page should be displayed", "Person Management Page Is Not displayed", "Failed", "", true );
				throw new SkipException("Person Management Page is not displayed");
			}

			rpt.enterStepHeader("Search the Person");
		//Enter the Details to Search the Person
			String strPersonNumber = exl.read(strDataSheetName, dataRow, "Person_Number");
			Person_Management.enterPersonNumber(strPersonNumber);
			Person_Management.clickOnSearch();

		//Verify the Entered Person Search Record Exists
			if(Person_Management.verifySearchedRecordExists(strPersonNumber) == false) {
				//Fail
				rpt.generateReport("", "Enter Search Person details", "", "Person Number: "+strPersonNumber, "Entered Person Number details should be displayed", "Entered Person Number details could not be displayed", "Failed", "", true);
				throw new SkipException("Person Number in Search Person page could not be entered");
			}else
			{
				//Pass
				rpt.generateReport("", "Enter Search Person details", "", "Person Number: "+strPersonNumber, "Entered Person Number details should be displayed", "Entered Person Number details is displayed", "Passed", "", true);
			}

			rpt.enterStepHeader("Select Create Work Relationship from Action Button");
		//Click On the Action Button of the Searched Person
			if(Person_Management.clickOnActionButtonForSearchedPerson(strPersonNumber) == true) {
				rpt.generateReport("", "Click on Action Button", "", strPersonNumber, "Action button of the Searched Employee should be clicked", "Action button of the Searched Employee is clicked", "Passed", "", true);
			}else
			{
				rpt.generateReport("", "Click on Action Button", "", strPersonNumber, "Action button of the Searched Employee should be clicked", "Action button of the Searched Employee is not clicked", "Failed", "", true);
			}

		//Select Personal And Employment and Select Create Work Relationship
			if(Person_Management.mouseHoverClickAfterClickOnActionButton(exl.read(strDataSheetName, dataRow, "SubMenu_1"))) {
				rpt.generateReport("", "Select Personal and Employment from Action Button", "", "", "Personal and Employment should be selected", "Personal and Employment is selected", "Passed", "", false);
				if(Person_Management.mouseHoverClickAfterClickOnActionButton(exl.read(strDataSheetName, dataRow, "SubMenu_2"))) {
					rpt.generateReport("", "Select Manage Person Action Button", "", "", "Create Work Relationship should be selected", "Create Work Relationship is selected", "Passed", "", true);
				}else {
					rpt.generateReport("", "Select Manage Person from Action Button", "", "", "Create Work Relationship should be selected", "Create Work Relationship is not selected", "Failed", "", true);
					throw new SkipException("Unable to perform mouse Hover and Click the Menu");
				}
			}else {
				rpt.generateReport("", "Select Personal and Employment from Action Button", "", "", "Personal and Employment should be selected", "Personal and Employment is not selected", "Failed", "", false);
				throw new SkipException("Unable to perform mouse Hover and Click the Menu");
			}
			
		
			ManageContact manageContact=new ManageContact();
			TimeUnit.SECONDS.sleep(5);
		//Clicking on Contact Tab
				cmnLib.clickOnWebElement(manageContact.ContactsTab);
				rpt.generateReport("", "Clicking on Contacts Tab", "", "", "Clicking on Contacts Tab", "Clicking on Contacts Tab", "Passed", "", true);
				TimeUnit.SECONDS.sleep(10);
				
				BenefitsEnrollment benefitsEnrollment = new BenefitsEnrollment();
				
				
				
				cmnLib.waitForElementToBeVisible(benefitsEnrollment.EditContactsIcon);
				if(benefitsEnrollment.EditContactsIcon.isEnabled())
				{
					rpt.generateReport("", "Manage Contacts page", "", strPersonNumber, "Manage Contacts page must be dispalyed", "Manage Contacts page is dispalyed", "Passed", "", true);
					//cmnLib.clickOnWebElement(benefitsEnrollment.TasksIcon);
				}else
				{
					rpt.generateReport("", "Manage Contacts page", "", strPersonNumber, "Manage Contacts page must be dispalyed", "Manage Contacts page is NOT dispalyed", "Failed", "", true);
					Assert.fail("Manage Contacts page is NOT dispalyed");
				}
				
			//Selecting the Contact to edit
				if(manageContact.ClickOnSearchedResults(exl.read(strDataSheetName, dataRow, "PaternalLastName_Edit")) == true)
				{
					rpt.generateReport("", "Click on Person Name", "", exl.read(strDataSheetName, dataRow, "PaternalLastName_Edit"), "Person Name of the Searched Employee should be clicked", "Person Name of the Searched Employee is clicked", "Passed", "", true);
				}else
				{
					rpt.generateReport("", "Click on Person Name", "", exl.read(strDataSheetName, dataRow, "PaternalLastName_Edit"), "Person Name of the Searched Employee should be clicked", "Person Name of the Searched Employee is not clicked", "Failed", "", true);
					Assert.fail("Person Name of the Searched Employee is not clicked");
				}
				
			//Edit Contacts
				cmnLib.clickOnWebElement(benefitsEnrollment.EditContactsIcon);
				
				
				cmnLib.waitForElementToBeVisible(manageContact.Name_Edit, 20);
				rpt.generateReport("", "Edit Personal relationship contact details", "", "", "Edit Contact page", "Edit Contact page befor Editing", "Passed", "", true);
				cmnLib.clickOnWebElement(manageContact.Name_Edit);
				cmnLib.clickOnWebElement(manageContact.Update_Name);
				cmnLib.waitForElementToBeVisible(manageContact.ContactEffectiveDate, 20);
				cmnLib.enterDataInTextBox(manageContact.ContactEffectiveDate, cmnLib.futureDate("dd/MMM/YYYY",0), true);
				rpt.generateReport("", "Edit Personal relationship contact details", "", "", "Effective date Pop up should appear", "Effective date Pop up appeared", "Passed", "", true);
				cmnLib.clickOnWebElement(manageContact.OK_EffectiveDate);
				
				cmnLib.waitForElementToBeVisible(manageContact.ContactPaternalName, 20);
				cmnLib.enterDataInTextBox(manageContact.ContactPaternalName,exl.read(strDataSheetName, dataRow, "ContactPaternalName") , true);
				cmnLib.enterDataInTextBox(manageContact.ContactFirstName, exl.read(strDataSheetName, dataRow, "ContactFirstName"), true);
				rpt.generateReport("", "Edit Personal relationship contact details", "", "", "Update Name deatils should be entered", "Update Name deatils is entered", "Passed", "", true);
				cmnLib.clickOnWebElement(manageContact.UpdateName_OK);
				
				cmnLib.enterDataInTextBox(manageContact.ContactDOB, exl.read(strDataSheetName, dataRow, "ContactDOB"), true);
				
				cmnLib.clickOnWebElement(manageContact.TypeDrop);
				driver.findElement(By.xpath("//li[text()='"+exl.read(strDataSheetName, dataRow, "PhoneType")+"']")).click();
				cmnLib.enterDataInTextBox(manageContact.ContactPhoneNumber, exl.read(strDataSheetName, dataRow, "PhoneNum"), true);
				
				cmnLib.clickOnWebElement(manageContact.Address_Edit);
				cmnLib.clickOnWebElement(manageContact.Address_Update);
				
				cmnLib.waitForElementToBeVisible(manageContact.Address_EffectiveDate, 20);
				cmnLib.enterDataInTextBox(manageContact.Address_EffectiveDate, cmnLib.futureDate("dd/MMM/YYYY",0), true);
				cmnLib.clickOnWebElement(manageContact.Address_EffectiveDate_OK);
				
				
				//cmnLib.clickOnWebElement(manageContact.UpdateAddress_Type);
				//driver.findElement(By.xpath("//li[text()='"+exl.read(strDataSheetName, dataRow, "AddressType")+"']")).click();
				cmnLib.enterDataInTextBox(manageContact.UpdateAddress_Line1, exl.read(strDataSheetName, dataRow, "Address Line 1"), true);
				rpt.generateReport("", "Edit Personal relationship contact details", "", "", "Update Address deatils should be entered", "Update Address deatils is entered", "Passed", "", true);
				cmnLib.clickOnWebElement(manageContact.UpdateAddress_OK);
				rpt.generateReport("", "Edit Personal relationship contact details", "", "", "Should Enter all the required details", "All the required details are entered", "Passed", "", true);
				cmnLib.clickOnWebElement(manageContact.EditContact_OK);
				
				TimeUnit.SECONDS.sleep(5);
					
		//Submit 
				cmnLib.waitForElementToBeVisible(manageContact.SubmitButton, 30);
				cmnLib.clickOnWebElement(manageContact.SubmitButton);
				
				if(cmnLib.waitForElementToBeVisible(manageContact.Warning_Popup, 30))
				{
					rpt.generateReport("", "Edit Personal relationship contact", "", "", "Warning message must Pop up", "Warning message is Popping up", "Passed", "", true);
					TimeUnit.SECONDS.sleep(3);
					cmnLib.clickOnWebElement(manageContact.Yes_Warning);
				}
				
		//Confirmation
				if(cmnLib.waitForElementToBeVisible(manageContact.Confirmation_PopUp, 30))
				{
					rpt.generateReport("", "Edit Personal relationship contact", "", "", "Confirmation message must Pop up", "Confirmation message is Popping up", "Passed", "", true);
					TimeUnit.SECONDS.sleep(3);
					cmnLib.clickOnWebElement(manageContact.Ok_Confirmation);
				}else {
					rpt.generateReport("", "Edit Personal relationship contact", "", "", "Confirmation message must Pop up", "Confirmation message has not Popped up", "Failed", "", true);
					Assert.fail("Confirmation message has not Popped up");
				}
}
}


}
