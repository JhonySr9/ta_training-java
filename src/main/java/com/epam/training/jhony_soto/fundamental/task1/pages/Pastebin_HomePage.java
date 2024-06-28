package com.epam.training.jhony_soto.fundamental.task1.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Pastebin_HomePage {
    private final ChromeDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "postform-text")
    private WebElement board;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement pasteExpirationBox;

    @FindBy(id = "postform-name")
    private WebElement nameTitleBox;

    @FindBy(xpath = "//button[@type='submit' and @class='btn -big']")
    private WebElement newPasteButton;

    public Pastebin_HomePage(ChromeDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void addTextBoard(String text){
        wait.until(ExpectedConditions.visibilityOf(board));
        board.sendKeys(text);
    }

    public List<WebElement> getPasteExpirationOptions(){
        pasteExpirationBox.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("select2-results__option")));
        return driver.findElements(By.className("select2-results__option"));
    }

    public void selectPasteExpirationOption(String option){
        List<WebElement> options = getPasteExpirationOptions();
        for (WebElement value : options){
            if (value.getText().equals(option)){
                value.click();
                break;
            }
        }
    }

    public void addTextNameTitle(String name){
        nameTitleBox.sendKeys(name);
    }

    public Pastebin_PostedBinPage submitNewPaste(){
        newPasteButton.submit();
        return new Pastebin_PostedBinPage(driver);
    }
}
