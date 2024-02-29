package supports;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReportsClass implements ITestListener, Constants {
	public static ExtentReports extentReport = new ExtentReports();
	public static ExtentSparkReporter htmlReporter = new ExtentSparkReporter("reports/myReports.html");
	public static ExtentTest extentTest;

	public void onTestStart(ITestResult result) {
		extentReport.attachReporter(htmlReporter);
	}

	public void onTestSuccess(ITestResult result) {

		extentTest.log(Status.INFO, "All Steps are Passed");

	}

	public void onTestFailure(ITestResult result) {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationpath = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator
				+ result.getName() + ".png";

		File finalDestination = new File(destinationpath);

		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		extentTest.log(Status.FAIL, "Step is fail , see the screenshot please")
				.addScreenCaptureFromPath(destinationpath);

	}

	public void onFinish(ITestContext context) {
		extentTest.log(Status.PASS, "Testing Website Done");
		extentReport.flush();
	}

}
