package hcm.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class SetupAndMaintenance extends TestBase {
	
	@FindBy(xpath="//img[@title='Tasks']")
	public WebElement TasksIcon;
	
	@FindBy(xpath="//a[text()='Search']")
	public WebElement SearchAction;
	
	@FindBy(xpath="//input[contains(@id,'content')]")
	public WebElement SearchBar;
	
	@FindBy(xpath="//img[@title='Search']")
	public WebElement SearchIcon;
	
	@FindBy(xpath="//h1[text()='Manage Salary Basis']")
	public WebElement ManageSalaryBasisHeader;
	
	@FindBy(xpath="//span[text()='Create']")
	public WebElement CreateIcon;
	
	@FindBy(xpath="//h3[text()='Create Salary Basis ']")
	public WebElement CreateSalaryBasisHeader;
	
	@FindBy(xpath="//h3[contains(text(),'Edit Salary Basis')]")
	public WebElement EditSalaryBasisHeader;
	
	@FindBy(xpath="//label[text()='Name']/parent::td/parent::tr//input")
	public WebElement SalaryBasisName;
	
	@FindBy(xpath="//label[text()='Code']/parent::td/parent::tr//input")
	public WebElement Code;
	
	@FindBy(xpath="//label[text()='Status']/parent::td/parent::tr//input[@type='text']")
	public WebElement Status;
	
	@FindBy(xpath="//label[text()='Legislative Data Group']/parent::td/parent::tr//input")
	public WebElement LegislativeDataGroup;
	
	@FindBy(xpath="//label[text()='Salary Basis Type']/parent::td/parent::tr//input[@type='text']")
	public WebElement SalaryBasisType;
	
	@FindBy(xpath="//label[text()='Frequency']/parent::td/parent::tr//input[@type='text']")
	public WebElement Frequency;
	
	@FindBy(xpath="//label[text()='Annualization Factor']/parent::td/parent::tr//input")
	public WebElement AnnualizationFactor;
	
	@FindBy(xpath="//label[text()='Payroll Element']/parent::td/parent::tr//input")
	public WebElement PayrollElement;
	
	@FindBy(xpath="//label[text()='Input Value']/parent::td/parent::tr//input")
	public WebElement InputValue;
	
	@FindBy(xpath="//button[text()='ave and Close']")
	public WebElement SaveAndCloseButton;
	
	@FindBy(xpath="//button[text()='Search']")
	public WebElement SearchButton;
	
	@FindBy(xpath="//label[text()='Name']/parent::td/parent::tr//input")
	public WebElement Search_Name;
	
	@FindBy(xpath="//a[contains(@id,'appPanel:basisType::drop')]")
	public WebElement SalaryBasisType_Dropdown;
	
	@FindBy(xpath="//a[contains(@id,'appPanel:basisCode::drop')]")
	public WebElement Frequency_Dropdown;
	
	@FindBy(xpath="//span[text()='Delete']")
	public WebElement DeleteIcon;
	
	@FindBy(xpath="//div[text()='Warning']")
	public WebElement WarningPopUp;
	
	@FindBy(xpath="//button[text()='Yes']")
	public WebElement Yes_WarningPOPup;
	
/*****************************************Manage Actions***********************************************/
	
	@FindBy(xpath="//h1[text()='Manage Actions']")
	public WebElement ManageActionsPage;
	
	@FindBy(xpath="//div[contains(@_afrac,'ATp:table1')]//div[@title='Add']")
	public WebElement Add_Action;
	
	@FindBy(xpath="//label[text()='Action Code']/..//input")
	public WebElement Action_Code;
	
	@FindBy(xpath="//label[text()='Action Name']/..//input")
	public WebElement Action_Name;
	
	@FindBy(xpath="//label[text()='Start Date']/..//input")
	public WebElement Start_Date;
	
	@FindBy(xpath="//label[text()='End Date']/..//input")
	public WebElement End_Date;
	
	@FindBy(xpath="//label[text()='Action Type']/..//a")
	public WebElement Action_Type_Dropdown;
	
	@FindBy(xpath="//button[text()='Save']")
	public WebElement Save_Actions;
	
	@FindBy(xpath="//div[contains(@id,'msgDlg::_ttxt') and text()='Error']")
	public WebElement Error;
							 
	@FindBy(xpath="//td[contains(@id,'dialog5::_hce')]//div[text()='Warning']")
	//@FindBy(xpath="//div[@id='pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:0:AP1:dialog5::_ttxt']")
	public WebElement Warning_Action;
	
	@FindBy(xpath="//td[contains(@id,'dialog5::_fce')]//button[text()='Yes']")
	public WebElement Warning_Action_Yes;
	
	@FindBy(xpath="//label[text()=' Action Code']/../input")
	public WebElement ActionCode_Search;
	
	@FindBy(xpath="//label[text()=' Effective Date']/../input")
	public WebElement EffectiveDate_Search;
	
	@FindBy(xpath="//span[text()='D']")
	public WebElement Actions_Done;
	
	@FindBy(xpath="//div[text()='Confirmation']")
	public WebElement Confimation_Message;
	
	@FindBy(xpath="//a[text()='Manage Actions']")
	public WebElement ManageActionsLink;
	
	@FindBy(xpath="//table[@summary='Action']//tr/td[1]")
	public WebElement SelectSearchedResult;
	
	@FindBy(xpath="//div[contains(@id,':panelBox1')]//img[@title='Add']")
	public WebElement Add_ActionsReasons;
	
	@FindBy(xpath="//label[text()='Action Reason Code']/..//input")
	public WebElement ActionReasonCode;
	
	@FindBy(xpath="//label[text()='Action Reason']/..//input")
	public WebElement ActionReason;
	
	@FindBy(xpath="//label[text()='Reason Start Date']/..//input")
	public WebElement ReasonStartDate;
	
	@FindBy(xpath="//label[text()='Reason End Date']/..//input")
	public WebElement ReasonEndDate;
	
	@FindBy(xpath="//button[text()='O']")
	public WebElement OK_ActionsReason;
	
	@FindBy(xpath="//td[contains(@id,'dialog3::_hce')]//div[text()='Warning']")
	public WebElement ActionReasons_Warning;
	
	@FindBy(xpath="//td[contains(@id,'dialog3::_fce')]//button[text()='Yes']")
	public WebElement ActionReason_Yes;
	
	@FindBy(xpath="//h1[text()='Manage Action Reasons']")
	public WebElement ManagActionReasonsPage;
	
	@FindBy(xpath="//div[contains(@_afrac,'ATp:table2')]//div[@title='Add']")
	public WebElement AddActionReason;
	
	@FindBy(xpath="//a[text()='Manage Action Reasons']")
	public WebElement ManageActionReasonLink;
	
	
	
	@FindBy(xpath="//td[contains(@id,'d1::_hce')]//div[text()='Warning']")
	public WebElement Warning_ActionReasons;
	
	@FindBy(xpath="//td[contains(@id,'d1::_fce')]//button[text()='Yes']")
	public WebElement Warning_ActionReasons_Yes;
	
/*****************************************Manage Default Cost Profile********************************************************************************/
	
	@FindBy(xpath="//h1[text()='Manage Default Cost Profiles']")
	public WebElement ManageDefaultCostProfilesPage;
	
	@FindBy(xpath="//label[text()='Cost Organization']/parent::td/parent::tr//input")
	public WebElement CostOrganization;
	
	@FindBy(xpath="//label[text()='Category Name']/parent::td/parent::tr//input")
	public WebElement CategoryName;
	
	@FindBy(xpath="//label[text()='Cost Book']/parent::td/parent::tr//input")
	public WebElement CostBook;
	
	@FindBy(xpath="//button[text()='Search']")
	public WebElement SearchBtn;
	
	@FindBy(xpath="//div[text()='No results found.']")
	public WebElement NoResultsFound;

	
	
	public boolean verifySearchedRecordExists(String SalaryName) {
		boolean exists = false;
		try {
			List<WebElement> TableRows = driver.findElements(By.xpath("//table[@summary='Salary Basis']/tbody/tr"));
			System.out.println("No Of Rows in Search Results Table: "+TableRows.size());
			if(TableRows.size() > 0) {
				for (int i = 1; i <= TableRows.size(); i++) {
					if(driver.findElement(By.xpath("//table[@summary='Salary Basis']/tbody/tr["+i+"]//*[contains(text(), '"+SalaryName+"')]")).isDisplayed()) {
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
	
	public boolean SelectInputComboBox(String strAction) {
	try {
		driver.findElement(By.xpath("//li[contains(text(),'"+strAction+"')]")).isDisplayed();
		driver.findElement(By.xpath("//li[contains(text(),'"+strAction+"')]")).click();
		log.info("Action: "+strAction+" Selected Page exists");
		return true;
	} catch (Exception e) {
		// TODO: handle exception
		log.info("Action: "+strAction+" Selected Page does not exist");
	}
	return false;
	}
	
	public boolean ClickOnSearchedResults() {
		boolean exists = false;
		try {
			List<WebElement> TableRows = driver.findElements(By.xpath("//div[@id='dcc:j_id7:tbl::db']/table/tbody/tr"));
			System.out.println("No Of Rows in Search Results Table: "+TableRows.size());
			if(TableRows.size() > 0) {
				for (int i = 1; i <= TableRows.size(); i++) {
					if(driver.findElement(By.xpath("//div[@id='dcc:j_id7:tbl::db']/table/tbody/tr["+i+"]/td[1]")).isDisplayed() && i==1) {
						driver.findElement(By.xpath("//div[@id='dcc:j_id7:tbl::db']/table/tbody/tr["+i+"]/td[1]")).click();
						exists = true;
						log.info("Searched Person Number record exists");
						break;
						}
					}
				}else {
					log.info("TableRows row count is less than zero !!");
				}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Searched Person Number record does not exist");
			e.printStackTrace();
		}
		return exists;
	}
	
	
	
	public SetupAndMaintenance()
	{
		PageFactory.initElements(driver, this);
		log.info("Setup And Maintenance is intialised");
	}
	
	

}
