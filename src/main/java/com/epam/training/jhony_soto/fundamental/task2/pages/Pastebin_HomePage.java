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

public class Pastebin_HomePage {
    private final ChromeDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "postform-text")
    private WebElement board;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement pasteExpirationBox;

    @FindBy(id = "postform-name")
    private WebElement nameTitleBox;

    @FindBy(xpath = "//button[@class='btn -big']")
    private WebElement newPasteButton;

    @FindBy(id = "select2-postform-format-container")
    private WebElement syntaxHighlightBox;

    private final By options = By.xpath("//li[@role='option']");

    public Pastebin_HomePage(ChromeDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);

    }

    public void addTextBoard(String text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(board));
        board.sendKeys(text);
    }

    public void selectSyntaxHighlightOption(String option){
        syntaxHighlightBox.click();
        List<WebElement> options = getOptions();
        for (WebElement value : options){
            if (value.getText().equals(option)){
                value.click();
                break;
            }
        }
    }

    public void selectPasteExpirationOption(String option){
        pasteExpirationBox.click();
        List<WebElement> options = getOptions();
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

    public List<WebElement> getOptions(){
        wait.until(ExpectedConditions.visibilityOfElementLocated((options)));
        return driver.findElements((options));
    }

    public Pastebin_PostedBinPage submitNewPaste(){
        newPasteButton.submit();
        return new Pastebin_PostedBinPage(driver);
    }
}
