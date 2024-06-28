package com.epam.training.jhony_soto.fundamental.task3.tests;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class GoogleCloud_Tests extends GoogleCloud_BaseTests{

    @Test
    public void userPricingCalculatorTest() throws InterruptedException {
        // Preconditions
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

        // Test
        var resultsPage = googleCloud_homePage.useSearchBar(searchValue);

        var pricingCalculatorPage = resultsPage.selectSearchResult(searchValue);
        pricingCalculatorPage.pressAddAnEstimate();

        var computeEnginePage = pricingCalculatorPage.openComputeEnginePage();
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

        assertTrue(computeEnginePage.getEstimatedCost());

        computeEnginePage.submitShareButton();
        var costEstimateSummaryPage = computeEnginePage
                .clickEstimateSummaryButton("Google Cloud Estimate Summary");

        //Assertions
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
