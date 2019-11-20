package hcm.pagefactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.commons.TestBase;

public class ManageEmployment extends TestBase{
	
	@FindBy (xpath = "//h1[contains(text(),'Assignment: ')]")
	public WebElement ExistingAssignment;
	
	@FindBy (id = "_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:0:AP1:edit")
	public WebElement Edit;
	
	@FindBy (xpath = "//table[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:0:AP1:menu1::ScrollContent']//tbody/tr/td[contains(text(), 'Update')]")
	public WebElement Edit_Update;
	
	@FindBy (xpath = "//table[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:0:AP1:menu1::ScrollContent']//tbody/tr/td[contains(text(), 'Correct')]")
	public WebElement Edit_Correct;
	
	@FindBy (xpath = "//table[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:0:AP1:menu1::ScrollContent']//tbody/tr/td[contains(text(), 'Delete')]")
	public WebElement Edit_Delete;
	
	@FindBy (xpath = "//div[contains(text(),'Update Employment')]")
	public WebElement VerifyUpdateEmployementPopup;

	@FindBy (xpath="//div[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:0:AP1:updatePopUp1::content']//input[1]")
	public WebElement EffectiveStartDate;
	
	@FindBy (xpath="//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:0:AP1:actionsName1::content']")
	public WebElement SelectAction;
	
	@FindBy (xpath="//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:0:AP1:actionsName1::content']")
	public WebElement SelectActionReason;
	
	@FindBy (xpath="//button[contains(.,'OK')]")
	public WebElement OKButton_InPopup;

	@FindBy (xpath="//span[contains(text(),'Review')]")
	public WebElement ReviewButton;
	
