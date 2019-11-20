package hcm.pagefactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.commons.TestBase;

public class PersonalInformation extends TestBase  {
	
	@FindBy(xpath="//h1[text()='My Details']")
	public WebElement PersonalInformationHeader;
	
	@FindBy(xpath="//button[text()='Edit']")
	public WebElement EditButton;
	
	@FindBy(xpath="//img[contains(@id,'cb1::icon')]")
	public WebElement AddAddressIcon;
	
	@FindBy(xpath="//span[text()='ave and Close']")
	public WebElement SaveAndCloseButton;
	
	@FindBy(xpath="//li[text()='Home Address']")
	public WebElement AddressType_Value;
	
	//label[text()='Type']/parent::td/parent::tr//a[contains(@id,'drop')]
	
	@FindBy(xpath="//label[text()='Effective Start Date']/parent::td/parent::tr//input")
	public WebElement EffectiveStartDate;
	
	@FindBy(xpath="//label[text()='Country']/parent::td/parent::tr//input")
	public WebElement Country;
	
	@FindBy(xpath="//label[text()='Address line 1']/parent::td/parent::tr//input")
	public WebElement AddressLine1;
	
	@FindBy(xpath="//label[text()='Address line 2']/parent::td/parent::tr//input")
	public WebElement AddressLine2;
	
	@FindBy(xpath="//label[text()='Postal Code']/parent::td/parent::tr//input")
	public WebElement PostalCode;
	
	@FindBy(xpath="//label[text()='Region']/parent::td/parent::tr//input")
	public WebElement Region;
	
	@FindBy(xpath="//label[text()='Provincia']/parent::td/parent::tr//input")
	public WebElement Provincia;
	
	@FindBy(xpath="//label[text()='Komune']/parent::td/parent::tr//input")
	public WebElement Komune;
	
	@FindBy(xpath="//div[text()='Contact Info']")
	public WebElement ContactsInformation;
	
	@FindBy(xpath="//img[contains(@id,':cil1::icon') and @title='Edit']")
	public WebElement AddressEdit;
	
	@FindBy(xpath="//label[text()='Address Line 1']/parent::td/parent::tr//input")
	public WebElement AddressLine1_Contacts;
	
	@FindBy(xpath="//label[text()='Address Line 2']/parent::td/parent::tr//input")
	public WebElement AddressLine2_Contacts;
	
	@FindBy(xpath="//label[text()='Postal Code']/parent::td/parent::tr//input")
	public WebElement PostalCode_Contacts;
	
	@FindBy(xpath="//label[text()='Region']/parent::td/parent::tr//input")
	public WebElement Region_Contacts;
	
	@FindBy(xpath="//label[text()='Provincia']/parent::td/parent::tr//input")
	public WebElement Provincia_Contacts;
	
	@FindBy(xpath="//label[text()='Komune']/parent::td/parent::tr//input")
	public WebElement Komune_Contacts;
	
	@FindBy(xpath="//a[contains(@id,'popEl')]")
	public WebElement CreateContactDrop;
	
	@FindBy(xpath="//td[text()='Phone']")
	public WebElement SelectPhone;
	
	@FindBy(xpath="//div[contains(@id,'0:pgl10')]/div[1]/table[1]/tbody/tr/td[2]//a")
	public WebElement ContactType;
	
	@FindBy(xpath="//div[contains(@id,'0:pgl10')]/div[1]/table[1]/tbody/tr/td[3]/table/tbody/tr/td[1]/span/span/input")
	public WebElement CountryCode;
	
	@FindBy(xpath="//input[contains(@id,'it6::content')]")
	public WebElement PhoneNumInput;
	
	/*Xpath in dev4
	 * @FindBy(xpath="//img[contains(@id,'0:cb6::icon')]")
	public WebElement DeletePhoneRow1;*/
	
	//Xpath in dev6
	@FindBy(xpath="//img[contains(@id,'0:cb6::icon')]")
	public WebElement DeletePhoneRow1;
	
	@FindBy(xpath="//td[text()='Email']")
	public WebElement SelectEmail;
	
	@FindBy(xpath="//div[contains(@id,'0:pgl5')]/div[1]/table[1]/tbody/tr/td[2]//a")
	public WebElement EmailType;
	
	@FindBy(xpath="//div[contains(@id,'0:pgl5')]/div[1]/table[1]/tbody/tr/td[3]//input")
	public WebElement EmailInput;
	
	@FindBy(xpath="//img[contains(@id,'0:cb6b::icon')]")
	public WebElement DeleteEmail_PI;
	
	@FindBy(xpath="//div[text()='Contacts']")
	public WebElement ContactsTab;
	
	@FindBy(xpath="//table[contains(@summary,'data body table below')]//img[@title='Add']")
	public WebElement AddContactsIcon;
	
	@FindBy(xpath="//div[text()='Add Contact']")
	public WebElement AddContactPopWindow;
	
	@FindBy(xpath="//label[text()='Add a new person']")
	public WebElement AddnewpersonRadioBtn;
	
	@FindBy(xpath="//button[text()='Contin']")
	public WebElement AddContactContinueBtn;
	
	@FindBy(xpath="//label[text()='Relationship']/parent::td/parent::tr//input[contains(@aria-owns,'pop')]")
	public WebElement Relationship;
	
	@FindBy(xpath="//label[text()='Relationship Start Date']/parent::td/parent::tr//input")
	public WebElement RelationshipStartDate;
	
	@FindBy(xpath="//label[text()='Update Date']/parent::td/parent::tr//input")
	public WebElement UpdateDate;
	
