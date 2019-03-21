package com.freecrm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.BaseClass;

public class LoginPage extends BaseClass{

	//Page Factory
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//div[@class='input-group-btn']/input[@type='submit' and @value='Login' and @class='btn btn-small']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[contains(@href,'register')]/font[text()='Sign Up']")
	WebElement signupBtn;

	@FindBy(xpath = "//img[contains(@class,'img-responsive') and @alt ='free crm logo']")
	WebElement crmLogo; 
	
	//Initializing the page Object
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
//Actions
public String validateLoginPage() {
	String title = driver.getTitle();
	return title;
}
public boolean validateCRMLogno() {
	return crmLogo.isDisplayed();
}
public HomePage login(String un,String pw) {
	username.sendKeys(un);
	password.sendKeys(pw);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", loginBtn);
	
	return new HomePage();
}

}
