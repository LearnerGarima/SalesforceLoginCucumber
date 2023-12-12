package utilities;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import testcase.BaseTest;




public class EventListeners extends BaseTest implements ITestListener{
	public EventListeners(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static ExtentReports extentUtilityObject;

	@Override
	public void onTestStart(ITestResult result) { 
		extentUtilityObject.startSingleTestReport(result.getMethod().getMethodName());	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentUtilityObject.logTestpassed(result.getMethod().getMethodName()+" is passed");	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentUtilityObject.logTestFailed(result.getMethod().getMethodName()+" is failed");
		String filename=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		System.out.println("filename="+filename);
		String path=Constants.SCREENSHOTS_DRECTORY_PATH+filename+".png";
		takescreenshot(path);
		extentUtilityObject.logTestWithscreenshot("./screenshots/"+filename+".png");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		extentUtilityObject=ExtentReports.getInstance();
		System.out.println("report utility object created="+extentUtilityObject.toString());
		extentUtilityObject.startExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		extentUtilityObject.endReport();
	}
	
}
