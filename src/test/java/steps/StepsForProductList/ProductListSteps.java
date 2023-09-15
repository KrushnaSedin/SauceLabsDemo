package steps.StepsForProductList;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.LogInPage;
import pages.MainPage;
import steps.BaseStep;
import test.TestContext;

import java.util.Optional;

public class ProductListSteps extends BaseStep {
    LogInPage login;
    MainPage mainPage;

    public ProductListSteps(TestContext testContext) {
        super(testContext);
    }
    @Then("user should see list of {int} products")
    public void user_should_see_list_of_products(Integer int1) {
        mainPage=new MainPage(this.testContext.driver);
        Assert.assertEquals(Optional.ofNullable(mainPage.getNumberOfProducts()),6);
    }
    @After
    public void tearDown(){
        this.testContext.driver.quit();
    }
}
