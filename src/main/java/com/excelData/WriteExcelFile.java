package com.excelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {

	public void setData(String sheetname, String TestCaseName, String data) throws IOException {

		File file = new File(System.getProperty("user.dir") + "\\Resource\\Input Data.xlsx");

		FileInputStream fileInput = new FileInputStream(file);

		XSSFWorkbook workbook = new XSSFWorkbook(fileInput);

		int sheetsCount = workbook.getNumberOfSheets();
		for (int i = 0; i < sheetsCount; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase(sheetname)) {

				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();// sheet is collection of rows

				while (rows.hasNext()) {
					Row firstRow = rows.next();
					// To read the data from the current row

					Iterator<Cell> cell = firstRow.cellIterator();// Row is collection of cell
					int k = 0;
					int coloumn = 0;
					while (cell.hasNext()) {
						Cell value = cell.next();

						if (value.getStringCellValue().equalsIgnoreCase("Users")) {
							coloumn = k;

						}
						k++;
					}
					System.out.println("Coloumn is " + coloumn);

					while (rows.hasNext()) {
						Row row2 = rows.next();
						if (row2.getCell(coloumn).getStringCellValue().equalsIgnoreCase(TestCaseName)) {
							Iterator<Cell> celldata=row2.cellIterator();
							while(celldata.hasNext()) {
								Cell c=celldata.next();
								if(c.getCellTypeEnum()==CellType._NONE) {
									row2.createCell(coloumn).setCellValue(data);;
								}
								
								FileOutputStream fos=new FileOutputStream(file);
								workbook.write(fos);
								
							}

						}
					}
				}
			}
		}
		
	}
	
}
