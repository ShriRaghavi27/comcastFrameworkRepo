package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizatioInfoPage {
	WebDriver driver;

	public OrganizatioInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "dvHeaderText")
	private WebElement headerMsg;
	
	@FindBy(xpath  = "//span[@id='dtlview_Industry']")
	private WebElement industryName;
	
	@FindBy(xpath = "//span[@id='dtlview_Type']")
	private WebElement typeName;
	
	@FindBy(xpath  = "//span[@id='dtlview_Phone']")
	private WebElement phoneNo;

	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getIndustryName() {
		return industryName;
	}

	public WebElement getTypeName() {
		return typeName;
	}

	public WebElement getPhoneNo() {
		return phoneNo;
	}

}
