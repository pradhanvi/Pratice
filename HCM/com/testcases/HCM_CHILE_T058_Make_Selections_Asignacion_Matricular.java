package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.commons.TestBase;
import com.commons.Common_Library.FrameSelectBy;

import hcm.pagefactory.BenefitsEnrollment;
import hcm.pagefactory.HomePage_HCM;
import hcm.pagefactory.LoginPage_HCM;
import hcm.pagefactory.PersonalInformation;
import hcm.pagefactory.SearchPerson;
import report.oracle.ofs.ReportGeneration;
import xlsx.databank.ofs.ExcelOperations;

/**
Script Name			: HCM_CHILE_T058_Make_Selections_Asignacion_Matricular
Script Description	: Make Selections Asignacion Matricular
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

public class HCM_CHILE_T058_Make_Selections_Asignacion_Matricular extends TestBase {

	String strModule = "HCM";
	
	@Test
	public void HCM_CHILE_T058_Make_Selections_Asignacion_Matricular_TC() throws Throwable {
		rpt = new ReportGeneration("HCM_CHILE_T058_Make_Selections_Asignacion_Matricular", "");

		String strDataSheetName = "T058_SlctAsignacionMatricular";
									
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
			rpt.generateReport("HCM_CHILE_T058_Make_Selections_Asignacion_Matricular", "Enter URL", "", "Password: "+hashmap.get("URL_"+strModule), "URL should be entered", "URL is entered", "Info", "", true );
			rpt.generateReport("", "Enter User Name", "", "UserName: "+hashmap.get("UserName_"+strModule), "UserName should be entered", "UserName is entered", "Info", "", true );
			rpt.generateReport("", "Enter Password", "", "Password: "+hashmap.get("Password_"+strModule), "Password should be entered", "Password is entered", "Info", "", true );
			rpt.generateReport("", "Validate Login to Appication", "", "", "Login Should be successful", "Login Is Successful", "Passed", "", true );
		}else
		{
			//FAIL
			rpt.generateReport("HCM_CHILE_T058_Make_Selections_Asignacion_Matricular", "Login to Appication", "", "UserName: "+exl.read("LoginDetails", 1, "UserName"), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
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
			
			cmnLib.clickOnWebElement(benefitsEnrollment.TasksIcon);
			cmnLib.clickOnWebElement(benefitsEnrollment.UnrestrictedEnrollments);
			
			rpt.enterStepHeader("Verifying  Unrestricted Enrollments page");
			if(cmnLib.waitForElementToBeVisible(benefitsEnrollment.ReprocessIcon, 20))
				cmnLib.clickOnWebElement(benefitsEnrollment.ReprocessIcon);
			
			if(cmnLib.waitForElementToBeVisible(benefitsEnrollment.UnrestrictedEnrollmentsPage,20))
			{
				rpt.generateReport("", "Verifying  Unrestricted Enrollments page", "", "", "Unrestricted Enrollments Page must be opened", "Unrestricted Enrollments Page is opened", "Passed", "", true);
			}else {
				rpt.generateReport("", "Verifying  Unrestricted Enrollments page", "", "", "Unrestricted Enrollments Page must be opened", "Unrestricted Enrollments Page is NOT opened", "Failed", "", true);
				Assert.fail("Unrestricted Enrollments Page is NOT opened");
			}
			
			PersonalInformation personalInformation = new PersonalInformation();
			
			if(personalInformation.selectValueFromInputComboBox("Program or Plan", exl.read(strDataSheetName, dataRow, "Program or Plan")) && cmnLib.clickOnWebElement(benefitsEnrollment.GoBtn))
			{
				rpt.generateReport("", "Selecting Programs or Plan", "", "", "Unrestricted Enrollments Page must be opened", "Unrestricted Enrollments Page is opened", "Passed", "", true);
			}else {
				rpt.generateReport("", "Selecting Programs or Plan", "", "", "Unrestricted Enrollments Page must be opened", "Unrestricted Enrollments Page is NOT opened", "Failed", "", true);
				Assert.fail("Unrestricted Enrollments Page is NOT opened");
			}
			
			cmnLib.clickOnWebElement(benefitsEnrollment.AidsAndBonusExpand);
			cmnLib.waitForPageLoaded();
			
			driver.findElement(By.xpath("//span[text()='"+exl.read(strDataSheetName, dataRow, "PlanType")+"']/../../../../tr/td[2]/span/span/span/span/label")).click();
			
			rpt.generateReport("", "Make Selections", "", exl.read(strDataSheetName, dataRow, "PlanType"), "Plan type should be selected", "Plan type is selected", "Passed", "", true);
			cmnLib.clickOnWebElement(benefitsEnrollment.SaveBtn);
			
			
			if(cmnLib.waitForElementToBeVisible(benefitsEnrollment.ConfirmationMsg, 20))
			{
				rpt.generateReport("", "Make Selections", "", "", "Confirmation Message should appear", "Confirmation Message appeared. Enrollments are saved", "Passed", "", true);
				cmnLib.clickOnWebElement(benefitsEnrollment.ConfirmationOkBtn);
			}else {
				rpt.generateReport("", "Make Selections", "", "", "Confirmation Message should appear", "Confirmation Message did not appeared. Enrollments are NOT saved", "Passed", "", true);
				Assert.fail("Confirmation Message did not appeared. Enrollments are NOT saved");
			}
		}
	}
}
