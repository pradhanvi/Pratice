package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.commons.TestBase;

import hcm.pagefactory.HomePage_HCM;
import hcm.pagefactory.LoginPage_HCM;
import hcm.pagefactory.ManageCommunication;
import report.oracle.ofs.ReportGeneration;
import xlsx.databank.ofs.ExcelOperations;

/**
Script Name			: HCM_CHILE_T004_13_ManageCommunicationMethods_EditEmailFrmEmpDir
Script Description	: Manage Communication methods - Edit E-Mail from Emp Dir
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
public class HCM_CHILE_T004_13_ManageCommunicationMethods_EditEmailFrmEmpDir extends TestBase{

	String strModule = "HCM_EMP";
	
	@Test
	public void HCM_CHILE_T004_13_ManageCommunicationMethods_EditEmailFrmEmpDir_TC() throws Throwable {
		rpt = new ReportGeneration("HCM_CHILE_T004_13_ManageCommunicationMethods", "Edit E-Mail from Emp Dir");

		String strDataSheetName = "T004_13_ManageCommMthds";
									
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
			rpt.generateReport("HCM_CHILE_T004_13_ManageCommunicationMethods_EditEmailFrmEmpDir", "Enter URL", "", "Password: "+hashmap.get("URL_"+strModule), "URL should be entered", "URL is entered", "Info", "", true );
			rpt.generateReport("", "Enter User Name", "", "UserName: "+hashmap.get("UserName_"+strModule), "UserName should be entered", "UserName is entered", "Info", "", true );
			rpt.generateReport("", "Enter Password", "", "Password: "+hashmap.get("Password_"+strModule), "Password should be entered", "Password is entered", "Info", "", true );
			rpt.generateReport("", "Validate Login to Appication", "", "", "Login Should be successful", "Login Is Successful", "Passed", "", true );
		}else
		{
			//FAIL
			rpt.generateReport("HCM_CHILE_T004_13_ManageCommunicationMethods_EditEmailFrmEmpDir", "Login to Appication", "", "UserName: "+exl.read("LoginDetails", 1, "UserName"), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
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
			ManageCommunication managecomm = homePage_HCM.clickOnDirectoryLink();
			TimeUnit.SECONDS.sleep(5);
			
			
		//Verify Person Number Edit box is displayed
			if(managecomm.DirectoryHeader.isDisplayed() == true)
			{
				rpt.generateReport("", "Navigation to Directory Page", "", "", "Directory Page should be displayed", "Directory Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to Directory Page", "", "", "Directory Page should be displayed", "Directory Page Is Not displayed", "Failed", "", true );
				Assert.fail("Directory Page is not displayed");
			}

		//Enter the Details to Search the Person
			String strPersonNumber = exl.read(strDataSheetName, dataRow, "Person_Number");
			managecomm.enterPersonNumber(strPersonNumber);
			managecomm.clickOnSearch();

		//Verify the Entered Person Search Record Exists
			cmnLib.waitForElementToBeVisible(managecomm.ShowFilters);
			
			if(cmnLib.waitForElementToBeVisible(managecomm.NoResultsFound, 8)) {
				//Fail
				rpt.generateReport("", "Enter Search Person details", "", "Person Number: "+strPersonNumber, "Entered Person Number details should be displayed", "Entered Person Number details could not be displayed", "Failed", "", true);
				Assert.fail("Person Number in Directory page could not be entered");
			}else {
				//Pass
				rpt.generateReport("", "Enter Search Person details", "", "Person Number: "+strPersonNumber, "Entered Person Number details should be displayed", "Entered Person Number details is displayed", "Passed", "", true);
			}

		//Click on searched result
			cmnLib.clickOnLinkText(exl.read(strDataSheetName, dataRow, "Person_Name"));
			
			
		//verify Person Page is opened
			cmnLib.waitForElementToBeVisible(managecomm.ChangeBackgroundPhoto);
			if(managecomm.ChangeBackgroundPhoto.isDisplayed() == true)
			{
				rpt.generateReport("", "Navigation to Person spotlight page", "", "", "Person spotlight Page should be displayed", "Person spotlight Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to Person spotlight Page", "", "", "Person spotlight Page should be displayed", "Person spotlight Page Is Not displayed", "Failed", "", true );
				Assert.fail("Person spotlight Page is not displayed");
			}
			
		//Edit Email ID
			cmnLib.clickOnWebElement(managecomm.EditPhoneNum);
			
			/*cmnLib.clickOnWebElement(managecomm.AddPhoneDrop);
			cmnLib.clickOnWebElement(managecomm.SelectEmail);*/
			TimeUnit.SECONDS.sleep(2);
			
			managecomm.selectOptionFromComboBoxInsideTable(managecomm.EmailTypeDrop, exl.read(strDataSheetName, dataRow, "Email_Type"));
			/*cmnLib.clickOnWebElement(managecomm.EmailTypeDrop);
			driver.findElement(By.xpath("//li[text()='"+exl.read(strDataSheetName, dataRow, "Email_Type")+"']")).click();;*/
			cmnLib.enterDataInTextBox(managecomm.EmailInput, exl.read(strDataSheetName, dataRow, "Email_ID"), true);
			
			rpt.generateReport("", "Edit Email ID", "", "", "Email details must be entered", "All the required details are entered", "Passed", "", true);
			TimeUnit.SECONDS.sleep(3);
			cmnLib.clickOnWebElement(managecomm.OKButton_AddPhone);
			TimeUnit.SECONDS.sleep(3);
			
}
}


}
