package com.main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class actionsClass {
    private WebDriver driver;
    private String baseUrl;
    JavascriptExecutor js;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        js = (JavascriptExecutor)driver;
        baseUrl = "D:\\Java\\DataDrivenFramework\\src\\main\\resources\\PracticePage2.html";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }
    @Test
    public void testMouseHoverAction() throws Exception{
        driver.get(baseUrl);
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0, 500)");
        Thread.sleep(2000);
        WebElement mouseElement = driver.findElement(By.id("mousehover"));
        Actions actions = new Actions(driver);
        //让鼠标移到悬停位置
        actions.moveToElement(mouseElement).perform();
        Thread.sleep(3000);
        WebElement backElement = driver.findElement(By.xpath("//div[@class='mouse-hover-content']/a[text()='回到顶部']"));
        actions.moveToElement(backElement).click().perform();
    }
    @AfterClass
    public void tearDown(){
        //driver.quit();
    }
}
