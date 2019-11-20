package com.commons;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.commons.Common_Library;

import report.oracle.ofs.ReportGeneration;
import xlsx.databank.ofs.ExcelOperations;

public class TestBase {

	public static WebDriver driver;
	public static String Browser;
	
	public static String URL;
	public static Logger log;
	public static SoftAssert st;
	public static ReportGeneration rpt;
	public static ExcelOperations exl;
	public static Common_Library cmnLib;
	public static HashMap<String, String> hashmap;
	public static String Module;
//	private String FirstModule;
	@BeforeSuite
	public void initialSetup() {
		cmnLib = new Common_Library();
		
		st = new SoftAssert();
		
		//Create Excel Object for LoginDetails
		try {
			exl = new ExcelOperations("Commons\\com\\commons\\LoginDetails.xlsx");
			System.out.println("'LoginDetails.xlsx' loaded successfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("'LoginDetails.xlsx' could not be loaded");
		}

		//Call the Method 'getLoginDetailsExcelData' to load the LoginDetails Excel data into Hashmap to use it later
		getLoginDetailsExcelData();
	}
	
	public void launchBrowser(String strModuleName) throws Throwable {
		
		if(strModuleName == null) {
			log.info("strModuleName is null/empty");
			throw new SkipException("Terminating the Execution: strModuleName is Invalid.");
		}
		
		//Initiate the Logger for the Specific Module
		if(strModuleName.toLowerCase().contains("otm")) {
			PropertyConfigurator.configure(".\\OTM\\log4j.properties");
		}else {
			PropertyConfigurator.configure(".\\"+strModuleName+"\\log4j.properties");
		}
//		PropertyConfigurator.configure(".\\"+strModuleName+"\\log4j.properties");
		log = Logger.getLogger("myLogger");
		
		if(driver!=null) {
			driver.quit();
			log.info("Closing the Existing Browsers");
		}
		System.out.println("Fetching the "+strModuleName+" Module Login Details");
		
		Browser = hashmap.get("Browser_"+strModuleName);
		System.out.println("Browser..."+Browser);
		URL= hashmap.get("URL_"+strModuleName);
		
		if(Browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "Drivers_EXE\\chromedriver.exe");
            driver=new ChromeDriver();
            log.info("Browser selected is ********** Chrome **********");
        }else if(Browser.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver", "Drivers_EXE\\IEDriverServer.exe");
             driver =new InternetExplorerDriver();
        }else if(Browser.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver", "Drivers_EXE\\geckodriver.exe");
            driver=new FirefoxDriver();
            log.info("Browser selected is ********** Mozilla FireFox **********");
        }
		
		driver.manage().window().maximize(); //maximize window browser
        log.info("Web Window is maximized");
        
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        
        log.info("Implicit Wait is Set to 20sec");
		driver.get(URL); 
		log.debug("URL is Opened");
	}
	
	private void getLoginDetailsExcelData() {
//		boolean executionReqFound = false;
		hashmap = new HashMap<>();
		
		//Get the Execute_Required as 'Y' and based on it fetch Module Name, Browser, URL etc.
		System.out.println("No records in LoginDetails.xlsx: "+exl.getRowCount("LoginDetails"));
		for (int i = 1; i < exl.getRowCount("LoginDetails"); i++) {

			String strExecutionRequired = exl.read("LoginDetails", i, "Execution_Required");
			if(strExecutionRequired.equalsIgnoreCase("Y")) {
				Module = exl.read("LoginDetails", i, "Module");

				hashmap.put("Browser_"+Module, exl.read("LoginDetails", i, "Browser"));
				hashmap.put("URL_"+Module, exl.read("LoginDetails", i, "URL"));
				hashmap.put("Domain_"+Module, exl.read("LoginDetails", i, "Domain"));
				hashmap.put("UserName_"+Module, exl.read("LoginDetails", i, "UserName"));
				hashmap.put("Password_"+Module, exl.read("LoginDetails", i, "Password"));
			}
		}
		System.out.println("Hashmap Details \n"+hashmap);
		
		System.out.println("Size of the Hashmap: "+hashmap.size());
	}
	
	@AfterSuite
	public void quitBrowser() {
		log.info("Browser will be Closed and Driver will be Quit !!");
		driver.quit();
	}

	
}
