package wms.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.commons.TestBase;

public class WaveInquiry extends TestBase{

	@FindBy  (xpath="//span[@name='AllocationRunHdrView.common_grid_search_action']")
	public WebElement SearchIcon_WaveInquiry;
	
	@FindBy  (xpath="//label[text()='Run Nbr']/ancestor::tr[1]//input")
	public WebElement RunNumber;
	
	@FindBy  (xpath="//span[@name='AllocationRunHdrView.search_pane.search']")
	public WebElement Search_Btn_WaveInquiry;
	
	@FindBy(xpath = "//div[@name='AllocationRunHdrView.grid']/div[1]//table//tr/th")
	public List<WebElement> columnHeaderElements;
	
	@FindBy(xpath = "//div[@name='AllocationRunHdrView.grid']/div[2]//table//tr")
	public List<WebElement> rowElements;
	
	@FindBy  (xpath="//span[@name='AllocationRunHdrView.allocation_details']")
	public WebElement Allocation_Btn_WaveInquiry;
	
	@FindBy(xpath = "//div[@name='AllocationViewPopup.grid']/div[1]//table//tr/th")
	public List<WebElement> columnHeaderElements_AllocationPage;
	
	@FindBy(xpath = "//div[@name='AllocationViewPopup.grid']/div[2]//table//tr")
	public List<WebElement> rowElements_AllocationPage;
	
	@FindBy  (xpath="//span[text()='Wave Inquiry' and contains(@id, 'Button')]")
	public WebElement WaveInquiry_Btn;
	
	@FindBy  (xpath="//span[@name='AllocationRunHdrView.undo']")
	public WebElement UndoWave_Btn_WaveInquiry;
	
	@FindBy  (xpath="//div[contains(@widgetid, 'ConfirmDialog')]//span[text()='OK']")
	public WebElement ConfirmDialog_OK_Btn;
	
	@FindBy  (xpath="//div[contains(@class, 'DialogPaneContent')]/div[1]")
	public WebElement SuccessDialog;
	
	@FindBy  (xpath="//div[contains(@class, 'DialogPaneContent')]//span[text()='OK']")
	public WebElement SuccessDialog_OK_Btn;
	
	
	/**
	 * 
	 * @author ampn (Amit PN)
	 * @Description This method gets the column number of the table given its Column Name and Table Column Headers List<elements>
	 * @param columnHeaderElementsTHs Ex: @FindBy(xpath = "//div[@name='WaveTemplateView.grid']/div[1]//table//tr/th") <br>public List<WebElement> columnHeaderElements;
	 * @param strColumnName Name of the Column
	 * @return int (Column #)
	 */
	public int getColumnNumberUsingColumnName(List<WebElement> columnHeaderElementsTHs, String strColumnName) {
		
		try {
			//Get the Column # of the Column_Names
			System.out.println("No of Column Headers: "+columnHeaderElementsTHs.size());
			
			for (int iColNo = 0; iColNo < columnHeaderElementsTHs.size(); iColNo++) {
				String headerName = columnHeaderElementsTHs.get(iColNo).getText();
				System.out.println(headerName+"-- Col# --"+iColNo);
				if(headerName.equalsIgnoreCase(strColumnName)) {
					iColNo = iColNo + 1;
					System.out.println("Column Name: "+headerName+"-- Found in Col# --"+iColNo);
					return iColNo;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Error in fetching table elements");
			return 0;
		}
		return 0;
	}
	
	
	
	/**
	 * 
	 * @Description This method gets the Row Value number of the table given its iRowNo(By default pass '0'), iColNo and Table row Elements List<elements>
	 * @param rowElementsTRs Ex: @FindBy(xpath = "//div[@name='WaveTemplateView.grid']/div[2]//table//tr") <br> public List<WebElement> rowElements;
	 * @param iRowNo Row# from which the value will be fetched (To fetch value from 1st Row pass value as '0')
	 * @param iColNo Col# from which the value will be fetched
	 * @return String (Value from the Table Cells(iRowNo, iColNo))
	 */
public String getRowValueUsingColumnNumber(List<WebElement> rowElementsTRs, int iRowNo, int iColNo) {
		
		try {
			System.out.println("No of Rows in DataTable: "+rowElementsTRs.size());
			
			//First Row# means zeroth element from the list hence iRowNo = 0 for RowNo = 1
			if(iRowNo == 1) {
				iRowNo = 0;
			}
			
			if(rowElementsTRs.size() > 0) {
				if(iRowNo == 0) {
					String rowText = rowElementsTRs.get(0).findElement(By.xpath("td["+iColNo+"]")).getText();
					System.out.println("Row Value: "+rowText+"-- Row# --1");
					return rowText;
				}else {
					String rowText = rowElementsTRs.get(iRowNo).findElement(By.xpath("td["+iColNo+"]")).getText();
					System.out.println("Row Value: "+rowText+"-- Row# --"+(iRowNo+1));
					return rowText;
				}
				
			}else {
				log.info("No of Row is: 0");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Error in fetching table elements");
			return null;
		}
		return null;
	}
	
	/**
	 * 
	 * @Description This method gets the Row Value number of the table given its iRowNo(By default pass '0'), iColNo and Table row Elements List<elements>
	 * @param rowElementsTRs Ex: @FindBy(xpath = "//div[@name='WaveTemplateView.grid']/div[2]//table//tr") <br> public List<WebElement> rowElements;
	 * @param iColNo Col# from which the value will be fetched
	 * @param strRowValue Click on Row# where RowValue exists (If Multiple Rows exist with same Value, It will select 1st occurrence Row#)
	 * @return String (Value from the Table Cells(iRowNo, iColNo))
	 */
	public boolean clickOnRowValue(List<WebElement> rowElementsTRs, int iColNo,  String strRowValue) {
		try {
			System.out.println("No of Rows in DataTable: "+rowElementsTRs.size());

			for (int iRowNo = 0; iRowNo < rowElementsTRs.size(); iRowNo++) {
				WebElement rowData = rowElementsTRs.get(iRowNo).findElement(By.xpath("td["+iColNo+"]"));
				String rowText = rowData.getText();
				System.out.println("Row Value: "+rowText+"-- Row# --"+(iRowNo+1));
				
				if(rowText.equalsIgnoreCase(strRowValue)) {
					rowData.click();
					return true;
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Error in fetching table elements");
			return false;
		}
		return false;
	}
}
