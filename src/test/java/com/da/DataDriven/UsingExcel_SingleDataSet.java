package com.da.DataDriven;

import com.da.utilities.Constants2;
import com.da.utilities.ExcelUtility_SingleDataSet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UsingExcel_SingleDataSet {
    private WebDriver driver;

    @BeforeClass
    public void  setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.get(Constants2.URL);
        driver.switchTo().frame("x-URS-iframe");
        // 指明excel文件路径
        ExcelUtility_SingleDataSet.setExcelFile(Constants2.File_Path + Constants2.File_Name, "Sheet1");

    }

    @Test
    public void testUsingExcel() throws Exception {
        String username = ExcelUtility_SingleDataSet.getCellData(1, 0);
        String password = ExcelUtility_SingleDataSet.getCellData(1, 1);
        // 输入用户名
        WebElement element = driver.findElement(By.xpath("//input[@data-placeholder='邮箱帐号或手机号']"));
        element.clear();
        element.sendKeys(username);
        // 输入密码
        driver.findElement(By.xpath("//input[@data-placeholder='密码']")).sendKeys(password);
        // 点击登录按钮
        driver.findElement(By.id("dologin")).click();
        Thread.sleep(2000);

        // 查找错误信息是否存在
        boolean result = driver.findElements(By.xpath("//div[text()='帐号或密码错误']")).size() != 0;
        Assert.assertTrue(result);

        // 把测试结果写入 Excel 文件
        ExcelUtility_SingleDataSet.setCellData("Pass", 1, 2);

    }

    @Test
    public void testUsingExcel2() throws Exception {
        String username = ExcelUtility_SingleDataSet.getCellData(2, 0);
        String password = ExcelUtility_SingleDataSet.getCellData(2, 1);
        // 输入用户名
        WebElement element = driver.findElement(By.xpath("//input[@data-placeholder='邮箱帐号或手机号']"));
        element.clear();
        element.sendKeys(username);
        // 输入密码
        driver.findElement(By.xpath("//input[@data-placeholder='密码']")).sendKeys(password);
        // 点击登录按钮
        driver.findElement(By.id("dologin")).click();
        Thread.sleep(2000);

        // 查找错误信息是否存在
        boolean result = driver.findElements(By.xpath("//div[text()='帐号或密码错误']")).size() != 0;
        Assert.assertTrue(result);

        // 把测试结果写入 Excel 文件
        ExcelUtility_SingleDataSet.setCellData("Pass!!!", 2, 2);

    }

    @AfterClass
    public void tearDown() throws Exception {
        //driver.quit();
    }
}
