package selenide.com.google;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import selenide.core.SelenideTestBase;
import selenide.pages.com.google.GoogleSearchPageSelenide;
import selenide.pages.com.google.GoogleSearchResultPageSelenide;
import selenium.core.TestListener;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

@Listeners({TestListener.class})
public class SearchGoogleTestSelenideEdition extends SelenideTestBase {

    private GoogleSearchPageSelenide searchPage = new GoogleSearchPageSelenide();
    private GoogleSearchResultPageSelenide resultPage = new GoogleSearchResultPageSelenide();

    @Test
    public void searchGoogleSelenideFirstLinkTest() {
        open("https://www.google.com.ua/");
        searchPage.searchFor("selenide");
        resultPage.getResultLink().should(text("Selenide"));
    }

    @Test
    public void searchGoogleSelenideLinksTest() {
        open("https://www.google.com.ua/");
        searchPage.searchFor("selenide");
        resultPage.getResultLinks()
                .shouldHaveSize(10)
                .forEach(selenideElement -> selenideElement.should(text("Selenide")));

    //        for(SelenideElement element : resultPage.getResultLinks()){
    //            element.should(text("Selenide"));
    //        }

    }
}
