package steps.addToCart;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.MainPage_PF;
import steps.BaseStep;
import test.TestContext;


public class AddToCartSteps extends BaseStep {

    MainPage_PF mainPage;
    public AddToCartSteps(TestContext testContext) {
        super(testContext);
    }

    @And("add single product to the cart")
    public void add_single_product_to_the_cart() {
        mainPage=new MainPage_PF(this.testContext.driver);
        mainPage.addItem1TotheCart();
    }
    @Then("Item should get added to the cart")
    public void item_should_get_added_to_the_cart() {
        Assert.assertEquals(mainPage.getCartCount(),"1");
    }

    @When("add multiple product to the cart")
    public void add_multiple_product_to_the_cart() {
        mainPage=new MainPage_PF(this.testContext.driver);
        mainPage.addAllTheProductsToCart();
    }
    @Then("All items should get added to the cart")
    public void all_items_should_get_added_to_the_cart() {
        Assert.assertEquals(mainPage.getCartCount(),"6");
    }

    @Then("Remove button should appear")
    public void removeButtonShouldAppear() {
        Assert.assertEquals(mainPage.removeButtonDisplayed(),true);
    }
}
