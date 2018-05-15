package com.main;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ScreenshotRandomFilename {
    private WebDriver driver;
    private String baseUrl;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        baseUrl = "https://mail.yahoo.com";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

    }

    @Test
    public void testScreenshots(){
        driver.get(baseUrl);
        driver.findElement(By.id("login-username")).sendKeys("ddwzdd@yahoo.com");
        driver.findElement(By.id("login-signin")).click();
    }

    //此方法可以得到一个随机的基本不重复的文件名
    public static String getRandomStringName(int length){
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for(int i=0; i<length; i++){
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    @AfterClass
    public void tearDown() throws InterruptedException, IOException {
        Thread.sleep(3000);
        //调用上面的方法
        String fileName = getRandomStringName(8) + ".png";
        String directory = "D:\\Java\\DataDrivenFramework\\src\\main\\resources\\";
        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile,new File(directory + fileName));
        //driver.quit();
    }
}



















