package com.epam.training.jhony_soto.fundamental.task1.tests;

import com.epam.training.jhony_soto.fundamental.task1.pages.Pastebin_HomePage;
import com.epam.training.jhony_soto.fundamental.task1.pages.Pastebin_PostedBinPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class Pastebin_Tests extends Pastebin_BaseTests{

    @Test
    public void AddNewPasteTest(){
        Pastebin_HomePage homePage = pastebin_homePage;
        homePage.addTextBoard("Hello from WebDriver");
        homePage.selectPasteExpirationOption("10 Minutes");
        homePage.addTextNameTitle("helloweb");
        Pastebin_PostedBinPage postedBinPage = homePage.submitNewPaste();

        String successMessage = postedBinPage.getSuccessPostedBinText();

        assertTrue(successMessage.contains("Your guest paste has been posted"));
    }
}
