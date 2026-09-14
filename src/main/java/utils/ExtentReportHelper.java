package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ExtentReportHelper {

    private static ExtentReports report;

    public static void addScreenshotToReport(Status status, String description,
                                             ExtentTest test, WebDriver driver) {
        // Capture the screenshot as a Base64 string and prepend with the data URI scheme for a PNG image
        String base64ScreenShot = "data:image/png;base64," + ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BASE64);

        // Log the screenshot to the report with the specified status (PASS, FAIL, etc.)
        test.log(status,description, MediaEntityBuilder.createScreenCaptureFromBase64String(base64ScreenShot).build());
    }

    public static void generateHTMLReportFile(){
        report.flush();
    }

    public static void createReportObject(){
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(
                System.getProperty("user.dir") + File.separator +
                        "report" + File.separator +
                        "TestReport.html");

        report = new ExtentReports();
        report.attachReporter(sparkReporter);

    }

    public static ExtentTest createTest(String name, String description){
        return report.createTest(name, description);
    }
}
