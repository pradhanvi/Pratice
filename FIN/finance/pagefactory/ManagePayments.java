package finance.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ManagePayments extends TestBase {

	@FindBy(xpath = "//h1[contains(text(),'Manage Payments')]")
	public WebElement ManagePayments_Header;

	@FindBy(xpath = "//label[text()='Payment Number']//parent::td//parent::tr//td[2]//input")
	public WebElement PaymentNumber;

	@FindBy(xpath = "//button[text()='Search']")
	public WebElement Search;
	
	@FindBy(xpath = "//table[@summary='Search Results']/tbody")
	public WebElement table_Results;
	
	@FindBy(xpath = "//a[text()='Actions']")
	public WebElement Actions_button;
	
	@FindBy(xpath = "//td[text()='Void']")
	public WebElement Void;
	
	@FindBy(xpath = "//button[contains(@id,'dialog1::ok')]")
	public WebElement Submit_Void;
	
	@FindBy(xpath = "//div[@title='Search']//parent::td//preceding-sibling::td//a")
	public WebElement Search_Arrow;

	public ManagePayments() {
		PageFactory.initElements(driver, this);
		log.info("Manage Paymnets page is initialized...");
	}

	public boolean selectPaymnetFromResults(String strPaymentNumber) {
		boolean flag = false;
		try {
			if (cmnLib.waitForElementToBeVisible(table_Results)) {
				List<WebElement> tableRows_SearchResults = driver
						.findElements(By.xpath("//table[@summary='Search Results']/tbody/tr"));
				int iRowSize = tableRows_SearchResults.size();
				System.out.println("No. of Rows: " + iRowSize);
				for (WebElement row : tableRows_SearchResults) {
					WebElement tableDataPaymentNumber = row.findElement(By.xpath("td[2]/div[1]/table/tbody/tr/td[1]"));
					String PaymnentNumber = tableDataPaymentNumber.getText();
					if (PaymnentNumber.equalsIgnoreCase(strPaymentNumber)) {
						row.findElement(By.xpath("td[1]")).click();
						flag = true;
						break;
					}
				}
			}else {
				log.info("Results not found");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Unable to select Payment in results");
		}
		return flag;
	}
	
	
	public String getPaymnetDetail(String strPaymentNumber) {
		String returnValue = null;
		try {
			if (cmnLib.waitForElementToBeVisible(table_Results)) {
				List<WebElement> tableRows_SearchResults = driver
						.findElements(By.xpath("//table[@summary='Search Results']/tbody/tr"));
				int iRowSize = tableRows_SearchResults.size();
				System.out.println("No. of Rows: " + iRowSize);
				for (WebElement row : tableRows_SearchResults) {
					WebElement tableDataPaymentNumber = row.findElement(By.xpath("td[2]/div[1]/table/tbody/tr/td[1]"));
					String PaymnentNumber = tableDataPaymentNumber.getText();
					if (PaymnentNumber.equalsIgnoreCase(strPaymentNumber)) {
						returnValue = row.findElement(By.xpath("td[2]/div[1]/table/tbody/tr/td[3]")).getText();
						break;
					}
				}
			}else {
				log.info("Results not found");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Unable to get Payment Detail in results");
		}
		return returnValue;
	}

}
