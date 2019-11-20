package hcm.pagefactory;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

import hcm.pagefactory.HomePage_HCM;


public class LoginPage_HCM extends TestBase {
	
//  WebElements+business logics
	
	@FindBy(id = "userid")     
	public WebElement UserName;    
	
	@FindBy(id = "password")     
	public WebElement Password;   
	
	@FindBy(id = "btnActive")     
	public WebElement SignIn;        

	public LoginPage_HCM() {
		PageFactory.initElements(driver, this);
		//log.info("LoginPage_HCM is initialized");
	}
	
	public HomePage_HCM login(String strUserName, String strPassword) throws IOException{  

		UserName.sendKeys(strUserName);
		log.info("UserName is entered");
		Password.sendKeys(strPassword);  
		log.info("Password is entered");
		SignIn.click();
		log.info("SignIn is Clicked");
		
		return PageFactory.initElements(driver, HomePage_HCM.class);
	}
	
}
