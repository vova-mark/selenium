package selenium.com.google;


import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import selenium.core.WebDriverTestBase;
import selenium.pages.com.google.GmailLoginPage;
import selenium.pages.com.google.GmailLoginPageFactoryPattern;

import static selenium.util.PropertiesCache.getProperty;

@Feature("Gmail login form")

public class GmailLoginPageObjectTest extends WebDriverTestBase {

    //@Description("Description of signing in google.")
    //@Test
    public void gmailLoginTest() {
        driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
        GmailLoginPage gmailLoginPage = new GmailLoginPage(driver);
        gmailLoginPage.Login("slnmtstaccnt@gmail.com", "pss$slnm");
    }


    @Test
    public void gmailLoginFactoryUseTest() {
        driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
        GmailLoginPageFactoryPattern loginPage = PageFactory.initElements(driver, GmailLoginPageFactoryPattern.class);
        //verify that page is Gmail
        loginPage.Login(getProperty("gmail.login"), getProperty("gmail.password"));
        //Verify that you logged in succefully and u have your mails
    }

    @Test
    public void gmailLoginHometaskTest() {
        driver.get("https://www.gmail.com");
        GmailLoginPageFactoryPattern loginPage = PageFactory.initElements(driver, GmailLoginPageFactoryPattern.class);
        //set driver in instance of page
        //verify that page is Gmail
        //loginPage.Login("slnmtstaccnt@gmail.com", "pss$slnm");
        //Verify that you logged in succefully and u have your mails
    }

}
