package scm.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ManageWorkArea extends TestBase {
	//h1[contains(@class,'xmt')]
	@FindBy(xpath="//h1[contains(@class,'xmt')]")
	public WebElement ManageWorkAreaHeader;
	
	@FindBy(xpath="//div[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:AT1:_ATp:create']")
	public WebElement AddWorkAreaButton;
	
	@FindBy(xpath="//div[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:AT1:d1::_ttxt']")
	public WebElement CreateWorkAreaPopUP;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:AT1:it2::content']")
	public WebElement WorkAreaName;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:AT1:it1::content']")
	public WebElement WorkAreaCode;
	
	@FindBy(xpath="//span[contains(text(),'ave and Close')]")
	public WebElement CreateWorkAreaSaveButton;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:qq1:criterionValue0::content']")
	public WebElement ManageWorkAreaSearchName;
	
	@FindBy(xpath="//a[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:qq1::search_icon']")
	public WebElement ManageWorkAreaSearchButton;
	
	@FindBy(xpath="")
	public WebElement abc8;
	
	@FindBy(xpath="")
	public WebElement abc10;
	
	public ManageWorkArea() {
		PageFactory.initElements(driver, this);
		log.info("ManageWorkArea is initialized");
	}
	
	
	public boolean verifySearchedRecordExists(String workAreaName) {
		boolean exists = false;
		try {
			
			List<WebElement> TableRows = driver.findElements(By.xpath("//table[@summary='Search Results']/tbody/tr"));
			System.out.println("No Of Rows in Search Results Table: "+TableRows.size());
			if(TableRows.size() > 0) {
				for (int i = 1; i <= TableRows.size(); i++) {
					if(driver.findElement(By.xpath("//table[@summary='Search Results']/tbody/tr["+i+"]//*[contains(text(), '"+workAreaName+"')]")).isDisplayed()) {
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
