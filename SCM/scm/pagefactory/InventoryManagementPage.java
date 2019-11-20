package scm.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class InventoryManagementPage extends TestBase{
	
	@FindBy(xpath="//h1[text()='Inventory Management']")
	public WebElement InventoryManagementHeader;
	
	@FindBy(xpath="//img[@title='Tasks']")
	public WebElement TasksIcon;
	
	@FindBy(xpath="//select[contains(@id,':soc1::content')]")
	public WebElement TasksSelctionDropdown;
	
	@FindBy(xpath="//a[text()='Manage Cycle Counts']")
	public WebElement ManageCycleCounts;
	
	@FindBy(xpath="//div[text()='Select Organization']")
	public WebElement SelectOrgWindow;
	
	@FindBy(xpath="//label[text()='Organization']/parent::td/parent::tr//input")
	public WebElement Org;
	
	@FindBy(xpath="//button[text()='O']")
	public WebElement OrgWindowOKBtn;
	
	@FindBy(xpath="//label[text()='Count Name']/parent::td/parent::tr//input")
	public WebElement CountName;
	
	@FindBy(xpath="//button[text()='Search']")
	public WebElement SearchBtn;
	
	@FindBy(xpath="//a[text()='Actions']")
	public WebElement ActionsBtn;
	
	@FindBy(xpath="//td[text()='Generate Count Schedules']")
	public WebElement GenerateCountSchedules;
	
	@FindBy(xpath="//div[text()=' No results found.']")
	public WebElement NoResultFound;
	
	@FindBy(xpath="//div[text()='Information']")
	public WebElement InformationWindow;
	
	@FindBy(xpath="//div[@id='_FOd1::msgDlg::_cnt']/div/table/tbody/tr/td/table/tbody/tr/td[2]/div")
	public WebElement ConfirmationMsg;
	
	@FindBy(xpath="//td[@id='_FOd1::msgDlg::_fcc']/button[text()='OK']")
	public WebElement ConfirmationWinOKBtn;
	
	@FindBy(xpath="//td[text()='Generate Count Sequences']")
	public WebElement GenerateCountSequences;
	
	@FindBy(xpath="//td[text()='Record Count Sequences']")
	public WebElement RecordCountSequences;
	
	@FindBy(xpath="//h1[text()='Record Count Sequences ']")
	public WebElement RecordCountSequencesPageHeader;
	
	@FindBy(xpath="//div[text()='No results found.']")
	public WebElement NoResultFoundRecordCountPage;
	
	@FindBy(xpath="//input[contains(@id,'2:pt1:ap1:aT1:_ATp:rRd:1:tcQt::content')]")
	public WebElement CountQty;
	
	@FindBy(xpath="//input[contains(@id,'2:pt1:ap1:aT1:_ATp:rRd:1:ctBId::content')]")
	public WebElement CountedBy;
	
	@FindBy(xpath="//span[text()='Sub']")
	public WebElement SubmitBtn;
	
	@FindBy(xpath="//td[text()='Approve Count Sequences']")
	public WebElement ApproveCountSequences;
	
	@FindBy(xpath="//h1[text()='Approve Count Sequences']")
	public WebElement ApproveCountSequencesPageHeader;
	
	@FindBy(xpath="//input[contains(@id,'approvedById::content')]")
	public WebElement ReviewedBy;
	
	@FindBy(xpath="//table[@summary='Approve Count Sequences']//tr/td[5]/span")
	public WebElement CountSequenceStatus;
	
	@FindBy(xpath="//button[text()='Approve']")
	public WebElement ApproveBtn;
	
	@FindBy(xpath="//a[@aria-label='Expand Advanced Search']")
	public WebElement ExpandAdvancedSearch;
	
	@FindBy(xpath="//h1[text()='Manage Cycle Counts']")
	public WebElement ManageCycleCountsPageHeader;
	
	@FindBy(xpath="")
	public WebElement abc5;
	
	@FindBy(xpath="")
	public WebElement abc6;
	
	public InventoryManagementPage() {
		PageFactory.initElements(driver, this);
		log.info("InventoryManagementPage is initialized");
	}
	
	

}
