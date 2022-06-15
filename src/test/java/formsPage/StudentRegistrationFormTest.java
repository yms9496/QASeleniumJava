package formsPage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.ElementsPage;
import pages.FormsPage;
import pages.TextBoxPage;
import utilities.BaseClass;

public class StudentRegistrationFormTest extends BaseClass{
	
	WebDriver driver;
	FormsPage fp;
	
	@BeforeTest
	public void beforeFormsPage() throws InterruptedException {

		// initialize driver and open browser
		driver = initiateBrowser();
		fp = new FormsPage(driver);

		scrollToElement(fp.formsCard());
		fp.formsCard().click();

		Assert.assertTrue(fp.formsPage().isDisplayed(), "Forms page did not load.");
		fp.practiceFormTab().click();
		
		//Removing ads from the practice form page
		JavascriptExecutor js=null;
		if (driver instanceof JavascriptExecutor) {
		    js = (JavascriptExecutor) driver;
		}
		js.executeScript("return document.getElementById('adplus-anchor').remove();");
		
		//Thread.sleep(5000);

	}
	
	@Test(priority = 1)
	public void studentRegistrationFormLoad(){
		
		Assert.assertTrue(fp.practiceFormPage().isDisplayed(), "Student Registration Form did not load");
		
	}
	
	@Test(priority = 2)
	public void studentRegistrationFormName(){
		
		Assert.assertEquals("Student Registration Form", fp.practiceFormPage().getText());
	}
	
	@Test(priority = 3)
	public void fillForm(){
		
		fp.firstName().sendKeys("John");
		fp.lastName().sendKeys("Wick");
		fp.userEmail().sendKeys("john.wick123@gmail.com");
		fp.genderMale().click();
		fp.userNumber().sendKeys("9876543210");
		
		fp.userDOB().clear();
		fp.userDOB().sendKeys("15 Jun 2022");
		
	}
	
	
	@AfterTest
	public void afterFormsPage(){
		
		driver.close();
	}

}
