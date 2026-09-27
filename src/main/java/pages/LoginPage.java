package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;

import java.util.List;

public class LoginPage {

    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameField;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//p[contains(@class,'oxd-alert-content-text')]")
    public WebElement invalidCredentialsMessage;

    @FindBy(xpath = "//span[text()='Required']")
    public List<WebElement> requiredMessages;

    @FindBy(xpath = "//input[@name='username']/ancestor::div[contains(@class,'oxd-input-group')]//span[text()='Required']")
    public WebElement usernameRequiredMessage;

    @FindBy(xpath = "//input[@name='password']/ancestor::div[contains(@class,'oxd-input-group')]//span[text()='Required']")
    public WebElement passwordRequiredMessage;

    public LoginPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
}