package scm.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class CreateCostAccountingDistributions extends TestBase {
	
	@FindBy(xpath="//h1[contains(text(),'Create Cost Accounting Distributions')]")
	public WebElement CreateCostAccountingDistributionsHeader;
	
	@FindBy(xpath="//img[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt2:0:pt1:rcpf1:0:ap1:AT1:_ATp:create::icon']")
	public WebElement RunControl_Add;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt2:0:pt1:rcpf1:0:ap1:AT1:_ATp:tid1:0:inputText3::content']")
	public WebElement RunControlID;
	
	@FindBy(xpath="//img[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt2:0:pt1:rcpf1:0:ap1:AT2:_ATp:create::icon']")
	public WebElement Details_Add;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt2:0:pt1:rcpf1:0:ap1:AT2:_ATp:tid2:0:selectOneChoice1::content']")
	public WebElement CostOrganization;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt2:0:pt1:rcpf1:0:ap1:AT2:_ATp:tid2:0:costBookCodeId::content']")
	public WebElement CostBooks;
	
	@FindBy(xpath="//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt2:0:pt1:rcpf1:0:ap1:AT2:_ATp:tid2:0:selectOneChoice3::content']")
	public WebElement CutOffDateOptions;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt2:0:pt1:rcpf1:0:ap1:AT2:_ATp:tid2:0:inputDate2::content']")
	public WebElement CutOffDate;
	
	@FindBy(xpath="//div[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt2:0:pt1:rcpf1:0:ap1:APsv2']//a")
	public WebElement SaveButton;
	
	@FindBy(xpath="//button[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt2:0:pt1:rcpf1:0:ap1:AT1:_ATp:ess_button']")
	public WebElement ScheduleProcessButton;
	
	@FindBy(xpath="//div[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt2:0:pt1:rcpf1:0:ap1:AT1:_ATp:Sched1:requestBtns:submitButton']//a")
	public WebElement SubmitButton;
	
	@FindBy(id="_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt2:0:pt1:rcpf1:0:ap1:AT1:_ATp:Sched1:requestBtns:confirmationPopup:pt_ol1")
	public WebElement ProcessIDMessage;
								
	@FindBy(xpath="//button[contains(@id,':confirmationPopup:confirmSubmitDialog::ok')]")
	public WebElement ConfirmationWindowOKButton;
	
	public CreateCostAccountingDistributions()
	{
		PageFactory.initElements(driver, this);
		log.info("Create CostAccounting Distributions page is initialised");
	}

}
