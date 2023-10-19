package com.saucelab.pages;

import com.saucelab.base.BaseClass;
import com.saucelab.test.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BaseClass {
    //MainPage_PF main=new MainPage_PF(driver);

    public CartPage(WebDriver driver, TestContext testContext) {
        super(driver,testContext);

    }

    @FindBy(css = "a.btn_action")
    WebElement checkOutButton;

    @FindBy(xpath = "//a[text()='CHECKOUT']")
    WebElement continueShoppingBtn;

    @FindBy(css = "a.checkout_button")
    WebElement checkOutBtn;

    public boolean checkOutBtnDisplayed() {
        return checkOutButton.isDisplayed();
    }

    public MainPage clickOnContinueShoppingButton() {
        continueShoppingBtn.click();
        return new MainPage(driver,testContext);
    }

    public CheckOutPage clickOnCheckout() {
        checkOutButton.click();
        return new CheckOutPage(driver,testContext);
    }
}
