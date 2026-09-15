package testScripts.TDLSchool;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import pages.TDLSchool.CareerPage;
import pages.TDLSchool.FooterPage;
import pages.TDLSchool.HeaderPage;
import pages.TDLSchool.HomePage;
import testScripts.BasePage;

import static utils.ExtentReportHelper.addScreenshotToReport;


public class NavigationTest extends BasePage {
//    Create Report before all test begin
//    Create test before each Test method
//    Export Report after all tests are done


    @Test(testName = "TDL School navigation",
            description = "We check navigation on TDL School homepage")
    public void openTDLSchoolHomepage() {
        HeaderPage headerPage = new HeaderPage(driver, extentTest);
        headerPage.checkIfLogoIsDisplayed();

        extentTest.log(Status.INFO, "Title:" + driver.getTitle());
        extentTest.log(Status.INFO, "Current URL:" + driver.getCurrentUrl());
    }


    @Test(testName = "TDL School navigation test")
    public void navigationTest() {
        HeaderPage headerPage = new HeaderPage(driver ,extentTest);
        CareerPage careerPage = new CareerPage(driver, extentTest);
        FooterPage footerPage = new FooterPage(driver, extentTest);

        headerPage.checkIfLogoIsDisplayed();
        headerPage.clickCareerPaths();
        careerPage.validateTitleValue("Not sure where to start?");
        footerPage.enterEmail("test");
        addScreenshotToReport(Status.INFO,"Screenshot of input field", extentTest, driver);
    }

    @Test(testName = "Validate visible courses count on Homepage")
    public void checkCoursesCount() {
        HomePage homePage = new HomePage(driver, extentTest);
        HeaderPage headerPage = new HeaderPage(driver, extentTest);

        headerPage.checkIfLogoIsDisplayed();
        homePage.validateUpcomingCourseCount(8);
    }

}
