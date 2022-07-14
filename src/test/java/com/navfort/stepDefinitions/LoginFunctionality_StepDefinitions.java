package com.navfort.stepDefinitions;

import com.navfort.pages.DashboardPage;
import com.navfort.pages.ForgotPasswordPage;
import com.navfort.utilities.*;
import com.navfort.pages.LoginPage;
import com.navfort.pages.QuickLaunchpad;
import com.navfort.utilities.ConfigurationReader;
import com.navfort.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.Set;

public class LoginFunctionality_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    QuickLaunchpad quickLaunchpad = new QuickLaunchpad();
    DashboardPage dashboardPage = new DashboardPage();
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();


    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("LoginPage"));
    }

    @When("User enters valid {string} and {string}")
    public void user_enters_valid(String username, String password) {

        loginPage.inputUsername.sendKeys(username);

        loginPage.inputPassword.sendKeys(password);
    }

    @When("User clicks to login button")
    public void user_clicks_to_login_button() {
        loginPage.loginButton.click();
    }

    @Then("User should be able to land on the {string} page")
    public void user_should_be_able_to_land_on_the_quick_launchpad_page(String expectedPage) {
        String actualPage = quickLaunchpad.QuickLauncpadPage.getText();
        com.cydeo.utilities.BrowserUtils.waitForVisibility(quickLaunchpad.QuickLauncpadPage, 10);
        Assert.assertEquals(expectedPage, actualPage);
    }


    @When("User enters invalid {string} and {string}")
    public void user_enters_invalid_and(String username, String password) {
        loginPage.inputUsername.sendKeys(username);
        loginPage.inputPassword.sendKeys(password);
    }


    @Then("User should not be able to land on the Dashboard page")
    public void user_should_not_be_able_to_land_on_the_quick_launchpad_page() {
        String expectedTitle = "Login";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @When("When User enters valid {string} and {string}")
    public void when_user_enters_valid_and(String username, String password) {
        loginPage.inputUsername.sendKeys(username);
        loginPage.inputPassword.sendKeys(password);
    }

    @Then("User should be able to land on the Dashboard page")
    public void user_should_be_able_to_land_on_the_dashboard_page() {
        String expectedPage = "Dashboard";
        String actualPage = dashboardPage.dashboardPage.getText();

        Assert.assertEquals(expectedPage, actualPage);
    }

    @When("User tries to login without provide credentials")
    public void user_tries_to_login_without_provide_credentials() {

    }

    @When("User should see the {string} message")
    public void user_should_see_the_message(String expectedMessage) {

        String actualMessage = loginPage.fillOutWarning.getAttribute("validationMessage");

        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Then("User should be on the login page without be able to login")
    public void user_should_be_on_the_login_page_without_be_able_to_login() {
        String expectedTitle = "Login";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);
    }


    @Then("User should see {string} message")
    public void user_should_see_message(String string) {
        String expectedMessage = "Invalid user name or password.";
        String actualMessage = loginPage.invalidUsernameOrPasswordMessage.getText();

        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @When("User clicks the Forgot your password link")
    public void user_clicks_the_forgot_your_password_link() {
        loginPage.forgotYourPasswordLink.click();
    }

    @When("User enters the {string} credentials")
    public void user_enters_the_credentials(String username) {
        forgotPasswordPage.usernameOrEmailField.sendKeys(username);
    }

    @When("User clicks the Request button")
    public void user_clicks_the_button() {
        forgotPasswordPage.requestButton.click();
    }

    @Then("User should not see {string} message")
    public void user_should_not_see_message(String warningMessage) {
        String actualMessage = forgotPasswordPage.unableToSendTheEmailMessage.getText();

        Assert.assertFalse(actualMessage.equals(warningMessage));
        ;

    }

    @When("user clicks the Remember me on this computer checkbox")
    public void user_clicks_the_remember_me_on_this_computer_checkbox() {
        loginPage.RememberMeCheckBox.click();
    }

    @When("user click to login button")
    public void user_click_to_login_button() {
      loginPage.loginButton.click();
    }

    @When("user closes the tab and opens new tab")
    public void user_closes_the_tab_and_opens_new_tab() {
        Set<Cookie> cookie = Driver.getDriver().manage().getCookies();

        for (Cookie c : cookie ) {
            if (c.getExpiry()==null) {
                Driver.getDriver().manage().deleteCookie(c);
            }
        }

        Driver.getDriver().get(ConfigurationReader.getProperty("homePage"));

//        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open()");
//        ArrayList<String> tabs = new ArrayList<>(Driver.getDriver().getWindowHandles());
//        Driver.getDriver().close();
//        Driver.getDriver().switchTo().window(tabs.get(1));
//        Driver.getDriver().get(ConfigurationReader.getProperty("homePage"));
    }

    @Then("user should be able to login again without entering credentials")
    public void user_should_be_able_to_login_again_without_entering_credentials() {

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals("https://qa.navfort.com/")); }



}
