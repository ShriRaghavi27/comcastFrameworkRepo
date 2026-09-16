package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement ConLink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement CampaignLink;
	
	@FindBy(linkText = "Products")
	private WebElement proLink;
	
	@FindBy(linkText = "More")
	private WebElement MoreLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminBtn;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutBtn;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getConLink() {
		return ConLink;
	}

	public WebElement getCampaignLink() {
		return CampaignLink;
	}

	public WebElement getMoreLink() {
		return MoreLink;
	}
	
	public WebElement getAdminBtn() {
		return adminBtn;
	}

	public WebElement getSignOutBtn() {
		return SignOutBtn;
	}

	public void navigateToCampaignPage() {
		mouseMoveOnElement(driver, CampaignLink);
		CampaignLink.click();
	}
	
	public void logout()
	{
		mouseMoveOnElement(driver, adminBtn);
		SignOutBtn.click();
	}
	
}
