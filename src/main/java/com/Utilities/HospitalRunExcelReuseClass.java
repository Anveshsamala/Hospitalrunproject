package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HospitalRunExcelReuseClass 
{
	public static File f;
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileOutputStream fos;
	public static int getlastrownumber(String filepath, String sheetname) throws FileNotFoundException
	{
		f=new File(filepath);
		fis=new FileInputStream(f);
		workbook=new XSSFWorkbook();
		sheet=workbook.getSheet(sheetname);
		return sheet.getLastRowNum();
	}
	public static int getlastcellnumber(String filepath, String sheetname) throws FileNotFoundException
	{
		f=new File(filepath);
		fis=new FileInputStream(f);
		workbook=new XSSFWorkbook();
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(1);
		return row.getLastCellNum();
	}
	public static String readdata(String filepath,String sheetname, int rownum, int colnum) throws FileNotFoundException
	{
		f=new File(filepath);
		fis=new FileInputStream(f);
		workbook=new XSSFWorkbook();
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		return cell.getStringCellValue();
	}
	public static boolean setCellData1(String filepath,String sheetname, int rownum, int colnum, String value)
	{
		try
		{
			int col_Num = colnum;
			sheet = workbook.getSheet(sheetname);

			row = sheet.getRow(0); 

			sheet.autoSizeColumn(col_Num);
			row = sheet.getRow(rownum - 1);
			if(row==null)
				row = sheet.createRow(rownum - 1);

			cell = row.getCell(col_Num);
			if(cell == null)
				cell = row.createCell(col_Num);

			cell.setCellValue(value);

			fos = new FileOutputStream(filepath);
			workbook.write(fos);
			fos.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return  false;
		}
		return true;
	}
	public static Object[][] getdata(String filepath,String sheetname) throws FileNotFoundException
	{
		f=new File(filepath);
		fis=new FileInputStream(f);
		workbook=new XSSFWorkbook();
		sheet=workbook.getSheet(sheetname);
		int totalrows=sheet.getLastRowNum();
		int totalcols=sheet.getRow(1).getLastCellNum();

		Object[][] data= new Object[totalrows][totalcols];
		for(int i=1;i<totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				data[i-1][j]=HospitalRunExcelReuseClass.readdata(filepath, sheetname, i, j);
			}
		}
		return data;

	}
}
