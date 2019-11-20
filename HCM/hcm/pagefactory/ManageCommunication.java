package hcm.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.commons.TestBase;

public class ManageCommunication extends TestBase {
	
	@FindBy(xpath="//span[text()='Directory']")
	public WebElement DirectoryHeader;
	
	@FindBy(xpath="//label[text()='Search']/parent::span//input")
	public WebElement PersonNumberInput;
	
	@FindBy(xpath="//img[@alt='Search']")
	public WebElement SearchButton_DirPage;
	
	@FindBy(xpath="//a[text()='Show Filters']")
	public WebElement ShowFilters;
	
	@FindBy(xpath="//div[text()='No results found.']")
	public WebElement NoResultsFound;
	
	@FindBy(xpath="//a[text()='Change Background Photo']")
	public WebElement ChangeBackgroundPhoto;
	
	@FindBy(xpath="//img[@alt='Edit Phone Numbers']")
	public WebElement EditPhoneNum;
	
	@FindBy(xpath="//div[text()='Edit Phone Details']")
	public WebElement EditPhonePopUP;
	
	@FindBy(xpath="//a[contains(@aria-describedby,'afrdescBy')]")
	public WebElement AddPhoneIcon;
	
	@FindBy(xpath="//a[contains(@id,'popEl')]")
	public WebElement AddPhoneDrop;
	
	@FindBy(xpath="//td[text()='Phone']")
	public WebElement SelectPhone;
	
	@FindBy(xpath="//div[contains(@id,'pgl20')]/div[1]/table/tbody/tr/td[3]/span/span/a")
	public WebElement TypeDrop;
	
	@FindBy(xpath="//td[contains(@id,'d3::_fcc')]//button")
	public WebElement OKButton_AddPhone;
	
	@FindBy(xpath="//div[contains(@id,'pgl20')]/div[1]/table/tbody/tr/td[5]/span/span/input")
	public WebElement CountryCode;
	
	@FindBy(xpath="//div[contains(@id,'pgl20')]/div[1]/table/tbody/tr/td[9]/span/input")
	public WebElement PhoneNumInput;
	
	@FindBy(xpath="//div[text()='Error']")
	public WebElement ErrorPopUp;
	
	@FindBy(xpath="//a[contains(@id,'1:inputComboboxListOfValues1::lovIconId')]")
	public WebElement DetailsDrop;
	
	@FindBy(xpath="//a[contains(@id,'0:cb6')]")
	public WebElement Delete_PhoneNum;
	
	@FindBy(xpath="//a[contains(@id,'0:soc2::drop')]")
	public WebElement EmailTypeDrop;
	
	@FindBy(xpath="//a[contains(@id,'0:soc1::drop')]")
	public WebElement Phone_TypeDrop;
	
	@FindBy(xpath="//input[contains(@id,'0:inputComboboxListOfValues1::content')]")
	public WebElement Phone_Details;
	
	@FindBy(xpath="//input[contains(@id,'0:inputText2')]")
	public WebElement Phone_Number;
	
	@FindBy(xpath="//img[contains(@id,'0:cb6::icon')]")
	public WebElement Delete_PhoneNum_Dir;

	@FindBy(xpath="//input[contains(@id,'it2::content')]")
	public WebElement EmailInput;
	
	@FindBy(xpath="//td[text()='Email']")
	public WebElement SelectEmail;
	
	@FindBy(xpath="//img[contains(@id,'0:cb6b::icon')]")
	public WebElement DeleteEmail_Dir;
	
	@FindBy(xpath="//li[text()='Home Email']")
	public WebElement HomeEmailSelect;
	
	
	
	@FindBy(xpath="//img[contains(@id,'0:cb6b::icon')]")
	public WebElement DeleteEmail_Dir_Ad;
	
	
	public void enterPersonNumber(String strPersonNumber) {
		PersonNumberInput.sendKeys(strPersonNumber);
		log.info("Entered the Person Number");
	}
	
	public void clickOnSearch() {
		SearchButton_DirPage.click();
		log.info("Clicked on Search Button");
	}
	
	public boolean selectOptionFromComboBox(String strLabelName, String strOptionValue) {
        boolean returnStatus = false;

        try {
               cmnLib.waitForPageLoaded();
               if (cmnLib
                            .clickOnWebElement(driver.findElement(By
                                          .xpath("//label[text()='" + strLabelName + "']//parent::td//parent::tr//td[2]/span/a")))
                            && cmnLib.waitForElementToBeVisible(
                                          driver.findElement(By.xpath("//td/ul[contains(@id,'::pop')]")))) {
                     List<WebElement> ListOptions = driver.findElements(By.xpath("//td/ul[contains(@id,'::pop')]//li"));
                     for (WebElement option : ListOptions) {
                            if (option.getText().equalsIgnoreCase(strOptionValue)) {
                                   option.click();
                                   returnStatus = true;
                                   log.info("Selected option from " + strLabelName);
                                   break;
                            }
                     }
               } else {
                     log.info("List Menu not visible for " + strLabelName + "  Combobox");
               }

        } catch (

        Exception e) {
               // TODO: handle exception
               e.printStackTrace();
               log.info("Unable to select option from " + strLabelName + " Combobox");
        }
        return returnStatus;
 }

 public boolean selectOptionFromComboBoxInsideTable(WebElement comboBoxArrow, String strOptionValue) {
        boolean returnStatus = false;

        try {
               if (cmnLib.clickOnWebElement(comboBoxArrow) && cmnLib
                            .waitForElementToBeVisible(driver.findElement(By.xpath("//td/ul[contains(@id,'::pop')]")))) {
                     List<WebElement> ListOptions = driver.findElements(By.xpath("//td/ul[contains(@id,'::pop')]//li"));
                     for (WebElement option : ListOptions) {
                            if (option.getText().equalsIgnoreCase(strOptionValue)) {
                                   option.click();
                                   returnStatus = true;
                                   log.info("Selected Option");
                                   break;
                            }
                     }
                     log.info("Expected option not found");
               } else {
                     log.info("List Menu not visible");
               }

        } catch (

        Exception e) {
               // TODO: handle exception
               e.printStackTrace();
               log.info("Unable to select option from Combobox");
        }
        return returnStatus;
 }
 
 

	

}
