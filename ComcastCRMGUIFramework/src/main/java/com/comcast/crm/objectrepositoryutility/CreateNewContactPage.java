package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{
	WebDriver driver;
	public CreateNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "lastname")
	private WebElement lastName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//input[@name=\"account_name\"]/following-sibling::img")
	private WebElement orgBtn;
	
	@FindBy(name = "search_text")
	private WebElement searchOrgTxt;
	
	@FindBy(name = "search")
	private WebElement searchOrgBtn;
	
	@FindBy(name = "support_start_date")
	private WebElement startDate;
	
	@FindBy(name = "support_end_date")
	private WebElement endDate;
	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getOrgBtn() {
		return orgBtn;
	}

	public WebElement getSearchOrgTxt() {
		return searchOrgTxt;
	}

	public WebElement getSearchOrgBtn() {
		return searchOrgBtn;
	}

	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getEndDate() {
		return endDate;
	}
	public void createContact(String lastname) {
		lastName.sendKeys(lastname);
		saveBtn.click();
	}
	
	public void createContactWithSupportDate(String lastname,String stDate, String edDate)
	{
		lastName.sendKeys(lastname);
		startDate.clear();
		startDate.sendKeys(stDate);
		endDate.clear();
		endDate.sendKeys(edDate);
		saveBtn.click();
		
	}
	public void createContactWithOrg(String lastname,String orgName)
	{
		lastName.sendKeys(lastname);
		orgBtn.click();
		switchToTabOnURL(driver, "module=Accounts");
		searchOrgTxt.sendKeys(orgName);
		searchOrgBtn.click();
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();
		switchToTabOnURL(driver, "module=Contacts");
		saveBtn.click();
	}
	
}
