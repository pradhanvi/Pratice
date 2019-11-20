package scm.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.commons.TestBase;

public class ManageStandardCosts extends TestBase {
	
	@FindBy(xpath="//h1[contains(@class,'xmt')]")
	public WebElement ManageStandardCostsHeader;
	
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt2:0:pt1:AP1:q1:value10::content']")
	public WebElement CostOrganizationSearchEle;
	
	@FindBy(xpath="//button[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt2:0:pt1:AP1:q1::search']")
	public WebElement SearchButton;
	
	public boolean verifySearchedResults() {
		boolean exists = false;
		try {
			List<WebElement> TableRows = driver.findElements(By.xpath("//*[@id=\"_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt2:0:pt1:AP1:AT1:_ATp:ATt1::db\"]/table/tbody/tr[1]/td[2]/div/table/tbody/tr"));
			System.out.println("No Of Rows in Search Results Table: "+TableRows.size());
			if(TableRows.size() > 0){
						exists = true;
						log.info("Searched Scenario record exists");
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
