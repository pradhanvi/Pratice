package hcm.pagefactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ManageContact extends TestBase {
	
	@FindBy(xpath="//div[contains(@id,':showDetailItem2::ti')]//a[text()='Contacts']")
	public WebElement ContactsTab;
	
	@FindBy(xpath="//*[contains(@id,':createLink::icon')]")
	public WebElement CreateContactIcon;
	
	@FindBy(xpath="//label[text()='Effective Start Date']/parent::td/parent::tr//input")
	public WebElement ContactEffectiveDate;
	
	@FindBy(xpath="//label[text()='Paternal Last Name']/parent::td/parent::tr//input")
	public WebElement ContactPaternalName;
	
	@FindBy(xpath="//label[text()='First Name']/parent::td/parent::tr//input")
	public WebElement ContactFirstName;
	
	@FindBy(xpath="//label[text()='Date of Birth']/parent::td/parent::tr//input")
	public WebElement ContactDOB;
	
	@FindBy(xpath="//a//img[contains(@id,'create::icon')]")
	public WebElement CreatePhoneIcon;
	
	@FindBy(xpath="//a[contains(@id,'soc1::drop')]")
	public WebElement TypeDrop;
	
	@FindBy(xpath="//li[text()='Home Phone']")
	public WebElement HomePhoneType;
	
	@FindBy(xpath="//input[contains(@id,'t1::content')]")
	public WebElement ContactPhoneNumber;
	
	@FindBy(xpath="//label[contains(@for,'i4:0:sbr1::content')]")
	public WebElement ContactAddRadioButton;
	
	@FindBy(xpath="//button[text()='O']")
	public WebElement CreateContactOKButton;
	
	@FindBy(xpath="//span[text()='Sub']")
	public WebElement SubmitButton;
	
	@FindBy(xpath="//td[contains(@id,'warningDialog::_fcc')]//button[text()='es']")
	public WebElement Yes_Warning;
	
	@FindBy(xpath="//div[text()='Confirmation']")
	public WebElement Confirmation_PopUp;
	
	@FindBy(xpath="//td[contains(@id,'confirmationDialog::_fcc')]//button[text()='O']")
	public WebElement Ok_Confirmation;
	
	@FindBy(xpath="//div[contains(@id,'warningDialog::_ttxt')]")
	public WebElement Warning_Popup;
	
	
	
	@FindBy(xpath="//a[contains(@id,'0:editDropDown::popEl')and (@title='Edit')]")
	public WebElement Name_Edit;
	
	@FindBy(xpath="//table[contains(@id,'updateMenu::ScrollContent')]//td[text()='Update']")
	public WebElement Update_Name;
	
	@FindBy(xpath="//td[contains(@id,'d1::_fce')]//button[text()='O']")
	public WebElement OK_EffectiveDate;
	
	@FindBy(xpath="//button[contains(@id,'okBtn') and text()='O']")
	public WebElement UpdateName_OK;
	
	@FindBy(xpath="//a[contains(@id,'editAddressDropDown::popEl') and @title='Edit']")
	public WebElement Address_Edit;
	
	@FindBy(xpath="//table[contains(@id,'updateMenu1::ScrollContent')]//td[text()='Update']")
	public WebElement Address_Update;
	
	@FindBy(xpath="//label[text()='Effective Start Date']/parent::td/parent::tr//input[contains(@id,'id7::content')]")
	public WebElement Address_EffectiveDate;
	
	@FindBy(xpath="//td[contains(@id,'d3::_fce')]//button[text()='O']")
	public WebElement Address_EffectiveDate_OK;
	
	@FindBy(xpath="//input[contains(@aria-owns,'0:soc7::pop')]//parent::span/a")
	public WebElement UpdateAddress_Type;
	
	@FindBy(xpath="//label[text()='Address line 1']/parent::td/parent::tr//input")
	public WebElement UpdateAddress_Line1;
	
	@FindBy(xpath="//td[contains(@id,'d4::_fcc')]//button[text()='O']")
	public WebElement UpdateAddress_OK;
	
	@FindBy(xpath="//td[contains(@id,'manageContactDialog::_fcc')]//button[text()='O']")
	public WebElement EditContact_OK;
	
	@FindBy(xpath="//span[text()='Delete']")
	public WebElement DeleteContact;
	
	@FindBy(xpath="//div[text()='Delete Confirmation']")
	public WebElement DeleteConfirmationPopUp;
	
	@FindBy(xpath="//button[text()='Yes']")
	public WebElement DeleteConfirmationPopUp_Yes;
	
	@FindBy(xpath="")
	public WebElement abc2;
	
	@FindBy(xpath="")
	public WebElement abc3;
	
	@FindBy(xpath="")
	public WebElement abc4;
	
	@FindBy(xpath="")
	public WebElement abc5;
	
	@FindBy(xpath="")
	public WebElement abc6;
	
	
	
	public ManageContact() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean selectValueFromInputComboBox(String inputElementLabelName, String strValueToSelect) {
		  boolean result = false;
		  try {
		   driver.findElement(By.xpath("//tr/td/label[contains(text(),'" + inputElementLabelName + "')]/../parent::tr//a")).click();
		   TimeUnit.SECONDS.sleep(1);
		   driver.findElement(By.xpath("//li[text()='" + strValueToSelect + "']")).click();
		   TimeUnit.SECONDS.sleep(1);
		   result = true;
		   log.info("Selected the Value from the input combobox");
		  } catch (Exception e) {
		   // TODO: handle exception
		   e.printStackTrace();
		   log.info("Exception in selectValueFromInputComboBox");
		  }
		  return result;

		 }
	public boolean ClickOnSearchedResults(String strPersonName_OR_PersonNumber) {
		boolean exists = false;
		try {
			List<WebElement> TableRows = driver.findElements(By.xpath("//table[contains(@summary,'Personal Relationships')]/tbody/tr"));
			System.out.println("No Of Rows in Search Results Table: "+TableRows.size());
			if(TableRows.size() > 0) {
				for (int i = 1; i <= TableRows.size(); i++) {
					
					WebElement element = driver.findElement(By.xpath("//table[contains(@summary,'Personal Relationships')]/tbody/tr["+i+"]//td[2]/div/table/tbody/tr/td[1]"));
					System.out.println(element.getText());
					if(element.getText().equalsIgnoreCase(strPersonName_OR_PersonNumber)) {
						driver.findElement(By.xpath("//table[contains(@summary,'Personal Relationships')]/tbody/tr["+i+"]//td[2]/div/table/tbody/tr/td[1]")).click();
						exists = true;
						log.info("Searched Person Number record exists");
					}
					/*if(driver.findElement(By.xpath("//table[@summary='Contacts']/tbody/tr["+i+"]//*[contains(text(),'"+strPersonName_OR_PersonNumber+"')]")).isDisplayed()) {
						exists = true;
						log.info("Searched Person Number record exists");
						}*/
					}
				}else {
					log.info("TableRows row count is less than zero !!");
				}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Searched Person Number record does not exist");
			e.printStackTrace();
		}
		return exists;
	}
}
