package com.epam.training.jhony_soto.fundamental.task1.tests;
import com.epam.training.jhony_soto.fundamental.task1.pages.Pastebin_HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class Pastebin_BaseTests {

    protected ChromeDriver driver;
    protected WebDriverWait wait;
    protected Pastebin_HomePage pastebin_homePage;
    protected static final String HOMEPAGE_URL = "https://pastebin.com/";

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    @AfterClass
    public void turnOff(){
        if (driver != null){
            driver.quit();
        }
    }

    public void goToHomePage(){
        driver.get(HOMEPAGE_URL);
        pastebin_homePage = new Pastebin_HomePage(driver);
    }
}
