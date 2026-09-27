package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverManager;

import java.time.Duration;

public class LoginSteps {

    LoginPage loginPage;

    @Given("the user is on the SyntaxHRM login page")
    public void userIsOnLoginPage() {

        DriverManager.getDriver().get(
                ConfigReader.getProperty("url")
        );

        DriverManager.getDriver().manage().window().maximize();

        loginPage = new LoginPage();
    }

    @When("the user enters a valid username")
    public void userEntersUsername() {

        WebDriverWait wait =
                new WebDriverWait(
                        DriverManager.getDriver(),
                        Duration.ofSeconds(10)
                );

        wait.until(
                ExpectedConditions.visibilityOf(loginPage.usernameField)
        );

        loginPage.usernameField.sendKeys(
                ConfigReader.getProperty("username")
        );
    }

    @When("the user enters a valid password")
    public void userEntersPassword() {

        loginPage.passwordField.sendKeys(
                ConfigReader.getProperty("password")
        );
    }

    @When("the user clicks on the login button")
    public void userClicksLogin() {

        loginPage.loginButton.click();
    }

    @Then("the user should successfully navigate to the dashboard")
    public void verifyDashboard() {

        DashboardPage dashboardPage = new DashboardPage();

        WebDriverWait wait =
                new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.visibilityOf(dashboardPage.dashboardHeader)
        );

        Assert.assertEquals(
                "Dashboard",
                dashboardPage.dashboardHeader.getText()
        );
    }
}