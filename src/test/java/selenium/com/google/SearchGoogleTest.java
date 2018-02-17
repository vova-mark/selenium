package selenium.com.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import selenium.core.TestListener;
import selenium.core.WebDriverTestBase;
import selenium.pages.com.google.GoogleResultPage;
import selenium.pages.com.google.GoogleSearchPage;

import java.util.List;


public class SearchGoogleTest extends WebDriverTestBase {

    private By searchFieldLocator = By.name("q");
    private By linkLocator = By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div/div/h3/a");
    private By searchButtonLocator = By.cssSelector("input[name='btnK']");
    private WebElement searchField;
    private WebElement linkField;
    private List<WebElement> resultList;
    private WebElement searchButton;
    private String searchData = "selenium";

    @Test
    public void searchGoogleTest() {
        driver.get("https://www.google.com.ua/");
        searchField = driver.findElement(searchFieldLocator);
        searchField.sendKeys(searchData);
        searchField.submit();


        linkField = driver.findElement(linkLocator);
        resultList = driver.findElements(linkLocator);
        for (WebElement element : resultList) {
            Assert.assertTrue(element
                    .getText()
                    .toLowerCase()
                    .contains(searchData));
        }
        //Assert.assertTrue(linkField.getText().contains(searchData));
        driver.quit();
    }

    @Test
    public void searchGooglePageObjectTest() {

        driver.get("https://www.google.com.ua/");
        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        searchPage.searchFor(searchData);
        GoogleResultPage resultPage = new GoogleResultPage(driver);
        linkField = resultPage.findLink();
        String result = linkField.getText().toLowerCase();
        Assert.assertTrue(linkField.getText().toLowerCase().contains(searchData));
        driver.close();

    }
}
