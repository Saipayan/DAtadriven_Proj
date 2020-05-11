package testcases;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;


import utilities.POIHelper;
import utilities.TestUtil;


public class AddCustomertTEST extends TestBase {

	
	
	
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void AddCustomer(String first_name,String last_name,String post_code,String Alert_TExt) throws InterruptedException
	{
		
		System.out.println("Hello");
		driver.findElement(By.xpath(OR.getProperty("ADD_customer"))).click();
		driver.findElement(By.xpath(OR.getProperty("FIRSTNAME_CUSTOMER"))).sendKeys(first_name);
		driver.findElement(By.xpath(OR.getProperty("LASTNAME_CUSTOMER"))).sendKeys(last_name);
		driver.findElement(By.xpath(OR.getProperty("POST_CODE"))).sendKeys(post_code);
		
		driver.findElement(By.xpath(OR.getProperty("Add_CUSTOMER_BTN"))).click();
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		
		Assert.assertTrue(alert.getText().contains(Alert_TExt));
		
		alert.accept();
		
		//Assert.fail("FAILED");
		
		Thread.sleep(3000);
	}
	
	
	
	
}
