package com.epam.training.jhony_soto.fundamental.task2.tests;

import com.epam.training.jhony_soto.fundamental.task2.pages.Pastebin_HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Pastebin_BaseTests {

    private ChromeDriver driver;
    protected Pastebin_HomePage pastebin_homePage;
    protected static final String HOMEPAGE_URL = "https://pastebin.com/";

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterClass
    public void turnOff(){
        if (driver != null){
            driver.quit();
        }
    }

    public void goToHomePage() {
        driver.get(HOMEPAGE_URL);
        pastebin_homePage = new Pastebin_HomePage(driver);
    }
}
