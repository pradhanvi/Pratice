package otm.pagefactory;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

import scm.pagefactory.HomePage_SCM;

public class LoginPage_OTM extends TestBase{
	
	@FindBy(id="tenantDisplayName")
	 public WebElement domain;
	 
	 @FindBy(id = "signin")
	 public WebElement go_button;
	 
	 @FindBy(xpath = "//form//div[text()='Welcome']")
	 public WebElement welcomeText;
	 
	 @FindBy(id="username")
	 public WebElement username;
	 
	 @FindBy(id="password")
	 public WebElement password;
	 
	 @FindBy(id="signin")
	 public WebElement signin_button;

	 public LoginPage_OTM() {
	  PageFactory.initElements(driver, this);
	 }
	 
	 public HomePage_OTM login(String strUsername, String strPassword) {
	  try {
	   username.sendKeys(strUsername);
	   log.info("Username Entered");
	   password.sendKeys(strPassword);
	   log.info("Password Entered");
	   signin_button.click();
	   log.info("Clicked Sign In");
	   return PageFactory.initElements(driver, HomePage_OTM.class);
	  }catch(Exception e) {
	   log.info("Signin failed");
	   return null;
	  }
	   
	 }
	 
	 public boolean setDomain(String strdomain) {
	  try {
	   domain.sendKeys(strdomain);
	   log.info("Entered Domain");
	   go_button.click();
	   log.info("Clicked Go button");
	   return true;
	  }catch(Exception e) {
	   log.info("Domain not set");
	   return false;
	  }
	  
	 }

	
	
	
	
	

	
/*//  WebElements+business logics
	
	@FindBy(id = "userid")     
	public WebElement UserName;    
	
	@FindBy(id = "password")     
	public WebElement Password;   
	
	@FindBy(id = "btnActive")     
	public WebElement SignIn;        

	public LoginPage_OTM() {
		PageFactory.initElements(driver, this);
		log.info("LoginPage_OTM is initialized");
	}
	
	public HomePage_OTM login(String strUserName, String strPassword) throws IOException{  

		UserName.sendKeys(strUserName);
		log.info("UserName is entered");
		Password.sendKeys(strPassword);  
		log.info("Password is entered");
		SignIn.click();
		log.info("SignIn is Clicked");
		
		return PageFactory.initElements(driver, HomePage_OTM.class);
	}*/
	

	
	
	
	
	/*
	
	@FindBy(id="tenantDisplayName")
	public WebElement domain;
	
	@FindBy(id = "signin")
	public WebElement go_button;
	
	@FindBy(xpath = "//form//div[text()='Welcome']")
	public WebElement welcomeText;
	
	@FindBy(id="username")
	public WebElement username;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(id="signin")
	public WebElement signin_button;

	public LoginPage_OTM() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage_OTM login(String strUsername, String strPassword) {
		try {
			username.sendKeys(strUsername);
			log.info("Username Entered");
			password.sendKeys(strPassword);
			log.info("Password Entered");
			signin_button.click();
			log.info("Clicked Sign In");
			return new HomePage_OTM();	
		}catch(Exception e) {
			log.info("Signin failed");
			return null;
		}
			
	}
	
	public boolean setDomain(String strdomain) {
		try {
			domain.sendKeys(strdomain);
			log.info("Entered Domain");
			go_button.click();
			log.info("Clicked Go button");
			return true;
		}catch(Exception e) {
			log.info("Domain not set");
			return false;
		}
		
	}
*/
	
}
