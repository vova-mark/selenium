package selenium.core;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

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
        saveImageAttach(iTestResult.getMethod().getQualifiedName());
//        try {
//            FileUtils.copyFile(scrFile,
//                    new File(PropertiesCache.getProperty("directory.screens")
//                            + iTestResult.getMethod().getMethodName() + ".png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    @Attachment(value = "{0}", type = "image/png")
    public byte[] saveImageAttach(String attachName){
        return  ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
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


}
