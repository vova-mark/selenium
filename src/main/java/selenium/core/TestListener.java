package selenium.core;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

import static com.google.common.io.Files.toByteArray;

public class TestListener implements ITestListener {
    private WebDriver driver;

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        driver = ((WebDriverTestBase) iTestResult.getInstance()).driver;
        //File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        this.saveImageAttach(iTestResult.getTestName() + "_methodFailure");
//        try {
//            FileUtils.copyFile(scrFile,
//                    new File(PropertiesCache.getProperty("directory.screens")
//                            + iTestResult.getMethod().getMethodName() + ".png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    @Attachment(value = "{0}", type = "image/png")
    public byte[] saveImageAttach(String attachName){
        try{
            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            return toByteArray(srcFile);
        }catch (Exception ex){
            ex.printStackTrace();
            return new byte[0];
        }
    }
}
