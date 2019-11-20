package hcm.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class BenefitsEnrollment extends TestBase {

	@FindBy(xpath = "//h1[contains(@class,'xmt')]")
	public WebElement BenefitsEnrollmentHeader;

	@FindBy(xpath = "//img[@title='Tasks']")
	public WebElement TasksIcon;

	@FindBy(xpath = "//a[contains(text(),'Manage Contacts')]")
	public WebElement ManageContactsLink;

	@FindBy(xpath = "//span[contains(text(),'Create')]")
	public WebElement CreateContactsIcon;

	@FindBy(xpath = "//li[text()='Spouse']")
	public WebElement Relationship;

	@FindBy(xpath = "//a[contains(@id,'drop')]")
	public WebElement RelationshipDropDown;
	
	@FindBy(xpath="//h1[text()='Search Person']")
	public WebElement EnrollmentPage;

	/*
	 * @FindBy(xpath=
	 * "//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_benefits_enrollment:0:MAt2:0:ap1:AT1:r1:1:soc6::content']")
	 * public WebElement Relationship;
	 */

	@FindBy(xpath = "//label[text()='Relationship Start Date']/parent::td/parent::tr//input")
	public WebElement RelationshipStartDate;

	@FindBy(xpath = "//label[text()='Paternal Last Name']/parent::td/parent::tr//input")
	public WebElement PaternalLastName;
	
	@FindBy(xpath="//label[text()='First Name']/parent::td/parent::tr//input")
	public WebElement FirstName;

	@FindBy(xpath = "//label[text()='Date of Birth']/parent::td/parent::tr//input")
	public WebElement DateOfBirth;

	@FindBy(xpath = "//button[@accesskey='K']")
	public WebElement OKButton;

	@FindBy(xpath = "//span[contains(text(),'Edit')]")
	public WebElement EditContactsIcon;

	@FindBy(xpath = "//label[text()='Update Date']/parent::td/parent::tr//input")
	public WebElement UpdateDate;

	@FindBy(xpath = "//h1[text()='Participant Benefits Summary']")
	public WebElement ParticipantBenefitsSummaryPage;
	
	@FindBy(xpath="//a[@title='Expand Person Attributes Information']")
	public WebElement ExpandPersonAttributesInformation;
	
	@FindBy(xpath="//img[@title='Notes']")
	public WebElement Notes;
	
	@FindBy(xpath="//div[text()='Notes']")
	public WebElement NotesPopUp;
	
	@FindBy(xpath="//div[contains(@id,':AT1:_ATp:ATm')]//table/tbody/tr/td[2]/a[text()='Actions']")
	public WebElement ActionsDropDown;
	
	@FindBy(xpath="//td[text()='Create']")
	public WebElement Notes_Create;
	
	@FindBy(xpath="//div[text()='Create Note']")
	public WebElement CreateNoteWindow;
	
	@FindBy(xpath="//iframe[contains(@id,'richText1::cont')]")
	public WebElement iframeNotes;
	
	@FindBy(xpath="//body[@dir='ltr']")
	public WebElement Notes_Desc;
	
	@FindBy(xpath="//button[text()='ave and Close']")
	public WebElement SaveAndCloseBtn;
	
	@FindBy(xpath="//div[@id='__af_Z_maskingframe']/iframe[1]")
	public WebElement SwitchBackToMain;
	
	@FindBy(xpath="//a[contains(text(),'Unrestricted Enrollments')]")
	public WebElement UnrestrictedEnrollments;
	
	@FindBy(xpath="//h1[contains(text(),'Unrestricted Enrollments')]")
	public WebElement UnrestrictedEnrollmentsPage;
	
	@FindBy(xpath="//button[text()='Go']")
	public WebElement GoBtn;
	
	@FindBy(xpath="//span[text()='Aids and Bonus']/../span/a")
	public WebElement AidsAndBonusExpand;
	
	@FindBy(xpath="//span[text()='Save']")
	public WebElement SaveBtn;
	
	@FindBy(xpath="//td[text()='The enrollments were saved.']")
	public WebElement ConfirmationMsg;
	
	@FindBy(xpath="//td[contains(@id,'dialog')]/button[text()='OK']")
	public WebElement ConfirmationOkBtn;
	
	@FindBy(xpath="//img[contains(@id,'cil3::icon')]")
	public WebElement ReprocessIcon;

	public BenefitsEnrollment() {
		PageFactory.initElements(driver, this);
		log.info("Benefits Enrollment initailzed");
	}

	public boolean verifySearchedRecordExists(String strPersonName_OR_PersonNumber) {
		boolean exists = false;
		try {
			List<WebElement> TableRows = driver.findElements(By.xpath("//table[@summary='Contacts']/tbody/tr"));
			System.out.println("No Of Rows in Search Results Table: "+TableRows.size());
			if(TableRows.size() > 0) {
				for (int i = 1; i <= TableRows.size(); i++) {
					
					WebElement element = driver.findElement(By.xpath("//table[@summary='Contacts']/tbody/tr["+i+"]//td[2]/div/table/tbody/tr/td[1]"));
					System.out.println(element.getText());
					if(element.getText().contains(strPersonName_OR_PersonNumber)) {
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
	
	public boolean ClickOnSearchedResults(String strPersonName_OR_PersonNumber) {
		boolean exists = false;
		try {
			List<WebElement> TableRows = driver.findElements(By.xpath("//table[@summary='Contacts']/tbody/tr"));
			System.out.println("No Of Rows in Search Results Table: "+TableRows.size());
			if(TableRows.size() > 0) {
				for (int i = 1; i <= TableRows.size(); i++) {
					
					WebElement element = driver.findElement(By.xpath("//table[@summary='Contacts']/tbody/tr["+i+"]//td[2]/div/table/tbody/tr/td[1]"));
					System.out.println(element.getText());
					if(element.getText().equalsIgnoreCase(strPersonName_OR_PersonNumber)) {
						driver.findElement(By.xpath("//table[@summary='Contacts']/tbody/tr["+i+"]//td[2]/div/table/tbody/tr/td[1]")).click();
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
