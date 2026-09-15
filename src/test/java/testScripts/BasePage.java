package testScripts;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ConfigFileReader;
import utils.WebDriverHelper;

import java.lang.reflect.Method;

import static utils.ExtentReportHelper.*;

public class BasePage {
    protected WebDriver driver;
    public ExtentTest extentTest;
    private ConfigFileReader configFileReader;

    @BeforeSuite
    public void createReport() {
        createReportObject();
    }

    @AfterSuite
    public void generateReport() {
        generateHTMLReportFile();
    }
    @BeforeClass
    @Parameters("configFile")
    public void readProperties(String configFile){
        configFileReader = new ConfigFileReader(configFile);
    }

    @BeforeMethod
    public void setUpBrowser(Method method) {
        extentTest = createTest(method.getAnnotation(Test.class).testName(),
                method.getAnnotation(Test.class).description());
        extentTest.assignAuthor(configFileReader.getValueFromProperties("author"));
        driver = WebDriverHelper.setUpDriver(configFileReader.getUrl(), configFileReader.getBrowser());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            addScreenshotToReport(Status.FAIL, result.getThrowable().getMessage(), extentTest, driver);
        }

        driver.close();
        driver.quit();
    }
}
