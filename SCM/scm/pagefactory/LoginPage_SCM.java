package scm.pagefactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

import hcm.pagefactory.HomePage_HCM;
import otm.pagefactory.HomePage_OTM;


public class LoginPage_SCM extends TestBase {
	
//  WebElements+business logics
	
	@FindBy(id = "userid")     
	public WebElement UserName;    
	
	@FindBy(id = "password")     
	public WebElement Password;   
	
	@FindBy(id = "btnActive")     
	public WebElement SignIn;        

	public LoginPage_SCM() {
		PageFactory.initElements(driver, this);
		log.info("LoginPage_HCM is initialized");
	}
	
	public HomePage_SCM login(String strUserName, String strPassword) throws IOException, InterruptedException{  

		UserName.sendKeys(strUserName);
		log.info("UserName is entered");
		Password.sendKeys(strPassword);  
		log.info("Password is entered");
		TimeUnit.SECONDS.sleep(5);
		SignIn.click();
		log.info("SignIn is Clicked");
		
		return PageFactory.initElements(driver, HomePage_SCM.class);
	}
	
}
