package com.epam.training.jhony_soto.fundamental.task3.tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.time.Duration;

/**
 * Base test class for Google Cloud tests.
 * This class sets up the WebDriver and WebDriverWait for the tests.
 */

public class GoogleCloud_BaseTests {

    protected ChromeDriver driver;
    protected WebDriverWait wait;
    protected final String HOMEPAGE_URL = "https://cloud.google.com/";

    /**
     * Configures WebDriver before starting tests.
     * Sets up the ChromeDriver and initializes WebDriverWait.
     */
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Closes WebDriver after finishing tests.
     * Ensures the driver quits if it is not null.
     */
    @AfterClass
    public void turnOff(){
        if (driver != null){
            driver.quit();
        }
    }

    /**
     * Navigates to the specified URL.
     *
     * @param URL The URL to navigate to.
     */
    public void goToURL(String URL){
        driver.get(URL);
    }
}
