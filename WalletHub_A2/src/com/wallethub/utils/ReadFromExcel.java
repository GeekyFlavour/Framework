package com.wallethub.utils;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel 
{
	private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;

    /*
    This method is to set the File path and to open the Excel file,
    Pass Excel Path and Sheetname as Arguments to this method.
    */

    public static void setExcelFile() throws Exception 
		{

			try 
			
					{

						// Open the Excel file
				
						File src=new File(Constant.File_Path_TestData);
				
						// Load the workbook
				  
						FileInputStream ExcelFile = new FileInputStream(src);
				  
						// Access the required test data sheet
						ExcelWBook = new XSSFWorkbook(ExcelFile);
						ExcelWSheet = ExcelWBook.getSheet(Constant.SheetName);
		
					}
				
			catch (Exception e)
				
					{
		
						throw (e);
		
					}
		
	}

//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

    public static String getCellData(int RowNum, int ColNum) throws Exception
	
		{

			try
		
					{

						Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
						String CellData = Cell.getStringCellValue();
						return CellData;
			
					}
		
			catch (Exception e)
			
					{

						return"";

					}	
  

		}
}
