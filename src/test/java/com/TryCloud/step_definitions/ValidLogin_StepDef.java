package com.TryCloud.step_definitions;

import com.TryCloud.pages.TryCloudLoginPage;
import com.TryCloud.utilities.ConfigurationReader;
import com.TryCloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ValidLogin_StepDef {

    TryCloudLoginPage tryCloudLoginPage = new TryCloudLoginPage();
    @Given("user on the login page")
    public void userOnTheLoginPage() {

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

    }
    @When("user enter valid username {string} and password {string}")
    public void userEnterValidUsernameAndPassword(String username, String password) {
        tryCloudLoginPage.inputUsername.sendKeys(username);
        tryCloudLoginPage.inputPassword.sendKeys(password);
    }
    @When("user click the login button")
    public void user_click_the_login_button() {
       tryCloudLoginPage.loginBtn.click();
    }
    @Then("verify the user should be at the dashboard page, expected page is {string}")
    public void verifyTheUserShouldBeAtTheDashboardPageExpectedPageIs(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("Title failed!",expectedTitle,actualTitle);
    }
}
