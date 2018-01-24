package net.ukr;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchUkrNetTest {
    private WebDriver driver;
    private By searchStringLocator = By.xpath("//*[@id=\"uh-search-box\"]");
    private By searchButtonLocator = By.xpath("//*[@id=\"yui_3_18_0_4_1516211864145_1227\"]");
    private By resultLinkLocator = By.xpath("//*[@id=\"yui_3_10_0_1_1516211938897_211\"]");
    private WebElement searchString;
    private WebElement searchButton;
    private WebElement resultLink;
    private String searchData = "Teach";

    @BeforeClass
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void searchGoogleTest() {
        driver.get("https://www.yahoo.com/");
        searchString = driver.findElement(searchStringLocator);
        searchString.sendKeys(searchData);
        searchString.submit();

        searchButton = driver.findElement(searchButtonLocator);
        searchButton.click();
        resultLink = driver.findElement(resultLinkLocator);
        Assert.assertTrue(resultLink.getText().contains(searchData));
    }
}
