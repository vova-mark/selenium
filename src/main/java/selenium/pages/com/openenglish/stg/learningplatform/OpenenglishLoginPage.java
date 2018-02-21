package selenium.pages.com.openenglish.stg.learningplatform;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenenglishLoginPage extends AbstractBasePage {

    private By loginTextboxLocator = By.id("login-email");
    public WebElement getLoginTextbox() {
        return driver.findElement(loginTextboxLocator);
    }

    private By passwordTextboxLocator = By.id("login-password");
    public WebElement getPasswordTextbox(){
        return driver.findElement(passwordTextboxLocator);
    }

    private By loginButtonLocator = By.id("login-submit");
    public WebElement getLoginButton(){
        return driver.findElement(loginButtonLocator);
    }

    private By bunnerContinueButtonLocator = By.id("banner-continue-btn");
    private WebElement bunnerContinueButton;


    private By loginRememberCheckboxLocator = By.id("login-remember");
    public WebElement getLoginRememberCheckbox() {
        return driver.findElement(loginRememberCheckboxLocator);
    }



    public OpenenglishLoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Login with {0} username")
    public OpenenglishLoginPage enterLogin(String s) {
        getLoginTextbox().sendKeys(s);
        return this;
    }

    @Step("Enter {0} Password ")
    public OpenenglishLoginPage enterPassword(String s) {
        getPasswordTextbox().sendKeys(s);
        return this;
    }

    public OpenEnglishMainPage pressLogInButton() {
        getLoginButton().click();
        return new OpenEnglishMainPage(driver);

    }

    public void closeBunnerContinue() {
        bunnerContinueButton = driver.findElement(bunnerContinueButtonLocator);
        bunnerContinueButton.click();
    }

    public OpenenglishLoginPage setRememberCheckbox(){
        getLoginRememberCheckbox().click();
        return this;
    }

}
