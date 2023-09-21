package pages;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainPage_PF extends LogInPage_PF {
    //List<WebElement> products = driver.findElements(By.cssSelector("div.inventory_item_price"));
    @FindBy(css="div.inventory_item_price")
    List<WebElement> products;

    @FindBy(css="span.fa-layers-counter")
    WebElement cartCount;

    @FindBy(xpath="//body/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='inventory_container']/div[1]/div[2]/div[1]/div[1]/div[3]/button[1]")
    WebElement addToCartButtonforProduct1;

    @FindBy(css="button.btn_primary ")
    List<WebElement> addToCartButtonList;

    @FindBy(css="button.btn_secondary ")
    WebElement removeButton;

    @FindBy(css="svg[role='img']")
    WebElement cartButton;

    @FindBy(css="select.product_sort_container")
    WebElement dropdown;
    //private WebElement dropdown = driver.findElement(By.cssSelector("select.product_sort_container"));

    public Select setFilter()
    {
        return new Select(dropdown);
    }
    //Select filter = new Select(dropdown);

    public MainPage_PF(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public Integer getNumberOfProducts() {
        return products.size();
    }

    public boolean priceFilterLowToHi() {
        boolean flag;
        //Store prices before filter
        List<WebElement> beforeFilterprices = driver.findElements(By.cssSelector("div.inventory_item_price"));
        List<Double> beforeFilter = new ArrayList<>();

        for (WebElement p1 : beforeFilterprices) {
            beforeFilter.add(Double.valueOf(p1.getText().replace("$", "")));
        }
        Collections.sort(beforeFilter);
        //Select Low to Hi filter
        setFilter().selectByValue("lohi");

        //Store prices after filter
        List<WebElement> afterFilterprices = driver.findElements(By.cssSelector("div.inventory_item_price"));
        List<Double> afterFilter = new ArrayList<>();
        for (WebElement p2 : afterFilterprices) {
            afterFilter.add(Double.valueOf(p2.getText().replace("$", "")));
        }
        //Printing prices before and after
        System.out.println(beforeFilter);
        System.out.println(afterFilter);

        if (beforeFilter.equals(afterFilter)) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public boolean priceFilterHiToLow() {
        boolean flag;
        //Store prices before filter
        List<WebElement> beforeFilterprices = driver.findElements(By.cssSelector("div.inventory_item_price"));
        List<Double> beforeFilter = new ArrayList<>();

        for (WebElement p1 : beforeFilterprices) {
            beforeFilter.add(Double.valueOf(p1.getText().replace("$", "")));
        }
        Collections.sort(beforeFilter, Collections.reverseOrder());
        //Select Hi to Low filter
        setFilter().selectByValue("hilo");

        //Store prices after filter
        List<WebElement> afterFilterprices = driver.findElements(By.cssSelector("div.inventory_item_price"));
        List<Double> afterFilter = new ArrayList<>();
        for (WebElement p2 : afterFilterprices) {
            afterFilter.add(Double.valueOf(p2.getText().replace("$", "")));
        }
        //Printing prices before and after
        System.out.println(beforeFilter);
        System.out.println(afterFilter);

        if (beforeFilter.equals(afterFilter)) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public boolean sortAtoZ() {
        boolean flag;
        //Store product names before filter
        List<WebElement> productListBefore = driver.findElements(By.cssSelector("div.inventory_item_name"));
        List<String> namesBeforeFilter = new ArrayList<>();

        //Storing names
        for (WebElement p : productListBefore) {
            namesBeforeFilter.add(p.getText());
        }
        Collections.sort(namesBeforeFilter);
        //Apply filter A to Z
        setFilter().selectByValue("az");
        //Store product names after filter
        List<WebElement> productListAfter = driver.findElements(By.cssSelector("div.inventory_item_name"));
        List<String> namesAfterFilter = new ArrayList<>();
        for (WebElement p : productListAfter) {
            namesAfterFilter.add(p.getText());
        }
        System.out.println(namesBeforeFilter);
        System.out.println(namesAfterFilter);
        //Check condition
        if (namesBeforeFilter.equals(namesAfterFilter)) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }
    public boolean sortZtoA() {
        boolean flag;
        //Store product names before filter
        List<WebElement> productListBefore = driver.findElements(By.cssSelector("div.inventory_item_name"));
        List<String> namesBeforeFilter = new ArrayList<>();

        //Storing names
        for (WebElement p : productListBefore) {
            namesBeforeFilter.add(p.getText());
        }
        Collections.sort(namesBeforeFilter,Collections.reverseOrder());
        //Apply filter Z to A
        setFilter().selectByValue("za");
        //Store product names after filter
        List<WebElement> productListAfter = driver.findElements(By.cssSelector("div.inventory_item_name"));
        List<String> namesAfterFilter = new ArrayList<>();
        for (WebElement p : productListAfter) {
            namesAfterFilter.add(p.getText());
        }
        System.out.println(namesBeforeFilter);
        System.out.println(namesAfterFilter);
        //Check condition
        if (namesBeforeFilter.equals(namesAfterFilter)) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }
    public void addItem1TotheCart()
    {
        addToCartButtonforProduct1.click();
    }
    public String getCartCount()
    {
        return cartCount.getText();
    }

    public void addAllTheProductsToCart(){
        for(WebElement p:addToCartButtonList)
        {
            p.click();
        }
    }

    public boolean removeButtonDisplayed()
    {
        return removeButton.isDisplayed();
    }
    public void removeItemFromCart()
    {
        removeButton.click();
    }
    public boolean toCheckEmptyCart()
    {
        return cartCount.isDisplayed();
    }
    public void clickOnCartButton(){
        cartButton.click();
    }
}