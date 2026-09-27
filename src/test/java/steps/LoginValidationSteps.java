package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utils.CommonMethods;
import utils.DriverManager;

public class LoginValidationSteps {

    LoginPage loginPage = new LoginPage();

    @When("the user enters an invalid password")
    public void userEntersInvalidPassword() {

        CommonMethods.sendText(
                loginPage.passwordField,
                "WrongPassword123!"
        );
    }

    @Then("the user should see the invalid credentials message")
    public void userShouldSeeInvalidCredentialsMessage() {

        Assert.assertEquals(
                "Invalid credentials",
                CommonMethods.getText(
                        loginPage.invalidCredentialsMessage
                )
        );
    }

    @Then("the username required message should be displayed")
    public void usernameRequiredMessageShouldBeDisplayed() {

        Assert.assertEquals(
                "Required",
                CommonMethods.getText(
                        loginPage.usernameRequiredMessage
                )
        );
    }

    @Then("the password required message should be displayed")
    public void passwordRequiredMessageShouldBeDisplayed() {

        Assert.assertEquals(
                "Required",
                CommonMethods.getText(
                        loginPage.passwordRequiredMessage
                )
        );
    }

    @Then("required messages should be displayed for username and password")
    public void requiredMessagesShouldBeDisplayedForUsernameAndPassword() {

        Assert.assertEquals(
                "Required",
                CommonMethods.getText(
                        loginPage.usernameRequiredMessage
                )
        );

        Assert.assertEquals(
                "Required",
                CommonMethods.getText(
                        loginPage.passwordRequiredMessage
                )
        );
    }

    @Then("the user should remain on the login page")
    public void userShouldRemainOnLoginPage() {

        Assert.assertTrue(
                DriverManager.getDriver()
                        .getCurrentUrl()
                        .contains("auth/login")
        );
    }
}