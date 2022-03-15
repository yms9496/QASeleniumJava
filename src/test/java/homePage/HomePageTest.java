package homePage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.BaseClass;

public class HomePageTest extends BaseClass{

	WebDriver driver;
	HomePage hp;
	
	@BeforeTest
	public void beforeHomePage() {
		
		// initialize driver and open browser
		driver = initiateBrowser();
		hp = new HomePage(driver);
	}
	
	@Test
	public void HomePageLoad() {
		
		hp.homePage().isDisplayed();
	}
	
	@AfterTest
	public void afterHomePage() {
		driver.close();
	}
}
