package testScripts.AutomationPractice;

import org.testng.annotations.Test;
import pages.AutomationPractice.AccountCreatedPage;
import pages.AutomationPractice.HeaderComponent;
import pages.AutomationPractice.LoginPage;
import pages.AutomationPractice.RegistrationPage;
import testScripts.BasePage;

import java.util.Locale;

public class RegistrationTest extends BasePage {

    @Test(testName = "Registration form validation",
            description = "We validate that registration flow works correctly.")
    public void registrationTest(){
        HeaderComponent header = new HeaderComponent(driver, extentTest);
        LoginPage loginPage = new LoginPage(driver, extentTest);
        RegistrationPage registrationPage = new RegistrationPage(driver, extentTest);
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver, extentTest);

        header.clickConsent();
        header.clickOnSignUpButton();
        loginPage.enterSignUpForm("test@email1.test", "Test User");
        registrationPage.fillTheRegistrationFrom("Mr",
                "P@ssowrd",
                "15",
                "September",
                "2021",
                "TestName",
                "TestLastName",
                "Test address",
                "India",
                "Test state",
                "Test City",
                "2312",
                "312312312123");

        accountCreatedPage.validateTitle("ACCOUNT CREATED!");
    }
}
