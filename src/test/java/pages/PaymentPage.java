package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends CheckOutPage {

    CheckOutPage checkout =new CheckOutPage(driver);

    @FindBy(xpath="//div[text()='FREE PONY EXPRESS DELIVERY!']")
    WebElement paymentText;

    public PaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    public String getPaymentText()
    {
        return paymentText.getText();
    }
}
