package scm.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ManageWorkCenters extends TestBase{
	
	@FindBy(xpath="//h1[contains(@class,'xmt')]")
	public WebElement ManageWorkCentersHeader;
	
	@FindBy(xpath="//img[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:AT1:_ATp:create::icon']")
	public WebElement AddManageWorkCenters;
	
	@FindBy(xpath="//h1[contains(@class,'xmt')]")
	public WebElement CreateWorkCenterHeader;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt3:0:AP1:it2::content']")
	public WebElement WorkCenters_Name;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt3:0:AP1:it1::content']")
	public WebElement WorkCenters_Code;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt3:0:AP1:workAreaTransientId::content']")
	public WebElement WorkCenters_WorkArea;
	
	@FindBy(xpath="//img[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt3:0:AP1:AT1:_ATp:create::icon']")
	public WebElement AddResourceAvailability;
	
	@FindBy(xpath="//input[@name='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt3:0:AP1:AT1:nameId']")
	public WebElement Resource_Name;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt3:0:AP1:AT1:it5::content']")
	public WebElement Planning_Utilization;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt3:0:AP1:AT1:it6::content']")
	public WebElement Planning_Efficiency;
	
	/*@FindBy(xpath="//div[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt3:0:AP1:AT1:ctb2']//a[@class='xw8']")
	public WebElement OKButton_WorkCentersResource;*/
	
	@FindBy(xpath="//td/div/a/span[contains(text(),'O')]")
	public WebElement OKButton_WorkCentersResource;
	
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt3:0:AP1:AT1:it4::content']")
	public WebElement DefaultUnitsAvailable;
	
	@FindBy(xpath="//span[contains(text(),'ave and Close')]")
	public WebElement Save_WorkCenters;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:it2::content']")
	public WebElement WorkCenters_SeachName;
	
	@FindBy(xpath="//button[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:ci1']")
	public WebElement WorkCenters_SearchButton;
	
	@FindBy(xpath="")
	public WebElement abc4;
	
	@FindBy(xpath="")
	public WebElement abc5;
	
	@FindBy(xpath="")
	public WebElement abc6;
	
	
	public ManageWorkCenters() {
		PageFactory.initElements(driver, this);
		log.info("ManageWorkArea is initialized");
	}
	
	public boolean verifySearchedRecordExists(String workCenterName) {
		boolean exists = false;
		try {
			
			List<WebElement> TableRows = driver.findElements(By.xpath("//table[@summary='Search Results']/tbody/tr"));
			System.out.println("No Of Rows in Search Results Table: "+TableRows.size());
			if(TableRows.size() > 0) {
				for (int i = 1; i <= TableRows.size(); i++) {
					if(driver.findElement(By.xpath("//table[@summary='Search Results']/tbody/tr["+i+"]//*[contains(text(), '"+workCenterName+"')]")).isDisplayed()) {
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
