package scm.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ManageWorkOrders extends TestBase{
	
	@FindBy(xpath="//h1[contains(@class,'xmt')]")
	public WebElement ManageWorkOrdersHeader;
	
	@FindBy(xpath="//a[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_execution:0:MAt2:0:AP1:AT1:_ATp:ctbb1::popEl']")
	public WebElement AddNewWorderOrderDropdown;
	
	@FindBy(xpath="//td[contains(text(),'Create Standard Work Order')]")
	public WebElement CreateStandardWorkOrderLink;
	
	@FindBy(xpath="//td[contains(text(),'Create Nonstandard Work Order')]")
	public WebElement CreateNonStandardWorkOrdersLink;
	
	@FindBy(xpath="//div[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_execution:0:MAt2:0:AP1:AT1:d1::_ttxt']")
	public WebElement CreateStandardWorkOrderHeader;
	
	@FindBy(xpath="//div[contains(text(),'Create Nonstandard Work Order')]")
	public WebElement CreateNonStandardWorkHeader;
					
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_execution:0:MAt2:0:AP1:AT1:r1:0:itemId:lovTxtId::content']")
	public WebElement Item_WorkOrder;
												
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_execution:0:MAt2:0:AP1:AT1:r1:0:it1::content']")
	public WebElement Quanity_WorkOrder;
	
	@FindBy(xpath="//span[contains(text(),'Save and Edit')]")
	public WebElement SaveEditButton_WorkOrder;
					
	@FindBy(xpath="//a[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_execution:0:MAt3:0:panel1:generalTab::disAcr']")
	public WebElement WorkOrderGenralInfoTab;
	
	@FindBy(xpath="//a[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_execution:0:MAt3:0:panel1:operationTab::disAcr']")
	public WebElement WorkOrderOperationsTab;
	
	@FindBy(xpath="//button[text()='ave and Close']")
	public WebElement SaveCloseButton_WorkOrder;
	
	@FindBy(xpath="//td[contains(text(),'Confirmation')]")
	public WebElement ConfirmationTD;
	
	@FindBy(xpath="//span[contains(text(),'updated')]")
	public WebElement ConfirmationMessage;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_execution:0:MAt2:0:AP1:AT1:r1:0:itemId1:lovTxtId::content']")
	public WebElement Item_NonStandard;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_execution:0:MAt2:0:AP1:AT1:r1:0:it5::content']")
	public WebElement Quantity_NonStandard;
	
	@FindBy(xpath="//div[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_execution:0:MAt2:0:AP1:AT1:r1:0:ctb1']//a[@class='xw8']")
	public WebElement SaveEdit_NonStandard;
	
	@FindBy(xpath="//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_execution:0:MAt2:0:AP1:AT1:r1:0:statusForNonMNT::content']")
	public WebElement Status_NonStandard;
	
	@FindBy(xpath="")
	public WebElement abc5;
	
	@FindBy(xpath="")
	public WebElement abc6;
	
	public ManageWorkOrders()
	{
		PageFactory.initElements(driver, this);
		log.info("Manage Work Orders intialised");
	}

}
