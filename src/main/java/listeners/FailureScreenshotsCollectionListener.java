package listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utilities.BaseClass;

public class FailureScreenshotsCollectionListener implements ITestListener {

	WebDriver driver;
	String screenshotPath = System.getProperty("user.dir") + "\\target\\Failure Screenshots\\";

	public FailureScreenshotsCollectionListener() {

		File spath = new File(screenshotPath);

		// create folder if not exists
		if (!spath.exists()) {

			System.out.println("Creating Failure Screenshots Folder");
			spath.mkdir();
		}

		// Print screenshots paths
		System.out.println("Failure Screenshots will be stored in " + spath);

		// Delete all existing files in the directory
		File[] files = spath.listFiles();
		if (files.length != 0) {

			for (File file : files) {
				Assert.assertTrue(file.delete(), "Could not delete the existing failure screenshots");
			}
		}

	}

	public void onFinish(ITestContext it) {
		
		System.out.println("public void onFinish(ITestContext it)");
	}

	public void onStart(ITestContext it) {

		System.out.println("public void onStart(ITestContext it)");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult it) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult it) {

		// get the failed test case name
		String failedTestCaseName = it.getTestClass().toString();

		System.out.println(
				"Failed Test Case Name " + failedTestCaseName + ". Collecting screenshot for failed case analysis");

		// Get current object of test class and extract driver
		Object testClassObject = it.getInstance();
		this.driver = ((BaseClass)testClassObject).driver;
		

		try {
			
			collectScreenshot(failedTestCaseName, driver);
		}
		
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult it) {

		System.out.println("Skipped Test Case : " + it.getTestClass().toString());
	}

	public void onTestStart(ITestResult it) {

		System.out.println("Executing Test Case : " + it.getTestClass().toString());
	}

	public void onTestSuccess(ITestResult it) {

		System.out.println("Test Case Passed : " + it.getTestClass().toString());
		
	}

	private void collectScreenshot(String failedTestCaseName, WebDriver driver) throws IOException {
		
		// take screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File ssFile = ts.getScreenshotAs(OutputType.FILE);
		
		// Copy to desired location
		String destinationFile = screenshotPath + failedTestCaseName + "FailureScreenshot.png";
		FileUtils.copyFile(ssFile, new File(destinationFile));
				
	}
}
