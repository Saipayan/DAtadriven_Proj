package utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import Base.TestBase;

public class TestUtil extends TestBase {

	
	public static String  SCR_PATH=System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\";
	public static String Scr_Name="error.jpg";
	
	public static void CAptureScreenShot() throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(SCR_PATH+Scr_Name));
	}
	
	@DataProvider(name="dp")
	public Object[][] getDATA(Method M) throws EncryptedDocumentException, IOException
	{
		if(myPOIHelper==null)
		{
		myPOIHelper=new POIHelper();
		
		String cell_Data="";
		String PAth = System.getProperty("user.dir")+"\\src\\test\\resources\\Excel\\"+M.getName()+".xlsx";
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
