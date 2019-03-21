package com.freecrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.freecrm.qa.base.BaseClass;

public class ContextPage extends BaseClass {
	
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactlabel;
	
	@FindBy(id = "first_name")
	WebElement firstName;
	
	@FindBy(id = "surname")
	WebElement lastName;
	
	@FindBy(name = "client_lookup")
	WebElement companyName;

	@FindBy(xpath = "//input[@value='Save and Create Another (same company)']//preceding-sibling::input[@value='Save']")
	WebElement saveBtn;
	
	
	//initializing the page object
public ContextPage() {
	PageFactory.initElements(driver, this);
}


public boolean veridyContactLabel(){
return 	contactlabel.isDisplayed();
	}
	
public void selectContactByName(String name) {
	driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
			+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
}

public void createNewContact(String title,String ftName, String ltName,String comName) {
	Select select = new Select(driver.findElement(By.name("title")));
	select.selectByVisibleText(title);
	firstName.sendKeys(ftName);
	lastName.sendKeys(ltName);
	companyName.sendKeys(comName);
	saveBtn.click();
}

}