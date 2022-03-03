import java.sql.SQLException;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.BaseClass;

public class dummyTest extends BaseClass{

	
	@BeforeTest
	public void beforeUploadTest() throws SQLException {

		driver = initiateBrowser();
			
		Capabilities cap = ((ChromeDriver) driver).getCapabilities();
	    System.out.println(cap.getVersion());
				

	}
	
	@Test
	public void a() {
		Assert.assertTrue(true);
	}
	
	@Test
	public void b() {
		Assert.assertTrue(true);
	}
	
	@AfterTest
	public void afterUploadTest() throws SQLException {

		driver.close();
	}
}
