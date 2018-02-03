package net.ukr;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

public class SearchUkrNetTest {
    private WebDriver driver;
    private By searchStringLocator = By.id("search-input");
    private By searchButtonLocator = By.cssSelector("input[value=Пошук]");
    private By resultLinkLocator = By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div/div/h3/a");
    private WebElement searchString;
    private WebElement searchButton;
    private WebElement resultLink;
    private String searchData = "Selenium";

    @BeforeClass
    public void SetUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void searchUkrNetTestMethod() {
        driver.get("https://www.ukr.net/");
        searchString = driver.findElement(searchStringLocator);
        searchString.sendKeys(searchData);

        searchButton = driver.findElement(searchButtonLocator);
        searchButton.click();

        ArrayList<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(1));

        resultLink = driver.findElement(resultLinkLocator);
        Assert.assertTrue(resultLink.getText().contains(searchData));
        driver.quit();
    }
}
