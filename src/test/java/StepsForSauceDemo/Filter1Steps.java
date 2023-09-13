package StepsForSauceDemo;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.cucumber.java.it.Ma;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LogInPage;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class Filter1Steps {
    public WebDriver driver;
    LogInPage login;
    MainPage mainPage;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/v1/");
    }
    @Given("User is on login portal")
    public void user_is_on_login_portal() {
        System.out.println("Done");
    }
    @When("^User login with valid credentials (.*) and (.*)")
    public void user_login_with_valid_credentials_standard_user_and_secret_sauce(String username,String password) {
        login = new LogInPage(driver);
        login.loginValidUser(username, password);
    }
    @And("User filtered out the products from Z toA")
    public void user_filtered_out_the_products_from_z_to_a() {
      mainPage=new MainPage(this.driver);
      mainPage.selectFilter1();
    }
    @Then("User should see {int} st product Tshirt Red")
    public void user_should_see_st_product_tshirt_red(Integer int1) {
        System.out.println("Done");
    }
}
