package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import objectRepository.ElementsWebElementClass;

public class HomePage{

	WebDriver driver;
	ElementsWebElementClass ele;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		ele = new ElementsWebElementClass();
	}
	
	public WebElement homePage() {
		
		return driver.findElement(By.xpath(ele.homePage));
	}
	
}
