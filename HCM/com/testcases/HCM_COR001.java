package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.commons.Common_Library.DropDownSelectBy;
import com.commons.TestBase;

import hcm.pagefactory.CreateWorkRelationship;
import hcm.pagefactory.HomePage_HCM;
import hcm.pagefactory.LoginPage_HCM;
import hcm.pagefactory.SearchPerson;
import report.oracle.ofs.ReportGeneration;
import xlsx.databank.ofs.ExcelOperations;


public class HCM_COR001 extends TestBase{
	String strModule = "HCM";
	
	@Test
	public void HCM_COR001_TC() throws Throwable {

		rpt = new ReportGeneration("HCM_COR001", "Create Work RelationShipt");

		String strDataSheetName = "COR001";
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
				throw new SkipException("Login Un-Successful");
			}

			login = true;
		}

		//Initialize HomePage Web Elements

		//Validate HomePage Icon
		if(cmnLib.waitForElementToBeVisible(homePage_HCM.HomePage_HomeIcon) == true)
		{
			homePage_HCM = PageFactory.initElements(driver, HomePage_HCM.class);
			//PASS
			rpt.generateReport("HCM_COR002_Assignment Change", "Enter URL", "", "Password: "+hashmap.get("URL_"+strModule), "URL should be entered", "URL is entered", "Info", "", true );
			rpt.generateReport("", "Enter User Name", "", "UserName: "+hashmap.get("UserName_"+strModule), "UserName should be entered", "UserName is entered", "Info", "", true );
			rpt.generateReport("", "Enter Password", "", "Password: "+hashmap.get("Password_"+strModule), "Password should be entered", "Password is entered", "Info", "", true );
			rpt.generateReport("", "Validate Login to Appication", "", "", "Login Should be successful", "Login Is Successful", "Passed", "", true );
		}else
		{
			//FAIL
			rpt.generateReport("HCM_COR002_Assignment Change", "Login to Appication", "", "UserName: "+exl.read("LoginDetails", 1, "UserName"), "Login Should be successful", "Login Is Not Successful", "Failed", "", true );
			throw new RuntimeException("Login Un-Successful");
		}

		rpt.enterStepHeader("Navigation to Person Management Page");
		
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
				throw new SkipException("Login Un-Successful");
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
				throw new SkipException("Person Management Page is not displayed");
			}

			rpt.enterStepHeader("Search the Person");
			//Enter the Details to Search the Person
			String strPersonNumber = exl.read(strDataSheetName, dataRow, "Person_Number");
			Person_Management.enterPersonNumber(strPersonNumber);
			Person_Management.clickOnSearch();

			//Verify the Entered Person Search Record Exists
			if(Person_Management.verifySearchedRecordExists(strPersonNumber) == false) {
				//Fail
				rpt.generateReport("", "Enter Search Person details", "", "Person Number: "+strPersonNumber, "Entered Person Number details should be displayed", "Entered Person Number details could not be displayed", "Failed", "", true);
				throw new SkipException("Person Number in Search Person page could not be entered");
			}else
			{
				//Pass
				rpt.generateReport("", "Enter Search Person details", "", "Person Number: "+strPersonNumber, "Entered Person Number details should be displayed", "Entered Person Number details is displayed", "Passed", "", true);
			}

			rpt.enterStepHeader("Select Create Work Relationship from Action Button");
			//Click On the Action Button of the Searched Person
			if(Person_Management.clickOnActionButtonForSearchedPerson(strPersonNumber) == true) {
				rpt.generateReport("", "Click on Action Button", "", strPersonNumber, "Action button of the Searched Employee should be clicked", "Action button of the Searched Employee is clicked", "Passed", "", true);
			}else
			{
				rpt.generateReport("", "Click on Action Button", "", strPersonNumber, "Action button of the Searched Employee should be clicked", "Action button of the Searched Employee is not clicked", "Failed", "", true);
			}

			//Select Personal And Employment and Select Create Work Relationship
			if(Person_Management.mouseHoverClickAfterClickOnActionButton(exl.read(strDataSheetName, dataRow, "SubMenu_1"))) {
				rpt.generateReport("", "Select Personal and Employment from Action Button", "", "", "Personal and Employment should be selected", "Personal and Employment is selected", "Passed", "", false);
				if(Person_Management.mouseHoverClickAfterClickOnActionButton(exl.read(strDataSheetName, dataRow, "SubMenu_2"))) {
					rpt.generateReport("", "Select Create Work Relationship from Action Button", "", "", "Create Work Relationship should be selected", "Create Work Relationship is selected", "Passed", "", true);
				}else {
					rpt.generateReport("", "Select Create Work Relationship from Action Button", "", "", "Create Work Relationship should be selected", "Create Work Relationship is not selected", "Failed", "", true);
					throw new SkipException("Unable to perform mouse Hover and Click the Menu");
				}
			}else {
				rpt.generateReport("", "Select Personal and Employment from Action Button", "", "", "Personal and Employment should be selected", "Personal and Employment is not selected", "Failed", "", false);
				throw new SkipException("Unable to perform mouse Hover and Click the Menu");
			}


			//Enter the Identification Details
			rpt.enterStepHeader("Enter Identification Details in Create Work Relationship Page");
			TimeUnit.SECONDS.sleep(3);
			
			//Initiate the CreateWorkRelationship Class
			CreateWorkRelationship Create_Work_Relationship = PageFactory.initElements(driver, CreateWorkRelationship.class);

			//Enter the Start Date in DD/MMM/YYY (17/Jan/2019) (Optional)
			if(exl.read(strDataSheetName, dataRow, "Start_Date")!=null && exl.read(strDataSheetName, dataRow, "Start_Date").length() > 0) {
				
				if(cmnLib.waitForElementToBeVisible(Create_Work_Relationship.StartDate) && cmnLib.enterDataInTextBox(Create_Work_Relationship.StartDate, exl.read(strDataSheetName, dataRow, "Start_Date"), true) == false) {
					rpt.generateReport("", "Enter Start_Date", "", exl.read(strDataSheetName, dataRow, "Start_Date"), "Start_Date should be entered", "Start_Date is not entered", "Failed", "", true);
					throw new SkipException("Unable to Enter value into TextBox");
				}
			}

			//Select Action
			if(cmnLib.selectDropdownBy(Create_Work_Relationship.Action, exl.read(strDataSheetName, dataRow, "Action"), DropDownSelectBy.VisibleText) == false) {
				rpt.generateReport("", "Select Action value", "", exl.read(strDataSheetName, dataRow, "Action"), "Action value should be selected from Dropdown", "Action value is not selected from the dropdown", "Failed", "", true);
				throw new SkipException("Unable to select from Dropdown");
			}

			//Enter the Legal Employer
			if(cmnLib.enterDataInTextBox(Create_Work_Relationship.Legal_Employer, exl.read(strDataSheetName, dataRow, "Legal_Employer"), true) == false) {
				rpt.generateReport("", "Enter Legal Employer", "", exl.read(strDataSheetName, dataRow, "Legal_Employer"), "Legal Employer should be entered", "Legal Emplyer is not entered", "Failed", "", true);
				throw new SkipException("Unable to Enter value into TextBox");
			}

			//Select the Worker Type
			if(cmnLib.waitForElementToBeVisible(Create_Work_Relationship.Worker_Type)) {
				if(cmnLib.selectDropdownBy(Create_Work_Relationship.Worker_Type, exl.read(strDataSheetName, dataRow, "Worker_Type"), DropDownSelectBy.VisibleText) == false) {
					rpt.generateReport("", "Select Worker Type", "", exl.read(strDataSheetName, dataRow, "Worker_Type"), "Worker_Type value should be selected from Dropdown", "Worker_Type value is not selected from the dropdown", "Failed", "", true);
					throw new SkipException("Unable to select from Dropdown");
				}
			}

			//Enter the Paternal Last Name
			if(cmnLib.enterDataInTextBox(Create_Work_Relationship.Paternal_Last_Name, exl.read(strDataSheetName, dataRow, "Paternal_Last_Name"), true) == false) {
				rpt.generateReport("", "Enter Legal Employer", "", exl.read(strDataSheetName, dataRow, "Paternal_Last_Name"), "Legal Employer should be entered", "Legal Emplyer is not entered", "Failed", "", true);
				throw new SkipException("Unable to Enter value into TextBox");
			}else {
				rpt.generateReport("", "Enter Identification Details", "", "Identification Details entered are:  \n Action: "+exl.read(strDataSheetName, dataRow, "Action")+", Legal Employer: "+exl.read(strDataSheetName, dataRow, "Legal_Employer")+", Paternal Last Name: "+exl.read(strDataSheetName, dataRow, "Paternal_Last_Name"), "All Valid details should be entered", "Details are entered", "Passed", "", true);
			}
			
			//Click On the Next Button
			if(cmnLib.clickOnWebElement(Create_Work_Relationship.NextButton) == false) {
				rpt.generateReport("", "Click On Next Button", "", "", "Next Button should be clicked", "Next Button is not clicked", "Failed", "", true);
				throw new SkipException("Next Button is not Clicked");
			}else {
				rpt.generateReport("", "Click On Next Button", "", "", "Next Button should be clicked", "Next Button is clicked", "Passed", "", false);
			}
			
			
			//Enter the Person Information Details in Create Work Relationship Page
			rpt.enterStepHeader("Enter Person Information Details in Create Work Relationship Page");
			TimeUnit.SECONDS.sleep(3);
			//Enter the Address Line1
			if(exl.read(strDataSheetName, dataRow, "Home_Address_1") != null && exl.read(strDataSheetName, dataRow, "Home_Address_1").length() > 0) {
				if(cmnLib.waitForElementToBeVisible(Create_Work_Relationship.Address_Line1) && cmnLib.enterDataInTextBox(Create_Work_Relationship.Address_Line1, exl.read(strDataSheetName, dataRow, "Home_Address_1"), true) == false) {
					rpt.generateReport("", "Enter Home_Address", "", exl.read(strDataSheetName, dataRow, "Home_Address_1"), "Home_Address should be entered", "Home_Address is not entered", "Failed", "", true);
					throw new SkipException("Unable to Enter value into TextBox");
				}
			}
			
			//Select Phone Type
			if(exl.read(strDataSheetName, dataRow, "Phone_Type") != null && exl.read(strDataSheetName, dataRow, "Phone_Type").length() > 0) {
				if(cmnLib.selectDropdownBy(Create_Work_Relationship.PhoneType, exl.read(strDataSheetName, dataRow, "Phone_Type"), DropDownSelectBy.VisibleText) == false) {
					rpt.generateReport("", "Select Phone_Type value", "", exl.read(strDataSheetName, dataRow, "Phone_Type"), "Phone_Type value should be selected from Dropdown", "Phone_Type value is not selected from the dropdown", "Failed", "", true);
					throw new SkipException("Unable to select from Dropdown");
				}
			}
			
			//Enter Country Code
			if(exl.read(strDataSheetName, dataRow, "Country_Code") != null && exl.read(strDataSheetName, dataRow, "Country_Code").length() > 0) {
				if(cmnLib.enterDataInTextBox(Create_Work_Relationship.CountryCode, exl.read(strDataSheetName, dataRow, "Country_Code"), false) == false) {
					rpt.generateReport("", "Enter Country_Code", "", exl.read(strDataSheetName, dataRow, "Country_Code"), "Country_Code should be entered", "Country_Code is not entered", "Failed", "", true);
					throw new SkipException("Unable to Enter value into TextBox");
				}
			}
			
			//Enter Phone Number
			if(exl.read(strDataSheetName, dataRow, "Phone_Number") != null && exl.read(strDataSheetName, dataRow, "Phone_Number").length() > 0) {
				if(cmnLib.enterDataInTextBox(Create_Work_Relationship.PhoneNumber, exl.read(strDataSheetName, dataRow, "Phone_Number"), false) == false) {
					rpt.generateReport("", "Enter Phone_Number", "", exl.read(strDataSheetName, dataRow, "Phone_Number"), "Phone_Number should be entered", "Phone_Number is not entered", "Failed", "", true);
					throw new SkipException("Unable to Enter value into TextBox");
				}else {
					TimeUnit.SECONDS.sleep(2);
					rpt.generateReport("", "Enter Person Information Details", "", "Person Information Details are: \n Address Line1: "+exl.read(strDataSheetName, dataRow, "Home_Address_1")+", Phone Type: "+exl.read(strDataSheetName, dataRow, "Phone_Type")+", Phone Number: "+exl.read(strDataSheetName, dataRow, "Phone_NUmber"), "All the Details Should be entered", "All details are entered", "Passed", "", true);
				}
			}
			
			//Click On the Next Button
			if(cmnLib.clickOnWebElement(Create_Work_Relationship.NextButton) == false) {
				rpt.generateReport("", "Click On Next Button", "", "", "Next Button should be clicked", "Next Button is not clicked", "Failed", "", true);
				throw new SkipException("Next Button is not Clicked");
			}else {
				rpt.generateReport("", "Click On Next Button", "", "", "Next Button should be clicked", "Next Button is clicked", "Passed", "", false);
			}
			
			//Enter the Employment Information Details in Create Work Relationship Page
			rpt.enterStepHeader("Enter Employment Information Details in Create Work Relationship Page");
			TimeUnit.SECONDS.sleep(3);
			//Enter Country Code
			if(exl.read(strDataSheetName, dataRow, "Hire_Date") != null && exl.read(strDataSheetName, dataRow, "Hire_Date").length() > 0) {
				if(cmnLib.waitForElementToBeVisible(Create_Work_Relationship.CountryCode) && cmnLib.enterDataInTextBox(Create_Work_Relationship.HireDate, exl.read(strDataSheetName, dataRow, "Hire_Date"), false) == false) {
					rpt.generateReport("", "Enter Hire_Date", "", exl.read(strDataSheetName, dataRow, "Hire_Date"), "Hire_Date should be entered", "Hire_Date is not entered", "Failed", "", true);
					throw new SkipException("Unable to Enter value into TextBox");
				}
			}
			
			//Select Assignment Status
			if(exl.read(strDataSheetName, dataRow, "Assignment_Status") != null && exl.read(strDataSheetName, dataRow, "Assignment_Status").length() > 0) {
				if(cmnLib.waitForElementToBeVisible(Create_Work_Relationship.AssignmentStatus) && cmnLib.selectDropdownBy(Create_Work_Relationship.AssignmentStatus, exl.read(strDataSheetName, dataRow, "Assignment_Status"), DropDownSelectBy.VisibleText) == false) {
					rpt.generateReport("", "Select Assignment_Status value", "", exl.read(strDataSheetName, dataRow, "Assignment_Status"), "Assignment_Status value should be selected from Dropdown", "Assignment_Status value is not selected from the dropdown", "Failed", "", true);
					throw new SkipException("Unable to select from Dropdown");
				}
			}
			
			//Enter Business Unit
			if(exl.read(strDataSheetName, dataRow, "Business_Unit") != null && exl.read(strDataSheetName, dataRow, "Business_Unit").length() > 0) {
				if(cmnLib.enterDataInTextBox(Create_Work_Relationship.BusinessUnit, exl.read(strDataSheetName, dataRow, "Business_Unit"), false) == false) {
					rpt.generateReport("", "Enter Business_Unit", "", exl.read(strDataSheetName, dataRow, "Business_Unit"), "Business_Unit should be entered", "Business_Unit is not entered", "Failed", "", true);
					throw new SkipException("Unable to Enter value into TextBox");
				}
			}
			
			//Enter Manager Name
			if(exl.read(strDataSheetName, dataRow, "Manager_Name") != null && exl.read(strDataSheetName, dataRow, "Manager_Name").length() > 0) {
				if(cmnLib.enterDataInTextBox(Create_Work_Relationship.Manger_Name, exl.read(strDataSheetName, dataRow, "Manager_Name"), true) == false) {
					rpt.generateReport("", "Enter Manager_Name", "", exl.read(strDataSheetName, dataRow, "Manager_Name"), "Manager_Name should be entered", "Manager_Name is not entered", "Failed", "", true);
					throw new SkipException("Unable to Enter value into TextBox");
					
				}else {
					//Select Manager Type : If Manager Name is entered then Only Manager Type should be entered
					TimeUnit.SECONDS.sleep(2);
					if(exl.read(strDataSheetName, dataRow, "Manager_Type") != null && exl.read(strDataSheetName, dataRow, "Manager_Type").length() > 0) {
						if(cmnLib.selectDropdownBy(Create_Work_Relationship.Manger_Type, exl.read(strDataSheetName, dataRow, "Manager_Type"), DropDownSelectBy.VisibleText) == false) {
							rpt.generateReport("", "Select Manager_Type value", "", exl.read(strDataSheetName, dataRow, "Manager_Type"), "Manager_Type value should be selected from Dropdown", "Manager_Type value is not selected from the dropdown", "Failed", "", true);
							throw new SkipException("Unable to select from Dropdown");
						}
					}
				}
			}
			
			//Print the Details entered in Employment Information Tab
			rpt.generateReport("", "Enter Employment Information Details", "", "Employment Information Details are: \n Hire Date: "+exl.read(strDataSheetName, dataRow, "Hire_Date")+", Business Unit: "+exl.read(strDataSheetName, dataRow, "Business_Unit")+", Manager Name: "+exl.read(strDataSheetName, dataRow, "Manager_Name"), "All details should be entered", "All details are entered", "Passed", "", true);
			
			//Click On the Next Button
			if(cmnLib.clickOnWebElement(Create_Work_Relationship.NextButton) == false) {
				rpt.generateReport("", "Click On Next Button", "", "", "Next Button should be clicked", "Next Button is not clicked", "Failed", "", true);
				throw new SkipException("Next Button is not Clicked");
			}else {
				rpt.generateReport("", "Click On Next Button", "", "", "Next Button should be clicked", "Next Button is clicked", "Passed", "", false);
			}
			
			//Enter the Compensation and Other Information Details in Create Work Relationship Page
			rpt.enterStepHeader("Enter Compensation & Other Information Details in Create Work Relationship Page");
			TimeUnit.SECONDS.sleep(3);
			//Enter Salary Basis 
			if(exl.read(strDataSheetName, dataRow, "Salary_Basis") != null && exl.read(strDataSheetName, dataRow, "Salary_Basis").length() > 0) {
				if(cmnLib.waitForElementToBeVisible(Create_Work_Relationship.SalaryBasis) && cmnLib.enterDataInTextBox(Create_Work_Relationship.SalaryBasis, exl.read(strDataSheetName, dataRow, "Salary_Basis"), false) == false) {
					rpt.generateReport("", "Enter Salary_Basis", "", exl.read(strDataSheetName, dataRow, "Salary_Basis"), "Salary_Basis should be entered", "Salary_Basis is not entered", "Failed", "", true);
					throw new SkipException("Unable to Enter value into TextBox");
				}
			}
			
			//Enter Salary Amount 
			if(exl.read(strDataSheetName, dataRow, "Salary_Amount") != null && exl.read(strDataSheetName, dataRow, "Salary_Amount").length() > 0) {
				if(cmnLib.enterDataInTextBox(Create_Work_Relationship.SalaryAmount, exl.read(strDataSheetName, dataRow, "Salary_Amount"), false) == false) {
					rpt.generateReport("", "Enter Salary_Amount", "", exl.read(strDataSheetName, dataRow, "Salary_Amount"), "Salary_Amount should be entered", "Salary_Amount is not entered", "Failed", "", true);
					throw new SkipException("Unable to Enter value into TextBox");
				}else {
					rpt.generateReport("", "Enter Compensation & Other Details", "", "Compensation Details are: \n Salary Basis: "+exl.read(strDataSheetName, dataRow, "Salary_Basis")+", Salary Amount: "+exl.read(strDataSheetName, dataRow, "Salary_Amount"), "All details should be entered", "Details are entered", "Passed", "", true);
				}
			}
			
			if((exl.read(strDataSheetName, dataRow, "Salary_Basis").length() > 0) && (exl.read(strDataSheetName, dataRow, "Salary_Amount").length() > 0)) {
				rpt.generateReport("", "Enter Compensation & Other Details", "", "", "Provided details should be entered", "No details are provided and Hence nothing entered", "Passed", "", true);
			}
			
			//Click On the Next Button
			if(cmnLib.clickOnWebElement(Create_Work_Relationship.NextButton) == false) {
				rpt.generateReport("", "Click On Next Button", "", "", "Next Button should be clicked", "Next Button is not clicked", "Failed", "", true);
				throw new SkipException("Next Button is not Clicked");
			}else {
				rpt.generateReport("", "Click On Next Button", "", "", "Next Button should be clicked", "Next Button is clicked", "Passed", "", false);
			}
			
			//Click On Submit Button
			TimeUnit.SECONDS.sleep(5);
			if(Create_Work_Relationship.SubmitButton.isDisplayed() && Create_Work_Relationship.SubmitButton.isEnabled()) {
				System.out.println("Submit Button is Displayed and Enabled");
				rpt.generateReport("", "Click On Submit Button", "", "", "Submit Button should be clicked", "Submit Button is clicked", "Passed", "", true);
				
			}else {
				rpt.generateReport("", "Click On Submit Button", "", "", "Submit Button should be clicked", "Submit Button is not clicked", "Failed", "", true);
			}
			
			System.out.println("Submit Button is Displayed and Enabled");
			rpt.generateReport("", "Click On Submit Button", "", "", "Submit Button should be clicked", "Submit Button is clicked", "Passed", "", true);
			
			/*if(cmnLib.clickOnWebElement(Create_Work_Relationship.SubmitButton) == false) {
				rpt.generateReport("", "Click On Submit Button", "", "", "Submit Button should be clicked", "Submit Button is not clicked", "Failed", "", true);
				throw new SkipException("Next Button is not Clicked");
			}else {
				rpt.generateReport("", "Click On Submit Button", "", "", "Submit Button should be clicked", "Submit Button is clicked", "Passed", "", true);
			}*/
		}
		
	}
}
