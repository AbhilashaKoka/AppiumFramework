package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentsReportDemo {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent ;
	public ExtentsReportDemo() {
		// TODO Auto-generated constructor stub
	}

	@BeforeSuite
	public void reportsetup() {
		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
        
        
	}
	@AfterSuite
	public void reportteardown() {
		extent.flush();
	}
	
	 
}
