package com.google.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

    protected WebDriver driver;
    protected WebDriverUtil webDriverUtil;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.webDriverUtil = new WebDriverUtil(driver);
    }
}
