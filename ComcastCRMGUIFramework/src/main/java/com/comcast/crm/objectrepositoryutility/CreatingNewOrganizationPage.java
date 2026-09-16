package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreatingNewOrganizationPage extends WebDriverUtility{

	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "accountname")
	private WebElement orgNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name = "industry")
	private WebElement industryDD;
	
	@FindBy(name = "accounttype")
	private WebElement typeDD;
	
	@FindBy(name = "phone")
	private WebElement phoneNoEdt;

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getIndustryDB() {
		return industryDD;
	}
	
	
	public WebElement getTypeDD() {
		return typeDD;
	}

	public WebElement getPhoneNoEdt() {
		return phoneNoEdt;
	}

	public void createOrg(String orgName) {
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	
	
	public void createOrg(String orgName,String industry,String type) {
		orgNameEdt.sendKeys(orgName);
		select(industryDD,industry);
		select(typeDD,type);
		saveBtn.click();
	}
	
	public void createOrg(String orgName,String phNo) {
		orgNameEdt.sendKeys(orgName);
		phoneNoEdt.sendKeys(phNo);
		saveBtn.click();
	}
}
