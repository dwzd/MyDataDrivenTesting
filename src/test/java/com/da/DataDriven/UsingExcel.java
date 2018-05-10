package com.da.DataDriven;

import com.da.utilities.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UsingExcel {
    private WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.get(Constants.URL);

        driver.switchTo().frame("x-URS-iframe");
        ExcelUtility.setExcelFile(Constants.File_Path + Constants.File_Name, "LoginTests");
    }

    //返回值是一个object 类型的二维数组  即excel 里第一个值
    @DataProvider(name = "loginData")
    public Object[][] dataProvider(){
        Object[][] testData = ExcelUtility.getTestData("Invalid_Login");
        return testData;
    }

    @Test(dataProvider = "loginData")
    public void testUsingExcel(String username, String password) throws InterruptedException {
        WebElement enterUser = driver.findElement(By.xpath("//input[@data-placeholder='邮箱帐号或手机号']"));
        enterUser.clear();
        enterUser.sendKeys(username);
        WebElement enterPWD = driver.findElement(By.xpath("//input[@data-placeholder='密码']"));
        enterPWD.clear();
        enterPWD.sendKeys(password);
        driver.findElement(By.id("dologin")).click();
        Thread.sleep(3000);
        //验证错误信息是否存在
        boolean result = driver.findElements(By.xpath("//div[text()='帐号或密码错误']")).size() != 0;
        Assert.assertTrue(result);
    }

    @AfterClass
    public void tearDown()throws Exception{
        //driver.quit();
    }
}
