package selenium.com.openenglish.stg.learningplatform;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import selenium.core.TestListener;
import selenium.core.WebDriverTestBase;
import selenium.pages.com.openenglish.stg.learningplatform.OpenenglishLoginPage;


@Feature("OpenenglishTest Feature annotation")
@Story("Add tickets on task. Allure annotation")
public class OpenenglishTest extends WebDriverTestBase {

    String correctLogin = "shiosaky@gmail.com.oe";
    String correctPassword = "123456";

    @Description("Allure method description annotation. Boy tests...")
    @Test
    public void LoginWithCorrectCredentialsTest() {
        driver.get("https://learningplatform.stg.openenglish.com");
        OpenenglishLoginPage loginPage = new OpenenglishLoginPage(driver);
        //loginPage.closeBunnerContinue();
        Assert.assertTrue(loginPage.enterLogin(correctLogin)
                                    .enterPassword(correctPassword)
                                    .pressLogInButton()
                                    .getDropdownUsername()
                                    .contains("Daniel Shiosaky"));
    }

    @Test
    public void Check_appearing_and_disappearing_the_Introducción_video(){
        driver.get(" https://learningplatform.stg.openenglish.com");
        OpenenglishLoginPage loginPage = new OpenenglishLoginPage(driver);

        Assert.assertTrue(!loginPage.getLoginButton()
                                    .isEnabled());

        Assert.assertTrue(loginPage.getPasswordTextbox()
                                    .getAttribute("type").equals("password"));

        Assert.assertTrue(loginPage.enterLogin(correctLogin)
                                    .enterPassword(correctPassword)
                                    .getLoginButton()
                                    .isEnabled());

        loginPage.pressLogInButton();

    }


}