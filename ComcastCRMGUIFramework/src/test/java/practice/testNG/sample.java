package practice.testNG;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class sample {
@Test
public void sampleTest()
{
	WebDriver driver = new ChromeDriver();
	driver.get("http://49.249.29.4:8888/");
	driver.quit();
	TakesScreenshot ts=(TakesScreenshot)driver;
	String filepath = ts.getScreenshotAs(OutputType.BASE64);
	
}
}
