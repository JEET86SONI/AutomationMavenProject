package com.freecrm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(xpath = "//td[contains(text(),'User: JITENDRA SONI')] [@align ='left']")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactLinks;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement taskLinks;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContact;
	
	public HomePage() {
		super();
	PageFactory.initElements(driver, this);	
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
		 
	}
	
	public boolean verifyUserName() {
		
		return userNameLabel.isDisplayed();
	}
	
	public ContextPage clickOnContactLink() {
		contactLinks.click();
		return new ContextPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TaskPage clickOnTaskLink() {
		taskLinks.click();
		return new TaskPage();
	}
	public void clickOnNewContact() {
		Actions action = new Actions(driver);
		action.moveToElement(contactLinks).build().perform();
		newContact.click();
	}
	
}
