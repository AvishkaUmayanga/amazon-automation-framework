package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	static ExtentReports extentReport;
	ExtentTest extentTest;
	
	public static ExtentReports getExtentReport() {
		String extentReportPath = System.getProperty("user.dir")+"\\reports\\extentreporter.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
		
		reporter.config().setReportName("Automation Result");
		reporter.config().setDocumentTitle("Amazon Automation");
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("Operating System", "Windows 10");
		extentReport.setSystemInfo("Test by", "Avishka");
		
		return extentReport;
	}
}
