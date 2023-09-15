package steps.login;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import pages.LogInPage;
import pages.LogInPage_PF;
import steps.BaseStep;
import test.TestContext;

import java.util.concurrent.TimeUnit;

public class LoginSteps extends BaseStep {
    //LogInPage login;
    LogInPage_PF login;
    public LoginSteps(TestContext testContext) {
        super(testContext);
    }
    @Given("user wants to try to login to saucedemo")
    public void user_is_on_login_portal() {
        this.testContext.driver.get("https://www.saucedemo.com/v1/");
    }
    @When("^he provides credentials (.*) as username and (.*) as password")
    public void user_login_with_valid_credentials_standard_user_and_secret_sauce(String username, String password) {
        login = new LogInPage_PF(this.testContext.driver);
        login.loginValidUser(username, password);
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
