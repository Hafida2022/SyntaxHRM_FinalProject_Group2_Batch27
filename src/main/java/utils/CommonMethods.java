package utils;

import org.openqa.selenium.WebElement;

public class CommonMethods {

    public static void click(WebElement element) {
        element.click();
    }

    public static void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }
}