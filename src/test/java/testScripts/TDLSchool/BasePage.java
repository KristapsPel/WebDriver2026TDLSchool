package testScripts.TDLSchool;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HeaderPage;
import utils.WebDriverHelper;

public class BasePage {
    protected WebDriver driver;

    @BeforeMethod
    public void setUpBrowser(){
        driver = WebDriverHelper.setUpDriverWithWDM("CHROME");
        driver.manage().window().maximize();
        driver.get("https://tdlschool.com/");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.checkIfLogoIsDisplayed();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
