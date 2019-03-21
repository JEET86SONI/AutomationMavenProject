package com.freecrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.BaseClass;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;

public class LoginPageTest extends BaseClass {
	LoginPage loginpage;
	HomePage homepage;
	
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initilization();
		 loginpage = new LoginPage();
		
	}
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginpage.validateLoginPage();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test(priority =2)
	public void crmLogoImageTest() {
		boolean flag = loginpage.validateCRMLogno();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void loginTest() {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
