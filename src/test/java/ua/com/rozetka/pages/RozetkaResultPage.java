package ua.com.rozetka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RozetkaResultPage extends RozetkaAbstractPage {

    @FindBy(how = How.XPATH, using = "//*[@id=\"catalog_goods_block\"]/div/div/div/div/div/div/div/div/div/div/form/span/button")
    private WebElement addGoodButton;

    //private By goodItems = By.cssSelector("div.g-i-tile-catalog");
    private By linksOfGoodsItem = By.xpath("//*[@id=\"catalog_goods_block\"]/div/div/div[1]/div/div[1]/div[2]/div[4]/a");

    public RozetkaResultPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getGoods() {
        return driver.findElements(linksOfGoodsItem);
    }

    public void addGoodToBasket() {
        addGoodButton.click();
    }

    public CartPopupPage getCartPopup() {
        CartPopupPage result = PageFactory.initElements(driver, CartPopupPage.class);
        result.setDriver(driver);
        return result;
    }


}
