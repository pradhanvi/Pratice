package scm.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.commons.TestBase;

public class CreateReceiptAccountingDistribution extends TestBase {
					
	@FindBy(xpath="//td[contains(@id,'requestHeader:cf8')]")
	public WebElement CreateReceiptAccountingDistribution_Name;
	
	@FindBy(xpath="//input[contains(@id,'basicReqBody:paramDynForm_ATTRIBUTE1_ATTRIBUTE1::content')]")
	public WebElement BillToBusinessUnit;
	
	@FindBy(xpath="//div[contains(@id,'requestBtns:submitButton')]")
	public WebElement SubmitButton;
	
	
	
	

}
