package hcm.pagefactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ManagePerson extends TestBase {
	@FindBy(xpath="//div[contains(@id,'::ti')]//a[contains(@id,':showDetailItem1::disAcr')]")
	//@FindBy(id="_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:SP1:showDetailItem1::disAcr")
	public WebElement PersonInformationTab;
	
	
	/*@FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='…'])[4]/following::span[1]")
	public WebElement NameEditDropdown;*/
	
	@FindBy(xpath="//div[contains(@id,':Manag1:0:editDropDown')]//span[contains(text(),'Edit')]")
	public WebElement NameEditDropdown;
	
	@FindBy(xpath="//label[text()='Effective Start Date']/parent::td/parent::tr//input")
	public WebElement EffectiveStartDate;
	
	@FindBy(xpath="//img[contains(@id,'commandButton1::icon')]")
	public WebElement EditNationalIDentifier;
	
	@FindBy(xpath="//a[contains(@id,'selectOneChoice3::drop')]")
	public WebElement NationalIDDrop;
	
	@FindBy(xpath="//li[text()='National Identifier']")
	public WebElement NationalIDType;
	/*@FindBy(id="_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:SP1:region1:0:Manag1:0:cb2")
	public WebElement UpdateNameOkButton;*/
	
	@FindBy(id="_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:SP1:region1:0:Manag1:0:region1:0:i1:0:it20::content")
	public WebElement GlobalParentalLastName;
	
	@FindBy(xpath="//label[text()='Enter local name']")
	public WebElement LocalNameCheckBox;
	
	@FindBy(xpath="//label[text()='Paternal Last Name']/parent::td/parent::tr//input")
	public WebElement PaternalLastName;
	
	@FindBy(xpath="//label[text()='First Name']/parent::td/parent::tr//input")
	public WebElement FirstName;
	
	@FindBy(xpath="//label[text()='Local-Name Language']/parent::td/parent::tr//a")
	public WebElement LocalNameLangDrop;
	
	@FindBy(xpath="//input[contains(@id,':i2:0:it91::content')]")
	public WebElement PaternalLastNameLocal;
	
	@FindBy(xpath="//button[contains(@id,'region1:0:Manag1:0:commandButton1')]")
	public WebElement UpdateNameOKButton;
	
	@FindBy(xpath="//button[contains(@id,'okBtn')]")
	public WebElement CorrectNameOKButton;
	
	@FindBy(xpath="//span[text()='Sub']")
	public WebElement SubmitButton;
	
	@FindBy(xpath="//td[contains(@id,'warningDialog::_fcc')]//button[text()='es']")
	public WebElement Yes_Warning;
	
	@FindBy(xpath="//div[text()='Confirmation']")
	public WebElement Confirmation_PopUp;
	
	@FindBy(xpath="//button[text()='O']")
	public WebElement Ok_Confirmation;
	
	@FindBy(xpath="//div[contains(@id,'warningDialog::_ttxt')]")
	public WebElement Warning_Popup;
	
	@FindBy(xpath="//button[contains(@id,'DeleteDialogOkBtn')]")
	public WebElement DeleteDialogYesButton;
	
	@FindBy(xpath="//td[contains(@id,'warningDialog::_fcc')]//button[text()='es']")
	public WebElement DeleteSubmitYesButton;
	
	@FindBy(xpath="//img[contains(@id,'newBtn::icon')]")
	public WebElement Create_Address;
	
	@FindBy(xpath="//label[text()='Effective Start Date']/parent::td/parent::tr//input")
	public WebElement EffectiveStartDate_Address;
	
	@FindBy(xpath="//label[text()='Type']/parent::td/parent::tr//a")
	public WebElement Type_AddressDrop;
	
	@FindBy(xpath="//label[text()='Country']/parent::td/parent::tr//input")
	public WebElement Country_Address;
	
	@FindBy(xpath="//label[text()='Address Line 1']/parent::td/parent::tr//input")
	public WebElement AddressLine1;
	
	@FindBy(xpath="//label[text()='Address Line 2']/parent::td/parent::tr//input")
	public WebElement AddressLine2;
	
	@FindBy(xpath="//label[text()='Postal Code']/parent::td/parent::tr//input")
	public WebElement PostalCode;
	
	@FindBy(xpath="//label[text()='Region']/parent::td/parent::tr//input")
	public WebElement Region;
	
	@FindBy(xpath="//label[text()='Provincia']/parent::td/parent::tr//input")
	public WebElement Provinica;
	
	@FindBy(xpath="//label[text()='Komune']/parent::td/parent::tr//input")
	public WebElement Komune;
	
	@FindBy(xpath="//*[contains(@id,'1:editAddressDropDown')]/table/tbody/tr/td[1]/a")
	public WebElement AddressEditDrop;
	
	@FindBy(xpath="//div[contains(@id,'region1:0:d2')]//span[text()='K']")
	public WebElement AddressOKButton;
	
	@FindBy(xpath="//label[text()='Effective End Date']/parent::td/parent::tr//input")
	public WebElement EffectiveEndDate;
	
	@FindBy(xpath="//td[contains(@id,'deleteConfirmDialog::_fcc')]//button[text()='Yes']")
	public WebElement DeleteConfirmationYes;
	
	@FindBy(xpath="//label[contains(@for,':sbc1::content')]/div")
	public WebElement DeleteConfirmationRadio;
	
	@FindBy(xpath="//td[contains(@id,'deleteConfirmDialog::_fce')]//button[text()='O']")
	public WebElement DeleteConfirmationOK;
	
	@FindBy(xpath="//td[contains(@id,'DeleteDialog::_fcc')]//button[text()='es']")
	public WebElement DeleteRecordConfirmationYes;
	
	@FindBy(xpath="//*[contains(@id,'0:editAddressDropDown')]/table/tbody/tr/td[1]/a")
	public WebElement AddressEditDropDeleRec;
	
	@FindBy(xpath="//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:SP1:region1:0:i1:0:editMailing']/table/tbody/tr/td[1]/a")
	public WebElement PrimaryAddressEditButton;
	
	@FindBy(xpath="//td[contains(@id,'region1:0:d3::_fcc')]//button[text()='O']")
	public WebElement PrimaryAddEffectiveDateOKButton;
	
	@FindBy(xpath="//a[contains(@id,'selectMailing::drop')]")
	public WebElement SelectPrimAddDrop;
	
	@FindBy(xpath="//ul[contains(@id,'selectMailing::pop')]//li[@_adfiv='0']")
	public WebElement SelectfirstPrimAdd;
	
	@FindBy(xpath="//td[contains(@id,'dialogMailing::_fcc')]//button[text()='O']")
	public WebElement PrimAddSelectOKButton;
	
	@FindBy(xpath="//*[contains(@id,'Manag5:0:editDropDown')]/table/tbody/tr/td[1]/a")
	public WebElement CommunicationEditDropButton;
	
	@FindBy(xpath="//img[contains(@id,':_ATp:create::icon')]")
	public WebElement AddEmailIcon;
	
	@FindBy(xpath="//a[contains(@id,'soc1::drop')]")
	public WebElement Email_TypeDrop;
	
	@FindBy(xpath="//input[contains(@id,'_ATp:table2:1:it2::content')]")
	public WebElement Email_input;
	
	@FindBy(xpath="//span[contains(@id,'panelGroupLayoutEmails')]//button[text()='O']")
	public WebElement Email_OK;
	
	@FindBy(xpath="//a[contains(@id,':1:selectOneChoice2Phone::drop')]")
	public WebElement Phone_TyprDrop;
	
	@FindBy(xpath="//input[contains(@id,':1:inputText3::content')]")
	public WebElement Phone_Num;
	
	@FindBy(xpath="//span[contains(@id,'panelGroupLayoutPhones')]//button[text()='O']")
	public WebElement Phone_OK;
	
	@FindBy(xpath="//li[text()='Home Email']")
	public WebElement EmailType;
	
	@FindBy(xpath="//ul[contains(@id,'table2:1:soc1::pop')]/li[text()='Home Email']")
	public WebElement UpdateEmailType;
	
	@FindBy(xpath="//*[contains(@id,'commandButton1::icon')]")
	public WebElement EditNationalIdentifier;
	
	@FindBy(xpath="//input[contains(@id,'0:inputText4')]")
	public WebElement NationalIDNumber;
	
	@FindBy(xpath="//td[contains(@id,'dialog::_fcc')]//button[text()='O']")
	public WebElement NationalIDOK;
	
	/*Xpath in dev4
	 * @FindBy(xpath="//button[text()='Edit']")
	public WebElement BiographicalInfoEdit;*/
	
	//Xpath in dev6
	@FindBy(xpath="//img[contains(@id,'0:cb1::icon')]")
	public WebElement BiographicalInfoEdit;
	
	@FindBy(xpath="//label[text()='Date of Birth']/parent::td/parent::tr//input")
	public WebElement DateOfBirth;
	
	@FindBy(xpath="//label[text()='Date of Death']/parent::td/parent::tr//input")
	public WebElement DateOfDeath;
	
	@FindBy(xpath="//label[text()='Country of Birth']/parent::td/parent::tr//input")
	public WebElement CountryOfBirth;
	
	@FindBy(xpath="//label[text()='Region of Birth']/parent::td/parent::tr//input")
	public WebElement RegionOfBirth;
	
	@FindBy(xpath="//label[text()='Town of Birth']/parent::td/parent::tr//input")
	public WebElement TownOfBirth;
	
	@FindBy(xpath="//td[contains(@id,'pt_r2:0:d1::_fcc')]//button[text()='O']")
	public WebElement BiographicalInfoOK;
	
	@FindBy(xpath="//button[text()='Add Country']")
	public WebElement AddCountryButton;
	
	@FindBy(xpath="//label[text()='Add Data for Country']/parent::td/parent::tr//input")
	public WebElement AddDataCountry;
	
	@FindBy(xpath="//td[contains(@id,'addCountry::_fcc')]//button[text()='O']")
	public WebElement AddCountryOK;
	
	@FindBy(xpath="//*[contains(@id,':1:editGender')]/table/tbody/tr/td[1]/a/span")
	public WebElement EditGenderMartialStatus;
	
	@FindBy(xpath="//button[contains(@id,'updateOkButton')]")
	public WebElement UpdateGenderEffectiveDateOKButton;
	
	@FindBy(xpath="//label[text()='Gender']/parent::td/parent::tr//input[@role='combobox']")
	public WebElement Gender;
	
	@FindBy(xpath="//label[text()='Marital Status']/parent::td/parent::tr//input[@role='combobox']")
	public WebElement MaritalStatus;
	
	@FindBy(xpath="//label[text()='Highest Education Level']/parent::td/parent::tr//input[@role='combobox']")
	public WebElement HighestEducationLevel;
	
	/*Xpath in dev4
	 * @FindBy(xpath="//button[contains(@id,'i5:1:commandButton2')]")
	public WebElement OKUpdateGender;*/
	
	//Xpath in dev6
	@FindBy(xpath="//button[contains(@id,'i5:1:commandButton2')]")
	public WebElement OKUpdateGender;
	
	@FindBy(xpath="//div[text()='Delete Confirmation']")
	public WebElement DeleteConfirmationPOPUp;
	
	@FindBy(xpath="//td[contains(@id,'deleteGenderDialog::_fcc')]//button[text()='O']")
	public WebElement DeleteConfirmationPOPUpOKButton;
	
	@FindBy(xpath="//div[contains(@id,'DeleteDialog::_ttxt')]")
	public WebElement DeletePopupMessage;
	
	@FindBy(xpath="//div[text()='Error']")
	public WebElement ErrorPopUpDelete;
	
	@FindBy(xpath="//td[contains(@id,'::msgDlg::_fcc')]//button")
	public WebElement ErrorPopUpDeleteOKButton;
	
	@FindBy(xpath="//button[contains(@id,'DeleteDialogOkBtn')]")
	public WebElement DeletePopupMessageYesButton;
	
	
	public ManagePerson() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickPersonInformationTab()
	{
		cmnLib.clickOnWebElement(PersonInformationTab);
//		PersonInformationTab.click();
		log.info("Clicked on Person Information Tab");
	}
	
	public void clickUpdateNameOkButton()
	{
		UpdateNameOKButton.click();
		log.info("CLicked on Update Name Ok button");
	}
	
	public void clickNameEditSelectUpdate()
	{
		if(cmnLib.clickOnWebElement(NameEditDropdown))
		{
			log.info("Clicked on Edit button");
		}else {
			log.info("Not clicked on Edit button");
		}
		
		if(cmnLib.clickOnWebElement(driver.findElement(By.xpath("//tr[contains(@id,'Manag1:0:cmi1')]//td[contains(text(),'Update')]"))))
		{
			log.info("Selected Update");
		}else
		{
			log.info("Not selected Update");
		}
	}
	
	public void clickNameEditSelectCorrect()
	{
		if(cmnLib.clickOnWebElement(NameEditDropdown))
		{
			log.info("Clicked on Edit button");
		}else {
			log.info("Not clicked on Edit button");
		}
		
		if(cmnLib.clickOnWebElement(driver.findElement(By.xpath("//div[contains(@id,':Manag1:0:updateMenu::ScrollBox')]//td[text()='Correct']"))))
		{
			log.info("Selected Update");
		}else
		{
			log.info("Not selected Update");
		}
	}
	
	public void clickNameEditSelectDelete()
	{
		if(cmnLib.clickOnWebElement(NameEditDropdown))
		{
			log.info("Clicked on Edit button");
		}else {
			log.info("Not clicked on Edit button");
		}
		
		if(cmnLib.clickOnWebElement(driver.findElement(By.xpath("//div[contains(@id,':Manag1:0:updateMenu::ScrollBox')]//td[text()='Delete Record']"))))
		{
			log.info("Selected Update");
		}else
		{
			log.info("Not selected Update");
		}
	}
	
	public void clickAddressEditSelectUpdate()
	{
		if(cmnLib.clickOnWebElement(AddressEditDrop))
		{
			log.info("Clicked on Edit button");
		}else {
			log.info("Not clicked on Edit button");
		}
		
		if(cmnLib.clickOnWebElement(driver.findElement(By.xpath("//div[contains(@id,'addIter:1:updateMenu::ScrollBox')]//td[text()='Update']"))))
		{
			log.info("Selected Update");
		}else
		{
			log.info("Not selected Update");
		}
	}
	
	public void clickAddressEditSelectCorrect()
	{
		if(cmnLib.clickOnWebElement(AddressEditDrop))
		{
			log.info("Clicked on Edit button");
		}else {
			log.info("Not clicked on Edit button");
		}
		
		if(cmnLib.clickOnWebElement(driver.findElement(By.xpath("//div[contains(@id,'addIter:1:updateMenu::ScrollBox')]//td[text()='Correct']"))))
		{
			log.info("Selected Update");
		}else
		{
			log.info("Not selected Update");
		}
	}
	
	public void clickAddressEditSelectEndDate()
	{
		if(cmnLib.clickOnWebElement(AddressEditDrop))
		{
			log.info("Clicked on Edit button");
		}else {
			log.info("Not clicked on Edit button");
		}
		
		if(cmnLib.clickOnWebElement(driver.findElement(By.xpath("//div[contains(@id,'addIter:1:updateMenu::ScrollBox')]//td[text()='End Date']"))))
		{
			log.info("Selected Update");
		}else
		{
			log.info("Not selected Update");
		}
	}
	
	
	public void clickAddressEditSelectDelete()
	{
		if(cmnLib.clickOnWebElement(AddressEditDrop))
		{
			log.info("Clicked on Edit button");
		}else {
			log.info("Not clicked on Edit button");
		}
		
		if(cmnLib.clickOnWebElement(driver.findElement(By.xpath("//div[contains(@id,'addIter:1:updateMenu::ScrollBox')]//td[text()='Delete']"))))
		{
			log.info("Selected Update");
		}else
		{
			log.info("Not selected Update");
		}
	}
	
	public void clickAddressEditSelectDeleteRecord() throws InterruptedException
	{
		if(cmnLib.clickOnWebElement(AddressEditDropDeleRec))
		{
			log.info("Clicked on Edit button");
		}else {
			log.info("Not clicked on Edit button");
		}
		TimeUnit.SECONDS.sleep(3);
		if(cmnLib.clickOnWebElement(driver.findElement(By.xpath("//div[contains(@id,'addIter:0:updateMenu::ScrollBox')]//td[text()='Delete Record']"))))
		{
			log.info("Selected Update");
		}else
		{
			log.info("Not selected Update");
		}
	}
	
	public void clickPrimaryAddressEditSelectUpdate()
	{
		if(cmnLib.clickOnWebElement(PrimaryAddressEditButton))
		{
			log.info("Clicked on Edit button");
		}else {
			log.info("Not clicked on Edit button");
		}
		
		if(cmnLib.clickOnWebElement(driver.findElement(By.xpath("//table[contains(@id,'menu1::ScrollContent')]//td[text()='Update']"))))
		{
			log.info("Selected Update");
		}else
		{
			log.info("Not selected Update");
		}
	}
	
	public void clickPrimaryAddressEditSelectCorrect()
	{
		if(cmnLib.clickOnWebElement(PrimaryAddressEditButton))
		{
			log.info("Clicked on Edit button");
		}else {
			log.info("Not clicked on Edit button");
		}
		
		if(cmnLib.clickOnWebElement(driver.findElement(By.xpath("//table[contains(@id,'menu1::ScrollContent')]//td[text()='Correct']"))))
		{
			log.info("Selected Update");
		}else
		{
			log.info("Not selected Update");
		}
	}
	
	
	public void clickCommunicationMethodEditSelectPhone()
	{
		if(cmnLib.clickOnWebElement(CommunicationEditDropButton))
		{
			log.info("Clicked on Edit button");
		}else {
			log.info("Not clicked on Edit button");
		}
		
		if(cmnLib.clickOnWebElement(driver.findElement(By.xpath("//table[contains(@id,'updateMenu::ScrollContent')]//td[text()='Phone Details']"))))
		{
			log.info("Selected Update");
		}else
		{
			log.info("Not selected Update");
		}
	}
	
	public void clickCommunicationMethodEditSelectEmail()
	{
		if(cmnLib.clickOnWebElement(CommunicationEditDropButton))
		{
			log.info("Clicked on Edit button");
		}else {
			log.info("Not clicked on Edit button");
		}
		
		if(cmnLib.clickOnWebElement(driver.findElement(By.xpath("//table[contains(@id,'updateMenu::ScrollContent')]//td[text()='Email Details']"))))
		{
			log.info("Selected Update");
		}else
		{
			log.info("Not selected Update");
		}
	}
	
	public void clickGenderMartialStatusEditSelectUpdate()
	{
		if(cmnLib.clickOnWebElement(EditGenderMartialStatus))
		{
			log.info("Clicked on Edit button");
		}else {
			log.info("Not clicked on Edit button");
		}
		
		if(cmnLib.clickOnWebElement(driver.findElement(By.xpath("//table[contains(@id,'i5:1:updateMenu::ScrollContent')]//td[text()='Update']"))))
		{
			log.info("Selected Update");
		}else
		{
			log.info("Not selected Update");
		}
	}
	
	public void clickGenderMartialStatusEditSelectCorrect()
	{
		if(cmnLib.clickOnWebElement(EditGenderMartialStatus))
		{
			log.info("Clicked on Edit button");
		}else {
			log.info("Not clicked on Edit button");
		}
		
		if(cmnLib.clickOnWebElement(driver.findElement(By.xpath("//table[contains(@id,'i5:1:updateMenu::ScrollContent')]//td[text()='Correct']"))))
		{
			log.info("Selected Update");
		}else
		{
			log.info("Not selected Update");
		}
	}
	
	public void clickGenderMartialStatusEditSelectDelete()
	{
		if(cmnLib.clickOnWebElement(EditGenderMartialStatus))
		{
			log.info("Clicked on Edit button");
		}else {
			log.info("Not clicked on Edit button");
		}
		
		if(cmnLib.clickOnWebElement(driver.findElement(By.xpath("//table[contains(@id,'i5:1:updateMenu::ScrollContent')]//td[text()='Delete']"))))
		{
			log.info("Selected Update");
		}else
		{
			log.info("Not selected Update");
		}
	}
	
	public void clickGenderMartialStatusEditSelectDeleteRecord()
	{
		if(cmnLib.clickOnWebElement(EditGenderMartialStatus))
		{
			log.info("Clicked on Edit button");
		}else {
			log.info("Not clicked on Edit button");
		}
		
		if(cmnLib.clickOnWebElement(driver.findElement(By.xpath("//table[contains(@id,'i5:1:updateMenu::ScrollContent')]//td[text()='Delete Record']"))))
		{
			log.info("Selected Update");
		}else
		{
			log.info("Not selected Update");
		}
	}
	/* Returns date. If number of days mentioned then days will be added to today's date.
	  * If todays date needed, then pass number of days as 0
	  * @param format : format in which date has to be generated 
	  * @return String with value date
	  * @throws Exception*/
	public String futureDate(String format, long noOfDays) {
		  String reqDateFormat = format;
		  String returnDate = "";
		  Date date = new Date();
		  if (reqDateFormat.indexOf("\"") != -1) {
		   reqDateFormat = reqDateFormat.replace("\"", "");
		  }
		  SimpleDateFormat reqFormat = new SimpleDateFormat(reqDateFormat);
		  if(noOfDays!=0){
		   int oneDay = 1000 * 60 * 60 * 24;
		   String nextDate = reqFormat.format(date.getTime() + (oneDay * noOfDays));
		   returnDate = nextDate;
		  } else {
		   returnDate = reqFormat.format(date.getTime());
		  }
		  return returnDate;

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
	
	public boolean SelectValuefromDropDownCombo(String strValueToSelect) {
		  boolean result = false;
		  try {
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

}