	@FindBy(xpath="//label[text()='Emergency Contact']/parent::td/parent::tr//label[contains(@id,'Label1')]")
	public WebElement EmergencyContact;
	
	@FindBy(xpath="//label[text()='Paternal Last Name']/parent::td/parent::tr//input")
	public WebElement PaternalLastName;
	
	@FindBy(xpath="//label[text()='First Name']/parent::td/parent::tr//input")
	public WebElement FirstName;
	
	@FindBy(xpath="//span[text()='Phone Numbers']//parent::td/parent::tr/td[3]/a[@title='Add']")
	public WebElement AddPhoneNum;
	
	@FindBy(xpath="//a[contains(@id,'soc4::drop')]")
	public WebElement PhoneNumTypeDrop;
	
	@FindBy(xpath="//li[text()='Home Phone']")
	public WebElement PhoneType_HomePhone;
	
	@FindBy(xpath="//input[contains(@id,'countryId::content')]")
	public WebElement PhoneNumCountry;
	
	@FindBy(xpath="//input[contains(@id,'t7::content')]")
	public WebElement PhoneAreaCode;
	
	@FindBy(xpath="//input[contains(@id,'t6::content')]")
	public WebElement PhoneNumberInput;
	
	@FindBy(xpath="//span[text()='Address']/ancestor::tr/td[3]/a")
	public WebElement AddressAddIcon;
	
	@FindBy(xpath="//label[text()='Country']/parent::td/parent::tr//input")
	public WebElement AddressCountry;
	
	@FindBy(xpath="//label[text()='Address Line 1']/parent::td/parent::tr//input")
	public WebElement ContactAddressLine1;
	
	@FindBy(xpath="//label[text()='Address Line 2']/parent::td/parent::tr//input")
	public WebElement ContactAddressLine2;
	
	@FindBy(xpath="//label[text()='Address Line 3']/parent::td/parent::tr//input")
	public WebElement ContactAddressLine3;
	
	@FindBy(xpath="//label[text()='City or Town']/parent::td/parent::tr//input")
	public WebElement ContactCity;
	
	@FindBy(xpath="//label[text()='Pin Code']/parent::td/parent::tr//input")
	public WebElement ContactPinCode;
	
	@FindBy(xpath="//label[text()='State']/parent::td/parent::tr//input")
	public WebElement ContactState;
	
	@FindBy(xpath="//span[text()='ave and Close']")
	public WebElement SaveAndCloseBtn;
	
	@FindBy(xpath="//img[@title='Edit']")
	public WebElement EditContactICon;
	
	@FindBy(xpath="")
	public WebElement abc5;
	
	@FindBy(xpath="")
	public WebElement abc6;
	
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
	
	public boolean selectDropdownValue(String strValue) {
		  WebElement ele = null;
		  try {
		   ele = driver.findElement(By.xpath("//li[text()='"+strValue+"']"));
		  } catch (Exception e) {
		   // TODO: handle exception
		   e.printStackTrace();
		   log.info("could not find the dropdown value webelement");
		   return false;
		  }
		  
		  if(cmnLib.clickOnWebElement(ele)) {
		   log.info("DropwDown value: "+strValue+" selected");
		   return true;
		  }else {
		   log.info("Could not select the DropwDown value: "+strValue);
		   return false;
		  }
		 }
	
	public boolean selectOptionFromComboBox(String strLabelName, String strOptionValue) {
        boolean returnStatus = false;

        try {
               cmnLib.waitForPageLoaded();
               if (cmnLib
                            .clickOnWebElement(driver.findElement(By
                                          .xpath("//label[text()='" + strLabelName + "']//parent::td//parent::tr//td[2]/span/a")))
                            && cmnLib.waitForElementToBeVisible(
                                          driver.findElement(By.xpath("//td/ul[contains(@id,'::pop')]")))) {
                     List<WebElement> ListOptions = driver.findElements(By.xpath("//td/ul[contains(@id,'::pop')]//li"));
                     for (WebElement option : ListOptions) {
                            if (option.getText().equalsIgnoreCase(strOptionValue)) {
                                   option.click();
                                   returnStatus = true;
                                   log.info("Selected option from " + strLabelName);
                                   break;
                            }
                     }
               } else {
                     log.info("List Menu not visible for " + strLabelName + "  Combobox");
               }

        } catch (

        Exception e) {
               // TODO: handle exception
               e.printStackTrace();
               log.info("Unable to select option from " + strLabelName + " Combobox");
        }
        return returnStatus;
 }

 public boolean selectOptionFromComboBoxInsideTable(WebElement comboBoxArrow, String strOptionValue) {
        boolean returnStatus = false;

        try {
               if (cmnLib.clickOnWebElement(comboBoxArrow) && cmnLib
                            .waitForElementToBeVisible(driver.findElement(By.xpath("//td/ul[contains(@id,'::pop')]")))) {
                     List<WebElement> ListOptions = driver.findElements(By.xpath("//td/ul[contains(@id,'::pop')]//li"));
                     for (WebElement option : ListOptions) {
                            if (option.getText().equalsIgnoreCase(strOptionValue)) {
                                   option.click();
                                   returnStatus = true;
                                   log.info("Selected Option");
                                   break;
                            }
                     }
                     log.info("Expected option not found");
               } else {
                     log.info("List Menu not visible");
               }

        } catch (

        Exception e) {
               // TODO: handle exception
               e.printStackTrace();
               log.info("Unable to select option from Combobox");
        }
        return returnStatus;
 }

	
	

}
