package testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;

public class LoginTest extends TestBase{

	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	
	
	
	
	
	@Test
	public void loginAs_BANKmanager() throws InterruptedException
	{
		
		System.out.println(OR.size());
		log.debug("Inside login Test..");
		System.out.println(OR.getProperty("Bank_MAnager_Login_BTN_Home"));
		driver.findElement(By.xpath(OR.getProperty("Bank_MAnager_Login_BTN_Home"))).click();
		
		//Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("ADD_customer"))));
		Thread.sleep(3000);
		log.debug("Loggin Ececuted.");
	}
}
