package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomePage {

    @FindBy(css="a.course-suggestions__course-card--active>div.cover-photo")
    private List<WebElement> visibleUpcomingCourse;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void validateUpcomingCourseCount(int expectedCount) {
        Assert.assertEquals(visibleUpcomingCourse.size(), expectedCount,
                "There not "+expectedCount+" elements visible");
    }
}
