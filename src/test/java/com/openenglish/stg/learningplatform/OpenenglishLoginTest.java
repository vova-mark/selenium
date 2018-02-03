package com.openenglish.stg.learningplatform;

import selenium.com.openenglish.stg.learningplatform.core.WebDriverTestBase;
import selenium.com.openenglish.stg.learningplatform.pages.OpenenglishLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenenglishLoginTest extends WebDriverTestBase {

    @Test
    public void LoginWithCorrectCredentialsTest() {
        driver.get("https://learningplatform.stg.openenglish.com");
        OpenenglishLoginPage loginPage = new OpenenglishLoginPage(driver);
        loginPage.closeBunnerContinue();
        loginPage.enterLogin("shiosaky@gmail.com.oe");
        loginPage.enterPassword("123456");
        loginPage.pressLogInButton();
        //TODO найти мальчика
        //loginPage.hoverAvatarImage();
        String string = loginPage.getDropdownUsername();
        Assert.assertTrue(string.contains("Daniel"));
        Assert.assertTrue(string.contains("Shiosaky"));


    }
}
