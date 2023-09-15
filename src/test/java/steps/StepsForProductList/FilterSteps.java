package steps.StepsForProductList;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.MainPage;
import pages.MainPage_PF;
import steps.BaseStep;
import test.TestContext;

public class FilterSteps extends BaseStep {


    MainPage_PF mainPage;
    boolean result;

    public FilterSteps(TestContext testContext) {
        super(testContext);
    }

    @And("User filtered out the products from low to high prices")
    public void user_filtered_out_the_products_from_low_to_high_prices() throws InterruptedException {
        mainPage = new MainPage_PF(this.testContext.driver);
        result=mainPage.priceFilterLowToHi();
        System.out.println(result);
    }

    @Then("User should see products in ascending order of prices")
    public void user_should_see_products_in_ascending_order_of_prices() {
        Assert.assertEquals(result,true);
    }

    @When("User filtered out the products from high to low prices")
    public void user_filtered_out_the_products_from_high_to_low_prices() {
        mainPage = new MainPage_PF(this.testContext.driver);
        result=mainPage.priceFilterHiToLow();
    }
    @Then("User should see products in descending order of prices")
    public void user_should_see_products_in_descending_order_of_prices() {
        Assert.assertEquals(result,true);
    }
    @When("User filtered out the products alphabetically")
    public void user_filtered_out_the_products_alphabetically() {
        mainPage = new MainPage_PF(this.testContext.driver);
        result=mainPage.sortAtoZ();
    }
    @Then("User should see products in alphabetical order of names")
    public void user_should_see_products_in_alphabetical_order_of_names() {
        Assert.assertEquals(result,true);
    }
    @When("User filtered out the products reverse alphabetically")
    public void user_filtered_out_the_products_reverse_alphabetically() {
        mainPage = new MainPage_PF(this.testContext.driver);
        result=mainPage.sortZtoA();
    }
    @Then("User should see products in reverse alphabetical order of names")
    public void user_should_see_products_in_reverse_alphabetical_order_of_names() {
        Assert.assertEquals(result,true);
    }
    @After
    public void tearDown() {
        this.testContext.driver.quit();
    }
}
