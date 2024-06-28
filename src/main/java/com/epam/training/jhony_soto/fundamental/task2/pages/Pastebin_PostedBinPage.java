package com.epam.training.jhony_soto.fundamental.task2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Pastebin_PostedBinPage {
    private final ChromeDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//div[@class='notice -success -post-view']")
    private WebElement successfulPostedBinMessage;

    @FindBy(xpath = "//a[@class='btn -small h_800' and contains(@href, '/archive')]")
    private WebElement syntaxHighlightMessage;

    @FindBy(className = "highlighted-code")
    private WebElement sourceCode;

    private final By codeList = By.xpath("//div[@class='de1']");

    public Pastebin_PostedBinPage(ChromeDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public String getSyntaxText(){
        wait.until(ExpectedConditions.visibilityOf(syntaxHighlightMessage));
        return syntaxHighlightMessage.getText();
    }

    public List<WebElement> getCodeValues(){
        wait.until(ExpectedConditions.visibilityOfElementLocated((codeList)));
        return driver.findElements((codeList));
    }

    public String selectCodeValueText(int paragraph) {
        wait.until(ExpectedConditions.visibilityOf(sourceCode));
        List<WebElement> values = getCodeValues();
        return values.get(paragraph - 1).getText();
    }
}
