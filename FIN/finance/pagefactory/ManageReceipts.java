package finance.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.commons.TestBase;

public class ManageReceipts extends TestBase{

	
	@FindBy(xpath = "//label[@class='af_query_criterion::label-text' and contains(text(), 'Receipt Number')]/../parent::tr//input")
	public WebElement ReceiptNumber;
	
	@FindBy(xpath = "//button[contains(@id, 'search')]")
	public WebElement SearchButton;
	
	
	@FindBy(xpath = "//input[contains(@id, 'customerAccountNumberId')]")
	public WebElement CustomerAccNumber;
	
	@FindBy(xpath = "//input[contains(@id, 'customerAccountNameId')]")
	public WebElement CustomerName;
	
	@FindBy(xpath = "//div[contains(@id, 'showDetailItem2::ti')]//a[text()='Application']")
	public WebElement ApplicationTab;
	
	@FindBy(xpath = "//button[contains(., 'Add Application')]")
	public WebElement AddApplicationButton;
	
	@FindBy(xpath = "//a[contains(@id, 'trxNumberList::lovIconId')]")
	public WebElement TransactionNum_SearchIcon;
	
	@FindBy(xpath = "//label[text()='Transaction Number']//parent::td/parent::tr//input")
	public WebElement TransactionNumber;
	
	@FindBy(xpath = "//div[contains(@id, 'trxNumberList_afrLovInternalTableId::db')]/table/tbody//tr//tr")
	public List<WebElement> tableRows_SearchAndSelect;
	
	@FindBy(xpath = "//button[contains(@id, 'trxNumberList::lovDialogId::ok')]")
	public WebElement SearchAndSelect_OKBtn;
	
	@FindBy(xpath = "//input[contains(@id, 'AmtApplied')]")
	public WebElement AppliedAmount;
	
	@FindBy(xpath = "//input[contains(@id, 'inputDate9')]")
	public WebElement ApplicationDate; //Date Format should be DD/MMM/YYYY
	
	@FindBy(xpath = "//input[contains(@id, 'AccountingDate')]")
	public WebElement AccountingDate; //Date Format should be DD/MMM/YYYY
	
	@FindBy(xpath = "//button[. = 'Save and Close']")
	public WebElement SaveAndClose_Btn;
	
	@FindBy(xpath = "//span[contains(@id, 'acctdAmountId')]")
	public WebElement AccountedAmount;
	
	@FindBy(xpath = "//label[text()='Total Applied Amount']//parent::td/parent::tr//span[contains(@id, 'FOSritemNode_receivables_receivables_balances')]")
	public WebElement TotalAmountApplied;
	
	@FindBy(xpath = "//a[text()='View']")
	public WebElement ViewButton;
	
	@FindBy(xpath = "//table[@summary='Search Results']/tbody/tr[1]//td[4]")
	public WebElement Status;
	
	@FindBy(xpath = "//h1[contains(text(),'Manage Receipts')]")
	public WebElement ManageReceipts_Header;
	
	
	public ManageReceipts() {
		PageFactory.initElements(driver, this);
		log.info("ManageReceipts initiated...");
	}
	
