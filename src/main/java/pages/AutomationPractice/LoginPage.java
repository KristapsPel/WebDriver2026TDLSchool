package pages.AutomationPractice;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

    @FindBy(name = "name")
    private WebElement nameInput;

    @FindBy(css = "[data-qa='signup-email']")
    private WebElement emailInput;

    @FindBy(css = "[data-qa='signup-button'")
    private WebElement signUpButton;

    private ExtentTest extentTest;

    public LoginPage(WebDriver driver, ExtentTest extentTest) {
        this.extentTest = extentTest;
        PageFactory.initElements(driver, this);
    }

    private void enterEmail(String email){
        Assert.assertTrue(emailInput.isDisplayed(), "Email field is not Displayed");
        extentTest.log(Status.PASS, "Email field is visible");
        extentTest.log(Status.INFO, "Enter email in Sign Up filed");
        emailInput.sendKeys(email);
    }

    private void enterName(String name) {
        Assert.assertTrue(nameInput.isDisplayed(), "Name field is not Displayed");
        extentTest.log(Status.PASS, "Name field is visible");
        extentTest.log(Status.INFO, "Enter Name in Sign Up filed");
        nameInput.sendKeys(name);
    }

    private void clickSignUpButton(){
        Assert.assertTrue(signUpButton.isDisplayed(), "Sign Up button is not Displayed");
        extentTest.log(Status.PASS, "Sign up button is visible");
        extentTest.log(Status.INFO, "Click on Sign Up button");
        signUpButton.click();
    }

    public void enterSignUpForm(String email, String name){
        enterName(name);
        enterEmail(email);
        clickSignUpButton();
    }
}
