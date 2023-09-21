package steps.checkOutPageSteps;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.CheckOutPage;
import steps.BaseStep;
import test.TestContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class checkOutPageSteps extends BaseStep {

    CheckOutPage checkout;
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
}
