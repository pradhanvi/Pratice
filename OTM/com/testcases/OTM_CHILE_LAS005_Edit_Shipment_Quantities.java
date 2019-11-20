package com.testcases;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.commons.Common_Library.FrameSelectBy;
import com.commons.TestBase;

import otm.pagefactory.HomePage_OTM;
import otm.pagefactory.LoginPage_OTM;
import otm.pagefactory.OrderReleaseFinder;
import otm.pagefactory.OrderReleaseResult;
import otm.pagefactory.EditShipmentQuantity;
import report.oracle.ofs.ReportGeneration;
import xlsx.databank.ofs.ExcelOperations;

/**
Script Name			: OTM_CHILE_LAS005_Edit_Shipment_Quantities
Script Description	: Edit Shipment Quantities
Track/Module		: OTM
Sub Track			: 
Created By			: Chitralekha
Creation Date		: 
Modified By 		: Pradhanvi T R
Modification Date	: 25-Mar-19
Instance Name & URL : https://otmgtm-edyg-dev7.otm.us2.oraclecloud.com/GC3/glog.webserver.servlet.umt.Logi
User ID/ Password	: TESTING_CHILE@beehiveonline.oracle.com/Bimbo321
Responsibility		: Domain(edyg-dev7)
Pre-Requisites		: 
Comments (if any)	:
 **/

public class OTM_CHILE_LAS005_Edit_Shipment_Quantities extends TestBase
{

	String strModule = "OTM_CHILE";

