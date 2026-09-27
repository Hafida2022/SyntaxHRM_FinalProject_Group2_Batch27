package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;

public class DashboardPage {

    @FindBy(xpath = "//h6[contains(@class,'oxd-topbar-header-breadcrumb-module')]")
    public WebElement dashboardHeader;

    public DashboardPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
}