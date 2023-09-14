package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {
    public WebDriver driver;

    private By txt_username= By.id("user-name");
    private By txt_password= By.id("password");
    private By loginButton= By.id("login-button");
    public LogInPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void loginValidUser(String username, String password){
        driver.findElement(txt_username).sendKeys(username);
        driver.findElement(txt_password).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
