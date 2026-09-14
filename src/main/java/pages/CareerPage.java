package pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CareerPage {
    @FindBy(css = "div>h1")
    private WebElement title;

    private ExtentTest extentTest;

    public CareerPage(WebDriver driver, ExtentTest extentTest) {
        PageFactory.initElements(driver, this);
        this.extentTest=extentTest;
    }

    public void validateTitleValue(String expectedTitle) {
        extentTest.log(Status.INFO,"Check if “"+expectedTitle+"” title is displayed");
        String actualTitleValue = title.getText();
        Assert.assertEquals(actualTitleValue, expectedTitle);
        extentTest.log(Status.PASS, expectedTitle+" title is displayed");
    }
}
