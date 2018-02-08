package selenium.pages.com.openenglish.stg.learningplatform;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenenglishLoginPage extends AbstractBasePage {

    private By loginTextboxLocator = By.id("username");
    private WebElement loginTextbox;

    private By passwordTextboxLocator = By.id("password");
    private WebElement passwordTextbox;

    private By loginButtonLocator = By.id("login-btn");
    private WebElement loginButton;

    private By bunnerContinueButtonLocator = By.id("banner-continue-btn");
    private WebElement bunnerContinueButton;

    private By avatarImageLocator = By.cssSelector("div.navbar-toggler");
    private WebElement avatarImage;

    private By dropdownUsernameLocator = By.cssSelector("p.dropdown-item.username");
    private WebElement dropdownUsername;

    public OpenenglishLoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterLogin(String s) {
        loginTextbox = driver.findElement(loginTextboxLocator);
        loginTextbox.sendKeys(s);
    }

    public void enterPassword(String s) {
        passwordTextbox = driver.findElement(passwordTextboxLocator);
        passwordTextbox.sendKeys(s);
    }

    public void pressLogInButton() {
        loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }

    public void closeBunnerContinue() {
        bunnerContinueButton = driver.findElement(bunnerContinueButtonLocator);
        bunnerContinueButton.click();
    }

    public void hoverAvatarImage() {

    }

    public String getDropdownUsername() {
        avatarImage = driver.findElement(avatarImageLocator);
        avatarImage.click();
        //Actions actions = new Actions(driver);
        //actions.moveToElement(avatarImage).build().perform();
        dropdownUsername = driver.findElement(dropdownUsernameLocator);
        //dropdownUsername = util.waitFor(ExpectedConditions.visibilityOf(dropdownUsername));
        return dropdownUsername.getText();
    }
}
