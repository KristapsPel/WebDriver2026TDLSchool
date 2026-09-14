package testScripts.TDLSchool;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.HeaderPage;
import utils.WebDriverHelper;

import java.io.File;
import java.lang.reflect.Method;

public class BasePage {
    protected WebDriver driver;
    private ExtentReports report;
    public ExtentTest extentTest;

    @BeforeSuite
    public void createReport(){
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(
                System.getProperty("user.dir") + File.separator +
                        "report" + File.separator +
                        "TestReport.html");

        report = new ExtentReports();
        report.attachReporter(sparkReporter);
    }

    @AfterSuite
    public void generateReport() {
        report.flush();
    }

    @BeforeMethod
    public void setUpBrowser(Method method){
        extentTest = report.createTest(method.getAnnotation(Test.class).testName(),
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
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
