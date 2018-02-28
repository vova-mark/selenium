package selenium.ua.silpo;

import org.testng.annotations.Test;
import selenium.core.WebDriverTestBase;
import selenium.pages.ua.silpo.SilpoMainPage;

public class SilpoStoresSortingTest extends WebDriverTestBase {

    //@Test
    public void StoresNamesSortingTest(){
        driver.get("https://silpo.ua");
        SilpoMainPage mainPage = new SilpoMainPage(driver);

        mainPage.clickNearestStoreButton().clickCitiesDropdown();

    }
}
