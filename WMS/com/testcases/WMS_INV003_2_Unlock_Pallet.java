package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.commons.TestBase;

import report.oracle.ofs.ReportGeneration;

import wms.pagefactory.HomePage_WMS;
import wms.pagefactory.IBLPN;
import wms.pagefactory.LoginPage_WMS;
import xlsx.databank.ofs.ExcelOperations;

/**
Script Name			: WMS_INV003_2_Unlock_Pallet
Script Description	: Unlock Pallet
Track/Module		: WMS
Sub Track			: 
Created By			: Pradhanvi T R
Creation Date		: 28-Mar-19
Modified By 		: 
Modification Date	: 
Instance Name & URL : https://ta17.wms.ocs.oraclecloud.com/bimbo_test2
User ID/ Password	: Naveen_Peru/Welcome@Naveen
Responsibility		: 
Pre-Requisites		: 
Comments (if any)	:
 **/


public class WMS_INV003_2_Unlock_Pallet  extends TestBase{

	String strModule = "WMS";

	@Test
	public void WMS_INV003_2_Unlock_Pallet_TC() throws Throwable {

		rpt = new ReportGeneration("WMS_INV003_2_Unlock_Pallet", "Unlock Pallet");

		String strDataSheetName = "INV003_2";
		
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
			//Verify Presence of Navigator Icon
			if(homePage_WMS.NavigatorIcon.isDisplayed() == false)
			{
				//FAIL
				rpt.generateReport("", "Validate HomePage", "", "", "Validation Should be successful", "Validation Is Not Successful", "Failed", "", true );
				Assert.fail("Login Un-Successful");
			}
			TimeUnit.SECONDS.sleep(5);
		/*//Click on Navigator Icon
			homePage_WMS.clickOnNavigationIcon();
			TimeUnit.SECONDS.sleep(5);
			
		//Click On IB LPN Links
			IBLPN iBLPN = homePage_WMS.clickOnIBLPN();
			TimeUnit.SECONDS.sleep(5);
			cmnLib.waitForPageLoaded();*/
			
			homePage_WMS.searchAndSelectResponsibility(exl.read(strDataSheetName, dataRow, "Navigation"));
			IBLPN iBLPN =new IBLPN();
		//Verify IB LPN page is displayed
			rpt.enterStepHeader("Verify IB LPN page is displayed");
			if(cmnLib.waitForElementToBeVisible(iBLPN.IBLPNHeader))
			{
				rpt.generateReport("", "Navigation to IB LPN Page", "", "", "Navigation to IB LPN should be displayed", "Navigation to IB LPN Is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Navigation to IB LPN Page", "", "", "Navigation to IB LPN Page should be displayed", "Navigation to IB LPN Is Not displayed", "Failed", "", true );
				Assert.fail("Navigation to IB LPN Is Not displayed");
			}	
			
		//Searching LPN Number
			rpt.enterStepHeader("Searching LPN Number");
			TimeUnit.SECONDS.sleep(3);
			cmnLib.clickOnWebElement(iBLPN.SearchIcon);
			cmnLib.waitForElementToBeVisible(iBLPN.LPN_Nbr);
			if(cmnLib.enterDataInTextBox(iBLPN.LPN_Nbr, exl.read(strDataSheetName, dataRow, "LPN_Nbr"), true))
			{
				rpt.generateReport("", "LPN number", "", exl.read(strDataSheetName, dataRow, "LPN_Nbr"), "LPN number should be entered", "LPN number is entered", "Passed", "", true );
			}
			cmnLib.clickOnWebElement(iBLPN.SearchButton);
		//Selecting the Lock Code to remove
			rpt.enterStepHeader("Selecting the Lock Code to remove");
			if(cmnLib.waitForElementToBeVisible(iBLPN.NbrLocksColumn))
			{
				rpt.generateReport("", "Nbr Locks screen", "", "", "Nbr Locks should be displayed", "Nbr Locks is displayed", "Passed", "", true );

			}else
			{
				//FAIL
				rpt.generateReport("", "Nbr Locks screen", "", "", "Nbr Locks should be displayed", "Nbr Locks is NOT displayed", "Failed", "", true );
				Assert.fail("Nbr Locks is NOT displayed");
			}	
			
			int NumOfLocks=Integer.parseInt(iBLPN.NbrLocksValue.getText());
			
			if(NumOfLocks>0)
			{
				cmnLib.clickOnWebElement(iBLPN.NbrLocksValue);
				if(cmnLib.waitForElementToBeVisible(iBLPN.LockCodeColumn))
				{
					rpt.generateReport("", "Lock Code page", "", "", "All the existing Lock Codes must be displayed", "All the existing Lock Codes are displayed", "Passed", "", true );
				}else {
					rpt.generateReport("", "Lock Code page", "", "", "All the existing Lock Codes must be displayed", "All the existing Lock Codes are NOT displayed", "Failed", "", true );
					Assert.fail("All the existing Lock Codes are NOT displayed");
				}
			}else {
				
				rpt.generateReport("", "Lock Code page", "", "", "All the existing Lock Codes must be displayed", "No Lock Code are found", "Failed", "", true );
				Assert.fail("No Lock Code are found");
			}
			
		//Searching Lock Code
			rpt.enterStepHeader("Searching Lock Code");
			
			if(iBLPN.SearchAndSelectLockCode(exl.read(strDataSheetName, dataRow, "Lock_Code")))
			{
				cmnLib.clickOnWebElement(iBLPN.DeleteIcon);
				if(cmnLib.waitForElementToBeVisible(iBLPN.WarningDialogBox))
				{
					rpt.generateReport("", "Remove Lock Code", "", exl.read(strDataSheetName, dataRow, "Lock_Code"), "Warning Message must be displayed", "Warning Message is displayed", "Passed", "", true );
					cmnLib.clickOnWebElement(iBLPN.DialogBox_OKButton);
				}else {
					rpt.generateReport("", "Remove Lock Code", "", exl.read(strDataSheetName, dataRow, "Lock_Code"), "Warning Message must be displayed", "Warning Message is NOT displayed", "Failed", "", true );
					Assert.fail("Warning Message is NOT displayed");
				}
				
			}else {
				rpt.generateReport("", "Remove Lock Code", "", exl.read(strDataSheetName, dataRow, "Lock_Code"), "Lock Code must be displayed", "Lock Code Not Found", "Failed", "", true );
				Assert.fail("Lock Code Not Found");
				
			}
		
		//Verifying Deletion
			rpt.enterStepHeader("Verifying Deletion");
			if(!iBLPN.SearchAndSelectLockCode(exl.read(strDataSheetName, dataRow, "Lock_Code")))
			{
				rpt.generateReport("", "Unlock Pallet", "", exl.read(strDataSheetName, dataRow, "Lock_Code"), "Successfull Unlock Pallet", "Successfully Unlocked Pallet", "Passed", "", true );
			}else {
				rpt.generateReport("", "Unlock Pallet", "", exl.read(strDataSheetName, dataRow, "Lock_Code"), "Successfull Unlock Pallet", "Un-Successfully Unlocked Pallet", "Failed", "", true );
				Assert.fail("Un-Successfully Unlocked Pallet");
			}

			
		}
	}
	

	

}
