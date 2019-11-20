package otm.pagefactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

import scm.pagefactory.CostAccountingPage;
import scm.pagefactory.ScheduledProcesses;
import scm.pagefactory.SetupAndMaintenancePage;
import scm.pagefactory.WorkDefinition;
import scm.pagefactory.WorkExecution;

public class HomePage_OTM extends TestBase {
								
	@FindBy  (xpath="//a[@title='Home']")
	public WebElement HomePage_HomeIcon;
	
	/*@FindBy  (xpath="//a[@id='l9']")
	public WebElement HomePage_HomeIcon;*/

	@FindBy (xpath = "//a[@title='Navigator']")
	public WebElement NavigatorIcon;

	@FindBy(xpath="//a[@id='navRegn:0:j_id440739981_623169d0_8']")
	public WebElement AssignmentBoardLink;
	
	@FindBy(xpath="//span[text()='Order Release']")
	public WebElement OrderReleaseLink;
	
	@FindBy(xpath="//span[contains(@id,'navRegn:0:j_id440739981_62316b85_7::text')]/span[text()='Order Release']")
	public WebElement OrderReleaseSubLink;
	
	@FindBy(xpath="//span[text()='Orden Rapida']")
	 public WebElement Rapid_Order_Icon;
	
	@FindBy(xpath="//h1[text()='Order Release Finder']")
	public WebElement OrderRelaeseFinderPage;
	

	public HomePage_OTM() {
		PageFactory.initElements(driver, this);
		//log.info("HomePage_OTM is initialized...");
	}
	
	

	public boolean clickOnWelcomePage_HomeIcon()
	{
		try {
			driver.findElement(By.xpath("//a[@title='Home']")).isDisplayed();
			driver.findElement(By.xpath("//a[@title='Home']")).click();
			//			HomePage_HomeIcon.isDisplayed();
			//			HomePage_HomeIcon.click();
			log.info("Clicked on HomeIcon in HomePage");
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Home Icon in HomePage is not displayed...");
			return false;
		}
		return true;
	}

	public String getUserNameFromHomePage() {
		String strUserName = null;
		try {
			clickOnWelcomePage_HomeIcon();

			driver.findElement(By.xpath("//*[@id='pt1:_UIScmil2u::icon']")).isDisplayed();
			strUserName = driver.findElement(By.xpath("//*[@id='pt1:_UIScmil2u::icon']")).getAttribute("title");
			//			UserName_Icon.isDisplayed();
			//			strUserName = UserName_Icon.getAttribute("title");
			System.out.println("UserName captured from HomePage: "+strUserName);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("UserName could not be captured from HomePage");
		}
		return strUserName;
	}

	public void clickOnNavigationIcon() throws InterruptedException {
		NavigatorIcon.click();
		log.info("Navigation Icon is clicked");
		TimeUnit.SECONDS.sleep(5);
	}
	
	public AssignmentBoard clickOnAssignmentBoardLink() {
		try {
			AssignmentBoardLink.isDisplayed();
			AssignmentBoardLink.click();
			log.info("Assignment Board Link is Clicked");

		} catch (Exception e) {
			// TODO: handle exception
			log.info("Assignment Board Link is Not Clicked");
			return null;
		}
		return PageFactory.initElements(driver, AssignmentBoard.class);
	}
	
	public OrderReleaseFinder clickOnOrderRelease() {
		try {
			OrderReleaseLink.isDisplayed();
			OrderReleaseLink.click();
			log.info("OrderReleaseLink Link is Clicked");

		} catch (Exception e) {
			// TODO: handle exception
			log.info("OrderReleaseLink Link is Not Clicked");
			return null;
		}
		return PageFactory.initElements(driver, OrderReleaseFinder.class);
	}
	
	public OrderReleaseFinder clickOnRapidOrder() {
		try {
			Rapid_Order_Icon.isDisplayed();
			Rapid_Order_Icon.click();
			log.info("Rapid Order Link is Clicked");

		} catch (Exception e) {
			// TODO: handle exception
			log.info("Rapid Order Link is Not Clicked");
			return null;
		}
		return PageFactory.initElements(driver, OrderReleaseFinder.class);
	}
	
	


}
