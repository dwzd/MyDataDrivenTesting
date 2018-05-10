package com.da.utilities;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelUtility_SingleDataSet {

    private static XSSFWorkbook ExcelWBook;
    private static XSSFSheet ExcelWSheet;
    private static XSSFCell Cell;
    private static XSSFRow Row;

    //设置excel 表和路径
    public static void setExcelFile(String Path, String SheetName) throws Exception {
        try {
            //打开 excel 表
            FileInputStream ExcelFile = new FileInputStream(Path);
            //访问excel 表
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(SheetName);
        }catch (Exception e){
            throw (e);
        }
    }
    //从 excel 单元格读取测试数据
    public static String getCellData(int RowNum, int ColNum){
        try{
            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            String cellData = Cell.getStringCellValue();
            return cellData;
        }catch (Exception e){
            return "";
        }
    }
    //从 excel 中读取日期格式的测试数据
    public static String getDateFromCellData(int RowNum, int ColUum){
        try{
            Cell = ExcelWSheet.getRow(RowNum).getCell(ColUum);
            DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
            //先取得日期对象，再转换成日期格式的字符串
            Date date = Cell.getDateCellValue();
            String dateStringFormat = dateFormat.format(date);
            return dateStringFormat;
        }catch (Exception e){
            return "";
        }
    }

    //下面的方法把数据写入excel 文件
    public static void setCellData(String Result, int RowNum, int ColNum) throws Exception {
        try {
            Row = ExcelWSheet.getRow(RowNum);
            // 如果Row不存在就创建
            if(Row == null){
                Row = ExcelWSheet.createRow(RowNum);
            }
            Cell = Row.getCell(ColNum);
            if(Cell == null){
                Cell = Row.createCell(ColNum);
                Cell.setCellValue(Result);
            }else {
                Cell.setCellValue(Result);
            }
            // 文件字节输出流写入数据
            FileOutputStream fileOutputStream = new FileOutputStream(Constants2.File_Path + Constants2.File_Name);
            //把上面的文件流写到excel 文件里
            ExcelWBook.write(fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        }catch (Exception e){
            throw  (e);
        }

    }

    //这是上面 setCellData 方法的重载
    public static void setCellData(double result, int rowNumm, int colNum) throws Exception {
        try{
            Row = ExcelWSheet.getRow(rowNumm);
            Cell = Row.getCell(colNum);
            if(Cell == null){
                Cell = Row.createCell(colNum);
                Cell.setCellValue(result);
            }else {
                Cell.setCellValue(result);
            }
            // 文件字节输出流写入数据
            FileOutputStream fileOutputStream = new FileOutputStream(Constants2.File_Path + Constants2.File_Name);
            ExcelWBook.write(fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        }catch (Exception e){
            throw (e);
        }
    }
}




























