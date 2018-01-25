package com.google.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GmailLoginPageFactoryPattern {

    @FindBy(how = How.CSS, using = "input[name=identifier]")
    private WebElement loginTextBox;

    @FindBy(how = How.CSS, using = "input[name=password]")
    private WebElement passwordTextBox;

    @FindBy(how = How.ID, using = "identifierNext")
    private WebElement nextButton;

    @FindBy(how = How.ID, using = "passwordNext")
    private WebElement submitButton;

    public void Login(String login, String passsword) {

        loginTextBox.sendKeys(login);
        nextButton.click();
        passwordTextBox.sendKeys(passsword);
        submitButton.click();
    }
}
