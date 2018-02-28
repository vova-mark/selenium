package selenium.pages.com.google;

import org.openqa.selenium.WebDriver;
import selenium.util.WebDriverUtil;


public class AbstractPage {

    protected WebDriver driver;
    protected WebDriverUtil webDriverUtil;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.webDriverUtil = new WebDriverUtil(driver);
    }
}
