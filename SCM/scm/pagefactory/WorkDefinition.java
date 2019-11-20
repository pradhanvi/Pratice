package scm.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class WorkDefinition extends TestBase {
	 
	@FindBy(xpath="//h1[contains(text(),'Recently Updated Work Definitions')]")
	public WebElement WorkDefinitionHeader;
	
	@FindBy(xpath="//div[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:_FOTsr2:1:pt1:d1::_ttxt']")
	public WebElement SelectOrganizationPopUp;
	
	@FindBy(xpath="//button[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:_FOTsr2:1:pt1:d1::cancel']")
	public WebElement Cancel_SelectOrganizationPopUp;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:_FOTsr2:1:pt1:organizationCodeId::content']")
	public WebElement OrganizationPopUp;
	
	@FindBy(xpath="//button[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:_FOTsr2:1:pt1:d1::ok']")
	public WebElement SelectOrganizationWindowOKButton;
	
	@FindBy(xpath="//img[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:_FOTsdiTaskRegionalArea::icon']")
	public WebElement TasksIcon;
					
	@FindBy(xpath="//a[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:_FOTRaT:0:RAtl12']")
	public WebElement ManageWorkAreaLink;
	
	@FindBy(xpath="//button[contains(text(),'Change Organization')]")
	public WebElement ChangeOrganizationButton;
	
	@FindBy(xpath="//a[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:_FOTRaT:0:RAtl1']")
	public WebElement ManageWorkDefinitionsLink;
	
	@FindBy(xpath="//a[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:_FOTRaT:0:RAtl11']")
	public WebElement ManageWorkCentersLink;
	
	@FindBy(xpath="//a[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:_FOTRaT:0:RAtl10']")
	public WebElement ManageResourceLink;
	
	@FindBy(xpath="//a[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:_FOTRaT:0:RAtl8']")
	public WebElement ManageStandardOperationsLink;
	
	
	
	public ManageWorkArea clickOnManageWorkArea() {
		try {
			ManageWorkAreaLink.isDisplayed();
			//cmnLib.clickOnLinkText("Cost Accounting");
			cmnLib.clickOnWebElement(ManageWorkAreaLink);
			log.info("Manage Work Area Link is Clicked");

		} catch (Exception e) {
			// TODO: handle exception
			log.info("Manage Work Area Link is NOT Clicked");
			return null;
		}
		return PageFactory.initElements(driver, ManageWorkArea.class);
	}
	
	public ManageWorkCenters clickOnManageWorkCentersArea() {
		try {
			ManageWorkCentersLink.isDisplayed();
			//cmnLib.clickOnLinkText("Cost Accounting");
			cmnLib.clickOnWebElement(ManageWorkCentersLink);
			log.info("Manage Work Centers Link is Clicked");

		} catch (Exception e) {
			// TODO: handle exception
			log.info("Manage Work Centers Link is NOT Clicked");
			return null;
		}
		return PageFactory.initElements(driver, ManageWorkCenters.class);
	}
	
	public ManageResource clickOnManageResource() {
		try {
			ManageResourceLink.isDisplayed();
			//cmnLib.clickOnLinkText("Cost Accounting");
			cmnLib.clickOnWebElement(ManageResourceLink);
			log.info("Manage Resource Link is Clicked");

		} catch (Exception e) {
			// TODO: handle exception
			log.info("Manage Resource Link is NOT Clicked");
			return null;
		}
		return PageFactory.initElements(driver, ManageResource.class);
	}
	
	public ManageStandardOperations clickOnManageStandardOperations() {
		try {
			ManageStandardOperationsLink.isDisplayed();
			//cmnLib.clickOnLinkText("Cost Accounting");
			cmnLib.clickOnWebElement(ManageStandardOperationsLink);
			log.info("Manage Standard Operations Link is Clicked");

		} catch (Exception e) {
			// TODO: handle exception
			log.info("Manage Standard Operations Link is NOT Clicked");
			return null;
		}
		return PageFactory.initElements(driver, ManageStandardOperations.class);
	}
	
	public ManageWorkDefinition clickOnManageWorkDefinition() {
		try {
			ManageWorkDefinitionsLink.isDisplayed();
			//cmnLib.clickOnLinkText("Cost Accounting");
			cmnLib.clickOnWebElement(ManageWorkDefinitionsLink);
			log.info("Manage Work Definitions Link is Clicked");

		} catch (Exception e) {
			// TODO: handle exception
			log.info("Manage Work Definitions Link is NOT Clicked");
			return null;
		}
		return PageFactory.initElements(driver, ManageWorkDefinition.class);
	}

}
