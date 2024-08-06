package com.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FileUpload_Robot {
    public static void main(String[] args) throws InterruptedException, AWTException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:100/");

        driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("user_password")).sendKeys("admin");
        driver.findElement(By.name("Login")).sendKeys(Keys.ENTER);
        driver.findElement(By.linkText("New Product")).click();
        //driver.findElement(By.xpath("//input[@type = 'file']")).sendKeys("C:\\Users\\HP\\Downloads\\shareddoc.pdf");

        Actions act = new Actions(driver);

        JavascriptExecutor js = ((JavascriptExecutor)driver);
        js.executeScript("window.scrollBy(0,300);","");

        //act.scrollToElement(driver.findElement(By.xpath("//input[@type = 'file']"))).perform();
        Thread.sleep(2000);
        act.click(driver.findElement(By.xpath("//input[@type = 'file']"))).perform();

        Thread.sleep(5000);
        String file = "C:\\Users\\HP\\Downloads\\shareddoc.pdf";
        StringSelection stringSelection = new StringSelection(file);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_V);
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);




    }
}
