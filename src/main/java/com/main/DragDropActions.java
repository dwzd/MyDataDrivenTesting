package com.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DragDropActions {
    private WebDriver driver;
    private String baseUrl;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        baseUrl = "http://jqueryui.com/droppable/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

    }

    @Test
    public void testDragAndDrop() throws InterruptedException {
        driver.get(baseUrl);
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        driver.switchTo().frame(0);
        WebElement dragElement = driver.findElement(By.id("draggable"));
        WebElement dropElement = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(dragElement, dropElement).build().perform();
        Thread.sleep(3000);
    }
    @Test
    public void testDragDropManual()throws Exception{
        //模拟手工测试的步骤
        driver.navigate().refresh();
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        driver.switchTo().frame(0);
        WebElement dragElement = driver.findElement(By.id("draggable"));
        WebElement dropElement = driver.findElement(By.id("droppable"));
        actions.clickAndHold(dragElement).moveToElement(dropElement).release().build().perform();
        Thread.sleep(2000);
    }

    @AfterClass
    public void tearDown(){
//        driver.quit();
    }
}
