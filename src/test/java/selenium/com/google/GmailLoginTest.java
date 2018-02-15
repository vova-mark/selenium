package selenium.com.google;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import selenium.core.TestListener;
import selenium.core.WebDriverTestBase;

import java.util.concurrent.TimeUnit;

@Listeners({TestListener.class})
public class GmailLoginTest extends WebDriverTestBase {

    private WebDriver driver;
    private WebElement loginButton;
    private WebElement loginTextBox;
    private WebElement nextButton;
    private WebElement passwordTextbox;
    private WebElement submitButton;

    private By loginButtonLocator = By.xpath("/html/body/nav/div/a[2]");
    private By loginTextBoxLocator = By.id("identifierId");
    private By nextButtonLocator = By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/form/div[2]/div/div[2]/div[1]/div/content/span");
    private By passwordTextBoxLocator = By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/form/div[2]/div/div[3]/div[1]/div[1]/div/div/div[1]/div/div[1]/input");
    private By submitButtonLocator = By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/form/div[2]/div/div[3]/div[2]/div[1]/div/div[2]");

    @BeforeClass
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    //@Test
    public void LoginTest(){
        driver.get("https://www.gmail.com");
        loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
        loginTextBox = driver.findElement(loginTextBoxLocator);
        loginTextBox.sendKeys("slnmtstaccnt@gmail.com");
        passwordTextbox = driver.findElement(passwordTextBoxLocator);
        passwordTextbox.sendKeys("pss$slnm");
        submitButton = driver.findElement(submitButtonLocator);
        submitButton.click();
    }
}
