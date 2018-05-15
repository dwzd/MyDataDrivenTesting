package com.main;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class scrollTest {
    private WebDriver driver;
    private JavascriptExecutor js;
    private String baseUrl;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        //baseUrl = "https://tokensale.nebula-ai.network/#home";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }

    @Test
    public void testScroll() throws Exception {
        js.executeScript("window.location = 'https://tokensale.nebula-ai.network'");
        Thread.sleep(3000);

        js.executeScript("window.scrollBy (0,800)");
        Thread.sleep(2000);
    }
}
