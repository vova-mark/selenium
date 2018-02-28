package selenium.pages.ua.silpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.pages.com.google.AbstractPage;

public class SilpoMainPage extends AbstractPage {
    public SilpoMainPage(WebDriver driver) {
        super(driver);
    }

    private WebElement nearestStoreButton;

    private By nearestStoreButtonLocator = By.cssSelector("button.nearest-store__btn");
    private By citiesSelectMenu = By.xpath("//span[@id='react-select-2--value']/div");
    private By citiesItemsLocator = By.xpath("");


    public SilpoMainPage clickCitiesDropdown(){
        driver.findElement(citiesSelectMenu).click();
        return this;
    }

    public SilpoMainPage clickNearestStoreButton(){
        driver.findElement(nearestStoreButtonLocator).click();
        return this;
    }
}
