package testScripts.AutomationPractice;

import org.testng.annotations.Test;
import pages.AutomationPractice.HeaderComponent;
import pages.AutomationPractice.LoginPage;
import testScripts.BasePage;

public class RegistrationTest extends BasePage {

    @Test(testName = "Registration form validation",
            description = "We validate that registration flow works correctly.")
    public void registrationTest(){
        HeaderComponent header = new HeaderComponent(driver, extentTest);
        LoginPage loginPage = new LoginPage(driver, extentTest);

        header.clickOnSignUpButton();
        loginPage.enterSignUpForm("test@email.test", "Test User");
    }
}
