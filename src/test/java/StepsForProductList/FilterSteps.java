package StepsForProductList;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import pages.LogInPage;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class FilterSteps {
    public WebDriver driver = null;
    LogInPage login;
    MainPage mainPage;
    boolean result;

    @Before
    public void setUp() {
        //WebDriverManager.chromedriver().setup();
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
        result=mainPage.priceFilterLowToHi();
        System.out.println(result);
    }

    @Then("User should see products in ascending order of prices")
    public void user_should_see_products_in_ascending_order_of_prices() {
        Assert.assertEquals(result,true);
    }

    @When("User filtered out the products from high to low prices")
    public void user_filtered_out_the_products_from_high_to_low_prices() {
        mainPage = new MainPage(this.driver);
        result=mainPage.priceFilterHiToLow();
    }
    @Then("User should see products in descending order of prices")
    public void user_should_see_products_in_descending_order_of_prices() {
        Assert.assertEquals(result,true);
    }
    @When("User filtered out the products alphabetically")
    public void user_filtered_out_the_products_alphabetically() {
        mainPage = new MainPage(this.driver);
        result=mainPage.sortAtoZ();
    }
    @Then("User should see products in alphabetical order of names")
    public void user_should_see_products_in_alphabetical_order_of_names() {
        Assert.assertEquals(result,true);
    }
    @When("User filtered out the products reverse alphabetically")
    public void user_filtered_out_the_products_reverse_alphabetically() {
        mainPage = new MainPage(this.driver);
        result=mainPage.sortZtoA();
    }
    @Then("User should see products in reverse alphabetical order of names")
    public void user_should_see_products_in_reverse_alphabetical_order_of_names() {
        Assert.assertEquals(result,true);
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
