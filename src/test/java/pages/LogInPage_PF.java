package pages;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage_PF {

    public WebDriver driver;

    @FindBy(id="user-name")
    WebElement txt_username;
    @FindBy(id="password")
    WebElement txt_password;
    @FindBy(id="login-button")
    WebElement loginButton;
    public LogInPage_PF(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void loginValidUser(String username, String password){
        txt_username.sendKeys(username);
        txt_password.sendKeys(password);
        loginButton.click();
        //return new MainPage_PF(driver);
    }
}
