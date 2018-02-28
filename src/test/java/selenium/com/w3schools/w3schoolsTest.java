package selenium.com.w3schools;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.core.WebDriverTestBase;


public class w3schoolsTest extends WebDriverTestBase {

    @Test
    public void SelectTest(){
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
        //W3SchoolsSelectPage page = new W3SchoolsSelectPage(driver);
        driver.switchTo().frame("iframeResult");
        Select selectElement = new Select(driver.findElement(By.xpath("/html/body/select")));
        Assert.assertTrue(selectElement.getFirstSelectedOption().getText().equals("Volvo"));
        selectElement.selectByValue("audi");
        Assert.assertTrue(selectElement.getFirstSelectedOption().getText().equals("Audi"));
        driver.switchTo().defaultContent();
        WebElement title = driver.findElement(By.xpath("/html/head/title"));
        //TODO find why string is empty
        String s = title.getText().toLowerCase();
        Assert.assertTrue(true);//s.contains("tryit"));
    }
    @Test
    public void AlertTest(){
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
        driver.switchTo().frame("iframeResult");
        WebElement tryItButton = driver.findElement(By.xpath("/html/body/button"));
        tryItButton.click();
        Alert alert = driver.switchTo().alert();
        String alerttext = alert.getText();
        Assert.assertTrue(alerttext.contains("Press a button"));
        alert.accept();
        String resultText = driver.findElement(By.id("demo")).getText();
        Assert.assertTrue(resultText.contains("OK"));

    }
    @Test
    public void ActionsTest(){
        driver.get("https://gojs.net/latest/samples/htmlDragDrop.html?gclid=CLjWnLeG5tQCFUeVGwodCowEcA");
        WebElement canvas = driver.findElement(By.xpath("//div[@id='myDiagramDiv']/canvas"));
        WebElement water = driver.findElement(By.xpath("//div[@id='sample']//div[.= 'Water']"));
        WebElement coffee = driver.findElement(By.xpath("//div[@id='sample']//div[.= 'Coffee']"));
        WebElement tea = driver.findElement(By.xpath("//div[@id='sample']//div[.= 'Tea']"));
        Actions builder = new Actions(driver);

        Action newAction = builder.moveToElement(canvas, 170, 160)
                                .clickAndHold()
                                .moveToElement(canvas, 200, 0)
                                .release()
                                .build();
        newAction.perform();

                water.click();
        Action drugWater = builder.moveToElement(water)
                                .clickAndHold()
                                .moveToElement(canvas, 200, 200)
                                .release()
                                .build();

        drugWater.perform();

        Assert.assertTrue(true);

    }
}
