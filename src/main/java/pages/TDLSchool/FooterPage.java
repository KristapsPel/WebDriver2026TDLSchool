package pages.TDLSchool;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterPage {

    @FindBy(name = "email")
    private WebElement emailInput;

    private ExtentTest extentTest;

    public FooterPage(WebDriver driver, ExtentTest extentTest) {
        PageFactory.initElements(driver, this);
        this.extentTest = extentTest;
    }

    public void enterEmail(String email) {
        extentTest.log(Status.INFO,"Enter “"+email+"” in footer input field email");
        emailInput.sendKeys(email);
    }
}
