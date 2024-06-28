package com.epam.training.jhony_soto.fundamental.task3.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GoogleCloud_ComputeEnginePage {

    private final ChromeDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "c13")
    private WebElement numberOfInstancesBar;

    @FindBy(xpath = "//label[contains(normalize-space(), 'Regular')]")
    private WebElement provisioningModel_regularOption;

    @FindBy(xpath = "//div[@aria-describedby='c22']")
    private WebElement operatingSystemBar;

    @FindBy(xpath = "//div[@aria-describedby='c26']")
    private WebElement machineFamilyBar;

    @FindBy(xpath = "//div[@aria-describedby='c30']")
    private WebElement seriesBar;

    @FindBy(xpath = "//div[@aria-describedby='c34']")
    private WebElement machineTypeBar;

    @FindBy(xpath = "//button[@aria-label='Add GPUs']//span[@class='eBlXUe-hywKDc']")
    private WebElement addGPUButton;

    @FindBy(xpath = "//div[@aria-describedby='c42']")
    private WebElement localSSDBar;

    @FindBy(xpath = "//div[@aria-describedby='c46']")
    private WebElement dataCenterLocationBar;

    @FindBy(xpath = "//label[@for='1-year']/ancestor::div[contains(@class, 'e2WL2b')]")
    private WebElement committedUse_oneYearOption;

    @FindBy(xpath = "//div[contains(@class, 'wFCpDb')]")
    private WebElement estimatedCostMessage;

    @FindBy(css = "button[aria-label='Open Share Estimate dialog']")
    private WebElement shareButton;

    @FindBy(xpath = "//a[contains(normalize-space(), 'summary')]")
    private WebElement openEstimateSummaryButton;

    private WebElement GPUModelBar;

    private WebElement GPUNumberBar;

    public GoogleCloud_ComputeEnginePage (ChromeDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void addInstances(String instances){
        wait.until(ExpectedConditions.visibilityOf(numberOfInstancesBar)).clear();
        wait.until(ExpectedConditions.visibilityOf(numberOfInstancesBar)).sendKeys(instances);
    }

    public WebElement getOptionToSelect (String option){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//li[contains(., '" + option + "')]")));
    }

    public void selectOperatingSystemValue(String operatingSystem) {
        wait.until(ExpectedConditions.visibilityOf(operatingSystemBar)).click();
        WebElement operatingSystemSelected = getOptionToSelect(operatingSystem);
        operatingSystemSelected.click();
    }

    public void selectProvisioningModel_regular(){
        wait.until(ExpectedConditions.visibilityOf(provisioningModel_regularOption)).click();
    }

    public void selectMachineFamily(String machineFamily) {
        wait.until(ExpectedConditions.visibilityOf(machineFamilyBar)).click();
        WebElement machineFamilySelected = getOptionToSelect(machineFamily);
        machineFamilySelected.click();
    }

    public void selectSeries(String series) {
        wait.until(ExpectedConditions.visibilityOf(seriesBar)).click();
        WebElement seriesSelected = getOptionToSelect(series);
        seriesSelected.click();
    }

    public void selectMachineType(String machineType) {
        wait.until(ExpectedConditions.visibilityOf(machineTypeBar)).click();
        WebElement machineTypeSelected = getOptionToSelect(machineType);
        machineTypeSelected.click();
    }

    public void addGPU_activateButton() {
        wait.until(ExpectedConditions.visibilityOf(addGPUButton)).click();
    }

    public void addGPU_selectGPUModel(String GPUModel) {
                GPUModelBar = driver.findElements(By.xpath("//div[@role='combobox']")).get(7);
        wait.until(ExpectedConditions.elementToBeClickable(GPUModelBar)).click();

        WebElement modelSelected = getOptionToSelect(GPUModel);
        modelSelected.click();
    }

    public void addGPU_selectGPUNumber() {
        GPUNumberBar = driver.findElements(By.xpath("//div[@role='combobox']")).get(8);
        wait.until(ExpectedConditions.elementToBeClickable(GPUNumberBar)).click();

        WebElement numberSelected = driver.findElement(By.xpath("(//li[@data-value='1'])[1]"));
        numberSelected.click();
    }

    public void selectLocalSSD(String localSSD) {
        wait.until(ExpectedConditions.elementToBeClickable(localSSDBar)).click();
        WebElement SSDSelected = getOptionToSelect(localSSD);
        wait.until(ExpectedConditions.visibilityOf(SSDSelected)).click();
    }

    public void selectDataCenterLocation(String dataCenterLocation) {
        wait.until(ExpectedConditions.elementToBeClickable(dataCenterLocationBar)).click();
        WebElement location = getOptionToSelect(dataCenterLocation);
        wait.until(ExpectedConditions.visibilityOf(location)).click();
    }

    public void selectCommittedUse_oneYear(){
        wait.until(ExpectedConditions.elementToBeClickable(committedUse_oneYearOption)).click();
    }

    public Boolean getEstimatedCost() throws InterruptedException {
        Thread.sleep(500);
        return wait.until(ExpectedConditions.visibilityOf(estimatedCostMessage)).isDisplayed();
    }

    public void submitShareButton() {
        wait.until(ExpectedConditions.elementToBeClickable(shareButton));
        shareButton.click();
        shareButton.click();
    }

    public GoogleCloud_CostEstimateSummaryPage clickEstimateSummaryButton(String tabTitle) {
        try {
            wait.until(ExpectedConditions.visibilityOf(openEstimateSummaryButton)).click();
        } catch (StaleElementReferenceException e) {
            wait.until(ExpectedConditions.visibilityOf(openEstimateSummaryButton)).click();
        }

        var windows = driver.getWindowHandles();
        for (String window : windows){
            driver.switchTo().window(window);
            if (tabTitle.equals(driver.getTitle())){
                break;
            }
        }
        return new GoogleCloud_CostEstimateSummaryPage(driver);
    }

}
