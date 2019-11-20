package wms.pagefactory;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.*;

import otm.pagefactory.OrderReleaseFinder;


public class HomePage_WMS extends TestBase{
							
    @FindBy  (xpath="//span[@title='Home']")
	public WebElement HomePage_HomeIcon;
    
    @FindBy(xpath="//span[contains(@id,'main_menu') and @role='button']")
    public WebElement NavigatorIcon;
    
    @FindBy(xpath="//span[text()='Search' and contains(@class, 'PlaceHolder')]/ancestor::div[1]//input[@role='textbox']")
    public WebElement Search_Input;
    
    @FindBy(xpath="//span[text()='IB LPNs' and @role='treeitem']")
    public WebElement IBLPNLink;

	

    public HomePage_WMS() {
		PageFactory.initElements(driver, this);
		System.out.println("HomePage is Initialized...");
	}

	public boolean clickOnWelcomePage_HomeIcon()
	{
		try {
			driver.findElement(By.xpath("//span[@title='Home']")).isDisplayed();
			driver.findElement(By.xpath("//span[@title='Home']")).click();
			

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
	
	public IBLPN clickOnIBLPN() {
		try {
			IBLPNLink.isDisplayed();
			IBLPNLink.click();
			log.info("IB LPN's Link is Clicked");

		} catch (Exception e) {
			// TODO: handle exception
			log.info("IB LPN's Link is NOT Clicked");
			return null;
		}
		return PageFactory.initElements(driver, IBLPN.class);
	}
	
	public boolean searchAndSelectResponsibility(String resp) {
		cmnLib.waitForElementToBeVisible(Search_Input);
		if(cmnLib.enterDataInTextBox(Search_Input, resp, true))
		{
			if(cmnLib.pressEnterKey())
			{
				log.info("Clicked on "+resp+"");
				return true;
			}
		}
		log.info("Unable to select "+resp+"");
		return false;
	}
	
	

	
	}

	

	
	
	

