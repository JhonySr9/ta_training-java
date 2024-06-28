package com.epam.training.jhony_soto.fundamental.task3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GoogleCloud_ResultsPage {

    private final ChromeDriver driver;
    private final WebDriverWait wait;

    public GoogleCloud_ResultsPage(ChromeDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public GoogleCloud_PricingCalculatorPage selectSearchResult(String searchValue) {
        WebElement searchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='" + searchValue + "']")));
        searchResult.click();
        return new GoogleCloud_PricingCalculatorPage(driver);
    }
}
