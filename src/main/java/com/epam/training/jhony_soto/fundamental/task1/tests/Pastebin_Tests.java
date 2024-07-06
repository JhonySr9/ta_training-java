package com.epam.training.jhony_soto.fundamental.task1.tests;
import com.epam.training.jhony_soto.fundamental.task1.pages.Pastebin_PostedBinPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class Pastebin_Tests extends Pastebin_BaseTests{

    @Test
    public void addNewPasteTest(){
        goToHomePage();
        pastebin_homePage.addTextBoard("Hello from WebDriver");
        pastebin_homePage.selectPasteExpirationOption("10 Minutes");
        pastebin_homePage.addTextNameTitle("helloweb");

        var postedBinPage = new Pastebin_PostedBinPage(driver);
        pastebin_homePage.submitNewPaste();

        assertTrue(postedBinPage.validateSuccessMessage());
    }
}
