package com.epam.training.jhony_soto.fundamental.task2.tests;

import com.epam.training.jhony_soto.fundamental.task2.pages.Pastebin_HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Pastebin_BaseTests {

    private ChromeDriver driver;
    protected Pastebin_HomePage pastebin_homePage;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        goHome();
    }


    @BeforeMethod
    public void goHome() {
        driver.get("https://pastebin.com/");
        pastebin_homePage = new Pastebin_HomePage(driver);
    }

    @AfterClass
    public void turnOff(){
        if (driver != null){
            driver.quit();
        }
    }
}
