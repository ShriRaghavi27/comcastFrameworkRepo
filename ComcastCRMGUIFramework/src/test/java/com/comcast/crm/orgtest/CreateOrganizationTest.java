package com.comcast.crm.orgtest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.listenerUtility.ListImpClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizatioInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void creatOrgTest() throws IOException {
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		String ORGANIZATION_NAME = eLib.getDataFromExcelFile("org", 1, 2) + jLib.getRandomNumber();

		// navigate to organization module
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Organization Module");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// click on "create Organization" Button
		UtilityClassObject.getTest().log(Status.INFO, "Click on Create Organization");
		OrganizationsPage onp = new OrganizationsPage(driver);
		onp.getCreateNewOrgBtn().click();

		// enter all details & create new Organization
		UtilityClassObject.getTest().log(Status.INFO, "Create a new Organization");
		CreatingNewOrganizationPage cnp = new CreatingNewOrganizationPage(driver);
		cnp.createOrg(ORGANIZATION_NAME);
		
		UtilityClassObject.getTest().log(Status.INFO, ORGANIZATION_NAME + " Organization Created");
		
		// Verify Header msg Expected Result
		OrganizatioInfoPage oip = new OrganizatioInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		Assert.assertEquals(true,actOrgName.contains(ORGANIZATION_NAME));
		UtilityClassObject.getTest().log(Status.INFO, ORGANIZATION_NAME + " organization is verified");
		
	}

	@Test(groups = "regressionTest")
	public void CreateOrganizationWithIndustriesTest() throws IOException {
		
		// read TestScript data from Excel file
		UtilityClassObject.getTest().log(Status.INFO, "Read data from excel");
		String ORGANIZATION_NAME = eLib.getDataFromExcelFile("org", 4, 2) + jLib.getRandomNumber();
		String INDUSTRIES = eLib.getDataFromExcelFile("org", 4, 3);
		String TYPE = eLib.getDataFromExcelFile("org", 4, 4);
		
		// step 2 : navigate to Organization module
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Organization Module");
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		
		// step 3 : click on "Create Organization" Button
		UtilityClassObject.getTest().log(Status.INFO, "Click on Create Organization");
		OrganizationsPage onp = new OrganizationsPage(driver);
		onp.getCreateNewOrgBtn().click();
		
		// step 4 : Enter all the details and create an Organization
		UtilityClassObject.getTest().log(Status.INFO, "Create a new Organization with industry and type");
		CreatingNewOrganizationPage cnp=new CreatingNewOrganizationPage(driver);
		cnp.createOrg(ORGANIZATION_NAME, INDUSTRIES, TYPE);
		
		UtilityClassObject.getTest().log(Status.INFO, ORGANIZATION_NAME + " Organization Created");
		
		// Verify the industries and type info
		OrganizatioInfoPage oip=new OrganizatioInfoPage(driver);
		
		UtilityClassObject.getTest().log(Status.INFO, "Verify industry name");
		String actIndustries = oip.getIndustryName().getText().trim();
		Assert.assertEquals(actIndustries, INDUSTRIES);
		UtilityClassObject.getTest().log(Status.INFO, INDUSTRIES + " is verified");

		UtilityClassObject.getTest().log(Status.INFO, "Verify type name");
		String actType = oip.getTypeName().getText().trim();
		Assert.assertEquals(actType, TYPE);
		UtilityClassObject.getTest().log(Status.INFO, TYPE + " is verified");
		
	}

	@Test(groups = "regressionTest")
	public void CreateOrganizationWithPhoneNumberTest() throws IOException {
		// read TestScript data from Excel file
		UtilityClassObject.getTest().log(Status.INFO, "Read data from excel");
		String ORGANIZATION_NAME =eLib.getDataFromExcelFile("org", 7, 2)+jLib.getRandomNumber();
		String PHONENUMBER = eLib.getDataFromExcelFile("org", 7, 3);
		
		// step 2 : navigate to Organization module
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Organization Module");
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		
		// step 3 : click on "Create Organization" Button
		UtilityClassObject.getTest().log(Status.INFO, "Click on Create Organization");
		OrganizationsPage onp = new OrganizationsPage(driver);
		onp.getCreateNewOrgBtn().click();
		
		// enter all details & create new Organization
		UtilityClassObject.getTest().log(Status.INFO, "Create a new Organization");
		CreatingNewOrganizationPage cnp=new CreatingNewOrganizationPage(driver);
		cnp.createOrg(ORGANIZATION_NAME, PHONENUMBER);
		
		UtilityClassObject.getTest().log(Status.INFO, ORGANIZATION_NAME + " Organization Created");

		// Verify PhoneNumber Expected Result
		UtilityClassObject.getTest().log(Status.INFO, "Verify Phone Number");
		OrganizatioInfoPage oip=new OrganizatioInfoPage(driver);
		String actPhone = oip.getPhoneNo().getText();
		
		Assert.assertEquals(actPhone,PHONENUMBER );
		UtilityClassObject.getTest().log(Status.INFO, PHONENUMBER + " is verified");
	}

}
