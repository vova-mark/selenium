package com.google.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class WebDriverTestBase {

    protected WebDriver driver;

    @BeforeClass
    public void SetUp() {
        //WebDriverManager.chromedriver().version("2.35").setup(); //with specified version of driver
        WebDriverManager.firefoxdriver().setup();  //with latest version of driver
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS); //timeout for page load
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS); //timeout for load scripts
    }

    //@AfterClass
    public void tearDown() {
        //driver.close(); //current tab
        driver.quit(); //close at all
    }
}
