package testScripts.TDLSchool;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import pages.CareerPage;
import pages.FooterPage;
import pages.HeaderPage;
import pages.HomePage;

import java.io.File;

import static utils.ExtentReportHelper.addScreenshotToReport;


public class NavigationTest extends BasePage {
//    Create Report before all test begin
//    Create test before each Test method
//    Export Report after all tests are done


    @Test(testName = "TDL School navigation",
            description = "We check navigation on TDL School homepage")
    public void openTDLSchoolHomepage() {
        extentTest.log(Status.INFO, "Title:" + driver.getTitle());
        extentTest.log(Status.INFO, "Current URL:" + driver.getCurrentUrl());
    }


    @Test(testName = "TDL School navigation test")
    public void navigationTest() {
        HeaderPage headerPage = new HeaderPage(driver ,extentTest);
        CareerPage careerPage = new CareerPage(driver, extentTest);
        FooterPage footerPage = new FooterPage(driver, extentTest);

        headerPage.clickCareerPaths();
        careerPage.validateTitleValue("Not sure where to start?");
        footerPage.enterEmail("test");
        addScreenshotToReport(Status.INFO,"Screenshot of input field", extentTest, driver);
    }

    @Test(testName = "Validate visible courses count on Homepage")
    public void checkCoursesCount() {
        HomePage homePage = new HomePage(driver, extentTest);

        homePage.validateUpcomingCourseCount(8);
    }

}
