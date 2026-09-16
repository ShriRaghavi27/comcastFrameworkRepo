package practice.testNG;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {
	ExtentReports report;
	@BeforeSuite
	public void configBS()
	{	//spark report Config
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvancedReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		//add env info 
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "windows-11");
		report.setSystemInfo("BROWSER", "CHROME-115");
	}
	@AfterSuite
	public void configAS()
	{
		report.flush();
	}
	@Test
	public void creatContactTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://49.249.29.4:8888/");
		TakesScreenshot ts=(TakesScreenshot)driver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		ExtentTest test=report.createTest("creatContactTest");
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		if("HDFC".equals("HTFC"))
		{
			test.log(Status.PASS, "contact is created");
		}else test.addScreenCaptureFromBase64String(filepath,"ErrorFile_"+time);
	}
}
