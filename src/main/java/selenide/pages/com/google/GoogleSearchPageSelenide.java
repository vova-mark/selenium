package selenide.pages.com.google;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class GoogleSearchPageSelenide {
    private SelenideElement searchTextbox = $(By.name("q")); //$$ returns the list of elements

    public GoogleSearchResultPageSelenide searchFor(String searchString) {
        searchTextbox.val(searchString).pressEnter();
        return new GoogleSearchResultPageSelenide();
    }
}
