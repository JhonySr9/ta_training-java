package com.epam.training.jhony_soto.fundamental.task3.tests;
import com.epam.training.jhony_soto.fundamental.task3.pages.*;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

/**
 * This class contains test cases for Google Cloud Pricing Calculator.
 */

public class GoogleCloud_Tests extends GoogleCloud_BaseTests{

    /**
     * Testing of the Pricing Calculator functionality.
     * @throws InterruptedException error in case a value is not displayed after a wait.
     */
    @Test
    public void usePricingCalculatorTest() throws InterruptedException {
        ////// Data //////

        String searchValue = "Google Cloud Pricing Calculator";
        String instances = "4";
        String operatingSystem = "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)";
        String machineFamily = "General Purpose";
        String series = "N1";
        String machineType = "n1-standard-8";
        String addGPU_GPUModel = "NVIDIA V100";
        String addGPU_GPUNumber = "1";
        String SSD = "2x375 GB";
        String dataCenterLocation = "Netherlands (europe-west4)";

        ////// Test //////

        // Navigate to the home page
        goToURL(HOMEPAGE_URL);

        // Instantiate the home page and search for the pricing calculator
        var googleCloud_homePage = new GoogleCloud_HomePage(driver);
        googleCloud_homePage.useSearchBar(searchValue);

        var resultsPage =  new GoogleCloud_ResultsPage(driver);
        resultsPage.selectSearchResult(searchValue);

        // Select the search result and navigate to the pricing calculator page
        var pricingCalculatorPage =  new GoogleCloud_PricingCalculatorPage(driver);
        pricingCalculatorPage.pressAddAnEstimateButton();
        pricingCalculatorPage.openComputeEnginePage();

        // Fill in the form on the Compute Engine page
        var computeEnginePage = new GoogleCloud_ComputeEnginePage(driver);
        computeEnginePage.addGPU_activateButton();
        computeEnginePage.addInstances(instances);
        computeEnginePage.selectOperatingSystemValue(operatingSystem);
        computeEnginePage.selectProvisioningModel_regular();
        computeEnginePage.selectMachineFamily(machineFamily);
        computeEnginePage.selectSeries(series);
        computeEnginePage.selectMachineType(machineType);
        computeEnginePage.addGPU_selectGPUModel(addGPU_GPUModel);
        computeEnginePage.addGPU_selectGPUNumber();
        computeEnginePage.selectLocalSSD(SSD);
        computeEnginePage.selectDataCenterLocation(dataCenterLocation);
        computeEnginePage.selectCommittedUse_oneYear();

        // Verify the estimated cost
        assertTrue(computeEnginePage.getEstimatedCost());

        // Share the estimate and navigate to the summary page
        computeEnginePage.submitShareButton();
        computeEnginePage.clickEstimateSummaryButton("Google Cloud Estimate Summary");

        //////Assertions//////
        // Assertions to verify the values on the summary page
        var costEstimateSummaryPage = new GoogleCloud_CostEstimateSummaryPage(driver);
        assertTrue(costEstimateSummaryPage.numberOfInstancesCorresponds(instances));
        assertTrue(costEstimateSummaryPage.operatingSystemCorresponds(operatingSystem));
        assertTrue(costEstimateSummaryPage.provisioningModelCorresponds("Regular"));
        assertTrue(costEstimateSummaryPage.seriesCorresponds(series));
        assertTrue(costEstimateSummaryPage.machineTypeCorresponds(machineType));
        assertTrue(costEstimateSummaryPage.GPUModelCorresponds(addGPU_GPUModel));
        assertTrue(costEstimateSummaryPage.GPUNumberCorresponds(addGPU_GPUNumber));
        assertTrue(costEstimateSummaryPage.localSSDCorresponds(SSD));
        assertTrue(costEstimateSummaryPage.dataCenterLocationCorresponds(dataCenterLocation));
        assertTrue(costEstimateSummaryPage.committedUsageCorresponds("1 year"));
    }
}
