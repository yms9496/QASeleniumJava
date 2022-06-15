package objectRepository;

public class FormsWebElementClass {

	// Home Page
	public String homePage = "//header/a/img[@src = '/images/Toolsqa.jpg']";
	public String formsCard = "//div[@class = 'category-cards']//div[@class = 'card-body']/h5[normalize-space() = 'Forms']";

	// Forms Page
	public String formsPage = "//div[@class = 'main-header' and normalize-space() = 'Forms']";
	public String formsMenuDropdown = "//div[@class = 'left-pannel']//div[@class = 'header-text' and normalize-space() = 'Forms']/span";
	public String practiceFormTab = "//div[@class = 'element-list collapse show']/ul/li/span[normalize-space()='Practice Form']";
	public String practiceFormPage = "//div[@class='practice-form-wrapper']/h5";
	public String firstName = "//input[@id='firstName']";
	public String lastName = "//input[@id='lastName']";
	public String userEmail = "//input[@id='userEmail']";
	public String genderMale = "//input[@name='gender'][@value = 'Male']";
	public String genderFemale = "//input[@name='gender'][@value = 'Female']";
	public String genderOther = "//input[@name='gender'][@value = 'Other']";
	public String userNumber = "//input[@id='userNumber']";
	public String userDOB = "//input[@id='dateOfBirthInput']";
	public String userSubjects = "//input[@id='subjectsInput']";
	public String hobbiesSports = "//input[@id='hobbies-checkbox-1']";
	public String hobbiesReading = "//input[@id='hobbies-checkbox-2']";
	public String hobbiesMusic = "//input[@id='hobbies-checkbox-3']";
	public String userPicture = "//input[@id='uploadPicture']";
	public String currentAddress = "//input[@id='currentAddress']";
	public String userState = "//div[@id='stateCity-wrapper']//input[@id='react-select-3-input']";
	public String userCity = "//div[@id='stateCity-wrapper']//input[@id='react-select-4-input']";
	public String submitButton = "//button[@id='submit']";
	
}
