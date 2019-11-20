package finance.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class CreditTransaction extends TestBase{
	
	@FindBy (xpath = "//h1[contains(text(),'Credit Transaction')]")
	public WebElement CreditTransaction_Header;
					 
	@FindBy(xpath = "//span[contains(@id, 'trxNumber1Id')]/ancestor::tr[1]//input")
	public WebElement Original_Transaction_Number;
					
	@FindBy(xpath = "//tr[contains(@id, 'businessunit')]/td[2]")
	public WebElement BusinessUnitDisplayed;

	@FindBy(xpath = "//label[text()='Transaction Source']/ancestor::tr[1]//input")
	public WebElement Transaction_Source;
	
	@FindBy(xpath = "//label[text()='Transaction Type']/ancestor::tr[1]//input")
	public WebElement Transaction_Type;
	
	@FindBy(xpath = "//label[text()='Transaction Number']/ancestor::tr[1]//input")
	public WebElement Transaction_Number;
	
	@FindBy(xpath = "//label[text()='Comments']/ancestor::tr[1]//textarea")
	public WebElement Comments;
								  
	@FindBy(xpath = "//table[@summary='Transaction Amounts']//tr[1]/td[3]//input")
	public WebElement LineCreditPercentage;
	
	@FindBy (xpath = "//a[contains(.,'Save')]")
	public WebElement Save;
	
	@FindBy (xpath = "//div[@class='p_AFError xkc af_messages_dialog']")
	public WebElement ErrorDialog;
	
	@FindBy (xpath = "//div[@class='p_AFError xkc af_messages_dialog']//button[text()='OK']")
	public WebElement ErrorDialogOKButton;
							
	@FindBy (xpath = "//a[contains(@id, 'CompleteandClose::popEl')]")
	public WebElement CompleteAndCloseArrow;
	
	@FindBy (xpath = "//td[contains(text(),'Complete and Review')]")
	public WebElement CompleteAndReview;
	
	@FindBy (xpath = "//a[@title='Search: Number']")
	public WebElement TrxNumber_SearchIcon;
	
	@FindBy(xpath = "//div[contains(@id, 'trxNumber1Id_afrLovInternalTableId::db')]//tr//tr")
	public List<WebElement> tableRows_SearchAndSelectName;
	
	public CreditTransaction() {
		PageFactory.initElements(driver, this);
		log.info("CreditTransaction initiated...");
	}
	public void isBusinessUnitValueDisplayed() {
		try {
			if(cmnLib.waitForElementToBeVisible(BusinessUnitDisplayed)) {
				log.info("Business Unit Value is displayed");
				System.out.println("Business Unit Value is: "+BusinessUnitDisplayed.getAttribute("text"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Business Unit Value is not displayed");
		}
	}
	
	@FindBy(xpath ="//div[contains(@id, 'trxNumber1Id_afrLovInternalTableId::db')]/ancestor::div[7]//label[text()='Transaction Source']/ancestor::tr[1]//input")
	public WebElement TrxSource_SearchAndSelect;
	
	@FindBy(xpath ="//div[contains(@id, 'trxNumber1Id_afrLovInternalTableId::db')]/ancestor::div[7]//label[text()='Transaction Number']/ancestor::tr[1]//input")
	public WebElement TrxNumber_SearchAndSelect;
	
	@FindBy(xpath ="//div[contains(@id, 'trxNumber1Id_afrLovInternalTableId::db')]/ancestor::div[7]//button[text()='Search']")
	public WebElement SearchBtn_SearchAndSelect;
	
	@FindBy(xpath ="//div[contains(@id, 'trxNumber1Id_afrLovInternalTableId::db')]/ancestor::div[7]//button[text()='OK']")
	public WebElement OKBtn_SearchAndSelect;
	
	public boolean searchAndSelectTrxNum(String strTrxNumber, String strTrxSource) {
		boolean flag = false;
		try {
			Thread.sleep(3000);
			//Enter Trx Source
			if(!cmnLib.enterDataInTextBox(TrxSource_SearchAndSelect, strTrxSource, true)) {
				System.err.println("Could not enter Transaction Source in Search And Select Original Transaction Number Popup");
				return false;
			}
			Thread.sleep(2000);
			if(!cmnLib.enterDataInTextBox(TrxNumber_SearchAndSelect, strTrxNumber, true)) {
				System.err.println("Could not enter Transaction Number in Search And Select Original Transaction Number Popup");
				return false;
			}
			Thread.sleep(1000);
			if(!cmnLib.clickOnWebElement(SearchBtn_SearchAndSelect)) {
				System.err.println("Could not click on Search Button in Search And Select Original Transaction Number Popup");
				return false;
			}
			Thread.sleep(3000);
			cmnLib.waitForPageLoaded();
			
			int iRowSize = tableRows_SearchAndSelectName.size();
			System.out.println("No. of Rows: " + iRowSize);
			if (iRowSize > 0) {
				for (WebElement row : tableRows_SearchAndSelectName) {
					WebElement rowData1 = row.findElement(By.xpath("td[1]"));
					System.out.println(rowData1.getText());
					String td1 = rowData1.getText().trim();
					
					WebElement rowData2 = row.findElement(By.xpath("td[2]"));
					System.out.println(rowData2.getText());
					String td2 = rowData2.getText().trim();
					
					if (td1.equalsIgnoreCase(strTrxNumber) && td2.equalsIgnoreCase(strTrxSource)) {
						cmnLib.clickOnWebElement(rowData1);
						flag = true;
						log.info("Selected " + strTrxNumber);
						break;
					}
				}
			} else {
				log.info("No Reports found");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Unable to select Transaction Number");
		}
		return flag;
	}
}
