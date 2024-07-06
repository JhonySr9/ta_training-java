package com.epam.training.jhony_soto.fundamental.task3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * This class represents the Google Cloud Cost Estimate Summary page and provides methods to verify various elements on the page.
 */
public class GoogleCloud_CostEstimateSummaryPage {

    private final ChromeDriver driver;
    private final WebDriverWait wait;

    /**
     * Constructor for GoogleCloud_CostEstimateSummaryPage.
     * Initializes WebDriverWait and PageFactory elements.
     *
     * @param driver The ChromeDriver instance to interact with the web page.
     */
    public GoogleCloud_CostEstimateSummaryPage(ChromeDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    /**
     * Gets the text value of a summary field based on the provided field name.
     *
     * @param fieldName The name of the field to retrieve the value for.
     * @return The text value of the specified field.
     */
    public String getSummaryFieldValue (String fieldName) {
        WebElement summaryField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//span[normalize-space(text())='" + fieldName + "']/following-sibling::span[@class='Kfvdz']")));
        return summaryField.getText();
    }

    /**
     * Verifies if the number of instances corresponds to the expected value.
     *
     * @param instances The expected number of instances.
     * @return True if the number of instances corresponds to the expected value, otherwise false.
     */
    public boolean numberOfInstancesCorresponds(String instances){
        return getSummaryFieldValue("Number of Instances").contains(instances);
    }

    /**
     * Verifies if the operating system corresponds to the expected value.
     *
     * @param operatingSystem The expected operating system.
     * @return True if the operating system corresponds to the expected value, otherwise false.
     */
    public boolean operatingSystemCorresponds(String operatingSystem){
        return getSummaryFieldValue("Operating System / Software").contains(operatingSystem);
    }

    /**
     * Verifies if the provisioning model corresponds to the expected value.
     *
     * @param provisioningModel The expected provisioning model.
     * @return True if the provisioning model corresponds to the expected value, otherwise false.
     */
    public boolean provisioningModelCorresponds(String provisioningModel){
        return getSummaryFieldValue("Provisioning Model").contains(provisioningModel);
    }

    /**
     * Verifies if the series corresponds to the expected value.
     *
     * @param series The expected series.
     * @return True if the series corresponds to the expected value, otherwise false.
     */
    public boolean seriesCorresponds(String series){
        return getSummaryFieldValue("Machine type").contains(series.toLowerCase());
    }

    /**
     * Verifies if the machine type corresponds to the expected value.
     *
     * @param machineType The expected machine type.
     * @return True if the machine type corresponds to the expected value, otherwise false.
     */
    public boolean machineTypeCorresponds(String machineType){
        return getSummaryFieldValue("Machine type").contains(machineType);
    }

    /**
     * Verifies if the GPU model corresponds to the expected value.
     *
     * @param GPUModel The expected GPU model.
     * @return True if the GPU model corresponds to the expected value, otherwise false.
     */
    public boolean GPUModelCorresponds(String GPUModel){
        return getSummaryFieldValue("GPU Model").contains(GPUModel);
    }

    /**
     * Verifies if the number of GPUs corresponds to the expected value.
     *
     * @param GPUNumber The expected number of GPUs.
     * @return True if the number of GPUs corresponds to the expected value, otherwise false.
     */
    public boolean GPUNumberCorresponds(String GPUNumber){
        return getSummaryFieldValue("Number of GPUs").contains(GPUNumber);
    }

    /**
     * Verifies if the local SSD corresponds to the expected value.
     *
     * @param localSSD The expected local SSD.
     * @return True if the local SSD corresponds to the expected value, otherwise false.
     */
    public boolean localSSDCorresponds(String localSSD){
        return getSummaryFieldValue("Local SSD").contains(localSSD);
    }

    /**
     * Verifies if the data center location corresponds to the expected value.
     *
     * @param dataCenterLocation The expected data center location.
     * @return True if the data center location corresponds to the expected value, otherwise false.
     */
    public boolean dataCenterLocationCorresponds(String dataCenterLocation){
        return getSummaryFieldValue("Region").contains(dataCenterLocation);
    }

    /**
     * Verifies if the committed usage corresponds to the expected value.
     *
     * @param committedUsage The expected committed usage.
     * @return True if the committed usage corresponds to the expected value, otherwise false.
     */
    public boolean committedUsageCorresponds(String committedUsage){
        return getSummaryFieldValue("Committed use discount options").contains(committedUsage);
    }

}
