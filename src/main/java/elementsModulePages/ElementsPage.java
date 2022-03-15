package elementsModulePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import objectRepository.ElementsWebElementClass;

public class ElementsPage {

	WebDriver driver;
	ElementsWebElementClass ele;

	public ElementsPage(WebDriver driver) {

		this.driver = driver;
		ele = new ElementsWebElementClass();
	}

	public WebElement homePage() {

		return driver.findElement(By.xpath(ele.homePage));
	}

	public WebElement elementsCard() {

		return driver.findElement(By.xpath(ele.elementsCard));
	}
	
	public WebElement elementsPage() {

		return driver.findElement(By.xpath(ele.elementsPage));
	}
	
	public WebElement elementsMenuDropdown() {

		return driver.findElement(By.xpath(ele.elementsMenuDropdown));
	}

	public WebElement textBoxTab() {

		return driver.findElement(By.xpath(ele.textBoxTab));
	}

	public WebElement checkBoxTab() {

		return driver.findElement(By.xpath(ele.checkBoxTab));
	}

	public WebElement radioButtonBoxTab() {

		return driver.findElement(By.xpath(ele.radioButtonBoxTab));
	}

	public WebElement webTablesBoxTab() {

		return driver.findElement(By.xpath(ele.webTablesBoxTab));
	}

	public WebElement buttonsTab() {

		return driver.findElement(By.xpath(ele.buttonsTab));
	}

	public WebElement linksTab() {

		return driver.findElement(By.xpath(ele.linksTab));
	}

	public WebElement brokenLinksImagesTab() {

		return driver.findElement(By.xpath(ele.brokenLinksImagesTab));
	}

}
