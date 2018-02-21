package selenium.pages.com.openenglish.stg.learningplatform;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpenEnglishMainPage extends AbstractBasePage {

    public OpenEnglishMainPage(WebDriver driver) {
        super(driver);
    }

    private By avatarImageLocator = By.xpath("//a[@id='nav-account']/img");
    private WebElement avatarImage;

    private By dropdownUsernameLocator = By.cssSelector("p.username.dropdown-item");
    private WebElement dropdownUsername;

    private WebElement logOutButton;
    private By logOutbuttonLocator = By.id("nav-logout");

    public String getDropdownUsername() {
        avatarImage = driver.findElement(avatarImageLocator);
        avatarImage.click();
        dropdownUsername = driver.findElement(dropdownUsernameLocator);
        dropdownUsername = util.waitFor(ExpectedConditions.visibilityOf(dropdownUsername));
        return dropdownUsername.getText();
    }

    public OpenenglishLoginPage logOut(){
        avatarImage = driver.findElement(avatarImageLocator);
        avatarImage.click();
        logOutButton = driver.findElement(logOutbuttonLocator);
        logOutButton.click();
        return new OpenenglishLoginPage(driver);
    }
}
