package com.freecrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.freecrm.qa.base.BaseClass;
import com.freecrm.qa.pages.ContextPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.utilities.TestUtil;

public class ContextPageTest extends BaseClass {
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContextPage contextpage;
	String sheetName = "contact";
	public ContextPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initilization();
		testutil = new TestUtil();
		loginpage = new LoginPage();
		contextpage = new ContextPage();
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		testutil.switchToFrame();
		contextpage = homepage.clickOnContactLink();
		}
	
	@Test(priority =1)
	public void verifyContactPageLabelTest() {
		 Assert.assertTrue(contextpage.veridyContactLabel(),"Contacts label is missing on the Page");	
	}
	
	@Test(priority = 2)
	public void selectSingleContactTextTest() {
		contextpage.selectContactByName("durga soni");
	}
	@Test(priority = 3)
	public void selectMultipleContactTextTest() {
		contextpage.selectContactByName("durga soni");
		contextpage.selectContactByName("Anika soni");
	}
	
	@DataProvider
	public  Object[][] getCrmTestData() {
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(priority = 4, dataProvider ="getCrmTestData")
	public void validateNewContact(String title,String firstname, String lastname,String company) {
		homepage.clickOnNewContact();
		//contextpage.createNewContact("Mr.","Tom", "Peter", "Google");
		contextpage.createNewContact(title, firstname, lastname, company);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
