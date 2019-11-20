package scm.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ManageCostScenarious extends TestBase{
	
	@FindBy(xpath="//h1[contains(text(),'Manage Cost Scenarios')]")
	public WebElement ManageCostScenariousPageHeader;
	
	@FindBy(xpath="//img[@title='Create']")
	public WebElement CreateCostScenarioIcon;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt3:0:pt1:AP1:it1::content']")
	public WebElement ScenarioField;
	
	@FindBy(xpath="//input[@name='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt3:0:pt1:AP1:costOrgName4Id']")
	public WebElement CostOrganizationField;
	
	@FindBy(xpath="//input[@name='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt3:0:pt1:AP1:costBookCodeId']")
	public WebElement CostBooksField;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt3:0:pt1:AP1:id1::content']")
	public WebElement EffectiveDate;
	
	@FindBy(xpath="//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt3:0:pt1:AP1:soc2::content']")
	public WebElement ScenarioType;
	
	@FindBy(xpath="//textarea[@name='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt3:0:pt1:AP1:it2']")
	public WebElement Comments;
	
	@FindBy(xpath="//input[@name='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt3:0:pt1:AP1:workDefNameId']")
	public WebElement WorkDefinitionField;
	
	@FindBy(xpath="//a/span[contains(text(),'Save')]")
	public WebElement SaveButton;
	
	
	@FindBy(xpath="//div[contains(@id,'SPc')]")
	public WebElement CancelButton;
	
	@FindBy(xpath="//div[@id='_FOd1::msgDlg::_ttxt']")
	public WebElement ErrorDialog;
	
	@FindBy(xpath="//button[@id='_FOd1::msgDlg::cancel']")
	public WebElement ErrorDialogOKButton;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt2:0:pt1:AP1:qryId1:value00::content'] ")
	public WebElement ScenarioSearchEle;
	
	@FindBy(xpath="//button[contains(@id,'search')] ")
	public WebElement SearchButton;
	
	@FindBy(xpath="//button[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt2:0:pt1:AP1:qryId1::reset']")
	public WebElement ResetButton;
	
	@FindBy(xpath="//button[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt2:0:pt1:AP1:AT1:_ATp:ATt1:0:cb1']")
	public WebElement ActionsButton;
	
	@FindBy(xpath="//tr[contains(@id,'rollup')]//td[text()='Roll up Costs']")
	public WebElement ActionsRollUpCosts;
	
	@FindBy(xpath="//div[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt2:0:pt1:AP1:d118::_ttxt']")
	public WebElement RollUpCostsHeader;
					
	@FindBy(xpath="//div[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt2:0:pt1:AP1:r13:requestBtns:submitButton']//a")
	public WebElement RollUpCostSubmitButton;
	
	@FindBy(id="_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt2:0:pt1:AP1:qryId1::_afrDscl")
	public WebElement ExpandSearch;
				
	@FindBy(id="_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt2:0:pt1:AP1:r13:requestBtns:confirmationPopup:confirmSubmitDialog::ok")
	public WebElement RollUpCostsOkButton;
	
	@FindBy(xpath="//td[contains(text(),'View Scenario Exceptions')]")
	public WebElement ActionViewScenarioExceptions;
	
	@FindBy(xpath="//td[contains(text(),'View Rolled-up Costs')]")
	public WebElement ActionViewRolledUpCosts;
	
	@FindBy(xpath="//h1[contains(@class,'xmt')]")
	public WebElement ViewScenarioExpectionHeader;
	
	@FindBy(xpath="//span[text()='Columns Hidden']")
	public WebElement ColumnHidden;
					
	@FindBy(xpath="//span[text()='D']")
	public WebElement DoneButton;
	
	@FindBy(id="_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt4:0:pt1:AP1:SPb")
	public WebElement CompareStandardCostDoneButton;
	
	@FindBy(xpath="//td[contains(text(),'Compare Standard Costs')]")	
	public WebElement ActionCompareStandardCosts;
	
	@FindBy(xpath="//td[contains(text(),'Update Standard Costs')]")
	public WebElement ActionUpdateStandardCosts;
	
	@FindBy(xpath="//div[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt5:0:pt1:AP1:d28::_ttxt']")
	public WebElement UpdateStandardCostsHeader;
	
	@FindBy(xpath="//div[contains(@id,'AP1:r23:requestBtns:submitButton')]")
	public WebElement SubmitButtonUpdateStandardCosts;
	
	@FindBy(xpath="//button[contains(@id,':requestBtns:confirmationPopup:confirmSubmitDialog::ok')] ")
	public WebElement OkButtonUpdateStandardCosts;
	
	public ManageCostScenarious() {
		PageFactory.initElements(driver, this);
		log.info("Manage Cost Scenarious page is Initialized...");
	}
	
	
	public boolean verifySearchedRecordExists(String Scenario) {
		boolean exists = false;
		try {
			List<WebElement> TableRows = driver.findElements(By.xpath("//table[@summary='Manage Cost Scenarios']/tbody/tr"));
			System.out.println("No Of Rows in Search Results Table: "+TableRows.size());
			if(TableRows.size() > 0) {
				for (int i = 1; i <= TableRows.size(); i++) {
					if(driver.findElement(By.xpath("//table[@summary='Manage Cost Scenarios']/tbody/tr["+i+"]//*[contains(text(), '"+Scenario+"')]")).isDisplayed()) {
						exists = true;
						log.info("Searched Scenario record exists");
						}
					}
				}else {
					log.info("TableRows row count is less than zero !!");
				}
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Searched Scenario record does not exist");
		}
		return exists;
	}
	
	

}
