package com.google;

import selenium.com.google.core.WebDriverTestBase;
import selenium.com.google.pages.GoogleResultPage;
import selenium.com.google.pages.GoogleSearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchGoogleTest extends WebDriverTestBase {

    private By searchFieldLocator = By.name("q");
    private By linkLocator = By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div/div/h3/a");
    private By searchButtonLocator = By.xpath("//*[@id=\"sbtc\"]/div[2]/div[2]/div[1]/div/ul/li[11]/div/span[1]/span/input");
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
        //searchString.submit();
        searchButton = driver.findElement(searchButtonLocator);
        searchButton.click();
        //linkField = driver.findElement(linkLocator);
        resultList = driver.findElements(linkLocator);
        for (WebElement element : resultList) {
            Assert.assertTrue(element.getText().toLowerCase().contains(searchData));
        }
        //Assert.assertTrue(linkField.getText().contains(searchData));
        driver.quit();
    }

    @Test
    public void searchGooglePageObjectTest(){

        driver.get("https://www.google.com.ua/");
        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        searchPage.searchFor(searchData);
        GoogleResultPage resultPage = new GoogleResultPage(driver);
        linkField = resultPage.findLink();
        Assert.assertTrue(linkField.getText().contains(searchData));
        driver.close();

    }
}
