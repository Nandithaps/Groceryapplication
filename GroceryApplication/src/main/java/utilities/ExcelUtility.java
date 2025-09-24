package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constants;

public class ExcelUtility 
{
	static FileInputStream f; //excel file
	static XSSFWorkbook w; // Book1 //Filename
	static XSSFSheet s; //sheets //sheet name


public static String getStringData(int a, int b, String sheet) throws IOException //a-row, b-column or cell, sheet - sheetno.
{
	// FileInputStream, XSSFRow, XSSFCell - inbuilt class
	//f = new FileInputStream("C:\\Users\\Nanditha\\eclipse-workspace\\GroceryApplication"); //copy as path - the file location of excel saved
	f = new FileInputStream(Constants.EXCELPATH);
	w = new XSSFWorkbook(f);
	s = w.getSheet(sheet);
	XSSFRow r = s.getRow(a);
	XSSFCell c = r.getCell(b);
	return c.getStringCellValue();
}

public static String getIntegerData(int a, int b, String sheet) throws IOException
{
	//f = new FileInputStream("C:\\Users\\Nanditha\\eclipse-workspace\\GroceryApplication\\src\\test\\resources\\Testdata1.xlsx");
	f = new FileInputStream(Constants.EXCELPATH);
	w = new XSSFWorkbook(f); // get file name
	s = w.getSheet(sheet); // get sheet name
	XSSFRow r = s.getRow(a); // get row
	XSSFCell c = r.getCell(b); // get column/cell
	int y = (int) c.getNumericCellValue();    //string-integer = typecasting      // here c gives double to get in int use int c
	return String.valueOf(y);                       //return integer as string so valueOf
}

}
