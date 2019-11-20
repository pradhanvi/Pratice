package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class CashBalances extends TestBase{
	
	@FindBy(xpath = "//img[@title='Tasks']")
	public WebElement TasksPane;
	
	@FindBy(xpath = "//a[text()='Create Bank Account Transfer']")
	public WebElement CreateBankAccountTransfer;
	
	@FindBy(xpath = "//a[text()='Manage Bank Account Transfers']")
	public WebElement ManageBankAccountTransfers;

	public CashBalances() {
		PageFactory.initElements(driver, this);
		log.info("Cash Balances page is initialized...");
	}

}
