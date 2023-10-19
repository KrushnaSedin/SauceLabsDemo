package com.saucelab.pages;

import com.saucelab.base.BaseClass;
import com.saucelab.test.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainPage extends BaseClass {
    //List<WebElement> products = driver.findElements(By.cssSelector("div.inventory_item_price"));
    @FindBy(css = "div.inventory_item_price")
    List<WebElement> productsByPrice;
    @FindBy(css = "div.inventory_item_name")
    List<WebElement> productsByName;

    @FindBy(css = "span.fa-layers-counter")
    WebElement cartCount;

    @FindBy(xpath = "//body/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='inventory_container']/div[1]/div[2]/div[1]/div[1]/div[3]/button[1]")
    WebElement addToCartButtonforProduct1;

    @FindBy(css = "button.btn_primary ")
    List<WebElement> addToCartButtonList;

    @FindBy(css = "button.btn_secondary ")
    WebElement removeButton;

    @FindBy(css = "svg[role='img']")
    WebElement cartButton;

    @FindBy(css = "select.product_sort_container")
    WebElement dropdown;
    //private WebElement dropdown = driver.findElement(By.cssSelector("select.product_sort_container"));

    public Select setFilter() {
        return new Select(dropdown);
    }
    //Select filter = new Select(dropdown);

    public MainPage(WebDriver driver, TestContext testContext) {
        super(driver,testContext);
    }

    public Integer getNumberOfProducts() {
        return productsByPrice.size();
    }

    public boolean AreProductsFilteredByPricesLowToHi() {
        return filterForPrice(productsByPrice, dropdown, "lohi");
    }

    public boolean AreProductsFilteredByPricesHiToLow() {
        return filterForPrice(productsByPrice, dropdown, "hilo");
    }

    public boolean AreProductsSortedFromAtoZ() {
        return filterByName(productsByName, dropdown, "az");
    }

    public boolean AreProductsSortedFromZtoA() {
        return filterByName(productsByName, dropdown, "za");
    }

    public void addFirstItemToTheCart() {
        addToCartButtonforProduct1.click();
    }

    public String getCartCount() {
        return cartCount.getText();
    }

    public void addAllTheProductsToCart() {
        for (WebElement p : addToCartButtonList) {
            p.click();
        }
    }

    public boolean IsRemoveButtonDisplayed() {
        return removeButton.isDisplayed();
    }

    public void removeItemFromCart() {
        removeButton.click();
    }

    public boolean IsTheCartEmpty() {
        return addToCartButtonforProduct1.isDisplayed();
    }

    public CartPage clickOnCartButton() {
        cartButton.click();
        return new CartPage(driver,testContext);
    }
}