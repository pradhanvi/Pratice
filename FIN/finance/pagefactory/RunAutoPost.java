package finance.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class RunAutoPost extends TestBase {
	

@FindBy(xpath = "//img[@title='Tasks']")
public WebElement TaskPane;

@FindBy(xpath="//a[@id='_FOpt1:_FOr1:0:_FOSritemNode_general_accounting_journals:0:_FOTRaT:0:RAtl5']")
public WebElement RunAutoPost;

@FindBy(xpath="//select[contains(@id,'paramDynForm_Attribute1_ATTRIBUTE1::content')]")
public WebElement AutoPostCriteria;

@FindBy(xpath="//div[contains(@id,'requestBtns:submitButton')]")
public WebElement SubmitButton;

@FindBy(xpath="//button[contains(@id,'confirmSubmitDialog::ok')]")
public WebElement OkButton;

@FindBy(xpath="//td[contains(text(),'2455307')]")
public WebElement AutoReverseJournals;

public RunAutoPost() {
	PageFactory.initElements(driver, this);
	log.info("Run AutoPost Page is initialized...");
}




}