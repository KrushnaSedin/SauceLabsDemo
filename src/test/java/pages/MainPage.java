package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class MainPage extends LogInPage {
    List<WebElement> products = driver.findElements(By.cssSelector("div.inventory_item_price"));
    List<Double> beforeFilter = new ArrayList<>();


    private WebElement dropdown = driver.findElement(By.cssSelector("select.product_sort_container"));
    Select filter = new Select(dropdown);

    public MainPage(WebDriver driver) {
        super(driver);
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
        filter.selectByValue("lohi");

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
        filter.selectByValue("hilo");

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
        filter.selectByValue("az");
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
        filter.selectByValue("za");
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
}