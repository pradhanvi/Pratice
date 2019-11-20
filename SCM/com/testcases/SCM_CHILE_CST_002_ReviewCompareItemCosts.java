package com.testcases;

/**
Script Name			: SCM_CHILE_CST_002_ReviewCompareItemCosts
Script Description	: Review and Compare Item Costs
Track/Module		: SCM
Sub Track			: 
Created By			: Pradhanvi T R
Creation Date		: 9-Mar-2019
Modified By 		:
Modification Date	:
Instance Name & URL : https://edyg-dev4.fa.us2.oraclecloud.com/homePage/faces/FuseWelcome
User ID/ Password	: 10013865/Bimbo123
Responsibility		:
Pre-Requisites		: 
Comments (if any)	:
 **/


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.commons.TestBase;

import report.oracle.ofs.ReportGeneration;
import scm.pagefactory.CostAccountingPage;
import scm.pagefactory.HomePage_SCM;
import scm.pagefactory.LoginPage_SCM;
import scm.pagefactory.ManageOverheadRates;
import scm.pagefactory.ReviewItemCosts;
import xlsx.databank.ofs.ExcelOperations;

public class SCM_CHILE_CST_002_ReviewCompareItemCosts extends TestBase{
	
	String strModule = "SCM";
	@Test
	public void SCM_CHILE_CST_002_ReviewCompareItemCosts_TC() throws Throwable {
		rpt = new ReportGeneration("SCM_CHILE_CST_002_ReviewCompareItemCosts", "Review and Compare Item Costs");

		String strDataSheetName = "CST_002";
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
						"Username must be entered", "Username entered", "Passed", "", true);
				rpt.generateReport("", "Enter Password", "", "", "Password must be entered", "Password entered",
						"Passed", "", true);
				rpt.generateReport("", "Click Sign In button", "", "", "Sign In button must be clicked",
						"Clicked Sign In button", "Passed", "", false);
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
			rpt.generateReport("SCM_CHILE_CST_002_ReviewCompareItemCosts", "Enter URL", "", "Password: "+hashmap.get("URL_"+strModule), "URL should be entered", "URL is entered", "Info", "", false );
			rpt.generateReport("", "Enter User Name", "", "UserName: "+hashmap.get("UserName_"+strModule), "UserName should be entered", "UserName is entered", "Info", "", false );
			rpt.generateReport("", "Enter Password", "", "Password: "+hashmap.get("Password_"+strModule), "Password should be entered", "Password is entered", "Info", "", false );
			rpt.generateReport("", "Validate Login to Appication", "", "", "Login Should be successful", "Login Is Successful", "Passed", "", false );
		}else
		{
			//FAIL
			rpt.generateReport("SCM_CHILE_CST_002_ReviewCompareItemCosts", "Login to Appication", "", "UserName: "+exl.read("LoginDetails", 1, "UserName"), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
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
			if(cmnLib.waitForElementToBeVisible(costAccountingPage.TasksIcon))
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
			
		//Clicking on Review Item Costs
			TimeUnit.SECONDS.sleep(5);
			ReviewItemCosts reviewItemCosts = costAccountingPage.clickOnReviewItemCosts();
			rpt.generateReport("", "Tasks Icon", "", "Manage Overhead Rates", "Must click on Manage Overhead Rates link", "Clicked on Manage Overhead Rates Link", "Pass", "", true);
			
		//Verify Manage Overhead Rates page is displayed
			TimeUnit.SECONDS.sleep(10);
			
			if(cmnLib.waitForElementToBeVisible(reviewItemCosts.SearchCostOrgEle))
			{
				rpt.generateReport("", "Navigation to Review Item Costs Page", "", "", "Navigation to  Review Item Costs Page should be displayed", "Navigation to  Review Item Costs Page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to  Review Item Costs Page", "", "", "Navigation to  Review Item Costs Page should be displayed", "Navigation to  Review Item Costs Page Is Not displayed", "Failed", "", true );
				Assert.fail("Navigation to  Review Item Costs Page is not displayed");
			}
			
			
		//Review Perpetual Average Cost
			cmnLib.enterDataInTextBox(reviewItemCosts.SearchCostOrgEle, exl.read(strDataSheetName, 1, "Cost Organization"), true);
			TimeUnit.SECONDS.sleep(2);
			cmnLib.enterDataInTextBox(reviewItemCosts.SearchItemEle, exl.read(strDataSheetName, 1, "Compare Item 1"), false);
			TimeUnit.SECONDS.sleep(2);
			cmnLib.clickOnWebElement(reviewItemCosts.SearchButton);
			 TimeUnit.SECONDS.sleep(2);
			 
			if( reviewItemCosts.verifySearchedRecordExists(exl.read(strDataSheetName, 1, "Compare Item 1")))
			{
				rpt.generateReport("", "Search results", "", "", "Search results for the given item must be displayed", "Search results appears for the given Item", "Passed", "", true );
			}else {
				rpt.generateReport("", "Search results", "", "", "Search results for the given item must be displayed", "Search results does not appear for the given Item", "Failed", "", true );
			}
			 
			 if(!reviewItemCosts.TotalUnitCost.equals("0"))
			 {
					rpt.generateReport("", "Search results", "", "", "Total unit cost should be more than 0", "Total unit cost is more than 0", "Passed", "", true );
				}else {
					rpt.generateReport("", "Search results", "", "", "Total unit cost should be more than 0", "Total unit cost is not more than 0", "Failed", "", true );
			}
			 
			 cmnLib.clickOnWebElement(reviewItemCosts.ReviewUnitCostButton);
			 TimeUnit.SECONDS.sleep(3);
			 
			 if(cmnLib.waitForElementToBeVisible(reviewItemCosts.CostBreakdown))
			 {
					rpt.generateReport("", "Review Perpetual Average Cost", "", "", "Review Perpetual Average Cost must be dispalyed", "Review Perpetual Average Cost page appears", "Passed", "", true );
				}else {
					rpt.generateReport("", "Review Perpetual Average Cost", "", "", "Review Perpetual Average Cost must be dispalyed", "Review Perpetual Average Cost page does not appears", "Failed", "", true );
			}
			 
			 cmnLib.clickOnWebElement(reviewItemCosts.CostBreakdown);
			 
			 rpt.generateReport("", "Review Perpetual Average Cost", "", "", "Review Perpetual Average Cost must be dispalyed", "Review Perpetual Average Cost page appears", "Passed", "", true );
			 TimeUnit.SECONDS.sleep(2);
			 
			 cmnLib.clickOnWebElement(reviewItemCosts.ReviewPerpetualAverageCostDoneButton);
		//Searching Items to Compare
			 TimeUnit.SECONDS.sleep(2);
			 cmnLib.clickOnWebElement(reviewItemCosts.ResetButton);
			/*cmnLib.enterDataInTextBox(reviewItemCosts.SearchItemEle, exl.read(strDataSheetName, 1, "Compare Item 1"), false);
			 TimeUnit.SECONDS.sleep(2);
			 cmnLib.clickOnWebElement(reviewItemCosts.SearchButton);
			 TimeUnit.SECONDS.sleep(2);
			reviewItemCosts.SearchRecordExists(exl.read(strDataSheetName, 1, "Compare Item 1"));
			
			cmnLib.enterDataInTextBox(reviewItemCosts.SearchItemEle, exl.read(strDataSheetName, 1, "Compare Item 2"), false);
			 TimeUnit.SECONDS.sleep(2);
			 cmnLib.clickOnWebElement(reviewItemCosts.SearchButton);
			 TimeUnit.SECONDS.sleep(2);
			 reviewItemCosts.SearchRecordExists(exl.read(strDataSheetName, 1, "Compare Item 2"));*/
			 
			 TimeUnit.SECONDS.sleep(30);
			 cmnLib.clickOnWebElement(reviewItemCosts .CompareButton);
			 
		//Items to compare page verification	 
			 TimeUnit.SECONDS.sleep(30);
			 if(cmnLib.waitForElementToBeVisible(reviewItemCosts .ItemsCompareButton))
			 {
				rpt.generateReport("", "Navigation to Items to compare page", "", "", "Navigation to  Items to compare page should be displayed", "Navigation to  Items to compare page Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to  Items to compare page", "", "", "Navigation to  Items to compare page should be displayed", "Navigation to  Items to compare page Is Not displayed", "Failed", "", true );
				Assert.fail("Navigation to  Items to compare page is not displayed");
			}
			 
		//Click on Compare Button
			 TimeUnit.SECONDS.sleep(2);
			 cmnLib.clickOnWebElement(reviewItemCosts .ItemsCompareButton);
			 
		//Verify Cost Accounting page is displayed
			 TimeUnit.SECONDS.sleep(5);
				if(cmnLib.waitForElementToBeVisible(reviewItemCosts.CostAttributes))
				{
					rpt.generateReport("", "Navigation to Compare Item Costs Page", "", "", "Navigation to Compare Item Costs Page should be displayed", "Navigation to Compare Item Costs Page Is displayed", "Passed", "", true );

				}else
				{
					//FAIL
					rpt.generateReport("", "Navigation to Compare Item Costs Page", "", "", "Navigation to Compare Item Costs Page should be displayed", "Navigation to Compare Item Costs Page Is Not displayed", "Failed", "", true );
					Assert.fail("Navigation to Compare Item Costs Page is not displayed");
				}
				TimeUnit.SECONDS.sleep(2);
				if(reviewItemCosts.CostAttributes.isDisplayed() == true)
				{
					rpt.generateReport("", "Cost Attribute ", "", "", "Cost Attributes should be dispalyed", "Cost Attributes is dispalyed", "Passed", "", true );

				}else
				{
					//FAIL
					rpt.generateReport("", "Cost Attribute ", "", "", "Cost Attributes should be dispalyed", "Cost Attributes is not dispalyed", "Failed", "", true );
					Assert.fail("Cost Attributes is not dispalyed");
				}
				TimeUnit.SECONDS.sleep(2);
				
				if(reviewItemCosts.CostDetails.isDisplayed() == true)
				{
					reviewItemCosts.CostElements.sendKeys(Keys.PAGE_DOWN);
					rpt.generateReport("", "Cost Details ", "", "", "Cost Details should be dispalyed", "Cost Details is dispalyed", "Passed", "", true );

				}else
				{
					//FAIL
					rpt.generateReport("", "Cost Details ", "", "", "Cost Details should be dispalyed", "Cost Details is not dispalyed", "Failed", "", true );
					Assert.fail("Cost Details is not dispalyed");
				}
				
				
			 
		}
	}
}
