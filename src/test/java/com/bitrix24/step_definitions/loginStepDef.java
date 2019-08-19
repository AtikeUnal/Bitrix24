package com.bitrix24.step_definitions;

import com.bitrix24.pages.LoginPage;
import com.bitrix24.utilities.BrowserUtils;
import com.bitrix24.utilities.ConfigurationReader;
import com.bitrix24.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class loginStepDef {

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        System.out.println("Opening the login page");
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("I login as a {string}")
    public void i_login_as_a(String string) {

            System.out.println("Logging in as a helpdesk employee");
            String username = ConfigurationReader.get("helpdesk_username");
            String password = ConfigurationReader.get("password");
            LoginPage loginPage = new LoginPage();
            loginPage.login(username, password);
    }

    @Then("I should be able to see the dashboard page")
    public void i_should_be_able_to_see_the_dashboard_page() {
        System.out.println("Verifying dashboard page");
        BrowserUtils.waitFor(2);
        Assert.assertTrue(Driver.get().getTitle().contains("Portal"));

    }

}