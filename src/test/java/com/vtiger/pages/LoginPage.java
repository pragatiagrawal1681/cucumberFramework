package com.vtiger.pages;

import com.aventstack.extentreports.ExtentTest;
import com.utilities.PageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageActions {


    public LoginPage(WebDriver driver , ExtentTest logger)
    {
        super(driver, logger);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "user_name")
    WebElement tb_uid;

    @FindBy(name = "user_password")
    WebElement tb_password;

    @FindBy(xpath = "//select[@name = 'login_theme']")
    WebElement dp_theme;

    @FindBy(name = "Login")
    WebElement btn_login;

    @FindBy(xpath = "//*[contains(text(),'You must specify a valid username and password.')]")
    WebElement err_msg;


    public void Validate_dropdown_exist()
    {
        elementExist(dp_theme, "dropdown theme is displayed");
    }


    public void Validate_Error_Message()
    {
        elementExist(err_msg, "err msg is displayed");
    }

    public void login(String userid , String pwd)
    {
        SetInput(tb_uid, userid, userid+"has been entered in username field");
        SetInput(tb_password, pwd, pwd+"has been entered in password field");
        clickElement(btn_login,"login button clicked");
    }


    public void login(String userid , String pwd , String theme)
    {


        SetInput(tb_uid, userid, userid+"has been entered in username field");
        SetInput(tb_password, pwd, pwd+"has been entered in password field");
        SelectVisibleText(dp_theme, theme, theme+"has been selelcted from theme dropdown");
        clickElement(btn_login, "login button clicked");


    }

}
