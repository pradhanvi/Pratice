package hcm.pagefactory;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.commons.*;

import scm.pagefactory.CostAccountingPage;
import scm.pagefactory.SetupAndMaintenancePage;


public class HomePage_HCM extends TestBase{

	@FindBy (xpath = "//*[@id='pt1:_UIScmil2u::icon']")
	public WebElement UserName_Icon;
	@FindBy  (xpath="//h1[contains(text(),'Welcome, ')]")
	public WebElement HomePage_StringValidation;
	
	@FindBy  (xpath="//*[@id='pt1:_UIShome::icon']")
	public WebElement HomePage_HomeIcon;
	
	@FindBy  (xpath="//span[contains(text(),'Employee News')]")
	public WebElement HomePage_StringValidation2;
	
	@FindBy (xpath = "//a[@title='Navigator']")
	public WebElement NavigatorIcon;
	
	@FindBy  (xpath = "//*[@id='groupNode_general_accounting']")
	public WebElement Role_GeneralAccounting;
	
	@FindBy (xpath = "//div[@id='pt1:_UISmmp::content']") 
	public WebElement NavigatorContent;
	@FindBy  (xpath="//*[@id='itemNode_general_accounting_journals']")
	public WebElement Resp_Journals;
	
	@FindBy (xpath="//*[@id='pt1:_FOr1:1:_FOSritemNode_general_accounting_journals:0:_FOTsr2:0:soc1::content']")
	public WebElement changeDataAccessSetElement;
	
	@FindBy (xpath = "//*[@id='pt1:_FOr1:0:_FOSritemNode_general_accounting_journals:0:_FOTsr2:0:d1::ok']")
	public WebElement OKButton;
	
	@FindBy (xpath = "//img[@src='/hcmUI/images/applcore/uishell/warning.png']")
	public WebElement WarningPopUpAfterClickingOnHomeIcon;
	
	@FindBy(id = "pt1:nv_itemNode_workforce_management_person_management")
	public WebElement PersonManagementLink;
	
	@FindBy(id="pt1:nv_itemNode_benefits_enrollment")
	public WebElement BenefitsEnrollmentLink;
	
	@FindBy(xpath="//a[text()='Personal Information' and contains(@id,'pt1:nv_PER_HCMPEOPLETOP_FUSE_PER_INFO')]")
	public WebElement PersonalInformation;
	
	@FindBy(xpath="//td/a[text()='Setup and Maintenance']")
	public WebElement SetupAndMaintenance;
	
	@FindBy(xpath="//a[text()='Setup and Maintenance']")
	public WebElement SetupAndMaintenance_HomePage_Icon;
	
	@FindBy(xpath="//td/a[text()='Workforce Structures']")
	public WebElement WorkforceStructures;
	
	@FindBy(xpath="//a[text()='Directory' and contains(@id,'nv_PER_HCMPEOPLETOP_FUSE_DIRECTORY')]")
	public WebElement DirectoryLink;
	
	
	public HomePage_HCM() {
		PageFactory.initElements(driver, this);
		//System.out.println("HomePage is Initialized...");
	}
	
	public String getUserNameFromHomePage() {
		String strUserName = null;
		try {
			clickOnWelcomePage_HomeIcon();
			
			driver.findElement(By.xpath("//*[@id='pt1:_UIScmil2u::icon']")).isDisplayed();
			strUserName = driver.findElement(By.xpath("//*[@id='pt1:_UIScmil2u::icon']")).getAttribute("title");
//			UserName_Icon.isDisplayed();
//			strUserName = UserName_Icon.getAttribute("title");
			System.out.println("UserName captured from HomePage: "+strUserName);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("UserName could not be captured from HomePage");
		}
		return strUserName;
	}
/*	public boolean validateWelcomePageWelcomeString()	{
		
		if(HomePage_StringValidation.getText().toLowerCase().contains("welcome")){
			log.info("Welcome Page Validation is successful");
			return true;
		}
		log.info("Welcome Page Validation is Un-successful");
		return false;
	}*/
	
