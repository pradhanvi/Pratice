package scm.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ManageResource extends TestBase{
	
	@FindBy(xpath="//h1[contains(@class,'xmt')]")
	public WebElement ManageResourceHeader;
							 
	@FindBy(xpath="//img[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:AT2:_ATp:create::icon']")
	public WebElement AddNewResourceButton;
	
	@FindBy(xpath="//div[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:AT2:d1::_ttxt']")
	public WebElement CreateResourceHeader;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:AT2:r1:0:it2::content']")
	public WebElement Resource_Name;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:AT2:r1:0:it1::content']")
	public WebElement Resource_Code;
	
	@FindBy(xpath="//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:AT2:r1:0:soc2::content']")
	public WebElement Resource_Type;

	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:AT2:r1:0:unitOfMeasureTransientId::content']")
	public WebElement Resource_UsageUOM;
	
	@FindBy(xpath="//span[contains(text(),'ave and Close')]")
	public WebElement Resource_Save;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:it2::content']")
	public WebElement Resource_SearchName;
	
	@FindBy(xpath="//button[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:ci1']")
	public WebElement Resource_SearchButton;
	
	@FindBy(xpath="")
	public WebElement abc5;
	
	@FindBy(xpath="")
	public WebElement abc6;
	
	
	 
	public ManageResource() {
		PageFactory.initElements(driver, this);
		log.info("Manage Resource is initialized");
	}
	
	public boolean verifySearchedRecordExists(String resourceName) {
		boolean exists = false;
		try {
			
			List<WebElement> TableRows = driver.findElements(By.xpath("//table[@summary='Search Results']/tbody/tr"));
			System.out.println("No Of Rows in Search Results Table: "+TableRows.size());
			if(TableRows.size() > 0) {
				for (int i = 1; i <= TableRows.size(); i++) {
					if(driver.findElement(By.xpath("//table[@summary='Search Results']/tbody/tr["+i+"]//*[contains(text(), '"+resourceName+"')]")).isDisplayed()) {
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
