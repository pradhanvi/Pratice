package scm.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;


public class ManageStandardOperations extends TestBase {
	
	@FindBy(xpath="//h1[contains(@class,'xmt')]")
	public WebElement ManageStandardOperationsHeader;
	
	@FindBy(xpath="//img[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:AT1:_ATp:create::icon']")
	public WebElement AddStandardOperations;
	
	@FindBy(xpath="//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:AT1:r1:0:soc5::content']")
	public WebElement OperationType;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:AT1:r1:0:it7::content']")
	public WebElement Operation_Name;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:AT1:r1:0:it2::content']")
	public WebElement Operations_Code;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:AT1:r1:0:workCenterNameId::content']")
	public WebElement Operations_WorkCenters;
	
	@FindBy(xpath="//img[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:AT1:r1:0:AT2:_ATp:create::icon']")
	public WebElement AddResourceIcon;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:AT1:r1:0:AT2:_ATp:ATt2:0:it11::content']")
	public WebElement Resource_Sequence;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:AT1:r1:0:AT2:_ATp:ATt2:0:resourceNameId::content']")
	public WebElement Resources_Resource;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:AT1:r1:0:AT2:_ATp:ATt2:0:it12::content']")
	public WebElement Resource_UnitAssigned;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:AT1:r1:0:AT2:_ATp:ATt2:0:it14::content']")
	public WebElement Resource_Usage;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:AT1:r1:0:AT2:_ATp:ATt2:0:it13::content']")
	public WebElement Resource_InverseUsage;
	
	@FindBy(xpath="//span[contains(text(),'ave and Close')]")
	public WebElement Resource_Save;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:qryId1:criterionValue0::content']")
	public WebElement Name_Search;
	
	@FindBy(xpath="//a[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:qryId1::search_icon']")
	public WebElement SearchButton;
	
	
	public ManageStandardOperations()
	{
		PageFactory.initElements(driver, this);
		log.info("Manage Standard Operations is initialized");
	}
	
	public boolean verifySearchedRecordExists(String standardOperationsName) {
		boolean exists = false;
		try {
			
			List<WebElement> TableRows = driver.findElements(By.xpath("//table[@summary='Search']/tbody/tr"));
			System.out.println("No Of Rows in Search Results Table: "+TableRows.size());
			if(TableRows.size() > 0) {
				for (int i = 1; i <= TableRows.size(); i++) {
					if(driver.findElement(By.xpath("//table[@summary='Search']/tbody/tr["+i+"]//*[contains(text(), '"+standardOperationsName+"')]")).isDisplayed()) {
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
