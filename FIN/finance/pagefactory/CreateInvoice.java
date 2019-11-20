package finance.pagefactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.commons.TestBase;

public class CreateInvoice extends TestBase {

	@FindBy(xpath = "//h1[contains(text(),'Create Invoice')]")
	public WebElement CreateInvoice_Header;
	
	@FindBy(xpath = "//div[contains(@id,'cb33')]")
	public WebElement Cancel;

	@FindBy(xpath = "//input[contains(@id,'ic2::content')]")
	public WebElement BusinessUnit;

	@FindBy(xpath = "//input[contains(@id,'ic3::content')]")
	public WebElement Supplier;

	@FindBy(xpath = "//tr[contains(@id,'MAnt2:1:pm1:r1:0:ap1:r2:0:pl3')]//td[2]")
	public WebElement SupplierNumber;

	@FindBy(xpath = "//input[contains(@id,'ic4::content')]")
	public WebElement SupplierSite;

	@FindBy(xpath = "//input[contains(@id,'legalEntityNameId::content')]")
	public WebElement LegalEntity_Input;
	
	@FindBy(xpath = "//span[contains(@id,'legalEntityNameId::content')]")
	public WebElement LegalEntity_Span;

	@FindBy(xpath = "//input[contains(@id,'i2::content')]")
	public WebElement Number;

	@FindBy(xpath = "//input[contains(@id,'i3::content')]")
	public WebElement Amount_Header;

	@FindBy(xpath = "//select[contains(@id,'soc1::content')]")
	public WebElement InvoiceCurrency;

	@FindBy(xpath = "//select[contains(@id,'so1::content')]")
	public WebElement Type;

	@FindBy(xpath = "//input[contains(@id,'id2::content')]")
	public WebElement Date;

	@FindBy(xpath = "//input[contains(@id,'so3::content')]")
	public WebElement PaymentTerms;

	@FindBy(xpath = "//input[contains(@id,'id5::content')]")
	public WebElement TermsDate;

	@FindBy(xpath = "//a[contains(@id,'sh2::_afrDscl')]")
	public WebElement Line_Expand_Collapse;

	@FindBy(xpath = "//input[contains(@id,'i26::content')]")
	public WebElement Amount_Line1;

	@FindBy(xpath = "//input[contains(@id,'kf1CS::content')]")
	public WebElement DistributionCombination;

	@FindBy(xpath = "//input[contains(@id,'id1::content')]")
	public WebElement AccountingDate;

	@FindBy(xpath = "//span[text()='Save']")
	public WebElement SaveButton;

	@FindBy(xpath = "//a[contains(@id,'ap1:cl3')]")
	public WebElement InvoiceValidationStatus;

	@FindBy(xpath = "//a[text()='Invoice Actions']")
	public WebElement InvoiceActions;

	@FindBy(xpath = "//div[contains(@id,'ap1:me1::popup-container')]")
	public WebElement InvoiceActions_Menu;

	@FindBy(xpath = "//span[text()='Total']//parent::div//following-sibling::div//td[3]")
	public WebElement TotalValue;

	@FindBy(xpath = "//span[text()='Total']//parent::div//following-sibling::div//img[contains(@title,'Out of Balance')]")
	public WebElement Total_Status_OutOfBalance;
	
	@FindBy(xpath = "//span[text()='Total']//parent::div//following-sibling::div//img")
	public WebElement Total_Status;

	@FindBy(xpath = "//a[contains(@id,'ap1:d37::close')]")
	public WebElement Close_InvoiceSummary;

	@FindBy(xpath = "//div[contains(@id,'_ATp:ctb3')]//a")
	public WebElement Distributions_Button;
	
	@FindBy(xpath = "//div[contains(@id,'ap1:po3::content')]")
	public WebElement ManageDistributions_Popup;
	
	@FindBy(xpath = "//label[text()='Distribution Combination']//parent::span/input")
	public WebElement DistributionCombination_ManageDistributions;
	
	@FindBy(xpath = "//table[@summary='Manage Distributions']//label[text()='Amount']//parent::span/input")
	public WebElement Amount_ManageDistributions;
	
	@FindBy(xpath = "//td[contains(@id,'ap1:d4')]//div[@title='Add Row']")
	public WebElement AddRow_ManageDistributions;
	
	@FindBy(xpath = "//button[text()='Save and Close']")
	public WebElement SaveAndClose_ManageDistributions;
	
	@FindBy(xpath = "//div[contains(@id,'pif15::content')]")
	public WebElement PayInFull_Popup;
	
	@FindBy(xpath = "//label[text()='Payment Amount']//parent::td//following-sibling::td/span[1]")
	public WebElement PaymentAmount;
	
	@FindBy(xpath = "//label[text()='Bank Account']//parent::td//following-sibling::td//input")
	public WebElement BankAccount;
	
