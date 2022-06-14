package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import objectRepository.FormsWebElementClass;

public class FormsPage {

	WebDriver driver;
	FormsWebElementClass fw;

	public FormsPage(WebDriver driver) {

		this.driver = driver;
		fw = new FormsWebElementClass();
	}

	public WebElement homePage() {

		return driver.findElement(By.xpath(fw.homePage));
	}

	public WebElement formsPage() {
		return driver.findElement(By.xpath(fw.formsPage));
	}

	public WebElement formsMenuDropdown() {
		return driver.findElement(By.xpath(fw.formsMenuDropdown));
	}

	public WebElement practiceFormTab() {
		return driver.findElement(By.xpath(fw.practiceFormTab));
	}

	public WebElement practiceFormPage() {
		return driver.findElement(By.xpath(fw.practiceFormPage));
	}

	public WebElement firstName() {
		return driver.findElement(By.xpath(fw.firstName));
	}

	public WebElement lastName() {
		return driver.findElement(By.xpath(fw.lastName));
	}

	public WebElement userEmail() {
		return driver.findElement(By.xpath(fw.userEmail));
	}

	public WebElement genderMale() {
		return driver.findElement(By.xpath(fw.genderMale));
	}

	public WebElement genderFemale() {
		return driver.findElement(By.xpath(fw.genderMale));
	}

	public WebElement genderOther() {
		return driver.findElement(By.xpath(fw.genderOther));
	}

	public WebElement userNumber() {
		return driver.findElement(By.xpath(fw.userNumber));
	}

	public WebElement userDOB() {
		return driver.findElement(By.xpath(fw.userDOB));
	}

	public WebElement userSubjects() {
		return driver.findElement(By.xpath(fw.userSubjects));
	}

	public WebElement hobbiesSports() {
		return driver.findElement(By.xpath(fw.hobbiesSports));
	}

	public WebElement hobbiesReading() {
		return driver.findElement(By.xpath(fw.hobbiesReading));
	}

	public WebElement hobbiesMusic() {
		return driver.findElement(By.xpath(fw.hobbiesMusic));
	}

	public WebElement userPicture() {
		return driver.findElement(By.xpath(fw.userPicture));
	}

	public WebElement currentAddress() {
		return driver.findElement(By.xpath(fw.currentAddress));
	}

	public WebElement userState() {
		return driver.findElement(By.xpath(fw.userState));
	}

	public WebElement userCity() {
		return driver.findElement(By.xpath(fw.userCity));
	}

	public WebElement submitButton() {
		return driver.findElement(By.xpath(fw.submitButton));
	}

}
