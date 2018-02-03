package selenide.pages.com.google;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GoogleSearchResultPageSelenide {

    private SelenideElement resultLink = $(By.xpath("//*[@id=\"rso\"]/div/div/div[1]/div/div/h3/a"));
    private ElementsCollection resultLinks = $$(By.xpath("//*[@id=\"rso\"]/div/div/div/div/div/h3/a"));

    public SelenideElement getResultLink() {
        return resultLink;
    }

    public ElementsCollection getResultLinks() {
        return resultLinks;
    }

}
