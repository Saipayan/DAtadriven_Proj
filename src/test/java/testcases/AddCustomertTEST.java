package testcases;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;
import utilities.POIHelper;

public class AddCustomertTEST extends TestBase {

	
	
	
	@Test(dataProvider="getDATA")
	public void AddCustomer(String first_name,String last_name,String post_code)
	{
		
		System.out.println("Hello");
		driver.findElement(By.xpath(OR.getProperty("ADD_customer"))).click();
		driver.findElement(By.xpath(OR.getProperty("FIRSTNAME_CUSTOMER"))).sendKeys(first_name);
		driver.findElement(By.xpath(OR.getProperty("LASTNAME_CUSTOMER"))).sendKeys(last_name);
		driver.findElement(By.xpath(OR.getProperty("POST_CODE"))).sendKeys(post_code);
		
		driver.findElement(By.xpath(OR.getProperty("Add_CUSTOMER_BTN"))).click();
		
	}
	
	
	@DataProvider
	public Object[][] getDATA() throws EncryptedDocumentException, IOException
	{
		if(myPOIHelper==null)
		{
		myPOIHelper=new POIHelper();
		
		String cell_Data="";
		String PAth = System.getProperty("user.dir")+"\\src\\test\\resources\\Excel\\Dataprovider.xlsx";
		File file = new File(PAth); 
		int Row_Count=myPOIHelper.getRowcount(PAth);
		
		int Col_Count=myPOIHelper.getColumncount(file);
		
		Object[][] data= new Object[Row_Count-1][Col_Count];
		
		for(int row_num=1;row_num<=Row_Count-1;row_num++)
		{
			for(int col_num=0;col_num<Col_Count;col_num++)
			{
				cell_Data=myPOIHelper.getCELLdata(file, row_num, col_num);
				data[row_num-1][col_num]=cell_Data;
			}
		}
		
		return data;
		}
		else
		{
			return null;
		}
				
	}
	
	
}
