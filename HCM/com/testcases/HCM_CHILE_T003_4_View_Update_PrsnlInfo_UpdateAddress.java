package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.commons.TestBase;

import hcm.pagefactory.HomePage_HCM;
import hcm.pagefactory.LoginPage_HCM;
import hcm.pagefactory.ManagePerson;
import hcm.pagefactory.SearchPerson;
import hcm.pagefactory.SetupAndMaintenance;
import report.oracle.ofs.ReportGeneration;
import xlsx.databank.ofs.ExcelOperations;

/**
Script Name			: HCM_CHILE_T003_4_View_Update_PrsnlInfo_UpdateAddress
Script Description	: View and Update Personal Information - Update Address
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

public class HCM_CHILE_T003_4_View_Update_PrsnlInfo_UpdateAddress extends TestBase {




	String strModule = "HCM";
	
	@Test
	public void HCM_CHILE_T003_4_View_Update_PrsnlInfo_UpdateAddress_TC() throws Throwable {
		rpt = new ReportGeneration("HCM_CHILE_T003_4_View_Update_PrsnlInfo", "Update Address");

		String strDataSheetName = "T003_4_ViewUpdate_PrsnInfo";
									
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
			rpt.generateReport("HCM_CHILE_T003_4_View_Update_PrsnlInfo_UpdateAddress", "Enter URL", "", "Password: "+hashmap.get("URL_"+strModule), "URL should be entered", "URL is entered", "Info", "", true );
			rpt.generateReport("", "Enter User Name", "", "UserName: "+hashmap.get("UserName_"+strModule), "UserName should be entered", "UserName is entered", "Info", "", true );
			rpt.generateReport("", "Enter Password", "", "Password: "+hashmap.get("Password_"+strModule), "Password should be entered", "Password is entered", "Info", "", true );
			rpt.generateReport("", "Validate Login to Appication", "", "", "Login Should be successful", "Login Is Successful", "Passed", "", true );
		}else
		{
			//FAIL
			rpt.generateReport("HCM_CHILE_T003_4_View_Update_PrsnlInfo_UpdateAddress", "Login to Appication", "", "UserName: "+exl.read("LoginDetails", 1, "UserName"), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
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
			
		//Update Address
			ManagePerson managePerson=new ManagePerson();
			TimeUnit.SECONDS.sleep(5);
		//Clicking on Person Information Tab
				cmnLib.clickOnWebElement(managePerson.PersonInformationTab);
				rpt.generateReport("", "Clicking on Person Information Tab", "", "", "Clicking on Person Information Tab", "Clicking on Person Information Tab", "Passed", "", true);
				TimeUnit.SECONDS.sleep(10);
				
		//Selecting Options from Edit dropdown
				System.out.println("Drop down selected");
				managePerson.clickAddressEditSelectUpdate();
				TimeUnit.SECONDS.sleep(3);
				System.out.println("Popup Exists: "+cmnLib.waitForElementToBeVisible(driver.findElement(By.xpath("//div[contains(@id, 'updatePopup::popup-container')]"))));
				managePerson.EffectiveStartDate.clear();
				managePerson.EffectiveStartDate.sendKeys(managePerson.futureDate("dd/MMM/YYYY",1));
				rpt.generateReport("", "Click on Update Address OK Button", "", "", "Must Click on OK button", "Clicked on OK button", "Passed", "", true);
				cmnLib.clickOnWebElement(managePerson.Ok_Confirmation);
				TimeUnit.SECONDS.sleep(3);
				
				
				
				
		//Update Address
				cmnLib.enterDataInTextBox(managePerson.AddressLine1, exl.read(strDataSheetName, dataRow, "AddressLine_1"), true);
				cmnLib.enterDataInTextBox(managePerson.AddressLine2, exl.read(strDataSheetName, dataRow, "AddressLine_2"), true);
				cmnLib.enterDataInTextBox(managePerson.PostalCode, exl.read(strDataSheetName, dataRow, "PostalCode"), true);
				cmnLib.enterDataInTextBox(managePerson.Region, exl.read(strDataSheetName, dataRow, "Region"), true);
				cmnLib.enterDataInTextBox(managePerson.Provinica, exl.read(strDataSheetName, dataRow, "Provincia"), true);
				cmnLib.enterDataInTextBox(managePerson.Komune, exl.read(strDataSheetName, dataRow, "Komune"), true);
				rpt.generateReport("", "Update address", "", "", "Must Enter all the details", "All the details entered successfully", "Passed", "", true);
				TimeUnit.SECONDS.sleep(3);
				cmnLib.clickOnWebElement(managePerson.AddressOKButton);	
				TimeUnit.SECONDS.sleep(10);
		//Submit 
				cmnLib.clickOnWebElement(managePerson.SubmitButton);
				
				if(cmnLib.waitForElementToBeVisible(managePerson.Warning_Popup, 15))
				{
					rpt.generateReport("", "Update address", "", "", "Warning message must Pop up", "Warning message is Popping up", "Passed", "", true);
					TimeUnit.SECONDS.sleep(3);
					cmnLib.clickOnWebElement(managePerson.Yes_Warning);
				}
				
		//Confirmation
				if(cmnLib.waitForElementToBeVisible(managePerson.Confirmation_PopUp, 10))
				{
					rpt.generateReport("", "Update address", "", "", "Confirmation message must Pop up", "Confirmation message is Popping up", "Passed", "", true);
					TimeUnit.SECONDS.sleep(3);
					cmnLib.clickOnWebElement(managePerson.Ok_Confirmation);
				}else {
					rpt.generateReport("", "Update address", "", "", "Confirmation message must Pop up", "Confirmation message has not Popped up", "Failed", "", true);
					Assert.fail("Confirmation message has not Popped up");
				}
}
}
}
