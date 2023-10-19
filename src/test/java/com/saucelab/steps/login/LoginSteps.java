package com.saucelab.steps.login;

import com.saucelab.pages.MainPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import com.saucelab.pages.LogInPage;
import com.saucelab.steps.BaseStep;
import com.saucelab.test.TestContext;
import utils.CommonUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginSteps extends BaseStep {
    public LoginSteps(TestContext testContext) {
        super(testContext);
    }
    @Given("user wants to try to login to saucedemo")
    public void user_is_on_login_portal() throws IOException {
        System.out.println(CommonUtils.getConfigProperty("BASE_URL"));
        this.testContext.driver.get(CommonUtils.getConfigProperty("BASE_URL"));
        new LogInPage(this.testContext.driver,this.testContext);

    }
    @When("^he provides valid credentials (.*) as username and (.*) as password")
    public void user_login_with_valid_credentials_standard_user_and_secret_sauce(String username, String password) {
        LogInPage login = (LogInPage) testContext.lastPage;
        login.tryLogin(username, password, MainPage::new);
    }
    @When("^he provides invalid credentials (.*) as username and (.*) as password")
    public void user_login_with_invalid_credentials_standard_user_and_secret_sauce(String username, String password) {
        LogInPage login = (LogInPage) testContext.lastPage;
        login.tryLogin(username, password, LogInPage::new);
    }

    @Then("user should be successfully logged in")
    public void user_should_succesfully_login() {
        Assert.assertEquals(this.testContext.driver.getTitle(), "Swag Labs");
    }

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        this.testContext.driver = new ChromeDriver(options);
        this.testContext.driver.manage().window().maximize();
        this.testContext.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @After
    public void tearDown(){
        this.testContext.driver.quit();
    }

    @Then("user should not be logged in")
    public void userShouldNotBeLoggedIn() {
    }
}
