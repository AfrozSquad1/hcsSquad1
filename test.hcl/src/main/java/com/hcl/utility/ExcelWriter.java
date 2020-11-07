package com.hcl.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {

   	public static void writeToExcel(Object[] Testimonial,Object[] Contents) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook();

		//Create a blank sheet
		XSSFSheet spreadsheet = workbook.createSheet( " Info ");

		//Create row object
		XSSFRow row;

		//This data needs to be written (Object[])
		Map < String, Object[] > info = new TreeMap < String, Object[] >();
		info.put("1",Testimonial);
		info.put("2",Contents);

		//Iterate over data and write to sheet
		Set < String > keyid = info.keySet();
		int rowid = 0;

		for (String key : keyid) {
			row = spreadsheet.createRow(rowid++);
			Object [] objectArr = info.get(key);
			int cellid = 0;

			for (Object obj : objectArr){
				Cell cell = row.createCell(cellid++);
				cell.setCellValue((String)obj);
			}
		}

		FileOutputStream out = new FileOutputStream(new File("C:\\Users\\afroz_a\\git\\hcsSquad1\\test.hcl\\exportedData\\excelData.xlsx"));
		workbook.write(out);
		out.close();
		System.out.println("Writesheet.xlsx written successfully");

	}
   	
   	
//    public static void main(String args[]) throws IOException{   
//    	Object [] Testimonial= new Object[] {"Tst1"};
//    	Object [] Contents= new Object[] {"TstContent1"};
//    	writoToExcel(Testimonial,Contents);
//    }
}