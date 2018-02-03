package selenium.com.openenglish.stg.learningplatform.pages;

import org.openqa.selenium.WebDriver;

public class AbstractBasePage {

    protected WebDriver driver;
    protected WebDriverUtil util;

    public AbstractBasePage(WebDriver driver) {
        this.driver = driver;
        this.util = new WebDriverUtil(driver);
    }



}
