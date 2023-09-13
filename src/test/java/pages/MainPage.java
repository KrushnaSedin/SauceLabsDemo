package pages;

import com.github.dockerjava.api.model.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainPage {

    public WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver=driver;
    }

    List products= driver.findElements(By.cssSelector("div.inventory_list div.inventory_item"));
    private WebElement dropdown= driver.findElement(By.cssSelector("select.product_sort_container"));
    Select filter= new Select(dropdown);

    public void selectFilter1(){
        filter.selectByValue("za");
    }

    public Integer getNumberOfProducts(){
        return products.size();
    }




}
