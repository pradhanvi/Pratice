package com.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.commons.TestBase;
import hcm.pagefactory.HomePage_HCM;
import hcm.pagefactory.LoginPage_HCM;
import hcm.pagefactory.ManageEmployment;
import hcm.pagefactory.SearchPerson;
import report.oracle.ofs.ReportGeneration;
import xlsx.databank.ofs.ExcelOperations;

public class HCM_COR002 extends TestBase{
	String strModule = "HCM";
	
	@Test
	public void HCM_COR001_TC() throws Throwable {
		
		rpt = new ReportGeneration("HCM_COR002", "Assignment Change");
		String strDataSheetName = "COR002";
		
		if(! new HomePage_HCM().getUserNameFromHomePage().equalsIgnoreCase(hashmap.get("UserName_"+strModule))) {
			//Launch & Login
			launchBrowser(strModule);
			
			LoginPage_HCM loginPage_HCM = PageFactory.initElements(driver, LoginPage_HCM.class);
			loginPage_HCM.login(hashmap.get("UserName_"+strModule), hashmap.get("Password_"+strModule));

		}
		
		//Initialize HomePage Web Elements
		HomePage_HCM homePage_HCM = PageFactory.initElements(driver, HomePage_HCM.class);
		
		//Validate HomePage Icon
		if(homePage_HCM.HomePage_HomeIcon.isDisplayed() == true)
		{
			//PASS
			rpt.generateReport("COR002_Assignment Change", "Login to Appication", "", "UserName: "+exl.read("LoginDetails", 1, "UserName"), "Login Should be successful", "Login Is Successful", "Passed", "", true );
		}else
		{
			//FAIL
			rpt.generateReport("COR002_Assignment Change", "Login to Appication", "", "UserName: "+exl.read("LoginDetails", 1, "UserName"), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
			new RuntimeException("Login Un-Successful");
		}

		//Always Load TestData Sheet Excel After Login as UserName & Password exists in other Excel which is loaded in TestBase
		exl = new ExcelOperations("HCM\\com\\dataBanks\\HCM_TestData.xlsx");

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
			new RuntimeException("Login Un-Successful");
		}
		
		//Click on Navigator Icon
		homePage_HCM.clickOnNavigationIcon();

		//Click On Person Management from Navigator Links
		SearchPerson Person_Management = homePage_HCM.clickOnPersonManagementLink();
		
		//Verify Person Number Edit box is displayed
		if(Person_Management.PersonNumber.isDisplayed() == true)
		{
			rpt.generateReport("", "Navigation to Person Management Page", "", "", "Person Management Page should be displayed", "Person Management Page Is displayed", "Passed", "", true );
			
		}else
		{
			//FAIL
			rpt.generateReport("", "Navigation to Person Management Page", "", "", "Person Management Page should be displayed", "Person Management Page Is Not displayed", "Failed", "", true );
			new RuntimeException("Person Management Page is not displayed");
		}
		
		//Enter the Details to Search the Person
		Person_Management.enterPersonNumber(exl.read(strDataSheetName, 1, "Person_Number"));
		Person_Management.clickOnSearch();
		
		//Verify the Search Person Record Exists
		if(Person_Management.verifySearchedRecordExists(exl.read(strDataSheetName, 1, "Person_Number")) == false) {
			//Fail
			rpt.generateReport("", "Enter Search Person details", "", "Person Number: "+exl.read(strDataSheetName, 1, "Person_Number"), "Entered Person Number details should be displayed", "Entered Person Number details could not be displayed", "Failed", "", true);
			throw new SkipException("Person Number in Search Person page could not be entered");
		}else
		{
			//Pass
			rpt.generateReport("", "Enter Search Person details", "", "Person Number: "+exl.read(strDataSheetName, 1, "Person_Number"), "Entered Person Number details should be displayed", "Entered Person Number details is displayed", "Passsed", "", true);
		}
		
		//Verify If Employee is in Active Payroll
		if(Person_Management.verifyActivePayroll(exl.read(strDataSheetName, 1, "Person_Name")) == false) {
			rpt.generateReport("", "Verify Employment Status", "", "", "Employement Status should be Active", "Employement Status is Not Active", "Failed", "", true);
			throw new SkipException("Employment Status is not Active");
		}else {
			rpt.generateReport("", "Verify Employment Status", "", "", "Employement Status should be Active", "Employement Status is Active", "Passed", "", false);
		}
		
		//Click On the Searched Person
		if(Person_Management.clickOnSearchedPerson(exl.read(strDataSheetName, 1, "Person_Name")) == false) {
			rpt.generateReport("", "Click On the Searched Person", "", "Person Name", "Searched Person Link should be clicked", "Searched Person Name link is not clicked", "Failed", "", true);
		}
		
		//Initialize the ManageEmployment Class
		ManageEmployment manageEmployment = PageFactory.initElements(driver, ManageEmployment.class);
		
		//Verify Manage Employment Tab
		if(manageEmployment.ExistingAssignment.isDisplayed() == false) {
			rpt.generateReport("", "Manage Employment", "", "", "Manage Employment Tab should be opened", "Manage Employment Tab is not opened", "Failed", "", true);
			throw new SkipException("Manage Employment tab does not exist");
		}else
		{
			rpt.generateReport("", "Manage Employment", "", "", "Manage Employment Tab should be opened", "Manage Employment Tab is opened", "Passed", "", true);
		}
			
		//Get the Existing Employee Position value
		String strPosition = manageEmployment.getExistingAssignment();
		if(strPosition != null) {
			rpt.generateReport("", "Capture Existing Employee Position", "", "", "Existing Emp Position should be captured", "Existing Emp Position is: "+strPosition, "Passed", "", true);
		}else {
			rpt.generateReport("", "Capture Existing Employee Position", "", "", "Existing Emp Position should be captured", "Existing Emp Position could not captured", "Failed", "", true);
			throw new SkipException("Existing Emp Position is: "+strPosition);
		}
		
		//Click On Edit and Click Update
		manageEmployment.clickOnEditnUpdate();
		
		//Enter the Details in Update Employment popup 
		String strEffectiveDate = exl.read(strDataSheetName, 1, "Start_Effective_Date");
		String strAction = exl.read(strDataSheetName, 1, "Action");
		String strAction_Reason = exl.read(strDataSheetName, 1, "Action_Reason");
		if(manageEmployment.enterInUpdateEmploymentPopUp(strEffectiveDate, strAction, strAction_Reason) == false) {
			rpt.generateReport("", "Enter Details in Update Employment Popup", "", "Start Effective Date: "+strEffectiveDate+", Action: "+strAction+", Action Reason: "+strAction_Reason, "Details should be entered", "Details could not be entered", "Failed", "", true);
			throw new SkipException("Method: enterInUpdateEmploymentPopUp Failed..");
		}else {
			rpt.generateReport("", "Enter Details in Update Employment Popup", "", "Start Effective Date: "+strEffectiveDate+", Action: "+strAction+", Action Reason: "+strAction_Reason, "Details should be entered", "Details are entered", "Passed", "", true);
		}
		
		//Click On OK Button in Update Employment Popup
		manageEmployment.clickOnOKButtoninPopup();
		
		//Change the Position
		if(manageEmployment.enterInPosition(exl.read(strDataSheetName, 1, "Position")) == true) {
			rpt.generateReport("", "Enter Postion value", "", exl.read(strDataSheetName, 1, "Position"), "Position value should be entered", "Position value is entered", "Passed", "", true);
		}else {
			rpt.generateReport("", "Enter Postion value", "", exl.read(strDataSheetName, 1, "Position"), "Position value should be entered", "Position value is not entered", "Failed", "", true);
			throw new SkipException("Position value could not be changed");
		}
		
		//Click Yes if Popup appears after the change of Position
		manageEmployment.clickOnYesButtonInPopUp();
		
		//Click On the Review
		manageEmployment.clickOnReviewButton();
		
		if(manageEmployment.SubmitButton.isDisplayed() == false) {
			rpt.generateReport("", "Verify Review Page", "", "", "Review Page should be existed", "Review Page does not exist", "Failed", "", true);
		}else {
			rpt.generateReport("", "Verify Review Page", "", "", "Review Page should be existed", "Review Page exists", "Passed", "", true);
		}
		
		//Click On the Submit Button
		manageEmployment.clickOnSubmitButton();
		
		//Verify Warning Pop Up Exists and Click Yes if exists
		String strWarningPopUpContainerString = manageEmployment.getWarningPopUpContainerString();
		if(strWarningPopUpContainerString != null) {
			rpt.generateReport("", "Capture Warning Pop Up Message", "", "", "Warning PopUp message should be captured", "Warning Pop up message is: "+strWarningPopUpContainerString, "Passed", "", true);
			
			//If PopUp exists the Click On Yes Button in PopUp
			manageEmployment.clickOnYesButtonInPopUp();
			
			if(manageEmployment.clickOnOKButtonInConfirmationPopup() == false) {
				rpt.generateReport("", "Verify Submit", "", "", "Change Assignment Should be submitted", "Could not Click on Submit button", "Failed", "", false);
			}else {
				rpt.generateReport("", "Verify Submit", "", "", "Change Assignment Should be submitted", "Could not Click on Submit button", "Failed", "", false);
			}
		}
		System.out.println("********** End Of Script COR002 **********");
		System.out.println();
	}
	
	
}
