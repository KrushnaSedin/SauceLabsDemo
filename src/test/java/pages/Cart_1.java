package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart_1 extends MainPage_PF{
    MainPage_PF main=new MainPage_PF(driver);

    public Cart_1(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="a.btn_action")
    WebElement checkOutButton;

    @FindBy(xpath = "//a[text()='CHECKOUT']")
    WebElement continueShoppingBtn;

    @FindBy(css="a.checkout_button")
    WebElement checkOutBtn;

    public boolean checkOutBtnDisplayed()
    {
       return checkOutButton.isDisplayed();
    }
    public void clickOnContinueShoppingButton()
    {
        continueShoppingBtn.click();
    }
    public void clickOnCheckout()
    {
        checkOutButton.click();
    }
}
