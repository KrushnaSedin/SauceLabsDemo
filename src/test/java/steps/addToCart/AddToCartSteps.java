package steps.addToCart;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.Cart_1;
import pages.CheckOutPage;
import pages.MainPage_PF;
import steps.BaseStep;
import test.TestContext;


public class AddToCartSteps extends BaseStep {

    MainPage_PF mainPage;
    Cart_1 cartPage;

    CheckOutPage checkOut;
    public AddToCartSteps(TestContext testContext) {
        super(testContext);
    }

    @And("he added single product to the cart")
    public void he_added_single_product_to_the_cart() {
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

    @And("then remove product from the cart")
    public void then_remove_product_from_the_cart() {
        mainPage=new MainPage_PF(this.testContext.driver);
        mainPage.removeItemFromCart();
    }
    @Then("Cart should be empty")
    public void cart_should_be_empty() {
        Assert.assertEquals(mainPage.toCheckEmptyCart(),false);
    }

    @When("he go to the cart")
    public void he_go_to_the_cart() {
        mainPage=new MainPage_PF(this.testContext.driver);
        mainPage.clickOnCartButton();
    }
    @Then("added prdocut should be there in the cart")
    public void added_prdocut_should_be_there_in_the_cart() {
        cartPage=new Cart_1(this.testContext.driver);
        Assert.assertEquals(cartPage.checkOutBtnDisplayed(),true);
    }

    @Then("he opt to go back to shopping")
    public void he_opt_to_go_back_to_shopping() {
        cartPage=new Cart_1(this.testContext.driver);
        cartPage.clickOnContinueShoppingButton();
    }
    @Then("user should be able to go back for shopping")
    public void user_should_be_able_to_go_back_for_shopping() {
        Assert.assertEquals(this.testContext.driver.getTitle(), "Swag Labs");
    }

    @Then("he opt to for Checkout option")
    public void he_opt_to_for_checkout_option() {
       cartPage=new Cart_1(this.testContext.driver);
       cartPage.clickOnCheckout();
    }
    @Then("user should navigate to Checkout screen")
    public void user_should_navigate_to_checkout_screen() {
        checkOut=new CheckOutPage(this.testContext.driver);
        Assert.assertEquals(checkOut.storeSubHeadingText(),"Checkout: Your Information");
    }


}
