package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.commons.TestBase;

import hcm.pagefactory.HomePage_HCM;
import hcm.pagefactory.LoginPage_HCM;
import hcm.pagefactory.PersonalInformation;
import report.oracle.ofs.ReportGeneration;
import xlsx.databank.ofs.ExcelOperations;

/**
Script Name			: HCM_CHILE_T005_5_AddPersonalRelationship_DeleteFrmEmp
Script Description	: Add Relationship - Delete Personal Relationship from Emp Login
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

@Test
public class HCM_CHILE_T005_5_AddPersonalRelationship_DeleteFrmEmp extends TestBase {


	String strModule = "HCM_EMP";
	
	public void HCM_CHILE_T005_5_AddPersonalRelationship_DeleteFrmEmp_TC() throws Throwable {
		rpt = new ReportGeneration("HCM_CHILE_T005_AddPersonalRelationship", "Delete Relationship from Employee");

		String strDataSheetName = "T005_5_AddPersoRelatshp";
									
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
			rpt.generateReport("HCM_CHILE_T005_5_AddPersonalRelationship_DeleteFrmEmp", "Enter URL", "", "Password: "+hashmap.get("URL_"+strModule), "URL should be entered", "URL is entered", "Info", "", true );
			rpt.generateReport("", "Enter User Name", "", "UserName: "+hashmap.get("UserName_"+strModule), "UserName should be entered", "UserName is entered", "Info", "", true );
			rpt.generateReport("", "Enter Password", "", "Password: "+hashmap.get("Password_"+strModule), "Password should be entered", "Password is entered", "Info", "", true );
			rpt.generateReport("", "Validate Login to Appication", "", "", "Login Should be successful", "Login Is Successful", "Passed", "", true );
		}else
		{
			//FAIL
			rpt.generateReport("HCM_CHILE_T005_5_AddPersonalRelationship_DeleteFrmEmp", "Login to Appication", "", "UserName: "+exl.read("LoginDetails", 1, "UserName"), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
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
			
		//Delete Personal Relationship
			rpt.enterStepHeader("Add Personal Relationship");
			cmnLib.clickOnWebElement(personalInformation.EditButton);
			
			if(cmnLib.waitForElementToBeVisible(personalInformation.AddAddressIcon))
			{
				rpt.generateReport("", "Verify Edit My Details page", "", "", "Edit My Details page must be opened", "Edit My Details page is opened", "Passed", "", true);
			}else {
				rpt.generateReport("", "Verify Edit My Details page", "", "", "Edit My Details page must be opened", "Edit My Details page is NOT opened", "Failed", "", true);
				Assert.fail("Edit My Details page is NOT opened");
			}
			
		//Click on Contacts Tab
			
			cmnLib.clickOnWebElement(personalInformation.ContactsTab);
			cmnLib.waitForPageLoaded();
			rpt.generateReport("", "Verify Edit My Details:Contacts page", "", "", "Edit My Details:Contacts page should be loaded", "Edit My Details:Contacts page is loaded", "Passed", "", true);
			driver.findElement(By.xpath("//span[text()='"+exl.read(strDataSheetName, dataRow, "ContactToDelete")+"']")).click();
			TimeUnit.SECONDS.sleep(3);
			driver.findElement(By.xpath("//span[text()='"+exl.read(strDataSheetName, dataRow, "ContactToDelete")+"']//ancestor::span/ancestor::tr/td[2]/span/a")).click();
			rpt.generateReport("", "Edit My Details:Contacts page", "", "", "Delete Contact", "Deleted contact", "Passed", "", true);
			
				
				
				
				if(cmnLib.clickOnWebElement(personalInformation.SaveAndCloseButton))
				{
					rpt.generateReport("", "Edit Address", "", "", "Personal Contact is deleted to his/her details","Personal Contact details are Saved Successfully", "Passed", "", true);
				}else {
					
					rpt.generateReport("", "Edit Address", "", "", "Personal Contact is deleted to his/her details", "Failed to delete Personal Contact", "Failed", "", true);
					Assert.fail("Failed to Edit address");
				}
			
			
			if(cmnLib.waitForElementToBeVisible(personalInformation.PersonalInformationHeader, 10))
				rpt.generateReport("", "Edit Address", "", "", "Personal Contact is deleted to his/her details","Personal Contact is deleted Successfully", "Passed", "", true);
			
			
			
		}
	}






}
