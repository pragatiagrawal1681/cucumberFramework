package com.vtiger.stepdefinitions;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.PublicKey;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class basesteps {

    public static WebDriver driver;
    public static LoginPage lp;
    public static HomePage hp;
    public static LeadPage ldp;
    public static Properties prop;
    public static Map<String,Map<String,String>> dt;
    public static String ScenarioName;
    public static ExtentReports extent;
    public static ExtentTest logger;


    public void readProperties() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Features/config.properties");
        prop.load(fis);
    }

    public void launchApp() throws Exception {
        readExcel();
        System.out.println(dt);
        //System.exit(0);
        readProperties();
        if (prop.getProperty("Browser").equals("chrome")) {
            driver = new ChromeDriver();
        } else if (prop.getProperty("Browser").equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (prop.getProperty("Browser").equals("edge")) {
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("globaltimeout"))));
        driver.get(prop.getProperty("AppUrl"));
    }


    public void readExcel() throws FilloException {
        Fillo fillo=new Fillo();
        Connection connection=fillo.getConnection(System.getProperty("user.dir") + "/src/test/resources/Features/TestData/data.xlsx");
        String strQuery="Select * from Sheet1";
        Recordset recordset=connection.executeQuery(strQuery);
        List<String> colm = recordset.getFieldNames();


        dt = new HashMap<String,Map<String,String>>();


        while(recordset.next())
        {
            Map<String,String> rowdata = new HashMap<String,String>();
            for (String s : colm)
            {
                rowdata.put(s, recordset.getField(s));
            }
            dt.put(recordset.getField("ScenarioName"), rowdata);
        }

        recordset.close();
        connection.close();
    }



    public void createExtentReports()
    {
        Date d = new Date();
        DateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
        String filename = ft.format(d);
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/src/test/java/com/vtiger/reports/ExtentReports"+filename+".html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "Automation Test Hub");
        extent.setSystemInfo("Environment", "Test");
        extent.setSystemInfo("User Name", "Pragati");
        htmlReporter.config().setDocumentTitle("vtiger Regression report");
        htmlReporter.config().setDocumentTitle("Name of the Report Comes here");
        htmlReporter.config().setTheme(Theme.STANDARD);

    }


}
