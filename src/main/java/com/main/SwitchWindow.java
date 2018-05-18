package com.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SwitchWindow {
    private WebDriver driver;
    private String baseUrl;
    private String firstHandle;
    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        baseUrl = "D:\\Java\\DataDrivenFramework\\src\\main\\resources\\PracticePage.html";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

    }

    @Test(priority = 1)
    public void testAWindowSwitch() throws InterruptedException {
        driver.get(baseUrl);
        firstHandle = driver.getWindowHandle();
        System.out.println("The main handle is: " + firstHandle);
        Thread.sleep(3000);
        WebElement searchTextBox = driver.findElement(By.id("openwindow"));
        searchTextBox.click();
        Set<String> handles = driver.getWindowHandles();
        for(String handle:handles ){
            System.out.println(handle);
            if(!(handle.equals(firstHandle))){
                driver.switchTo().window(handle);
                Thread.sleep(2000);
                driver.findElement(By.id("q")).sendKeys("selenium java");
                //driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/span/span/button")).click();
                Thread.sleep(3000);
                //driver.close();
            }
            break;
        }
    }

    @Test(priority = 2)
    public void testSwitchback(){
        driver.switchTo().window(firstHandle);
        driver.findElement(By.id("name")).sendKeys("完美的结果！！！");

    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
       // driver.quit();
    }
}
