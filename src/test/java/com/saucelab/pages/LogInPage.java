package com.saucelab.pages;

import com.saucelab.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;

public class LogInPage extends BaseClass {

    //public WebDriver driver;

    @FindBy(id = "user-name")
    WebElement txt_username;
    @FindBy(id = "password")
    WebElement txt_password;
    @FindBy(id = "login-button")
    WebElement loginButton;

    public LogInPage(WebDriver driver) {
        //this.driver=driver;
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void loginAsValidUser(String username, String password) {
        txt_username.sendKeys(username);
        txt_password.sendKeys(password);
        loginButton.click();
        //return new MainPage_PF(driver);
    }
}
