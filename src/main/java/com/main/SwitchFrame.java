package com.main;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchFrame {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://jqueryui.com/datepicker/";

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void test() throws InterruptedException {
        driver.switchTo().frame(0);
        WebElement datePicker = driver.findElement(By.id("datepicker"));
        datePicker.click();
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(10000);
        driver.quit();
    }

}
