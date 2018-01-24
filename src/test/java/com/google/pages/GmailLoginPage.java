package com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailLoginPage {

    private WebDriver driver;

    private WebElement loginTextBox;
    private By loginTextBoxLocator = By.cssSelector("input[name=identifier]");

    private WebElement passwordTextBox;
    private By passwordTextBoxLocator = By.cssSelector("input[name=password]");

    private WebElement nextButton;
    private By nextButtonLocator = By.id("identifierNext");

    private WebElement submitButton;
    private By submitButtonLocator = By.id("passwordNext");


    public GmailLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void Login(String login, String passsword) {

        WebDriverWait wait = new WebDriverWait(driver, 10);

        loginTextBox = driver.findElement(loginTextBoxLocator);
        loginTextBox.sendKeys(login);

        nextButton = driver.findElement(nextButtonLocator);
        nextButton.click();

        passwordTextBox = wait.until(ExpectedConditions.elementToBeClickable(passwordTextBoxLocator));
        passwordTextBox.sendKeys(passsword);


        submitButton = wait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator));
        //submitButton = driver.findElement(submitButtonLocator);
        submitButton.click();
    }
}
