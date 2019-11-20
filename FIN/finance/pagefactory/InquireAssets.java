package finance.pagefactory;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class InquireAssets extends TestBase {

	// @FindBy(xpath = "//table[@summary='Search Results']")
	// public List<WebElement> tableRows_Multiple;
	
	@FindBy(xpath = "//table[contains(@id,'pgl28')]")
	public WebElement table_FinancialDetails;

	@FindBy(xpath = "//table[contains(@id,'pgl28')]/tbody/tr/td[1]/div/table/tbody/tr")
	public WebElement tableRows_FinancialDetails;

	@FindBy(xpath = "//div[contains(@id,'t2::db')]/table")
	public WebElement table_Book;

	@FindBy(xpath = "//div[contains(@id,'t2::db')]/table//tr")
	public List<WebElement> tableRows_Book;

	@FindBy(xpath = "//table[@summary='Search Results: Depreciation Details']/tbody/tr//tr")
	public List<WebElement> tableRows_DepreciationDetails;

	@FindBy(xpath = "//table[@class='xw2 x1a']/tbody/tr/td[1]/div/table/tbody/tr")
	public WebElement FinancialDetails;

	@FindBy(xpath = "//td[contains(@id,'showDetailHeader2::_afrTtxt')]")
	public WebElement BookDetails_Header;

	@FindBy(xpath = "//div[contains(@id,'asIap:r1:0:pt1::tabh::cbc')]//a")
	public List<WebElement> BookDetails_Tabs;

	@FindBy(xpath = "//div[contains(@id,'asIap:SPb')]")
	public WebElement Done;

	@FindBy(xpath = "//span[text()='Transaction Number']//parent::div//preceding-sibling::div//a[@title='Sort Descending']")
	public WebElement TransactionNumber_SortDescending;

	@FindBy(xpath = "//div[contains(@id,'t4::db')]/table")
	public WebElement table_Transactions;

	@FindBy(xpath = "//div[contains(@id,'t4::db')]/table/tbody/tr//tr")
	public List<WebElement> tableRows_Transactions;

	public InquireAssets() {
		PageFactory.initElements(driver, this);
		log.info("Inquire Assets page is initialized...");
	}

	public boolean selectTab_BookDetails(String strTabName) {
		boolean flag = false;
		try {
			int iTabSize = BookDetails_Tabs.size();
			if (iTabSize > 0) {
				for (WebElement tab : BookDetails_Tabs) {
					if (tab.getText().equalsIgnoreCase(strTabName)) {
						System.out.println("Tab Name matched: " + strTabName);
						cmnLib.clickOnWebElement(tab);
						flag = true;
						log.info("Selected tab");
						break;
					}

				}
			} else {
				log.info("No Tabs found");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Unable to select Tab");
		}
		return flag;
	}

	public boolean selectBook(String strBook) {
		boolean flag = false;
		try {
			if (cmnLib.waitForElementToBeVisible(table_Book)) {
				int iRowSize = tableRows_Book.size();
				System.out.println("No. of Rows: " + iRowSize);
				if (iRowSize > 0) {
					for (WebElement row : tableRows_Book) {
						WebElement tableDataBook = row.findElement(By.xpath("td[1]"));
						String Book = tableDataBook.getText();
						System.out.println(Book);
						if (Book.equalsIgnoreCase(strBook)) {
							cmnLib.clickOnWebElement(tableDataBook);
							flag = true;
							log.info("Book selected");
							break;
						}
					}
				} else {
					log.info("No Books found");
				}
			} else {
				log.info("Book section not loaded");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Unable to select Book");
		}
		return flag;
	}

	public String getFinancialDetails(String strAttributeName) {
		String strAttributeValue = null;
		try {
			if (cmnLib.waitForElementToBeVisible(table_FinancialDetails)) {
				cmnLib.scrollTillVisibilityOfElement(table_FinancialDetails);
				List<WebElement> finDetails = tableRows_FinancialDetails.findElements(By.xpath("td//td"));
				for (WebElement data : finDetails) {
					if (data.getText().equalsIgnoreCase(strAttributeName)) {
						System.out.println("Attribute: " + data.getText());
						strAttributeValue = data.findElement(By.xpath("following-sibling::td//td[2]")).getText();
						System.out.println("Attribute Value: " + strAttributeValue);
						log.info("Financial Detail found");
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to get Financial Details");
		}
		return strAttributeValue;
	}

	public boolean verifyCalculatedDepreciation(String valueBeforeDepreciation, String valueAfterDepreciation,
			String compareValue) {
		boolean flag = false;
		try {
			double dBeforeDepreciation = Double.parseDouble(valueBeforeDepreciation);
			double dAfterDepreciation = Double.parseDouble(valueAfterDepreciation);
			double dCompareValue = Double.parseDouble(compareValue);
			if ((dAfterDepreciation - dBeforeDepreciation) == dCompareValue) {
				flag = true;
				log.info("Compare value successful");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Unable to compare values");
		}
		return flag;
	}

	public HashMap<String, String> getAssetBookDetails(String strBook) {
		HashMap<String, String> hashAssetBookDetails = new HashMap<>();
		try {
			if (cmnLib.waitForElementToBeVisible(table_Book)) {
				int iRowSize = tableRows_Book.size();
				System.out.println("No. of Rows: " + iRowSize);
				for (WebElement row : tableRows_Book) {
					WebElement tableDataBook = row.findElement(By.xpath("td[1]"));
					String Book = tableDataBook.getText();
					System.out.println(Book);
					if (Book.equalsIgnoreCase(strBook)) {
						hashAssetBookDetails.put("Book Class", row.findElement(By.xpath("td[2]")).getText());
						hashAssetBookDetails.put("Cost", row.findElement(By.xpath("td[3]")).getText());
						log.info("Asset Book Details captured");
						break;
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Unable to select Book");
		}
		return hashAssetBookDetails;
	}

	public String getRecentTransactionDetail(String strColumNumber) {
		String strTransactionType = null;
		try {
			TimeUnit.SECONDS.sleep(3);
			if (cmnLib.waitForElementToBeVisible(table_Transactions)) {
				int iRowSize = tableRows_Transactions.size();
				System.out.println("No. of Rows: " + iRowSize);
				for (WebElement row : tableRows_Transactions) {
					WebElement tableDataTransactionType = row.findElement(By.xpath("td[2]"));
					strTransactionType = tableDataTransactionType.getText();
					System.out.println(strTransactionType);
					break;
				}
			} else {
				log.info("Transactions table not found");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Unable to get transaction detail");
		}
		return strTransactionType;
	}

}
