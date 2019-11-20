package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.commons.TestBase;

import report.oracle.ofs.ReportGeneration;
import wms.pagefactory.HomePage_WMS;
import wms.pagefactory.IBLPN;
import wms.pagefactory.Location;
import wms.pagefactory.LoginPage_WMS;
import xlsx.databank.ofs.ExcelOperations;

public class WMS_INV003_3_Lock_Location_With_LockCode extends TestBase{


	String strModule = "WMS";

	@Test
	public void WMS_INV003_3_Lock_Location_With_LockCode_TC() throws Throwable {

		rpt = new ReportGeneration("WMS_INV003_3_Lock_Location_With_LockCode", "Lock Location with Lock Code");

		String strDataSheetName = "INV003_3";
		
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
			rpt.generateReport("WMS_INV003_3_Lock_Location_With_LockCode", "Enter URL", "", "Password: "+hashmap.get("URL_"+strModule), "URL should be entered", "URL is entered", "Info", "", true );
			rpt.generateReport("", "Enter User Name", "", "UserName: "+hashmap.get("UserName_"+strModule), "UserName should be entered", "UserName is entered", "Info", "", true );
			rpt.generateReport("", "Enter Password", "", "Password: "+hashmap.get("Password_"+strModule), "Password should be entered", "Password is entered", "Info", "", true );
			rpt.generateReport("", "Validate Login to Appication", "", "", "Login Should be successful", "Login Is Successful", "Passed", "", true );
		}
		else
		{
			//FAIL
			rpt.generateReport("WMS_INV003_3_Lock_Location_With_LockCode", "Login to Appication", "", "UserName: "+exl.read("LoginDetails", 1, "UserName"), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
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
			//Verify Presence of Navigator Icon
			if(homePage_WMS.NavigatorIcon.isDisplayed() == false)
			{
				//FAIL
				rpt.generateReport("", "Validate HomePage", "", "", "Validation Should be successful", "Validation Is Not Successful", "Failed", "", true );
				Assert.fail("Login Un-Successful");
			}
			TimeUnit.SECONDS.sleep(5);
		
			
			homePage_WMS.searchAndSelectResponsibility(exl.read(strDataSheetName, dataRow, "Navigation"));
			Location location =new Location();
			
		//Verify Locations page
			rpt.enterStepHeader("Verify Locations page");
			if(cmnLib.waitForElementToBeVisible(location.SearchIcon))
			{
				rpt.generateReport("", "Navigation to Location Page", "", "", "Navigation to Location should be displayed", "Navigation to Location Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to Location Page", "", "", "Navigation to Location Page should be displayed", "Navigation to Location Is Not displayed", "Failed", "", true );
				Assert.fail("Navigation to Location Is Not displayed");
			}
		//Searching Location by Barcode
			rpt.enterStepHeader("Searching Location by Barcode");
			cmnLib.clickOnWebElement(location.SearchIcon);
			cmnLib.waitForElementToBeVisible(location.Barcode_Search);
			if(cmnLib.enterDataInTextBox(location.Barcode_Search, exl.read(strDataSheetName, dataRow, "Barcode"), true))
			{
				rpt.generateReport("", "Barcode number", "", exl.read(strDataSheetName, dataRow, "Barcode"), "Barcode number should be entered", "Barcode number is entered", "Passed", "", true );
			}
			cmnLib.clickOnWebElement(location.Search_Button);
			
		//Edit Lock code
			rpt.enterStepHeader("Edit Lock code");
			cmnLib.waitForElementToBeVisible(location.LockCode_Column);
			if(cmnLib.moveToElementAndClick(location.LockCode_Value))
			{
				TimeUnit.SECONDS.sleep(3);
				rpt.generateReport("", "Lock Code", "", "", "Lock Code type must be displayed", "Lock Code type is displayed", "Passed", "", true );
			}
			TimeUnit.SECONDS.sleep(3);
			cmnLib.clickOnWebElement(location.Edit_Icon);
			cmnLib.waitForElementToBeVisible(location.LockCode_Edit);
			if(cmnLib.enterDataInTextBox(location.LockCode_Edit, exl.read(strDataSheetName, dataRow, "LockCode"), true))
			{
				rpt.generateReport("", "Lock Code", "", exl.read(strDataSheetName, dataRow, "LockCode"), "Lock Code must be provided", "Lock Code is provided", "Passed", "", true );
				TimeUnit.SECONDS.sleep(2);
				cmnLib.clickOnWebElement(location.Save_Button);
			}else {
				rpt.generateReport("", "Lock Code", "", exl.read(strDataSheetName, dataRow, "LockCode"), "Lock Code must be provided", "Lock Code is NOT provided", "Failed", "", true );
				Assert.fail("Lock Code is NOT provided");
			}
			cmnLib.waitForPageLoaded();
			TimeUnit.SECONDS.sleep(3);
			cmnLib.moveToElementAndClick(location.LockCode_Value);
			TimeUnit.SECONDS.sleep(3);
			if(location.LockCode_Value.getText().equals(exl.read(strDataSheetName, dataRow, "LockCode")))
			{
				rpt.generateReport("", "Lock Location with Lock Code", "", exl.read(strDataSheetName, dataRow, "LockCode"), "Successfully Locked location with Lock Code", "Successfully Locked location with Lock Code", "Passed", "", true );
			}else {
				rpt.generateReport("", "Lock Location with Lock Code", "", exl.read(strDataSheetName, dataRow, "LockCode"), "Successfully Locked location with Lock Code", "Failed Locked location with Lock Code", "Failed", "", true );
				Assert.fail("Failed Locked location with Lock Code");
			}
			
			
		}
	}
}
