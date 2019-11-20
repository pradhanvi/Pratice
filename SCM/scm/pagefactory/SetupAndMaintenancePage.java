package scm.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.commons.TestBase;

public class SetupAndMaintenancePage extends TestBase {
	
	@FindBy(xpath="//h1[contains(@class,'xmt')]")
	public WebElement SetupManintenanceHeader;
	
	
	//@FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='…'])[4]/following::span[1]")
	@FindBy(id="pt1:r1:0:r0:0:r1:0:AP1:soc2::drop")
	public WebElement SetupDropDown;
	
	//@FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='PrintMe'])[1]/following::td[7]")
	@FindBy(xpath="//li[contains(text(),'Manufacturing and Supply Chain Materials Managemen')]")
	public WebElement SelectSCM;
	
	@FindBy(id="pt1:r1:0:r0:0:r1:0:AP1:s92:it2::content")
	public WebElement SearchTasks;
	
	@FindBy(xpath="//img[@title='Search']")
	public WebElement SearchTasksSearchButton;
	
	@FindBy(id="pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:ap1:SPps2")
	public WebElement ManageCostBooksPage;
	
	@FindBy(id="pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:ap1:searchCostBooksQueryResultId:_ATp:table2:0:inputText1::content")
	public WebElement CostBook1;
	
	
	@FindBy(id="pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:ap1:searchCostBooksQueryResultId:_ATp:table2:1:inputText1::content")
	public WebElement CostBook2;
	
	@FindBy(id="pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:ap1:searchCostBooksQueryResultId:_ATp:table2:2:inputText1::content")
	public WebElement CostBook3;
	
	@FindBy(id="pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:ap1:searchCostBooksQueryResultId:_ATp:table2:3:inputText1::content")
	public WebElement CostBook4;
	
	@FindBy(id="pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:ap1:searchCostBooksQueryResultId:_ATp:table2:4:inputText1::content")
	public WebElement CostBook5;
	
	@FindBy(id="pt1:r1:0:rt:0:r2:0:dynamicRegion1:0:pt1:ap1:searchCostBooksQueryResultId:_ATp:table2:0:inputText1::content")
	public WebElement CostBook6;
	
	@FindBy(id="pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:ap1:searchCostBooksQueryResultId:_ATp:table2:6:inputText1::content")
	public WebElement CostBook7;
	
	@FindBy(xpath="//h1[contains(text(),'Manage Cost Books')]")
	public WebElement ManageCostBooksPageHeader;
	
	public boolean selectSCMdropdown()
	{
		if(cmnLib.clickOnWebElement(SetupDropDown) && cmnLib.clickOnWebElement(SelectSCM))
		{
			log.info("SCM is selected from Setup dropdown");
			return true;
		}else {
			log.info("SCM is not selected from Setup dropdown");
			return false;
		}
	}
	

	
	

}
