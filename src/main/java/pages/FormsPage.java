package pages;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

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

	public WebElement selectDate(WebElement calendar, String date)
			throws InterruptedException {

		String[] datesplitted = date.split("-");
		int year = Integer.parseInt(datesplitted[1]);
		int month = Integer.parseInt(datesplitted[1]);
		int day = Integer.parseInt(datesplitted[1]);

	    LocalDate date1 = LocalDate.of(year,month,day);
	    String date2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(date1);
	    datesplitted = date2.split(" ");
		
		String y = (datesplitted[1]);
		String m = (datesplitted[1]);
		String d = (datesplitted[1]);
	    
		// clicking on the calendar to open calendar widget
		calendar.click();

		// Selecting year from year dropdown
		WebElement yearDropDown = driver.findElement(
				By.xpath("//div[@class = 'react-datepicker']//select[@class = 'react-datepicker__year-select']"));
		Select selectYear = new Select(yearDropDown);
		selectYear.selectByVisibleText(y);

		Thread.sleep(2000);

		// Selecting month from month dropdown
		WebElement monthDropDown = driver.findElement(
				By.xpath("//div[@class = 'react-datepicker']//select[@class = 'react-datepicker__month-select']"));
		Select selectMonth = new Select(monthDropDown);
		selectMonth.selectByVisibleText(m);

		// Select and return date

		String locator = "//div[@class = 'react-datepicker__week']//div[text() = '" + d
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

		//bs.getDBConnection();
		
		String userFirstName = "";
		
		rs = bs.getQueryResultSet("select * from \"QASelenium\".\"User_Data\" where \"user id\" = 1");
		
		while(rs.next()) {

			userFirstName = rs.getString("first name");

		}
		
		//bs.closeDBConnection();
		return userFirstName;
	}

	public String getUserLastName() throws SQLException {
		
	//	bs.getDBConnection();

		String userLastName = "";
		
		rs = bs.getQueryResultSet("select * from \"QASelenium\".\"User_Data\" where \"user id\" = 1");
		
		while(rs.next()) {

		
		userLastName = rs.getString("last name");
		}
	//	bs.closeDBConnection();
		return userLastName;
	}
	
	public String getUserEmail() throws SQLException {
		
		//bs.getDBConnection();

		String userEmail = "";
		
		rs = bs.getQueryResultSet("select * from \"QASelenium\".\"User_Data\" where \"user id\" = 1");
		
		while(rs.next()) {
			userEmail = rs.getString("user email");
		}
	//	bs.closeDBConnection();
		return userEmail;
	}
	
	public WebElement getGender() throws SQLException {
		
	//	bs.getDBConnection();

		String userGender = "";
		
		rs = bs.getQueryResultSet("select * from \"QASelenium\".\"User_Data\" where \"user id\" = 1");
		
		while(rs.next()) {
			userGender = rs.getString("gender");
		}
		
		WebElement genderCheckBox;
		
		if(userGender.equalsIgnoreCase("Male"))
			genderCheckBox = genderMale();
		else if(userGender.equalsIgnoreCase("Male"))
			genderCheckBox = genderFemale();
		else
			genderCheckBox = genderOther();
		
	//	bs.closeDBConnection();
		return genderCheckBox;
	}
	
	public long getUserContactNumber() throws SQLException {
		
	//	bs.getDBConnection();

		long userContactNumber = 0;
		
		rs = bs.getQueryResultSet("select * from \"QASelenium\".\"User_Data\" where \"user id\" = 1");
		
		while(rs.next()) {
			userContactNumber = rs.getLong("phone number");
		}
	//	bs.closeDBConnection();
		return userContactNumber;
	
	}
	// DOB part to be implemented here
	
	
	public String getUserDOB() throws SQLException {
		
	//	bs.getDBConnection();

		String userDOB = "";
		
		rs = bs.getQueryResultSet("select * from \"QASelenium\".\"User_Data\" where \"user id\" = 1");
		
		while(rs.next()) {
			userDOB = rs.getDate("user dob").toString();
		}
	//	bs.closeDBConnection();	
		return userDOB;
	}
	
	
	public String getUserSubjects() throws SQLException {
		
	//	bs.getDBConnection();

		String userSubjects = "";
		
		rs = bs.getQueryResultSet("select * from \"QASelenium\".\"User_Data\" where \"user id\" = 1");
		
		while(rs.next()) {
			userSubjects = rs.getString("subjects");
		}
	//	bs.closeDBConnection();
		return userSubjects;
		
	}
	
	// Hobbies part to be implemented
	
	public String getUserCurrentAddress() throws SQLException {
		
	//	bs.getDBConnection();

		String userCurrentAddress = "";
		
		rs = bs.getQueryResultSet("select * from \"QASelenium\".\"User_Data\" where \"user id\" = 1");
		
		while(rs.next()) {
		
			userCurrentAddress = rs.getString("current address");
		
		}
	//	bs.closeDBConnection();
		return userCurrentAddress;
	}
	
	public String getUserCity() throws SQLException {
		
	//	bs.getDBConnection();

		String userCity = "";
		
		rs = bs.getQueryResultSet("select * from \"QASelenium\".\"User_Data\" where \"user id\" = 1");
		
		while(rs.next()) {
			userCity = rs.getString("city");
		}
	//	bs.closeDBConnection();
		return userCity;
	}
	
	public String getUserState() throws SQLException {
		
	//	bs.getDBConnection();

		String userState = "";
		
		rs = bs.getQueryResultSet("select * from \"QASelenium\".\"User_Data\" where \"user id\" = 1");
		
		while(rs.next()) {
			userState = rs.getString("state");
		}
	//	bs.closeDBConnection();
		return userState;
	}
	
	
}
