package finance.pagefactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.Common_Library.DropDownSelectBy;
import com.commons.TestBase;

public class CreateReceipt extends TestBase{
	
	@FindBy (xpath = "//h1[contains(text(),'Create Receipt')]")
	public WebElement CreateReceipt_Header;
	
	@FindBy(xpath = "//div[contains(@id,'cb6')]")
	public WebElement Cancel;

	@FindBy(xpath = "//select[contains(@id, 'receiptType')]")
	public WebElement Receipt_Type;
	
	@FindBy(xpath = "//input[contains(@id, 'businessUnitId')]")
	public WebElement Business_Unit;
	
	@FindBy(xpath = "//a[@title='Search: Receipt Method']")
	public WebElement Search_Receipt_Method;
	
	@FindBy(xpath = "//span[contains(@id, 'inputText12::content')]")
	public WebElement RemittanceBankCurrency;
	
	@FindBy(xpath = "//div[contains(@id, 'receiptMethodId::dropdownPopup::dropDownContent::db')]/table/tbody/tr")
	public List <WebElement> Search_Receipt_Method_Rows;
	
	@FindBy(xpath = "//input[contains(@id, 'receiptNumberId')]")
	public WebElement Receipt_Number;
	
	@FindBy(xpath = "//select[contains(@id, 'currencyCode4Id')]")
	public WebElement Currency;
	
	@FindBy(xpath = "//input[contains(@id, 'amountId')]")
	public WebElement Amount;
	
	@FindBy(xpath = "//textarea[contains(@id, 'inputText5::content')]")
	public WebElement Comments;
	
	@FindBy(xpath = "//a[contains(@id, 'commandButton2::popEl')]")
	public WebElement SubmitButton_Link;
	
	@FindBy(xpath = "//table[contains(@id, 'ScrollContent')]//tr")
	public List <WebElement> SubmitButton_List;
	
	@FindBy(xpath = "//div[contains(@class, 'p_AFInfo')]")
	public WebElement InfoDialog;
	
	@FindBy(xpath = "//div[contains(@class, 'p_AFInfo')]//button")
	public WebElement InfoDialogOKButton;
	
	public CreateReceipt() {
		PageFactory.initElements(driver, this);
		log.info("CreateReceipt initiated...");
	}
	
	public boolean selectReceiptType(String strReceiptType) {
		return cmnLib.selectDropdownBy(Receipt_Type, strReceiptType, DropDownSelectBy.VisibleText) ? true : false;
	}
	
	public boolean enterBusinessUnit(String strBusinessUnit) {
		return cmnLib.enterDataInTextBox(Business_Unit, strBusinessUnit, true) ? true : false;
	}
	
	public boolean enterReceiptMethod(String strReceiptMehtod, String BankAccName) throws InterruptedException {
		try {
			strReceiptMehtod = strReceiptMehtod.toLowerCase();
			BankAccName = BankAccName.toLowerCase();
			if(!cmnLib.clickOnWebElement(Search_Receipt_Method)) {
				log.info("Could not click on Search Receipt Method link");
				return false;
			}
			TimeUnit.SECONDS.sleep(2);
			if(Search_Receipt_Method_Rows.size() > 0) {
				for (int i = 0; i < Search_Receipt_Method_Rows.size(); i++) {
					String rowText = Search_Receipt_Method_Rows.get(i).getText().toLowerCase();
//					String rowText = eachRow.getText().toLowerCase();
					if(rowText.contains(strReceiptMehtod) && rowText.contains(BankAccName)) {
						
						if(cmnLib.clickOnWebElement(Search_Receipt_Method_Rows.get(i).findElements(By.tagName("td")).get(0))) {
							cmnLib.waitForPageLoaded();
							log.info("Receipt Method is selected");
							return true;
						}
						break;
						
					}
				}
				/*for (WebElement eachRow : Search_Receipt_Method_Rows) {
					String rowText = eachRow.getText().toLowerCase();
					if(rowText.contains(strReceiptMehtod) && rowText.contains(BankAccName)) {
						
						if(cmnLib.clickOnWebElement(eachRow)) {
							cmnLib.waitForPageLoaded();
							log.info("Receipt Method is selected");
							return true;
						}
						break;
						
					}
				}*/
			}else {
				log.info("Search Method List does not exist");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Exception: enterReceiptMethod");
		}
		return false;
	}
	
	public boolean verifyRemittanceBankCurrency() {
		return cmnLib.waitForTextToBePresentInElement(RemittanceBankCurrency) ? true : false;
	}
	public String enterReceiptNumber() throws Throwable {
		String receiptNum = cmnLib.randomNumber("Receipt_");
		return cmnLib.enterDataInTextBox(Receipt_Number, receiptNum, true) ? receiptNum : null;
	}
	
	public boolean selectCurrency(String strCurrency) {
		return cmnLib.selectDropdownBy(Currency, strCurrency, DropDownSelectBy.VisibleText) ? true : false;
	}
	
	public boolean enterAmount(String strAmount) throws Throwable {
		return cmnLib.enterDataInTextBox(Amount, strAmount, true) ? true : false;
	}
	
	public boolean enterComments(String strComments) throws Throwable {
		return strComments.length() > 0 ? (cmnLib.enterDataInTextBox(Comments, strComments, true) ? true : false) : true;
//		return cmnLib.enterDataInTextBox(Amount, strComments, true) ? true : false;
	}
	
	public boolean submitButton(String strSubmitValue) {
		strSubmitValue = strSubmitValue.toLowerCase();
		try {
			if(!cmnLib.clickOnWebElement(SubmitButton_Link)) {
				log.info("Could not click on SubmitButton_Link");
				return false;
			}
			if(SubmitButton_List.size() > 0) {
				for (int i = 0; i < SubmitButton_List.size(); i++) {
					String textValue = SubmitButton_List.get(i).getText().toLowerCase();
					if(textValue.contains(strSubmitValue)) {
						if(cmnLib.clickOnWebElement(SubmitButton_List.get(i).findElements(By.tagName("td")).get(1))) {
							cmnLib.waitForPageLoaded();
							return true;
						}
					}
				}
				/*
				for (WebElement submitValueEle : SubmitButton_List) {
					String textValue = submitValueEle.getText().toLowerCase();
					if(textValue.contains(strSubmitValue)) {
						submitValueEle.click();
						cmnLib.waitForPageLoaded();
						return true;
					}
				}*/
			}else {
				log.info("Could not see any values under Submit Button");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Exception: submitButton");
		}
		
		return false;
	}
	
	public String getReceiptConfirmationMSG() {
		try {
			if(cmnLib.waitForElementToBeVisible(InfoDialog))
			{
				return InfoDialog.getText();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Exception: getReceiptConfirmationMSG");
		}
		return null;
	}
}
