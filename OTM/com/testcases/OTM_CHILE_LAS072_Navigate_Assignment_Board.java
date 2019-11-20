package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.commons.Common_Library.FrameSelectBy;
import com.commons.TestBase;

import otm.pagefactory.AssignmentBoard;
import otm.pagefactory.HomePage_OTM;
import otm.pagefactory.LoginPage_OTM;
import report.oracle.ofs.ReportGeneration;
import xlsx.databank.ofs.ExcelOperations;
/**
Script Name			: OTM_CHILE_LAS072_Navigate_Assignment_Board
Script Description	: Navigation to Assignment board
Track/Module		: OTM
Sub Track			: 
Created By			: Pradhanvi T R
Creation Date		: 15-Mar-19
Modified By 		: 
Modification Date	: 
Instance Name & URL : https://otmgtm-edyg-dev7.otm.us2.oraclecloud.com/GC3/glog.webserver.servlet.umt.Logi
User ID/ Password	: TESTING_CHILE@beehiveonline.oracle.com/Bimbo321
Responsibility		: Domain(edyg-dev7)
Pre-Requisites		: 
Comments (if any)	:
 **/
public class OTM_CHILE_LAS072_Navigate_Assignment_Board extends TestBase {

	String strModule = "OTM_CHILE";
	@Test
	public void OTM_CHILE_LAS072_Navigate_Assignment_Board_TC() throws Throwable {
		rpt = new ReportGeneration("OTM_CHILE_LAS072_Navigate_Assignment_Board", "Navigation to Assignment board");

		String strDataSheetName = "LAS072";
		boolean login = false;

		rpt.enterStepHeader("Login To Application");
		
		HomePage_OTM homePage_OTM = null;
		if(! (new HomePage_OTM().getUserNameFromHomePage() != null && new HomePage_OTM().getUserNameFromHomePage().equalsIgnoreCase(hashmap.get("UserName_"+strModule)))) {

			//Launch Browser
			launchBrowser(strModule);

			//Login To Application
			
			LoginPage_OTM loginPage_OTM = PageFactory.initElements(driver, LoginPage_OTM.class);
			loginPage_OTM.setDomain(hashmap.get("Domain_" + strModule));			
			homePage_OTM = loginPage_OTM.login(hashmap.get("UserName_"+strModule), hashmap.get("Password_"+strModule));
			rpt.enterStepHeader("Login to Application");
			if (homePage_OTM != null) {
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
		TimeUnit.SECONDS.sleep(10);
		if(cmnLib.waitForElementToBeVisible(homePage_OTM.HomePage_HomeIcon) == true)
		{
			homePage_OTM = PageFactory.initElements(driver, HomePage_OTM.class);
			//PASS
			rpt.generateReport("OTM_CHILE_LAS072_Navigate_Assignment_Board", "Enter URL", "", "Password: "+hashmap.get("URL_"+strModule), "URL should be entered", "URL is entered", "Info", "", false );
			rpt.generateReport("", "Enter User Name", "", "UserName: "+hashmap.get("UserName_"+strModule), "UserName should be entered", "UserName is entered", "Info", "", false );
			rpt.generateReport("", "Enter Password", "", "Password: "+hashmap.get("Password_"+strModule), "Password should be entered", "Password is entered", "Info", "", false );
			rpt.generateReport("", "Validate Login to Appication", "", "", "Login Should be successful", "Login Is Successful", "Passed", "", false );
		}else
		{
			//FAIL
			rpt.generateReport("OTM_CHILE_LAS072_Navigate_Assignment_Board", "Login to Appication", "", "UserName: "+hashmap.get("UserName_"+strModule), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
			Assert.fail("Login Un-Successful");
		}
		rpt.enterStepHeader("Navigation to Cost Accounting Page");

		//Always Load TestData Sheet Excel After Login as UserName & Password exists in other Excel which is loaded in TestBase
		exl = new ExcelOperations("OTM\\com\\dataBanks\\OTM_TestData.xlsx");

		// Script will execute for all the Rows present in the Data Sheet.
		System.out.println("No Of DataRows: "+exl.getRowCount(strDataSheetName));
		for (int dataRow = 1; dataRow < exl.getRowCount(strDataSheetName); dataRow++) {

		//Navigation
			if(homePage_OTM.clickOnWelcomePage_HomeIcon() == true)
			{
				homePage_OTM = PageFactory.initElements(driver, HomePage_OTM.class);
			}else
			{
				rpt.generateReport("", "Click On HomePage Icon", "", "", "HomePage Icon should be clicked", "HomePage Icon is not clicked", "Failed", "", true);
			}

		//Verify Presence of Navigator Icon
			if(homePage_OTM.NavigatorIcon.isDisplayed() == false)
			{
				//FAIL
				rpt.generateReport("", "Validate HomePage", "", "", "Validation Should be successful", "Validation Is Not Successful", "Failed", "", true );
				Assert.fail("Login Un-Successful");
			}
			TimeUnit.SECONDS.sleep(5);
		//Click on Navigator Icon
			homePage_OTM.clickOnNavigationIcon();
			TimeUnit.SECONDS.sleep(5);
			
		//Click On Assignment Board
			AssignmentBoard assignmentBoard = homePage_OTM.clickOnAssignmentBoardLink();
			TimeUnit.SECONDS.sleep(5);
			cmnLib.waitForPageLoaded();
			
		//Switching the frame to Dispatch board	
			//Dev4- Dev
			//cmnLib.switchToFrame("mainContentRegion:1:if1::f", FrameSelectBy.StringFrameName);
			
			//Dev4-19C Reg
			cmnLib.switchToFrame("mcr:2:if1::f", FrameSelectBy.StringFrameName);
			
		//Verifying the page
			TimeUnit.SECONDS.sleep(5);
			if(assignmentBoard.AssignmentBoardHeader.getText().contains("Dispatch Board"))
			 {
				rpt.generateReport("", "Navigation to Assignment Board", "", "", "Assignment Board page must be opened",
						"Assignment Board page is opened", "Passed", "", true);
			} else {
				rpt.generateReport("", "Navigation to Assignment Board", "", "", "Assignment Board page must be opened",
						"Assignment Board page is NOT opened", "Failed", "", true);
				Assert.fail("Assignment Board page is NOT opened");
			}
			
			
		
	

		}
	}
}
