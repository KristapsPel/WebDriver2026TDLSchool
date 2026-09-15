package pages.AutomationPractice;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class RegistrationPage {
    @FindBy(css = "input[type='radio']")
    private List<WebElement> radioTitleButtons;

    @FindBy(id ="password")
    private WebElement passwordField;

    @FindBy(id = "days")
    private WebElement selectDays;

    @FindBy(id = "months")
    private WebElement selectMonths;

    @FindBy(id = "years")
    private WebElement selectYears;

    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "address1")
    private WebElement addressInput;

    @FindBy(id = "country")
    private WebElement selectCountry;

    @FindBy(id = "state")
    private WebElement stateInput;

    @FindBy(id = "city")
    private WebElement cityInputField;

    @FindBy(id = "zipcode")
    private WebElement zipCodeField;

    @FindBy(id = "mobile_number")
    private WebElement phoneNumberField;

    @FindBy(css = "button[data-qa]")
    private WebElement createAccountButton;

    private ExtentTest extentTest;

    public RegistrationPage (WebDriver driver, ExtentTest extentTest) {
        this.extentTest=extentTest;
        PageFactory.initElements(driver, this);
    }

    private void selectTitle(String title) {
        boolean isFound = false;
        for (WebElement selectOption: radioTitleButtons) {
            if (selectOption.getAttribute("value")==title){
                selectOption.click();
                extentTest.log(Status.PASS, "Select title:"+title);
                isFound = true;
                break;
            }
        }
        Assert.assertTrue(isFound, "There is not tile "+title+" available");
    }

    private void enterPassword(String password) {
        Assert.assertTrue(passwordField.isDisplayed(), "Password field is not visible.");
        extentTest.log(Status.PASS, "Password field is present");
        extentTest.log(Status.INFO, "Enter "+password+" in password field");
        passwordField.sendKeys(password);
    }

    private void selectDate(String day, String month, String year){
        Select dropdownDays = new Select(selectDays);
        Select dropdownMonth = new Select(selectMonths);
        Select dropdownYear = new Select(selectYears);

        extentTest.log(Status.INFO, "Enter "+day+" in days field");
        dropdownDays.selectByVisibleText(day);
        extentTest.log(Status.INFO, "Enter "+month+" in months field");
        dropdownMonth.selectByVisibleText(month);
        extentTest.log(Status.INFO, "Enter "+year+" in years field");
        dropdownYear.selectByVisibleText(year);
    }

    private void enterFirstName(String firstName) {
        Assert.assertTrue(firstNameInput.isDisplayed(), "First Name field is not visible.");
        extentTest.log(Status.PASS, "First Name field is present");
        extentTest.log(Status.INFO, "Enter "+firstName+" in First Name field");
        firstNameInput.sendKeys(firstName);
    }

    private void enterLastName(String lastName) {
        Assert.assertTrue(lastNameInput.isDisplayed(), "Last Name field is not visible.");
        extentTest.log(Status.PASS, "Last Name field is present");
        extentTest.log(Status.INFO, "Enter "+lastName+" in last Name field");
        lastNameInput.sendKeys(lastName);
    }
    private void enterAddress(String address) {
        Assert.assertTrue(addressInput.isDisplayed(), "Address field is not visible.");
        extentTest.log(Status.PASS, "Address field is present");
        extentTest.log(Status.INFO, "Enter "+address+" in last Name field");
        addressInput.sendKeys(address);
    }
    private void enterState(String state) {
        Assert.assertTrue(stateInput.isDisplayed(), "State field is not visible.");
        extentTest.log(Status.PASS, "State field is present");
        extentTest.log(Status.INFO, "Enter "+state+" in State field");
        stateInput.sendKeys(state);
    }
    private void enterCity(String city) {
        Assert.assertTrue(cityInputField.isDisplayed(), "City field is not visible.");
        extentTest.log(Status.PASS, "Last Name field is present");
        extentTest.log(Status.INFO, "Enter "+city+" in City field");
        cityInputField.sendKeys(city);
    }
    private void enterZipCode(String zipCode) {
        Assert.assertTrue(zipCodeField.isDisplayed(), "ZipCode field is not visible.");
        extentTest.log(Status.PASS, "ZipCode field is present");
        extentTest.log(Status.INFO, "Enter "+zipCode+" in ZipCode field");
        zipCodeField.sendKeys(zipCode);
    }
    private void enterPhoneNumber(String phoneNumber) {
        Assert.assertTrue(phoneNumberField.isDisplayed(), "Mobile phone field is not visible.");
        extentTest.log(Status.PASS, "Mobile Phone field is present");
        extentTest.log(Status.INFO, "Enter "+phoneNumber+" in Mobile phone field");
        phoneNumberField.sendKeys(phoneNumber);
    }

    private void clickCreateAccount(){
        Assert.assertTrue(createAccountButton.isDisplayed(), "Create account button is not visible.");
        extentTest.log(Status.PASS, "Create account button is present");
        extentTest.log(Status.INFO, "Click on Create account");
        createAccountButton.click();
    }
}
