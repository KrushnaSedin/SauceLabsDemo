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
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class ProductListSteps {
    WebDriver driver = null;
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
    }

    @Given("user is on saucedemo loginpage")
    public void user_is_on_saucedemo_loginpage() {
        driver.get("https://www.saucedemo.com/v1/");
    }
    @When("^user login on saucedemo with valid (.*) and (.*)$")
    public void user_login_on_saucedemo_with_valid_standard_user_and_secret_sauce(String username, String password) {
        login = new LogInPage(driver);
        login.loginValidUser(username, password);
    }
    @Then("user should see list of {int} products")
    public void user_should_see_list_of_products(Integer int1) {
        mainPage=new MainPage(driver);
        Assert.assertEquals(mainPage.getNumberOfProducts(),"6");
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
