package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class CreateTransaction extends TestBase{

	@FindBy (xpath = "//a[contains(.,'Save')]")
	public WebElement Save;
	
	@FindBy (xpath = "//a[contains(.,'Complete and Review')]")
	public WebElement CompleteAndReview;
	
	@FindBy (xpath = "//h1[contains(text(),'Create Transaction')]")
	public WebElement CreateTransaction_Header;
	
	@FindBy (xpath = "//div[contains(@id,'commandToolbarButton2')]")
	public WebElement Cancel;
	
	@FindBy (xpath = "//td[contains(text(),'changes will be lost')]")
	public WebElement Message_Warning;
	
	@FindBy (xpath = "//button[contains(@id,'dialogCancel::yes')]")
	public WebElement Yes_Warning;	
				   
	@FindBy (xpath = "//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_receivables_billing:0:MAnt2:1:pt1:MTF1:2:pt1:TCF:0:ap1:batchSourceId::content']")
	public WebElement Transaction_Source;
					  
	@FindBy (xpath = "//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_receivables_billing:0:MAnt2:1:pt1:MTF1:2:pt1:TCF:0:ap1:inputText2::content']")
	public WebElement Transaction_Number;
									
	@FindBy (xpath = "//div[@class='p_AFError xkc af_messages_dialog']")
	public WebElement ErrorDialog;
	
	@FindBy (xpath = "//div[@class='p_AFError xkc af_messages_dialog']//button[text()='OK']")
	public WebElement ErrorDialogOKButton;
	
	public CreateTransaction() {
		PageFactory.initElements(driver, this);
		log.info("CreateTransaction is initiated...");
	}
}
