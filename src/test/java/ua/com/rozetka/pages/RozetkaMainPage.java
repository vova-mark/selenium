package ua.com.rozetka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RozetkaMainPage extends RozetkaAbstractPage{

    @FindBy(how = How.CSS, using = "input.rz-header-search-input-text")
    private WebElement searchForGoodtextBox;

    @FindBy(how = How.CSS, using = "button.js-rz-search-button ")
    private WebElement searchButton;

    public RozetkaMainPage(WebDriver driver) {
        super(driver);
    }

    public RozetkaResultPage searchForGood(String searchText) {
        searchForGoodtextBox.sendKeys(searchText);
        searchButton.click();
        RozetkaResultPage result = PageFactory.initElements(driver, RozetkaResultPage.class);
        result.setDriver(driver);
        return result;
    }

}
