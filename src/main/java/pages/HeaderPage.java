package pages;

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


    public HeaderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void checkIfLogoIsDisplayed() {
        System.out.println("Check if TDL School logo is Displayed");
        Assert.assertTrue(logo.isDisplayed(), "TDL School Logo is not Displayed ");
    }

    public void clickCareerPaths() {
        System.out.println("Click on Career Paths");
        careerPathLink.click();
    }
}
