package com.main;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PageWindowSize {
    private WebDriver driver;
    private JavascriptExecutor js;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        js = (JavascriptExecutor)driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }

    @Test
    public void testJsWindowSize() throws Exception {
        js.executeScript("window.location = 'https://www.google.ca'");
        Thread.sleep(2000);
//        long height = (long)js.executeScript("return window.innerHeight;");
        Object height = js.executeScript("return window.innerHeight;");
        Object width = js.executeScript("return window.innerWidth;");
        System.out.println("窗口的高度为："+height.toString());
        System.out.println("窗口的宽度为："+width.toString());
    }
}
