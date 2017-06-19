package com.qa.Homepage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage
{

	static String LINKS_START_XPATH = ".//*[@id='navigation']/div/ul/li[";
	static String LINKS_END_XPATH = "]/a";
	
//Declaring WebDriver
	WebDriver driver;
	int i;
	
// Constructor	
	public HomePage (WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void handlepopup()
	 {
		System.out.println("Pop-up");
		driver.findElement(By.xpath(".//div[@class='ntfc_buttongroup details']/button[@class='ntfc_dactive']")).click();
			 }
	// Size determine and Print Navigation elements
	 public void Navsize() throws InterruptedException
	 {
		 try
		 {
		 System.out.println("Calculating Navigation Size");
		 int size=driver.findElements(By.xpath(".//*[@id='navigation']/div/ul/li/a")).size();
		System.out.println("Length is" + size);
		for ( i=3;i<size;i++)
			{
				String text = driver.findElement(By.xpath(LINKS_START_XPATH+i+LINKS_END_XPATH)).getText();
				// String text = driver.findElement(By.xpath(LINKS_START_XPATH+i+LINKS_END_XPATH)).get().
									
				System.out.println(text + i);
				//Thread.sleep(10000);
				
			 driver.findElement(By.xpath(LINKS_START_XPATH+i+LINKS_END_XPATH)).click();
			 String browserTitle = driver.getTitle();
			 System.out.println(browserTitle);
			 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			 driver.navigate().back();
			 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			}						
			}
		 catch(Exception e)
		 {
		 
		 }
			}
	 
	 public void mousehover ()
	 {
		 try
		 {
		 WebElement navigation = driver.findElement(By.xpath(LINKS_START_XPATH+i+LINKS_END_XPATH));
		 Actions action_navigation = new Actions(driver);
		 action_navigation.moveToElement(navigation).perform();
		 
		 System.out.println("Checking Mouse Hovering Functionality");
		 int size=driver.findElements(By.xpath(".//*[@id='navigation']/div/ul/li/a")).size();
		 System.out.println(size);
		 for (int i=3;i<size;i++)

		 {
			 String text = driver.findElement(By.xpath(LINKS_START_XPATH+i+LINKS_END_XPATH)).getText();
			 System.out.println(text + i);
		 	if (text.equals("NEWS"))
		 	{
		 		System.out.println("Hovering");
		 		WebElement element_mobile = driver.findElement(By.xpath(".//*[@id='navigation']/div/ul/li[4]/a"));


		 		Actions action_mobile = new Actions(driver);
		 		action_mobile.moveToElement(element_mobile).perform();

		 	}

			 // Mouse Over on News Link
			 /*WebElement element_mobile = driver.findElement(By.xpath(".//*[@id='navigation']/div/ul/li[4]/a"));
			 Actions a1 = new Actions(driver);
			 a1.moveToElement(element_mobile).perform();*/
			 
		 }
		 }
		 catch(Exception e)
		 {
		 }
		 }
	 }

