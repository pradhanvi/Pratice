package com.testcases;

/**
Script Name			: SCM_CHILE_CST_008_ReviewStandardCost
Script Description	: Review Standard Cost
Track/Module		: SCM
Sub Track			: 
Created By			: Pradhanvi T R
Creation Date		: 28-Feb-2019
Modified By 		:
Modification Date	:
Instance Name & URL : https://edyg-dev4.fa.us2.oraclecloud.com/homePage/faces/FuseWelcome
User ID/ Password	: 10013865/Bimbo123
Responsibility		:
Pre-Requisites		: 
Comments (if any)	:
 **/

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.commons.TestBase;
import com.sun.corba.se.spi.servicecontext.CodeSetServiceContext;

import report.oracle.ofs.ReportGeneration;
import scm.pagefactory.CostAccountingPage;
import scm.pagefactory.HomePage_SCM;
import scm.pagefactory.LoginPage_SCM;
import scm.pagefactory.ManageResourceRates;
import scm.pagefactory.ManageStandardCosts;
import xlsx.databank.ofs.ExcelOperations;

public class SCM_CHILE_CST_008_ReviewStandardCost extends TestBase {
	String strModule = "SCM";
	@Test
	public void SCM_CHILE_CST_008_ReviewStandardCost_TC() throws Throwable {
		rpt = new ReportGeneration("SCM_CHILE_CST_008_ReviewStandardCost", "Review Standard Cost");

		String strDataSheetName = "CST_008";
		boolean login = false;

		rpt.enterStepHeader("Login To Application");
		HomePage_SCM homePage_SCM = null;
		if(! (new HomePage_SCM().getUserNameFromHomePage() != null && new HomePage_SCM().getUserNameFromHomePage().equalsIgnoreCase(hashmap.get("UserName_"+strModule)))) {

			//Launch Browser
			launchBrowser(strModule);

			//Login To Application
			LoginPage_SCM loginPage_SCM = PageFactory.initElements(driver, LoginPage_SCM.class);

			homePage_SCM = loginPage_SCM.login(hashmap.get("UserName_"+strModule), hashmap.get("Password_"+strModule));
			rpt.enterStepHeader("Login to Application");
			if (homePage_SCM != null) {
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
		if(cmnLib.waitForElementToBeVisible(homePage_SCM.HomePage_HomeIcon) == true)
		{
			homePage_SCM = PageFactory.initElements(driver, HomePage_SCM.class);
			//PASS
			rpt.generateReport("SCM_CHILE_CST_008_ReviewStandardCost", "Enter URL", "", "Password: "+hashmap.get("URL_"+strModule), "URL should be entered", "URL is entered", "Info", "", true );
			rpt.generateReport("", "Enter User Name", "", "UserName: "+hashmap.get("UserName_"+strModule), "UserName should be entered", "UserName is entered", "Info", "", true );
			rpt.generateReport("", "Enter Password", "", "Password: "+hashmap.get("Password_"+strModule), "Password should be entered", "Password is entered", "Info", "", true );
			rpt.generateReport("", "Validate Login to Appication", "", "", "Login Should be successful", "Login Is Successful", "Passed", "", true );
		}else
		{
			//FAIL
			rpt.generateReport("SCM_CHILE_CST_008_ReviewStandardCost", "Login to Appication", "", "UserName: "+exl.read("LoginDetails", 1, "UserName"), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
			Assert.fail("Login Un-Successful");
		}
		rpt.enterStepHeader("Navigation to Cost Accounting Page");

		//Always Load TestData Sheet Excel After Login as UserName & Password exists in other Excel which is loaded in TestBase
		exl = new ExcelOperations("SCM\\com\\dataBanks\\SCM_TestData.xlsx");

		// Script will execute for all the Rows present in the Data Sheet.
		System.out.println("No Of DataRows: "+exl.getRowCount(strDataSheetName));
		for (int dataRow = 1; dataRow < exl.getRowCount(strDataSheetName); dataRow++) {

		//Navigation
			if(homePage_SCM.clickOnWelcomePage_HomeIcon() == true)
			{
				homePage_SCM = PageFactory.initElements(driver, HomePage_SCM.class);
			}else
			{
				rpt.generateReport("", "Click On HomePage Icon", "", "", "HomePage Icon should be clicked", "HomePage Icon is not clicked", "Failed", "", true);
			}

		//Verify Presence of Navigator Icon
			if(homePage_SCM.NavigatorIcon.isDisplayed() == false)
			{
				//FAIL
				rpt.generateReport("", "Validate HomePage", "", "", "Validation Should be successful", "Validation Is Not Successful", "Failed", "", true );
				Assert.fail("Login Un-Successful");
			}
			TimeUnit.SECONDS.sleep(5);
		//Click on Navigator Icon
			homePage_SCM.clickOnNavigationIcon();
			TimeUnit.SECONDS.sleep(5);
			
		//Click On Cost Accounting from Navigator Links
			CostAccountingPage costAccountingPage = homePage_SCM.clickOnCostAccountingLink();
			TimeUnit.SECONDS.sleep(5);
			cmnLib.waitForPageLoaded();

		//Verify Cost Accounting page is displayed
			if(costAccountingPage.CostAccountingHeader.isDisplayed() == true)
			{
				rpt.generateReport("", "Navigation to Cost Accounting Page", "", "", "Navigation to Cost Accounting Page should be displayed", "Navigation to Cost Accounting Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to Cost Accounting Page", "", "", "Navigation to Cost Accounting Page should be displayed", "Navigation to Cost Accounting Page Is Not displayed", "Failed", "", true );
				Assert.fail("Navigation to Cost Accounting Page is not displayed");
			}

		// Selecting Tasks
			cmnLib.waitForPageLoaded();
			TimeUnit.SECONDS.sleep(30);
			costAccountingPage.clickOnTaksIcon();
			
		//Clicking on Manage Standard Costs
			TimeUnit.SECONDS.sleep(5);
			ManageStandardCosts manageStandardCosts = costAccountingPage.clickOnManageStandardCosts();
			rpt.generateReport("", "Tasks Icon", "", "Manage Standard Costs", "Must click on Manage Standard Costs link", "Clicked on Manage Standard Costs Link", "Pass", "", true);
			
		//Verify Manage Standard Costs page is displayed
			TimeUnit.SECONDS.sleep(10);
			
			//cmnLib.waitForElementToBeVisible(manageStandardCosts.ManageStandardCostsHeader);
			if(cmnLib.waitForElementToBeVisible(manageStandardCosts.CostOrganizationSearchEle))
			{
				rpt.generateReport("", "Navigation to Manage Standard Costs Page", "", "", "Navigation to  Manage Standard Costs Page should be displayed", "Navigation to  Manage Standard Costs Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to  Manage Standard Costs Page", "", "", "Navigation to  Manage Standard Costs Page should be displayed", "Navigation to  Manage Standard Costs Page Is Not displayed", "Failed", "", true );
				Assert.fail("Navigation to  Manage Standard Costs Page is not displayed");
			}
		//Search for Items
			TimeUnit.SECONDS.sleep(3);
			
			if(!cmnLib.enterDataInTextBox(manageStandardCosts.CostOrganizationSearchEle, exl.read(strDataSheetName, dataRow, "Cost Organization"), false))
			{
				rpt.generateReport("", "Data entering in Search Criteria", "", exl.read(strDataSheetName, dataRow, "Cost Organization"), "Data must be enetered in Search Criteria", "Data is enetered in Search Criteria", "Failed", "", true);
			     Assert.fail("Data is not enetered in Search Criteria");
			}
			
			TimeUnit.SECONDS.sleep(2);
			 cmnLib.clickOnWebElement(manageStandardCosts.SearchButton);
		//Verifying Search results	  
			TimeUnit.SECONDS.sleep(10);
			if(manageStandardCosts.verifySearchedResults()== false) {
				//Fail
				rpt.generateReport("", "Enter search criteria", "", "Cost Organization : "+exl.read(strDataSheetName, dataRow, "Cost Organization"), "Entered Search criteria must be displayed in search reults", "Entered Search criteria is not displayed in search reults", "Failed", "", true);
				Assert.fail("Entered serach reults doesn't exists in Manage Standard Costs page");
			}else
			{
				//Pass
				
				rpt.generateReport("", "Enter search criteria", "", "Cost Organization : "+exl.read(strDataSheetName, dataRow, "Cost Organization"), "Entered Search criteria must be displayed in search reults", "Entered Search criteria is displayed in search reults", "Passed", "", true);
				TimeUnit.SECONDS.sleep(8);
			}
			
		}
	}
}
