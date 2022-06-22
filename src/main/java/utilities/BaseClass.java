package utilities;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public Connection conn;
	ExcelMapping em = new ExcelMapping();
	ExcelUtilities eu = new ExcelUtilities();
	String envName;
	String envURL;
	String browser;
	String browserVersion;
	String dbRegion;

	public WebDriver initiateBrowser() {

		// get envName and dbRegion from test data and set URL
		envName = eu.excelRead(em.excelMapping.get("CurrentEnv"));
		dbRegion = eu.excelRead(em.excelMapping.get("DB_Region"));

		if (envName.equalsIgnoreCase("SIT")) {

			envURL = eu.excelRead(em.excelMapping.get("CurrentEnvURL"));
			System.out.println("Executing on: " + envName);

		} else if (envName.equalsIgnoreCase("UAT")) {

			envURL = eu.excelRead(em.excelMapping.get("CurrentEnvURL"));
			System.out.println("Executing on: " + envName);

		} else if (envName.equalsIgnoreCase("PERF")) {

			envURL = eu.excelRead(em.excelMapping.get("CurrentEnvURL"));
			System.out.println("Executing on: " + envName);
		}

		System.out.println("DB Pointing set to : " + dbRegion);

		// get browser from excel test data
		browser = eu.excelRead(em.excelMapping.get("Browser"));

		if (browser.equalsIgnoreCase("chrome")) {

			System.out.println("Browser : " + browser);

			// System.setProperty("webdriver.chrome.driver",
			// ".\\resources\\chromedriver.exe");

			// setup driver for the installed chrome version
			WebDriverManager.chromedriver().driverVersion(eu.excelRead(em.excelMapping.get("ChromeVersion"))).setup();

			// Expected browser version
			System.out.println(eu.excelRead(em.excelMapping.get("ChromeVersion")));
		

//        	// for 32 bit browser
//        	WebDriverManager.chromedriver().arch32().driverVersion(cap.getVersion()).setup();
//
//        	// for 64 bit browser
//        	WebDriverManager.chromedriver().arch64().driverVersion(cap.getVersion()).setup();
//        	
//        	// with proxy
//			WebDriverManager.chromedriver().driverVersion("83.0.0").arch32().proxy("proxyhostname:80").proxyUser("username")
//					.proxyPass("password").setup();

			// create object of chrome options
			ChromeOptions options = new ChromeOptions();

//            //add the headless argument
//            options.addArguments("headless");

			driver = new ChromeDriver(options);

			// capabilities to get current browser version
			Capabilities cap = ((ChromeDriver) driver).getCapabilities();
			System.out.println("Current Chrome Version: " + cap.getVersion());

			// verify browser and driver versions are in line
			Assert.assertEquals(cap.getVersion(), eu.excelRead(em.excelMapping.get("ChromeVersion")),
					"Wrong chrome version in Excel");

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(envURL);

		} else if (browser.equalsIgnoreCase("firefox")) {

			System.out.println("Browser : " + browser);

			// System.setProperty("webdriver.gecko.driver",
			// ".\\resources\\geckodriver.exe");

			// setup driver for the installed chrome version
			WebDriverManager.firefoxdriver().driverVersion(eu.excelRead(em.excelMapping.get("FireFoxVersion"))).setup();

			// Expected browser version
			System.out.println(eu.excelRead(em.excelMapping.get("FireFoxVersion")));

//        	// for 32 bit browser
//        	WebDriverManager.chromedriver().arch32().driverVersion(cap.getVersion()).setup();
//
//        	// for 64 bit browser
//        	WebDriverManager.chromedriver().arch64().driverVersion(cap.getVersion()).setup();
//        	
//        	// with proxy
//			WebDriverManager.chromedriver().driverVersion("83.0.0").arch32().proxy("proxyhostname:80").proxyUser("username")
//					.proxyPass("password").setup();

			driver = new FirefoxDriver();

			// capabilities to get current browser version
			Capabilities cap = ((FirefoxDriver) driver).getCapabilities();
			System.out.println("Current Firefox Version: " + cap.getVersion());

			// verify browser and driver versions are in line
			Assert.assertEquals(eu.excelRead(em.excelMapping.get("FireFoxVersion")), cap.getVersion(),
					"Wrong firefox version in Excel");

			driver.manage().window().maximize();
			driver.get(envURL);

		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}
	
	public void scrollToElement(WebElement element) {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", element);

	}
	
	// implement this
	public void collectScreenshot(){
		
	}

	

	protected void getDBConnection() throws SQLException {

		String uname = eu.excelRead(em.excelMapping.get("DB_Uname"));
		String pass = eu.excelRead(em.excelMapping.get("DB_Pass"));
		dbRegion = eu.excelRead(em.excelMapping.get("DB_Region"));
		System.out.println("DB pointing set to: " + dbRegion);

		String url = "jdbc:postgresql://localhost/" + dbRegion + "?user=" + uname + "&password=" + pass + "&ssl=false?currentSchema=QASelenium";

		if (conn == null) {
			
			System.out.println("Establishing DB Connection");
			conn = DriverManager.getConnection(url);
		}
			
		else {
			
			System.out.println("DB Connection already active");
		}
			
	}

	public ResultSet getQueryResultSet(String query) throws SQLException {

		getDBConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		closeDBConnection();
		return rs;
	}
	
	public void executeQuery(String query) throws SQLException {
		
		getDBConnection();
		Statement stmt = conn.createStatement();
		stmt.executeQuery(query);
		closeDBConnection();
		
	}
	
	public void executePSQuery(PreparedStatement ps) throws SQLException {
		
		getDBConnection();
		ps.executeUpdate();
		closeDBConnection();
	}
	
	public void executeCSQuery(CallableStatement cs) throws SQLException {
		
		getDBConnection();
		cs.execute();
		closeDBConnection();
		
	}

	protected void closeDBConnection() throws SQLException {

		if (conn != null) {
			System.out.println("Closing DB Connection");
			conn.close();
		}
	}
}
