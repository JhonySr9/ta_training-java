package com.epam.training.jhony_soto.fundamental.task3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GoogleCloud_CostEstimateSummaryPage {

    private final ChromeDriver driver;
    private final WebDriverWait wait;


    public GoogleCloud_CostEstimateSummaryPage(ChromeDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public String getSummaryFieldValue (String fieldName) {
        WebElement summaryField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//span[normalize-space(text())='" + fieldName + "']/following-sibling::span[@class='Kfvdz']")));
        return summaryField.getText();
    }

    public Boolean numberOfInstancesCorresponds(String instances){
        return getSummaryFieldValue("Number of Instances").contains(instances);
    }

    public Boolean operatingSystemCorresponds(String operatingSystem){
        return getSummaryFieldValue("Operating System / Software").contains(operatingSystem);
    }

    public Boolean provisioningModelCorresponds(String provisioningModel){
        return getSummaryFieldValue("Provisioning Model").contains(provisioningModel);
    }

    public Boolean seriesCorresponds(String series){
        return getSummaryFieldValue("Machine type").contains(series.toLowerCase());
    }

    public Boolean machineTypeCorresponds(String machineType){
        return getSummaryFieldValue("Machine type").contains(machineType);
    }

    public Boolean GPUModelCorresponds(String GPUModel){
        return getSummaryFieldValue("GPU Model").contains(GPUModel);
    }

    public Boolean GPUNumberCorresponds(String GPUNumber){
        return getSummaryFieldValue("Number of GPUs").contains(GPUNumber);
    }

    public Boolean localSSDCorresponds(String localSSD){
        return getSummaryFieldValue("Local SSD").contains(localSSD);
    }

    public Boolean dataCenterLocationCorresponds(String dataCenterLocation){
        return getSummaryFieldValue("Region").contains(dataCenterLocation);
    }

    public Boolean committedUsageCorresponds(String committedUsage){
        return getSummaryFieldValue("Committed use discount options").contains(committedUsage);
    }

}
