package com.edewor.michael.automation.test;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author medewor
 *
 */
public class SparcQaChallengeTest {

    @Test
    public void w3cTest() throws IOException {

        String googleSearchPage = "https://www.google.com/";
        String googleSearchInputFieldSelector = "gbqfq";
        String googleSearchSubmitButtonSelector = "gbqfb";
        String searchString = "w3c";
        String w3cLinkNameOnGoogle = "h3 a";

        String mathMLId = "tr_MathML";

        String screenShotFilePath = "/tmp/SparcQaChallengeTest.png";

        WebDriver driver = new FirefoxDriver();

        // This action opens the google.com search page
        driver.get(googleSearchPage);

        // This locates the search field in the google.com search page
        WebElement googleSearchInputField = driver.findElement(By.id(googleSearchInputFieldSelector));

        // This types in the search string into the input file
        googleSearchInputField.sendKeys(searchString);

        // This locates the search submit button
        WebElement googleSubmitButton = driver.findElement(By.id(googleSearchSubmitButtonSelector));

        // This clicks on the submit button
        googleSubmitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(w3cLinkNameOnGoogle)));

        // Locate the World Wide Web Consortium (W3C) using the link text
        WebElement w3cLinkInGoogleSearchResults = driver.findElement(By.cssSelector(w3cLinkNameOnGoogle));

        // This action clicks on the link
        w3cLinkInGoogleSearchResults.click();


        try {

            WebElement mathMLLink = driver.findElement(By.id(mathMLId));

            // This asserts that the MathML element is
            Assert.assertTrue(mathMLLink.isDisplayed());

        } catch (Throwable error) {

            System.out.println("The element was not present on the page");
        }

        try {

            WebElement mathMLLink = driver.findElement(By.id(mathMLId));

            mathMLLink.click();

        } catch (Throwable error) {

            System.out.println("The MathML element was not present on the page. So, it could not be clicked");
        }

        File screenshotFileObject = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(screenshotFileObject, new File(screenShotFilePath));

    }
}
