package selenium.pages.ua.com.rozetka;

import org.openqa.selenium.WebDriver;
import selenium.util.WebDriverUtil;

public class RozetkaAbstractPage  {

    protected WebDriver driver;
    private WebDriverUtil driverUtil;

    public RozetkaAbstractPage(WebDriver driver) {
        this.driver = driver;
        this.driverUtil = new WebDriverUtil(driver);
    }

    public void setDriver(WebDriver driver){
        this.driver = driver;
    }
}
