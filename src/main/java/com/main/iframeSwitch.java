package com.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class iframeSwitch {
    private WebDriver driver;
    private String baseUrl;
    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        baseUrl = "http://jqueryui.com/datepicker/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }


    @Test
    public void testDatepicker() throws InterruptedException {
        driver.get(baseUrl);
        driver.switchTo().frame( 0);
        WebElement datePicker = driver.findElement(By.id("datepicker"));
        datePicker.click();
        //返回主界面
        Thread.sleep(5000);
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//input[@name='s']")).sendKeys("转换 Iframe 成功了！！！");

    }
    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }


}
