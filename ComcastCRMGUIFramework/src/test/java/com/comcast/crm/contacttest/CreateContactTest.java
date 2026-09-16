package com.comcast.crm.contacttest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizatioInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateContactTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createContactTest() throws IOException {
		// Read test data from Excel file utility
		UtilityClassObject.getTest().log(Status.INFO, "Read data from excel");
		String LAST_NAME = eLib.getDataFromExcelFile("Contact", 1, 2) + jLib.getRandomNumber();
		
		// Step 2:Navigate to contact module
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to contact Module");
		HomePage hp = new HomePage(driver);
		hp.getConLink().click();

		// Step 3: Click on "Create Contacts" Button
		UtilityClassObject.getTest().log(Status.INFO, "Click on Create Contact");
		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewContactBtn().click();
		
		// Step 4: Enter all the details & create new Contact
		UtilityClassObject.getTest().log(Status.INFO, "Create a new contact with lastname");
		CreateNewContactPage cnp = new CreateNewContactPage(driver);
		cnp.createContact(LAST_NAME);
		
		UtilityClassObject.getTest().log(Status.INFO, LAST_NAME + " Contact Created");
		
		// Verify LastName info Expected Result
		ContactInfoPage cip = new ContactInfoPage(driver);

		String actHeader = cip.getHeaderInfo().getText();
		Assert.assertEquals(actHeader, LAST_NAME);
		UtilityClassObject.getTest().log(Status.INFO, LAST_NAME + " contact is created");
		
		String actLastName = cip.getLastName().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actLastName, LAST_NAME);
		soft.assertAll();
		UtilityClassObject.getTest().log(Status.INFO, actLastName + " is verified");

	}

	@Test(groups = "regressionTest")
	public void createContactWithSupportDateTest() throws Throwable {
		// Read test data from Excel file utility
		UtilityClassObject.getTest().log(Status.INFO, "Read data from excel");
		String LAST_NAME = eLib.getDataFromExcelFile("Contact", 4, 2);
		
		// Step 2:Navigate to contact module
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to contact Module");
		HomePage hp = new HomePage(driver);
		hp.getConLink().click();
		
		// Step 3: Click on "Create Contacts" Button
		UtilityClassObject.getTest().log(Status.INFO, "Click on Create Contact");
		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewContactBtn().click();
		

		UtilityClassObject.getTest().log(Status.INFO,"Create a new contact with support start date and support end date");
		CreateNewContactPage cnp = new CreateNewContactPage(driver);

		String startDate = jLib.getSystemDateYYYYDDMM();
		String afterDateRequired = jLib.getRequiredDate(35);
		cnp.createContactWithSupportDate(LAST_NAME, startDate, afterDateRequired);

		ContactInfoPage cip = new ContactInfoPage(driver);

		String actStartDate = cip.getStDate().getText();
		Assert.assertEquals(actStartDate, startDate);
		UtilityClassObject.getTest().log(Status.INFO, startDate + " support start date is verified");

		String actEndDate = cip.getEndDate().getText();
		Assert.assertEquals(actEndDate, afterDateRequired);
		UtilityClassObject.getTest().log(Status.INFO, startDate + " support end date is verified");

	}

	@Test(groups = "regressionTest")
	public void createContactWithOrgTest() throws Throwable {
		// Read test data from Excel file utility
		UtilityClassObject.getTest().log(Status.INFO, "Read data from excel");
		String OrgName = eLib.getDataFromExcelFile("Contact", 7, 2) + jLib.getRandomNumber();
		String LastName = eLib.getDataFromExcelFile("Contact", 7, 3) + jLib.getRandomNumber();
		
		// Navigate to organization module
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to organization Module");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		//Click on "Create organization" Button
		UtilityClassObject.getTest().log(Status.INFO, "Click on Create organization");
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		//Enter all the details and create an Organization
		UtilityClassObject.getTest().log(Status.INFO, "Create a new Organization");
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(OrgName);
		
		UtilityClassObject.getTest().log(Status.INFO, "Organization Created");
		
		// Verify Header message
		OrganizatioInfoPage oip = new OrganizatioInfoPage(driver);
		String headerInfo = oip.getHeaderMsg().getText();
		Assert.assertTrue(headerInfo.contains(OrgName));
		
		//Navigate to Contacts module
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Contacts Module");
		hp.getConLink().click();
		
		// Click on "Create Contacts" Button
		UtilityClassObject.getTest().log(Status.INFO, "Click on Create Contact");
		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewContactBtn().click();
		
		// Enter all the details and create new Contact
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContactWithOrg(LastName, OrgName);
		
		UtilityClassObject.getTest().log(Status.INFO,LastName + " contact is created with Orgnaization " + OrgName);

		// Verify LastName Name
		ContactInfoPage cip = new ContactInfoPage(driver);
		String headerconInf = cip.getHeaderInfo().getText();
		Assert.assertTrue(headerconInf.contains(LastName));
		
		// Verify Organization Name
		String actOrgname = cip.getOrgName().getText().trim();
		Assert.assertTrue(actOrgname.equals(OrgName));
	}
}
