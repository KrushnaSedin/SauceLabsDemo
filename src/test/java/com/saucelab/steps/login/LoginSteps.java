package com.saucelab.steps.login;

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
    //LogInPage login;
    LogInPage login;
    public LoginSteps(TestContext testContext) {
        super(testContext);
    }
    @Given("user wants to try to login to saucedemo")
    public void user_is_on_login_portal() throws IOException {
        System.out.println(CommonUtils.getConfigProperty("BASE_URL"));
        this.testContext.driver.get(CommonUtils.getConfigProperty("BASE_URL"));

    }
    @When("^he provides credentials (.*) as username and (.*) as password")
    public void user_login_with_valid_credentials_standard_user_and_secret_sauce(String username, String password) {
        login = new LogInPage(this.testContext.driver);
        login.loginAsValidUser(username, password);
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

}
