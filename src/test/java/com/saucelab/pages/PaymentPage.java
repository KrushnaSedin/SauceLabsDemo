package com.saucelab.pages;

import com.saucelab.test.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends CheckOutPage {


    @FindBy(xpath = "//div[text()='FREE PONY EXPRESS DELIVERY!']")
    WebElement paymentText;
    @FindBy(xpath = "//a[text()='FINISH']")
    WebElement finishBtn;
    @FindBy(css = "h2.complete-header")
    WebElement thankYouMessage;

    public PaymentPage(WebDriver driver, TestContext testContext) {
        super(driver,testContext);
    }

    public String getPaymentText() {
        return paymentText.getText();
    }

    public void clickOnFinish() {
        finishBtn.click();
    }

    public String getThankYouMessage() {
        return thankYouMessage.getText();
    }
}
