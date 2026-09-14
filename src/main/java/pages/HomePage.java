package pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.PrimitiveIterator;

public class HomePage {

    @FindBy(css="a.course-suggestions__course-card--active>div.cover-photo")
    private List<WebElement> visibleUpcomingCourse;

    private ExtentTest extentTest;

    public HomePage(WebDriver driver, ExtentTest extentTest) {
        PageFactory.initElements(driver, this);
        this.extentTest = extentTest;
    }

    public void validateUpcomingCourseCount(int expectedCount) {
        extentTest.log(Status.INFO, "Check that "+expectedCount+" upcoming" +
                " lecture elements are displayed in Home Page");
        Assert.assertEquals(visibleUpcomingCourse.size(), expectedCount,
                "There not "+expectedCount+" elements visible");
        extentTest.log(Status.PASS, expectedCount+" upcoming" +
                " lecture elements are displayed in Home Page");
    }
}
