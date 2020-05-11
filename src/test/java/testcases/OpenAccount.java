package testcases;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.POIHelper;
import utilities.TestUtil;
import Base.TestBase;


public class OpenAccount extends TestBase {
	
	
	
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void Openaccount(String Customer,String Currency) throws InterruptedException
	{
		
		System.out.println("Customer");
		System.out.println("Currency");
		
		WebElement dropdown;
		driver.findElement(By.xpath(OR.getProperty("OPN_Account_BTN"))).click();
		dropdown=driver.findElement(By.xpath(OR.getProperty("CustomerNAME_OPENAccount")));
		
		Select select = new Select(dropdown);
		select.selectByVisibleText(Customer);
		
		

		dropdown=driver.findElement(By.xpath(OR.getProperty("Currency_OpenACCOUNT")));
		
		Select select_ = new Select(dropdown);
		select_.selectByVisibleText(Currency);
		
		driver.findElement(By.xpath(OR.getProperty("Process_BTN"))).click();
		

		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		
		//Assert.assertTrue(alert.getText().contains(Alert_TExt));
		
		alert.accept();
		
		//Assert.fail("FAILED");
		
		Thread.sleep(3000);
		
		
		
	}
	
	
	

}
