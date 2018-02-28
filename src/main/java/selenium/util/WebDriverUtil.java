package selenium.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static selenium.util.PropertiesCache.getProperty;

public class WebDriverUtil {

    protected WebDriver driver;
    private WebDriverWait webDriverWait;

    public WebDriverUtil(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(this.driver, Long.parseLong(getProperty("wait.explicit")));
    }

    public WebElement waitFor(ExpectedCondition<WebElement> expectedCondition) {

        return webDriverWait.until(expectedCondition);

    }
}
