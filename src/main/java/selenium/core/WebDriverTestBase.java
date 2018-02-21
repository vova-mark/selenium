package selenium.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static selenium.util.PropertiesCache.getProperty;

@Listeners({TestListener.class})
public class  WebDriverTestBase {

    protected WebDriver driver;
    protected BrowsersEnum browser = BrowsersEnum.valueOf(System.getProperty("browser", getProperty("defaultbrowser")));

    private DesiredCapabilities setDesiredCapabilities(String platform, String remoteBrowser){
        DesiredCapabilities caps = new DesiredCapabilities();
        if (platform.equalsIgnoreCase(Platform.WIN10.name())) {
            caps.setPlatform(Platform.WIN10);
            caps.setBrowserName(remoteBrowser);
        }

        return caps;
    }

    @Parameters({"platform", "remoteBrowser"})
    @BeforeClass
    public void SetUp(@Optional String platform, @Optional String remoteBrowser) throws MalformedURLException {
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
            case REMOTE:
                DesiredCapabilities caps = setDesiredCapabilities(platform, remoteBrowser);
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
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
