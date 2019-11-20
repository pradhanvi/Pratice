package scm.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class OrderManagement extends TestBase{
	
	@FindBy(xpath="//span[text()='Create Order']")
	public WebElement CreateOrderButton;
	
	@FindBy(xpath="//span[text()='Search']/parent::td/parent::tr//input")
	public WebElement SearchInput;
	
	@FindBy(xpath="//a[contains(@id,'::search_icon')]")
	public WebElement SearchButton;
	
	@FindBy(xpath="//a[text()='Actions']")
	public WebElement ActionsButton;
	
	@FindBy(xpath="//td[text()='View Pricing Strategy and Segment']")
	public WebElement ViewPricingStrategySegment;
	
	@FindBy(xpath="//div[text()='View Pricing Strategy and Segment']")
	public WebElement ViewPricingStrategySegmentHeader;
	
	@FindBy(xpath="//button[text()='D']")
	public WebElement DoneButton;
	
	@FindBy(xpath="//a[text()='Tasks']")
	public WebElement TasksButton;
	
	@FindBy(xpath="//td[text()='Create Order']")
	public WebElement CreateOrder_Tasks;
	
	@FindBy(xpath="//h1[text()='Create Order']")
	public WebElement CreateOrder_Header;
	
	@FindBy(xpath="//img[@title='Tasks']")
	public WebElement Tasks;
	
	@FindBy(xpath="//a[text()='Manage Pricing Strategies']")
	public WebElement ManagePricingStrategies;
	
	@FindBy(xpath="//h1[text()='Manage Pricing Strategies']")
	public WebElement ManagePricingStrategies_Header;
	
	@FindBy(xpath="//div[text()='Global Order Promising']")
	public WebElement GlobalOrderPromising;
	
	@FindBy(xpath="//h1[text()='Global Order Promising']")
	public WebElement GlobalOrderPromising_Header;
	
	@FindBy(xpath="//span[text()='ancel']")
	public WebElement CancelButton;
	
	@FindBy(xpath="//span[text()='Y']")
	public WebElement YesButton;
	
	@FindBy(xpath="")
	public WebElement abc6;
	
	
	public OrderManagement() {
		PageFactory.initElements(driver, this);
		log.info("Order Management page is Initialized...");
	}
	
	
	public boolean verifySearchedRecordExists(String orderNumber) {
		boolean exists = false;
		try {
			
			List<WebElement> TableRows = driver.findElements(By.xpath("//table[@summary='Search Results']/tbody/tr"));
			System.out.println("No Of Rows in Search Results Table: "+TableRows.size());
			if(TableRows.size() > 0) {
				for (int i = 1; i <= TableRows.size(); i++) {
					if(driver.findElement(By.xpath("//table[@summary='Search Results']/tbody/tr["+i+"]//*[contains(text(), '"+orderNumber+"')]")).isDisplayed()) {
						exists = true;
						log.info("Searched Scenario record exists");
						driver.findElement(By.xpath("//table[@summary='Search Results']/tbody/tr["+i+"]//*[contains(text(), '"+orderNumber+"')]")).click();
						}
					}
				}else {
					log.info("TableRows row count is less than zero !!");
				}
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Searched Scenario record does not exist");
		}
		return exists;
	}

}
