package bdd.com.google.steps;

import bdd.com.google.pages.GoogleSearchPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import selenium.pages.com.google.GoogleResultPage;

public class GoogSearchForTextSteps {

    private static final String SEARCH_PAGE = "https://www.google.com.ua/";

    private WebDriver driver;
    private GoogleSearchPage googleSearchPage;
    private GoogleResultPage googleResultPage;


    @Given("New google searching page is opened")
    public void newPageInitialization() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.get(SEARCH_PAGE);
    }

    @When("I type \"([^\"]*)\" to seach")
    public void typeSearchText(String searchString){
        googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.searchForText(searchString);
    }

    @Then("I saw in result page searching string \"([^\"]*)\"")
    public void checkForSearchingTextInResult(String stringToCheck){
        googleResultPage = new GoogleResultPage(driver);
        Assert.assertTrue(googleResultPage.findLink()
                .getText()
                .toLowerCase()
                .contains(stringToCheck));
        driver.close();
    }
}
