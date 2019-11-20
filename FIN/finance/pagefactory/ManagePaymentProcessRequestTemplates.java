package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ManagePaymentProcessRequestTemplates extends TestBase {
	
	@FindBy(xpath="//a[contains(text(),'Actions')]")
	public WebElement ActionBtn;
	
	@FindBy(xpath="//td[contains(text(),'Create')]")
	public WebElement CreateBtn;
	
	//General Information Details
	
	@FindBy(xpath="//label[text()='Name']//parent::td//parent::tr//td[2]//input")
	public WebElement NameTextBox;
	
	@FindBy(xpath="//select[contains(@id,'selectOneChoice10')]")
	public WebElement TypeDropDown;
	
	@FindBy(xpath="//label[text()='Description']//parent::td//parent::tr//td[2]//textarea")
	public WebElement DescriptionTextBox;
	
	//Selection Criteria Details
	
	@FindBy(xpath="/input[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_payments:0:MAnt2:2:ap1:inputText5::content']")
	public WebElement PayThroughDaysTextBox;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_payments:0:MAnt2:2:ap1:inputText6::content']")
	public WebElement FromPaymentPriorityTextBox	;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_payments:0:MAnt2:2:ap1:inputText7::content']")
	public WebElement ToPaymentPriorityTextBox;
	
	@FindBy(xpath="//div[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_payments:0:MAnt2:2:ap1:PayGroupRadio::content']//label[@class='x2l'][contains(text(),'All')]")
	public WebElement PayGroupsRadioBtn;
	
	@FindBy(xpath="//div[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_payments:0:MAnt2:2:ap1:CurrencyGroupRadio::content']//label[@class='x2l'][contains(text(),'All')]")
	public WebElement CurrenciesRadioBtn;
	
	
	//Payment and Processing Options Tab
	
	@FindBy(xpath="//div[contains(@id,'ti')]//a[contains(text(),'Payment and Processing Options')]")
	public WebElement PaymentAndProcessingOption;
	
	@FindBy(xpath="//input[@placeholder='dd/mmm/yyyy']")
	public WebElement PaymentDateRadioBtn;
	
	@FindBy(xpath="//label[text()='Disbursement Bank Account']//parent::td//parent::tr//td[2]//input")
	public WebElement DisbursementBankAccountTextBox;
	
	@FindBy(xpath="//label[text()='Payment Conversion Rate Type']//parent::td//parent::tr//td[2]//input")
	public WebElement PaymentConversionType;
	
	@FindBy(xpath="//select[contains(@id,'PaymentDocumentId::content')]")
	public WebElement PaymentDocumentDropDown;
	
	@FindBy(xpath="//input[contains(@id,'paymentProfileNameId::content')]")
	public WebElement PaymentProcessProfileTextBox ;
	
	@FindBy(xpath="//div[contains(@id,'cl2')]")
	public WebElement SaveAndCloseBtn ;
	
	@FindBy(xpath="//div[contains(text(),'changes were saved')]")
	public WebElement Message_Information;
	
	@FindBy(xpath="//button[contains(@id,'msgDlg::cancel')]")
	public WebElement OK_Information ;
	
	//MessageBox after Clicking Save and Close Button
	
	@FindBy(xpath="//div[@class='p_AFInfo xkc af_messages_dialog']")
	public WebElement SavedMsgValidation ;
	
	@FindBy(xpath="//button[contains(@id,'msgDlg::cancel')]")
	public WebElement SavedMsgOKBTN ;
	
	//Submit Payment Process Request
	
	@FindBy(xpath="//a[contains(text(),'Submit Payment Process Request')]")
	public WebElement SubmitPaymentProcessRequestIcon;
	
	@FindBy(xpath="//input[contains(@id,'inputText1')]")
	public WebElement PPRName;
	
	@FindBy(xpath="//a[@accesskey ='m']")
	public WebElement SubmitBtn;
	
	//After Submission
	
	@FindBy(xpath="//div[@class='p_AFConfirmation xkc af_messages_dialog']")
	public WebElement SubmissionConf;
	
	@FindBy(xpath="//button[contains(@id, '::msgDlg::cancel')]")
	public WebElement ConfOkBtn;
	
	public ManagePaymentProcessRequestTemplates() {
		PageFactory.initElements(driver, this);
	}
	
	//Manage Payments
	
	@FindBy(xpath="//a[contains(text(),'Manage Payments')]")
	public WebElement ManagePayments;
	
	@FindBy(xpath="//input[contains(@id,'value20::content')]")
	public WebElement PaymentNumber;
	
	@FindBy(xpath="//button[contains(@id,'search')]")
	public WebElement PaymentNumberSearchBtn;
	
	@FindBy(xpath="//a[contains(text(),'Actions')]")
	public WebElement VoidActionBtn;
	
	@FindBy(xpath="//td[contains(text(),'Void')]")
	public WebElement VoidBtn;
	
	//Voiding the Payment
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_payments:0:MAnt2:1:AP1:AT1:inputDate6::content']")
	public WebElement VoidDate;
	
	@FindBy(xpath="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_payments:0:MAnt2:1:AP1:AT1:inputDate6::content']")
	public WebElement AccountingDate;
	
	@FindBy(xpath="//button[contains(@id,'dialog1::ok')]")
	public WebElement VoidSubmitBtn;
	
	//Manage
	
	
}
