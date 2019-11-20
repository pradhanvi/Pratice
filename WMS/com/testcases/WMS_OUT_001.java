package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.commons.TestBase;
import com.commons.Common_Library.DropDownSelectBy;


import report.oracle.ofs.ReportGeneration;
import wms.pagefactory.HomePage_WMS;
import wms.pagefactory.LoginPage_WMS;
import xlsx.databank.ofs.ExcelOperations;

public class WMS_OUT_001 extends TestBase{
	String strModule = "WMS";

	@Test
	public void SCM_CHILE_PRC01_TC() throws Throwable {

		rpt = new ReportGeneration("WMS_OUT_001", "");

		String strDataSheetName = "OUT001";
		rpt.enterStepHeader("TestCase ID: WMS_OUT_001");
		rpt.enterStepHeader("TestCase Name: Print OBLPN");

		rpt.enterStepHeader("Login To Application");

		if(! (new HomePage_WMS().getUserNameFromHomePage() != null && new HomePage_WMS().getUserNameFromHomePage().equalsIgnoreCase(hashmap.get("UserName_"+strModule)))) {

			launchBrowser(strModule);
			//Launch & Login
			
			LoginPage_WMS loginPage_WMS = PageFactory.initElements(driver, LoginPage_WMS.class);
			loginPage_WMS.login(hashmap.get("UserName_"+strModule), hashmap.get("Password_"+strModule));
		}

		//Initialize HomePage Web Elements
		HomePage_WMS homePage_WMS = PageFactory.initElements(driver, HomePage_WMS.class);
		cmnLib.waitForPageLoaded();
		
		//Validate HomePage Icon
		if(cmnLib.waitForElementToBeVisible(homePage_WMS.HomePage_HomeIcon) == true)
		{
			//PASS
			rpt.generateReport("WMS_OUT_001", "Enter URL", "", "Password: "+hashmap.get("URL_"+strModule), "URL should be entered", "URL is entered", "Info", "", true );
			rpt.generateReport("", "Enter User Name", "", "UserName: "+hashmap.get("UserName_"+strModule), "UserName should be entered", "UserName is entered", "Info", "", true );
			rpt.generateReport("", "Enter Password", "", "Password: "+hashmap.get("Password_"+strModule), "Password should be entered", "Password is entered", "Info", "", true );
			rpt.generateReport("", "Validate Login to Appication", "", "", "Login Should be successful", "Login Is Successful", "Passed", "", true );
		}
		else
		{
			//FAIL
			rpt.generateReport("WMS_OUT_001", "Login to Appication", "", "UserName: "+exl.read("LoginDetails", 1, "UserName"), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
			Assert.fail("Login Un-Successful");
		}

		rpt.enterStepHeader("Navigation to OBLPNs screen");

		//Always Load TestData Sheet Excel After Login as UserName & Password exists in other Excel which is loaded in TestBase
		
		exl = new ExcelOperations("WMS\\com\\dataBanks\\WMS_TestData.xlsx");

		// Script will execute for all the Rows present in the Data Sheet.
		
		System.out.println("No Of DataRows: "+exl.getRowCount(strDataSheetName));
		for (int dataRow = 1; dataRow < exl.getRowCount(strDataSheetName); dataRow++) {
			homePage_WMS = new HomePage_WMS();
		
		//Navigation
			if(homePage_WMS.clickOnWelcomePage_HomeIcon() == true)
			{
				homePage_WMS = PageFactory.initElements(driver, HomePage_WMS.class);
			}
			else
			{
				rpt.generateReport("", "Click On HomePage Icon", "", "", "HomePage Icon should be clicked", "HomePage Icon is not clicked", "Failed", "", true);
			}
			
		}
	}
	
}