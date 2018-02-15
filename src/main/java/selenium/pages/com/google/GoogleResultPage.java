package selenium.pages.com.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleResultPage {

    private WebDriver driver;
    private By linkLocator = By.xpath("//*[@id=\"rso\"]/div[2]/div/div[1]/div/div/h3/a");
    private WebElement linkField;
    private By linksLocator = By.xpath("//*[@id=\"rso\"]/div/div/div/div/div/h3/a");
    private List<WebElement> resultList;

    public GoogleResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findLink(){
        linkField = driver.findElement(linkLocator);
        return linkField;
    }

    public List findElements(){
        resultList = driver.findElements(linksLocator);
        return resultList;
    }
}
