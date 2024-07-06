package com.epam.training.jhony_soto.fundamental.task3.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * This class represents the Google Cloud Pricing Calculator page and provides methods to interact with it.
 */
public class GoogleCloud_PricingCalculatorPage {

    private final ChromeDriver driver;
    private final WebDriverWait wait;

    @FindBy (xpath = "//span[normalize-space(text())='Add to estimate']")
    private WebElement addAnEstimateButton;

    @FindBy (xpath = "//div[@data-idx='0']")
    private WebElement computeEngineOption;

    /**
     * Constructor for GoogleCloud_PricingCalculatorPage.
     * Initializes WebDriverWait and PageFactory elements.
     *
     * @param driver The ChromeDriver instance to interact with the web page.
     */
    public GoogleCloud_PricingCalculatorPage(ChromeDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks the "Add to estimate" button on the Pricing Calculator page.
     */
    public void pressAddAnEstimateButton(){
        wait.until(ExpectedConditions.visibilityOf(addAnEstimateButton));
        addAnEstimateButton.click();
    }

    /**
     * Navigates to the Compute Engine Page.
     */
    public void openComputeEnginePage(){
        wait.until(ExpectedConditions.visibilityOf(computeEngineOption));
        computeEngineOption.click();
    }
}
