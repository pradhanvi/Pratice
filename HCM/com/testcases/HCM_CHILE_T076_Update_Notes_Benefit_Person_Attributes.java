package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.commons.Common_Library.FrameSelectBy;
import com.commons.TestBase;

import hcm.pagefactory.BenefitsEnrollment;
import hcm.pagefactory.HomePage_HCM;
import hcm.pagefactory.LoginPage_HCM;
import hcm.pagefactory.PersonalInformation;
import hcm.pagefactory.SearchPerson;
import report.oracle.ofs.ReportGeneration;
import xlsx.databank.ofs.ExcelOperations;
/**
Script Name			: HCM_CHILE_T076_Update_Notes_Benefit_Person_Attributes
Script Description	: Update notes Benefit Person Attributes
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

public class HCM_CHILE_T076_Update_Notes_Benefit_Person_Attributes extends TestBase{

	String strModule = "HCM";
	
	@Test
	public void HCM_CHILE_T076_Update_Notes_Benefit_Person_Attributes_TC() throws Throwable {
		rpt = new ReportGeneration("HCM_CHILE_T076_Update_Notes_Benefit_Person_Attributes", "");

		String strDataSheetName = "T076_UpdateNotes";
									
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
			rpt.generateReport("HCM_CHILE_T076_Update_Notes_Benefit_Person_Attributes", "Enter URL", "", "Password: "+hashmap.get("URL_"+strModule), "URL should be entered", "URL is entered", "Info", "", true );
			rpt.generateReport("", "Enter User Name", "", "UserName: "+hashmap.get("UserName_"+strModule), "UserName should be entered", "UserName is entered", "Info", "", true );
			rpt.generateReport("", "Enter Password", "", "Password: "+hashmap.get("Password_"+strModule), "Password should be entered", "Password is entered", "Info", "", true );
			rpt.generateReport("", "Validate Login to Appication", "", "", "Login Should be successful", "Login Is Successful", "Passed", "", true );
		}else
		{
			//FAIL
			rpt.generateReport("HCM_CHILE_T076_Update_Notes_Benefit_Person_Attributes", "Login to Appication", "", "UserName: "+exl.read("LoginDetails", 1, "UserName"), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
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

		//Click On Enrollment
			rpt.enterStepHeader("Navigation to  Enrollment");
			  BenefitsEnrollment benefitsEnrollment = homePage_HCM.clickOnBenefitsEnrollment();
			TimeUnit.SECONDS.sleep(5);
			
		//Verifying  Benefits Enrollment page
			rpt.enterStepHeader("Verifying  Benefits Enrollment page");
			if(cmnLib.waitForElementToBeVisible(benefitsEnrollment.EnrollmentPage))
			{
				rpt.generateReport("", "Verify Enrollment Page", "", "", "Enrollment Page must be opened", "Enrollment Page is opened", "Passed", "", true);
			}else {
				rpt.generateReport("", "Verify Enrollment Page", "", "", "Enrollment Page must be opened", "Enrollment Page is NOT opened", "Failed", "", true);
				Assert.fail("Enrollment Page is NOT opened");
			}
			
		//Enter Person Number
			rpt.enterStepHeader("Entering Person Number for search");
			SearchPerson Person_Management = new SearchPerson();
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

			if(cmnLib.clickOnLinkText(exl.read(strDataSheetName, dataRow, "Person_Name")))
			{
				log.info("Clicked on Person Name");
			}else {
				log.info("Not Clicked on Person Name");
				Assert.fail("Not Clicked on Person Name");
			}
			
			//Verifying  Participant Benefits Summary page
			rpt.enterStepHeader("Verifying  Participant Benefits Summary page");
			cmnLib.waitForPageLoaded();
			if(cmnLib.waitForElementToBeVisible(benefitsEnrollment.ParticipantBenefitsSummaryPage,20))
			{
				rpt.generateReport("", "Verify Participant Benefits Summary page", "", "", "Participant Benefits Summary Page must be opened", "Participant Benefits Summary Page is opened", "Passed", "", true);
			}else {
				rpt.generateReport("", "Verify Participant Benefits Summary Page", "", "", "Participant Benefits Summary Page must be opened", "Participant Benefits Summary Page is NOT opened", "Failed", "", true);
				Assert.fail("Participant Benefits Summary Page is NOT opened");
			}
			
			cmnLib.clickOnWebElement(benefitsEnrollment.ExpandPersonAttributesInformation);
			cmnLib.clickOnWebElement(benefitsEnrollment.Notes);
			if(cmnLib.waitForElementToBeVisible(benefitsEnrollment.NotesPopUp, 20))
			{
				rpt.generateReport("", "Displays Notes Page", "", "", "Displays Notes Page", "Notes page is displayed", "Passed", "", true);
			}else {
				rpt.generateReport("", "Displays Notes Page", "", "", "Displays Notes Page", "Notes page is NOT displayed", "Failed", "", true);
				Assert.fail("Notes page is NOT displayed");
			}
			
			cmnLib.clickOnWebElement(benefitsEnrollment.ActionsDropDown);
			cmnLib.clickOnWebElement(benefitsEnrollment.Notes_Create);
			
			if(cmnLib.waitForElementToBeVisible(benefitsEnrollment.CreateNoteWindow, 20))
			{
				rpt.generateReport("", "Displays Create Notes Page", "", "", "Displays Create Notes page", "Create Notes page is displayed", "Passed", "", true);
			}else {
				rpt.generateReport("", "Displays Create Notes Page", "", "", "Displays Create Notes Page", "Create Notes page is NOT displayed", "Failed", "", true);
				Assert.fail("Create Notes page is NOT displayed");
			}
			
			cmnLib.switchToFrame(benefitsEnrollment.iframeNotes,FrameSelectBy.FrameWebElement);
			cmnLib.enterDataInTextBox(benefitsEnrollment.Notes_Desc, exl.read(strDataSheetName, dataRow, "Notes_Desc"), true);
			
			rpt.generateReport("", "Create Notes Page", "", "", "Create Notes page", "Notes description is entered", "Passed", "", true);
			TimeUnit.SECONDS.sleep(3);
			driver.switchTo().defaultContent();
			//cmnLib.switchToFrame("afr::PushIframe",FrameSelectBy.StringFrameName);
			if(cmnLib.clickOnWebElement(benefitsEnrollment.SaveAndCloseBtn)) {
				System.out.println("Clicked on Save and close button");
			}
			
			if(cmnLib.waitForElementToBeVisible(benefitsEnrollment.NotesPopUp, 20))
			{
				TimeUnit.SECONDS.sleep(5);
				rpt.generateReport("", "Update Notes Page", "", "", "Notes should be updated", "Notes are updated", "Passed", "", true);
			}else {
				rpt.generateReport("", "Update Notes Page", "", "", "Notes should be updated", "Notes not updated", "Failed", "", true);
			}
			
		}
	}

}
