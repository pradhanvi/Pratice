package scm.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class WorkExecution extends TestBase {

	@FindBy(xpath="//span[@title='Work Orders']")
	public WebElement WorkOrdersHeader;
	
	@FindBy(xpath="//img[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_execution:0:_FOTsdiTaskRegionalArea::icon']")
	public WebElement TasksIcon;
	
	@FindBy(xpath="//button[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_execution:0:_FOTsr2:0:r1:0:cb4']")
	public WebElement ChangeOrganizationButton;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_execution:0:_FOTsr2:1:pt1:organizationCodeId::content']")
	public WebElement OrganizationPopup;
	
	@FindBy(xpath="//button[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_execution:0:_FOTsr2:1:pt1:d1::ok']")
	public WebElement SelectOrganizationWindowOKButton;
	
	@FindBy(xpath="//a[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_execution:0:_FOTRaT:0:RAtl1']")
	public WebElement ManageWorkOrders;
	
	public ManageWorkOrders clickOnManageWorkOrders() {
		try {
			ManageWorkOrders.isDisplayed();
			//cmnLib.clickOnLinkText("Cost Accounting");
			cmnLib.clickOnWebElement(ManageWorkOrders);
			log.info("Manage Work Orders Link is Clicked");

		} catch (Exception e) {
			// TODO: handle exception
			log.info("Manage Work Orders Link is NOT Clicked");
			return null;
		}
		return PageFactory.initElements(driver, ManageWorkOrders.class);
	}
}
