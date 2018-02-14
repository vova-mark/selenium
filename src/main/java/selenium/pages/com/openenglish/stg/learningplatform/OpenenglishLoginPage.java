package selenium.pages.com.openenglish.stg.learningplatform;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpenenglishLoginPage extends AbstractBasePage {

    private By loginTextboxLocator = By.id("login-email");
    private WebElement loginTextbox;

    private By passwordTextboxLocator = By.id("login-password");
    private WebElement passwordTextbox;

    private By loginButtonLocator = By.id("login-submit");
    private WebElement loginButton;

    private By bunnerContinueButtonLocator = By.id("banner-continue-btn");
    private WebElement bunnerContinueButton;



    public OpenenglishLoginPage(WebDriver driver) {
        super(driver);
    }

    public OpenenglishLoginPage enterLogin(String s) {
        loginTextbox = driver.findElement(loginTextboxLocator);
        loginTextbox.sendKeys(s);
        return this;
    }

    public OpenenglishLoginPage enterPassword(String s) {
        passwordTextbox = driver.findElement(passwordTextboxLocator);
        passwordTextbox.sendKeys(s);
        return this;
    }

    public WebElement getPasswordTextbox() {
        return driver.findElement(passwordTextboxLocator);
    }

    public OpenEnglishMainPage pressLogInButton() {
        loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
        return new OpenEnglishMainPage(driver);

    }

    public void closeBunnerContinue() {
        bunnerContinueButton = driver.findElement(bunnerContinueButtonLocator);
        bunnerContinueButton.click();
    }

    public WebElement getLoginButton() {
        return driver.findElement(loginButtonLocator);
    }
}
