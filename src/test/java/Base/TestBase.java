package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.POIHelper;
import utilities.TestUtil;

public class TestBase {

	
	// All initialising happens here. Common starting point for all test cases.
	
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static FileInputStream fi_OR;
	public POIHelper myPOIHelper=null;
	public static WebDriverWait wait;
	
	
	
	public Boolean isElementPresent(By by)
	{
		try
		{
			driver.findElement(by);
			return true;
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
	}
	
	@BeforeSuite
	public void setUP() throws IOException
	{
	
		if(driver==null)
		{
			log.debug("Execution started.");
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\config.properties");
			fi_OR = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\OR.properties");
			config.load(fis);
			log.info("Config file loaded!!");
			OR.load(fi_OR);
			if(config.getProperty("browser").equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Executables\\geckodriver.exe");
				driver=new FirefoxDriver();
			}
			else if(config.getProperty("browser").equals("chrome"))
			{
				//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Executables\\chromedriver.exe");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				log.debug("Chrome launched..");
			}
			
			driver.get(config.getProperty("siteURL"));
			log.debug("NAvigated the the required page.");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("waiting_time")), TimeUnit.SECONDS);
			wait=new WebDriverWait(driver,5);
			
		}
		
		
	}
	
	public static void verifyEquals(String actual,String Expected) throws IOException
	{
		try
		{
			Assert.assertEquals(actual, Expected);
		}
		catch(Exception e)
		{
			TestUtil.CAptureScreenShot();
		}
	}
	
	@AfterSuite
	public void tearDown()
	{
		if(driver!= null)
		{
			log.debug("Execution completed.");
			driver.quit();
		}
	}
	
	
	
	
	
}
