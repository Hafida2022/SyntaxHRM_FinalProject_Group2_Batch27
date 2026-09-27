package steps;

import io.cucumber.java.After;
import utils.DriverManager;

public class Hooks {

    @After
    public void closeBrowser() {
        DriverManager.closeDriver();
    }
}