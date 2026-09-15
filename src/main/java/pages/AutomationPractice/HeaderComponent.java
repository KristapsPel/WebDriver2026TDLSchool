package pages.AutomationPractice;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HeaderComponent {
    @FindBy(className = "fa-lock")
    private WebElement signUpButton;

    @FindBy(css="button[aria-label='Consent']")
    private WebElement consent;

    private ExtentTest extentTest;

    public HeaderComponent(WebDriver driver, ExtentTest extentTest) {
        this.extentTest = extentTest;
        PageFactory.initElements(driver, this);
    }

    public void clickOnSignUpButton(){
        Assert.assertTrue(signUpButton.isDisplayed(), "Sign Up button is not Displayed");
        extentTest.log(Status.PASS, "Sign up button is visible");
        extentTest.log(Status.INFO, "Click on Sign Up");
        signUpButton.click();
    }

    public void clickConsent(){
        extentTest.log(Status.INFO, "Click on Consent is cookies popup");
        consent.click();
    }
}
