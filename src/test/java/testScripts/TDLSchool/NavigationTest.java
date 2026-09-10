package testScripts.TDLSchool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
//    Close browser
//    Quit driver

    @Test(testName = "TDL School navigation",
            description = "We check navigation on TDL School homepage")
    public void openTDLSchoolHomepage() {
        System.setProperty("webdriver.chrome.driver",
                "src" + File.separator +
                        "test" + File.separator +
                        "resources" + File.separator +
                        "drivers" + File.separator +
                        "chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tdlschool.com/");
        System.out.println("Title:"+driver.getTitle());
        System.out.println("Current URL:"+driver.getCurrentUrl());
        driver.close();
        driver.quit();
    }
}