	/**
	 * Description: This methods Verify the Search Record exists or not
	 * @param SearchInputValue It can be Receipt Number
	 * @return
	 */
	public boolean clickSearchedRecord(String SearchValue, String strColumnLabelText) {
		try {
			int HeaderLabelColNo = 0;
			List<WebElement> TableRowsHeaders = driver.findElements(By.xpath("//table[@summary='This table contains column headers corresponding to the data body table below']/tbody/tr"));
			for (int i = 0; i < TableRowsHeaders.size(); i++) {
				List<WebElement> TableHeaders = driver.findElements(By.xpath("//table[@summary='This table contains column headers corresponding to the data body table below']/tbody/tr["+(i+1)+"]/th"));
				System.out.println("Col Count: "+TableHeaders.size());
				for (int j = 0; j < TableHeaders.size(); j++) {
					String strText = TableHeaders.get(j).getText();
//					System.out.println("Header-Row: "+i+1+" --- Header-Col: "+(j+1)+" StrText: "+strText);
					if(strText != null && !strText.isEmpty() && strText.equalsIgnoreCase(strColumnLabelText)) {
						HeaderLabelColNo = j+1;
						break;
					}
				}
			}
			
			List<WebElement> TableRows = driver.findElements(By.xpath("//table[@summary='Search Results']/tbody/tr"));
			System.out.println("No Of Rows: "+TableRows.size());

			for (int i = 0; i <= TableRows.size(); i++) {
//				if(driver.findElement(By.xpath("//table[@summary='Search Results']/tbody/tr["+i+"]//*[contains(text(), '"+SearchInputValue+"')]")).isDisplayed()) {
				if(cmnLib.waitForElementToBeVisible(driver.findElement(By.xpath("//table[@summary='Search Results']/tbody/tr["+(i+1)+"]/td["+HeaderLabelColNo+"]")))) {
					String strText = driver.findElement(By.xpath("//table[@summary='Search Results']/tbody/tr["+(i+1)+"]/td["+HeaderLabelColNo+"]")).getText();
					System.out.println("strTextDataRowValue: "+strText);
					if(strText!=null && strText.length() > 0 && strText.equalsIgnoreCase(SearchValue)) {
						driver.findElement(By.xpath("//table[@summary='Search Results']/tbody/tr["+(i+1)+"]/td[1]")).click();
						driver.findElement(By.xpath("//table[@summary='Search Results']/tbody/tr["+(i+1)+"]//a[text()='"+SearchValue+"']")).click();
						cmnLib.waitForPageLoaded();
						log.info("Clicked the Receipt Number of Row#: "+(i+1));
						return true;
					}
					
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			log.info("Searched Record could not be Selected");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean isCustomerNameExists() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.attributeToBeNotEmpty(CustomerName, "value"));
			System.out.println("CustomerName: "+CustomerName.getAttribute("value"));
			if(CustomerName.getAttribute("value").length() > 0) {
				log.info("Customer Name Exists");
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Exception: isCustomerNameExists");
		}
		return false;
	}
	
	public boolean searchAndSelectTransactionNum(String strTransactionNumber) {
		try {
			Thread.sleep(3000);
			int iRowSize = tableRows_SearchAndSelect.size();
			System.out.println("No. of Rows: " + iRowSize);
			if (iRowSize > 0) {
				for (WebElement row : tableRows_SearchAndSelect) {
					WebElement rowData = row.findElement(By.xpath("td[1]"));
					System.out.println(rowData.getText());
					if (rowData.getText().equalsIgnoreCase(strTransactionNumber)) {
						// WebElement rowItem = nameElement.findElement(By.xpath("//parent:td"));
						cmnLib.clickOnWebElement(rowData);
						log.info("Selected Transaction Num: " + strTransactionNumber);
						return true;
					}
				}
			} else {
				log.info("No Transaction Num Records found");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Unable to select Transaction Num");
		}
		return false;
	}
	
	private double getAccountedAmount() {
		double i = 0;
		if(cmnLib.waitForElementToBeVisible(AccountedAmount)) {
			System.out.println("AccountedAmount: "+AccountedAmount.getText());
			System.out.println("AccountedAmountLength: "+AccountedAmount.getText().length());
			String strAmt = AccountedAmount.getText().trim();
			i = Double.parseDouble(strAmt);
//			i = Integer.parseInt(strAmt);
			System.out.println("Accounted Amount: "+i);
		}
		return i;
	}
	
	private double getTotalAppliedAmount() {
		double i = 0;
		if(cmnLib.waitForElementToBeVisible(TotalAmountApplied)) {
			System.out.println("TotalAppliedAmount: "+TotalAmountApplied.getText());
			System.out.println("TotalAppliedAmount Length: "+TotalAmountApplied.getText().length());
			String strAmt = TotalAmountApplied.getText().trim();
			i = Double.parseDouble(strAmt);
			System.out.println("Total Amount Applied: "+i);
		}
		return i;
	}
	
	public double verifyAccounted_And_TotalAppliedAmount() throws InterruptedException {
		Thread.sleep(2000);
		double diff = getAccountedAmount() - getTotalAppliedAmount();
		if(diff == 0) {
			return 0;
		}
		return diff;
	}
	
	public boolean mouseHoverClickAfterClickOnActionButton(String strMenuName) {
		boolean clicked = false;
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='AFPopupMenuPopup']")));
			WebElement menu = driver.findElement(By.xpath("//div[@class='AFPopupMenuPopup']//td[text()='"+strMenuName+"']"));
			Actions actions = new Actions(driver);
			
			actions.moveToElement(menu);
			actions.click().build().perform();
			log.info("Mouse Hover and Click successful");
			clicked = true;
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Mouse Hover and Click not successful");
		}
		return clicked;
	}
	
	/**
	 * Description: This methods Verify the Search Record exists or not
	 * @param SearchInputValue It can be Receipt Number
	 * @return
	 */
	public String getColumnDataValueInSearchTable(String strColumnLabelText) {
		try {
			int HeaderLabelColNo = 0;
			List<WebElement> TableRowsHeaders = driver.findElements(By.xpath("//table[@summary='This table contains column headers corresponding to the data body table below']/tbody/tr"));
			for (int i = 0; i < TableRowsHeaders.size(); i++) {
				List<WebElement> TableHeaders = driver.findElements(By.xpath("//table[@summary='This table contains column headers corresponding to the data body table below']/tbody/tr["+(i+1)+"]/th"));
				System.out.println("Col Count: "+TableHeaders.size());
				for (int j = 0; j < TableHeaders.size(); j++) {
					String strText = TableHeaders.get(j).getText();
//					System.out.println("Header-Row: "+i+1+" --- Header-Col: "+(j+1)+" StrText: "+strText);
					if(strText != null && !strText.isEmpty() && strText.equalsIgnoreCase(strColumnLabelText)) {
						HeaderLabelColNo = j+1;
						break;
					}
				}
			}
			
			List<WebElement> TableRows = driver.findElements(By.xpath("//table[@summary='Search Results']/tbody/tr"));
			System.out.println("No Of Rows: "+TableRows.size());

			for (int i = 0; i <= TableRows.size(); i++) {
//				if(driver.findElement(By.xpath("//table[@summary='Search Results']/tbody/tr["+i+"]//*[contains(text(), '"+SearchInputValue+"')]")).isDisplayed()) {
				if(cmnLib.waitForElementToBeVisible(driver.findElement(By.xpath("//table[@summary='Search Results']/tbody/tr["+(i+1)+"]/td["+HeaderLabelColNo+"]")))) {
					String strText = driver.findElement(By.xpath("//table[@summary='Search Results']/tbody/tr["+(i+1)+"]/td["+HeaderLabelColNo+"]")).getText().trim();
					System.out.println("strColumnDataValue: "+strText);
					return strText;
					
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			log.info("Could not get the Value of the Column from Search Table");
			e.printStackTrace();
		}
		return null;
	}
}
