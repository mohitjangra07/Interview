package test.app.manage;


import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import test.app.utils.JSONData;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

@Log4j2
public class BaseTestSteps {

    public static WebDriver driver;

    /**
     * This method will check if the test is UI or API and setup browser (if UI)
     */
    public static void setUpMethod() {
        if (JSONData.baseConfig().getTestType().equalsIgnoreCase("ui")) {
            log.info("Starting UI Tests");
            setUpBrowser();
        } else {
            log.info("Running API Tests");
        }
    }

    public static void setUpBrowser() {
        switch (JSONData.baseConfig().getBrowserName().toLowerCase(Locale.ENGLISH)) {
            case "chrome":
                log.info("Starting Chrome browser");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                log.info("Starting Firefox browser");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                log.info("Starting Internet Explorer browser");
                WebDriverManager.iedriver();
                driver = new InternetExplorerDriver();
                break;
            default:
                throw new UnsupportedOperationException(JSONData.baseConfig().getBrowserName() + " is not available. Please select available browser");
        }
        launchURl();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    /**
     * This method will launch the test url on the browser
     */
    public static void launchURl() {
        log.info("launching the test url" + JSONData.baseConfig().getAppTestUrl());
        driver.get(JSONData.baseConfig().getAppTestUrl());
    }

    /**
     * Method is to return the existing driver instance
     *
     * @return WebDriver driver
     */
    public static WebDriver getDriverInstance() {
        log.info("Returning the existing driver instance");
        return driver;
    }

}
