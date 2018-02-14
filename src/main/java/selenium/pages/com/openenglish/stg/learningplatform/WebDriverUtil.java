package selenium.pages.com.openenglish.stg.learningplatform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.util.PropertiesCache;

public class WebDriverUtil {

    protected WebDriver driver;
    private WebDriverWait wait;

    public WebDriverUtil(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Long.parseLong(PropertiesCache.getProperty("wait.explicit")));
    }

    public WebElement waitFor(ExpectedCondition<WebElement> expectedCondition) {

        return wait.until(expectedCondition);

    }
}

