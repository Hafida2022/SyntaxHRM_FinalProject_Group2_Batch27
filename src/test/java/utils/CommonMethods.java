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

            if (browser == null || browser.trim().isEmpty()) {
                browser = "chrome";
            }

            browser = browser.trim().toLowerCase();

            boolean isJenkins = System.getenv("JENKINS_URL") != null;

            switch (browser) {

                case "chrome":
                case "chrome-headless":

                    if (isJenkins) {
                        // Jenkins uses Chromium version 147
                        WebDriverManager.chromedriver()
                                .browserVersion("147")
                                .setup();
                    } else {
                        // Automatically manage local ChromeDriver
                        WebDriverManager.chromedriver().setup();
                    }

                    ChromeOptions options = new ChromeOptions();

                    if (isJenkins || browser.equals("chrome-headless")) {

                        options.addArguments("--headless=new");
                        options.addArguments("--window-size=1920,1080");
                        options.addArguments("--no-sandbox");
                        options.addArguments("--disable-dev-shm-usage");
                    }

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