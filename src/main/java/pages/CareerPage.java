package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CareerPage {
    @FindBy(css = "div>h1")
    private WebElement title;

    public CareerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void validateTitleValue(String expectedTitle) {
        System.out.println("Check if “"+expectedTitle+"” title is displayed");
        String actualTitleValue = title.getText();
        Assert.assertEquals(actualTitleValue, expectedTitle);
    }
}
