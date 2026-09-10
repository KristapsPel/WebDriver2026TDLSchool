package testScripts.TDLSchool;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class NavigationTest {
//    Create new project Web Automation Practice Done
//    Add Selenium and TestNG dependency Done
//    Download and add to project driver Done
//    Create WebDriver object Done
//    Maximize windows size Done
//    Open page: https://tdlschool.com/ Done
//    Print out : Title and Current url Done
//    Close browser Done
//    Quit driver Done

    private WebDriver setUpWebDriverWithWDM(String browser){
        WebDriver driver = null;
        switch (browser){
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println(browser+" not supported!");
                break;
        }
        return driver;
    }

    private WebDriver setUpWebDriver(String browser){
        WebDriver driver = null;
        switch (browser){
            case "CHROME":
                System.setProperty("webdriver.chrome.driver",
                        "src" + File.separator +
                                "test" + File.separator +
                                "resources" + File.separator +
                                "drivers" + File.separator +
                                "chromedriver.exe");

                driver = new ChromeDriver();
                break;
            case "FIREFOX":
                System.setProperty("webdriver.gecko.driver",
                        "src" + File.separator +
                                "test" + File.separator +
                                "resources" + File.separator +
                                "drivers" + File.separator +
                                "geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println(browser+" not supported!");
                break;
        }
        return driver;
    }
    private WebDriver driver;

    @BeforeMethod
    private void setUpBrowser(){
        driver = setUpWebDriver("CHROME");
        driver.manage().window().maximize();
        driver.get("https://tdlschool.com/");
    }

    @AfterMethod
    private void tearDown(){
        driver.close();
        driver.quit();
    }

    @Test(testName = "TDL School navigation",
            description = "We check navigation on TDL School homepage")
    public void openTDLSchoolHomepage() {
        System.out.println("Title:" + driver.getTitle());
        System.out.println("Current URL:" + driver.getCurrentUrl());
    }

//    Use previously created Webdriver project
//    Open page: https://tdlschool.com/
//    Check if TDL School logo is Displayed
//    Click on Career Paths
//    Check if “Not sure where to start?” title is displayed
//    Enter “test” in footer input field email

    @Test(testName = "TDL School navigation test")
    public void navigationTest(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Check if TDL School logo is Displayed");
        WebElement tdlSchoolLogoImg = driver.findElement(By.className("navigation__logo"));
        boolean isDisplayed = tdlSchoolLogoImg.isDisplayed();
        Assert.assertTrue(isDisplayed, "TDL School Logo is not Displayed ");

        System.out.println("Click on Career Paths");
        driver.findElement(By.linkText("Career Paths")).click();

        System.out.println("Check if “Not sure where to start?” title is displayed");
        String actualTitleValue = driver.findElement(By.cssSelector("div>h1")).getText();
        Assert.assertEquals(actualTitleValue, "Not sure where to start?");

        System.out.println("Enter “test” in footer input field email");
        WebElement inputEmailField = driver.findElement(By.name("email"));
        System.out.println("Enter text test");
        inputEmailField.sendKeys("test");
    }
}
