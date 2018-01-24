package com.google;

import com.google.core.WebDriverTestBase;
import com.google.pages.GmailLoginPage;
import com.google.pages.GmailLoginPageFactoryPattern;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class GmailLoginPageObjectTest extends WebDriverTestBase {

    @Test
    public void gmailLoginTest() {
        driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
        GmailLoginPage gmailLoginPage = new GmailLoginPage(driver);
        gmailLoginPage.Login("0934033001", "asdasda");
    }

    @Test
    public void gmailLoginTestFactoryUse() {
        driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
        GmailLoginPageFactoryPattern loginPage = PageFactory.initElements(driver, GmailLoginPageFactoryPattern.class);
        loginPage.Login("0934033001", "22091973-intx");
    }

}
