package pojoClass.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class FetchDataFromExcel {

	public static String getStringExcelData(String sheetName, int rowNum, int celNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\main\\resources\\AddProject.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		DataFormatter formatter=new DataFormatter();
		String data = formatter.formatCellValue(wb.getSheet(sheetName).getRow(rowNum).getCell(celNum));
		return data;	
	}
	
public static int getNumericExcelData(String sheetName, int rowNum, int celNum) throws EncryptedDocumentException, IOException {
	
	FileInputStream fis = new FileInputStream(".\\src\\main\\resources\\AddProject.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	
	double data1=wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getNumericCellValue();
	int data=(int)data1;
	return data;
	
}
	}

