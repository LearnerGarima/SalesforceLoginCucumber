package utilities;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.MediaEntityBuilder;


public class ExtentReports {
	public static ExtentReports report ;
	public static ExtentSparkReporter spark;
	public static ExtentTest testLogger;
	private static ExtentReports extentObject;
	
	private ExtentReports() {
		
	}
	
	public static ExtentReports getInstance() {
		if(extentObject==null) {
			extentObject=new ExtentReports();
		}

		return extentObject;
	}
	
	public void startExtentReport() {
		report= new ExtentReports();
		spark = new ExtentSparkReporter(Constants.SPARKS_HTML_REPORT_PATH);
		report.setSystemInfo("Host Name", "Salesforce");
		report.setSystemInfo("Environment", "QA");
		report.setSystemInfo("User Name", "Garima");
		
		spark.config().setDocumentTitle("Test Execution Report");
		spark.config().setReportName("Salesforce Regression Tests");
		spark.config().setTheme(Theme.DARK);
		report.attachReporter(spark);	
	}
	
	public void startSingleTestReport(String methodName) {
		testLogger=report.createTest(methodName);
	}
	public void endReport() {
		report.flush();
	}
	
	public void logTestInfo(String text) {
		testLogger.log(Status.INFO,text);
		//testLogger.info(text);
	}
	
	public void logTestpassed(String text) {
		testLogger.log(Status.PASS,MarkupHelper.createLabel(text, ExtentColor.GREEN));
	}
	
	public void logTestFailed(String text) {
		testLogger.log(Status.FAIL,MarkupHelper.createLabel(text, ExtentColor.RED));
	}
	
	public void logTestFailedWithException(Throwable e) {
		testLogger.log(Status.FAIL,e);
	
		}
	
	public void logTestWithscreenshot(String path) {
		
		testLogger.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		
	}

}