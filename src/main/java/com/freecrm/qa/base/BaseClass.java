package com.freecrm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.freecrm.qa.utilities.TestUtil;
import com.freecrm.qa.utilities.WebEventListners;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListners eventlistners;
	
	public BaseClass() {
		try {
		prop = new Properties();
		FileInputStream ip = new  FileInputStream("C:\\Users\\user\\eclipse-workspace\\AutomationMavenProject\\src\\main\\java\\com\\freecrm\\qa\\config\\config.properties");
	prop.load(ip);
		}catch(FileNotFoundException e) { 
			e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
	}
	
	public static void initilization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		}
		
//		e_driver = new EventFiringWebDriver(driver);
//		// Now create object of EventListerHandler to register it with EventFiringWebDriver
//		eventlistners = new WebEventListners();
//		e_driver.register(eventlistners);
//		driver = e_driver;
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

	driver.get(prop.getProperty("url"));
	}
	
}
