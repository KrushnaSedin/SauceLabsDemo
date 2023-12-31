package com.saucelab.steps.checkOutPageSteps;

import io.cucumber.java.en.*;
import org.testng.Assert;
import com.saucelab.pages.CheckOutPage;
import com.saucelab.pages.PaymentPage;
import com.saucelab.steps.BaseStep;
import com.saucelab.test.TestContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class checkOutPageSteps extends BaseStep {

    CheckOutPage checkout;
    PaymentPage paymentPage;
    public checkOutPageSteps(TestContext testContext)
    {super(testContext);}
    @When("he selects menu bar")
    public void he_selects_menu_bar() {
        CheckOutPage checkout= (CheckOutPage) testContext.lastPage;
        checkout.ClickOnMenuBar();
        System.out.println(checkout.storeMenuItemList());
    }
    @Then("under menu bar there should be list of options")
    public void under_menu_bar_there_should_be_list_of_options() {
        CheckOutPage checkout= (CheckOutPage) testContext.lastPage;
        String[] items= {"All Items", "About", "Logout", "Reset App State"};
        List<String> exp= new ArrayList<String>(Arrays.asList(items));
        Assert.assertEquals(checkout.storeMenuItemList(),exp);
    }
    @When("He provide valid information")
    public void he_provide_valid_information() {
        CheckOutPage checkout= (CheckOutPage) testContext.lastPage;
        checkout.enterFirstname("Krushna");
        checkout.enterLastname("Thakare");
        checkout.enterPostalCode("425001");
    }
    @When("Select Continue option")
    public void select_continue_option() {
        CheckOutPage checkout= (CheckOutPage) testContext.lastPage;
        checkout.clickOnContinue();
    }
    @Then("User should see valid payment amount")
    public void user_should_see_valid_payment_amount() {
        PaymentPage paymentPage= (PaymentPage) testContext.lastPage;
        Assert.assertEquals(paymentPage.getPaymentText(),"FREE PONY EXPRESS DELIVERY!");
    }
    @When("User proceed to place order")
    public void user_proceed_to_place_order() {
        PaymentPage paymentPage= (PaymentPage) testContext.lastPage;
        paymentPage.clickOnFinish();
    }
    @Then("User should be able to successfully place order")
    public void user_should_be_able_to_successfully_place_order() {
        PaymentPage paymentPage= (PaymentPage) testContext.lastPage;
        Assert.assertEquals(paymentPage.getThankYouMessage(),"THANK YOU FOR YOUR ORDER");
    }

}
