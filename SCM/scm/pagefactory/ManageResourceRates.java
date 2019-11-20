package scm.pagefactory;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ManageResourceRates extends TestBase {
	
	@FindBy(xpath="//h1[contains(@class,'xmt')]")	
	//@FindBy(id="_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt2:0:pt1:AP1:SPph")
	public WebElement ManageResourceRatesHeader;
	
	
	@FindBy(id="_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt2:0:pt1:AP1:AT1:_ATp:create::icon")
	public WebElement CreateResourceRatesIcon;
	
	@FindBy(id="_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt3:0:pt1:AP1:scenarioNumberId::content")
	public WebElement ScenarioField;
								
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt3:0:pt1:AP1:nameId::content']")
	public WebElement PlantField;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt3:0:pt1:AP1:resourceNameId::content']")
	public WebElement Resource;
				
	@FindBy(id="_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt3:0:pt1:AP1:AT1:_ATp:create::icon")
	public WebElement AddRates;
	
	@FindBy(xpath=" //input[@name='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt3:0:pt1:AP1:AT1:_ATp:ATt1:0:costElementCodeId']")
	public WebElement CostElement;
	
	@FindBy(xpath="//input[@name='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt3:0:pt1:AP1:AT1:_ATp:ATt1:0:expensePoolCodeId']")
	public WebElement ExpensePool;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt3:0:pt1:AP1:AT1:_ATp:ATt1:0:it3::content']")
	public WebElement Rates;
	
	@FindBy(xpath="//span[contains(text(),'Save')]")
	public WebElement SaveButton;
	
	@FindBy(xpath="//span[contains(text(),'ancel')]")
	public WebElement CancelButton;
	
	@FindBy(xpath="//div[@id='_FOd1::msgDlg::_ttxt']")
	public WebElement ErrorDialog;
	
	@FindBy(xpath="//button[@id='_FOd1::msgDlg::cancel']")
	public WebElement ErrorDialogOKButton;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_costing_cost_accounting:0:MAt2:0:pt1:AP1:qrr:value00::content']")
	public WebElement ScenarioSearchEle;
	
	@FindBy(xpath="//button[contains(@id,'search')]")
	public WebElement SearchButton;
	
	//@FindBy(xpath="//h2[contains(text(),'08/6/19: Details')]")
	@FindBy(xpath="//h2[contains(text(),'Details')]")
	public WebElement Details;
	
	public ManageResourceRates() {
		PageFactory.initElements(driver, this);
		log.info("Manag eResource Rates page is Initialized...");
	}
	
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

	public void autosuggestBasedXpath(String webelemet_xpath,
			   String autosuggest_xpath, String search_data) throws Exception {
			  try {
			   WebElement optionsauto1 = driver.findElement(By
			     .xpath(webelemet_xpath));
			   optionsauto1.sendKeys(search_data);
			   /*Thread.sleep(2000);
			   while(isElementPresent(By.xpath(".//*[contains(@id,'_afrautosuggestbusydiv')]"))) {
			    Thread.sleep(2000);
			   }*/
			   Thread.sleep(6000);

			   List<WebElement> text1 = driver.findElement(By
			     .xpath(autosuggest_xpath)).findElements(By.tagName("li"));

			   // List<WebElement>
			   // text1=driver.findElements(By.tagName(autosuggest_xpath));
			   for (WebElement values : text1) {
			    System.out.println(values.getText());
			    if (values.getText().contains(search_data)) {
			     System.out.println("-------------------------");
			     System.out.println("Trying to Select : " + search_data);
			     values.click();
			    }
			   }
			  } catch (NoSuchElementException e) {
			   System.err.println("No such element :  " + e);
			   System.out.println(e.getStackTrace());

			  } catch (Exception e) {
			   System.err.println("Exception occured :  " + e);
			   System.out.println(e.getStackTrace());
			  }
			 }
}
