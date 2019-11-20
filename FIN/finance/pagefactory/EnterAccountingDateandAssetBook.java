package finance.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class EnterAccountingDateandAssetBook extends TestBase {
	@FindBy(xpath ="//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:ap1:r1:basicReqBody:paramDynForm_ATTRIBUTE1_ATTRIBUTE1::content']")
	public WebElement AccountingDate;
	
	@FindBy(id="_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:ap1:r1:basicReqBody:paramDynForm_ATTRIBUTE2_ATTRIBUTE2::content")
	public WebElement AssetBook;
	
	@FindBy(xpath="//a[@title='Navigator']")
	public WebElement NavigatorIcon;
	
	
	public EnterAccountingDateandAssetBook() {
		PageFactory.initElements(driver, this);
		}
	
	/*public boolean EnterDate(String AcctDate) {
		boolean enter=false;
		try {
			System.out.print(AcctDate);
			Date.sendKeys("02/feb/2019");
			log.info("Date is Entered");
			enter=true;
		} catch (Exception e) {
			log.info("Date is not Entered");
	}
		return enter;
		
}*/
	
	/*public boolean SelectAssetbook(String AssetBook) {
		
		boolean enter=false;
		
		try {
			Select mySelect = new  Select(driver.findElement(By.id("_FOpt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:ap1:r1:basicReqBody:paramDynForm_ATTRIBUTE2_ATTRIBUTE2::content")));
			mySelect.selectByVisibleText(AssetBook);
			log.info("Asset Book Entered");
			enter=true;
		} catch (Exception e) {
			log.info("Asset Book couldn't be Entered");
			
		}
		return enter;
		
	}*/
	
	
	public boolean SubmitheInvoice() {
		boolean Submit = false;
		WebElement SubmissionOkbtn = driver.findElement(By.id("_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:ap1:r1:requestBtns:confirmationPopup:confirmSubmitDialog::ok"));
		
		cmnLib.clickOnWebElement(SubmissionOkbtn);
		Submit = true;
		return Submit;
		}
	
	//FIN_PERU_AP010 - Confirmation Button
	
	public boolean SubmitokBtn() {
		boolean Submit = false;
		WebElement SubmitClickOkbtn = driver.findElement(By.id("pt1:USma:0:MAnt1:0:pt1:r1:0:r1:requestBtns:confirmationPopup:confirmSubmitDialog::ok"));
		cmnLib.clickOnWebElement(SubmitClickOkbtn);
		Submit = true;
		return Submit;
		}
	
	//FIN_PERU_AP013 - Confirmation Button
	
	public boolean ClickOnOKBtn() {
		boolean Submit = false;
		WebElement SubmissionOkbtn = driver.findElement(By.id("_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:ap1:r1:requestBtns:confirmationPopup:confirmSubmitDialog::ok"));
		cmnLib.clickOnWebElement(SubmissionOkbtn);
		Submit = true;
		return Submit;
		}
	
	

	

}
