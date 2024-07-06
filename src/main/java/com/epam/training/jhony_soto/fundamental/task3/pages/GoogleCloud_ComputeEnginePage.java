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

/**
 * This class represents the Google Cloud Compute Engine page and provides methods to interact with it.
 */
public class GoogleCloud_ComputeEnginePage {

    private final ChromeDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//input[@id='c13']")
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

    @FindBy(xpath = "//button[@aria-label='Open Share Estimate dialog']")
    private WebElement shareButton;

    @FindBy(xpath = "//a[contains(normalize-space(), 'summary')]")
    private WebElement openEstimateSummaryButton;

    @FindBy(xpath = "//style[contains(text(),'.SyW2Hf{--gm3-dialog-refactored-supporting-text-co')]")
    private WebElement styleDialog;

    private WebElement GPUModelBar;

    private WebElement GPUNumberBar;

    /**
     * Constructor for GoogleCloud_ComputeEnginePage.
     * Initializes WebDriverWait and PageFactory elements.
     *
     * @param driver The ChromeDriver instance to interact with the web page.
     */
    public GoogleCloud_ComputeEnginePage (ChromeDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    /**
     * Adds the specified number of instances to the form.
     *
     * @param instances The number of instances to add.
     */
    public void addInstances(String instances){
        wait.until(ExpectedConditions.visibilityOf(numberOfInstancesBar)).clear();
        wait.until(ExpectedConditions.visibilityOf(numberOfInstancesBar)).sendKeys(instances);
    }

    /**
     * Gets the option element to select based on the provided option text.
     *
     * @param option The text of the option to select.
     * @return The WebElement representing the option.
     */
    public WebElement getOptionToSelect (String option){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//li[contains(., '" + option + "')]")));
    }

    /**
     * Selects the specified operating system value.
     *
     * @param operatingSystem The operating system value to select.
     */
    public void selectOperatingSystemValue(String operatingSystem) {
        wait.until(ExpectedConditions.elementToBeClickable(operatingSystemBar)).click();
        WebElement operatingSystemSelected = getOptionToSelect(operatingSystem);
        operatingSystemSelected.click();
    }

    /**
     * Selects the "regular" provisioning model.
     */
    public void selectProvisioningModel_regular(){
        wait.until(ExpectedConditions.elementToBeClickable(provisioningModel_regularOption)).click();
    }

    /**
     * Selects the specified machine family.
     *
     * @param machineFamily The machine family to select.
     */
    public void selectMachineFamily(String machineFamily) {
        wait.until(ExpectedConditions.elementToBeClickable(machineFamilyBar)).click();
        WebElement machineFamilySelected = getOptionToSelect(machineFamily);
        machineFamilySelected.click();
    }

    /**
     * Selects the specified series.
     *
     * @param series The series to select.
     */
    public void selectSeries(String series) {
        wait.until(ExpectedConditions.elementToBeClickable(seriesBar)).click();
        WebElement seriesSelected = getOptionToSelect(series);
        seriesSelected.click();
    }

    /**
     * Selects the specified machine type.
     *
     * @param machineType The machine type to select.
     */
    public void selectMachineType(String machineType) {
        wait.until(ExpectedConditions.elementToBeClickable(machineTypeBar)).click();
        WebElement machineTypeSelected = getOptionToSelect(machineType);
        machineTypeSelected.click();
    }

    /**
     * Activates the "add GPU" button.
     */
    public void addGPU_activateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addGPUButton)).click();
    }

    /**
     * Selects the specified GPU model.
     *
     * @param GPUModel The GPU model to select.
     */
    public void addGPU_selectGPUModel(String GPUModel) {
                GPUModelBar = driver.findElements(By.xpath("//div[@role='combobox']")).get(7);
        wait.until(ExpectedConditions.elementToBeClickable(GPUModelBar)).click();

        WebElement modelSelected = getOptionToSelect(GPUModel);
        modelSelected.click();
    }

    /**
     * Selects the GPU number.
     */
    public void addGPU_selectGPUNumber() {
        GPUNumberBar = driver.findElements(By.xpath("//div[@role='combobox']")).get(8);
        wait.until(ExpectedConditions.elementToBeClickable(GPUNumberBar)).click();

        WebElement numberSelected = driver.findElement(By.xpath("(//li[@data-value='1'])[1]"));
        numberSelected.click();
    }

    /**
     * Selects the specified local SSD option.
     *
     * @param localSSD The local SSD option to select.
     */
    public void selectLocalSSD(String localSSD) {
        wait.until(ExpectedConditions.elementToBeClickable(localSSDBar)).click();
        WebElement SSDSelected = getOptionToSelect(localSSD);
        wait.until(ExpectedConditions.visibilityOf(SSDSelected)).click();
    }

    /**
     * Selects the specified data center location.
     *
     * @param dataCenterLocation The data center location to select.
     */
    public void selectDataCenterLocation(String dataCenterLocation) {
        wait.until(ExpectedConditions.elementToBeClickable(dataCenterLocationBar)).click();
        WebElement location = getOptionToSelect(dataCenterLocation);
        wait.until(ExpectedConditions.visibilityOf(location)).click();
    }

    /**
     * Selects the "one-year" committed use option.
     */
    public void selectCommittedUse_oneYear(){
        wait.until(ExpectedConditions.elementToBeClickable(committedUse_oneYearOption)).click();
    }

    /**
     * Gets the estimated cost.
     *
     * @return True if the estimated cost message is displayed, otherwise false.
     * @throws InterruptedException If the thread is interrupted while waiting.
     */
    public Boolean getEstimatedCost() throws InterruptedException {
        Thread.sleep(500);
        return wait.until(ExpectedConditions.visibilityOf(estimatedCostMessage)).isDisplayed();
    }

    /**
     * Clicks the share button to share the estimate.
     */
    public void submitShareButton() {
        wait.until(ExpectedConditions.elementToBeClickable(shareButton));
        shareButton.click();
        shareButton.click();
    }

    /**
     * Navigates to the Estimate Summary Page.
     *
     * @param tabTitle The title of the tab to switch to.
     */
    public void clickEstimateSummaryButton(String tabTitle) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(openEstimateSummaryButton)).click();
        } catch (StaleElementReferenceException e) {
            wait.until(ExpectedConditions.elementToBeClickable(openEstimateSummaryButton)).click();
        }

        var windows = driver.getWindowHandles();
        for (String window : windows){
            driver.switchTo().window(window);
            if (tabTitle.equals(driver.getTitle())){
                break;
            }
        }
    }

}