	public boolean clickOnWelcomePage_HomeIcon()
	{
		try {
			driver.findElement(By.xpath("//*[@id='pt1:_UIShome::icon']")).isDisplayed();
			driver.findElement(By.xpath("//*[@id='pt1:_UIShome::icon']")).click();
//			HomePage_HomeIcon.isDisplayed();
//			HomePage_HomeIcon.click();
			log.info("Clicked on HomeIcon in HomePage");
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Home Icon in HomePage is not displayed...");
			return false;
		}
		return true;
	}
	
	
	/*public boolean validateHomePageWelcomeString() throws InterruptedException	{
		TimeUnit.SECONDS.sleep(1);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(HomePage_StringValidation2));
		if(HomePage_StringValidation2.getText().toLowerCase().contains("employee news")){
			log.info("Home Page Validation is successful");
			return true;
		}
		log.info("Home Page Validation is successful");
		return false;
	}*/
	
	public void clickOnNavigationIcon() throws InterruptedException {
		cmnLib.clickOnWebElement(NavigatorIcon);
		log.info("Navigation Icon is clicked");
		TimeUnit.SECONDS.sleep(5);
	}
	
	/*public void clickOnGeneralAccounting()
	{
		Role_GeneralAccounting.click();
		log.info("General Accounting is clicked");
	}*/
	
	
	
	/*public void changeDataAccess(String strChangeDataAccessSet) {
		Select sel = new Select (changeDataAccessSetElement);
		if (changeDataAccessSetElement.isDisplayed() && strChangeDataAccessSet!= null)
		{
			sel.selectByVisibleText(strChangeDataAccessSet);
			log.info("Change Data Access Set is Selected");
			OKButton.click();
			log.info("OK button is clicked");
		}else if (changeDataAccessSetElement.isDisplayed())
		{
			sel.selectByIndex(0);
			log.info("Change Data Access Set is selected by Index=0");
			OKButton.click();
			log.info("OK button is clicked");
		}
	}*/

	
	public SearchPerson clickOnPersonManagementLink() {
		try {
			PersonManagementLink.isDisplayed();
			PersonManagementLink.click();
			log.info("Person Management Link is Clicked");
			
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Person Management Link is Not Clicked");
			return null;
		}
		return PageFactory.initElements(driver, SearchPerson.class);
	}
	
	
	public ManageCommunication clickOnDirectoryLink() {
		try {
			DirectoryLink.isDisplayed();
			DirectoryLink.click();
			log.info("Directory Link is Clicked");
			
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Directory Link is Not Clicked");
			return null;
		}
		return PageFactory.initElements(driver, ManageCommunication.class);
	}
	
	public BenefitsEnrollment clickOnBenefitsEnrollment() {
		try {
			BenefitsEnrollmentLink.isDisplayed();
			cmnLib.clickOnWebElement(BenefitsEnrollmentLink);
			log.info("Benefits Enrollment Link is Clicked");
			
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Benefits Enrollment Link is NOT Clicked");
			return null;
		}
		return PageFactory.initElements(driver, BenefitsEnrollment.class);
	}
	
	public PersonalInformation clickOnPersonalInformation() {
		try {
			PersonalInformation.isDisplayed();
			cmnLib.clickOnWebElement(PersonalInformation);
			log.info("Personal Information Link is Clicked");
			
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Personal Information Link is NOT Clicked");
			return null;
		}
		return PageFactory.initElements(driver, PersonalInformation.class);
	}
	
	public SetupAndMaintenance clickOnSetupAndMaintenance() {
		try {
			SetupAndMaintenance.isDisplayed();
			cmnLib.clickByJSE(SetupAndMaintenance);
			log.info("Setup And Maintenance Link is Clicked");
			
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Setup And Maintenance Link is NOT Clicked");
			return null;
		}
		return PageFactory.initElements(driver, SetupAndMaintenance.class);
	}
	
	public WorkforceStructures clickOnWorkforceStructures() {
		try {
			WorkforceStructures.isDisplayed();
			cmnLib.clickOnWebElement(WorkforceStructures);
			log.info("Workforce Structures Link is Clicked");
			
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Workforce Structures Link is NOT Clicked");
			return null;
		}
		return PageFactory.initElements(driver, WorkforceStructures.class);
	}
	
	
	}
	

