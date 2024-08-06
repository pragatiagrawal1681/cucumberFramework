package com.vtiger.pages;

import com.aventstack.extentreports.ExtentTest;
import com.utilities.PageActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class LeadPage extends PageActions {



    public LeadPage(WebDriver driver , ExtentTest logger)
    {
        super(driver, logger);
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText= "New Lead")
    WebElement lnk_NewLead;

    @FindBy(name= "lastname")
    WebElement tb_lastname;

    @FindBy(name= "company")
    WebElement tb_company;

    @FindBy(name= "button")
    WebElement btn_save;


    public void ClickNewLead()
    {
        clickElement(lnk_NewLead,"Link New Lead clicked");
    }

    public void CreateLead(String lname , String comp)
    {
        SetInput(tb_lastname,lname , lname+" has been entered into lastname field" );
        SetInput(tb_company,comp , comp+" has been entered into company field" );
        clickElement(btn_save,"Save button clicked");
    }

}
