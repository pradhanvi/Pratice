package finance.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ManageTransactions extends TestBase {
	
	@FindBy (xpath = "//h1[contains(text(),'Manage Transactions')]")
	public WebElement ManageTransactions_Header;

	@FindBy(xpath = "//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_receivables_billing:0:MAnt2:1:pt1:MTF1:0:ap1:q1:value10::content']")
	public WebElement Transaction_Source;

	@FindBy(xpath = "//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_receivables_billing:0:MAnt2:1:pt1:MTF1:0:ap1:q1:value40::content']")
	public WebElement Transaction_Number;

	@FindBy(xpath = "//input[@id='pt1:_FOr1:1:_FOSritemNode_receivables_billing:0:MAnt2:1:pt1:MTF1:0:ap1:q1:value50::content']")
	public WebElement Transaction_Date; // Date should be in dd/mmm/yyyy format

	@FindBy(xpath = "//input[@id='pt1:_FOr1:1:_FOSritemNode_receivables_billing:0:MAnt2:1:pt1:MTF1:0:ap1:q1:value60::content']")
	public WebElement Bill_To_Customer;

	@FindBy(xpath = "//label[text()='Business Unit']//parent::td//parent::tr//td[2]//input")
	public WebElement BusinessUnit;

	@FindBy(xpath = "//label[text()='Transaction Source']//parent::td//parent::tr//td[2]//input")
	public WebElement TransactionSource;

	@FindBy(xpath = "//label[text()='Transaction Number']//parent::td//parent::tr//td[2]//input")
	public WebElement TransactionNumber;

	@FindBy(xpath = "//button[text()='Search']")
	public WebElement Search;

	@FindBy(xpath = "//table[@summary='Search Results']/tbody")
	public WebElement table_SearchResults;
	
	@FindBy(xpath = "//table[@summary='Search Results']//parent::div[contains(text(),'No results found')]")
	public WebElement table_NoResults;

	public ManageTransactions() {
		PageFactory.initElements(driver, this);
		log.info("ManageTransactions is initiated...");
	}

	/**
	 * Description: This methods Verify the Search Record exists or not
	 * 
	 * @param SearchInputValue
	 *            It can be
	 *            Transaction_Source/Transaction_Number/Transaction_Date/Bill_To_Customer
	 * @return
	 */
	public ReviewTransaction clickSearchedRecord(String SearchInputValue) {
		try {
			List<WebElement> TableRows = driver.findElements(By.xpath("//table[@summary='Search Results']/tbody/tr"));
			System.out.println("No Of Rows: " + TableRows.size());

			for (int i = 1; i <= TableRows.size(); i++) {
				if (driver.findElement(By.xpath("//table[@summary='Search Results']/tbody/tr[" + i
						+ "]//*[contains(text(), '" + SearchInputValue + "')]")).isDisplayed()) {
					log.info("Searched Person Record Exists");
					driver.findElement(By.xpath("//table[@summary='Search Results']/tbody/tr[" + i
							+ "]//a[contains(text(), '" + SearchInputValue + "')]")).click();
					log.info("Searched Record is Selected");

					// table[@summary='Search Results']/tbody/tr[1]/td[3]//a
					// **** Assuming that Transaction Number column exists in col# 3
					driver.findElement(By.xpath("//table[@summary='Search Results']/tbody/tr[" + i + "]/td[3]//a"))
							.click();
					cmnLib.waitForPageLoaded();
					log.info("Clicked the Transaction Number of Row#: " + i);
					return PageFactory.initElements(driver, ReviewTransaction.class);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			log.info("Searched Record could not be Selected");
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * public int verifyHeaderColumnNumber(String ColumnName) { int result = 0; try
	 * { //Header Table List<WebElement> TableHeaderRows = driver.findElements(By.
	 * xpath("//table[@summary='This table contains column headers corresponding to the data body table below']/tbody/tr"
	 * )); System.out.println("No Of Rows: "+TableHeaderRows.size());
	 * 
	 * for (int i = 1; i <= TableHeaderRows.size(); i++) { List<WebElement>
	 * colHeaderName = TableHeaderRows.get(i).findElements(By.tagName("th")); for
	 * (int j = 0; j < colHeaderName.size(); j++) { String header =
	 * colHeaderName.get(j).getAttribute("text"); if(header.length() > 0 &&
	 * header.equalsIgnoreCase(ColumnName)) {
	 * System.out.println("Found Col: "+ColumnName+" in td: "+j); return j; } } }
	 * 
	 * } catch (Exception e) { // TODO: handle exception } return result; }
	 */

	public boolean clickTransactionNumberInResults(String strTransactionNumber) {
		boolean flag = false;

		try {
			WebElement element = driver.findElement(By.xpath(
					"//table[@summary='Search Results']/tbody/tr//td[5]//a[text()='" + strTransactionNumber + "']"));
			element.click();
			flag = true;
			log.info("Clicked Transaction Number in Results");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to click Transaction Number in Results");
		}
		return flag;
	}
}
