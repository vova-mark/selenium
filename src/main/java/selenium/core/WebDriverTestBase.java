package selenium.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import static selenium.util.PropertiesCache.getProperty;


import java.util.concurrent.TimeUnit;

public class  WebDriverTestBase {

    protected WebDriver driver;
    protected BrowsersEnum browser = BrowsersEnum.valueOf(System.getProperty("browser", getProperty("defaultbrowser")));

    @BeforeClass
    public void SetUp() {
        switch (browser) {
            case CHROME:
                //WebDriverManager.chromedriver().version("2.35").setup(); //with specified version of driver
                WebDriverManager.chromedriver().setup();  //with latest version of driver
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                //WebDriverManager.chromedriver().version("2.35").setup(); //with specified version of driver
                WebDriverManager.firefoxdriver().setup();  //with latest version of driver
                driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getProperty("wait.implicit")), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(getProperty("wait.pageload")), TimeUnit.SECONDS); //timeout for page load
        driver.manage().timeouts().setScriptTimeout(Long.parseLong(getProperty("wait.scriptload")), TimeUnit.SECONDS); //timeout for load scripts
    }

    @AfterClass
    public void tearDown() {
        //driver.close(); //current tab
        driver.quit(); //close at all
    }
}
