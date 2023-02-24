package Utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import POM_Classes.LoginOrSignUpPage;

public class Utility 
{
	public static void captureScreenshot(WebDriver driver, String methodname) throws IOException, InterruptedException
	{
				String date = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
				TakesScreenshot scrShot =((TakesScreenshot)driver);
				Thread.sleep(1000);
				
				File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

		        File DestFile =  
		      	new	File("C:\\Users\\Neha\\Desktop\\Velocity Class\\Screenshot\\ " 
		        + methodname + " " + date + ".png");
		            
		        FileHandler.copy(SrcFile, DestFile);
	}
	
				// Return type		     // SheetName, row, cell
	public static String getDataFromExcelSheet(String sheetname, int row, int cell) throws IOException
	{
		String path = "C:\\Users\\Neha\\Desktop\\Velocity Class\\Automation\\TestData.xlsx";
		
		FileInputStream file = new FileInputStream(path);
		Workbook book = WorkbookFactory.create(file);
		
		String data = book.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}  
	

	
		// code
	/*	String data = " ";
		try
		{
			data = getStringCellValue();
		}
		catch
		{
			double value = getNumericCellValue();
			data = convert double to String
		}
		
		return data;
	}
	*/
}


