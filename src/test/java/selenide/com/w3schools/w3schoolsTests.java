package selenide.com.w3schools;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import selenide.core.SelenideTestBase;
import selenium.core.TestListener;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;

@Listeners({TestListener.class})
public class w3schoolsTests extends SelenideTestBase {

    @Test
    public void SelectTest(){
        open("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
        Selenide.switchTo().frame("iframeResult");
        SelenideElement select = Selenide.$(By.xpath("/html/body/select"));
        Assert.assertTrue(select.getSelectedText().equals("Volvo"));
        select.selectOption("Audi");
        Assert.assertTrue(select.getSelectedValue().equals("audi"));
        String s = getWebDriver().getTitle(); //Selenide.switchTo().defaultContent().getTitle(); // has the same result
        Assert.assertTrue(s.contains("Tryit Editor"));
    }

    @Test
    public void AlertTest(){
        open("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
        String s1 = getWebDriver().getTitle();
        Selenide.switchTo().frame("iframeResult");
        $(By.xpath("//body/button")).click();
        Alert alert = Selenide.switchTo().alert();
        Assert.assertTrue(alert.getText().equals("Press a button!"));
        alert.accept();
        //Selenide.switchTo().frame("iframeResult");
        Assert.assertTrue($(By.id("demo")).getText().contains("OK"));
    }

    @Test
    public void ActionsTest(){
        open("https://gojs.net/latest/samples/htmlDragDrop.html?gclid=CLjWnLeG5tQCFUeVGwodCowEcA");
        SelenideElement water = $(By.xpath("//div[.='Water']"));
        SelenideElement canvas = $(By.xpath("//canvas"));

        Selenide.actions()
                .moveToElement(canvas, 170, 160)
                .clickAndHold()
                .moveToElement(canvas, 50, 50)
                .release()
                .build()
                .perform();

        //TODO how to move  element to canvas???
//        Selenide.actions()
//                .moveToElement(water, 70, 10)
//                .clickAndHold()
//                .moveToElement(canvas, 170, 160)
//                .release()
//                .perform();



        //Selenide.actions().clickAndHold(water).moveToElement(canvas).release().build().perform();
        //Selenide.actions().dragAndDrop(water, canvas).build().perform();
    }
}
