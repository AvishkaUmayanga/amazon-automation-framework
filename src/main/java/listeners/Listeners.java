package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resouces.Base;
import utilities.ExtentReporter;

public class Listeners extends Base implements ITestListener {
	
	ExtentReports extentReport = ExtentReporter.getExtentReport();
	ExtentTest extentTest;
	WebDriver driver;
	
	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getName();
		extentTest = extentReport.createTest(testName);
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		extentTest.log(Status.PASS,testName+" Test Passed.");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		extentTest.fail(result.getThrowable());
		String testMethodName = result.getName();
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			
			String screenshotFilePath = takeScreenshot(testMethodName,driver);
			extentTest.addScreenCaptureFromPath(screenshotFilePath,testMethodName);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	} 

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getName();
		extentTest.log(Status.SKIP, testName+" Test Skipped.");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		
		
	}

	 @Override
	    public void onFinish(ITestContext context) {
	        extentReport.flush(); 
	    }
}




