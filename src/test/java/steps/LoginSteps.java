package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.DriverManager;

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

        CommonMethods.sendText(
                loginPage.usernameField,
                ConfigReader.getProperty("username")
        );
    }

    @When("the user enters a valid password")
    public void userEntersPassword() {

        CommonMethods.sendText(
                loginPage.passwordField,
                ConfigReader.getProperty("password")
        );
    }

    @When("the user clicks on the login button")
    public void userClicksLogin() {

        CommonMethods.click(loginPage.loginButton);
    }

    @Then("the user should successfully navigate to the dashboard")
    public void verifyDashboard() {

        DashboardPage dashboardPage = new DashboardPage();

        Assert.assertEquals(
                "Dashboard",
                CommonMethods.getText(dashboardPage.dashboardHeader)
        );
    }
}