package scm.pagefactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ScheduledProcesses extends TestBase {

	@FindBy(xpath = "//a//span[text()='Schedule New Process']")
	public WebElement ScheduleNewProcess;

	@FindBy(id = "pt1:USma:0:MAnt1:0:pt1:panel:processRefreshId::icon")
	public WebElement Refresh;

	@FindBy(id = "pt1:USma:0:MAnt1:0:pt1:srRssdfl:value00::content")
	public WebElement Name;

	@FindBy(xpath = "//label[text()='Process ID']//parent::td//parent::tr//td[2]//input")
	public WebElement ProcessID;

	@FindBy(xpath = "//label[text()='Process ID']//parent::td//parent::tr//td[2]//select")
	public WebElement ProcessID_select;

	@FindBy(xpath = "//label[text()='Delete Analysis Data']//parent::td//parent::tr//td[2]//select")
	public WebElement DeleteAnalysisData_select;

	@FindBy(xpath = "//button[text()='Search']")
	public WebElement Submit;

	@FindBy(xpath = "//table[contains(@summary,'List of Processes')]")
	public WebElement table_ScheduleNewProcess;

	@FindBy(xpath = "//div[@id='pt1:USma:0:MAnt1:0:pt1:panel:result::db']//tr//tr")
	public List<WebElement> tableRows_ScheduleNewProcess;

	@FindBy(id = "pt1:USma:0:MAnt1:0:pt1:srRssdfl::_afrDscl")
	public WebElement Search_ExpandCollapse;

	@FindBy(xpath = "//span[contains(text(),'Schedule New Process')]")
	public WebElement ScheduleNewProcesses;

	@FindBy(xpath = "//a[@id='pt1:USma:0:MAnt1:0:pt1:selectOneChoice2::lovIconId']")
	public WebElement NameDropdown;

	@FindBy(xpath = "//a[@id='pt1:USma:0:MAnt1:0:pt1:selectOneChoice2::dropdownPopup::popupsearch']")
	public WebElement Search;

	@FindBy(xpath = "//input[contains(@id,'afrLovInternalQueryId:value00::content')]")
	public WebElement ProcessName;

	@FindBy(xpath = "//button[contains(@id,'afrLovInternalQueryId::search')]")
	public WebElement SearchName;

	@FindBy(xpath = "//td[contains(text(),'Prepare Receivables to General Ledger Reconciliati')]")
	public WebElement SearchResult;

	@FindBy(xpath = "//button[contains(@id,'selectOneChoice2::lovDialogId::ok')]")
	public WebElement OkBtn;

	@FindBy(xpath = "//button[@id='pt1:USma:0:MAnt1:0:pt1:snpokbtnid']")
	public WebElement OkButton;

	@FindBy(xpath = "//div[contains(@id,'requestBtns:submitButton')]")
	public WebElement SubmitBtn;

	@FindBy(xpath = "//button[@id='pt1:USma:0:MAnt1:0:pt1:r1:0:r1:requestBtns:confirmationPopup:confirmSubmitDialog::ok']")
	public WebElement OkConfirmation;
	
/************Create Accounting********************************/
	
	@FindBy(xpath="//label[text()='Subledger Application']/parent::td/parent::tr//select")
	public WebElement SubledgerApplication;
	
	@FindBy(xpath="//a[@id='pt1:_UIScml21']")
	public WebElement ScheduledProcessesHeader;
	
	@FindBy(xpath="//div[@id='pt1:USma:0:MAnt1:0:pt1:r1:0:r1:requestBtns:submitButton']//a")
	public WebElement Para_Submit;
	
	@FindBy(xpath="//label[text()='Ledger']/parent::td/parent::tr//input")
	public WebElement Ledger_CA;
	
	@FindBy(xpath="//label[text()='End Date']/parent::td/parent::tr//input")
	public WebElement EndDate_CA;
	
	@FindBy(xpath="//label[text()='Accounting Mode']/parent::td/parent::tr//select")
	public WebElement AccountingMode;
	
	@FindBy(xpath="//label[text()='Process Events']/parent::td/parent::tr//select")
	public WebElement ProcessEvents;
	
	@FindBy(xpath="//label[text()='Report Style']/parent::td/parent::tr//select")
	public WebElement ReportStyle;
	
	@FindBy(xpath="//label[text()='Transfer to General Ledger']/parent::td/parent::tr//select")
	public WebElement TransfertoGeneralLedger;
	
	@FindBy(xpath="//label[text()='Post in General Ledger']/parent::td/parent::tr//select")
	public WebElement PostinGeneralLedger;
	
	@FindBy(xpath="//label[text()='Include User Transaction Identifiers']/parent::td/parent::tr//select")
	public WebElement IncludeUserTransactionIdentifiers;
	
	
	/**************************************************************************************************************
	 * Parameters
	 *************************************************************************************************************/
		@FindBy(xpath="//input[@id='pt1:USma:0:MAnt1:0:pt1:r1:0:r1:basicReqBody:paramDynForm_BusinessUnit::content']")
		public WebElement Para_BusinessUnit;
		
		@FindBy(xpath="//input[@id='pt1:USma:0:MAnt1:0:pt1:r1:0:r1:basicReqBody:paramDynForm_ATTRIBUTE2::content']")
		public WebElement Para_NoOfChildWorkers;
		
		@FindBy(xpath="//input[@id='pt1:USma:0:MAnt1:0:pt1:r1:0:r1:basicReqBody:paramDynForm_ATTRIBUTE3::content']")
		public WebElement Para_ImportAsOfDate;
	/*					//div[@id='pt1:USma:0:MAnt1:0:pt1:r1:0:r1:requestBtns:submitButton']//a
		@FindBy(xpath="//div[@id='pt1:USma:0:MAnt1:0:pt1:r1:0:r1:requestBtns:submitButton']//a")
		public WebElement Para_Submit;*/
		
		@FindBy(xpath="//input[@id='pt1:USma:0:MAnt1:0:pt1:r1:0:r1:basicReqBody:paramDynForm_PlantCode::content']")
		public WebElement Para_Organization;
		
		@FindBy(xpath="//input[@id='pt1:USma:0:MAnt1:0:pt1:r1:0:r1:basicReqBody:paramDynForm_SourceSystemCode::content']")
		public WebElement Para_SourceSystem;
		
		@FindBy(xpath="//input[@id='pt1:USma:0:MAnt1:0:pt1:r1:0:r1:basicReqBody:paramDynForm_Attribute1::content']")
		public WebElement Para_Cost_Organization;
		
		@FindBy(xpath="//input[@id='pt1:USma:0:MAnt1:0:pt1:r1:0:r1:basicReqBody:paramDynForm_Attribute3_ATTRIBUTE3::content']")
		public WebElement Para_CommitLimit;
		
		@FindBy(xpath="//input[@id='pt1:USma:0:MAnt1:0:pt1:r1:0:r1:basicReqBody:paramDynForm_ATTRIBUTE2_ATTRIBUTE2::content']")
		public WebElement Para_CutOffDate;

	public ScheduledProcesses() {
		PageFactory.initElements(driver, this);
	}

	public String verifyReportStatus(String strProcessID, String strReportName) {
		String returnStatus = null;
		boolean bool = false;

		try {

			if (!(strProcessID.matches("\\d+"))) {
				System.out.println("Process ID not captured from the confirmation Message");
				if (!cmnLib.clickOnWebElement(Refresh)) {
					System.err.println("Unable to Click the Refresh Button in Scheduled Processes");
					return returnStatus;
				}
				TimeUnit.SECONDS.sleep(3);
				if (cmnLib.waitForElementToBeVisible(table_ScheduleNewProcess)) {
					int iRowSize = tableRows_ScheduleNewProcess.size();
					System.out.println("Total Number of Results: " + iRowSize);
					if (iRowSize > 0) {
						for (WebElement row : tableRows_ScheduleNewProcess) {
							String Name = row.findElement(By.xpath("td[1]")).getText();
							System.out.println("Report Name: " + Name);
							if (Name.equalsIgnoreCase(strReportName)) {
								System.out.println("Report Name Matched: " + Name);
								String ID = row.findElement(By.xpath("td[2]")).getText();
								return verifyReportStatus(ID, Name);
							}
						}
						log.info("Report Name not found in Results");
					} else {
						log.info("No rows found");
					}
				} else {
					log.info("Scheduled Processes table not found");
				}
			}

			if (cmnLib.waitForElementToBeVisible(Search_ExpandCollapse)
					&& Search_ExpandCollapse.getAttribute("title").equalsIgnoreCase("Expand Search")) {
				cmnLib.clickOnWebElement(Search_ExpandCollapse);
				cmnLib.waitForPageLoaded();
				TimeUnit.SECONDS.sleep(1);
			}
			cmnLib.enterDataInTextBox(ProcessID, strProcessID, false);
			cmnLib.clickOnWebElement(Submit);
			// cmnLib.clickOnWebElement(Refresh);

			while (!bool) {
				TimeUnit.SECONDS.sleep(3);
				if (cmnLib.waitForElementToBeVisible(table_ScheduleNewProcess)) {
					int iRowSize = tableRows_ScheduleNewProcess.size();
					System.out.println("Number of Results: " + iRowSize);
					if (iRowSize > 0) {
						for (WebElement row : tableRows_ScheduleNewProcess) {
							String ID = row.findElement(By.xpath("td[2]")).getText();
							if (ID.equalsIgnoreCase(strProcessID)) {
								System.out.println("Process ID Matched: " + ID);
								String Status = row.findElement(By.xpath("td[3]")).getText();
								System.out.println("Status of the Report: " + Status);
								if (Status.equalsIgnoreCase("Succeeded") || Status.equalsIgnoreCase("Error")
										|| Status.equalsIgnoreCase("Warning") || Status.equalsIgnoreCase("Canceled")) {
									bool = true;
									returnStatus = Status;
									log.info("Status changed to Succeeded/Error");
								} else {
									TimeUnit.SECONDS.sleep(3);
									log.info("Wait complete before refresh");
									cmnLib.clickOnWebElement(Refresh);
									break;
								}
							}
						}
					} else {
						log.info("No Reports found");
					}
				} else {
					log.info("Scheduled Processes table not found");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Unable to verify report status");
		}
		return returnStatus;

	}

	// to Run in Final Mode : AP013

	public String InvFverifyReportStatus(int iFProcessID) {
		String returnStatus = null;
		boolean bool = false;
		try {
			Thread.sleep(3000);
			while (!bool) {
				int iRowSize = tableRows_ScheduleNewProcess.size();
				System.out.println("Number of Rows: " + iRowSize);
				if (iRowSize > 0) {
					for (WebElement row : tableRows_ScheduleNewProcess) {
						int ID = Integer.parseInt(row.findElement(By.xpath("td[2]")).getText());
						if (ID == iFProcessID) {
							System.out.println("Process ID Matched: " + ID);
							String Status = row.findElement(By.xpath("td[3]")).getText();
							System.out.println("Status of the Report: " + Status);
							if (Status.equalsIgnoreCase("Succeeded") || Status.equalsIgnoreCase("Error")
									|| Status.equalsIgnoreCase("Warning") || Status.equalsIgnoreCase("Completed")
									|| Status.equalsIgnoreCase("Wait")) {
								bool = true;
								returnStatus = Status;
								log.info("Status changed to Succeeded/Error");
								break;
							} else {
								Thread.sleep(5000);
								log.info("Wait complete for 5 seconds");
								cmnLib.clickOnWebElement(Refresh);
								break;
							}
						}
					}

				} else {
					log.info("No Reports found");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Unable to verify report status");
		}
		return returnStatus;

	}

	// to Run in Final Mode : AP022

	public String FverifyReportStatus(int iFProcessID) {
		String returnStatus = null;
		boolean bool = false;
		try {
			Thread.sleep(3000);
			while (!bool) {
				int iRowSize = tableRows_ScheduleNewProcess.size();
				System.out.println("Number of Rows: " + iRowSize);
				if (iRowSize > 0) {
					for (WebElement row : tableRows_ScheduleNewProcess) {
						int ID = Integer.parseInt(row.findElement(By.xpath("td[2]")).getText());
						if (ID == iFProcessID) {
							System.out.println("Process ID Matched: " + ID);
							String Status = row.findElement(By.xpath("td[3]")).getText();
							System.out.println("Status of the Report: " + Status);
							if (Status.equalsIgnoreCase("Succeeded") || Status.equalsIgnoreCase("Error")
									|| Status.equalsIgnoreCase("Warning")) {
								bool = true;
								returnStatus = Status;
								log.info("Status changed to Succeeded/Error");
								break;
							} else {
								Thread.sleep(5000);
								log.info("Wait complete for 5 seconds");
								cmnLib.clickOnWebElement(Refresh);
								break;
							}
						}
					}

				} else {
					log.info("No Reports found");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Unable to verify report status");
		}
		return returnStatus;

	}

	/******************************************************************************************************************
	 * Schedule New Process
	 *******************************************************************************************************************/
	@FindBy(id = "pt1:USma:0:MAnt1:0:pt1:selectOneChoice2::lovIconId")
	public WebElement NameDropdown_ScheduleNewProcess;

	@FindBy(id = "pt1:USma:0:MAnt1:0:pt1:selectOneChoice2::dropdownPopup::popupsearch")
	public WebElement Search_ScheduleNewProcess;

	@FindBy(id = "pt1:USma:0:MAnt1:0:pt1:snpokbtnid")
	public WebElement OK_ScheduleNewProcess;

	@FindBy(xpath = "//label[text()='Name']//parent::td//parent::tr//td[2]//input")
	public WebElement Name_Input_ScheduleNewProcess;

	/******************************************************************************************************************
	 * Search and Select Name
	 *******************************************************************************************************************/
	@FindBy(id = "pt1:USma:0:MAnt1:0:pt1:selectOneChoice2::_afrLovInternalQueryId:value00::content")
	public WebElement Name_SearchAndSelectName;

	@FindBy(id = "pt1:USma:0:MAnt1:0:pt1:selectOneChoice2::_afrLovInternalQueryId::search")
	public WebElement SearchButton_SearchAndSelectName;

	@FindBy(xpath = "//div[@id='pt1:USma:0:MAnt1:0:pt1:selectOneChoice2_afrLovInternalTableId::db']//tr//tr")
	public List<WebElement> tableRows_SearchAndSelectName;

	@FindBy(id = "pt1:USma:0:MAnt1:0:pt1:selectOneChoice2::lovDialogId::ok")
	public WebElement OK_SearchAndSelectName;

	@FindBy(xpath = "//a[contains(@id,'selectOneChoice2')]")
	public WebElement Name_SearchAndSelectNamedropdwn;

	@FindBy(xpath = "//input[contains(@id,'afrLovInternalQueryId:value00::content')]")
	public WebElement Aftersearc_Name;

	@FindBy(xpath = "//button[contains(@id,'afrLovInternalQueryId::search')]")
	public WebElement Aftersearc_search;

	@FindBy(xpath = "//button[contains(@id,'lovDialogId::ok')]")
	public WebElement Aftersearc_ok_Rptname;

	@FindBy(xpath = "//button[contains(@id,'snpokbtnid')]")
	public WebElement Aftersearc_ok_Last;

	public boolean selectReportName_SearchAndSelectName(String strReportName) {
		boolean flag = false;
		try {
			Thread.sleep(3000);
			int iRowSize = tableRows_SearchAndSelectName.size();
			System.out.println("No. of Rows: " + iRowSize);
			if (iRowSize > 0) {
				for (WebElement row : tableRows_SearchAndSelectName) {
					WebElement rowData = row.findElement(By.xpath("td[1]"));
					System.out.println(rowData.getText());
					if (rowData.getText().equalsIgnoreCase(strReportName)) {
						// WebElement rowItem = nameElement.findElement(By.xpath("//parent:td"));
						cmnLib.clickOnWebElement(rowData);
						flag = true;
						log.info("Selected " + strReportName);
						break;
					}
				}
			} else {
				log.info("No Reports found");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Unable to select Report Name");
		}
		return flag;
	}

	/******************************************************************************************************************
	 * Process Details
	 *******************************************************************************************************************/
	@FindBy(id = "pt1:USma:0:MAnt1:0:pt1:r1:0:r1:basicReqBody:paramDynForm_Attribute1_ATTRIBUTE1::content")
	public WebElement AssetBook_Dropdown;

	@FindBy(id = "pt1:USma:0:MAnt1:0:pt1:r1:0:r1:basicReqBody:paramDynForm_Attribute2_ATTRIBUTE2::content")
	public WebElement FromPeriod;

	@FindBy(xpath = "//label[text()='From Period']//parent::td//parent::tr//td[2]//select")
	public WebElement FromPeriod_select;

	@FindBy(id = "pt1:USma:0:MAnt1:0:pt1:r1:0:r1:basicReqBody:paramDynForm_Attribute3_ATTRIBUTE3::content")
	public WebElement ToPeriod;

	@FindBy(xpath = "//label[text()='To Period']//parent::td//parent::tr//td[2]//select")
	public WebElement ToPeriod_select;

	@FindBy(xpath = "//label[text()='Start Date']//parent::td//parent::tr//td[2]//input")
	public WebElement StartDate;

	@FindBy(xpath = "//label[text()='End Date']//parent::td//parent::tr//td[2]//input")
	public WebElement EndDate;

	@FindBy(id = "pt1:USma:0:MAnt1:0:pt1:r1:0:r1:requestBtns:submitButton")
	public WebElement Submit_ProcessDetails;

	/******************************************************************************************************************
	 * Process Details for AP023
	 *******************************************************************************************************************/

	@FindBy(xpath = "//input[contains(@id,'it1::content')]")
	public WebElement RequestName;

	@FindBy(xpath = "//select[contains(@id,'soc1::content')]")
	public WebElement Ledger;

	@FindBy(xpath = "//input[contains(@id,'businessunitId::content')]")
	public WebElement BusinessUnit;

	@FindBy(xpath = "//input[contains(@id,'aTTRIBUTE6Id::content')]")
	public WebElement AccountingPeriod;

	/******************************************************************************************************************
	 * Confirmation
	 *******************************************************************************************************************/
	@FindBy(id = "pt1:USma:0:MAnt1:0:pt1:r1:0:r1:requestBtns:confirmationPopup:confirmSubmitDialog::ok")
	public WebElement OK_Confirmation;

	@FindBy(xpath = "//span[@id='pt1:USma:0:MAnt1:0:pt1:r1:0:r1:requestBtns:confirmationPopup:pt_ol1']//label")
	public WebElement Message_Confirmation;
	
	
	
	/******************************************************************************************************************
	 * Submit a new request
	 *******************************************************************************************************************/
					
	@FindBy(xpath="//input[@id='pt1:USma:0:MAnt1:0:pt1:selectOneChoice2::_afrLovInternalQueryId:value00::content']")
	public WebElement Name_SearchScheduledNewProcess;
	
	@FindBy(xpath=" //a[@id='pt1:USma:0:MAnt1:0:pt1:selectOneChoice2::dropdownPopup::popupsearch']")
	public WebElement PopupSearchLink;
	
	@FindBy(xpath="//button[@id='pt1:USma:0:MAnt1:0:pt1:selectOneChoice2::_afrLovInternalQueryId::search']")
	public WebElement SearchButton;
	
	@FindBy(xpath="//button[@id='pt1:USma:0:MAnt1:0:pt1:selectOneChoice2::lovDialogId::ok']")
	public WebElement OkButton1;
	
	@FindBy(xpath="//button[@id='pt1:USma:0:MAnt1:0:pt1:snpokbtnid']")
	public WebElement OkButton2;
	
	@FindBy(xpath="//h1[contains(text(),'Basic Options')]")
	public WebElement ParametersPage;
	
	public boolean submitNewRequest(String strReportName)
	{
		boolean flag=false;
		cmnLib.clickOnWebElement(ScheduleNewProcess);
		cmnLib.waitForElementToBeVisible(NameDropdown_ScheduleNewProcess);
		cmnLib.clickOnWebElement(NameDropdown_ScheduleNewProcess);
		cmnLib.clickOnWebElement(PopupSearchLink);
		cmnLib.enterDataInTextBox(Name_SearchScheduledNewProcess, strReportName, false);
		cmnLib.clickOnWebElement(SearchButton);
		if(selectReportName_SearchAndSelectName(strReportName))
		{
			flag=true;
			cmnLib.clickOnWebElement(OkButton1);
			cmnLib.clickOnWebElement(OkButton2);
			log.info("Selected the request successfully");
		}
		
		
			
		return flag;
		
	}
}
