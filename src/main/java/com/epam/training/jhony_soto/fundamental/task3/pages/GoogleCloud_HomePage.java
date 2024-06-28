package com.epam.training.jhony_soto.fundamental.task3.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GoogleCloud_HomePage {

    private final ChromeDriver driver;
    private final WebDriverWait wait;

    @FindBy (name = "q")
    private WebElement searchButton;

    public GoogleCloud_HomePage (ChromeDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public GoogleCloud_ResultsPage useSearchBar(String searchValue){
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.click();
        searchButton.sendKeys(searchValue);
        searchButton.submit();
        return new GoogleCloud_ResultsPage(driver);
    }
}
