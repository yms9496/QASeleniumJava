package elementsModulePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;

public class TextBoxPage {

	WebDriver driver;

	public TextBoxPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		// PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);

	}

	// Locating the text box tab
	@FindBy(xpath = "//div[@class = 'element-list collapse show']/ul/li/span[normalize-space()='Text Box']")
	public WebElement textBoxTab;

	// Locating the text box page
	@FindBy(className = "main-header")
	public WebElement textBoxPage;

	// Locating user name field
	@FindAll({ @FindBy(id = "userName-wrapper"), @FindBy(id = "userName") })
	public WebElement userName;

	// Locating user email field
	@FindAll({ @FindBy(id = "userEmail-wrapper"), @FindBy(id = "userEmail") })
	public WebElement userEmail;

	// Locating current address field
	@FindAll({ @FindBy(id = "userAddress-wrapper"), @FindBy(id = "userEmail") })
	public WebElement userAddress;

	// Locating permanent address field
	@FindAll({ @FindBy(id = "permanentAddress-wrapper"), @FindBy(id = "permanentAddress") })
	public WebElement permanentAddress;

	// Locating the submit button
	@CacheLookup
	@FindBy(id = "submit")
	public WebElement submitButton;

}
