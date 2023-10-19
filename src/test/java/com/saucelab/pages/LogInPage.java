package com.saucelab.pages;

import com.saucelab.base.BaseClass;
import com.saucelab.test.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class LogInPage extends BaseClass {

    //public WebDriver driver;

    @FindBy(id = "user-name")
    WebElement txt_username;
    @FindBy(id = "password")
    WebElement txt_password;
    @FindBy(id = "login-button")
    WebElement loginButton;

    public LogInPage(WebDriver driver, TestContext testContext) {
        //this.driver=driver;
        super(driver,testContext);
    }

    public <T> T tryLogin(String username, String password, BiFunction<WebDriver,TestContext,T> factory) {
        txt_username.sendKeys(username);
        txt_password.sendKeys(password);
        loginButton.click();
        return factory.apply(this.driver,testContext);
    }
}
