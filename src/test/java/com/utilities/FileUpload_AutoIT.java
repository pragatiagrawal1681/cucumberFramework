package com.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class FileUpload_AutoIT {

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:100/");

        driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("user_password")).sendKeys("admin");
        driver.findElement(By.name("Login")).sendKeys(Keys.ENTER);
        driver.findElement(By.linkText("New Product")).click();
        //driver.findElement(By.xpath("//input[@type = 'file']")).sendKeys("C:\\Users\\HP\\Downloads\\shareddoc.pdf");


        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollBy(0,300);", "");

        Thread.sleep(2000);
        Actions act = new Actions(driver);

        //act.scrollToElement(driver.findElement(By.xpath("//input[@type = 'file']"))).perform();
        act.click(driver.findElement(By.xpath("//input[@type = 'file']"))).perform();
        Thread.sleep(5000);
        Runtime.getRuntime().exec("C:\\Users\\HP\\Desktop\\pragati.exe");
    }
}

