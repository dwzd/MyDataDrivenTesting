package com.main;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertConfirm {
    private WebDriver driver;
    private String baseUrl;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        baseUrl = "D:\\Java\\DataDrivenFramework\\src\\main\\resources\\PracticePage.html";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.get(baseUrl);
        Thread.sleep(2000);
    }

    @Test
    public void testAlertSwitch() throws InterruptedException {
        driver.findElement(By.id("name")).sendKeys("达达好强！");
        Thread.sleep(2000);
        driver.findElement(By.id("alertbtn")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void testConfirmSwitch()throws Exception{
        driver.findElement(By.id("name")).sendKeys("幼幼好好！");
        Thread.sleep(2000);
        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.getText();
        alert.dismiss();

    }

    @AfterMethod
    public void tearDown()throws Exception{
        Thread.sleep(3000);
        driver.quit();
    }
}
