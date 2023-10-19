package com.saucelab.steps.addToCart;

import io.cucumber.java.en.*;
import org.testng.Assert;
import com.saucelab.pages.CartPage;
import com.saucelab.pages.CheckOutPage;
import com.saucelab.pages.MainPage;
import com.saucelab.steps.BaseStep;
import com.saucelab.test.TestContext;


public class AddToCartSteps extends BaseStep {
    public AddToCartSteps(TestContext testContext) {
        super(testContext);
    }

    @And("he added single product to the cart")
    public void he_added_single_product_to_the_cart() {
        MainPage mainPage= (MainPage) testContext.lastPage;
        mainPage.addFirstItemToTheCart();
    }
    @Then("Item should get added to the cart")
    public void item_should_get_added_to_the_cart() {
        MainPage mainPage= (MainPage) testContext.lastPage;
        Assert.assertEquals(mainPage.getCartCount(),"1");
    }

    @When("add multiple product to the cart")
    public void add_multiple_product_to_the_cart() {
        MainPage mainPage= (MainPage) testContext.lastPage;
        mainPage.addAllTheProductsToCart();
    }
    @Then("All items should get added to the cart")
    public void all_items_should_get_added_to_the_cart() {
        MainPage mainPage= (MainPage) testContext.lastPage;
        Assert.assertEquals(mainPage.getCartCount(),"6");
    }

    @Then("he should see option to remove the added item")
    public void removeButtonShouldAppear() {
        MainPage mainPage= (MainPage) testContext.lastPage;
        Assert.assertEquals(mainPage.IsRemoveButtonDisplayed(),true);
    }

    @And("then remove product from the cart")
    public void then_remove_product_from_the_cart() {
        MainPage mainPage= (MainPage) testContext.lastPage;
        mainPage.removeItemFromCart();
    }
    @Then("Cart should be empty")
    public void cart_should_be_empty() {
        MainPage mainPage= (MainPage) testContext.lastPage;
        Assert.assertEquals(mainPage.IsTheCartEmpty(),true);
    }

    @When("he go to the cart")
    public void he_go_to_the_cart() {
        MainPage mainPage= (MainPage) testContext.lastPage;
        mainPage.clickOnCartButton();
    }
    @Then("added prdocut should be there in the cart")
    public void added_prdocut_should_be_there_in_the_cart() {
        CartPage cartPage= (CartPage) testContext.lastPage;
        Assert.assertEquals(cartPage.checkOutBtnDisplayed(),true);
    }

    @Then("he opt to go back to shopping")
    public void he_opt_to_go_back_to_shopping() {
        CartPage cartPage= (CartPage) testContext.lastPage;
        cartPage.clickOnContinueShoppingButton();
    }
    @Then("user should be able to go back for shopping")
    public void user_should_be_able_to_go_back_for_shopping() {
        Assert.assertEquals(this.testContext.driver.getTitle(), "Swag Labs");
    }

    @Then("he opt to for Checkout option")
    public void he_opt_to_for_checkout_option() {
        CartPage cartPage= (CartPage) testContext.lastPage;
       cartPage.clickOnCheckout();
    }
    @Then("user should navigate to Checkout screen")
    public void user_should_navigate_to_checkout_screen() {
        CheckOutPage checkOut= (CheckOutPage) testContext.lastPage;
        Assert.assertEquals(checkOut.storeSubHeadingText(),"Checkout: Your Information");
    }
}