	@FindBy(xpath = "//label[text()='Payment Process Profile']//parent::td//following-sibling::td//input")
	public WebElement PaymentProcessProfile;
	
	@FindBy(xpath = "//label[text()='Payment Document']//parent::td//following-sibling::td//input")
	public WebElement PaymentDocument;
	
	@FindBy(xpath = "//label[text()='Payment Number']//parent::td//following-sibling::td//input")
	public WebElement PaymentNumber_PayInFull;
	
	@FindBy(xpath = "//button[contains(@id,'pifbtn1')]")
	public WebElement Submit_PayInFull;
	
	@FindBy(xpath = "//input[contains(@id,'legalEntityNameId::content')]")
	public WebElement LegalEntity;

	public CreateInvoice() {
		PageFactory.initElements(driver, this);
	}

	public boolean selectInvoiceCurrency(String strInvoiceCurrency) {
		boolean result = false;
		try {
			TimeUnit.SECONDS.sleep(2);
			if (cmnLib.waitForElementToBeVisible(InvoiceCurrency)) {
				Select sel = new Select(InvoiceCurrency);
				List<WebElement> selOptionsList = sel.getOptions();
				for (WebElement selOption : selOptionsList) {
					String strText = selOption.getText();
					if (strText.contains(strInvoiceCurrency)) {
						sel.selectByVisibleText(strText);
						result = true;
						break;
					}
				}
			} else {
				log.info("Invoice Currency Select Box does not exist");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Exception: selectInvoiceCurrency");
		}
		return result;
	}

	public boolean selectOptionUnderInvoiceActions(String strOption) {
		boolean flag = false;

		String strMenuOption, strSubMenuAction;
		strMenuOption = strSubMenuAction = null;

		try {
			String[] options = strOption.split(":");
			strMenuOption = options[0];
			strSubMenuAction = options[1];
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			strSubMenuAction = null;
		}

		try {
			if (cmnLib.waitForElementToBeVisible(InvoiceActions_Menu)) {
				// Click on Invoice Actions Menu option
				if (cmnLib.clickOnWebElement(
						InvoiceActions_Menu.findElement(By.xpath("//td[text()='" + strMenuOption + "']")))) {
					log.info("Clicked on Invoice Actions Menu option");

					if (!(strSubMenuAction == null || strSubMenuAction.isEmpty())) {
						// Click on Invoice Actions Sub Menu option
						if (cmnLib.clickOnWebElement(InvoiceActions_Menu.findElement(
								By.xpath("following-sibling::div//td[text()='" + strSubMenuAction + "']")))) {
							log.info("Clicked on Invoice Actions Sub Menu option");
						}
					}
				}

				flag = true;
			} else {
				log.info("Invoice Actions menu not visible");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Unable to select option");
		}
		return flag;
	}

	/**************************************************************************************************
	 * Warning
	 *************************************************************************************************/
	@FindBy(xpath = "//td[contains(@id,'ap1:d36::contentContainer')]")
	public WebElement Message_Warning;

	@FindBy(xpath = "//button[text()='Continue']")
	public WebElement Continue_Warning;

	@FindBy(xpath = "//button[text()='Review Later']")
	public WebElement ReviewLater_Warning;

	/**************************************************************************************************
	 * Invoice Summary
	 *************************************************************************************************/

	@FindBy(xpath = "//td[contains(@id,'ap1:d37::contentContainer')]")
	public WebElement InvoiceSummary_Container;
	
	@FindBy(xpath = "//span[text()='Payments']//parent::span//parent::td//following-sibling::td")
	public WebElement Payments_InvoiceSummary;

	public boolean validateStatusInInvoiceSummary(String strAttribute, String strStatus) {
		boolean result = false;
		try {
			String attrStatus = driver
					.findElement(By.xpath(
							"//span[text()='" + strAttribute + "']//parent::span//parent::td//following-sibling::td"))
					.getText();
			System.out.println(attrStatus);
			if (attrStatus.equalsIgnoreCase(strStatus)) {
				result = true;
				log.info("Status validated");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Unable to validate Status");
		}
		return result;
	}

	/**************************************************************************************************
	 * Confirmation
	 *************************************************************************************************/
	@FindBy(xpath = "//button[contains(@id,'ap1:cb43')]")
	public WebElement OK_Confirmation;

	@FindBy(xpath = "//table[contains(@id,'ap1:pgl4')]")
	public WebElement Message_Confirmation;
	
	/**************************************************************************************************
	 * Payment Confirmation
	 *************************************************************************************************/
	@FindBy(xpath = "//div[@id='_FOd1::msgDlg::_cnt']//div[contains(text(),'Payment')]")
	public WebElement Message_PaymentConfirmation;
	
	@FindBy(xpath = "//button[@id='_FOd1::msgDlg::cancel']")
	public WebElement OK_PaymentConfirmation;

}
