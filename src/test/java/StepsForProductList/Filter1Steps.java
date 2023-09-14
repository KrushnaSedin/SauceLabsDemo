package StepsForProductList;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.cucumber.java.it.Ma;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import pages.LogInPage;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class Filter1Steps {
    public WebDriver driver = null;
    LogInPage login;
    MainPage mainPage;
    boolean result;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Given("User is on login portal")
    public void user_is_on_login_portal() {
        driver.get("https://www.saucedemo.com/v1/");
    }

    @When("^User login with valid credentials (.*) and (.*)")
    public void user_login_with_valid_credentials_standard_user_and_secret_sauce(String username, String password) {
        login = new LogInPage(driver);
        login.loginValidUser(username, password);
    }

    @And("User filtered out the products from low to high prices")
    public void user_filtered_out_the_products_from_low_to_high_prices() throws InterruptedException {
        mainPage = new MainPage(this.driver);
        result=mainPage.priceFilter();
        System.out.println(result);
    }

    @Then("User should see products in ascending order of prices")
    public void user_should_see_products_in_ascending_order_of_prices() {
        Assert.assertEquals(result,true);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
