package com.epam.training.jhony_soto.fundamental.task2.tests;

import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

import static org.testng.AssertJUnit.*;

public class Pastebin_Tests extends Pastebin_BaseTests {

    @Test
    public void addNewPasteTest() throws IOException {
        // Preconditions
        String filePath = "src/main/java/com/epam/training/jhony_soto/fundamental/task2/src/code.txt";
        String text = new String(Files.readAllBytes(Paths.get(filePath)));
        String[] textLines = text.split("\\r?\\n");
        String secondParagraph = textLines[1];

        String nameTitle = "how to gain dominance among developers";
        String syntaxHighlight = "Bash";

        // Test
        goToHomePage();
        pastebin_homePage.addTextBoard(text);
        pastebin_homePage.selectSyntaxHighlightOption(syntaxHighlight);
        pastebin_homePage.selectPasteExpirationOption("10 Minutes");
        pastebin_homePage.addTextNameTitle(nameTitle);
        var postedBinPage = pastebin_homePage.submitNewPaste();

        String pageTitle = postedBinPage.getPageTitle();
        String syntaxText = postedBinPage.getSyntaxText();
        String codeTextExtract = postedBinPage.selectCodeValueText(2);

        // Assertions
        assertTrue(pageTitle.contains(nameTitle));
        assertEquals(syntaxHighlight, syntaxText);
        assertEquals(secondParagraph, codeTextExtract);
    }
}
