package selenium.pages.com.openenglish.stg.learningplatform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbstractBasePage {

    protected WebDriver driver;
    protected WebDriverUtil util;

    public AbstractBasePage(WebDriver driver) {
        this.driver = driver;
        this.util = new WebDriverUtil(driver);
    }
}
