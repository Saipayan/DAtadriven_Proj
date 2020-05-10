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

import utilities.POIHelper;
import utilities.TestUtil;
import Base.TestBase;


public class OpenAccount extends TestBase {
	
	
	
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void Openaccouunt(String Customer,String Currency) throws InterruptedException
	{
		
		System.out.println("Customer");
		System.out.println("Currency");
	}
	
	
	

}
