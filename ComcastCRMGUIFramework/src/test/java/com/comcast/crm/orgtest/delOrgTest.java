package com.comcast.crm.orgtest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizatioInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class delOrgTest {

	public static void main(String[] args) throws IOException {

		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String BROWSER =fLib.getDataFromPropertiesFile("browser");
		String URL=fLib.getDataFromPropertiesFile("url");
		String USERNAME=fLib.getDataFromPropertiesFile("username");
		String PASSWORD=fLib.getDataFromPropertiesFile("password");
		
		String ORGANIZATION_NAME = eLib.getDataFromExcelFile("org", 7, 2)+jLib.getRandomNumber();
		
		WebDriver driver=null;
		if(BROWSER.equals("chrome"))
		{
			
			driver=new ChromeDriver();
		}else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}else if(BROWSER.equals("edge"))
		{
			driver=new EdgeDriver();
		}else driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		wLib.waitForPageToLoad(driver);
		
		//login to app
		LoginPage l=new LoginPage(driver);
		l.Login(URL,USERNAME, PASSWORD);
		
		//navigate to organization module
		HomePage op=new HomePage(driver);
		op.getOrgLink().click();
		
		//click on "create Organization" Button
		OrganizationsPage cnp=new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();
		
		//enter all details & create new Organization
		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
		cnop.createOrg(ORGANIZATION_NAME);
		
		//Verify Header msg Expected Result
		OrganizatioInfoPage oip=new OrganizatioInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		if(actOrgName.contains(ORGANIZATION_NAME)){
			System.out.println(ORGANIZATION_NAME+"name is verified == PASS");
		}else {System.out.println(ORGANIZATION_NAME+"name is not verified == FAIL");
		}
		//go tback to organization link
		op.getOrgLink().click();
		
		//search for organization
		cnp.getSerchEdt().sendKeys(ORGANIZATION_NAME);
		wLib.select(cnp.getSearchDD(),"Organization Name");
		cnp.getSearchBtn().click();
		
		driver.findElement(By.xpath("//a[text()='"+ORGANIZATION_NAME+"']/../../td[8]/a[text()='del']")).click();
		wLib.switchToAlertAndAccept(driver);
		
		op.logout();
		
		driver.quit();
	}

}
