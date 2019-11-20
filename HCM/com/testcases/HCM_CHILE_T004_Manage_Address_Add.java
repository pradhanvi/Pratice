package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.commons.Common_Library.DropDownSelectBy;
import com.commons.TestBase;

import hcm.pagefactory.BenefitsEnrollment;
import hcm.pagefactory.HomePage_HCM;
import hcm.pagefactory.LoginPage_HCM;
import hcm.pagefactory.PersonalInformation;
import hcm.pagefactory.SearchPerson;
import report.oracle.ofs.ReportGeneration;
import xlsx.databank.ofs.ExcelOperations;

public class HCM_CHILE_T004_Manage_Address_Add extends TestBase{


	String strModule = "HCM";
	
	@Test
	public void HCM_CHILE_T004_Manage_Address_Add() throws Throwable {
		rpt = new ReportGeneration("HCM_CHILE_T004_Manage_Address_Add", "Manage Address-Add Address");

		String strDataSheetName = "T004_Manage_Address";
									
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
			rpt.generateReport("HCM_CHILE_T004_Manage_Address_Add", "Enter URL", "", "Password: "+hashmap.get("URL_"+strModule), "URL should be entered", "URL is entered", "Info", "", true );
			rpt.generateReport("", "Enter User Name", "", "UserName: "+hashmap.get("UserName_"+strModule), "UserName should be entered", "UserName is entered", "Info", "", true );
			rpt.generateReport("", "Enter Password", "", "Password: "+hashmap.get("Password_"+strModule), "Password should be entered", "Password is entered", "Info", "", true );
			rpt.generateReport("", "Validate Login to Appication", "", "", "Login Should be successful", "Login Is Successful", "Passed", "", true );
		}else
		{
			//FAIL
			rpt.generateReport("HCM_CHILE_T004_Manage_Address_Add", "Login to Appication", "", "UserName: "+exl.read("LoginDetails", 1, "UserName"), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
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
			rpt.enterStepHeader("Navigation to  Personal Information Page");
			 PersonalInformation personalInformation = homePage_HCM.clickOnPersonalInformation();
			TimeUnit.SECONDS.sleep(5);
			
		//Verifying Personal Information page
			rpt.enterStepHeader("Verifying Personal Information page");
			if(cmnLib.waitForElementToBeVisible(personalInformation.PersonalInformationHeader))
			{
				rpt.generateReport("", "Verify Persoanl Information page", "", "", "Persoanl Information page must be opened", "Persoanl Information page is opened", "Passed", "", true);
			}else {
				rpt.generateReport("", "Verify Persoanl Information page", "", "", "Persoanl Information page must be opened", "Persoanl Information page is NOT opened", "Failed", "", true);
				Assert.fail("Persoanl Information page is NOT opened");
			}
			
		//Editing the address
			rpt.enterStepHeader("Edit Address page");
			cmnLib.clickOnWebElement(personalInformation.EditButton);
			
			if(cmnLib.waitForElementToBeVisible(personalInformation.AddAddressIcon))
			{
				rpt.generateReport("", "Verify Edit My Details page", "", "", "Edit My Details page must be opened", "Edit My Details page is opened", "Passed", "", true);
			}else {
				rpt.generateReport("", "Verify Edit My Details page", "", "", "Edit My Details page must be opened", "Edit My Details page is NOT opened", "Failed", "", true);
				Assert.fail("Edit My Details page is NOT opened");
			}
			
			cmnLib.clickOnWebElement(personalInformation.AddAddressIcon);
			
			cmnLib.waitForElementToBeVisible(personalInformation.AddressLine1);
			
			//cmnLib.enterDataInTextBox(personalInformation.AddressType, exl.read(strDataSheetName, dataRow, "Type"), true);
			//cmnLib.selectDropdownBy(personalInformation.AddressType, exl.read(strDataSheetName, dataRow, "Type"), DropDownSelectBy.VisibleText);
			personalInformation.selectValueFromInputComboBox("Type", exl.read(strDataSheetName, dataRow, "Type"));
			cmnLib.enterDataInTextBox(personalInformation.EffectiveStartDate, cmnLib.futureDate("dd/MMM/yyyy", 0), true);
			cmnLib.enterDataInTextBox(personalInformation.Country, exl.read(strDataSheetName, dataRow, "Country"), true);
			cmnLib.enterDataInTextBox(personalInformation.AddressLine1, exl.read(strDataSheetName, dataRow, "AddressLine_1"), true);
			cmnLib.enterDataInTextBox(personalInformation.AddressLine2, exl.read(strDataSheetName, dataRow, "AddressLine_2"), true);
			cmnLib.enterDataInTextBox(personalInformation.PostalCode, exl.read(strDataSheetName, dataRow, "PostalCode"), true);
			cmnLib.enterDataInTextBox(personalInformation.Region, exl.read(strDataSheetName, dataRow, "Region"), true);
			cmnLib.enterDataInTextBox(personalInformation.Provincia, exl.read(strDataSheetName, dataRow, "Provincia"), true);
			cmnLib.enterDataInTextBox(personalInformation.Komune, exl.read(strDataSheetName, dataRow, "Komune"), true);
			
			rpt.generateReport("", "Edit My Details page", "", "", "Must Enter all the details", "All the details entered successfully", "Passed", "", true);
			
			if(cmnLib.clickOnWebElement(personalInformation.SaveAndCloseButton))
			{
				rpt.generateReport("", "Add Address", "", "", "Successfully added New Address ","Successfully added New Address, ", "Passed", "", true);
			}else {
				
				rpt.generateReport("", "Add Address", "", "", "Successfully added New Address, ", "Failed to add New address", "Failed", "", true);
				Assert.fail("Failed to add New address");
			}
			
			
			
		
			
				
	}	
	
	}




}
