package com.epam.training.jhony_soto.fundamental.task3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * This class represents the results page of Google Cloud and provides methods to interact with it.
 */
public class GoogleCloud_ResultsPage {

    private final ChromeDriver driver;
    private final WebDriverWait wait;

    /**
     * Constructor for GoogleCloud_ResultsPage.
     * Initializes WebDriverWait and PageFactory elements.
     *
     * @param driver The ChromeDriver instance to interact with the web page.
     */
    public GoogleCloud_ResultsPage(ChromeDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /**
     * Selects the search result based on the specified search value.
     *
     * @param searchValue The string value to search and click.
     */
    public void selectSearchResult(String searchValue) {
        // Wait until the search result is visible, then click it.
        WebElement searchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='" + searchValue + "']")));
        searchResult.click();
    }
}
