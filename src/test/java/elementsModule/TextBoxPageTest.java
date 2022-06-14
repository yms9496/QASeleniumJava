package elementsModule;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.ElementsPage;
import pages.TextBoxPage;
import utilities.BaseClass;

public class TextBoxPageTest extends BaseClass {

	WebDriver driver;
	TextBoxPage tbp;
	ElementsPage ep;


	@BeforeTest
	public void beforeElementsPage() {

		// initialize driver and open browser
		driver = initiateBrowser();
		tbp = new TextBoxPage(driver);
		ep = new ElementsPage(driver);

		scrollToElement(ep.elementsCard());
		ep.elementsCard().click();

		Assert.assertTrue(ep.elementsPage().isDisplayed(), "Elements page did not load.");
		ep.textBoxTab().click();

	}

	@Test(priority = 1)
	public void TextBoxPageLoad() {

		Assert.assertTrue(tbp.textBoxPage.isDisplayed(), "Textbox Page did not load.");
	}

	@Test(priority = 2)
	public void fullName() {

		Assert.assertTrue(tbp.userName.isDisplayed());
	}

	@Test(priority = 2)
	public void email() {

		Assert.assertTrue(tbp.userEmail.isDisplayed());
	}

	@Test(priority = 3)
	public void address() {

		Assert.assertTrue(tbp.userAddress.isDisplayed());

	}

	@Test(priority = 4)
	public void permanentAddress() {

		Assert.assertTrue(tbp.permanentAddress.isDisplayed());

	}

	@Test(priority = 5)
	public void submitButton() {

		Assert.assertTrue(tbp.submitButton.isDisplayed());

	}

	@AfterTest
	public void afterElementsPage() {

		driver.close();
	}

}
