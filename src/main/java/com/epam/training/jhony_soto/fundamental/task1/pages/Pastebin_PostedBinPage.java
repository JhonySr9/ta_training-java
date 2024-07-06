package com.epam.training.jhony_soto.fundamental.task1.pages;

import com.epam.training.jhony_soto.fundamental.task1.tests.Pastebin_BaseTests;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Pastebin_PostedBinPage extends Pastebin_BaseTests {
    private final ChromeDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//div[@class='notice -success -post-view']")
    private WebElement successfulPostedBinMessage;

    public Pastebin_PostedBinPage(ChromeDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public Boolean validateSuccessMessage(){
        wait.until(ExpectedConditions.visibilityOf(successfulPostedBinMessage));
        String successfulPostedBinMessageText = successfulPostedBinMessage.getText();
        return successfulPostedBinMessageText.contains("Your guest paste has been posted");
    }

}
