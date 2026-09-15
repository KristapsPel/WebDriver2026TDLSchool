package pages.AutomationPractice;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AccountCreatedPage {
    @FindBy(css = "h2>b")
    private WebElement tile;

    private ExtentTest extentTest;

    public AccountCreatedPage(WebDriver driver, ExtentTest extentTest){
        this.extentTest=extentTest;
        PageFactory.initElements(driver, this);
    }

    public void validateTitle(String expectedTitle){
        Assert.assertEquals(tile.getText(), expectedTitle, "Actual text is not "+expectedTitle);
        extentTest.log(Status.PASS, "Page title is "+expectedTitle);
    }
}
