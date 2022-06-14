package elementsModule;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.ElementsPage;
import utilities.BaseClass;

public class ElementsPageTest extends BaseClass {

	WebDriver driver;
	ElementsPage ep;

	@BeforeTest
	public void beforeElementsPage() {

		// initialize driver and open browser
		driver = initiateBrowser();
		ep = new ElementsPage(driver);
	}

	@Test(priority = 1)
	public void HomePageLoad() {

		Assert.assertTrue(ep.homePage().isDisplayed(), "Homepage did not load.");
	}

	@Test(priority = 2)
	public void ElementsCard() {

		scrollToElement(ep.elementsCard());
		ep.elementsCard().click();
	}

	@Test(priority = 3)
	public void ElementsPage() {

		Assert.assertTrue(ep.elementsPage().isDisplayed(), "Elements page did not load.");
	}

	@Test(priority = 4)
	public void TextBoxTab() {

		ep.textBoxTab().click();

	}

	@Test(priority = 5)
	public void CheckBoxTab() {

		ep.checkBoxTab().click();

	}

	@Test(priority = 6)
	public void RadioButtonBoxTab() {

		scrollToElement(ep.buttonsTab());
		ep.radioButtonBoxTab().click();

	}

	@Test(priority = 7)
	public void WebTablesTab() {

		scrollToElement(ep.buttonsTab());
		ep.webTablesBoxTab().click();

	}

	@Test(priority = 8)
	public void ButtonsTab() {

		scrollToElement(ep.buttonsTab());
		ep.buttonsTab().click();

	}

	@Test(priority = 9)
	public void LinksTab() {

		scrollToElement(ep.buttonsTab());
		ep.linksTab().click();

	}

	@Test(priority = 10)
	public void BrokenLinksImagesTab() {

		scrollToElement(ep.buttonsTab());
		ep.brokenLinksImagesTab().click();
		//Assert.assertTrue(false);

	}

	@AfterTest
	public void afterElementsPage() {

		driver.close();
	}
}
