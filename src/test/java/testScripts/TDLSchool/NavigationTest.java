package testScripts.TDLSchool;

import org.testng.annotations.Test;
import pages.CareerPage;
import pages.FooterPage;
import pages.HeaderPage;
import pages.HomePage;


public class NavigationTest extends BasePage {

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

        headerPage.clickCareerPaths();
        careerPage.validateTitleValue("Not sure where to start?");
        footerPage.enterEmail("test");

    }

    @Test
    public void checkCoursesCount() {
        HomePage homePage = new HomePage(driver);

        homePage.validateUpcomingCourseCount(4);
    }

}
