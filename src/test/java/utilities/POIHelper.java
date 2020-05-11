package utilities;

import java.io.File;  
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  
public class POIHelper  
{  
	public  String path;
	public  FileInputStream fis = null;
	public  FileOutputStream fileOut =null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row   =null;
	private XSSFCell cell = null;
public static void generic_function(String[] args)   
{  
try  
{  
File file = new File("C:\\Users\\Sreyoshi\\Documents\\Dataprovider.xlsx");   //creating a new file instance  
FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  

Workbook workbook=WorkbookFactory.create(file);

Sheet sheet0=workbook.getSheetAt(0);

for(Row row : sheet0)
{
	for(Cell cell : row)
	{
		
		System.out.println("Hello world!!");
		switch(cell.getCellType())  
		{  
		case NUMERIC:   //field that represents numeric cell type  
		//getting the value of the cell as a number  
		System.out.print(cell.getNumericCellValue()+ "\t\t");   
		break;  
		case STRING:    //field that represents string cell type  
		//getting the value of the cell as a string  
		System.out.print(cell.getStringCellValue()+ "\t\t");  
		break; 
		case BLANK:    //field that represents string cell type  
			//getting the value of the cell as a string  
			System.out.print("Its a BLANK value");  
			break; 
		default:
		}  
	}
}
fis.close();

}  
catch(Exception e)  
{  
e.printStackTrace();  
}  
}  

public int getRowcount(File file) throws EncryptedDocumentException, IOException
{
	Workbook workbook=WorkbookFactory.create(file);
	Sheet sheet0=workbook.getSheetAt(0);
	int count =0;
	for(Row row : sheet0)
	{
		count++;
	}
	return count;
}


//returns the data from a cell
	public String getCellData(String colName,int rowNum){
		try{
			if(rowNum <=0)
				return "";
		
		int index = 0;
		int col_Num=-1;
		if(index==-1)
			return "";
		
		sheet = workbook.getSheetAt(index);
		row=sheet.getRow(0);
		for(int i=0;i<row.getLastCellNum();i++){
			//System.out.println(row.getCell(i).getStringCellValue().trim());
			if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
				col_Num=i;
		}
		if(col_Num==-1)
			return "";
		
		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(rowNum-1);
		if(row==null)
			return "";
		cell = row.getCell(col_Num);
		
		if(cell==null)
			return "";
		
		String result="";
		
		switch(cell.getCellType())  
		{  
		case NUMERIC:   
			cell.getNumericCellValue();   
			result=String.valueOf(cell.getNumericCellValue());
		break;  
		case STRING:    
		result=String.valueOf(cell.getStringCellValue());
		break; 
		case BLANK:    
			result= "";
			break; 
		default:
		}  
		
		return result;
		
		
		}
		catch(Exception e){
			
			e.printStackTrace();
			return "row "+rowNum+" or column "+colName +" does not exist in xls";
		}
	}
	


public int getColumncount(File file) throws EncryptedDocumentException, IOException
{
	Workbook workbook=WorkbookFactory.create(file);
	Sheet sheet0=workbook.getSheetAt(0);
	int count =0;
	
	int flag=0;
	for(Row row : sheet0)
	{
		if(row.getRowNum()==1)
		{
			flag=1;
		}
		for(Cell cell : row)
		{
			if(flag==1)
			{
				break;
			}
			switch(cell.getCellType())  
			{  
			case NUMERIC:   //field that represents numeric cell type  
			count++;  
			break;  
			case STRING:    //field that represents string cell type  
			count++;
			break; 
			case BLANK:    //field that represents string cell type  
				//getting the value of the cell as a string  
				flag=1;
				break; 
			default:
			}  
		}
		
	}
	return count;
}

public String getCELLdata(File file,int Rownum,int Columnnum) throws EncryptedDocumentException, IOException
{
	Workbook workbook=WorkbookFactory.create(file);
	Sheet sheet0=workbook.getSheetAt(0);
	
	String result="";
	
	Row row=sheet0.getRow(Rownum);
	
	if(row==null)
	{
		return "";
	}
	
	Cell cell = row.getCell(Columnnum);
	
	switch(cell.getCellType())  
	{  
	case NUMERIC:   
		cell.getNumericCellValue();   
		result=String.valueOf(cell.getNumericCellValue());
	break;  
	case STRING:    
	result=String.valueOf(cell.getStringCellValue());
	break; 
	case BLANK:    
		result= "";
		break; 
	default:
	}  
	
	return result;
	
	
	
}


}  