package StepsForSauceDemo;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import pages.LogInPage;

import java.util.concurrent.TimeUnit;

public class LogInSteps {
    WebDriver driver = null;
    LogInPage login;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Given("user is on saucedemo login page")
    public void user_is_on_saucedemo_login_page() {
        driver.get("https://www.saucedemo.com/v1/");
    }

    @When("^user login with valid (.*) and (.*) for saucedemo$")
    public void user_login_with_valid_standard_user_and_secret_sauce_for_saucedemo(String username, String password) {
        login = new LogInPage(driver);
        login.loginValidUser(username, password);
    }

    @Then("user should succesfully redirected to saucedemo homepage")
    public void user_should_succesfully_redirected_to_saucedemo_homepage() {
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
