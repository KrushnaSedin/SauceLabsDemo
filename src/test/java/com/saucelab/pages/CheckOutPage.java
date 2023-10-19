package com.saucelab.pages;

import com.saucelab.test.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CheckOutPage extends CartPage {

    @FindBy(css = "div.subheader")
    WebElement subHeading;

    @FindBy(css = "div.bm-burger-button")
    WebElement menuBar;

    @FindBy(css = "a.bm-item")
    List<WebElement> menuItems;

    @FindBy(id = "first-name")
    WebElement firstNameField;
    @FindBy(id = "last-name")
    WebElement lastNameField;
    @FindBy(id = "postal-code")
    WebElement postalCodeField;
    @FindBy(css = "input[type=submit]")
    WebElement continueBtn;

    public CheckOutPage(WebDriver driver, TestContext testContext) {
        super(driver,testContext);
    }

    public String storeSubHeadingText() {
        return subHeading.getText();
    }

    public void ClickOnMenuBar() {
        menuBar.click();
    }

    public List storeMenuItemList() {
        List<String> ItemList = new ArrayList<>();
        for (WebElement p : menuItems) {
            ItemList.add(p.getText());
        }
        return ItemList;
    }

    public void enterFirstname(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterLastname(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode) {
        postalCodeField.sendKeys(postalCode);
    }

    public PaymentPage clickOnContinue() {
        continueBtn.click();
        return new PaymentPage(driver,testContext);
    }

}
