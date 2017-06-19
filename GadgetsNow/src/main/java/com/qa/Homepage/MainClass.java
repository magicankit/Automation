package com.qa.Homepage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainClass 
{
	static WebDriver driver;
	
	@BeforeTest	
	public static void UrlLaunch() 
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\c-ankit.arora\\Downloads\\geckodriver-v0.17.0-win64\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		driver = new FirefoxDriver(capabilities);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.gadgetsnow.com/");
	}
	@Test
	public void popup() throws InterruptedException {
		HomePage objectHomePage = new HomePage(driver);
		objectHomePage.handlepopup();
		objectHomePage.Navsize();
	}
	
	@AfterTest
	public void closebrowser()
	{
		driver.close();
	}
}