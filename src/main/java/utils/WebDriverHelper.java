package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class WebDriverHelper {

    public static WebDriver setUpWebDriverManually(String browser){
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

    public static WebDriver setUpDriverWithWDM(String browser) {
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
}
