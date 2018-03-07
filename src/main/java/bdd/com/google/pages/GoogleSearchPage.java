package bdd.com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {
    private WebDriver driver;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchForText(String searchString) {
        WebElement searchTextbox = driver.findElement(By.cssSelector("input[name=q]"));
        searchTextbox.sendKeys(searchString);
        searchTextbox.submit();
    }
}
