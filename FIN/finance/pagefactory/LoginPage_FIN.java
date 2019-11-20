package finance.pagefactory;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class LoginPage_FIN extends TestBase {

	// WebElements+business logics

	@FindBy(id = "userid")
	public WebElement UserName;

	@FindBy(id = "password")
	public WebElement Password;

	@FindBy(id = "btnActive")
	public WebElement SignIn;
	
	public LoginPage_FIN() {
		PageFactory.initElements(driver, this);
	}

	public HomePage_FIN login(String strUserName, String strPassword) throws IOException {
		try {
			UserName.sendKeys(strUserName);
			log.info("UserName is entered");
			Password.sendKeys(strPassword);
			log.info("Password is entered");
			SignIn.click();
			log.info("SignIn is Clicked");
			return new HomePage_FIN();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Signin failed");
			return null;
		}

	}

}
