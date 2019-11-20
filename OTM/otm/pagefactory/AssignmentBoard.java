package otm.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commons.TestBase;

public class AssignmentBoard extends TestBase{
	
	@FindBy(xpath="//h1[@class='tm_panelHeader_title-text0']")
	public WebElement AssignmentBoardHeader;
	
	public AssignmentBoard()
	{
		PageFactory.initElements(driver, this);
		log.info("Assignment board is intialized");
	}
}
