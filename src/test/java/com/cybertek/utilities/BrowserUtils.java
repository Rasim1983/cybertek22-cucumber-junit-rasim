package com.cybertek.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    public void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    public void assertTitle(String expectedTitle) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    public static List<String> getElementsText(List<WebElement> webElements) {
        List<String> elementsText = new ArrayList<>();
        for (WebElement webElement : webElements) {
            elementsText.add(webElement.getText());

        }
        return elementsText;
    }


    /*
     Method that will accept int
     Wait for given second duration
      */
    public static void sleep(int second) {

        second += 1000;

        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            System.out.println("Something happened");
        }

    }


}
