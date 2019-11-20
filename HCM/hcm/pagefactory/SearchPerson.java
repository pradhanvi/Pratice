package hcm.pagefactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.commons.TestBase;

public class SearchPerson extends TestBase{
	
	@FindBy  (xpath="//h1[contains(text(),'Person Management')]")
	public WebElement PersonManagementPage_StringValidation;

	@FindBy (xpath = "//label[text()='Person Number']/parent::td/parent::tr//input")
	public WebElement PersonNumber;
	
	@FindBy(xpath = "//button[contains(@id,'search')]")
	public WebElement SearchButton;
	
	public void enterPersonNumber(String strPersonNumber) {
		PersonNumber.sendKeys(strPersonNumber);
		log.info("Entered the Person Number");
	}
	
	public SearchPerson()
	{
		PageFactory.initElements(driver, this);
		log.info("Search Person is initialzed");
	}
	
	public void clickOnSearch() {
		SearchButton.click();
		log.info("Clicked on Search Button");
	}
	
//	@FindBy (xpath = "//button[@title='Actions']")
//	public WebElement ActionButton;
//	
//	public void clickOnActionsButton() {
//		ActionButton.click();
//	}
	public boolean verifySearchedRecordExists(String strPersonName_OR_PersonNumber) {
		boolean exists = false;
		try {
			List<WebElement> TableRows = driver.findElements(By.xpath("//table[@summary='Search Results']/tbody/tr"));
			System.out.println("No Of Rows in Search Results Table: "+TableRows.size());
			if(TableRows.size() > 0) {
				for (int i = 1; i <= TableRows.size(); i++) {
					if(driver.findElement(By.xpath("//table[@summary='Search Results']/tbody/tr["+i+"]//*[contains(text(), '"+strPersonName_OR_PersonNumber+"')]")).isDisplayed()) {
						exists = true;
						log.info("Searched Person Number record exists");
						}
					}
				}else {
					log.info("TableRows row count is less than zero !!");
				}
			
			
			/*for (int i = 1; i <= TableRows.size(); i++) {
				if(driver.findElement(By.xpath("//table[@summary='Search Results']/tbody/tr["+i+"]//*[contains(text(), '"+strPersonName_OR_PersonNumber+"')]")).isDisplayed()) {
					Actions actions = new Actions(driver);
					driver.findElement(By.xpath("//table[@summary='Search Results']/tbody/tr["+i+"]//button")).click();
					TimeUnit.SECONDS.sleep(3);
					//Mouse Hover on Personal and Employment and Select Person Management
					WebElement menu = driver.findElement(By.xpath("//div[@class='AFPopupMenuPopup']//td[text()='Personal and Employment']"));
					actions.moveToElement(menu);
					actions.click().build().perform();
					
					WebElement subMenu = driver.findElement(By.xpath("//div[@class='AFPopupMenuPopup']//td[text()='Manage Person']"));
					actions.moveToElement(subMenu);
					actions.click().build().perform();
					exists = true;
				}
			}*/
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Searched Person Number record does not exist");
		}
		return exists;
	}
	
	public boolean verifyActivePayroll(String strPersonName) {
		try {
			List<WebElement> TableRows = driver.findElements(By.xpath("//table[@summary='Search Results']/tbody/tr"));
			System.out.println("No Of Rows: "+TableRows.size());
			
			for (int i = 1; i <= TableRows.size(); i++) {
				if(driver.findElement(By.xpath("//table[@summary='Search Results']/tbody/tr["+i+"]//*[contains(text(), '"+strPersonName+"')]")).isDisplayed()) {
					
					String strIsActivePayroll = driver.findElement(By.xpath("//table[@summary='Search Results']/tbody/tr["+i+"]//button/preceding::td[1]")).getText();
					if(strIsActivePayroll.toLowerCase().contains("active")) {
						log.info("Employment Status of the Employee is Active");
						return true;
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		log.info("Employement Status of the Employee is Not Active");
		return false;
	}

	public boolean clickOnSearchedPerson(String strPersonName) {
		strPersonName = strPersonName.toUpperCase();
		boolean exists = false;
		try {
			driver.findElement(By.xpath("//table[@summary='Search Results']//a[contains(text(), '"+strPersonName+"')]")).isDisplayed();
			driver.findElement(By.xpath("//table[@summary='Search Results']//a[contains(text(), '"+strPersonName+"')]")).click();
			log.info("Clicked on Searched Person");
			exists = true;
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Could not Click on Person. As Searched Person Number record does not exist");
			exists = false;
		}
		return exists;
	}
	
	public boolean clickOnActionButtonForSearchedPerson(String strPersonNumber) {
		boolean clicked = false;
		
		try {
			int TableRowsCount = driver.findElements(By.xpath("//table[@summary='Search Results']/tbody/tr")).size();
			
			for (int i = 1; i <= TableRowsCount; i++) {
				if(driver.findElement(By.xpath("//table[@summary='Search Results']/tbody/tr["+i+"]//*[contains(text(), '"+strPersonNumber+"')]")).isDisplayed()) {
					log.info("Searched Record with exists");
					driver.findElement(By.xpath("//table[@summary='Search Results']/tbody/tr["+i+"]//button")).click();
					log.info("Clicked on Action button of the Searched Record");
					TimeUnit.SECONDS.sleep(3);
					clicked = true;
				}else {
					log.info("Person Number Record does not");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Colud not click the Action button of the Searched Employee");
		}
		return clicked;
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
	
	
}
