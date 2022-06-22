package formsPage;


import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	JavascriptExecutor jse;
	
	@BeforeTest
	public void beforeFormsPage() throws InterruptedException, SQLException {

		// initialize driver and open browser
		driver = initiateBrowser();
		fp = new FormsPage(driver);

		scrollToElement(fp.formsCard());
		fp.formsCard().click();

		Assert.assertTrue(fp.formsPage().isDisplayed(), "Forms page did not load.");
		fp.practiceFormTab().click();
		
		//Removing ads from the practice form page
		jse = (JavascriptExecutor)driver;
		jse.executeScript("return document.getElementById('adplus-anchor').remove();");
		
		//Thread.sleep(3000);

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
	public void fillForm() throws InterruptedException, SQLException{
		
		fp.firstName().sendKeys(fp.getUserFirstName());
		fp.lastName().sendKeys(fp.getUserLastName());
		fp.userEmail().sendKeys(fp.getUserEmail());
		
	//	WebDriverWait wait = new WebDriverWait(driver, 10);
    //  wait.until(ExpectedConditions.elementToBeClickable(fp.genderMale()));
	//	fp.genderMale().click();
		
		jse.executeScript("arguments[0].click()", fp.getGender());
		
		fp.userNumber().sendKeys(fp.getUserContactNumber());
		
		fp.selectDate(fp.userDOB(), "2022", "July", "9").click();
		
		fp.userSubjects().sendKeys(fp.getUserSubjects());
		
		jse.executeScript("window.scrollBy(0,250)", "");
		
		jse.executeScript("arguments[0].click()", fp.hobbiesMusic());
		jse.executeScript("arguments[0].click()", fp.hobbiesReading());
		
		final String filetoUpload = System.getProperty("user.dir") + "\\Test Data\\Image1.jpg";
		fp.userPicture().sendKeys(filetoUpload);
		
		fp.currentAddress().sendKeys(fp.getUserCurrentAddress());
	
		
		fp.selectState(fp.getUserState());

		fp.selectCity(fp.getUserCity());

	}
	
	
	@AfterTest
	public void afterFormsPage(){
		
		driver.close();
	}

}
