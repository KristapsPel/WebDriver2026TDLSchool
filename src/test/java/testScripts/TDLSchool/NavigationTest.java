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


public class NavigationTest extends BasePage {
//    Create Report before all test begin
//    Create test before each Test method
//    Export Report after all tests are done


    @Test(testName = "TDL School navigation",
            description = "We check navigation on TDL School homepage")
    public void openTDLSchoolHomepage() {
        System.out.println("Title:" + driver.getTitle());
        System.out.println("Current URL:" + driver.getCurrentUrl());
    }


    @Test(testName = "TDL School navigation test")
    public void navigationTest() {
        HeaderPage headerPage = new HeaderPage(driver);
        CareerPage careerPage = new CareerPage(driver);
        FooterPage footerPage = new FooterPage(driver);

        extentTest.log(Status.INFO, "Click on Career Paths button");
        headerPage.clickCareerPaths();

        extentTest.log(Status.INFO, "We check if Not sure where to start? title is visible");
        careerPage.validateTitleValue("Not sure where to start?");
        extentTest.log(Status.PASS, "Title is correct");

        extentTest.log(Status.INFO, "We enter test inside email input field in footer");
        footerPage.enterEmail("test");
        addScreenshotToReport(Status.INFO, extentTest);
    }

    @Test(testName = "Validate visible courses count on Homepage")
    public void checkCoursesCount() {
        HomePage homePage = new HomePage(driver);

        extentTest.log(Status.INFO, "Check that 4 elements are visible inside upcoming lectures");
        homePage.validateUpcomingCourseCount(4);
        extentTest.log(Status.PASS, "Upcoming lecture shows correct amount of courses");
    }

    public void addScreenshotToReport(Status status, ExtentTest test) {
        // Capture the screenshot as a Base64 string and prepend with the data URI scheme for a PNG image
        String base64ScreenShot = "data:image/png;base64," + ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BASE64);

        // Log the screenshot to the report with the specified status (PASS, FAIL, etc.)
        test.log(status, MediaEntityBuilder.createScreenCaptureFromBase64String(base64ScreenShot).build());
    }

}
