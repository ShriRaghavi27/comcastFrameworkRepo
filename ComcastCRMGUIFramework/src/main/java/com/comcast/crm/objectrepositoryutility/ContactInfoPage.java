package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	WebDriver driver;
	public ContactInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerInfo;
	
	@FindBy(xpath = "//span[@id='dtlview_Last Name']")
	private WebElement lastName;
	
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement orgName;
	
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement stDate;
	
	@FindBy(id = "dtlview_Support End Date")
	private WebElement endDate;
	
	public WebElement getHeaderInfo() {
		return headerInfo;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getStDate() {
		return stDate;
	}

	public WebElement getEndDate() {
		return endDate;
	}
	
	

}
