package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonMethods {

    private static final int TIMEOUT = 10;

    public static void sendText(WebElement element, String text) {

        WebDriverWait wait =
                new WebDriverWait(
                        DriverManager.getDriver(),
                        Duration.ofSeconds(TIMEOUT)
                );

        wait.until(ExpectedConditions.visibilityOf(element));

        element.clear();
        element.sendKeys(text);
    }

    public static void click(WebElement element) {

        WebDriverWait wait =
                new WebDriverWait(
                        DriverManager.getDriver(),
                        Duration.ofSeconds(TIMEOUT)
                );

        wait.until(ExpectedConditions.elementToBeClickable(element));

        element.click();
    }

    public static String getText(WebElement element) {

        WebDriverWait wait =
                new WebDriverWait(
                        DriverManager.getDriver(),
                        Duration.ofSeconds(TIMEOUT)
                );

        wait.until(ExpectedConditions.visibilityOf(element));

        return element.getText();
    }
}