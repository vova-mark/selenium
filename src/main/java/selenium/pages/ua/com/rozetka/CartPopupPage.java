package selenium.pages.ua.com.rozetka;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CartPopupPage extends RozetkaAbstractPage {

    @FindBy(how = How.CSS, using = "h2.cart-title")
    private WebElement cartHeader;

    //useful, only if cart is empty
    @FindBy(how = How.CSS, using = "div.cart-added a.cart-i-title-link")
    private WebElement linkOfAddedGood;

    //when cart wasn't empty before
    @FindBy(how = How.CSS, using = "div.cart-added a.cart-i-title-link")
    private WebElement linkOfLastAddedGood;

    public WebElement getLinkOfLastAddedGood() {
        return linkOfAddedGood;
    }

    public CartPopupPage(WebDriver driver) {
        super(driver);
    }

    public String headerText (){
        return cartHeader.getText();
    }

}
