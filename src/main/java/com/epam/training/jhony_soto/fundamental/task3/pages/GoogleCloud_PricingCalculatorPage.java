package com.epam.training.jhony_soto.fundamental.task3.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GoogleCloud_PricingCalculatorPage {

    private final ChromeDriver driver;
    private final WebDriverWait wait;

    @FindBy (xpath = "//span[normalize-space(text())='Add to estimate']")
    private WebElement addAnEstimateButton;

    @FindBy (xpath = "//div[@data-idx='0']")
    private WebElement computeEngineOption;

    public GoogleCloud_PricingCalculatorPage(ChromeDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void pressAddAnEstimate(){
        wait.until(ExpectedConditions.visibilityOf(addAnEstimateButton));
        addAnEstimateButton.click();
    }

    public GoogleCloud_ComputeEnginePage openComputeEnginePage(){
        wait.until(ExpectedConditions.visibilityOf(computeEngineOption));
        computeEngineOption.click();
        return new GoogleCloud_ComputeEnginePage(driver);
    }
}
