package scm.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.commons.TestBase;

public class ReviewItemCosts extends TestBase {
	
	@FindBy(xpath="//h1[contains(@class,'xmt')]")
	public WebElement ReviewItemCostsHeader;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt2:0:pt1:ap1:qid:value20::content']")
	public WebElement SearchItemEle;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt2:0:pt1:ap1:qid:value00::content']")
	public WebElement SearchCostOrgEle;
	
	@FindBy(xpath="//span[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt2:0:pt1:ap1:qrid:_ATp:table1:0:pgl1']")
	public WebElement TotalUnitCost;
	
	@FindBy(xpath="//span[contains(text(),'Review Unit Cost')]")
	public WebElement ReviewUnitCostButton;
	
	@FindBy(xpath="//h1[contains(@class,'xmt')]")
	public WebElement ReviewPerpetualAverageCostHeader;
	
	@FindBy(xpath="//h1[contains(text(),'Cost Breakdown')]")
	public WebElement CostBreakdown;
	
	@FindBy(xpath="//div[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt2:1:pt1:applicationPanel:SPb']//a")
	public WebElement ReviewPerpetualAverageCostDoneButton;
	
	@FindBy(xpath="//button[contains(text(),'Reset')]")
	public WebElement ResetButton;

	
	@FindBy(xpath="//button[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt2:0:pt1:ap1:qid::search']")
	public WebElement SearchButton;
	
	@FindBy(xpath="//span[contains(text(),'Compare (2)')]")
	public WebElement CompareButton;
	
	@FindBy(xpath="//div[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt2:0:pt1:ap1:qrid:dialog2::_ttxt']")
	public WebElement ItemsToCompareHeader;
					
	@FindBy(xpath="//div[@title='Compare costs of two to six items']//span[text()='Compare']")
	public WebElement ItemsCompareButton;
	
	@FindBy(xpath="//h1[contains(@class,'xmt')]")
	public WebElement CompareItemCostsHeader;
	
	@FindBy(xpath="//h1[contains(text(),'Cost Attributes')]")
	public WebElement CostAttributes;
	
	@FindBy(xpath="//h1[contains(text(),'Cost Details')]")
	public WebElement CostDetails;
	
	@FindBy(xpath="//span[contains(text(),'Cost Elements')]")
	public WebElement CostElements;
	
	public boolean SearchRecordExists(String Item) {
		boolean exists = false;
		try {
			List<WebElement> TableRows = driver.findElements(By.xpath("//table[@summary='Search Results']/tbody/tr"));
			System.out.println("No Of Rows in Search Results Table: "+TableRows.size());
			if(TableRows.size() > 0) {
				for (int i = 1; i <= TableRows.size(); i++) {
					if(driver.findElement(By.xpath("//table[@summary='Search Results']/tbody/tr["+i+"]//*[contains(text(), '"+Item+"')]")).isDisplayed()) {
						driver.findElement(By.xpath("//tr["+i+"][@class='xeq p_AFSelected']//td["+i+"][@class='xer x1ms']")).click();
						driver.findElement(By.xpath("//label[@class='x1cd']")).click();
						exists = true;
						log.info("Searched Item record exists");
						}
					}
				}else {
					log.info("TableRows row count is less than zero !!");
				}
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Searched Item record does not exist");
		}
		return exists;
	}
	
	public boolean verifySearchedRecordExists(String Item) {
		boolean exists = false;
		try {
			List<WebElement> TableRows = driver.findElements(By.xpath("//table[@summary='Search Results']/tbody/tr"));
			System.out.println("No Of Rows in Search Results Table: "+TableRows.size());
			if(TableRows.size() > 0) {
				for (int i = 1; i <= TableRows.size(); i++) {
					if(driver.findElement(By.xpath("//table[@summary='Search Results']/tbody/tr["+i+"]//*[contains(text(), '"+Item+"')]")).isDisplayed()) {
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
