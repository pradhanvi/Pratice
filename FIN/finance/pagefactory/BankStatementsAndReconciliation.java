package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class BankStatementsAndReconciliation extends TestBase{
	
	@FindBy(xpath = "//img[@title='Tasks']")
	public WebElement TasksPane;
	
	@FindBy(xpath = "//a[text()='Create Bank Statement']")
	public WebElement CreateBankStatement;
	
	@FindBy(xpath = "//a[text()='Manage Bank Statements']")
	public WebElement ManageBankStatements;
	
	@FindBy(xpath = "//a[text()='Load and Import Bank Statement']")
	public WebElement LoadAndImportBankStatement;
	
	@FindBy(xpath = "//a[text()='Submit Autoreconciliation']")
	public WebElement SubmitAutoreconciliation;
	
	@FindBy(xpath = "//a[text()='Manual Reconciliation']")
	public WebElement ManualReconciliation;
	
	@FindBy(xpath = "//a[text()='Create Transaction']")
	public WebElement CreateTransaction;
	
	@FindBy(xpath = "//a[text()='Manage Transactions']")
	public WebElement ManageTransactions;
	
	@FindBy(xpath = "//a[text()='Create Accounting']")
	public WebElement CreateAccounting;
	
	@FindBy(xpath = "//a[text()='Bank Statement Report']")
	public WebElement BankStatementReport;
	
	@FindBy(xpath = "//a[text()='Cash to General Ledger Reconciliation Report']")
	public WebElement CashToGeneralLedgerReconciliationReport;
	
	@FindBy(xpath="//h1[text()='Bank Statement Reconciliation']")
	public WebElement BankStatementsReconciliationPage;
	
	@FindBy(xpath="//h1[text()='Create External Transaction']")
	public WebElement CreateExternalTransactionPage;
	
	@FindBy(xpath="//label[text()='Bank Account']/parent::td/parent::tr//input")
	public WebElement BankAccount;
	
	@FindBy(xpath="//label[text()='Business Unit']/parent::td/parent::tr//input")
	public WebElement BusinessUnit;
	
	@FindBy(xpath="//label[text()='Amount']/parent::td/parent::tr//input")
	public WebElement Amount;
	
	@FindBy(xpath="//label[text()='Date']/parent::td/parent::tr//input")
	public WebElement Date;
	
	@FindBy(xpath="//select[contains(@id,'::content')]")
	public WebElement TransactionType;
	
	@FindBy(xpath="//label[text()='Description']/parent::td/parent::tr//textarea")
	public WebElement DescriptionTextArea;
	
	@FindBy(xpath="//label[text()='Cash Account']/parent::td/parent::tr//input")
	public WebElement CashAccount;
	
	@FindBy(xpath="//label[text()='Offset Account']/parent::td/parent::tr//input")
	public WebElement OffsetAccount;
	
	@FindBy(xpath="//span[text()='Save and Close']")
	public WebElement SaveAndCloseBtn;
	
	@FindBy(xpath="//h1[text()='Create Bank Statement']")
	public WebElement CreateBankStatementPage;
	
	@FindBy(xpath="//label[text()='Period Start Date']/parent::td/parent::tr//input")
	public WebElement PeriodStartDate;
	
	@FindBy(xpath="//label[text()='Period End Date']/parent::td/parent::tr//input")
	public WebElement PeriodEndDate;
	
	@FindBy(xpath="//label[text()='Statement ID']/parent::td/parent::tr//input")
	public WebElement StatementID;
	
	@FindBy(xpath="//div[contains(@id,':cbsshowDetailItem2::ti')]//a[text()='Statement Lines']")
	public WebElement StatementLines;
	
	@FindBy(xpath="//img[contains(@id,':create::icon')]")
	public WebElement AddStatementLine;
	
	@FindBy(xpath="//label[text()='Booking Date']/parent::td/parent::tr//input")
	public WebElement BookingDate;
	
	@FindBy(xpath="//label[text()='Transaction Code']/parent::td/parent::tr//input")
	public WebElement TransactionCode;
	
	@FindBy(xpath="//select[contains(@id,'selectOneChoice3::content')]")
	public WebElement FlowIndicator;
	
	@FindBy(xpath="//button[text()='O']")
	public WebElement OKBtn;
	
	@FindBy(xpath="//button[text()='ave and Close']")
	public WebElement SaveAndCloseBtnTrans;
	
	@FindBy(xpath="//div[text()='Confirmation']")
	public WebElement ConfirmationDialogBox;
	
	@FindBy(xpath="//td[@id='_FOd1::msgDlg::_fcc']/button[text()='OK']")
	public WebElement OKBtnConfirmation;
	
	@FindBy(xpath="//div[text()='Warning']")
	public WebElement WarningDailog;
  
	@FindBy(xpath="//label[text()='From Statement End Date']/parent::td/parent::tr//input")
	public WebElement FromStatementEndDate;
	
	@FindBy(xpath="//label[text()='To Statement End Date']/parent::td/parent::tr//input")
	public WebElement ToStatementEndDate;
	
	@FindBy(xpath="//span[text()='Sub']")
	public WebElement SubmitBtn;
	
	@FindBy(xpath="//button[contains(@id,'confirmationPopup:confirmSubmitDialog::ok')]")
	public WebElement ConfirmSubmitDialog_Ok;
	
	@FindBy(xpath="//div[contains(@id,'mrreconcileSearchBtn')]")
	public WebElement SearchBtn;
	
	@FindBy(xpath="//div[contains(@id,'mrreconciled::ti')]//a[text()='Reconciled']")
	public WebElement ReconciledLink;
	
	@FindBy(xpath="//div[text()='No results found.']")
	public WebElement NoResultFound;
	
	@FindBy(xpath="//label[contains(@id,'mrselectBooleanCheckbox2::Label0')]")
	public WebElement CheckBox_Unreconciled;
	
	@FindBy(xpath="//button[text()='Unreconcile']")
	public WebElement Unreconcile;
	
	
	public BankStatementsAndReconciliation() {
		PageFactory.initElements(driver, this);
		log.info("Bank Statements and Reconciliation page is initialized...");
		
	}
	
}
