package wms.pagefactory;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

import hcm.pagefactory.HomePage_HCM;
import otm.pagefactory.HomePage_OTM;


public class LoginPage_WMS extends TestBase {
	
//  WebElements+business logics
	
	@FindBy(id = "username")     
	public WebElement UserName;    
	
	@FindBy(id = "password")     
	public WebElement Password;   
	
	@FindBy(xpath="//button[@type='submit' and contains( text(),'Sign In')]")     
	public WebElement SignIn;        

	public LoginPage_WMS() {
		PageFactory.initElements(driver, this);
		log.info("LoginPage_HCM is initialized");
	}
	
	public HomePage_WMS login(String strUserName, String strPassword) throws IOException{  

		UserName.sendKeys(strUserName);
		log.info("UserName is entered");
		Password.sendKeys(strPassword);  
		log.info("Password is entered");
		SignIn.click();
		log.info("SignIn is Clicked");
		
		return PageFactory.initElements(driver, HomePage_WMS.class);
	}
	
}
