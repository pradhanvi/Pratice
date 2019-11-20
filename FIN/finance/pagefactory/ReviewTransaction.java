package finance.pagefactory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class ReviewTransaction extends TestBase{
	@FindBy (xpath = "//a[contains(text(), 'Actions')]")
	public WebElement Actions;
	
	@FindBy (xpath = "//td[contains(text(),'Duplicate')]")
	public WebElement Duplicate;
	
	@FindBy (xpath = "//label[@class='af_panelLabelAndMessage_label-text' and contains(text(), 'Status')]/../parent::tr//a")
	public WebElement Status;
	
	@FindBy (xpath = "//td[contains(text(),'Account in Draft')]")
	public WebElement AccountInDraft;
	
	@FindBy (xpath = "//td[contains(text(),'View Accounting')]")
	public WebElement ViewAccounting;
	
	@FindBy (xpath = "//button[.='Done']")
	public WebElement DoneButton;
	
	@FindBy (xpath = "//td[contains(text(),'View Transaction Activities')]/..[contains(@class, 'Disabled')]")
	public WebElement ViewTransactionActivities_Disabled;
	
	@FindBy (xpath = "//td[contains(text(),'View Transaction Activities')]")
	public WebElement ViewTransactionActivities;
	
	@FindBy (xpath = "//td[contains(text(),'Manage Adjustments')]")
	public WebElement ManageAdjustments;
	
	@FindBy (xpath = "//label[text()='Status']//parent::td//following-sibling::td")
	public WebElement Status_Value;
	
	@FindBy (xpath = "//label[text()='Status']//parent::td//following-sibling::td//a[text()='Complete']")
	public WebElement Status_Complete;
	
	@FindBy (xpath = "//label[text()='Status']//parent::td//following-sibling::td[text()='Incomplete']")
	public WebElement Status_Incomplete;
	
	@FindBy (xpath = "//span[text()='Incomplete']//parent::a")
	public WebElement Incomplete_Button;
	
	@FindBy (xpath = "//span[text()='Delete']//parent::a")
	public WebElement Delete_Button;
	
	@FindBy (xpath = "//td[contains(text(),'delete incomplete transaction')]")
	public WebElement Message_Warning;
	
	@FindBy (xpath = "//button[contains(@id,'dialog3::yes')]")
	public WebElement yes_Warning;
	
	public ReviewTransaction() {
		PageFactory.initElements(driver, this);
		log.info("ReviewTransaction is initiated...");
	}
	
	public String getTransactionStatus() {
		if(cmnLib.waitForElementToBeVisible(Status)) {
			log.info("Status Webelement Exists");
			return Status.getText().trim();
		}else {
			log.info("Status Webelement does not Exist");
			return null;
		}
	}
	
	private boolean viewTrxActivitiesDisabled() {
		
		if(cmnLib.waitForElementToBeVisible(ViewTransactionActivities_Disabled)) {
			log.info("View Transaction Activities Link is Disabled under Actions");
			return true;
		}else {
			log.info("View Transaction Activities Link is enabled under Actions");
			return false;
		}
	}
	
	public boolean verifyAdjustmentApplied() throws AWTException, InterruptedException {
		if(!cmnLib.clickOnWebElement(Actions)) {
			log.info("Could not click on Actions button");
			return true;
		}
		TimeUnit.SECONDS.sleep(3);
		cmnLib.waitForPageLoaded();
		if(viewTrxActivitiesDisabled()) {
			log.info("Adjustment is not Applied");
			Robot robo = new Robot();
			robo.keyPress(KeyEvent.VK_ESCAPE);
			robo.keyRelease(KeyEvent.VK_ESCAPE);
			return false;
		}else {
			if(cmnLib.clickOnWebElement(ViewTransactionActivities)){
				log.info("Clicked on View Transaction Activities under Actions");
				cmnLib.waitForPageLoaded();
				try {
					String strAdjustmentNo = driver.findElement(By.xpath("//table[@summary='Transaction Activities']/tbody/tr/td[1]")).getText();
					if(strAdjustmentNo.length() > 0) {
						System.out.println("Adjustment Number Exists for Transaction: "+strAdjustmentNo);
						log.info("Adjustment Number Exists for Transaction: "+strAdjustmentNo);
						return true;
					}else {
						System.out.println("Adjustment Number for Transaction: "+strAdjustmentNo);
						new Robot().keyPress(KeyEvent.VK_ESCAPE);
						new Robot().keyRelease(KeyEvent.VK_ESCAPE);
						return false;
					}
					
				} catch (Exception e) {
					// TODO: handle exception
					log.info("Exception in verifyAdjustmentApplied");
					return true;
				}
			}else {
				log.info("Could not click on View Transaction Activities webelement under Actions");
				return true;
			}
		}
	}
}
