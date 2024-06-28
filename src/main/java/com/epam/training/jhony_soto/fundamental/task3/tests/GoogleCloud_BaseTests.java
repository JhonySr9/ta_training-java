package com.epam.training.jhony_soto.fundamental.task3.tests;
import com.epam.training.jhony_soto.fundamental.task3.pages.GoogleCloud_HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class GoogleCloud_BaseTests {

    private ChromeDriver driver;
    protected GoogleCloud_HomePage googleCloud_homePage;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        goHome();
    }


    @BeforeMethod
    public void goHome() {
        driver.get("https://cloud.google.com/");
        googleCloud_homePage = new GoogleCloud_HomePage(driver);
    }

    @AfterClass
    public void turnOff(){
        if (driver != null){
            driver.quit();
        }
    }
}
