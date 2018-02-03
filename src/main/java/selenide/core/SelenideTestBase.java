package selenide.core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.WebDriverRunner.*;


public class SelenideTestBase {

    private String browser = System.getProperty("browser", CHROME);

    @BeforeClass
    public void SetUp() {

        //проблема в том, что selenide быстро закрывает драйвер, может не успеть пройти последний тест
        //Configuration.closeBrowserTimeoutMs = Long.parseLong(""); установить время на закрытие браузера
        Configuration.holdBrowserOpen = true; //или false - закрывать ли браузет после или оставить открытым

        Configuration.browser = browser;
        switch (browser) {
            case CHROME:
                ChromeDriverManager.getInstance().setup();
                break;
            case FIREFOX:
                FirefoxDriverManager.getInstance().setup();
                break;
            case EDGE:
                EdgeDriverManager.getInstance().setup();
                break;
        }
    }

    @AfterClass
    public void tearDown() {
        WebDriverRunner.getWebDriver().quit();
    }
}
