package com.google.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtil {

    protected WebDriver driver;
    private WebDriverWait webDriverWait;

    public WebDriverUtil(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(this.driver, 10);
    }

    public WebElement waitFor(ExpectedCondition<WebElement> expectedCondition) {

        return webDriverWait.until(expectedCondition);

    }
}
