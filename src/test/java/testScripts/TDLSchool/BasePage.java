package testScripts.TDLSchool;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HeaderPage;
import utils.WebDriverHelper;

import java.io.File;
import java.lang.reflect.Method;

import static utils.ExtentReportHelper.*;

public class BasePage {
    protected WebDriver driver;
    public ExtentTest extentTest;

    @BeforeSuite
    public void createReport() {
        createReportObject();
    }

    @AfterSuite
    public void generateReport() {
        generateHTMLReportFile();
    }

    @BeforeMethod
    public void setUpBrowser(Method method) {
        extentTest = createTest(method.getAnnotation(Test.class).testName(),
                method.getAnnotation(Test.class).description());
        driver = WebDriverHelper.setUpDriverWithWDM("CHROME");
        driver.manage().window().maximize();
        driver.get("https://tdlschool.com/");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.checkIfLogoIsDisplayed();
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
