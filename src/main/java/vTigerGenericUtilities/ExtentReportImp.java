package vTigerGenericUtilities;

import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportImp implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;
	

	public void onTestStart(ITestResult result) {
		
		test=report.createTest(result.getMethod().getMethodName());
	}

	
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS,result.getMethod().getMethodName() );
		test.log(Status.PASS, result.getThrowable());
	}

	
	public void onTestFailure(ITestResult result) {
		
		test.log(Status.FAIL,result.getMethod().getMethodName() );
		test.log(Status.FAIL, result.getThrowable());
		
		String screenShot=null;
		
		try {
			screenShot=WebDriverUtility.takeScreenShotEx(BaseClass.sdriver, result.getMethod().getMethodName());
			} catch (Throwable e) {
				e.printStackTrace();
			}
			test.addScreenCaptureFromPath(screenShot);
			
			
		
	}

	
	public void onTestSkipped(ITestResult result) {
		

		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
		
		String dateAndTime=new Date().toString().replace(" ","_").replace(":","_");
		ExtentSparkReporter spark=new ExtentSparkReporter("ExtentReport/report.html"+dateAndTime);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("vTigerReport");
		spark.config().setReportName("Shubha");
		
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("platform", "Windows");
		report.setSystemInfo("executed By", "Shubha");
		report.setSystemInfo("reviewed By", "Shubha");
		
	}

	
	public void onFinish(ITestContext context) {
		
		report.flush();
	}

	
	
}
