package com.da.DataDriven;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ReadExcel {
    public static void main(String[] args) {
        XSSFWorkbook excelWBook;
        XSSFSheet excelWSheet;
        XSSFCell cell;
        // Location of the Excel file
        String path = "src/test/utilities/ExcelRead.xlsx";
        String sheetName = "Sheet1";

        try {
            FileInputStream excelFile = new FileInputStream(path);
            excelWBook = new XSSFWorkbook(excelFile);
            excelWSheet = excelWBook.getSheet(sheetName);
            cell = excelWSheet.getRow(1).getCell(2);
            String cellData = cell.getStringCellValue();
            System.out.println("cell data:" + cellData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
