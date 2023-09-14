package StepsForSauceDemo;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import pages.LogInPage;

import java.util.concurrent.TimeUnit;

public class LogInSteps {
    WebDriver driver = null;
    LogInPage login;

//    @Before
//    public void setUp(){
////        WebDriverManager.chromedriver().setup();
////        ChromeOptions options = new ChromeOptions();
////        options.addArguments("--remote-allow-origins=*");
////        driver = new ChromeDriver(options);
////        driver.manage().window().maximize();
////        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    }

    @Given("user is on login portal")
    public void user_is_on_login_portal() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/v1/");
    }

    @When("^user login with valid credentials (.*) and (.*)$")
    public void user_login_with_valid_credentials_standard_user_and_secret_sauce(String username, String password) {
        login = new LogInPage(driver);
        login.loginValidUser(username, password);
    }

    @Then("user should succesfully login")
    public void user_should_succesfully_login() {
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
