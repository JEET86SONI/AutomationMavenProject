package com.freecrm.qa.testcases;

//import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.freecrm.qa.base.BaseClass;
import com.freecrm.qa.pages.ContextPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.utilities.TestUtil;

public class HomePageTest extends BaseClass {
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContextPage contextpage;
	public HomePageTest() {
		super();
	}
	//test cases should be separated -- independent with each other
	//before each test cases-- launch the browser and login
	//@test --execute the test case
	//after each test cases-- closed the browser
	@BeforeMethod
	public void setUp() {
		initilization();
		testutil = new TestUtil();
		loginpage = new LoginPage();
		contextpage = new ContextPage();
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String HomePagetitle = homepage.verifyHomePageTitle();
	Assert.assertEquals(HomePagetitle,"CRMPRO","Home page title not Matched");
	}
	
	@Test(priority =2)
	
	public void  verifyUserNameTest() {
		testutil.switchToFrame();
	Assert.assertTrue(homepage.verifyUserName());	
	
		}
	@Test(priority =3)
	public void verifyContactLinkTest() {
		testutil.switchToFrame();
		contextpage = homepage.clickOnContactLink();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
