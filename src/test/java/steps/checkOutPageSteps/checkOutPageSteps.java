package steps.checkOutPageSteps;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.CheckOutPage;
import pages.PaymentPage;
import steps.BaseStep;
import test.TestContext;

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
        checkout= new CheckOutPage(this.testContext.driver);
        checkout.ClickOnMenuBar();
        System.out.println(checkout.storeMenuItemList());
    }
    @Then("under menu bar there should be list of options")
    public void under_menu_bar_there_should_be_list_of_options() {
        checkout= new CheckOutPage(this.testContext.driver);
        String[] items= {"All Items", "About", "Logout", "Reset App State"};
        List<String> exp= new ArrayList<String>(Arrays.asList(items));
        Assert.assertEquals(checkout.storeMenuItemList(),exp);
    }
    @When("He provide valid information")
    public void he_provide_valid_information() {
        checkout= new CheckOutPage(this.testContext.driver);
        checkout.enterFirstname("Krushna");
        checkout.enterLastname("Thakare");
        checkout.enterPostalCode("425001");
    }
    @When("Select Continue option")
    public void select_continue_option() {
        checkout= new CheckOutPage(this.testContext.driver);
        checkout.clickOnContinue();
    }
    @Then("User should see valid payment amount")
    public void user_should_see_valid_payment_amount() {
        paymentPage=new PaymentPage(this.testContext.driver);
        Assert.assertEquals(paymentPage.getPaymentText(),"FREE PONY EXPRESS DELIVERY!");
    }
}
