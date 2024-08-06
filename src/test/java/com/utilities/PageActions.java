package com.utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v125.page.model.Screenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageActions {

    public WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest logger;

    public PageActions(WebDriver driver, ExtentTest logger)
    {
        this.driver = driver;
        this.logger = logger;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void SetInput(WebElement elm , String val, String msg)
    {
        try {
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.clear();
            elm.sendKeys(val);
            logger.pass(msg);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            logger.fail("Unable to enter text into Textbox due to error"+e.getMessage()+"<a href ='"+getScreenshot()+"  "+"'><span class='label start-time'>Screenshot</span></a>");
        }

    }


    public void SelectVisibleText(WebElement elm , String val, String msg)
    {
        try {
            wait.until(ExpectedConditions.visibilityOf(elm));
            Select sel = new Select(elm);
            sel.selectByVisibleText(val);
            logger.pass(msg);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            logger.fail("Unable to select value from dropdown due to error"+e.getMessage()+"<a href ='"+getScreenshot()+"  "+"'><span class='label start-time'>Screenshot</span></a>");
        }

    }


    public void clickElement(WebElement elm , String msg)
    {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(elm));
            elm.click();
            logger.pass(msg);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            logger.fail("Unable to click on element due to error"+e.getMessage()+"<a href ='"+getScreenshot()+"  "+"'><span class='label start-time'>Screenshot</span></a>");
        }

    }

    public void elementExist(WebElement elm, String msg)
    {
        try {
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.isDisplayed();
            logger.pass(msg);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            logger.fail("Unable to find the element due to error"+e.getMessage()+"<a href ='"+getScreenshot()+"  "+"'><span class='label start-time'>Screenshot</span></a>");
        }

    }



    public String getScreenshot()
    {
        Date d = new Date();
        DateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
        String fileName = ft.format(d);
        String path = System.getProperty("user.dir"+"src/test/java/com/vtiger/reports/screenshot/"+fileName+".png");
        TakesScreenshot ts = ((TakesScreenshot)driver);
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(path);
        try
        {
            FileUtils.copyFile(srcFile,DestFile);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return path;

    }




}

