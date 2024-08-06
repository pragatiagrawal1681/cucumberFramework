package com.vtiger.pages;

import com.aventstack.extentreports.ExtentTest;
import com.utilities.PageActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageActions {


    public HomePage(WebDriver driver , ExtentTest logger)
    {
        super(driver, logger);
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Logout")
    WebElement lnk_logout;

    @FindBy(linkText = "Home")
    WebElement lnk_home;


    public void click_logout()
    {
        clickElement(lnk_logout, "Link Logout clicked");
    }

    public  void Validate_logout()
    {
       elementExist(lnk_logout, "Link logout is displayed");
    }

    public  void Validate_Home()
    {
        elementExist(lnk_home, "Link Home is displayed");
    }



}
