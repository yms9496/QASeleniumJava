package listeners;

import java.sql.SQLException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utilities.BaseClass;

public class DBConnectionManagerListener extends BaseClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {

//		try {
//			getDBConnection();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
//		try {
//			closeDBConnection();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	
	
}