	@FindBy (xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:1:r:JobDe1:0:positionId::content']")
	public WebElement Position;
	
	@FindBy (xpath="//button[contains(.,'Yes')]")
	public WebElement YesButton_InPopup;
	
	
	@FindBy (xpath="//span[contains(., 'Submit')]")
	public WebElement SubmitButton;
	
	@FindBy(xpath = "//div[contains(@id, 'warningPopup::content')]")
	public WebElement WarningPopUp;
	
	@FindBy(xpath = "//td[contains(@id, 'warningDialog::contentContainer')]")
	public WebElement WarningPopUpContainerString;
	
	@FindBy(xpath = "//div[contains(@id, 'confirmationPopup::content')]")
	public WebElement ConfirmationDialogPopUp;
	
	@FindBy(xpath = "//div[contains(@id, 'confirmationPopup::content')]//button")
	public WebElement OKButton_InConfirmationPopUp;
	
	public ManageEmployment(WebDriver driver) {
		PageFactory.initElements(driver, this);
		log.info("ManageEmployment is Initialized...");
	}
	
	public boolean clickOnOKButtonInConfirmationPopup() {
		try {
			
			ConfirmationDialogPopUp.isDisplayed();
			OKButton_InConfirmationPopUp.click();
			log.info("Clicked on OK button in Confirmation Dialog Popup");
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Could not Click on OK button in Confirmation Dialog Popup");
			return false;
		}
		return true;
	}
	
	public String getWarningPopUpContainerString() {
		try {
			if(verifyIsWarningPopupExists() == true) {
				WarningPopUpContainerString.isEnabled();
				String strWarningPopUpContainerString = WarningPopUpContainerString.getText();
				log.info("Warning Pop Up Container String exists");
				return strWarningPopUpContainerString;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Warning Pop Up Container String does not exist");
		}
		return null;
	}
	public boolean verifyIsWarningPopupExists() {
		try {
			WarningPopUp.isEnabled();
			log.info("Warning popup exists");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Warning popup does not exist");
		}
		return false;
	}
	public String getExistingAssignment() {
		String strExistingAssignment = null;
		try {
			ExistingAssignment.isDisplayed();
			strExistingAssignment = ExistingAssignment.getText();
			strExistingAssignment = (strExistingAssignment.replaceAll("Assignment: ", "")).trim();
			log.info("Existing Assignment is captured: "+strExistingAssignment);
			
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Existing Assingment could not be captured");
		}
		return strExistingAssignment;
	}
	public void clickOnYesButtonInPopUp() {
		try {
			TimeUnit.SECONDS.sleep(5);
			YesButton_InPopup.isDisplayed();
			YesButton_InPopup.click();
			log.info("Yes button in Position Details Popup is clicked");
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Yes button in Position Details Popup is not clicked");
		}
	}
	public boolean enterInPosition(String strPosition) {
		try {
			Position.isDisplayed();
			Position.clear();
			Position.sendKeys(strPosition); //OPERARIO E ALMACEN DE INSUMOS PLANTA CALLAO
			Position.sendKeys(Keys.TAB);
			log.info("Position is entered");
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Position is not entered");
			return false;
		}
		return true;
	}
	public void clickOnReviewButton() {
		
		try {
			TimeUnit.SECONDS.sleep(5);
			ReviewButton.isDisplayed();
			ReviewButton.click();
			log.info("Review Button is Clicked");
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Review Button is not Clicked");
		}
	}
	public void clickOnOKButtoninPopup() {
		try {
			OKButton_InPopup.isDisplayed();
			OKButton_InPopup.click();
			log.info("OK button in Update Employment Popup is clicked");
		} catch (Exception e) {
			// TODO: handle exception
			log.info("OK button in Update Employment Popup is Not clicked");
		}
	}
	private void clickOnEdit() {
		Edit.click();
		log.info("Clicked on Edit button");
	}
	public void clickOnEditnUpdate() {
		try {
			clickOnEdit();
			Edit_Update.click();
			log.info("Clicked on Update under Edit");
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Could not Click on Update under Edit");
		}
		
	}
	
	public void clickOnEditnCorrect() {
		try {
			clickOnEdit();
			Edit_Correct.click();
			log.info("Clicked on Correct under Edit");
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Could not Click on Correct under Edit");
		}
	}
	
	public void clickOnEditnDelete() {
		try {
			clickOnEdit();
			Edit_Delete.click();
			log.info("Clicked on Delete under Edit");
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Could not Click on Delete under Edit");
		}
	}
	
	/**
	 * @author ampn(Amit PN)
	 * @param strEffectiveStartDate: Effective Start Date in DD/MMM/YYYY format. If Value is not passed/null then today's date will be taken
	 * @param strAction: Action Value
	 * @param strActionReason: Optional Parameter(Action Reason value)
	 * @return boolean
	 */
	public boolean enterInUpdateEmploymentPopUp(String strEffectiveStartDate, String strAction, String strActionReason) {
		try {
			VerifyUpdateEmployementPopup.isDisplayed();
			log.info("Update Employment Popup is displayed");
			
			//Enter EffectiveStartDate
			if(strEffectiveStartDate == null || strEffectiveStartDate.isEmpty()) {
				log.info("Start Effective Date will be Today's Date");
			}else {
				EffectiveStartDate.sendKeys(strEffectiveStartDate);
				log.info("Effective Start date is entered");
			}

			//Select Action  (Assignment Change)
			
			new Select(SelectAction).selectByVisibleText(strAction);
			log.info("Action is selected");
			
			//Select Action Reason
			if(strActionReason!=null && !strActionReason.isEmpty()) {
				new Select(SelectActionReason).selectByVisibleText(strActionReason);
				log.info("Action Reason is selected");
			}else
			{
				log.info("Action Reason parameter is null/empty");
			}
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			log.info("method: enterInUpdateEmploymentPopUp could not be executed due to exception");
		}
		
		return false;
	}
	
	public void clickOnSubmitButton() {
		try {
			SubmitButton.isDisplayed();
			SubmitButton.click();
			log.info("Submit Button is clicked");
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Submit Button is not clicked");
		}
	}
	/*public boolean verifyActionSelectedPage(String strAction) {
		try {
			driver.findElement(By.xpath("//h1[contains(text(),'"+strAction+"')]")).isDisplayed();
			log.info("Action: "+strAction+" Selected Page exists");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Action: "+strAction+" Selected Page does not exist");
		}
		return false;
	}*/
	
}
