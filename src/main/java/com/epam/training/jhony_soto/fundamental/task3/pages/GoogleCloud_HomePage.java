package com.epam.training.jhony_soto.fundamental.task3.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * This class represents the home page of Google Cloud and provides methods to interact with it.
 */

public class GoogleCloud_HomePage {

    private final WebDriverWait wait;

    @FindBy (xpath = "//input[@name='q']")
    private WebElement searchButton;

    /**
     * Constructor for GoogleCloud_HomePage.
     * Initializes WebDriverWait and PageFactory elements.
     *
     * @param driver The ChromeDriver instance to interact with the web page.
     */
    public GoogleCloud_HomePage (ChromeDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /**
     * Uses the search bar to look for the searchValue and move into it.
     * @param searchValue is the string used to search.
     */
    public void useSearchBar(String searchValue){
        // Wait until the search button is visible, then click, enter the search value, and submit.
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.click();
        searchButton.sendKeys(searchValue);
        searchButton.submit();
    }
}
