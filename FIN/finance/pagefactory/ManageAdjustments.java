package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ManageAdjustments extends TestBase{
	
	@FindBy (xpath = "//img[contains(@id, 'create::icon')]")
	public WebElement CreateRecordIcon;
	
	@FindBy (xpath = "//label[@class='af_panelLabelAndMessage_label-text' and contains(text(), 'Receivables Activity')]/../parent::tr//input")
	public WebElement ReceivablesActivity;
	
	@FindBy (xpath = "//label[@class='af_panelLabelAndMessage_label-text' and contains(text(), 'Adjustment Type')]/../parent::tr//select")
	public WebElement AdjustmentType;
	
	@FindBy (xpath = "//label[@class='af_panelLabelAndMessage_label-text' and contains(text(), 'Adjustment Amount')]/../parent::tr//input")
	public WebElement AdjustmentAmount;
	
	@FindBy (xpath = "//label[@class='af_panelLabelAndMessage_label-text' and contains(text(), 'Adjustment Date')]/../parent::tr//input")
	public WebElement AdjustmentDate;
	
	@FindBy (xpath = "//label[@class='af_panelLabelAndMessage_label-text' and contains(text(), 'Accounting Date')]/../parent::tr//input")
	public WebElement AccountingDate;
	
	@FindBy (xpath = "//label[@class='af_panelLabelAndMessage_label-text' and contains(text(), 'Installment Number')]/../parent::tr//select")
	public WebElement InstallmentNumber;
	
	@FindBy (xpath = "//label[@class='af_panelLabelAndMessage_label-text' and contains(text(), 'Adjustment Reason')]/../parent::tr//select")
	public WebElement AdjustmentReason;
	
	@FindBy (xpath = "//button[@title='Save' and .='Submit']")
	public WebElement SubmitButton;
	
	@FindBy (xpath = "//div[contains(@class, 'p_AFInfo')]")
	public WebElement AdjustmentCofirmationDialog;
	
	@FindBy (xpath = "//div[contains(@class, 'p_AFInfo']//button[text()='OK']")
	public WebElement AdjustmentCofirmationDialog_OKBtn;
	
	
	public ManageAdjustments() {
		PageFactory.initElements(driver, this);
		log.info("ManageAdjustments initiated...");
	}
	
	public String getDigitsFromString(String strTextContainingDigits) {
		try {
			strTextContainingDigits = strTextContainingDigits.replaceAll("\\D+", "");
//			System.out.println("strTextContainingDigits output: "+strTextContainingDigits);
			return strTextContainingDigits;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Exception: getDigitsFromString");
		}
		return null;
	}

}
