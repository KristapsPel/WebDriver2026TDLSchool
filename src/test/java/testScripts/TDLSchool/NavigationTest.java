package testScripts.TDLSchool;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

    @Test(testName = "TDL School navigation",
            description = "We check navigation on TDL School homepage")
    public void openTDLSchoolHomepage() {
        WebDriver driver = setUpWebDriver("CHROME");
        driver.manage().window().maximize();
        driver.get("https://tdlschool.com/");
        System.out.println("Title:" + driver.getTitle());
        System.out.println("Current URL:" + driver.getCurrentUrl());
        driver.close();
        driver.quit();
    }

    @Test(testName = "TDL School navigation FireFox",
            description = "We check navigation on TDL School homepage with Firefox")
    public void openTDLSchoolHomepageFirefox() {
        WebDriver driver = setUpWebDriver("FIREFOX");
        driver.manage().window().maximize();
        driver.get("https://tdlschool.com/");
        System.out.println("Title:" + driver.getTitle());
        System.out.println("Current URL:" + driver.getCurrentUrl());
        driver.close();
        //driver.quit();
    }

    @Test(testName = "TDL School navigation FireFox WDM",
            description = "We check navigation on TDL School homepage with Firefox WDM")
    public void openTDLSchoolHomepageFirefoxWDM() {
        WebDriver driver=setUpWebDriverWithWDM("FIREFOX");
        driver.manage().window().maximize();
        driver.get("https://tdlschool.com/");
        System.out.println("Title:" + driver.getTitle());
        System.out.println("Current URL:" + driver.getCurrentUrl());
        driver.close();
        //driver.quit();
    }


    @Test(testName = "TDL School navigation with WDM",
            description = "We check navigation on TDL School homepage with WDM")
    public void openTDLSchoolHomepageWithWDM() {
        WebDriver driver=setUpWebDriverWithWDM("CHROME");
        driver.manage().window().maximize();
        driver.get("https://tdlschool.com/");
        System.out.println("Title:" + driver.getTitle());
        System.out.println("Current URL:" + driver.getCurrentUrl());
        driver.close();
        driver.quit();
    }
}
