package hcm.pagefactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.commons.TestBase;

public class CreateWorkRelationship extends TestBase{

	//Identification 
	@FindBy(xpath = "//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:r1:0:pt1:SP1:inputDate1::content']") 
	public WebElement StartDate; //Optional
	
	@FindBy(xpath = "//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:r1:0:pt1:SP1:action::content']") 
	public WebElement Action;
	
	@FindBy(xpath = "//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:r1:0:pt1:SP1:legaEm::content']") 
	public WebElement Legal_Employer;
	
	@FindBy(xpath = "//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:r1:0:pt1:SP1:selectOneChoice1::content']") 
	public WebElement Worker_Type;
	
	@FindBy(xpath = "//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:r1:0:pt1:SP1:NewPe1:0:pt_r1:0:r1:0:i1:0:it20::content']") 
	public WebElement Paternal_Last_Name;
	
	@FindBy(xpath = "//a[contains(., 'Next')]") 
	public WebElement NextButton;
	
	//Person Information
	@FindBy(xpath = "//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:r1:1:pt1:SP1:Perso1:0:Perso1:0:r1:0:i1:0:inputText17::content']") 
	public WebElement Address_Line1;
	
	@FindBy(xpath = "//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:r1:1:pt1:SP1:Perso1:0:pt_r1:0:AT1:_ATp:table1:0:soc1::content']") 
	public WebElement PhoneType;
	
	@FindBy(xpath = "//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:r1:1:pt1:SP1:Perso1:0:pt_r1:0:AT1:_ATp:table1:0:iclov1::content']") 
	public WebElement CountryCode;
	
	@FindBy(xpath = "//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:r1:1:pt1:SP1:Perso1:0:pt_r1:0:AT1:_ATp:table1:0:it3::content']") 
	public WebElement PhoneNumber;
	
	//Employment Information
	@FindBy(xpath = "//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:r1:2:pt2:SP1:r2ram:0:id1::content']") 
	public WebElement HireDate;
	
	@FindBy(xpath = "//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:r1:2:pt2:SP1:AddWo2:0:AddWo1:0:soc2::content']") 
	public WebElement AssignmentStatus;
	
	@FindBy(xpath = "//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:r1:2:pt2:SP1:AddWo2:0:AddWo1:0:businessUnitId::content']") 
	public WebElement BusinessUnit;
	
	@FindBy(xpath = "//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:r1:2:pt2:SP1:AddWo2:0:r3:0:i1:0:ManagerNameId::content']") 
	public WebElement Manger_Name;
	
	@FindBy(xpath = "//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:r1:2:pt2:SP1:AddWo2:0:r3:0:i1:0:selectOneChoice1::content']") 
	public WebElement Manger_Type;
	
	//Compensation and Other Information
	@FindBy(xpath = "//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:r1:1:pt1:SP2:r61:0:r5:0:icAsgLov::content']") 
	public WebElement SalaryBasis;
	
	@FindBy(xpath = "//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:r1:1:pt1:SP2:r61:0:r5:0:itSA::content']") 
	public WebElement SalaryAmount;
	
	//Review
	@FindBy(xpath = "//a[contains(., 'Submit')]") 
	public WebElement SubmitButton;
	
	public void enterStartDate(String strStartDate) {
		try {
			if(strStartDate == null || strStartDate.isEmpty()) {
				log.info("Start Date is Optional and Start Date value in DataBank is empty, Hence Today's Date is defaulted");
			}else {
				StartDate.isDisplayed();
				StartDate.sendKeys(strStartDate);
				StartDate.sendKeys(Keys.TAB);
				log.info("Start Date is Entered");
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Start Date is not Entered");
		}
	}
	
	public void enterLegalEmployer() {
		
	}
}
