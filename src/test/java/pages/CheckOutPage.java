package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends Cart_1 {

    Cart_1 cart=new Cart_1(driver);
    @FindBy(css="div.subheader")
    WebElement subHeading;

    public CheckOutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String storeSubHeadingText()
    {
        return subHeading.getText();
    }
}