	@Test
	public void f() throws Throwable 
	{
		rpt = new ReportGeneration("OTM_CHILE_LAS005_Edit_Shipment_Quantities","Edit Shipment Quantities");

		// Login to Application
		HomePage_OTM homepage = null;
		if (!(new HomePage_OTM().getUserNameFromHomePage() != null && new HomePage_OTM().getUserNameFromHomePage()
				.equalsIgnoreCase(hashmap.get("UserName_" + strModule)))) 
		{

			launchBrowser(strModule);
			// Launch & Login

			LoginPage_OTM loginPage = new LoginPage_OTM();
			loginPage.setDomain(hashmap.get("Domain_" + strModule));
			homepage = loginPage.login(hashmap.get("UserName_" + strModule), hashmap.get("Password_" + strModule));
		}

		rpt.enterStepHeader("Login to Application");
		
		if (homepage != null) 
		{
			rpt.generateReport("OTM_LAS005_To_Edit_Shpmt_Qty", "Enter Username", "",
					hashmap.get("UserName_" + strModule), "Username must be entered", "Username entered", "Passed", "",
					false);
			rpt.generateReport("OTM_LAS005", "Enter Password", "", "", "Password must be entered", "Password entered", "Passed",
					"", false);
			rpt.generateReport("OTM_LAS005", "Click Sign In button", "", "", "Sign In button must be clicked",
					"Clicked Sign In button", "Passed", "", true);
		} 
		else 
		{
			rpt.generateReport("OTM_LAS005_To_Edit_Shpmt_Qty", "Login to application",
					"Enter Username, Password and Click Sign In button",
					"Username: " + hashmap.get("UserName_" + strModule), "Login must be Successful",
					"Login Un-Successful", "Failed", "", true);
			Assert.fail("Login Un-Successful");
		}

		exl = new ExcelOperations("OTM\\com\\databanks\\OTM_TestData.xlsx");
		String sheetName = "LAS005";
		
		System.out.println("No Of DataRows: " + exl.getRowCount(sheetName));
		for (int dataRow = 1; dataRow < exl.getRowCount(sheetName); dataRow++) 
		{
			
			//Navigation
			if(homepage.clickOnWelcomePage_HomeIcon() == true)
			{
				homepage = PageFactory.initElements(driver, HomePage_OTM.class);
			}else
			{
				rpt.generateReport("", "Click On HomePage Icon", "", "", "HomePage Icon should be clicked", "HomePage Icon is not clicked", "Failed", "", true);
			}

		//Verify Presence of Navigator Icon
			if(homepage.NavigatorIcon.isDisplayed() == false)
			{
				//FAIL
				rpt.generateReport("", "Validate HomePage", "", "", "Validation Should be successful", "Validation Is Not Successful", "Failed", "", true );
				Assert.fail("Login Un-Successful");
			}
			TimeUnit.SECONDS.sleep(5);
		/*//Click on Navigator Icon
			homepage.clickOnNavigationIcon();
			TimeUnit.SECONDS.sleep(5);*/

			// Click Rapid Order Icon
			rpt.enterStepHeader("Go to Rapid Order");
			OrderReleaseFinder orderReleaseFinder = homepage.clickOnRapidOrder();
			cmnLib.waitForPageLoaded();
			cmnLib.switchToFrame(orderReleaseFinder.actionFrame, FrameSelectBy.FrameWebElement);
			if (cmnLib.clickOnWebElement(homepage.OrderRelaeseFinderPage) == true) 
			{
				orderReleaseFinder = new OrderReleaseFinder();
				rpt.generateReport("OTM_LAS005", "Click on Rapid Order icon", "", "", "Rapid Order icon must be clicked",
						"Clicked on Rapid Order icon", "Passed", "", true);
			} 
			else 
			{
				rpt.generateReport("OTM_LAS005", "Navigate to Order Release Finder page", "Click on Rapid Order icon", "",
						"Rapid Order icon must be clicked and application must navigate to Order Release Finder page",
						"Failed to click Rapid Order icon and navigate to Order Release Finder page", "Failed", "", true);
				Assert.fail("Failed to click Rapid Order icon and navigate to Order Release Finder page");
			}

			// Perform search with Order Release ID
			
			rpt.enterStepHeader("Perform Search with Order Release ID");
			OrderReleaseResult orderReleaseResult = null;
			cmnLib.enterDataInTextBox(orderReleaseFinder.order_Relase_ID, exl.read(sheetName, dataRow, "OrderReleaseID"),
					false);
			if (cmnLib.clickByJSE(orderReleaseFinder.search_button)) 
			{
				orderReleaseResult = new OrderReleaseResult();
				rpt.generateReport("OTM_LAS005", "Enter Order Release ID", "Enter Order Release ID",
						exl.read(sheetName, dataRow, "OrderReleaseID"), "Order Release ID must be entered",
						"Order Release ID entered", "Passed", "", false);
				rpt.generateReport("OTM_LAS005", "Click on Search button", "Click on Search button", "",
						"Search button must be clicked", "Clicked on Search button", "Passed", "", true);
			} 
			else 
			{
				rpt.generateReport("OTM_LAS005", "Perform search with Order Release ID",
						"Enter Order Release ID and Click Search button", exl.read(sheetName, dataRow, "OrderReleaseID"),
						"Search must be Successful", "Search Un-Successful", "Passed", "", true);
				Assert.fail("Search Un-Successful");
			}
	
			// Select Order from the results
			rpt.enterStepHeader("Select an Order and Edit Shipment Quantities");
			if (orderReleaseResult.selectOrderFromResuls(exl.read(sheetName, dataRow, "OrderReleaseID"))) 
			{
				rpt.generateReport("OTM_LAS005", "Select Order from results", "", exl.read(sheetName, dataRow, "OrderReleaseID"),
						"Order must be selected from results", "Selected Order from results", "Passed", "", true);
			} 
			else 
			{
				rpt.generateReport("OTM_LAS005", "Select Order from results", "", exl.read(sheetName, dataRow, "OrderReleaseID"),
						"Order must be selected from results", "Failed to select Order from results", "Failed", "", true);
				Assert.fail("Failed to select Order from results");
			}
			TimeUnit.SECONDS.sleep(4);
			// Select Edit Shipment Quantities under Actions dropdown
						if (cmnLib.clickByJSE(orderReleaseResult.actionsDropdown) == true) {
							rpt.generateReport("OTM_LAS005", "Click Actions dropdown", "", "", "Actions dropdown must be clicked",
									"Clicked on Actions dropdown", "Passed", "", true);
						} else {
							rpt.generateReport("OTM_LAS005", "Click Actions dropdown", "", "", "Actions dropdown must be clicked",
									"Actions dropdown not clicked", "Failed", "", true);
							Assert.fail("Actions dropdown not clicked");
						}
				
						cmnLib.switchToFrame("actionFrame", FrameSelectBy.StringFrameName);
				
						String parentNode = exl.read(sheetName, dataRow, "Actions_Parent");
						String childNode = exl.read(sheetName, dataRow, "Actions_Child");
						String link = exl.read(sheetName, dataRow, "Actions_Link");
				
						// Select Parent Node under Actions dropdown
						WebElement parentElement = orderReleaseResult.clickNodeUnderActionsDropdown(orderReleaseResult.actionTree,parentNode);
				
						if (parentElement != null) {
							rpt.generateReport("OTM_LAS005", "Click " + parentNode + " under Actions dropdown", "", parentNode,
									parentNode + " must be clicked", "Clicked " + parentNode, "Passed", "", true);
						} else {
							rpt.generateReport("OTM_LAS005", "Click " + parentNode + " under Actions dropdown", "", parentNode,
									parentNode + " must be clicked", parentNode + "not clicked", "Failed", "", true);
							Assert.fail(parentNode + "not clicked");
						}

					// Select Child Node
					WebElement childElement = orderReleaseResult.clickNodeUnderActionsDropdown(parentElement,
							exl.read(sheetName, dataRow, "Actions_Child"));

					if (childElement != null)
					{
						rpt.generateReport("OTM_LAS005", "Click " + childNode, "", childNode, childNode + " must be clicked",
								"Clicked " + childNode, "Passed", "", true);
					} 
					else 
					{
						rpt.generateReport("OTM_LAS005", "Click " + childNode, "", childNode, childNode + " must be clicked",
								childNode + " not clicked", "Failed", "", true);
						Assert.fail(childNode + "not clicked");
					}

					// Click link
					boolean result = orderReleaseResult.selectLinkUnderNode(childElement, exl.read(sheetName, dataRow, "Actions_Link"));

					// Switch to new Window
					String pHandle = driver.getWindowHandle();

					Set<String> allHandles = null;
					boolean flag = false;
					while (!flag) 
					{
						allHandles = driver.getWindowHandles();
						if (allHandles.size() > 1)
						{
							flag = true;
						}
					}

					for (String handle : allHandles) 
					{
						if (!handle.equals(pHandle)) 
						{
							driver.switchTo().window(handle);
						}
					}

					if (result == true)
					{
						rpt.generateReport("OTM_LAS005", "Click " + link, "", link, "Edit Shipment Quantities window must be opened",
								"Delete Remaining Order Quantity window opened", "Passed", "", true);
					}
					else 
					{
						rpt.generateReport("OTM_LAS005", "Click " + link, "", link, "Edit Shipment Quantities window must be opened",
								"Edit Shipment Quantities window not opened", "Failed", "", true);
						Assert.fail("Edit Shipment Quantities window must be opened");
					}

					//**Edit Shipment Quantities**
					cmnLib.switchToFrame("mainBody", FrameSelectBy.StringFrameName);
					
					Thread.sleep(1000);
										
					EditShipmentQuantity editShipmentQuantity = PageFactory.initElements(driver,EditShipmentQuantity.class);
					
					//Select the Edit By options
					if (editShipmentQuantity.selectEditOptions()==true)
					{
						rpt.generateReport("OTM_LAS005", "Select the Edit by options as Ship unit and Weight/Volume Type", "", "",
								"Edit by options must be set to Ship unit and Weight/Volume Type", 
								"Selected the Edit by options as Ship unit and Weight/Volume Type", "Passed", "", true);
					} 
					else {
						rpt.generateReport("OTM_LAS005", "Select the Edit by options as Ship unit and Weight/Volume Type", "", "",
								"Edit by options must be set to Ship unit and Weight/Volume Type", 
								"Failed to select the Edit by options as Ship unit and Weight/Volume Type", "Failed", "", true);
						
						Assert.fail("Failed to click Submit button");
					}
					
					//Click on the Submit Button
					if (cmnLib.clickByJSE(editShipmentQuantity.submitBuySQButton)==true)
					{
						rpt.generateReport("OTM_LAS005", "Click on Submit button in Buy Shipment Quantities window", "", "",
								"Submit button must be clicked", "Clicked on Submit button", "Passed", "", true);
					} 
					else 
					{
						rpt.generateReport("OTM_LAS005", "Click on Submit button in Buy Shipment Quantities window", "", "",
								"Submit button must clicked", "Failed to click Submit button", "Failed", "", true);
						Assert.fail("Failed to click Submit button");
					}

					Thread.sleep(1000);

					cmnLib.switchToFrame("mainBody", FrameSelectBy.StringFrameName);
					
						
					//Get value of Weight and replace with new value
					
					String getCurrentWeight = editShipmentQuantity.shipmentWeight.getText();
					
					System.out.println("The current weight is "+getCurrentWeight);
					String strCurrentWeight = (exl.read(sheetName, dataRow,"Current_Weight"));
					String strNewWeight = exl.read(sheetName, dataRow,"New_Weight");
					
					/*if(getCurrentWeight.equalsIgnoreCase(strCurrentWeight))
					{	
						System.out.println("weights match");
					}
					else
					{
						System.out.println("weights dont match");

						rpt.generateReport("OTM_LAS005", "Ship Unit with said Weight Quantity isn't available", "", "",
								"Ship Unit Weight Quantity needs to be found", "Ship Unit with said Weight Quantity isn't available", "Failed", "", true);
						Assert.fail("Failed to find said weight");
					}*/
					
					cmnLib.clickOnWebElement(editShipmentQuantity.shipmentWeight);
					editShipmentQuantity.shipmentWeight.clear();	
					
					if(cmnLib.enterDataInTextBox(editShipmentQuantity.shipmentWeight, strNewWeight, false) == true)
					{
						rpt.generateReport("OTM_LAS005", "Ship Unit Weight Quantity has been Changed", "", "",
							"Ship Unit Weight Quantity needs to be Changed", "Ship Unit Weight Quantity has been Changed", "Passed", "", true);
					}
					else 
					{
						rpt.generateReport("OTM_LAS005", "Ship Unit Weight Quantity has been Changed", "", "",
								"Ship Unit Weight Quantity needs to be Changed", "Ship Unit Weight Quantity hasnt been Changed", "Failed", "", true);
						Assert.fail("Failed to Change Ship unit weight");
					}
						
					Thread.sleep(500);
					//Click Finished button
					
					//editShipmentQuantity.finishedButton.click();
					if (cmnLib.clickByJSE(editShipmentQuantity.finishedButton) == true) 
					{

						rpt.generateReport("OTM_LAS005", "Click on Finished Button in Buy Shipment Quantity window", "", "",
								"Finished button must be clicked", "Clicked on Finished Button in Buy Shipment Quantity window", "Passed", "", true);
					} 
					else 
					{
						rpt.generateReport("OTM_LAS005", "Click on Finished Button in Buy Shipment Quantity window", "", "",
								"Finished button must clicked", "Failed to click Finished button", "Failed", "", true);
						Assert.fail("Failed to click Finished button");
					}
					
					Thread.sleep(1000);
					
					//Validate the success
					if (cmnLib.waitForTextToBePresentInElement(editShipmentQuantity.successStmt) == true
							&& editShipmentQuantity.successStmt.getText().length() != 0) 
					{	
						if (editShipmentQuantity.successStmt.getText().matches("You successfully modified the following records:")) 
						{
							rpt.generateReport("OTM_LAS005","Ship Unit Quantity has been successfully updated", "",
									"", "Ship Unit Quantity must be updated", "Ship Unit Quantity has been updated", "Passed", "", true);
						}
						else
						{
							rpt.generateReport("OTM_LAS005","Verify if Ship Unit Qty has been updated", "", "",
									"Ship Unit Quantity must be updated", "Ship Unit Quantity has not been updated", "Failed", "", true);
							Assert.fail("Ship Unit Quantity not updated");
					}
						Thread.sleep(1000);
				    }
		}
	}
}

