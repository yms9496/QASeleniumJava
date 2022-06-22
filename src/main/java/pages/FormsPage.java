package pages;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import objectRepository.FormsWebElementClass;
import utilities.BaseClass;

public class FormsPage {

	WebDriver driver;
	FormsWebElementClass fw;
	BaseClass bs;
	ResultSet rs;

	public FormsPage(WebDriver driver) throws SQLException {

		this.driver = driver;
		fw = new FormsWebElementClass();
		bs = new BaseClass();
		rs = bs.getQueryResultSet("select * from User_Data where user id = 001");
	}

	public WebElement homePage() {

		return driver.findElement(By.xpath(fw.homePage));
	}

	public WebElement formsCard() {

		return driver.findElement(By.xpath(fw.formsCard));
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

	public WebElement selectedState() {
		return driver.findElement(By.xpath(fw.selectedState));
	}

	public WebElement userCity() {
		return driver.findElement(By.xpath(fw.userCity));
	}

	public WebElement selectedCity() {
		return driver.findElement(By.xpath(fw.selectedCity));
	}

	public WebElement submitButton() {
		return driver.findElement(By.xpath(fw.submitButton));
	}

	public WebElement selectDate(WebElement calendar, String year, String month, String day)
			throws InterruptedException {

		// clicking on the calendar to open calendar widget
		calendar.click();

		// Selecting year from year dropdown
		WebElement yearDropDown = driver.findElement(
				By.xpath("//div[@class = 'react-datepicker']//select[@class = 'react-datepicker__year-select']"));
		Select selectYear = new Select(yearDropDown);
		selectYear.selectByVisibleText(year);

		Thread.sleep(2000);

		// Selecting month from month dropdown
		WebElement monthDropDown = driver.findElement(
				By.xpath("//div[@class = 'react-datepicker']//select[@class = 'react-datepicker__month-select']"));
		Select selectMonth = new Select(monthDropDown);
		selectMonth.selectByVisibleText(month);

		// Select and return date

		String locator = "//div[@class = 'react-datepicker__week']//div[text() = '" + day
				+ "'][not( contains(@class,'outside-month'))]";
		WebElement selectedDate = driver.findElement(By.xpath(locator));
		return selectedDate;
	}

	public void selectState(String state) throws InterruptedException {

		userState().sendKeys(state);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ARROW_DOWN).build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		Assert.assertEquals(selectedState().getText().trim(), state.trim());
	}

	public void selectCity(String city) {

		userCity().sendKeys(city);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ARROW_DOWN).build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		Assert.assertEquals(selectedCity().getText().trim(), city.trim());
	}

	public String getUserFirstName() throws SQLException {

		String userFirstName = "";
		while (rs.next()) {

			userFirstName = rs.getString("first name");
		}
		return userFirstName;
	}

	public String getUserLastName() throws SQLException {

		String userLastName = "";
		while (rs.next()) {

			userLastName = rs.getString("last name");
		}
		return userLastName;
	}
	
	public String getUserEmail() throws SQLException {

		String userEmail = "";
		while (rs.next()) {

			userEmail = rs.getString("user email");
		}
		return userEmail;
	}
	
	public String getGender() throws SQLException {

		String userGender = "";
		while (rs.next()) {

			userGender = rs.getString("gender");
		}
		return userGender;
	}
	
	public String getUserContactNumber() throws SQLException {

		String userContactNumber = null;
		while (rs.next()) {

			userContactNumber = Integer.toString(rs.getInt("phone number"));
		}
		return userContactNumber;
	}
	
	// DOB part to be implemented here
	
	public String getUserSubjects() throws SQLException {

		String userSubjects = "";
		while (rs.next()) {

			userSubjects = rs.getString("subjects");
		}
		return userSubjects;
	}
	
	// Hobbies part to be implemented
	
	public String getUserCurrentAddress() throws SQLException {

		String userCurrentAddress = "";
		while (rs.next()) {

			userCurrentAddress = rs.getString("address");
		}
		return userCurrentAddress;
	}
	
	public String getUserCity() throws SQLException {

		String userCity = "";
		while (rs.next()) {

			userCity = rs.getString("city");
		}
		return userCity;
	}
	
	public String getUserState() throws SQLException {

		String userState = "";
		while (rs.next()) {

			userState = rs.getString("state");
		}
		return userState;
	}
	
	
}
