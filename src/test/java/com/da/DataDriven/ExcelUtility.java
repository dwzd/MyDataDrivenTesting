package com.da.DataDriven;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtility {
    //声明 表和表单 这两个变量
    private static XSSFWorkbook ExcelWorkBook;
    private static XSSFSheet ExcelWorkSheet;

    public static void setExcelFile(String path, String sheetName) throws Exception {
        try {
            // 打开 excel 文件
            FileInputStream ExcelFile = new FileInputStream(path);
            //访问 excel 表
            ExcelWorkBook = new XSSFWorkbook(ExcelFile);
            ExcelWorkSheet = ExcelWorkBook.getSheet(sheetName);
        } catch (Exception e) {
            throw (e);
        }
    }


}
