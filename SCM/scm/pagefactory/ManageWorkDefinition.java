package scm.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ManageWorkDefinition extends TestBase {
	
	@FindBy(xpath="//button[contains(text(),'ancel')]/span")
	public WebElement ManageWorkDefinitionHeader;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:qryId1:value00::content']")
	public WebElement Item_Search;
	
	@FindBy(xpath="//button[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:qryId1::search']")
	public WebElement SearchButton;
	
	/*@FindBy(xpath="//button[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt3:0:AP1:cb3']")
	public WebElement EditWindow_CancelButton;*/
	
	@FindBy(xpath="//button[contains(text(),'ancel')]/span")
	public WebElement EditWindow_CancelButton;
	
	@FindBy(xpath="//img[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:AT2:_ATp:create::icon']")
	public WebElement Add_WorkDefinition;
	
	@FindBy(xpath="//div[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:d1::_ttxt']")
	public WebElement CreateWorkDefinitionHeader;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:r1:0:r2:0:inputListOfValues2:lovTxtId::content']")
	public WebElement Item_WorkDefinition;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:r1:0:r2:0:soc3::content']")
	public WebElement Name_WorkDefinition;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:r1:0:r2:0:it1::content']")
	public WebElement Version_WorkDefinition;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:r1:0:r2:0:it11::content']")
	public WebElement ProductionPriority_WorkDefinition;
	
	/*@FindBy(xpath="//button[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:r1:0:r2:0:commandButton2']")
	public WebElement Next_WorkDefinition;*/
	
	@FindBy(xpath="//button[contains(text(),'Ne')]/span")
	public WebElement Next_WorkDefinition;
	
	/*@FindBy(xpath="//img[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:r1:0:r2:1:AT1:_ATp:create::icon']")
	public WebElement Add_Operations;*/
	
	@FindBy(xpath="//img[@title='Add Row']")
	public WebElement Add_Operations;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:r1:0:r2:1:AT1:_ATp:ATt1:0:it7::content']")
	public WebElement Sequence_WorkDefinition;
	
	@FindBy(xpath="//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:r1:0:r2:1:AT1:_ATp:ATt1:0:soc2::content']")
	public WebElement Operations_Type;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:r1:0:r2:1:AT1:_ATp:ATt1:0:it8::content']")
	public WebElement Name_Operations;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:r1:0:r2:1:AT1:_ATp:ATt1:0:soc1::content']")
	public WebElement WorkCenter_WorkDefinition;
	
	@FindBy(xpath="//button[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:r1:0:r2:1:commandButton2']")
	public WebElement Save_WorkDefinition;
	
	@FindBy(xpath="//button[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:qryId1::reset']")
	public WebElement Seach_Reset;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:qryId1:value10::content']")
	public WebElement Name_Search;
	
	@FindBy(xpath="//button[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt5:0:AP1:cb2']")
	public WebElement SaveCloseButton_Edit;
					
	@FindBy(xpath="//span[@id='_FOpt1:_FOr1:0:_FOSritemNode_manufacturing_work_definition:0:MAt2:0:AP1:r1:0:r2:1:AT1:_ATp:ATt1:0:sbc2']")
	public WebElement CountPointCheckbox;
	
	
	public ManageWorkDefinition()
	{
		PageFactory.initElements(driver, this);
		log.info("Manage Work Definition is intialised");
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
	
	public boolean selectingItem(String Item)
	{
		boolean exists = false;
try {
			
			List<WebElement> TableRows = driver.findElements(By.xpath("//table[@summary='Search Results']/tbody/tr"));
			System.out.println("No Of Rows in Search Results Table: "+TableRows.size());
			if(TableRows.size() > 0) {
				for (int i = 1; i <= TableRows.size(); i++) {
					if(driver.findElement(By.xpath("//table[@summary='Search Results']/tbody/tr["+i+"]//*[contains(text(), '"+Item+"')]")).isDisplayed() && i==1) {
						exists = true;
						cmnLib.clickOnWebElement(driver.findElement(By.xpath("//table[@summary='Search Results']/tbody/tr["+i+"]//td[4]//a")));
						log.info("Clicked on selected Item");
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
