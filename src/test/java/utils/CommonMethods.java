package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonMethods {

    private static final int TIMEOUT = 10;

    private static WebDriver driver;

    public static void sendText(WebElement element, String text) {

        WebDriverWait wait =
                new WebDriverWait(
                        getDriver(),
                        Duration.ofSeconds(TIMEOUT)
                );

        wait.until(ExpectedConditions.visibilityOf(element));

        element.clear();
        element.sendKeys(text);
    }

    public static void click(WebElement element) {

        WebDriverWait wait =
                new WebDriverWait(
                        getDriver(),
                        Duration.ofSeconds(TIMEOUT)
                );

        wait.until(ExpectedConditions.elementToBeClickable(element));

        element.click();
    }

    public static String getText(WebElement element) {

        WebDriverWait wait =
                new WebDriverWait(
                        getDriver(),
                        Duration.ofSeconds(TIMEOUT)
                );

        wait.until(ExpectedConditions.visibilityOf(element));

        return element.getText();
    }

    public static synchronized WebDriver getDriver() {

        if (driver == null) {
            String browser = ConfigReader.getProperty("browser");
            if (browser == null) {
                browser = "chrome";
            }

            switch (browser.trim().toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless=new");
                    options.addArguments("--window-size=1920,1080");
                    driver = new ChromeDriver(options);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    // fallback to chrome
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }
        }

        return driver;
    }

    public static void closeDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}