package pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HeaderPage {
    @FindBy(className = "navigation__logo")
    private WebElement logo;
    @FindBy(linkText = "Career Paths")
    private WebElement careerPathLink;

    private ExtentTest extentTest;


    public HeaderPage(WebDriver driver, ExtentTest extentTest) {
        PageFactory.initElements(driver, this);
        this.extentTest = extentTest;
    }

    public void checkIfLogoIsDisplayed() {
        extentTest.log(Status.INFO, "Check if TDL School logo is Displayed");
        Assert.assertTrue(logo.isDisplayed(), "TDL School Logo is not Displayed ");
        extentTest.log(Status.PASS, "TDL School logo is displayed");
    }

    public void clickCareerPaths() {
        extentTest.log(Status.INFO,"Click on Career Paths");
        careerPathLink.click();
    }
}
