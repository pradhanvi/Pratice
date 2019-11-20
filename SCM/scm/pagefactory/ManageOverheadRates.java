package scm.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.commons.TestBase;

public class ManageOverheadRates extends TestBase {
	
	@FindBy(xpath="//h1[contains(@class,'xmt')]")
	public WebElement ManageOverheadRatesHeader;
	
	@FindBy(xpath="//img[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt2:0:pt1:AP1:sorrat:_ATp:create::icon']")
	public WebElement CreateOverheadRatesIcon;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt3:0:pt1:AP1:scenarioNumberId::content']")
	public WebElement ScenarioField;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt3:0:pt1:AP1:nameId::content']")
	public WebElement PlantField;

	@FindBy(xpath="//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt3:0:pt1:AP1:soc1::content']")
	public WebElement OverheadRateType;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt3:0:pt1:AP1:categoryNameId::content']")
	public WebElement ItemCategory;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt3:0:pt1:AP1:itemNumberId::content']")
	public WebElement ItemField;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt3:0:pt1:AP1:workCenterNameId::content']")
	public WebElement WorkCenterField;
	
	@FindBy(xpath="//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt3:0:pt1:AP1:soc3::content']")
	public WebElement ResourceType;
	
	@FindBy(xpath="//img[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt3:0:pt1:AP1:AT1:_ATp:create::icon']")
	public WebElement AddOverheadRatesIcon;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt3:0:pt1:AP1:AT1:_ATp:ATt1:0:costElementCodeId::content']")
	public WebElement CostElement;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt3:0:pt1:AP1:AT1:_ATp:ATt1:0:expensePoolCodeId::content']")
	public WebElement ExpensePool;
	
	@FindBy(xpath="//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt3:0:pt1:AP1:AT1:_ATp:ATt1:0:soc2::content']")
	public WebElement AbsorptionType;
	
	@FindBy(xpath="//input[@name='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt3:0:pt1:AP1:AT1:_ATp:ATt1:0:it1']")
	public WebElement Value;
	
	@FindBy(xpath="//span[text()='Save']")
	public WebElement SaveButton;
	
	@FindBy(xpath="//span[text()='ancel']")
	public WebElement CancelButton;
	
	@FindBy(xpath="//div[@id='_FOd1::msgDlg::_ttxt']")
	public WebElement ErrorDialog;
	
	@FindBy(xpath="//button[@id='_FOd1::msgDlg::cancel']")
	public WebElement ErrorDialogOKButton;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt2:0:pt1:AP1:ssor:value00::content']")
	public WebElement ScenarioSearchEle;
	
	@FindBy(xpath="//button[contains(@id,'search')]")
	public WebElement SearchButton;
	
	@FindBy(xpath="//h2[contains(text(),'Details')]")
	public WebElement Details;
	
	
	public boolean verifySearchedRecordExists(String Scenario) {
		boolean exists = false;
		try {
			List<WebElement> TableRows = driver.findElements(By.xpath("//table[@summary='Search Results']/tbody/tr"));
			System.out.println("No Of Rows in Search Results Table: "+TableRows.size());
			if(TableRows.size() > 0) {
				for (int i = 1; i <= TableRows.size(); i++) {
					if(driver.findElement(By.xpath("//table[@summary='Search Results']/tbody/tr["+i+"]//*[contains(text(), '"+Scenario+"')]")).isDisplayed()) {
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
